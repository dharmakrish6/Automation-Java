*** Settings ***
Documentation
Resource         keywords/webportal/low_level_keywords/web_common.robot
Resource         keywords/webportal/low_level_keywords/profile/web_profile-feedback.robot
Resource         keywords/webportal/high_level_keywords/authentication.robot
Test Setup          Open Browser And Navigate To SunNXT Website
Test Teardown       Close Opened Browser

*** Test Cases ***
TEST-SCENARIO 65: SUBMIT FEEDBACK
    Authenticate Web Portal  ID_Email_Subs
    Click On Profile Icon
    Click On Feedback Link
    Enter Feedback
    Submit Feedback
    Check If Feedback Is Submitted Or Not

    