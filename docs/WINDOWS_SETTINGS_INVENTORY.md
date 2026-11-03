# Windows settings parity inventory

Generated from every Android `*_preferences.xml` on 2026-11-03. All Windows settings in this initial inventory are unimplemented. Actions and subpage links are included, not merely persisted values. Runtime-created settings and dialogs must additionally be checked against `SettingsActivity.kt`.

## api_token_preferences.xml

| Key | Android control | Title | Default | Values | Windows |
| --- | --- | --- | --- | --- | --- |
| api_login | ListPreference | Get token for selected APIs | 0 | 0, 1, 2 | Unimplemented |
| helix_client_id | EditTextPreference | Helix client ID | ilfexgv3nnljz3isbm257gzwrzr7bi |  | Unimplemented |
| helix_redirect | EditTextPreference | Helix redirect URL | https://localhost |  | Unimplemented |
| gql_client_id2 | EditTextPreference | GQL client ID | kd1unb4b3q4t58fwlpcbzcbnm76a8fp |  | Unimplemented |
| user_id | EditTextPreference | Account ID |  |  | Unimplemented |
| username | EditTextPreference | Account login |  |  | Unimplemented |
| token | EditTextPreference | Helix token |  |  | Unimplemented |
| gql_token2 | EditTextPreference | GQL token |  |  | Unimplemented |
| gql_token_web | EditTextPreference | Web GQL token |  |  | Unimplemented |
| validate_tokens | SwitchPreferenceCompat | Validate tokens on startup | true |  | Unimplemented |

## buffer_preferences.xml

| Key | Android control | Title | Default | Values | Windows |
| --- | --- | --- | --- | --- | --- |
| player_buffer_min | EditTextPreference | Minimum buffer | 15000 |  | Unimplemented |
| player_buffer_max | EditTextPreference | Maximum buffer | 50000 |  | Unimplemented |
| player_buffer_playback | EditTextPreference | Buffer for playback | 2000 |  | Unimplemented |
| player_buffer_rebuffer | EditTextPreference | Rebuffer | 2000 |  | Unimplemented |
| player_live_min_speed | EditTextPreference | Live minimum speed |  |  | Unimplemented |
| player_live_max_speed | EditTextPreference | Live maximum speed |  |  | Unimplemented |
| player_live_target_offset | EditTextPreference | Live target offset | 2000 |  | Unimplemented |

## chat_preferences.xml

