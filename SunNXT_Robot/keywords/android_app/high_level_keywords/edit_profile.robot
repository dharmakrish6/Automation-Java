*** Settings ***
Documentation    Suite description
Resource            keywords/android_app/low_level_keywords/android_common.robot
Resource            keywords/android_app/low_level_keywords/android_profile.robot
Resource            keywords/android_app/low_level_keywords/android_edit_profile.robot
Resource            keywords/android_app/high_level_keywords/authentication.robot

*** Keywords ***
Edit Information Available In Profile and Verify
    [Arguments]  ${user_type}
    Authenticate App  ${user_type}
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Tap On Edit Profile
    Verify User Type Is Primary
    Tap On Edit Complete Profile
    Edit Complete Profile
    Save Edited Changes
#    Tap On Edit Profile
#    Verify User Type Is Primary
#    Tap On Edit Complete Profile
#    Verify Full Name
#    Verify Age
#    Verify Country
#    Verify State