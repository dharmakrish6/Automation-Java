*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Keyword/Common.robot
Resource         ../Keyword/Content/HomePage.robot
Resource         ../Keyword/Player.robot
Resource         ../Keyword/VOD-DetailsScreen.robot
Resource         ../Variable/Variables.robot

*** Test Cases ***
TestCase 03: Login valid credentials and stream a movie
    [Documentation]     This is to verify valid login for SunNXT web-page and logout
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
        Click on 1st Carousel Indicator
        sleep       2s
        Click on 1st Carousel Content
        Click on Play button
        Change Quality of VOD Player
        Forward VOD to 30 seconds
        Turn OFF subtitle
        Rewind VOD to 30 seconds
        Turn ON subtitle
        Change audio status (mute/unmute)
        Click on Profile button
        Click on logout link
    [Teardown]
        Close Browser