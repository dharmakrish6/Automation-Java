*** Settings ***
Documentation    Suite description
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_authentication.robot
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_common.robot

*** Keywords ***
Sign-up
    [Arguments]  ${userid}  ${userpass}
    Select Language And Proceed To Home-Screen
    Accept Imei Sharing
    Dismiss Displayed Coach Mark
    Tap On Profile Button
    Click Login Text
    Click On Signup Link
    Input User-Id  ${userid}
    Input Signup Password  ${userpass}
    Input Full Name Of User
    Select Age Of User
    Select Gender Of User
    Select Residing Country Of User
    Select Residing State Of User
    Click On Submit
    Wait Until Navigated To Home-Screen
