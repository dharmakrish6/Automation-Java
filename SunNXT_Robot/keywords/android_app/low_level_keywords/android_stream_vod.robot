*** Settings ***
Documentation    Suite description
Library          AppiumLibrary  30  run_on_failure=Capture Page Screenshot
Resource         E:/Automation-Java/SunNXT_Robot/locators/android_app/player.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/android_app/common.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/android_app/content.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/android_app/videodetails_screen.robot
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_common.robot

*** Keywords ***
GEAR
    wait until page contains element  ${btn_gear}
    click element  ${btn_gear}

WAIT UNTIL AD STREAMS
    ${status}=  run keyword and return status  page should contain text  ${btn_visitAdvertiser}
    run keyword if  "${status}"=="True"  sleep  30s

WAIT UNTIL CONTENT IS READY TO STREAM
    wait until page contains element  ${seek_bar}
#    click element  ${btn_play}
#    wait until page contains element  ${btn_play_pause}  timeout=10
    wait until element is visible  ${btn_play_pause}
    ${content_streamed}=  get text  ${content_title}
    log many  ${content_title}


REWIND CONTENT TO 30 SECS
     :FOR    ${index}    IN RANGE    3
     \  run keyword  WAIT UNTIL AD STREAMS
     \  tap  ${player_frame}
     \  click element  ${btn_seek_left}

FORWARD CONTENT TO 30 SECS
        :FOR    ${index}    IN RANGE    3
     \  run keyword  WAIT UNTIL AD STREAMS
     \  tap  ${player_frame}
     \  click element  ${btn_seek_right}

ENABLE/DISABLE SUBTITLE
   ${present} =  Run Keyword And Return Status  page should contain element  ${btn_subtitle}
   run keyword if  "${present}"=="True"  click element  ${btn_subtitle}

CHANGE VOD QUALITY
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

SWITCH TO FULL SCREEN
    click element  ${btn_fullscreen}

NAVIGATE TO CONTENT DETAILS SCREEN
    [Arguments]  ${carousel_title}  ${content_name}
    :for  ${swiping}  in range  1000
    \  ${status}=  run keyword and return status  page should contain text  ${carousel_title}
    \  run keyword if  "${status}"=="False"  swipe by percent  50  40  50  10
    \  continue for loop if  "${status}"=="False"
    \  ${status}=  run keyword and return status  page should contain text  ${content_name}
    \  run keyword if  "${status}"=="False"  swipe by percent  50  40  50  10
    \  wait until page contains  ${content_name}  timeout=10
    \  click text  ${content_name}
    \  exit for loop