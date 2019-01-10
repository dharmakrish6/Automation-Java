*** Settings ***
Documentation    Suite description
Resource                keywords/webportal/low_level_keywords/web_common.robot
Resource                keywords/webportal/low_level_keywords/profile/web_profile-switch_profile.robot
Resource                keywords/webportal/low_level_keywords/profile/web_profile-add_delete_profile.robot
Resource            keywords/webportal/high_level_keywords/authentication.robot

*** Keywords ***
Switch Profile And Verify User Name In Profile Page
    [Arguments]  ${profile}
    Authenticate Web Portal  ID_Email_Subs
    Click On Profile Icon
    Click On Switch Profile Link
    Wait Until Switch Profile Pop-Up Is Displayed
    Check If Selected Profile Is Primary Or Not
    Check and Proceed As Per Availability Of Profiles

