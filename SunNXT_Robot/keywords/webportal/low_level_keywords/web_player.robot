*** Settings ***
Documentation       Contains actions performed on flowplayer for livetv and vod's
Library               SeleniumLibrary
Library               BuiltIn
Resource              E:/Automation-Java/SunNXT_Robot/locators/webportal/player.robot
Resource              E:/Automation-Java/SunNXT_Robot/test_data/web_portal/timeout.robot

*** Keywords ***
CLICK ON PLAY BUTTON
    click element  ${vod_playbtn}
    sleep   ${stream_content}

CLICK ON PLAY BUTTON FOR LIVE TV
    click element  ${live_playbtn}

STREAM IN FULL-SCREEN MODE
    click element  ${vod_fullscreen}

CLICK ON FORWARD & REWIND BUTTON
   run keyword if  "${title}"=="SUNNXT::LIVE"  FORWARD VOD TO 30 SECONDS USING FORWARD BUTON
   sleep  ${stream_content}
   run keyword if  "${title}"=="SUNNXT::LIVE"  REWIND VOD TO 30 SECONDS USING REWIND BUTTON

FORWARD VOD TO 30 SECONDS USING FORWARD BUTON
    :for    ${index}    in range    3
     \   click element  ${forward_icon}

REWIND VOD TO 30 SECONDS USING REWIND BUTTON
    :for    ${index}    in range    3
     \   click element  ${rewind_icon}

CHANGE AUDIO STATUS (MUTE/UNMUTE)
    click element  ${volume_icon}

CHANGE QUALITY OF PLAYER
    ${title}=  get title
    run keyword if  "${title}"=="SUNNXT::LIVE"  CHANGE QUALITY OF LIVE TV PLAYER
    ...  ELSE  CHANGE QUALITY OF VOD PLAYER

CHANGE QUALITY OF VOD PLAYER
    wait until page contains element  ${vquality_option}
    :for    ${index}    in range    4
     \  sleep  ${stream_content}
     \  click element  ${quality_option}
     \   run keyword if  ${index}==0  click link  ${vquality_medium}
     \   run keyword if  ${index}==1  click link  ${vquality_auto}
     \   run keyword if  ${index}==2  click link  ${vquality_low}
     \   run keyword if  ${index}==3  click link  ${vquality_hd}

CHANGE QUALITY OF LIVE TV PLAYER
    wait until page contains element  ${quality_option}
    :for    ${index}    in range    7
     \  sleep  ${stream_content}
     \  click element  ${quality_option}
     \   run keyword if  ${index}==0  click link  ${lquality_180p160k}
     \   run keyword if  ${index}==1  click link  ${lquality_180p96k}
     \   run keyword if  ${index}==2  click link  ${lquality_180p288k}
     \   run keyword if  ${index}==3  click link  ${lquality_auto}
     \   run keyword if  ${index}==4  click link  ${lquality_360p1088k}
     \   run keyword if  ${index}==5  click link  ${lquality_270p544k}
     \   run keyword if  ${index}==6  click link  ${lquality_270p800k}

TURN SUBTITLE ON/OFF
    ${status}=  wait until page contains element  ${subtitle_option}
    log  ${status}
    run keyword if  "${status}"=="True"  TURN SUBTITLE OFF
    sleep  ${stream_content}
    run keyword if  "${status}"=="True"  TURN SUBTITLE ON

TURN SUBTITLE ON
    click element  ${subtitle_option}
    click element  ${subs_off}

TURN SUBTITLE OFF
    click element  ${subtitle_option}
    click element  ${subs_on}

#CHANGE SPEED OF VOD PLAYER
#    :for    ${index}    in range    5
#    \  sleep  ${stream}
#    \   click element  ${vgear_icon}
#    \   click element  ${vspeed_option}
#    \   run keywords if  ${index}==0  click element  ${vspeed_slow}
#    \   run keywords if  ${index}==1  click element  ${vspeed_fastersmooth}
#    \   run keywords if  ${index}==2  click element  ${vspeed_slow}
#    \   run keywords if  ${index}==3  click element  ${vspeed_faster}
#    \   run keywords if  ${index}==4  click element  ${vspeed_normal}

WAIT FOR CONTENT TO START STREAMING
   wait until page contains element  ${live_seekbar}