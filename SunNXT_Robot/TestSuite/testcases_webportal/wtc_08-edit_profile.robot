*** Settings ***
Documentation    Suite description
Resource         keywords/webportal/low_level_keywords/web_common.robot
Resource         keywords/webportal/high_level_keywords/edit_profile.robot
Test Setup          Open Browser And Navigate To SunNXT Website
Test Teardown       Close Opened Browser
Test Template    Edit Primary Profile Info And Verify In My Account

*** Test Cases ***                                      user_info
TEST-SCENARIO 62: EDIT PRIMARY PROFILE INFORMATION      New User Info#1