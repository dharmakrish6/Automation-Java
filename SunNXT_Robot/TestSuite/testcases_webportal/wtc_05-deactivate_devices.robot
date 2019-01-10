*** Settings ***
Documentation
Resource         keywords/webportal/low_level_keywords/web_common.robot
Resource         keywords/webportal/low_level_keywords/web_devices.robot
Resource         keywords/webportal/low_level_keywords/web_common.robot
Resource         keywords/webportal/high_level_keywords/authentication.robot
Test Setup          Open Browser And Navigate To SunNXT Website
Test Teardown       Close Opened Browser

*** Test Cases ***
TEST-SCENARIO 57: DEVICE DEACTIVATION
    Authenticate Web Portal  ID_Email_Subs
    Click On Profile Icon
    Click On Devices Link
    Deactivate Devices Displayed In List
    Check If All Devices Are Deactivated