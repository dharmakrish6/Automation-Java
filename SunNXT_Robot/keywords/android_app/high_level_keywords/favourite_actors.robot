*** Settings ***
Documentation    Suite description
Resource            keywords/android_app/low_level_keywords/android_common.robot
Resource            keywords/android_app/low_level_keywords/android_videodetailsscreen.robot
Resource            keywords/android_app/low_level_keywords/android_profile.robot
Resource            keywords/android_app/high_level_keywords/authentication.robot
Resource            keywords/android_app/low_level_keywords/android_keystrokes.robot

*** Keywords ***
Add Actor/Actress To Favourite List
    [Arguments]  ${user_type}  ${content_language}  ${content_header}
    Authenticate App  ${user_type}
    Navigate To Change Content Language
    Select Content Language  ${content_language}
    Select Content Tab  ${content_header}
    Navigate To Content Details Screen  ${content_language}  ${content_header}
    Dismiss Displayed Coach Mark
    Navigate To Starcast
    Add Actor/Actress To Favourite
    go back
    Check If Navigated To Video Details Screen
    go back
#    Press Back Button
    wait until page contains   ${content_name}  timeout=15
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Swipe Down
    Tap On Favourite Actors