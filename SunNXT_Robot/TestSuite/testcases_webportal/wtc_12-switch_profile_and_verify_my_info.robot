*** Settings ***
Documentation    Suite description
Resource         keywords/webportal/low_level_keywords/web_common.robot

Resource         keywords/webportal/high_level_keywords/profile/switch_profile.robot
Test Setup              Open Browser And Navigate To SunNXT Website
Test Teardown           Close Opened Browser
Test Template           Switch Profile And Verify User Name In Profile Page

*** Test Cases ***                                profile
TEST-SCENARIO 64: SWITCH TO THIRD SECONDARY      Third Secondary