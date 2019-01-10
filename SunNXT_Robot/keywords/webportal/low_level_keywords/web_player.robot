*** Settings ***
Documentation           Contains keywords for operations performed on Live TV and VOD Player
Library                 SeleniumLibrary
Library                 venv/Lib/site-packages/robot/libraries/String.py
Library                 BuiltIn
Resource                locators/webportal/player.robot
Resource                test_data/web_portal/timeout.robot

*** Keywords ***
Click On Play Button
    click element  ${playbtn}
    sleep   ${stream_content}

Exit Full-Screen Mode
    ${player_status}=  get element attribute  css=[webkit-playsinline]  class
    ${status}=  run keyword and return status  should contain  ${player_status}  is-fullscreen
    run keyword if  "${status}"=="True"  Click On Full-Screen Button

Click On Full-Screen Button
    mouse over  ${playback_controls}
    wait until element is visible  ${fullscreen}  timeout=${extended_wait}
    click element  ${fullscreen}


Click On Forward & Rewind Button
   ${title}=  get title
   ${status}=  run keyword and return status  should contain  ${title}  Live
   mouse over  ${playback_controls}
   wait until element is visible  ${controls_bottom_left}  timeout=${extended_wait}
   run keyword if  "${status}"=="Fail"  Forward Vod To 30 Seconds Using Forward Buton
   sleep  ${stream_content}
   mouse over  ${playback_controls}
   run keyword if  "${status}"=="Fail"  Rewind Vod To 30 Seconds Using Rewind Button

Forward Vod To 30 Seconds Using Forward Button
    :for    ${index}    in range    3
     \   click element  ${forward_icon}

Rewind Vod To 30 Seconds Using Rewind Button
    :for    ${index}    in range    3
     \   click element  ${rewind_icon}

Change Audio Status (Mute/Unmute)
    mouse over  ${playback_controls}
    wait until element is visible  ${volume_icon}  timeout=${extended_wait}
    click element  ${volume_icon}

Change Quality Of Player
    ${title}=  get title
    ${status}=  run keyword and return status  should contain  ${title}  ${title_liveTV}
    run keyword if  "${status}"=="True"  Change Quality Of Live Tv Player
    ...  ELSE  Change Quality Of Vod Player

Change Quality Of Vod Player
    wait until page contains element  ${quality_option}
    :for    ${index}    in range    4
     \  sleep  ${stream_content}
     \  mouse over  ${playback_controls}
     \  click element  ${quality_option}
     \   run keyword if  ${index}==0  click link  ${vquality_medium}
     \   run keyword if  ${index}==1  click link  ${vquality_auto}
     \   run keyword if  ${index}==2  click link  ${vquality_low}
     \   run keyword if  ${index}==3  click link  ${vquality_hd}

Check If Channel Being Streamed Is HD Supported Or Not
    ${channel_being_played}=  get text  ${channel_name}
    ${test_php}=  get element attribute  css= body > script:nth-child(6)  PHP.data
    ${channel_type}=  run keyword and return status  should contain  ${channel_being_played}  HD
    set global variable  ${channel_type}

Change Quality Of Live Tv Player
    wait until page contains element  ${quality_option}
    :for    ${index}    in range    7
     \  sleep  ${stream_content}
     \  mouse over  ${playback_controls}
     \  click element  ${quality_option}
     \   run keyword if  ${index}==0  click link  ${lquality_180p160k}
     \   run keyword if  ${index}==1  click link  ${lquality_180p96k}
     \   run keyword if  ${index}==2  click link  ${lquality_180p288k}
     \   run keyword if  ${index}==3  click link  ${lquality_auto}
     \   run keyword if  ${index}==4 and "${channel_type}"=="Pass"  click link  ${lquality_360p1088k}
     \   run keyword if  ${index}==5 and "${channel_type}"=="Pass"  click link  ${lquality_270p544k}
     \   run keyword if  ${index}==6 and "${channel_type}"=="Pass"  click link  ${lquality_270p800k}

Turn Subtitle On/Off
    ${status}=  run keyword and return status  element should be visible  ${subtitle_option}
    run keyword if  "${status}"=="True"  TURN SUBTITLE ON
    Click Seekbar At Different Positions
    run keyword if  "${status}"=="True"  TURN SUBTITLE OFF

Click Seekbar At Different Positions
    ${progressbar_length}=  get horizontal position  ${progressbar}
    ${progressbar_height}=  get vertical position  ${progressbar}
    :for    ${index}    in range    1  5
    \  ${progressbar_seek}=  evaluate  ${progressbar_length} * ${progressbar_height} * ${index}
    \  mouse over  ${playback_controls}
    \  click element at coordinates  ${progressbar}  ${progressbar_seek}  ${progressbar_height}
    \  capture page screenshot
    \  sleep  5
    \  ${status}=  run keyword and return status  element should be visible  ${subtitle}
    \  run keyword if  "${status}"=="True"  log many  SUBTITLE WAS DISPLAYED WHILE IN ${index} LOOP


Turn Subtitle On
    mouse over  ${playback_controls}
    click element  ${subtitle_option}
    click link  ${subs_off}

Turn Subtitle Off
    mouse over  ${playback_controls}
    click element  ${subtitle_option}
    click link    ${subs_on}

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
   ${status}=  run keyword and return status  page should contain element  ${ad_msg}
   run keyword if  "${status}"=="True"  sleep  4
   wait until page contains element  ${seekbar}

Check For Any Player Error Message
    ${status}=  run keyword and return status  page should contain element  ${player_error}
    run keyword if  "${status}"=="True"  Error Message

Error Message
    ${error}=  get text  ${player_error}
    set test message  ERROR ENCOUNTERED WHILE STREAMING CONTENT ${content_name}. ERROR MESSAGE DISPLAYED IS '${error}'.
    fail