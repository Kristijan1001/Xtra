# Windows 11 port: Android parity reference

Inspected 2026-11-03. This is a source inventory and implementation proposal, not a claim of Windows implementation or tested runtime parity. The Android APK is the first deliverable. No Windows application has been implemented by this inventory work.

## Acceptance rule

Every screen, action, state, setting, and data operation below needs a working Windows implementation and verification before claiming full parity. A visible button, fixture, mocked response, or passing source test is insufficient for account, playback, chat, download, or native integration parity. Disabled controls must state their actual limitation. Android device-specific controls need an explicitly documented Windows equivalent.

Reference sources: `app/src/main/res/navigation/nav_graph.xml`, `settings_nav_graph.xml`, `app/src/main/res/xml/*_preferences.xml`, `app/src/main/res/menu/*.xml`, and the corresponding `ui` fragments, dialogs, view models and repositories. [WINDOWS_SETTINGS_INVENTORY.md](WINDOWS_SETTINGS_INVENTORY.md) records each XML preference with its title, type, default, and choices.

## Screens and navigation

All Windows entries are **unimplemented** as of this document's creation.

| Android area / source | Required desktop behavior | Windows status |
| --- | --- | --- |
| MainActivity / MainViewModel | Persistent main navigation, configurable tab visibility/order, start-on-followed, paging/navigation history, refresh and scroll-to-top, playing media retained while browsing, error/retry/empty/loading states | Unimplemented |
| TopStreamsFragment | Live directory, stream cards or compact rows, language/tag filters, sort, pagination, channel/game navigation, context actions | Unimplemented |
| GamesFragment / GamesSortDialog | Category directory, tag search, sort and pagination, follow state, category navigation | Unimplemented |
| FollowPagerFragment / FollowMediaFragment | Configurable paged or combined followed content | Unimplemented |
| FollowedStreamsFragment | Followed live streams, refresh/filter/sort, local and account follow sources as supported by Android | Unimplemented |
| FollowedVideosFragment | Followed-channel VOD list, types/sorting/filtering/pagination, download/bookmark/share actions | Unimplemented |
| FollowedChannelsFragment / sort dialog | Followed channels including offline entries, local ordering and sort persistence, remote/local follow mutations | Unimplemented |
| FollowedGamesFragment | Followed categories, local follows and ordering, open category or unfollow | Unimplemented |
| GamePagerFragment / GameMediaFragment | Category header/follow state and configurable tabs or combined content, inherited language/tag filters | Unimplemented |
| GameStreamsFragment | Live streams for category, sort/filter/pagination | Unimplemented |
| GameVideosFragment | Category videos, video type/period/language/sort filters | Unimplemented |
| GameClipsFragment | Category clips with period/language/sort and pagination | Unimplemented |
| ChannelPagerFragment | Channel header, follow/notifications/account state, configurable tab order, direct live playback and stream identifier handling | Unimplemented |
| ChannelVideosFragment | Channel videos, types/sort/period, playback/download/bookmark/share | Unimplemented |
| ChannelClipsFragment | Channel clips, period/sort, playback/download/share | Unimplemented |
| ChannelAboutFragment / ChannelPanelAdapter | Channel metadata, schedule/about text and panels, links, team references | Unimplemented |
| ChannelSuggestionsFragment | Related/recommended channels, loading/empty/error handling | Unimplemented |
| TeamFragment / TeamMembersAdapter | Team metadata/member list, channel navigation, share | Unimplemented |
| SearchPagerFragment | Configurable search tabs, recent queries stored/deleted according to preference, search-user action, state preservation | Unimplemented |
| ChannelSearchFragment | Search channel names and direct user lookup | Unimplemented |
| StreamSearchFragment | Search live streams, filters/pagination | Unimplemented |
| GameSearchFragment | Search categories, follow/navigation actions | Unimplemented |
| VideoSearchFragment | Search VODs, playback/context actions/pagination | Unimplemented |
| SavedPagerFragment / SavedMediaFragment | Configurable saved tabs or combined content | Unimplemented |
| BookmarksFragment / sort dialog | VOD bookmarks, resume position/time-left display, sort, refresh, download, ignore-user and delete | Unimplemented |
| DownloadsFragment | Live/VOD/clip/local file list, progress, stop/resume, play, convert VOD to file, move/export/share, change chat file, delete, import files/folders | Unimplemented |
| FiltersFragment | Saved filters CRUD and opening matching directories | Unimplemented |
| LoginActivity | Service-owned authentication, token validation/scopes and sign-out; no passwords entered or retained by tooling | Unimplemented |
| SettingsActivity | Root and settings search, all 14 XML preference groups, proxies/video-swap editors, drag tab order, language download management, backup/restore, update check | Unimplemented |

## Player and chat behavior

