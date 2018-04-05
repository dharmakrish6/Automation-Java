*** Variable ***
#*********************************  VOD player ******************************************
#FlowPlayer UI - VOD
${vod_playbtn}          xpath=//*[@id=\"player\"]/div[2]/div[1]/div[5]/div[2]/a
${vod_fullscreen}       css=a.fp-fullscreen.fp-icon
${rewind_icon}          xpath=//*[@id=\"rewind\"]
${forward_icon}         xpath=//*[@id=\"fastFwd\"]

#subtitle settings
${subtitle_option}      css=strong.fp-cc
${subs_ON}              xpath=//div[@class='fp-ui']//a[.='English']
${subs_OFF}             xpath=//div[@class='fp-ui']//a[.='Off subtitle']

#quality settings
${vquality_auto}         xpath=//div[@class='fp-ui']//a[.='Auto']
${vquality_low}          xpath=//div[@class='fp-ui']//a[.='Low']
${vquality_medium}       xpath=//div[@class='fp-ui']//a[.='Medium']
${vquality_HD}           xpath=//div[@class='fp-ui']//a[.='HD']

#speed settings (depreceated)
#${vspeed_option}         css=a.group-item:nth-child(2) > div:nth-child(2)
#${vspeed_slow}           css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(2)
#${vspeed_slowersmooth}   css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(3)
#${vspeed_normal}         css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(4)
#${vspeed_fastersmooth}   css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(5)
#${vspeed_faster}         css=#player > div.fp-player > div.fp-ui > div.fp-controls-menu.fp-menu.fp-settings-menu.fp-submenu.fp-active > a:nth-child(6)

#************************************************* Live TV Player ****************************************************************
#Flow Player UI - Live TV
${live_playbtn}          xpath=//*[@id="app"]/div[1]/section[1]/div[2]/div[3]/div[3]/a
${live_fullscreen}       css=.fp-fullscreen
${live_gear}             xpath=//*[@id=\"player\"]/div[2]/div[1]/div[5]/button
${live_seekbar}          xpath=//div[@class='fp-progress fp-color animated']

#Quality Settings - Live TV
${lquality_auto}         xpath=//div[@class='fp-ui']//a[.='Auto']
${lquality_180p96k}      xpath=//div[@class='fp-ui']//a[.='180p (96k)']
${lquality_180p160k}     xpath=//div[@class='fp-ui']//a[.='180p (160k)']
${lquality_180p288k}     xpath=//div[@class='fp-ui']//a[.='180p (288k)']
${lquality_270p544k}     xpath=//div[@class='fp-ui']//a[.='270p (544k)']
${lquality_270p800k}     xpath=//div[@class='fp-ui']//a[.='270p (800k)']
${lquality_360p1088k}    xpath=//div[@class='fp-ui']//a[.='360p (1088k)']
${lquality_720p2624k}    xpath=//div[@class='fp-ui']//a[.='720p (2624k)']

#*************************************************** Common **********************************************************************
${quality_option}       css=i.fa.fa-cog
${volume_icon}          css=a.fp-icon.fp-volumebtn
${elapsed_time}         xpath=//*[@id=\"player\"]/div[2]/div[1]/div[5]/div[3]/div[1]/span[1]
${total_time}           xpath=//*[@id=\"player\"]/div[2]/div[1]/div[5]/div[3]/div[1]/span[2]
${remaining_time}       xpath=//*[@id=\"player\"]/div[2]/div[1]/div[5]/div[3]/div[1]/span[3]