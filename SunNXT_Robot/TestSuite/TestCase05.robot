*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Keyword/Common.robot
Resource         ../Locators/SunNXThome.robot
Resource         ../Keyword/Signup.robot

*** Test Cases ***
TestCase 5: Signup using an already registered credential
    [Documentation]     This is to verify whether user is restricted to signup using a already registered credential or not
    [Tags]               Smoke
    [Setup]
        Open Browser
        Navigate to SunNXT web-portal
        Verify the homepage title
        Click on Profile authentication icon
        Click on Sign In link from dropdown
        Click on Sign-Up link
        Enter new user UserID
        Enter new user Password
        Enter name of the user
        Select age of the person
        Select gender as male
        Select residing country of the user
        Select residing state of the user
        Click 'Agree Terms' checkbox
        Click on Submit button to create new credential
        Error Message displayed is:

    [Teardown]
        Close Browser