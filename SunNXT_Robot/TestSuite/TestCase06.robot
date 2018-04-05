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
TestCase 6: Try to stream using a credential with no active subsription
    [Documentation]     This is to verify whether user with no active subscription is restricted to stream content or not
    [Tags]               Sanity
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
        Click on Content-carousel in row 1
        Click on Play button for Live TV
        Check whether subscription pop-up is displayed or not
    [Teardown]
        Close Browser