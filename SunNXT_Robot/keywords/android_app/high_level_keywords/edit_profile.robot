*** Settings ***
Documentation    Suite description
Resource            ../keywords/android_app/low_level_keywords/android_common.robot
Resource            ../keywords/android_app/low_level_keywords/android_profile.robot
Resource            ../keywords/android_app/low_level_keywords/android_edit_profile.robot
Resource            ../keywords/android_app/low_level_keywords/android_authentication.robot

*** Keywords ***
Edit Information Available In Profile and Verify
    [Arguments]  ${new_full_name}  ${new_age}  ${new_gender}  ${new_country}  ${new_state}
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Tap On Edit Profile
    Verify User Type Is Primary
    Tap On Edit Complete Profile
    Edit Complete Profile  ${new_full_name}  ${new_age}  ${new_gender}  ${new_country}  ${new_state}
    Save Edited Changes
    Tap On Edit Profile
    Verify User Type Is Primary
    Tap On Edit Complete Profile
    Verify Full Name  ${new_full_name}
    Verify Age  ${new_age}
    Verify Country  ${new_country}
    Verify State  ${new_state}