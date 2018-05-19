*** Settings ***
Documentation    Suite description
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_authentication.robot
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_common.robot

*** Keywords ***
SIGNUP
    [Arguments]  ${userid}  ${userpass}
    SELECT LANGUAGE AND PROCEED TO HOME-SCREEN
    ACCEPT IMEI SHARING
    DISMISS DISPLAYED COACH MARK
    TAP ON PROFILE BUTTON
    CLICK LOGIN TEXT
    CLICK ON SIGNUP LINK
    INPUT USER-ID  ${userid}
    INPUT SIGNUP PASSWORD  ${userpass}
    INPUT FULL NAME OF USER
    SELECT AGE OF USER
    SELECT GENDER OF USER
    SELECT RESIDING COUNTRY OF USER
    SELECT RESIDING STATE OF USER
    CLICK ON SUBMIT
    WAIT UNTIL NAVIGATED TO HOME-SCREEN