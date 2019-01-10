*** Settings ***
Documentation       Suite description
Resource            keywords/android_app/low_level_keywords/android_common.robot
Resource            keywords/android_app/low_level_keywords/android_profile.robot
Resource            keywords/android_app/low_level_keywords/android_edit_profile.robot
Resource            keywords/android_app/low_level_keywords/android_authentication.robot
Resource            keywords/android_app/high_level_keywords/authentication.robot

*** Keywords ***
Change Password and Login Via New Password
    [Arguments]  ${user_type}
    Authenticate App  ${user_type}
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Tap On Edit Profile
    Verify User Type Is Primary
    Tap On Change Password
    Change Password  ${user_type}
    Save Edited Changes
    wait until page contains element  ${profile_button}  timeout=15
    Swipe Down
    Tap On Logout Text
    Accept Alert
    Check Whether App Has Navigated To Home Screen Or Not
    Tap On Profile Button
    Click Login Text
    Enter User Id  ${user_type}
    Enter Password  ${user_type}
    Click Login Button
    Wait Until Navigated To Home-Screen  ${user_type}