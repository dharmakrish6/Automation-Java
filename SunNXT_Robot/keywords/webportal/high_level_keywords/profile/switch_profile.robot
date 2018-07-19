*** Settings ***
Documentation    Suite description
Resource                ../keywords/webportal/low_level_keywords/web_common.robot
Resource                ../keywords/webportal/low_level_keywords/profile/web_profile-switch_profile.robot
Resource                ../keywords/webportal/low_level_keywords/web_profile.robot

*** Keywords ***
Switch Profile And Verify User Name In Profile Page
    [Arguments]  ${profile}
    Click On Profile Icon
    Click On Switch Profile Link
    Wait Until Switch Profile Pop-Up Is Displayed
    Switch Profile  ${profile}
    Click On Profile Icon
    Click On Profile Link
    Fetch UserName And Verify
