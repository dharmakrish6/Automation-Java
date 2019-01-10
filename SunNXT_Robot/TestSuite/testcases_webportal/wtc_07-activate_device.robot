*** Settings ***
Documentation       Suite description
Resource         keywords/webportal/low_level_keywords/web_common.robot
Resource         keywords/webportal/high_level_keywords/devices.robot
Test Setup          Open Browser And Navigate To SunNXT Website
Test Teardown       Close Opened Browser
Test Template       Activate Devices

*** Test Cases ***                                                              device
TEST-SCENARIO 61: ACTIVATE A DEVICE USING AUTHENTICATION CODE DISPLAYED         Device#1
TEST-SCENARIO 62: ACTIVATE A DEVICE USING INVALID AUTHENTICATION CODE           Device#2

