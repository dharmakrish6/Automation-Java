*** Settings ***
Documentation       Flow to stream a content whose title is provided in test-case (to be used in Suite/Test Setup)
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_stream_vod.robot

*** Keywords ***
Navigate To And Stream Any Content
    [Arguments]  ${content_language}  ${content_header}  ${carousel_title}  ${content_name}
    Select Content Language  ${content_language}
    Select Content Tab  ${content_header}
    Navigate To Content Details Screen  ${carousel_title}  ${content_name}
    Stream Content And Check Playback Controls
    Go Back


