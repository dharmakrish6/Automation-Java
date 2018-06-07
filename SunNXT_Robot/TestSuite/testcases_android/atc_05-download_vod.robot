*** Settings ***
Documentation    Suite description
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/high_level_keywords/download_vod.robot
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/high_level_keywords/authentication.robot
Resource         E:/Automation-Java/SunNXT_Robot/test_data/credentials.robot
Test Setup       LOGIN VIA APP  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown    QUIT APPLICATION
Test Template    DOWNLOAD VIDEO AND VERIFY

*** Test Cases ***           content_header          carousel_title               content_name           download_quality
MOVIE                            MOVIES               ACTION MOVIES                Rajapattai                  HD