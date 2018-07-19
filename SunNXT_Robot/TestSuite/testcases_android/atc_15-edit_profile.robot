*** Settings ***
Documentation    Suite description
Resource         ../keywords/android_app/high_level_keywords/edit_profile.robot
Resource         ../keywords/android_app/high_level_keywords/authentication.robot
Resource         ../keywords/android_app/low_level_keywords/android_common.robot
Resource         ../test_data/credentials.robot
Test Setup       LOGIN VIA APP  ${reg_id-email_exp}   ${reg_pass-email_exp}
Test Teardown    CLOSE APP
Test Template    Edit Information Available In Profile and Verify

*** Test Cases ***                      new_full_name  new_age      new_gender  new_country  new_state
TEST-SCENARIO 115: EDIT PROFILE INFO    Issei Hyodou   18-25 Years  MALE        Madagascar   Toliary