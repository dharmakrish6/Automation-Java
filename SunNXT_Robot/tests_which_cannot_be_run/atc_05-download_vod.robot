*** Settings ***
Documentation    Suite description
Resource         ../keywords/android_app/high_level_keywords/download_vod.robot
Resource         ../keywords/android_app/high_level_keywords/authentication.robot
Resource         ../test_data/credentials.robot
Test Setup       LOGIN VIA APP  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown    Close App
Test Template    DOWNLOAD VIDEO AND VERIFY

*** Test Cases ***           content_header          carousel_title               content_name           download_quality
MOVIE                            MOVIES               ACTION MOVIES                Rajapattai                  HD