| Key | Android control | Title | Default | Values | Windows |
| --- | --- | --- | --- | --- | --- |
| chat_boldnames | SwitchPreferenceCompat | Bold usernames | false |  | Unimplemented |
| chat_randomcolor | SwitchPreferenceCompat | Random color for users without a color | true |  | Unimplemented |
| chat_theme_adapted_username_color | SwitchPreferenceCompat | Readable colors based on the app theme | true |  | Unimplemented |
| chat_timestamps | SwitchPreferenceCompat | Show timestamps | false |  | Unimplemented |
| chat_timestamp_format | ListPreference | Timestamp format | 0 | 0, 1, 2, 3, 4, 5, 6, 7 | Unimplemented |
| chat_image_library | ListPreference | Image library | 0 | 0, 1, 2 | Unimplemented |
| chat_use_webp | SwitchPreferenceCompat | Use WebP images | true |  | Unimplemented |
| chat_image_quality | ListPreference | Image quality | 4 | 1, 2, 3, 4 | Unimplemented |
| chat_size_modifier | SeekBarPreference | Size modifier | 100 |  | Unimplemented |
| chat_text_size | EditTextPreference | Text size | 14 |  | Unimplemented |
| chat_emote_size | EditTextPreference | Emote size | 29.5 |  | Unimplemented |
| chat_badge_size | EditTextPreference | Badge size | 18.5 |  | Unimplemented |
| chat_show_gif_messages | SwitchPreferenceCompat | Show GIF messages | true |  | Unimplemented |
| chat_gif_size | EditTextPreference | GIF size | 79.5 |  | Unimplemented |
| chatWidth | SeekBarPreference | Landscape chat width | 30 |  | Unimplemented |
| chat_limit | SeekBarPreference | Message limit | 600 |  | Unimplemented |
| chat_recent | SwitchPreferenceCompat | Load recent messages | true |  | Unimplemented |
| chat_recent_messages_url | EditTextPreference | Recent messages API URL | https://recent-messages.robotty.de/api/v2/recent-messages/$channel |  | Unimplemented |
| chat_recent_limit | SeekBarPreference | Recent message limit | 100 |  | Unimplemented |
| chat_translate | SwitchPreferenceCompat | Translate chat messages | false |  | Unimplemented |
| downloaded_languages | Preference | Downloaded languages |  |  | Unimplemented |
| chat_translate_target | ListPreference | Target language | en |  | Unimplemented |
| player_keep_chat_open | SwitchPreferenceCompat | Keep chat connected in the background | false |  | Unimplemented |
| chat_use_websocket | SwitchPreferenceCompat | Connect using WebSocket | true |  | Unimplemented |
| chat_use_ssl | SwitchPreferenceCompat | Connect using SSL | true |  | Unimplemented |
| chat_pubsub_enabled | SwitchPreferenceCompat | Enable PubSub | true |  | Unimplemented |
| chat_points_collect | SwitchPreferenceCompat | Collect channel points automatically | true |  | Unimplemented |
| chat_points_notify | SwitchPreferenceCompat | Notify when earning channel points | false |  | Unimplemented |
| chat_raids_show | SwitchPreferenceCompat | Show raids | true |  | Unimplemented |
| chat_raids_auto_switch | SwitchPreferenceCompat | Switch stream on raid automatically | true |  | Unimplemented |
| chat_polls_show | SwitchPreferenceCompat | Show polls | true |  | Unimplemented |
| chat_predictions_show | SwitchPreferenceCompat | Show predictions | true |  | Unimplemented |
| chat_show_paints | SwitchPreferenceCompat | Show 7TV name paints | true |  | Unimplemented |
| chat_show_stv_badges | SwitchPreferenceCompat | Show 7TV badges | true |  | Unimplemented |
| chat_show_personal_emotes | SwitchPreferenceCompat | Show 7TV personal emotes | true |  | Unimplemented |
| chat_stv_live_updates | SwitchPreferenceCompat | 7TV live emote updates | true |  | Unimplemented |
| chat_enable_stv | SwitchPreferenceCompat | Enable 7TV emotes | true |  | Unimplemented |
| chat_enable_bttv | SwitchPreferenceCompat | Enable BTTV emotes | true |  | Unimplemented |
| chat_enable_ffz | SwitchPreferenceCompat | Enable FFZ emotes | true |  | Unimplemented |
| chat_show_usernotice | SwitchPreferenceCompat | Show user notices (subs, raids) | true |  | Unimplemented |
| chat_show_clearmsg | SwitchPreferenceCompat | Show deletions of single messages | true |  | Unimplemented |
| chat_show_clearchat | SwitchPreferenceCompat | Show timeouts and bans | true |  | Unimplemented |
| chat_firstmsg_visibility | ListPreference | First messages and redemptions with text | 0 | 0, 1, 2 | Unimplemented |
| animatedGifEmotes | SwitchPreferenceCompat | Animated emotes | true |  | Unimplemented |
| chat_zerowidth | SwitchPreferenceCompat | Overlay emotes | true |  | Unimplemented |
| chat_system_message_emotes | SwitchPreferenceCompat | Show emotes on system messages | true |  | Unimplemented |
| chat_disable | SwitchPreferenceCompat | Disable chat | false |  | Unimplemented |

## debug_preferences.xml

| Key | Android control | Title | Default | Values | Windows |
| --- | --- | --- | --- | --- | --- |
| debug_chat_fullmsg | SwitchPreferenceCompat | Copy full IRC messages | false |  | Unimplemented |
| debug_api_commands | SwitchPreferenceCompat | Use API chat commands | true |  | Unimplemented |
| debug_api_chat_messages | SwitchPreferenceCompat | Send chat messages using the API | true |  | Unimplemented |
| debug_websocket_info | SwitchPreferenceCompat | Show more info about WebSockets | false |  | Unimplemented |
| player | ListPreference | Player | ExoPlayer | ExoPlayer, MediaPlayer | Unimplemented |
| debug_eventsub_chat | SwitchPreferenceCompat | EventSub chat | false |  | Unimplemented |
| debug_player_menu_playlist_tags | SwitchPreferenceCompat | Show playlist tags | false |  | Unimplemented |
| enable_integrity | SwitchPreferenceCompat | Use integrity token | false |  | Unimplemented |
| use_webview_integrity | SwitchPreferenceCompat | Get integrity token using WebView | true |  | Unimplemented |
| get_all_gql_headers | SwitchPreferenceCompat | Get all headers | false |  | Unimplemented |
| gql_headers | EditTextPreference | GQL headers |  |  | Unimplemented |
| get_integrity_token | Preference | Get new integrity token |  |  | Unimplemented |

