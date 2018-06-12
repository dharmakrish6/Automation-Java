*** Settings ***
Documentation           Contains keywords related to operations perfomed on search
Library                 SeleniumLibrary
Library                 BuiltIn
Library                 Screenshot
Resource                E:/Automation-Java/SunNXT_Robot/locators/webportal/homepage.robot
Resource                E:/Automation-Java/SunNXT_Robot/test_data/web_portal/keystrokes.robot
Resource                E:/Automation-Java/SunNXT_Robot/locators/webportal/search.robot

*** Keywords ***
Click On Search Icon
    wait until page contains element  ${search_icon}
    click element  ${search_icon}

Click On Search Box
    wait until element is enabled   ${search_field}
    click element  ${search_field}

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
    ...  else  log many  SEARCH RESULT NOT DISPLAYED IN FIRST CAROUSEL

No Search Result
    ${status}=  run keyword and return status  page should contain element  ${no_result_displayed}
    ${msg}=  get text  ${no_result_displayed}
    run keyword if  "${status}"=="True"  log many  ${msg}