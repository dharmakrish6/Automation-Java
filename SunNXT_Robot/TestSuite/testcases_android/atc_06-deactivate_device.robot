*** Settings ***
Documentation    Suite description
Resource         ../keywords/android_app/high_level_keywords/authentication.robot
Resource         ../keywords/android_app/low_level_keywords/android_profile.robot
Resource         ../keywords/android_app/low_level_keywords/android_common.robot
Resource         ../test_data/credentials.robot
Test Setup       LOGIN VIA APP  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown    Close App

*** Test Cases ***
TESTCASE 04:
    TAP ON PROFILE BUTTON
    DISMISS DISPLAYED COACH MARK
    SWIPE DOWN
    CLICK ON DEVICES
    UNREGISTER ALL DEVICES ASSOCIATED WITH LOGGED ACCOUNT