## download_preferences.xml

| Key | Android control | Title | Default | Values | Windows |
| --- | --- | --- | --- | --- | --- |
| download_playlist_to_file | SwitchPreferenceCompat | Download videos to single files | false |  | Unimplemented |
| download_wifi_only | SwitchPreferenceCompat | Download using Wi-Fi only | false |  | Unimplemented |
| download_limit | SeekBarPreference | Concurrent downloads | 2 |  | Unimplemented |
| download_concurrent_limit | SeekBarPreference | Download threads | 10 |  | Unimplemented |
| download_stream_live_check | EditTextPreference | Stream playlist check frequency | 2 |  | Unimplemented |
| download_stream_offline_check | EditTextPreference | Live check frequency | 10 |  | Unimplemented |
| download_stream_start_wait | EditTextPreference | Wait time before stream | 120 |  | Unimplemented |
| download_stream_end_wait | EditTextPreference | Wait time after stream | 15 |  | Unimplemented |
| import_app_downloads | Preference | Import downloads from app storage |  |  | Unimplemented |

## playback_preferences.xml

| Key | Android control | Title | Default | Values | Windows |
| --- | --- | --- | --- | --- | --- |
| proxy_timeout | EditTextPreference | Proxy timeout | 3000 |  | Unimplemented |
| player_use_video_swap | SwitchPreferenceCompat | Use video swap | false |  | Unimplemented |
| video_swap_settings | Preference | Video swap settings |  |  | Unimplemented |
| player_hide_ads | SwitchPreferenceCompat | Hide player during ads | false |  | Unimplemented |
| token_supported_codecs | EditTextPreference | Supported codecs | av1,h265,h264 |  | Unimplemented |
| token_include_token_stream | SwitchPreferenceCompat | Include GQL token in stream requests | true |  | Unimplemented |
| token_include_token_video | SwitchPreferenceCompat | Include GQL token in video requests | true |  | Unimplemented |

## player_button_preferences.xml

| Key | Android control | Title | Default | Values | Windows |
| --- | --- | --- | --- | --- | --- |
| player_minimize | SwitchPreferenceCompat | Minimize | true |  | Unimplemented |
| player_download | SwitchPreferenceCompat | Download | false |  | Unimplemented |
| player_follow | SwitchPreferenceCompat | Follow | false |  | Unimplemented |
| player_sleep | SwitchPreferenceCompat | Sleep timer | false |  | Unimplemented |
| sleep_timer_use_time_picker | SwitchPreferenceCompat | Use Material time picker for sleep timer | false |  | Unimplemented |
| sleep_timer_lock | SwitchPreferenceCompat | Lock screen after sleep timer is done | false |  | Unimplemented |
| admin_settings | Preference | Enable/disable as device admin app |  |  | Unimplemented |
| player_aspect | SwitchPreferenceCompat | Aspect ratio | true |  | Unimplemented |
| player_speedbutton | SwitchPreferenceCompat | Playback speed | true |  | Unimplemented |
| player_speed_list | EditTextPreference | Playback speeds | 0.25\n0.5\n0.75\n1.0\n1.25\n1.5\n1.75\n2.0\n3.0\n4.0\n8.0 |  | Unimplemented |
| player_settings | SwitchPreferenceCompat | Quality | true |  | Unimplemented |
| player_menu | SwitchPreferenceCompat | Player menu | true |  | Unimplemented |
| player_menu_settings | Preference | Player menu settings |  |  | Unimplemented |
| player_gamesbutton | SwitchPreferenceCompat | Chapters | true |  | Unimplemented |
| player_restart | SwitchPreferenceCompat | Restart player | true |  | Unimplemented |
| player_seeklive | SwitchPreferenceCompat | Seek to live | false |  | Unimplemented |
| player_volumebutton | SwitchPreferenceCompat | Volume | true |  | Unimplemented |
| player_audio_compressor_button | SwitchPreferenceCompat | Audio compressor | true |  | Unimplemented |
| player_mode | SwitchPreferenceCompat | Audio only | false |  | Unimplemented |
| player_subtitles | SwitchPreferenceCompat | Subtitles | false |  | Unimplemented |
| player_chatbartoggle | SwitchPreferenceCompat | Chat input toggle | false |  | Unimplemented |
| player_chattoggle | SwitchPreferenceCompat | Chat toggle | true |  | Unimplemented |
| player_fullscreen | SwitchPreferenceCompat | Fullscreen | true |  | Unimplemented |
| player_doubletap | SwitchPreferenceCompat | Double tap to toggle chat | true |  | Unimplemented |
| playerRewindV2 | EditTextPreference | Rewind | 10 |  | Unimplemented |
| playerForwardV2 | EditTextPreference | Fast forward | 10 |  | Unimplemented |
| player_channel | SwitchPreferenceCompat | Show channel name | true |  | Unimplemented |
| player_title | SwitchPreferenceCompat | Show title | true |  | Unimplemented |
| player_category | SwitchPreferenceCompat | Show category | true |  | Unimplemented |
| player_show_uptime | SwitchPreferenceCompat | Show stream uptime | true |  | Unimplemented |
| player_viewerlist | SwitchPreferenceCompat | Open viewer list from view count | false |  | Unimplemented |
| player_viewericon | SwitchPreferenceCompat | Show view count and uptime icons | true |  | Unimplemented |
| player_pause | SwitchPreferenceCompat | Show pause button on livestreams | false |  | Unimplemented |

