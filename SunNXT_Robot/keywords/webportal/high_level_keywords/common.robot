*** Settings ***
Documentation    SunNXT Web-portal
Library          String
Resource         E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_common.robot

*** Keywords ***
Authenticate Web Portal
    [Arguments]  ${userid}  ${userpass}
    Click On Profile Authentication Icon
    Click On Sign In Link
    Enter Registered Credential  ${userid}
    Enter Password  ${userpass}
    Click On Login Button
    Validate Sign-In

Login Into Web Portal
    [Arguments]  ${userid}  ${userpass}
    Open Chrome Browser
    Click On Profile Authentication Icon
    Click On Sign In Link
    Enter Registered CREDENTIAL  ${userid}
    Enter Password  ${userpass}
    Click On Login Button
    Validate Sign-In
    sleep  5s
