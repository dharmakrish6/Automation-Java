*** Settings ***
Documentation    Suite description
Resource            keywords/webportal/low_level_keywords/web_filter_content.robot
Resource            keywords/webportal/low_level_keywords/web_common.robot
Resource            keywords/webportal/high_level_keywords/authentication.robot

*** Keywords ***
Filter Content In View All Section
    [Arguments]  ${page_source}
    Authenticate Web Portal  ID_Email_Subs
    Select Source Page  ${page_source}
    Click View All Button  ${page_source}
    Click On First Filter
    Choose a Specific Pilter  ${page_source}
    Click On Second Filter
    Choose a Specific Pilter  ${page_source}
    Verify Filter  ${page_source}