## player_menu_preferences.xml

| Key | Android control | Title | Default | Values | Windows |
| --- | --- | --- | --- | --- | --- |
| player_menu_quality | SwitchPreferenceCompat | Quality | false |  | Unimplemented |
| player_menu_speed | SwitchPreferenceCompat | Playback speed | false |  | Unimplemented |
| player_menu_viewer_list | SwitchPreferenceCompat | Viewer list | true |  | Unimplemented |
| player_menu_games | SwitchPreferenceCompat | Chapters | false |  | Unimplemented |
| player_menu_download | SwitchPreferenceCompat | Download | true |  | Unimplemented |
| player_menu_bookmark | SwitchPreferenceCompat | Bookmark | true |  | Unimplemented |
| player_menu_share | SwitchPreferenceCompat | Share | true |  | Unimplemented |
| player_menu_find_vod | SwitchPreferenceCompat | Find unlisted video | true |  | Unimplemented |
| player_menu_sleep | SwitchPreferenceCompat | Sleep timer | true |  | Unimplemented |
| player_menu_aspect | SwitchPreferenceCompat | Aspect ratio | false |  | Unimplemented |
| player_menu_volume | SwitchPreferenceCompat | Volume | false |  | Unimplemented |
| player_menu_subtitles | SwitchPreferenceCompat | Toggle subtitles | true |  | Unimplemented |
| player_menu_restart | SwitchPreferenceCompat | Restart player | false |  | Unimplemented |
| player_menu_chat_bar | SwitchPreferenceCompat | Toggle chat input | true |  | Unimplemented |
| player_menu_chat_toggle | SwitchPreferenceCompat | Toggle chat | false |  | Unimplemented |
| player_menu_reload_emotes | SwitchPreferenceCompat | Reload emotes | true |  | Unimplemented |
| player_menu_chat_disconnect | SwitchPreferenceCompat | Disconnect from chat | true |  | Unimplemented |

## player_preferences.xml

