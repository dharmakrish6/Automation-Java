*** Settings ***
Documentation       Contains action that can be performed for signup operation
Library               SeleniumLibrary
Resource              E:/Automation-Java/SunNXT_Robot/locators/webportal/authentication.robot
Resource              E:/Automation-Java/SunNXT_Robot/locators/webportal/homepage.robot
Resource              E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_common.robot
Resource              E:/Automation-Java/SunNXT_Robot/variable/credentials.robot

*** Keywords ***
CLICK ON SIGN UP LINK
    wait until element is visible  ${signup_link}
    click element  ${signup_link}

INPUT USERID
    [Arguments]  ${userid}
    input text  ${signup_user}   ${userid}

INPUT PASSWORD
    [Arguments]  ${userpass}
    input text  ${signup_password}   ${userpass}

ENTER NAME OF THE USER
    input text  ${signup_name}  ${user_full_name}

SELECT AGE OF THE PERSON
    click element  ${signup_age}
    click link  ${user_age}

SELECT GENDER AS MALE
    click element  ${signup_male}

SELECT RESIDING COUNTRY OF THE USER
    click element  ${signup_country}
    click link  ${user_country}

SELECT RESIDING STATE OF THE USER
    click element  ${signup_state}
    click link  ${user_state}

CLICK 'AGREE TERMS' CHECKBOX
    click element at coordinates  ${agree_checkbox}  -140   0

CLICK ON SUBMIT BUTTON
    wait until element is visible  ${submit}  timeout=15s
    click button  ${submit}

CHECK FOR SIGNUP ERROR MESSAGE
    wait until element is visible  ${signup_error}  timeout=15s
    ${signup_error_message} =  get text  ${signup_error}
    set global variable  ${signup_error_message}

CHECK FOR CREDENTIAL ERROR MESSAGE
    wait until element is visible  ${credential_error}  timeout=15s
    ${credential_error_message} =  get text  ${credential_error}
    set global variable  ${credential_error_message}

VALIDATE SIGN-UP
    ${status#1} =  run keyword and return status  CHECK FOR SIGNUP ERROR MESSAGE
    run keyword if   "${status#1}"=="True"  log many  ${signup_error_message}
    ${status#2} =  run keyword and return status  CHECK FOR CREDENTIAL ERROR MESSAGE
    run keyword if  "${status#2}"=="True"  log many  ${credential_error_message}
    run keyword if  "${status#1}"=="False"  AND  "${status#2}"=="False"  CHECK IF POP-UP IS DISMISSED


CHECK WHETHER USER IS NAVIGATED TO HOMEPAGE OR NOT
    sleep  5s
    wait until element is visible  ${sunnxt_logo}
    log location