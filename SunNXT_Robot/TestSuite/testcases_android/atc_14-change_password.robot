*** Settings ***
Documentation    Suite description
Library         AppiumLibrary
Resource         keywords/android_app/high_level_keywords/change_password.robot
Test Setup       Launch App
Test Teardown    Close App
Test Template    Change Password and Login Via New Password

*** Test Cases ***                         user_type
TEST-SCENARIO 114: CHANGE PASSWORD         ID_Change_Pass