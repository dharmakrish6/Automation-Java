*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Keyword/Common.robot
Resource         ../Keyword/Content/HomePage.robot
Resource         ../Keyword/Signup.robot

*** Test Cases ***
TestCase 4: Sign Up as a new user
    [Documentation]     This is to verify whether user is able to signup using a new e-mail ID or not
    [Tags]              Smoke
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
        Check whether user is navigated to Homepage or not
    [Teardown]
        Close Browser