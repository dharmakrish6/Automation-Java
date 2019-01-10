*** Settings ***
Documentation    Suite description
Resource            keywords/android_app/low_level_keywords/android_videodetailsscreen.robot
Resource            keywords/android_app/low_level_keywords/android_profile.robot
Resource            keywords/android_app/low_level_keywords/android_stream_vod.robot
Resource            keywords/android_app/low_level_keywords/android_common.robot
Resource            keywords/android_app/high_level_keywords/authentication.robot

*** Keywords ***
Add Content To Watch List
    [Arguments]  ${user_type}  ${content_language}  ${content_header}
    Authenticate App  ${user_type}
    Navigate To Change Content Language
    Select Content Language  ${content_language}
    Select Content Tab  ${content_header}
    Navigate To Content Details Screen  ${content_language}  ${content_header}
    Dismiss Displayed Coach Mark
    Start Streaming
    Wait Until Ad Streams
    Wait Until Content Is Ready To Stream
    Dismiss Displayed Coach Mark
    Add Content To Favourite
    Go Back
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Tap On Watchlist
    Verify If Content Bas Been Added Or Not