*** Settings ***
Documentation    Suite description
Resource         ../keywords/android_app/high_level_keywords/change_password.robot
Resource         ../keywords/android_app/high_level_keywords/authentication.robot
Resource         ../keywords/android_app/low_level_keywords/android_common.robot
Resource         ../test_data/credentials.robot
Test Setup       LOGIN VIA APP  ${reg_id-email_exp}   ${reg_pass-email_exp}
Test Teardown    CLOSE APP
Test Template    Change Password and Login Via New Password

*** Test Cases ***                                current_password  new_password  userid
TEST-SCENARIO 114: CHANGE PASSWORD                  @meet087        123456        ${reg_id-email_exp}