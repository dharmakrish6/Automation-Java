*** Settings ***
Documentation    Suite description
Resource                E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/common.robot
Resource                E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_search.robot

*** Keywords ***
Search For A Movie, Tv Show And Music Video
    [Arguments]  ${content_language}  ${content_name}
    Select Language  ${content_language}
    Click On Search Icon
    Click On Search Box
    Enter Search Query  ${content_name}
    Search Validation  ${content_name}