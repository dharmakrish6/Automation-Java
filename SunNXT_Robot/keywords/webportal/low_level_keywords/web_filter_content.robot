*** Settings ***
Documentation    Suite description
Library             venv/Lib/site-packages/robot/libraries/String.py
Library             ExcelReader
Resource            locators/webportal/content/view_all_contents.robot
Resource            locators/webportal/common.robot

*** Keywords ***
Click View All Button
    [Arguments]  ${page_source}
    run keyword if  "${page_source}"=="movies"  Click On View All Movies
    ...  ELSE IF  "${page_source}"=="tv shows"  Click On View All TV Shows
    ...  ELSE IF  "${page_source}"=="music videos"  Click On View All Music Videos

Click On View All Movies
#    wait until page contains element  ${view_all-movies}
    click link  ${view_all-movies}

Click On View All TV Shows
#    wait until page contains element  ${view_all-tv_shows}
    click link  ${view_all-tv_shows}

Click On View All Music Videos
#    wait until page contains element  ${view_all_music_videos}
    click link  ${view_all_music_videos}

Click On First Filter
    click element  ${filter#1}
    ${filter}=  set variable  FilterOne
    set global variable  ${filter}

Click On Second Filter
    click element  ${filter#2}
    ${filter}=  set variable  FilterTwo
    set global variable  ${filter}

Choose a Specific Pilter
    [Arguments]  ${page_source}
    run keyword if  "${filter}"=="FilterOne"  Get Filter 1 Value  ${page_source}
    ...  ELSE IF  "${filter}"=="FilterTwo"  Get Filter 2 Value  ${page_source}
    ${choose_filter}=  catenate  SEPARATOR=  [for='  ${filter_name}  ']
    click element  css:${choose_filter}
    run keyword if  "${filter}"=="FilterOne"  click element  ${btn_filter#1}
    ...  ELSE IF  "${filter}"=="FilterTwo"  click element  ${btn_filter#2}

Get Filter 1 Value
        [Arguments]  ${page_source}
        ${filter_name}=  get value from corresponding row  filter  Source  ${page_source}  Filter 1
        set global variable  ${filter_name}

Get Filter 2 Value
        [Arguments]  ${page_source}
        ${filter_name}=  get value from corresponding row  filter  Source  ${page_source}  Filter 2
        set global variable  ${filter_name}

Verify Filter
    [Arguments]  ${page_source}
    ${verify_content}=  get value from corresponding row  filter  Source  ${page_source}  Verifiable Content
    set global variable  ${verify_content}
    Check Content Presence
#    run keyword if  "${status}"=="False"  fail

Check Content Presence
    wait until element is not visible  ${content_loading_animation}  timeout=${extended_wait}
    page should contain  ${verify_content}