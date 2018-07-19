*** Settings ***
Documentation    Suite description
Library
Resource         ../keywords/webportal/low_level_keywords/web_common.robot
Resource         ../keywords/webportal/high_level_keywords/authentication.robot
Resource         ../keywords/webportal/low_level_keywords/web_devices.robot
Resource         ../test_data/credentials.robot
Test Setup       Login Into Web Portal  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown    Close Opened Browser

*** Test Cases ***
TEST-SCENARIO 61: ACTIVATE A DEVICE USING AUTHENTICATION CODE DISPLAYED
    Click On Profile Icon
    Click On Devices Link
    Input Code To Enter Code TextField
    Activate Device
