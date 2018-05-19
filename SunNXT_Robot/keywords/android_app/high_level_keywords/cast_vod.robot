*** Settings ***
Documentation
Resource                E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_cast_vod.robot
Resource                E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_stream_vod.robot
Resource                E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_common.robot

*** Keywords ***
CAST VIDEO TO CASTING DEVICE
    [Arguments]  ${carousel_title}  ${content_name}
    NAVIGATE TO CONTENT DETAILS SCREEN  ${carousel_title}  ${content_name}
    DISMISS DISPLAYED COACH MARK
    WAIT UNTIL CONTENT IS READY TO STREAM
#    WAIT UNTIL AD STREAMS
#    DISMISS DISPLAYED COACH MARK
    VERIFY IF CHROMECAST IS PRESENT
    CAST TO DEVICE
    sleep  20