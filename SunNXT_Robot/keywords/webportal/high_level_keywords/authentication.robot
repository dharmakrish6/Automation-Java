*** Settings ***
Documentation           Flow for Sign-in & Sign-up operation in Web-portal (to be used as Suite/Test Setup)
Resource                keywords/webportal/low_level_keywords/web_common.robot
Resource                keywords/webportal/low_level_keywords/web_signup.robot

*** Keywords ***
Authenticate Web Portal
    [Arguments]  ${user_type}
    Click On Profile Authentication Icon
    Click On Sign In Link
    Enter Registered Credential  ${user_type}
    Enter Password  ${user_type}
    Click On Login Button
    Validate Sign-In  ${user_type}

Signup Using Credential
  [Arguments]  ${user_type}
  Click On Profile Authentication Icon
  Click On Sign In Link
  Click On Sign Up Link
  Input Userid  ${user_type}
  Input Password  ${user_type}
  Enter Name Of The User  ${user_type}
  Select Age Of The Person  ${user_type}
  Select Gender As Male  ${user_type}
  Select Residing Country Of The User  ${user_type}
  Select Residing State Of The User  ${user_type}
  Click 'Agree Terms' Checkbox
  Click On Submit Button
  Validate Sign-Up

Logout From Web Portal
    Click On Profile Icon
    Click On Logout Link
    delete all cookies
    close opened browser