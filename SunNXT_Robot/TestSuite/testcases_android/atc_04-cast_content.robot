*** Settings ***
Documentation    Suite description
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/high_level_keywords/cast_vod.robot
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/high_level_keywords/authentication.robot
Resource         E:/Automation-Java/SunNXT_Robot/test_data/credentials.robot
Resource         E:/Automation-Java/SunNXT_Robot/test_data/android_app/swipe_variables.robot
Test Setup       LOGIN VIA APP  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown    QUIT APPLICATION
Test Template    CAST VIDEO TO CASTING DEVICE

*** Test Cases ***      content_header                carousel_title                     content_name
MOVIE                       HOME                RECENTLY ADDED MUSIC ALBUMS              Kalakalapu 2