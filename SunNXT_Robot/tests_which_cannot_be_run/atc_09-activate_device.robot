*** Settings ***
Documentation    Suite description
Resource         ../keywords/android_app/high_level_keywords/authentication.robot
Resource         ../keywords/android_app/low_level_keywords/android_profile.robot
Resource         ../keywords/android_app/low_level_keywords/android_common.robot
Resource         ../test_data/credentials.robot
Test Setup       LOGIN VIA APP  ${reg_id-email_subs}  ${reg_pass-email_subs}
#Test Teardown    Close App

*** Test Cases ***
TEST-SCENARIO 96: ACTIVATE A DEVICE USING AUTHENTICATION CODE DISPLAYED
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Swipe Down
    Tap On Devices
    Authenticate Device