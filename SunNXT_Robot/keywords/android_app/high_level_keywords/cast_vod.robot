*** Settings ***
Documentation           Flow to cast any content to attached casting device from android smartphone
Resource                ../keywords/android_app/low_level_keywords/android_cast_vod.robot
Resource                ../keywords/android_app/low_level_keywords/android_stream_vod.robot
Resource                ../keywords/android_app/low_level_keywords/android_common.robot

*** Keywords ***
Cast Video To Casting Device
    [Arguments]  ${content_language}  ${content_header}  ${carousel_title}  ${content_name}
    Select Content Language  ${content_language}
    Select Content Tab  ${content_header}
    Navigate To Content Details Screen  ${carousel_title}  ${content_name}
    Dismiss Displayed Coach Mark
    Start Streaming
    Wait Until Content Is Ready To Stream
#    Wait Until Ad Streams
#    Dismiss Displayed Coach Mark
    Verify If Chromecast Is Present
    Cast To Device
    Sleep  20
