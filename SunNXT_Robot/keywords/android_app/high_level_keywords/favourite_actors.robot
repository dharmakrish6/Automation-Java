*** Settings ***
Documentation    Suite description
Resource            ../keywords/android_app/low_level_keywords/android_common.robot
Resource            ../keywords/android_app/low_level_keywords/android_videodetailsscreen.robot
Resource            ../keywords/android_app/low_level_keywords/android_profile.robot

*** Keywords ***
Add Actor/Actress To Favourite List
    [Arguments]  ${content_language}  ${content_tab}  ${carousel_title}  ${content_name}
    Select Content Language  ${content_language}
    Select Content Tab  ${content_tab}
    Navigate To Content Details Screen  ${carousel_title}  ${content_name}
    Dismiss Displayed Coach Mark
    Navigate To Starcast
    Add Actor/Actress To Favourite
    go back
    go back
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Tap On Favourite Actors