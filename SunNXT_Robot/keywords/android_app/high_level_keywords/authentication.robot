*** Settings ***
Documentation       Suite description
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_common.robot
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_authentication.robot

*** Keywords ***
AUTHENTICATE APP
    [Arguments]  ${userid}  ${userpass}
    SELECT LANGUAGE AND PROCEED TO HOME-SCREEN
    ACCEPT IMEI SHARING
    DISMISS DISPLAYED COACH MARK
    TAP ON PROFILE BUTTON
    CLICK LOGIN TEXT
    ENTER USER ID  ${userid}
    ENTER PASSWORD  ${userid}  ${userpass}
    CLICK LOGIN BUTTON
    WAIT UNTIL NAVIGATED TO HOME-SCREEN

SIGNUP
    [Arguments]  ${userid}  ${userpass}
    ACCEPT IMEI SHARING

LOGIN VIA APP
    [Arguments]  ${userid}  ${userpass}
    OPEN SUNNXT APP
    SELECT LANGUAGE AND PROCEED TO HOME-SCREEN
    ACCEPT IMEI SHARING
    DISMISS DISPLAYED COACH MARK
    TAP ON PROFILE BUTTON
    CLICK LOGIN TEXT
    ENTER USER ID  ${userid}
    ENTER PASSWORD  ${userid}  ${userpass}
    CLICK LOGIN BUTTON
    WAIT UNTIL NAVIGATED TO HOME-SCREEN