| Feature / Android source | Required Windows behavior | Status |
| --- | --- | --- |
| PlayerFragment / PlayerViewModel | Stream, VOD, clip and offline entry types, correct metadata, resume state, retained player while browsing, maximize/minimize/close, responsive chat placement and width | Unimplemented |
| ExoPlayerService / MediaPlayerService | Hardware-decoded HLS/VOD/clip playback, selected backend capabilities, quality and audio-only tracks, stream/VOD token handling and auth errors, reconnect, live edge and DVR | Unimplemented |
| player_layout.xml | Play/pause, rewind/forward, seek bar, position/duration, live jump, quality, speed, restart, fullscreen, minimize, volume, audio compressor, audio-only, subtitles, chat/chat-input toggles | Unimplemented |
| Player metadata and buttons | Channel/title/category navigation, uptime/viewer count, follow, download, sleep timer, aspect ratio, configurable button and menu visibility | Unimplemented |
| PlayerSettingsDialog | Quality, speed, viewer list, VOD chapters, download, bookmark, share, find unlisted VOD, timer, ratio, volume, subtitles, restart, chat visibility/input, reload emotes, connect/disconnect chat, translate-all, playlist tag diagnostics | Unimplemented |
| PlayerGamesDialog | VOD chapter/category timeline and seeking | Unimplemented |
| PlayerViewerListDialog | Viewer list with actual API availability and account behavior | Unimplemented |
| PlayerVolumeDialog | Volume and dynamic range/audio compressor controls | Unimplemented |
| SleepTimerDialog | Duration/time picker, stop playback, optional Windows lock with explicit user preference | Unimplemented |
| PlayerLayout / ChatLayout | Resizing/moving minimized player, portrait/landscape equivalent responsive layouts, click/touch gestures and keyboard access | Unimplemented |
| BasePlaybackService | Media session, headset/media keys, audio-focus/noisy-device behavior, background audio policy, stream notification seeking, pause/release ownership | Unimplemented |
| ChatFragment / ChatAdapter | Bounded virtualized live chat, timestamps, usernames/theme-adapted color, badges, message highlights, recent history, clear-message/clear-chat, first-message and system notices, pause-on-scroll/jump-to-latest | Unimplemented |
| Chat write | Authenticated send, autocomplete, reply composer/thread navigation, room follower/sub/slow/emote state and visible send errors | Unimplemented |
| EmotesFragment / EmotesAdapter | Recent/Twitch/channel third-party emote tabs, animated GIF/WebP, zero-width overlays, size/quality settings and tap insertion | Unimplemented |
| 7TV / BTTV / FFZ integration | Global/channel/personal emotes, 7TV badges/name paints and live updates according to preferences | Unimplemented |
| MessageClickedDialog | User metadata/history, reply, copy message/clip/full message, translate/selected source language, view channel profile | Unimplemented |
| ReplyClickedDialog | Conversation view, live updates, reply/copy/profile/translation actions | Unimplemented |
| ImageClickedDialog | Full image/emote preview and associated metadata/actions | Unimplemented |
| ChatReplayManager / ChatReplayManagerLocal | Online VOD and downloaded chat replay synchronized to seek, speed, pause, and video identity | Unimplemented |
| Chat event transports | IRC over WebSocket/socket and TLS setting, EventSub/Hermes/PubSub events, appropriate connection ownership/retry/teardown | Unimplemented |
| Chat interactive events | Channel point collection/notifications, raids and auto-switch, polls/predictions display and countdowns | Unimplemented |
| Translation | Automatic/per-message translation, target language/per-channel preferences and downloaded-model management; Android ML Kit has no direct Windows implementation here | Unimplemented |

## Data and native integrations

| Android capability | Windows equivalent and parity requirement | Status |
| --- | --- | --- |
| AppDatabase schema 41 | Versioned persistence for OfflineVideo, RecentEmote, VideoPosition, LocalChannelFollow, LocalGameFollow, Bookmark, BookmarkIgnoredUser, ChannelSort, GameSort, ShownNotification, NotificationUser, TranslatedChannel, SavedFilter, RecentSearch, PlaybackState, CustomProxy, StreamProxy, VideoSwap | Unimplemented |
| Settings backup/restore | Portable import/export with validated keys/types, no account secret included in routine settings export, failure leaves current state intact | Unimplemented |
| Downloads | Cancel/resume-safe files, HLS parsing/segment retrieval, stream recording, VOD range/quality selection and chat download, conversion/import/export and storage errors | Unimplemented |
| LiveNotificationWorker | Opt-in Windows notifications, schedule/coalescing, follow and notification user state, click opens correct stream, no polling while disabled | Unimplemented |
| MediaSession / MediaButtonReceiver | System media transport controls and media keys, correct play/pause/stop and metadata | Unimplemented |
| Android picture-in-picture | Compact always-on-top Windows player with explicit close/background policy | Unimplemented |
| Foreground playback/download services | Owned application jobs with clear exit/tray policy and shutdown that releases media, sockets, timers, and downloads as configured | Unimplemented |
| Twitch http(s) intents | Windows URI association/deep-link routing for channels, VODs and clips, including app-already-open routing | Unimplemented |
| Android external share / SAF | Windows clipboard/share/open URL, native file/folder dialogs and explicit export destinations | Unimplemented |
| Android auth/token storage | Windows credential protection, user-owned browser auth flow, never log bearer tokens or passwords | Unimplemented |
| Android cutouts/orientation/device-admin/notification permission | Windows sizing/fullscreen/lock/notification settings; document semantic equivalents and avoid inert Android controls | Unimplemented |
| Theme/localization | Source light/dark/black/custom colors, typography/card spacing/iconography, translations and RTL; Windows system theme mapping | Unimplemented |
| Updates | Fork-specific release source, downloadable Windows package, version/channel reporting and signature strategy | Unimplemented |

