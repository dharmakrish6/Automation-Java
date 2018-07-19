*** Settings ***
Resource                ../keywords/android_app/low_level_keywords/android_common.robot
Resource                ../keywords/android_app/low_level_keywords/android_search.robot
*** Keywords ***
Search For A Content
    [Arguments]  ${content_language}  ${content_type}  ${content_name}
    Select Content Language  ${content_language}
    Tap On Search Button
    Choose Search Content Type  ${content_type}
    Enter Search Query  ${content_name}
    Validate Search  ${content_name}  ${content_type}