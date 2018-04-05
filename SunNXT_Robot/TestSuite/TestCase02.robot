*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Keyword/Common.robot
Resource         ../Keyword/Search.robot

*** Test Cases ***
TestCase 2: Login and search for a movie, tv show and music video
    [Documentation]     This is to verify whether Search functionality is working or not
    [Tags]              Basic
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
        Click on Search icon
        Click on Search box
        Enter Search query for movie
        sleep       ${timeout}
        Check whether searched content is available in search results
    [Teardown]
        Close Browser

*** Keywords ***
Check whether searched content is available in search results
    Page Should Contain   Mass Engira Masilamani