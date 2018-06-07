*** Settings ***
Documentation       Suite description
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_stream_vod.robot

*** Keywords ***
Stream A Vod
    [Arguments]  ${content_language}  ${content_header}  ${carousel_title}  ${content_name}
    Select Content Language  ${content_language}
    Select Content Tab  ${content_header}
    Navigate To Content Details Screen  ${carousel_title}  ${content_name}
    Stream Content And Check Playback Controls
    Go Back

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
