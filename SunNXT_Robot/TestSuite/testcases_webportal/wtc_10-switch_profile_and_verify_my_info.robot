*** Settings ***
Documentation    Suite description
Resource                ../keywords/webportal/low_level_keywords/web_common.robot
Resource                ../keywords/webportal/high_level_keywords/authentication.robot
Resource                ../keywords/webportal/high_level_keywords/profile/switch_profile.robot
Suite Setup             Open Browser And Navigate To SunNXT Website
Test Setup              Login Into Web Portal  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown           Logout From Web Portal
Suite Teardown          Close Opened Browser
Test Template           Switch Profile And Verify User Name In Profile Page

*** Test Cases ***                                profile
TEST-SCENARIO 64: SWITCH TO SECOND SECONDARY      First Secondary