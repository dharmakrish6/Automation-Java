*** Settings ***
Documentation           Flow for Sign-in & Sign-up operation in Web-portal (to be used as Suite/Test Setup)
Resource                ../keywords/webportal/low_level_keywords/web_common.robot
Resource                ../keywords/webportal/low_level_keywords/web_signup.robot

*** Keywords ***
Authenticate Web Portal
    [Arguments]  ${userid}  ${userpass}
    Click On Profile Authentication Icon
    Click On Sign In Link
    Enter Registered Credential  ${userid}
    Enter Password  ${userpass}
    Click On Login Button
    Validate Sign-In

Login Into Web Portal
    [Arguments]  ${userid}  ${userpass}
#    Open Browser And Navigate To SunNXT Website
    Click On Profile Authentication Icon
    Click On Sign In Link
    Enter Registered Credential  ${userid}
    Enter Password  ${userpass}
    Click On Login Button
    Validate Sign-In
    sleep  5s

Signup Using Credential
  [Arguments]  ${userid}  ${userpass}
  Click On Profile Authentication Icon
  Click On Sign In Link
  Click On Sign Up Link
  Input Userid  ${userid}
  Input Password  ${userpass}
  Enter Name Of The User
  Select Age Of The Person
  Select Gender As Male
  Select Residing Country Of The User
  Select Residing State Of The User
  Click 'Agree Terms' Checkbox
  Click On Submit Button
  Validate Sign-Up

Logout From Web Portal
    Click On Profile Icon
    Click On Logout Link
    delete all cookies