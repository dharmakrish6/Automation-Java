*** Settings ***
Documentation    Suite description
Library          AppiumLibrary
Resource         keywords/android_app/high_level_keywords/authentication.robot
Resource         keywords/android_app/low_level_keywords/android_profile.robot
Resource         keywords/android_app/low_level_keywords/android_common.robot
Test Setup       Launch App
Test Teardown    Close App

*** Test Cases ***
TESTCASE 04:
    Authenticate App  ID_Email_Subs
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Swipe Down
    Tap On Devices
    Unregister All Devices Associated With Logged Account