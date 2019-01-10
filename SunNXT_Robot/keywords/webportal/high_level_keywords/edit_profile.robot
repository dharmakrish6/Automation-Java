*** Settings ***
Documentation           Suite description
Resource                keywords/webportal/low_level_keywords/web_common.robot
Resource                keywords/webportal/low_level_keywords/web_profile.robot
Resource                keywords/webportal/low_level_keywords/profile/web_profile-edit_profile.robot
Resource                keywords/webportal/low_level_keywords/profile/web_profile-my_account.robot
Resource         keywords/webportal/high_level_keywords/authentication.robot


*** Keywords ***
Edit Primary Profile Info And Verify In My Account
    [Arguments]  ${user_info}
    Authenticate Web Portal  ID_Email_Subs
    Click On Profile Icon
    Click On Profile Link
    Click On Edit Profile Icon
    Wait Until Profile Slide-In Appears
    Click On 'Edit Complete Profile' Button
    Wait Until Edit Complete Profile Page Appears
    Modify The Provided Name Of User  ${user_info}
    Last Name Should Not Be Present In The Page
    Try To Edit Mobile Number  ${user_info}
    Try To Edit E-Mail ID  ${user_info}
    Edit Age Of The User  ${user_info}
    Change Gender Of The User  ${user_info}
    Select Country  ${user_info}
    Select State  ${user_info}
    Save Edited Changes
    Click On Profile Icon
    Click On My Account Link
    Click On My Info Accordion
    Fetch Name Displayed in My Info Accordion And Verify
    Fetch Email Displayed in My Info Accordion And Verify
    Fetch Mobile Number Displayed in My Info Accordion And Verify
    Fetch Country Displayed in My Info Accordion And Verify
    Fetch State Displayed in My Info Accordion And Verify