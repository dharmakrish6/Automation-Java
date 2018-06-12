*** Settings ***
Documentation           Contains keywords for operations performed on Live TV and VOD Player
Library                 SeleniumLibrary
Library                 BuiltIn
Resource                E:/Automation-Java/SunNXT_Robot/locators/webportal/player.robot
Resource                E:/Automation-Java/SunNXT_Robot/test_data/web_portal/timeout.robot

*** Keywords ***
Click On Play Button
    click element  ${playbtn}
    sleep   ${stream_content}

Stream In Full-Screen Mode
    wait until page contains element  ${fullscreen}  timeout=20
    click element  ${fullscreen}

Click On Forward & Rewind Button
   ${title}=  get title
   run keyword if  "${title}"!="SUNNXT::LIVE"  Forward Vod To 30 Seconds Using Forward Buton
   sleep  ${stream_content}
   run keyword if  "${title}"!="SUNNXT::LIVE"  Rewind Vod To 30 Seconds Using Rewind Button

Forward Vod To 30 Seconds Using Forward Button
    :for    ${index}    in range    3
     \   click element  ${forward_icon}

Rewind Vod To 30 Seconds Using Rewind Button
    :for    ${index}    in range    3
     \   click element  ${rewind_icon}

Change Audio Status (Mute/Unmute)
    click element  ${volume_icon}

Change Quality Of Player
    ${title}=  get title
    run keyword if  "${title}"=="SUNNXT::LIVE"  Change Quality Of Live Tv Player
    run keyword if  "${title}"!="SUNNXT::LIVE"  Change Quality Of Vod Player

Change Quality Of Vod Player
    wait until page contains element  ${quality_option}
    :for    ${index}    in range    4
     \  sleep  ${stream_content}
     \  click element  ${quality_option}
     \   run keyword if  ${index}==0  click link  ${vquality_medium}
     \   run keyword if  ${index}==1  click link  ${vquality_auto}
     \   run keyword if  ${index}==2  click link  ${vquality_low}
     \   run keyword if  ${index}==3  click link  ${vquality_hd}

Change Quality Of Live Tv Player
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

Turn Subtitle On/Off
    ${status}=  wait until page contains element  ${subtitle_option}
    log  ${status}
    run keyword if  "${status}"=="True"  TURN SUBTITLE OFF
    sleep  ${stream_content}
    run keyword if  "${status}"=="True"  TURN SUBTITLE ON

Turn Subtitle On
    click element  ${subtitle_option}
    click element  ${subs_off}

Turn Subtitle Off
    click element  ${subtitle_option}
    click element  ${subs_on}

#Change Speed Of Vod Player
#    :for    ${index}    in range    5
#    \  sleep  ${stream}
#    \   click element  ${vgear_icon}
#    \   click element  ${vspeed_option}
#    \   run keywords if  ${index}==0  click element  ${vspeed_slow}
#    \   run keywords if  ${index}==1  click element  ${vspeed_fastersmooth}
#    \   run keywords if  ${index}==2  click element  ${vspeed_slow}
#    \   run keywords if  ${index}==3  click element  ${vspeed_faster}
#    \   run keywords if  ${index}==4  click element  ${vspeed_normal}

Wait For Content To Start Streaming
   wait until page contains element  ${seekbar}