*** Settings ***
Documentation    Suite description
Resource         ../keywords/android_app/high_level_keywords/authentication.robot
Resource         ../keywords/android_app/low_level_keywords/android_common.robot
Resource         ../test_data/credentials.robot
Test Setup       LOGIN VIA APP  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown    Close App

*** Test Cases ***
TEST-SCENARIO XX: Test The Crash F
    wait until page contains  SOME TEST WAIT  timeout=120

*** Variables ***
${device}    7.0