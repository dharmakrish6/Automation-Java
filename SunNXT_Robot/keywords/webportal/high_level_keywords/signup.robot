*** Settings ***
Documentation    SunNXT Web-portal
Resource               E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_signup.robot
Resource               E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_common.robot

*** Keywords ***
SIGNUP USING CREDENTIAL
  [Arguments]  ${userid}  ${userpass}
  CLICK ON PROFILE AUTHENTICATION ICON
  CLICK ON SIGN IN LINK
  CLICK ON SIGN UP LINK
  INPUT USERID  ${userid}
  INPUT PASSWORD  ${userpass}
  ENTER NAME OF THE USER
  SELECT AGE OF THE PERSON
  SELECT GENDER AS MALE
  SELECT RESIDING COUNTRY OF THE USER
  SELECT RESIDING STATE OF THE USER
  CLICK 'AGREE TERMS' CHECKBOX
  CLICK ON SUBMIT BUTTON
  VALIDATE SIGN-UP