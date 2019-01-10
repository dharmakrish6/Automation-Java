*** Settings ***
Documentation    Suite description
Library         AppiumLibrary
Resource         keywords/android_app/high_level_keywords/edit_profile.robot
Resource         keywords/android_app/low_level_keywords/android_common.robot
Test Setup       Launch App
Test Teardown    Close App
Test Template    Edit Information Available In Profile and Verify

*** Test Cases ***                      user_type
TEST-SCENARIO 115: EDIT PROFILE INFO    ID_Email_Subs