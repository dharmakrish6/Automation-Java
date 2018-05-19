*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Keyword/Common.robot
Resource         ../Keyword/Player.robot
Resource         ../Keyword/Subscription.robot
Resource         ../Locators/SunNXThome.robot
Resource         ../Keyword/Content/HomePage.robot
Resource         ../Keyword/VOD-DetailsScreen.robot
Resource         ../Keyword/Profile.robot
Resource         ../Variable/Variables.robot

*** Test Cases ***
TestCase 08: Stream a content and check whether it is available in continue watching section or not
    [Documentation]     This is to verify whether streamed content is available in continue watching section or not
    [Tags]              Regression
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
        sleep       60s
        Click on Content-carousel in row 7
        Record streamed content
        Play and pause content
        Click on Profile icon
        Click on Profile link
        sleep  5s
        Record Latest content in continue watching
        Check if streamed content is added in continue watching section or not
    [Teardown]
        Close Browser