# Desktop implementation interfaces

Flutter project: `windows/desktop`. Shared model types are in `lib/core/models.dart`.

`TwitchApi` in `lib/core/twitch_api.dart` exposes:

- Mutable `String? accessToken`, `String? accountLogin`, `String? accountId`, `String clientId` (web GQL client default).
- `Future<Map<String,dynamic>> gql(String query, [Map<String,dynamic> variables = const {}])`.
- `Future<ContentPage> topStreams({String? after, String? gameId, String sort = 'VIEWER_COUNT', List<String> languages = const [], List<String> tags = const []})`.
- `Future<ContentPage> games({String? after, List<String> tags = const []})`.
- `Future<ContentPage> search(String query, MediaKind kind, {String? after})`.
- `Future<ContentItem> channel(String login)`; returned extra may include about/panels/socials/schedule.
- `Future<ContentPage> channelVideos(String login, {String? after, String sort = 'TIME', String type = 'ARCHIVE'})`.
- `Future<ContentPage> channelClips(String login, {String? after, String period = 'LAST_WEEK'})`.
- `Future<ContentPage> gameVideos(String id, {String? after, String period = 'WEEK', String sort = 'VIEWS'})`.
- `Future<ContentPage> gameClips(String id, {String? after, String period = 'LAST_WEEK'})`.
- `Future<ContentPage> followedStreams({String? after})` and `followedChannels({String? after})` (real account auth required).
- `Future<ContentPage> relatedChannels(String login, {String? after})`.
- `Future<PlaybackSource> resolvePlayback(ContentItem item)`.
- `Future<List<ChatMessage>> videoComments(String videoId, {double offset = 0, String? cursor})`; cursor can be exposed via tag `cursor` on the last message.
- `Future<void> followChannel(String id, bool follow)`.
- `void close()`.

Do not create fixture results for live failures. Expose a useful error/retry state, respect service restrictions, preserve all upstream queries as reference assets.

Root owns `AppStore` in `lib/core/app_store.dart`: extends ChangeNotifier; `load()`, `getBool(key,default)`, `getString(key,default)`, `getInt(key,default)`, `getDouble(key,default)`, `setPref(key,value)`, `prefs`, `followedChannels`, `followedGames`, `bookmarks`, `isFollowed(item)`, `toggleFollow(item)`, `toggleBookmark(item,{Duration? position})`, `savePosition(item,Duration)`, `positionFor(item)`, `recentSearches`, `addSearch(query)`, `removeSearch(query)`. Changes are persisted atomically. Routine state/settings backup excludes account tokens and secrets.

Browse agent owns `lib/ui/` except root owns settings/auth. Export `XtraShell({required TwitchApi api,required AppStore store,required Widget Function(ContentItem,VoidCallback) playerBuilder,required VoidCallback onLogin,required VoidCallback onSettings})` in `ui/shell.dart`. Shell keeps playback alive while browsing, and routes streams/videos/clips/offline to playerBuilder. Top navigation follows Android: Following, Streams, Games, Saved plus search/settings/login in toolbar. Root will wire main.dart.

Player agent owns `lib/player/` and `lib/chat/`. Export `PlayerPane({required ContentItem item,required TwitchApi api,required AppStore store,required VoidCallback onClose,ValueChanged<ContentItem>? onNavigate})` in `player/player_pane.dart`. Use media_kit hardware decoding, stop/dispose on close, only connect chat for a visible player. Preserve player/chat feature behavior and document anything still missing.

Root owns main.dart, pubspec, persistence/settings/auth/download services, runner and packaging. Coordinate any extension needed rather than duplicating shared types.
