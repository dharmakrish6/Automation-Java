*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Keyword/Common.robot
Resource         ../Keyword/Content/HomePage.robot
Resource         ../Keyword/Player.robot
Resource         ../Keyword/VOD-DetailsScreen.robot
Resource         ../Keyword/Content/HomePage.robot
Resource         ../Variable/Variables.robot

*** Test Cases ***
TestCase 09: Login with valid credentials and stream a Live TV channel
    [Documentation]     This is to verify whether Live TV Channel streams and their playback controls are accessible or not
    [Tags]              Content Streaming
    [Setup]
        Open Browser
        Navigate to SunNXT web-portal
        Verify the homepage title
        Click on Profile authentication icon
        Click on Sign In link from dropdown
        sleep       1s
        Enter UserID
        Enter Password
        sleep       1s
        Click on Submit button
        sleep       ${timeout}
        Click on Live TV header link
        Change Quality of Live TV Player
        Change audio status (mute/unmute)
        Click on Profile button
        Click on logout link
    [Teardown]
        Close Browser