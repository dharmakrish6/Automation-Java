*** Settings ***
Documentation           Flow for deactivating and activating devices in Web-portal (to be used as Suite/Test Setup)
Resource                keywords/webportal/low_level_keywords/web_common.robot
Resource                keywords/webportal/high_level_keywords/authentication.robot
Resource                keywords/webportal/low_level_keywords/web_devices.robot

*** Keywords ***
Activate Devices
    [Arguments]  ${device}
    Authenticate Web Portal  ID_Email_Subs
    Click On Profile Icon
    Click On Devices Link
    Input Code To Enter Code TextField  ${device}
    Activate Device