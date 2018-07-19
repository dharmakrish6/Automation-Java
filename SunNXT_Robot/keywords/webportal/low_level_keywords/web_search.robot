*** Settings ***
Documentation           Contains keywords related to operations perfomed on search
Library                 SeleniumLibrary
Library                 BuiltIn
Library                 Screenshot
Resource                ../locators/webportal/homepage.robot
Resource                ../test_data/web_portal/keystrokes.robot
Resource                ../locators/webportal/search.robot

*** Keywords ***
Click On Search Icon
    wait until page contains element  ${search_icon}
    click element  ${search_icon}

Enter Search Query
    [Arguments]  ${content_name}
    input text  ${search_field}   ${content_name}
    press key  ${search_field}   ${enter_key}

Search Validation
    [Arguments]  ${content_name}
    sleep  5s
    ${status}=  run keyword and return status  page should contain element  ${search_result_displayed}
    run keyword if  "${status}"=="True"  Search Result Displayed  ${content_name}
    run keyword if  "${status}"=="False"  No Search Result
    capture page screenshot

Search Result Displayed
    [Arguments]  ${content_name}
    ${1st_content_displayed}=  get text  ${search_result_1st}
    run keyword if  "${1st_content_displayed}"=="${content_name}"  log many  SEARCHED CONTENT DISPLAYED IN RESULTS
    ...  ELSE  log many  SEARCH RESULT NOT DISPLAYED IN FIRST CAROUSEL

No Search Result
    ${status}=  run keyword and return status  page should contain element  ${no_result_displayed}
    run keyword if  "${status}"=="True"  ${msg}=  get text  ${no_result_displayed}
    run keyword if  "${status}"=="True"  log many  ${msg}