## Architecture proposal

Use a Flutter Windows frontend with `media_kit`/libmpv for the same Windows approach as the existing CB Plus desktop, provided player rendering and hardware decoding pass early validation. Recreate Xtra's Material layout, card shapes, tab structure, icon positions and settings hierarchy from the Android resources. Keep a navigation/state model independent of widgets and use virtualized lists for directories and chat. Build an actual desktop media controller; do not embed twitch.tv as a substitute for Xtra's player and UI.

The existing CB Plus desktop at `C:\Library\General\Scripts\Claude Projects\Programs\Chaturbate Plus\windows\desktop` uses Flutter, `media_kit`, `media_kit_video`, `media_kit_libs_video`, and `share_plus`. Its approach can guide build packaging, portable storage, native player ownership, and smoke tests. Its application state, API adapters and domain UI are unrelated and must not be copied wholesale. Its own `PARITY_GAPS.md` distinguishes source/fixture coverage from signed-in runtime checks; use that distinction for this port too.

Keep the Android Kotlin implementation while reducing its wasted work. Rewriting Android in Dart just to share new Windows widgets would add regression risk before establishing measured battery improvements.

Share a versioned **behavior contract and fixtures** first: routes, model JSON, settings key/default/option schema, HLS quality parsing examples, IRC tags/reply/clear events, downloaded-chat replay, filter/sort rules, and persistent data import/export. Pure Kotlin parsers/data models could be extracted into a JVM core if a Kotlin service is chosen, but that introduces a bundled JVM and a second process. A Compose Desktop frontend is a credible alternative if preserving Kotlin repository logic becomes more valuable than using the prior Flutter toolchain.

Direct source reuse is not presently available: `PlayerRepository` imports Android `Context`, `HttpEngine`, `Uri`, `Base64`, Room DAOs and Cronet; Android fragments/view bindings, Media3/MediaPlayer, ML Kit, WorkManager and preferences are platform-specific. A Kotlin rewrite is therefore not a zero-cost port. For Flutter, port the repository/API and chat behavior with conformance fixtures instead of claiming the Kotlin sources are shared.

Separate the Windows application into navigation/browse, Twitch API and auth, player/stream resolution, chat/transports/rendering, persistence/library/downloads, settings, and platform adapters. Use bounded caches and event-driven updates; suspend animations and polling when views are hidden/minimized, release video decoding for audio-only operation, and tear down all socket/timer ownership when the associated session closes. Token-bearing traffic must remain inside the API layer and must be excluded from logs/fixtures.

## Tooling observed locally

`C:\Library\Claude Tools` contains `flutter`, `vs-buildtools`, `android-sdk`, `gradle-dist`, `gradle-home`, `jdk17`, `dotnet`, and caches. Flutter's executable is `C:\Library\Claude Tools\flutter\bin\flutter.bat`. A separate `dotnet.exe` host is on PATH but `dotnet --list-sdks` returned no SDK entries in this audit. These observations identify candidates, not proof of build readiness. Existing CB Plus Windows build scripts use short paths and staging to avoid paths with spaces. Keep new staging/output under the current authorized workspace.

## Verification gates

1. Obtain the battery-fix Android APK first and record its build SHA and changed behavior. Preserve Android as the parity reference.
2. Prove Windows hardware-decoded live HLS, VOD/clip seeking, audio, quality switching and session teardown before expanding the UI.
3. Implement all navigation/screens and the complete preference inventory with real persistence. Record screenshots at matching logical dimensions for Android/Windows side-by-side comparison.
4. Verify chat against recorded protocol fixtures, then live read-only chat, then user-authenticated send/reply and account features through user-owned login.
5. Verify every download/import/export/state migration and Windows native integration. Exercise cancellation, network loss, restart and invalid data.
6. Complete end-to-end signed-out and signed-in parity checks, native fullscreen/compact/media keys/notifications, and extended playback CPU/GPU/memory/network measurements. Only then publish a Windows release as full parity.

No runtime, build, Windows visual, media, or account validation is established by this document.
