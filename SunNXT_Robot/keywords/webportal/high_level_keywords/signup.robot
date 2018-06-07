*** Settings ***
Documentation    SunNXT Web-portal
Resource               E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_signup.robot
Resource               E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_common.robot

*** Keywords ***
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