*** Settings ***
Documentation    Suite description
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/high_level_keywords/authentication.robot
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_profile.robot
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_common.robot
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/test.robot
Resource         E:/Automation-Java/SunNXT_Robot/test_data/credentials.robot
Test Setup       LOGIN VIA APP  ${unreg_id-mob}  ${unreg_id-mob}
Test Teardown    QUIT APPLICATION

*** Test Cases ***
TestCase TestVersion:
    SCREENSHOT
    swipe