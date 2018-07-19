*** Settings ***
Documentation    Suite description
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/high_level_keywords/switch_profile.robot
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/high_level_keywords/authentication.robot
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_common.robot
Resource         E:/Automation-Java/SunNXT_Robot/test_data/credentials.robot
Test Setup       LOGIN VIA APP  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown    CLOSE APP
Test Template    Switch Profile

*** Test Cases ***                                                    content_type
TEST-SCENARIO 113: SWITCH TO PRIMARY PROFILE                            Primary