*** Settings ***
Documentation       Suite description
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_common.robot
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_authentication.robot
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_profile.robot

*** Keywords ***
Authenticate App
    [Arguments]  ${userid}  ${userpass}
    Select Language And Proceed To Home-Screen
    Accept Imei Sharing
    Dismiss Displayed Coach Mark
    Tap On Profile Button
    Click Login Text
    Enter User Id  ${userid}
    Enter Password  ${userid}  ${userpass}
    Click Login Button
    Wait Until Navigated To Home-Screen

#Signup
#    [Arguments]  ${userid}  ${userpass}
#    Accept Imei Sharing

Login Via App
    [Arguments]  ${userid}  ${userpass}
    Open Sunnxt App
    Select Language And Proceed To Home-Screen
    Accept Imei Sharing
    Dismiss Displayed Coach Mark
    Tap On Profile Button
    Click Login Text
    Enter User Id  ${userid}
    Enter Password  ${userid}  ${userpass}
    Click Login Button
    Wait Until Navigated To Home-Screen