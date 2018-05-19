*** Settings ***
Documentation       Suite description
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_stream_vod.robot

*** Keywords ***
STREAM A VOD
    [Arguments]  ${carousel_title}  ${content_name}
    NAVIGATE TO CONTENT DETAILS SCREEN  ${carousel_title}  ${content_name}
    STREAM CONTENT AND CHECK PLAYBACK CONTROLS
    GO BACK
    sleep  10

STREAM CONTENT AND CHECK PLAYBACK CONTROLS
    DISMISS DISPLAYED COACH MARK
    WAIT UNTIL CONTENT IS READY TO STREAM
    WAIT UNTIL AD STREAMS
    DISMISS DISPLAYED COACH MARK
    FORWARD CONTENT TO 30 SECS
    ENABLE/DISABLE SUBTITLE
    SWITCH TO FULL SCREEN
    REWIND CONTENT TO 30 SECS
    ENABLE/DISABLE SUBTITLE
    CHANGE VOD QUALITY