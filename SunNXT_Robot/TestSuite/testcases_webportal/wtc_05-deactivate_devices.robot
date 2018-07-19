*** Settings ***
Documentation
Resource            ../keywords/webportal/low_level_keywords/web_common.robot
Resource            ../keywords/webportal/low_level_keywords/web_devices.robot
Resource            ../test_data/credentials.robot
Resource            ../keywords/webportal/low_level_keywords/web_common.robot
Resource            ../keywords/webportal/high_level_keywords/authentication.robot
Test Setup         LOGIN INTO WEB PORTAL  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown      Close Opened Browser

*** Test Cases ***
TEST-SCENARIO 57: DEVICE DEACTIVATION
    Click On Profile Icon
    Click On Devices Link
    Deactivate Devices Displayed In List
    Check If All Devices Are Deactivated