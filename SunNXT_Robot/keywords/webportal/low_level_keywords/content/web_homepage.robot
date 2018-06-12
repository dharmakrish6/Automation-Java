*** Settings ***
Library          SeleniumLibrary
Library          BuiltIn
Resource         E:/Automation-Java/SunNXT_Robot/locators/webportal/content/content_home.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/webportal/content/content_movies.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/webportal/homepage.robot

*** Keywords ***
Click On 1st Carousel Indicator
    wait until page contains element  ${sc_indicator#1}
    double click element  ${sc_indicator#1}

Click On 1st Carousel Content
    wait until page contains element  ${sc_content#1}
    click element  ${sc_content#1}

Click On 4th Carousel Indicator
    wait until page contains element  ${sc_indicator#4}
    double click element  ${sc_indicator#4}

Click On 4th Carousel Content
    wait until page contains element  ${sc_content#4}
    click element  ${sc_content#4}

Click On Play Now Button In Movies
    wait until page contains element  ${play_watchnow}
    click element  ${play_watchnow}

Click On Content Carousel
    [Arguments]  ${content}

    wait until page contains element  ${content}  timeout=300
    ${content_name}=  get text  ${content}
    log many  STREAMING NOW: ${content_name}
    click element  ${content}