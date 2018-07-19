*** Settings ***
Documentation    Suite description
Resource         ../keywords/webportal/low_level_keywords/web_common.robot
Resource         ../keywords/webportal/high_level_keywords/authentication.robot
Resource         ../keywords/webportal/high_level_keywords/edit_profile.robot
Resource         ../test_data/credentials.robot
Suite Setup         Open Browser And Navigate To SunNXT Website
Test Setup          Login Into Web Portal  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown       Logout From Web Portal
Suite Teardown      Close Opened Browser
Test Template    Edit Primary Profile Info And Verify In My Account

*** Test Cases ***                                     new_name     new_age_range  new_gender  new_country  new_state
TEST-SCENARIO 62: EDIT PRIMARY PROFILE INFORMATION     Escanor      51-60 Years    MALE        India        Karnataka


#age index to be used
#1 - 18-25 Years
#2 - 26-30 Years
#3 - 31-35 Years
#4 - 36-40 Years
#5 - 41-50 Years
#6 - 51-60 Years
#7 - 61-70 Years
#8 - 71-80 Years
#9 - 81-90 Years