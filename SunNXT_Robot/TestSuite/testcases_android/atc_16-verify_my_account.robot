*** Settings ***
Documentation           Suite description
Library                 AppiumLibrary
Resource         keywords/android_app/low_level_keywords/android_common.robot
Resource         keywords/android_app/low_level_keywords/android_edit_profile.robot
Resource         keywords/android_app/low_level_keywords/android_profile.robot
Resource         keywords/android_app/low_level_keywords/android_my_account.robot
Resource         keywords/android_app/high_level_keywords/authentication.robot
Test Setup              Launch App
Test Teardown           Close App

*** Test Cases ***
TEST SCENARIO 116: VERIFY MY ACCOUNT
    Authenticate App  ID_Email_Subs
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Tap On Edit Profile
    Tap On Edit Complete Profile
    Get Value From Full Name Field
    Get Value From Mobile Number
    Swipe Down
    Get Value From Country Spinner
    Get Value From State Spinner
    Tap On Done Button
    Save Edited Changes
    Tap On Action Overflow Icon
    Tap On My Account
    Tap On My Info
    Swipe Down
    Get Value For Name and Verify
    Get Value For Email-ID and Verify
    Get Value For Mobile Number and Verify
    Get Value For Country and Verify
    Get Value For State and Verify
    Get Value For Age and Verify