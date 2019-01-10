*** Settings ***
Documentation           Suite description
Library         AppiumLibrary
Resource         keywords/android_app/high_level_keywords/authentication.robot
Resource         keywords/android_app/low_level_keywords/android_common.robot
Resource         keywords/android_app/low_level_keywords/android_settings.robot
Test Setup              Launch App
Test Teardown           Close App

*** Test Cases ***
TEST SCENARIO 117: SUBMIT A FEEDBACK
    Authenticate App  ID_Email_Subs
    Tap On Action Overflow Icon
    Tap On Settings Option
    Tap On Feeback Option
    Enter Feedback In Displayed Textbox
    Submit Feedback


