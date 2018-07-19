*** Settings ***
Documentation           Contains keywords related to streaming of content
Library                 AppiumLibrary  run_on_failure=Capture Page Screenshot
Resource                ../locators/android_app/player.robot
Resource                ../locators/android_app/common.robot
Resource                ../locators/android_app/content.robot
Resource                ../locators/android_app/videodetails_screen.robot
Resource                ../keywords/android_app/low_level_keywords/android_common.robot

*** Keywords ***
Gear
    wait until page contains element  ${btn_gear}
    click element  ${btn_gear}

Wait Until Ad Streams
#    wait until page does not contain element  ${loading_animation}  timeout=15
    ${status}=  run keyword and return status  wait until page contains  ${btn_visitAdvertiser}
    run keyword if  "${status}"=="True"  sleep  30s

Start Streaming
    ${status}=  run keyword and return status  page should contain element  ${btn_play}
    run keyword if  "${status}"=="True"  click element  ${btn_play}

Wait Until Content Is Ready To Stream
    wait until page contains element  ${seek_bar}  timeout=15s
    tap  ${player_frame}
    wait until element is visible  ${btn_play_pause}
    ${content_streamed}=  get text  ${content_title}
    set global variable  ${content_streamed}


Rewind Content To 30 Secs
     :FOR    ${index}    IN RANGE    3
     \  run keyword  WAIT UNTIL AD STREAMS
     \  tap  ${player_frame}
     \  click element  ${btn_seek_left}

Forward Content To 30 Secs
        :FOR    ${index}    IN RANGE    3
     \  run keyword  WAIT UNTIL AD STREAMS
     \  tap  ${player_frame}
     \  click element  ${btn_seek_right}

Enable/Disable Subtitle
   ${present} =  Run Keyword And Return Status  page should contain element  ${btn_subtitle}
   run keyword if  "${present}"=="True"  click element  ${btn_subtitle}

Change VOD Quality
    :FOR  ${index}  IN RANGE  4
    \  click element  id=com.suntv.sunnxt:id/fragment_carousel_view_all
    \  run keyword  WAIT UNTIL AD STREAMS
    \  tap  ${player_frame}
    \  run keyword  GEAR
    \  run keyword if  ${index}==0  click text  ${medium}
    \  run keyword if  ${index}==1  click text  ${hd}
    \  run keyword if  ${index}==2  click text  ${auto}
    \  run keyword if  ${index}==3  click text  ${low}
    \  sleep  10s

Switch To Full Screen
    click element  ${btn_fullscreen}

Stream Content And Check Playback Controls
    Dismiss Displayed Coach Mark
    Wait Until Content Is Ready To Stream
    Wait Until Ad Streams
    Dismiss Displayed Coach Mark
    Forward Content To 30 Secs
    Enable/Disable Subtitle
    Switch To Full Screen
    Rewind Content To 30 Secs
    Enable/Disable Subtitle
    Change Vod Quality