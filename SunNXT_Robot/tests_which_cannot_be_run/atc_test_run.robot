*** Settings ***
Resource            tests_which_cannot_be_run/atc_test.robot
Resource            keywords/android_app/high_level_keywords/authentication.robot
Test Setup          LOGIN VIA APP  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown       Close App
Test Template       Navigate To And Stream Any Content

*** Test Cases ***           content_language   content_header          carousel_title               content_name
MOVIE                         TAMIL             MOVIES              ACTION MOVIES                ANJAAN