*** Settings ***
Documentation           Suite description
Resource                ../keywords/webportal/low_level_keywords/web_common.robot
Resource                ../keywords/webportal/low_level_keywords/web_profile.robot
Resource                ../keywords/webportal/low_level_keywords/profile/web_profile-edit_profile.robot
Resource                ../keywords/webportal/low_level_keywords/profile/web_profile-my_account.robot


*** Keywords ***
Edit Primary Profile Info And Verify In My Account
    [Arguments]  ${new_name}  ${new_age}  ${new_gender}  ${new_country}  ${new_state}
    Click On Profile Icon
    Click On Profile Link
    Click On Edit Profile Icon
    Wait Until Profile Slide-In Appears
    Click On 'Edit Complete Profile' Button
    Wait Until Edit Complete Profile Page Appears
    Modify The Provided Name Of User  ${new_name}
    Last Name Should Not Be Present In The Page
    Try To Edit Mobile Number
    Try To Edit E-Mail ID
    Edit Age Of The User  ${new_age}
    Change Gender Of The User  ${new_gender}
    Select Country  ${new_country}
    Select State  ${new_state}
    Save Edited Changes
    Click On Profile Icon
    Click On My Account Link
    Click On My Info Accordion
    Fetch Name Displayed in My Info Accordion And Verify  ${new_name}
    Fetch Email Displayed in My Info Accordion And Verify
    Fetch Mobile Number Displayed in My Info Accordion And Verify
    Fetch Country Displayed in My Info Accordion And Verify  ${ep_country}
    Fetch State Displayed in My Info Accordion And Verify  ${ep_state}
