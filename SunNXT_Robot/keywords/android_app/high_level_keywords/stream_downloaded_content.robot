*** Settings ***
Documentation           Flow to download any content in android smatphone
Resource                keywords/android_app/low_level_keywords/android_common.robot
Resource                keywords/android_app/low_level_keywords/android_stream_vod.robot
Resource                keywords/android_app/low_level_keywords/android_downloads.robot
Resource                keywords/android_app/low_level_keywords/android_videodetailsscreen.robot
Resource                keywords/android_app/low_level_keywords/android_profile.robot
Resource            keywords/android_app/high_level_keywords/authentication.robot

*** Keywords ***
Download Video And Stream It
    [Arguments]  ${content_language}  ${content_header}  ${download_quality}
    Authenticate App  ID_Email_Subs
    Navigate To Change Content Language
    Select Content Language  ${content_language}
    Select Content Tab  ${content_header}
    Navigate To Content Details Screen  ${content_language}  ${content_header}
    Dismiss Displayed Coach Mark
    Start Streaming
    Wait Until Content Is Ready To Stream
    Click Download Button
    Select Download Quality  ${download_quality}
    Go Back
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Tap On Download
    Check If Download Is Completed Or Not
    Go Back
    Set Network Connection Status  0
    Tap On Download
    Stream Downloaded Content