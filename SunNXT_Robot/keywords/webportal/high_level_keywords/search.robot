*** Settings ***
Documentation           Flow to search content in web-portal using search bar (Movies, TV Show and Music Videos)
Resource                ../keywords/webportal/low_level_keywords/web_common.robot
Resource                ../keywords/webportal/low_level_keywords/web_search.robot

*** Keywords ***
Search For A Movie, Tv Show And Music Video
    [Arguments]  ${content_language}  ${content_name}
    Select Content Language  ${content_language}
    Click On Search Icon
    Enter Search Query  ${content_name}
    Search Validation  ${content_name}