# Xtra Plus Android battery work

Based on upstream `0ab697de04799365f590f91e2dfbefc092c3ad5a` (2.60.10).

## Changes and evidence

| Path | Source finding | Change |
| --- | --- | --- |
| Proxy/video-swap playback | Replacing `secondaryPlayer` did not release the previous player; players were allocated before suspending playlist lookups | Release replaced/failed players, cancel superseded requests, allocate only after playlist lookup |
| Background playback | Audio rendition was opt-in; Exo video disabling depended on finding a separate audio rendition | Prefer audio rendition by default, disable hidden Exo video even without one, restore foreground quality; existing explicit preferences are respected |
| Legacy MediaPlayer | Wi-Fi performance lock was acquired for the whole service lifetime, including paused idle retention | Acquire while playing; release on pause, completion, error and teardown |
| Service destruction | Sleep/stop/save-position timers and audio processing effects could retain dead service resources | Cancel timers and release effects and artwork requests |
| Player artwork | Metadata and notification updates independently canceled/restarted the same pending fetch | Share in-flight artwork request; discard outdated results |
| Chat images | Untracked Coil/Glide targets could finish after recycling and start animation on stale rows | Per-binding ownership, cancellation, stale-result checks, lifecycle/visibility-controlled animation |
| Chat drawing | Drawable callback supplied absolute uptime to `postDelayed` | Convert uptime to relative delay; remove pending callbacks when hidden |
| 7TV name paints | Image names allocated a bitmap/Canvas/Paint per animated redraw; gradients were rebuilt repeatedly | Reuse mask and drawing objects per span, cache stable masks/gradients, preserve the caller's Paint |
| Chat transport | Frame headers read directly from TLS; a separate character reader could read ahead into frame bytes | One buffered byte stream for handshake and frames; reject truncated frames; release native compression resources |

Android documents the battery cost of Wi-Fi performance locks: [WifiManager](https://developer.android.com/reference/android/net/wifi/WifiManager). Restricting lock ownership is a source-level fix, not a measured power result.

## Validation limits

Compilation, unit tests, lint, emulator navigation/playback checks, and physical-device power measurement are different gates. See the release notes for checks actually completed for a build. No percentage battery saving is claimed without a controlled physical-device comparison. An emulator cannot establish real battery savings.

The optimized APK currently uses the upstream test signing key and a separate package `com.github.kristijan1001.xtra`. It installs alongside upstream Xtra. This is a test build, not a production signing setup. Do not put account passwords or access tokens in source, scripts, logs or release notes.

The legacy MediaPlayer backend cannot reliably stop decoding video from a combined-only source; ExoPlayer is the better background-audio path in that case. Existing explicit preference values take precedence over changed defaults.

## Repeatable physical-device comparison

1. Use the same device, stream/VOD segment, quality, brightness, refresh rate, volume, Wi-Fi connection and charge range. Disable charging during measurements. Let temperature settle between runs.
2. Alternate upstream and Plus runs: video with chat, video with hidden chat, screen-off audio, paused app, then closed player. Include a busy animated-emote channel and proxy retry transitions.
3. Capture at least 15 minutes per state. Record Android battery usage or a system trace, CPU time, network bytes, frame rendering and wake locks. Repeat each state at least twice.
4. Check video returns after foregrounding, background audio stays audible, quality/seek/resume work, and chat animations stop when hidden and resume on return.
5. Use `scripts/Capture-AndroidProfile.ps1` for before/after diagnostic snapshots. It does not reset device-wide battery counters. Cumulative snapshots must be compared as deltas and are not a standalone battery benchmark.

## Build

Requires JDK 21, Android SDK 37 and the repository's Gradle wrapper:

```powershell
$env:JAVA_HOME = 'path-to-jdk-21'
$env:ANDROID_HOME = 'path-to-android-sdk'
.\gradlew.bat testReleaseUnitTest lintRelease assembleRelease --console=plain
```

On Windows, very long temporary paths can break Java's local Unix socket creation. Set `JAVA_TOOL_OPTIONS=-Djdk.net.unixdomain.tmpdir=<short-existing-local-directory>` for the build if that specific error occurs.
