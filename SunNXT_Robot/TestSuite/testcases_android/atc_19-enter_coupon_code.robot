*** Settings ***
Documentation           Suite description
Library         AppiumLibrary
Resource         keywords/android_app/low_level_keywords/android_common.robot
Resource         keywords/android_app/low_level_keywords/android_profile.robot
Resource         keywords/android_app/high_level_keywords/authentication.robot
Test Setup              Launch App
Test Teardown           Close App

*** Test Cases ***
TEST SCENARIO 119: ENTER AN INVALID COUPON CODE
    Authenticate App  ID_Email_Subs
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Swipe Up Dropdown
    Tap On Coupon Code Text
    Input Coupon Code In Displayed TextBox
    Submit Coupon Code
    Accept Alert Message
