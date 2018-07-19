*** Settings ***
Documentation           Suite description
Resource                ../keywords/webportal/low_level_keywords/web_common.robot
Resource                ../keywords/webportal/high_level_keywords/authentication.robot
Resource                ../keywords/webportal/low_level_keywords/profile/web_profile-my_account.robot
Resource                ../test_data/credentials.robot
Test Setup              Login Into Web Portal  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown           Close Opened Browser

*** Test Cases ***
TEST-SCENARIO 63: CLEAR CONTINUE WATCHING
    Click On Profile Icon
    Click On My Account Link
    Click On Clear My Watch History Accordion
    Clear My Watch History
    Verify That Clear My Watch History Accordion Is Not Being Displayed
    Select Source Page  HOME
    Verify If Continue Watching Has Been Removed Or Not


