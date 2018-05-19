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
*** Test Cases ***
TestCase 07: Try to stream free-tag content using a credential with no active subsription
    [Documentation]     This is to verify whether user with no active subscription can stream free-tag content or not
    [Tags]              Content Streaming
    [Setup]
        Open Browser
        Navigate to SunNXT web-portal
        Verify the homepage title
        Click on Profile authentication icon
        Click on Sign In link from dropdown
        sleep       2s
        Enter UserID with no subscription
        Enter Password
        sleep       1s
        Click on Submit button
        sleep       ${timeout}
        Click on Free-tag content
        Wait for content to start streaming
    [Teardown]
        Close Browser