| Key | Android control | Title | Default | Values | Windows |
| --- | --- | --- | --- | --- | --- |
| player_disable_background_video | SwitchPreferenceCompat | Disable video rendering in the background | true |  | Unimplemented |
| player_use_background_audio_track | SwitchPreferenceCompat | Switch to audio-only track in the background | true |  | Unimplemented |
| player_background_audio_pip_closed | SwitchPreferenceCompat | Play audio in the background when closing PiP | false |  | Unimplemented |
| player_background_audio_pip_locked | SwitchPreferenceCompat | Play audio in the background when the screen is locked in PiP mode | true |  | Unimplemented |
| player_keep_screen_on_when_paused | SwitchPreferenceCompat | Keep screen on when video is paused | false |  | Unimplemented |
| player_audio_focus | SwitchPreferenceCompat | Pause when other apps play audio | false |  | Unimplemented |
| player_handle_audio_becoming_noisy | SwitchPreferenceCompat | Pause when headphones are disconnected | true |  | Unimplemented |
| player_show_stream_notification_seekbar | SwitchPreferenceCompat | Show seekbar on media notification when watching streams | true |  | Unimplemented |
| player_defaultquality | ListPreference | Default player quality | saved | saved, auto, Source, 1080p60, 1080, 720p60, 720, 480, 360, 160, audio_only, chat_only | Unimplemented |
| player_default_cellular_quality | ListPreference | Default player quality on cellular network | saved | saved, auto, Source, 1080p60, 1080, 720p60, 720, 480, 360, 160, audio_only, chat_only | Unimplemented |
| player_rounded_corner_padding | SwitchPreferenceCompat | Avoid rounded screen corners | false |  | Unimplemented |
| player_move_freely | SwitchPreferenceCompat | Move minimized player freely | false |  | Unimplemented |
| player_use_videopositions | SwitchPreferenceCompat | Save positions of watched videos | true |  | Unimplemented |
| delete_video_positions | Preference | Delete video positions |  |  | Unimplemented |

## root_preferences.xml

| Key | Android control | Title | Default | Values | Windows |
| --- | --- | --- | --- | --- | --- |
| ui_language | ListPreference | Language | auto | auto, de, en, es, fr, gl, in, it, pt-BR, tr, ru, ar, ja, zh-TW, zh-CN | Unimplemented |
| ui_draw_behind_cutouts | SwitchPreferenceCompat | Draw behind display cutouts | false |  | Unimplemented |
| live_notifications_enabled | SwitchPreferenceCompat | Live notifications | false |  | Unimplemented |
| theme_settings | Preference | Theme |  |  | Unimplemented |
| ui_settings | Preference | UI |  |  | Unimplemented |
| chat_settings | Preference | Chat |  |  | Unimplemented |
| player_picture_in_picture | SwitchPreferenceCompat | Picture-in-Picture | true |  | Unimplemented |
| player_background_audio | SwitchPreferenceCompat | Play audio in the background | true |  | Unimplemented |
| player_background_audio_locked | SwitchPreferenceCompat | Play audio in the background when the screen is locked | true |  | Unimplemented |
| player_settings | Preference | Player |  |  | Unimplemented |
| player_button_settings | Preference | Player buttons |  |  | Unimplemented |
| buffer_settings | Preference | Buffer settings |  |  | Unimplemented |
| player_use_custom_proxy | SwitchPreferenceCompat | Use custom proxies | true |  | Unimplemented |
| custom_proxy_settings | Preference | Custom proxy settings |  |  | Unimplemented |
| player_use_stream_proxy | SwitchPreferenceCompat | Use HTTP proxies | false |  | Unimplemented |
| stream_proxy_settings | Preference | HTTP proxy settings |  |  | Unimplemented |
| playback_settings | Preference | Playback |  |  | Unimplemented |
| api_token_settings | Preference | API token settings |  |  | Unimplemented |
| network_library | ListPreference | Network library | OkHttp | HttpEngine, Cronet, OkHttp | Unimplemented |
| download_settings | Preference | Downloads |  |  | Unimplemented |
| check_updates | Preference | Check for updates |  |  | Unimplemented |
| update_settings | Preference | Update settings |  |  | Unimplemented |
| backup_settings | Preference | Backup settings and data |  |  | Unimplemented |
| restore_settings | Preference | Restore settings and data |  |  | Unimplemented |
| debug_settings | Preference | Debug |  |  | Unimplemented |

## theme_preferences.xml

