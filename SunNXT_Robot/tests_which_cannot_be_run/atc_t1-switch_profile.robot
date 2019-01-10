*** Settings ***
Documentation    Suite description
Library          AppiumLibrary
Resource         keywords/android_app/high_level_keywords/switch_profile.robot
Resource         keywords/android_app/low_level_keywords/android_common.robot
Test Setup          Launch App
Test Teardown       Close App
Test Template    Switch Profile

*** Test Cases ***                                                    content_type
TEST-SCENARIO 113: SWITCH TO PRIMARY PROFILE                            Primary