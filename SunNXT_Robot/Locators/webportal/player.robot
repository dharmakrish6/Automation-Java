*** Variable ***
#*********************************  VOD player ******************************************
#AD assert
${ad_msg}               css= div.fp-message.fp-title

#FlowPlayer UI - VOD
${rewind_icon}          css= #rewind
${forward_icon}         css= #fastFwd
${progressbar}          css= #player > div.fp-player > div.fp-ui > div.fp-controls > div.fp-timeline.fp-bar.fp-progressbar
${subtitle}             css= #player > div.fp-player > div.fp-captions.fp-shown

#subtitle settings
${subtitle_option}      css= .fp-cc
${subs_on}              English
${subs_off}             Off subtitle

#quality settings
${v_quality_auto}         Auto
${v_quality_low}          Low
${v_quality_medium}       Medium
${v_quality_HD}           HD

#speed settings (depreceated)
#${v_speed_option}         css=a.group-item:nth-child(2) > div:nth-child(2)
#${v_speed_slow}           css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(2)
#${v_speed_slowersmooth}   css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(3)
#${v_speed_normal}         css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(4)
#${v_speed_fastersmooth}   css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(5)
#${v_speed_faster}         css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(6)

#************************************************* Live TV Player ****************************************************************
#Channel Assert
${channel_name}           css= head title

#Quality Settings - Live TV
${l_quality_auto}         Auto
${l_quality_180p96k}      180p (96k)
${l_quality_180p160k}     180p (160k)
${l_quality_180p288k}     180p (288k)
${l_quality_270p544k}     270p (544k)
${l_quality_270p800k}     270p (800k)
${l_quality_360p1088k}    360p (1088k)
${l_quality_720p2624k}    720p (2624k)

#*************************************************** Common **********************************************************************
${playback_controls}     css= .fp-controls
${controls_bottom_left}  css= .video-controls-bottom
${playbtn}               css= .video-controls-bottom .fp-playbtn
${quality_option}        css= .fa-cog
${volume_icon}           css= .fp-volumebtn
${elapsed_time}          css= .fp-elapsed
${total_time}            css= .fp-duration
${remaining_time}        css= .fp-remaining
${seekbar}               css= .fp-progress
${fullscreen}            css= .fp-fullscreen
${chromecast_icon}
${player_error}          css= .fp-message