| Key | Android control | Title | Default | Values | Windows |
| --- | --- | --- | --- | --- | --- |
| theme | ListPreference | Theme | 0 | 4, 6, 5, 0, 1, 2, 3 | Unimplemented |
| ui_theme_follow_system | SwitchPreferenceCompat | Change based on device theme | false |  | Unimplemented |
| ui_theme_dark_on | ListPreference | Dark theme on | 0 | 4, 6, 5, 0, 1, 2, 3 | Unimplemented |
| ui_theme_dark_off | ListPreference | Dark theme off | 2 | 4, 6, 5, 0, 1, 2, 3 | Unimplemented |
| ui_theme_rounded_corners_v2 | ListPreference | Rounded corners | 0 | 0, 1, 2 | Unimplemented |
| ui_theme_reduced_padding | SwitchPreferenceCompat | Reduced padding | false |  | Unimplemented |
| ui_theme_compact_text | SwitchPreferenceCompat | Compact text | false |  | Unimplemented |
| ui_theme_appbar_lift | SwitchPreferenceCompat | Lift app bar on scroll | true |  | Unimplemented |
| ui_theme_bottom_nav_color | SwitchPreferenceCompat | Bottom navigation color | true |  | Unimplemented |
| ui_theme_material3 | SwitchPreferenceCompat | Material 3 theme | true |  | Unimplemented |

## ui_preferences.xml

| Key | Android control | Title | Default | Values | Windows |
| --- | --- | --- | --- | --- | --- |
| columnsPortrait | ListPreference | Portrait column count | @string/portraitColumns | 1, 2, 3, 4 | Unimplemented |
| columnsLandscape | ListPreference | Landscape column count | @string/landscapeColumns | 1, 2, 3, 4, 5, 6 | Unimplemented |
| ui_follow_button | ListPreference | Follow button | 0 | 0, 1, 2 | Unimplemented |
| ui_activate_notifications_when_following | SwitchPreferenceCompat | Activate notifications when following | true |  | Unimplemented |
| ui_startonfollowed | ListPreference | Start on \"Following\" page | 1 | 0, 1, 2 | Unimplemented |
| ui_navigation_tab_list_dialog | Preference | Bottom navigation tabs |  |  | Unimplemented |
| ui_following_tabs_dialog | Preference | Following tabs |  |  | Unimplemented |
| ui_saved_tabs_dialog | Preference | Saved tabs |  |  | Unimplemented |
| ui_channel_tabs_dialog | Preference | Channel tabs |  |  | Unimplemented |
| ui_game_tabs_dialog | Preference | Game tabs |  |  | Unimplemented |
| ui_search_tabs_dialog | Preference | Search tabs |  |  | Unimplemented |
| compactStreamsV2 | ListPreference | Hide stream previews | disabled | all, followed, disabled | Unimplemented |
| ui_name_display | ListPreference | Username display | 0 | 0, 1, 2 | Unimplemented |
| ui_rounduserimage | SwitchPreferenceCompat | Circle profile pictures | true |  | Unimplemented |
| ui_truncateviewcount | SwitchPreferenceCompat | Compact number formatting | true |  | Unimplemented |
| ui_uptime | SwitchPreferenceCompat | Show stream uptime | true |  | Unimplemented |
| ui_tags | SwitchPreferenceCompat | Show tags | true |  | Unimplemented |
| ui_broadcasterscount | SwitchPreferenceCompat | Show broadcaster count on games | true |  | Unimplemented |
| ui_followpager | SwitchPreferenceCompat | Use tabs for \"Following\" page | true |  | Unimplemented |
| ui_savedpager | SwitchPreferenceCompat | Use tabs for \"Saved\" page | true |  | Unimplemented |
| ui_gamepager | SwitchPreferenceCompat | Use tabs for \"Games\" page | true |  | Unimplemented |
| ui_scrolltop | SwitchPreferenceCompat | Show scroll to top button | true |  | Unimplemented |
| ui_bookmark_time_left | SwitchPreferenceCompat | Show time left on bookmarked VODs | true |  | Unimplemented |
| ui_store_recent_searches | SwitchPreferenceCompat | Store recent searches | true |  | Unimplemented |
| delete_recent_searches | Preference | Delete recent searches |  |  | Unimplemented |

## update_preferences.xml

| Key | Android control | Title | Default | Values | Windows |
| --- | --- | --- | --- | --- | --- |
| update_url | EditTextPreference | Update check URL | https://api.github.com/repos/crackededed/xtra/releases/tags/latest |  | Unimplemented |
| update_check_enabled | SwitchPreferenceCompat | Check for updates on startup | false |  | Unimplemented |
| update_check_frequency | EditTextPreference | Update check frequency | 7 |  | Unimplemented |
| update_use_browser | SwitchPreferenceCompat | Open update link in browser | false |  | Unimplemented |

Total XML controls/actions inventoried: 220.
