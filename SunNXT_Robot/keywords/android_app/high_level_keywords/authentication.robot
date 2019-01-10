*** Settings ***
Documentation           Flow for Sign-in & Sign-up operation in Android Smartphone (to be used as Suite/Test Setup)
Library                 AppiumLibrary
Resource                keywords/android_app/low_level_keywords/android_common.robot
Resource                keywords/android_app/low_level_keywords/android_authentication.robot
Resource                keywords/android_app/low_level_keywords/android_profile.robot

*** Keywords ***
Authenticate App
    [Arguments]  ${user_type}
    Select Language And Proceed To Home-Screen
    Accept Imei Sharing
    Dismiss Displayed Coach Mark
    Tap On Profile Button
    Click Login Text
    Enter User Id  ${user_type}
    Enter Password  ${user_type}
    Click Login Button
    Wait Until Navigated To Home-Screen  ${user_type}

Sign-up
    [Arguments]  ${user_type}
    Select Language And Proceed To Home-Screen
    Accept Imei Sharing
    Dismiss Displayed Coach Mark
    Tap On Profile Button
    Click Login Text
    Click On Signup/Signin Link
    Input User-Id  ${user_type}
    Input Signup Password  ${user_type}
    Input Full Name Of User  ${user_type}
    Select Age Of User  ${user_type}
    Select Gender Of User  ${user_type}
    Select Residing Country Of User  ${user_type}
    Select Residing State Of User  ${user_type}
    Click On Submit

    Wait Until Navigated To Home-Screen  ${user_type}