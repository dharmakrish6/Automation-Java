*** Settings ***
Documentation           Suite description
Library         AppiumLibrary
Resource         keywords/android_app/high_level_keywords/authentication.robot
Resource         keywords/android_app/low_level_keywords/android_common.robot
Resource         keywords/android_app/low_level_keywords/android_my_account.robot
Test Setup              Launch App
Test Teardown           Close App
*** Test Cases ***
TEST SCENARIO 118: CLEAR WATCH HISTORY
    Authenticate App  ID_Email_Subs
    Tap On Action Overflow Icon
    Tap On My Account
    Tap On Clear My Watch History/Cache
    Tap On Yes Button For Clear My Watch History/Cache
    Check If Continue Watching Is Present Or Not

