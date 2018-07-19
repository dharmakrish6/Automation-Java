*** Settings ***
Documentation           Contains keywords for signup operation at lower-level
Library                 SeleniumLibrary
Resource                ../locators/webportal/authentication.robot
Resource                ../locators/webportal/homepage.robot
Resource                ../keywords/webportal/low_level_keywords/web_common.robot
Resource                ../test_data/credentials.robot

*** Keywords ***
Click On Sign Up Link
    wait until element is visible  ${signup_link}
    click element  ${signup_link}

Input Userid
    [Arguments]  ${userid}
    input text  ${signup_user}   ${userid}

Input Password
    [Arguments]  ${userpass}
    input text  ${signup_password}   ${userpass}

Enter Name Of The User
    input text  ${signup_name}  ${user_full_name}

Select Age Of The Person
    click element  ${signup_age}
    click link  ${user_age}

Select Gender As Male
    click element  ${signup_male}

Select Residing Country Of The User
    click element  ${signup_country}
    click link  ${user_country}

Select Residing State Of The User
    click element  ${signup_state}
    click link  ${user_state}

Click 'Agree Terms' Checkbox
    click element at coordinates  ${agree_checkbox}  -140   0

Click On Submit Button
    wait until element is visible  ${submit}  timeout=15s
    click button  ${submit}

Check For Signup Error Message
    wait until element is visible  ${signup_error}  timeout=15s
    ${signup_error_message} =  get text  ${signup_error}
    set global variable  ${signup_error_message}

Check For Credential Error Message
    wait until element is visible  ${credential_error}  timeout=15s
    ${credential_error_message} =  get text  ${credential_error}
    set global variable  ${credential_error_message}

Validate Sign-Up
    ${status#1} =  run keyword and return status  CHECK FOR SIGNUP ERROR MESSAGE
    run keyword if   "${status#1}"=="True"  log many  ${signup_error_message}
    ${status#2} =  run keyword and return status  CHECK FOR CREDENTIAL ERROR MESSAGE
    run keyword if  "${status#2}"=="True"  log many  ${credential_error_message}
    run keyword if  "${status#1}"=="False"  AND  "${status#2}"=="False"  CHECK IF POP-UP IS DISMISSED


Check Whether User Is Navigated To Homepage Or Not
    sleep  5s
    wait until element is visible  ${sunnxt_logo}
    log location