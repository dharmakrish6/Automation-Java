*** Settings ***
Documentation           Flow for Sign-in & Sign-up operation in Android Smartphone (to be used as Suite/Test Setup)
Resource                ../keywords/android_app/low_level_keywords/android_common.robot
Resource                ../keywords/android_app/low_level_keywords/android_authentication.robot
Resource                ../keywords/android_app/low_level_keywords/android_profile.robot

*** Keywords ***
Authenticate App
    [Arguments]  ${userid}  ${userpass}
    Select Language And Proceed To Home-Screen
    Accept Imei Sharing
    Dismiss Displayed Coach Mark
    Tap On Profile Button
    Click Login Text
    Enter User Id  ${userid}
    Enter Password  ${userpass}
    Click Login Button
    Wait Until Navigated To Home-Screen  ${userid}

Login Via App
    [Arguments]  ${userid}  ${userpass}
    Open Sunnxt App
    Select Language And Proceed To Home-Screen
    Accept Imei Sharing
    Dismiss Displayed Coach Mark
    Tap On Profile Button
    Click Login Text
    Enter User Id  ${userid}
    Enter Password  ${userpass}
    Click Login Button
    Wait Until Navigated To Home-Screen  ${userid}

Sign-up
    [Arguments]  ${userid}  ${userpass}
    Select Language And Proceed To Home-Screen
    Accept Imei Sharing
    Dismiss Displayed Coach Mark
    Tap On Profile Button
    Click Login Text
    Click On Signup/Signin Link
    Input User-Id  ${userid}
    Input Signup Password  ${userpass}
    Input Full Name Of User
    Select Age Of User
    Select Gender Of User
    Select Residing Country Of User
    Select Residing State Of User
    Click On Submit
    Wait Until Navigated To Home-Screen  ${userid}