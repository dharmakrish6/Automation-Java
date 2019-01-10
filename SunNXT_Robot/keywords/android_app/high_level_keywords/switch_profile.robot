*** Settings ***
Documentation       Suite description
Resource            keywords/android_app/low_level_keywords/android_common.robot
Resource            keywords/android_app/low_level_keywords/android_switch_profile.robot
Resource            keywords/android_app/low_level_keywords/android_profile.robot
Resource            keywords/android_app/high_level_keywords/authentication.robot

*** Keywords ***
Switch Profile
    [Arguments]  ${profile_type}
    Authenticate App  ID_Email_Subs
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Tap On Switch Profile
    sleep  5
    get source
    Switch To Desired Profile  ${profile_type}
    Tap On Profile Button
    Tap On Switch Profile
    Veirfy The Selected Profile