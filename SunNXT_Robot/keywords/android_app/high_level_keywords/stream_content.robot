*** Settings ***
Documentation       Flow to stream a content whose title is provided in test-case (to be used in Suite/Test Setup)
Resource            keywords/android_app/low_level_keywords/android_stream_vod.robot
Resource            keywords/android_app/low_level_keywords/android_common.robot
Resource            keywords/android_app/high_level_keywords/authentication.robot

*** Keywords ***
Navigate And Stream Any Content
    [Arguments]  ${content_language}  ${content_header}
    Authenticate App  ID_Mobile_Subs
    Navigate To Change Content Language
    Select Content Language  ${content_language}
    Select Content Tab  ${content_header}
    Navigate To Content Details Screen  ${content_language}  ${content_header}
    Dismiss Displayed Coach Mark
    Stream Content And Check Playback Controls
    Go Back


