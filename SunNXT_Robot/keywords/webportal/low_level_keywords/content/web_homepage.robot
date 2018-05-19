*** Settings ***
Library          SeleniumLibrary
Library          BuiltIn
Resource         E:/Automation-Java/SunNXT_Robot/locators/webportal/content/content_home.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/webportal/content/content_movies.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/webportal/homepage.robot

*** Keywords ***
CLICK ON 1ST CAROUSEL INDICATOR
    wait until page contains element  ${carousel_one}
    double click element  ${cindicator_one}

CLICK ON 1ST CAROUSEL CONTENT
    wait until page contains element  ${carousel_one}
    click element  ${carousel_one}

CLICK ON 4TH CAROUSEL INDICATOR
    wait until page contains element  ${carousel_four}
    double click element  ${cindicator_four}

CLICK ON 4TH CAROUSEL CONTENT
    wait until page contains element  ${carousel_four}
    click element  ${carousel_four}

CLICK ON FREE-TAG CONTENT
    wait until page contains element  ${#0_content3}
    click element  ${#0_content3}

CLICK ON CONTENT-CAROUSEL IN ROW 1
    wait until page contains element  ${#0_content2}
    click element  ${#0_content2}

CLICK ON CONTENT-CAROUSEL IN ROW 7
    wait until page contains element  ${#7_content4}
    click element  ${#7_content4}

CLICK ON LIVE TV HEADER LINK
    click link  ${header_livetv}

CLICK ON MOVIE HEADER LINK
    click link  ${header_movies}

CLICK ON PLAY NOW BUTTON IN MOVIES
    wait until page contains element  ${play_watchnow}
    click element  ${play_watchnow}

CLICK ON CONTENT CAROUSEL
    [arguments]  ${content}
    wait until page contains element  ${content}  timeout=60s
    click element  ${content}