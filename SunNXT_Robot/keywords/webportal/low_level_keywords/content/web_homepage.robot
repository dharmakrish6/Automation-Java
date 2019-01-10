*** Settings ***
Library          SeleniumLibrary
Library          BuiltIn
Library          venv/Lib/site-packages/robot/libraries/String.py
Library          ExcelReader
Library          ExtendedBuiltin
Resource         locators/webportal/content/content_home.robot
Resource         locators/webportal/vod_details_screen.robot

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

Set Sheet From Which Content Name Has To Be Fetched
    [Arguments]  ${page_source}
    run keyword if  "${page_source}"=="home"  Set Sheet Name For Content At Home
    ...  ELSE IF  "${page_source}"=="movies"  Set Sheet Name For Content At Movies
    ...  ELSE IF  "${page_source}"=="tv shows"  Set Sheet Name For Content At TV Shows
    ...  ELSE IF  "${page_source}"=="live tv"  Set Sheet Name For Content At Comedy
    ...  ELSE IF  "${page_source}"=="music videos"  Set Sheet Name For Content At Music Videos
    ...  ELSE IF  "${page_source}"=="comedy"  Set Sheet Name For Content At Comedy

Set Sheet Name For Content At Home
    ${content_sheet}=  set global variable  home

Set Sheet Name For Content At Movies
    ${content_sheet}=  set global variable  movies

Set Sheet Name For Content At TV Shows
    ${content_sheet}=  set global variable  tv_shows

Set Sheet Name For Content At Live TV
    ${content_sheet}=  set global variable  live_tv

Set Sheet Name For Content At Music Videos
    ${content_sheet}=  set global variable  music_videos

Set Sheet Name For Content At Comedy
    ${content_sheet}=  set global variable  comedy

Click On Content Carousel
    [Arguments]  ${page_source}  ${content_language}
    ${content_name}=  get value from corresponding row  ${page_source}  Language  ${content_language}  Content Name
    set global variable  ${content_name}
    ${content_locator}=  catenate  SEPARATOR=  //h2[contains(text(),'  ${content_name}  ')]
    wait until page contains element  xpath:${content_locator}  timeout=${extended_wait}
    set focus to element  xpath:${content_locator}
    log many  STREAMING NOW: ${content_name}
    click element  xpath:${content_locator}
    ${url_now}=  get location
    ${status}=  run keyword and return status  should contain  ${url_now}  live
    run keyword if  "${status}"=="True"  Verify Content Name For Live TV
    ...  ELSE  Verify Content Name For VOD

Verify Content Name For VOD
    ${content_being_streamed}=  get text  ${content_streamed}
    set global variable  ${content_being_streamed}
    ${status}=  run keyword and return status  should be an integer  ${content_being streamed}
    run keyword if  "${status}"=="Pass"  Compare Content Streamed And Content Name Provided

Compare Content Streamed And Content Name Provided
    ${content_being_streamed}=  convert to lowercase  ${content_being_streamed}
    ${content_name}=  convert to lowercase  ${content_name}
    should contain  ${content_being_streamed}  ${content_name}

Verify Content Name For Live TV
    ${page_title}=  get title
    ${page_title}=  convert to lowercase  ${page_title}
    ${content_name}=  convert to string  ${content_name}
    ${content_name}=  convert to lowercase  ${content_name}
    should contain  ${page_title}  ${content_name}