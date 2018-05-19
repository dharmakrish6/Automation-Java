*** Settings ***
Documentation       Contains actions related to search operation
Library               SeleniumLibrary
Library               BuiltIn
Library               Screenshot
Resource              E:/Automation-Java/SunNXT_Robot/locators/webportal/homepage.robot
Resource              E:/Automation-Java/SunNXT_Robot/variable/webportal/keystrokes.robot

*** Keywords ***
CLICK ON SEARCH ICON
    wait until page contains element  ${search_icon}
    click element  ${search_icon}

CLICK ON SEARCH BOX
    wait until element is enabled   ${search_field}
    click element  ${search_field}

ENTER SEARCH QUERY
    [Arguments]  ${content_name}
    input text  ${search_field}   ${content_name}
    press key  ${search_field}   ${enter_key}

SEARCH VALIDATION
    [Arguments]  ${content_name}
    wait until page does not contain element  ${c_indicator_three}
    page should not contain element  css=.error_message_container h2