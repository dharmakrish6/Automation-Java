*** Variable ***
#*********************************  VOD player ******************************************
#FlowPlayer UI - VOD
${vod_playbtn}          xpath=//*[@id=\"player\"]/div[2]/div[1]/div[5]/div[2]/a
${vod_fullscreen}       css=a.fp-fullscreen.fp-icon
${rewind_icon}          xpath=//*[@id=\"rewind\"]
${forward_icon}         xpath=//*[@id=\"fastFwd\"]

#subtitle settings
${subtitle_option}      css=strong.fp-cc
${subs_on}              xpath=//div[@class='fp-ui']//a[.='English']
${subs_off}             xpath=//div[@class='fp-ui']//a[.='Off subtitle']

#quality settings
${v_quality_auto}         xpath=//div[@class='fp-ui']//a[.='Auto']
${v_quality_low}          xpath=//div[@class='fp-ui']//a[.='Low']
${v_quality_medium}       xpath=//div[@class='fp-ui']//a[.='Medium']
${v_quality_HD}           xpath=//div[@class='fp-ui']//a[.='HD']

#speed settings (depreceated)
#${v_speed_option}         css=a.group-item:nth-child(2) > div:nth-child(2)
#${v_speed_slow}           css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(2)
#${v_speed_slowersmooth}   css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(3)
#${v_speed_normal}         css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(4)
#${v_speed_fastersmooth}   css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(5)
#${v_speed_faster}         css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(6)

#************************************************* Live TV Player ****************************************************************
#Flow Player UI - Live TV
${live_playbtn}          xpath=//*[@id="app"]/div[1]/section[1]/div[2]/div[3]/div[3]/a
${live_fullscreen}       css=.fp-fullscreen
${live_gear}             xpath=//*[@id=\"player\"]/div[2]/div[1]/div[5]/button
${live_seekbar}          xpath=//div[@class='fp-progress fp-color animated']

#Quality Settings - Live TV
${l_quality_auto}         xpath=//div[@class='fp-ui']//a[.='Auto']
${l_quality_180p96k}      xpath=//div[@class='fp-ui']//a[.='180p (96k)']
${l_quality_180p160k}     xpath=//div[@class='fp-ui']//a[.='180p (160k)']
${l_quality_180p288k}     xpath=//div[@class='fp-ui']//a[.='180p (288k)']
${l_quality_270p544k}     xpath=//div[@class='fp-ui']//a[.='270p (544k)']
${l_quality_270p800k}     xpath=//div[@class='fp-ui']//a[.='270p (800k)']
${l_quality_360p1088k}    xpath=//div[@class='fp-ui']//a[.='360p (1088k)']
${l_quality_720p2624k}    xpath=//div[@class='fp-ui']//a[.='720p (2624k)']

#*************************************************** Common **********************************************************************
${v_quality_option}      xpath=//*[@id="player"]/div[2]/div[1]/div[5]/strong[2]/i
${quality_option}       css=i.fa.fa-cog
${volume_icon}          css=a.fp-icon.fp-volumebtn
${elapsed_time}         xpath=//*[@id=\"player\"]/div[2]/div[1]/div[5]/div[3]/div[1]/span[1]
${total_time}           xpath=//*[@id=\"player\"]/div[2]/div[1]/div[5]/div[3]/div[1]/span[2]
${remaining_time}       xpath=//*[@id=\"player\"]/div[2]/div[1]/div[5]/div[3]/div[1]/span[3]