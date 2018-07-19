*** Settings ***
Documentation       Suite description
Resource            ../keywords/android_app/low_level_keywords/android_common.robot
Resource            ../keywords/android_app/low_level_keywords/android_profile.robot
Resource            ../keywords/android_app/low_level_keywords/android_edit_profile.robot
Resource            ../keywords/android_app/low_level_keywords/android_authentication.robot

*** Keywords ***
Change Password and Login Via New Password
    [Arguments]  ${current_password}  ${new_password}  ${userid}
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Tap On Edit Profile
    Verify User Type Is Primary
    Tap On Change Password
    Change Password  ${current_password}  ${new_password}
    Save Edited Changes
    Swipe Down
    Tap On Logout Text
    Accept Alert Message
    Check Whether App Has Navigated To Home Screen Or Not
    Tap On Profile Button
    Click Login Text
    Enter User Id  ${userid}
    ${userpass}=  ${new_password}
    Enter Password  ${userpass}
    Click Login Button
    Wait Until Navigated To Home-Screen