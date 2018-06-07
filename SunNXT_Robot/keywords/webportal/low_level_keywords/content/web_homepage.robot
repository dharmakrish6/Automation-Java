*** Settings ***
Library          SeleniumLibrary
Library          BuiltIn
Resource         E:/Automation-Java/SunNXT_Robot/locators/webportal/content/content_home.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/webportal/content/content_movies.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/webportal/homepage.robot

*** Keywords ***
Click On 1st Carousel Indicator
    wait until page contains element  ${carousel_one}
    double click element  ${cindicator_one}

Click On 1st Carousel Content
    wait until page contains element  ${carousel_one}
    click element  ${carousel_one}

Click On 4th Carousel Indicator
    wait until page contains element  ${carousel_four}
    double click element  ${cindicator_four}

Click On 4th Carousel Content
    wait until page contains element  ${carousel_four}
    click element  ${carousel_four}

Click On Free-Tag Content
    wait until page contains element  ${#0_content3}
    click element  ${#0_content3}

Click On Content-Carousel In Row 1
    wait until page contains element  ${#0_content2}
    click element  ${#0_content2}

Click On Content-Carousel In Row 7
    wait until page contains element  ${#7_content4}
    click element  ${#7_content4}

Click On Live Tv Header Link
    click link  ${header_livetv}

Click On Movie Header Link
    click link  ${header_movies}

Click On Play Now Button In Movies
    wait until page contains element  ${play_watchnow}
    click element  ${play_watchnow}

Click On Content Carousel
    [Arguments]  ${content}
    wait until page contains element  ${content}  timeout=60s
    ${content_name}=  get text  ${content}
    log many  STREAMING NOW: ${content_name}
    click element  ${content}