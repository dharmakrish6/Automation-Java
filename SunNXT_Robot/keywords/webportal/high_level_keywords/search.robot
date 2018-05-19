*** Settings ***
Documentation    Suite description
Resource                E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/common.robot
Resource                E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_search.robot

*** Keywords ***
SEARCH FOR A MOVIE, TV SHOW AND MUSIC VIDEO
    [Arguments]  ${content_name}
    CLICK ON SEARCH ICON
    CLICK ON SEARCH BOX
    ENTER SEARCH QUERY  ${content_name}
    SEARCH VALIDATION  ${content_name}