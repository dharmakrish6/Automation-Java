*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Keyword/Common.robot
Resource         ../Keyword/Player.robot
Resource         ../Locators/SunNXThome.robot

*** Test Cases ***
TestCase 1: Login valid credentials and Logout
    [Documentation]     This is to verify valid login for SunNXT web-page and logout
    [Tags]               Smoke
    [Setup]
        Open Browser
        Navigate to SunNXT web-portal
        Verify the homepage title
        Click on Profile authentication icon
        Click on Sign In link from dropdown
        sleep       2s
        Enter UserID
        Enter Password
        sleep       1s
        Click on Submit button
        sleep       ${timeout}
        Click on Profile button
        Click on Logout link
    [Teardown]
        Close Browser