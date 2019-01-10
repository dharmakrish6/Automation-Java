*** Settings ***
Documentation           Contains keywords related to operations perfomed on search
Library                 SeleniumLibrary
Library                 BuiltIn
Library                 Screenshot
Library                 venv/Lib/site-packages/robot/libraries/String.py
Resource                locators/webportal/homepage.robot
Resource                test_data/web_portal/keystrokes.robot
Resource                locators/webportal/search.robot

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
    ${status}=  run keyword and return status  page should contain element  ${search_result_displayed}
    run keyword if  "${status}"=="True"  Search Result Displayed  ${content_name}
    ...  ELSE IF  "${status}"=="False"  fail
    capture page screenshot

Search Result Displayed
    [Arguments]  ${content_name}
    ${searched_content}=  catenate  SEPARATOR=  //h2[starts-with(text(),'  ${content_name}  ')]
    ${status}=  run keyword and return status  page should contain element  xpath:${searched_content}
    ${message}=  catenate  SEPARATOR=  SEARCHED CONTENT '  ${content_name}  ' IS BEING DISPLAYED IN SEARCH RESULTS
    run keyword if  "${status}"=="True"  set test message  ${message}
    ...  ELSE  No Content Displayed in Search Result

No Content Displayed in Search Result
    reload page
    wait until page does not contain element  ${content_loading_animation}  timeout=${extended_wait}
    ${status}=  run keyword and return status  page should contain element  xpath:${searched_content}
    ${message}=  catenate  SEPARATOR=  SEARCHED CONTENT '  ${content_name}  ' IS VISIBLE AFTER PAGE RELOAD
    run keyword if  "${status}"=="True"  set test message  ${message}
    ...  ELSE  fail

No Search Result
    ${status}=  run keyword and return status  page should contain element  ${no_result_displayed}
    run keyword if  "${status}"=="True"  Fetch Displayed Message From Site

Fetch Displayed Message From Site
    ${msg}=  get text  ${no_result_displayed}
    ${msg}=  convert to uppercase  ${msg}
    set test message  ${msg}