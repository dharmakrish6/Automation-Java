*** Settings ***
Documentation       Automated Tests for Project SunNXT. Scripts By: Ameet Kumar Pradhan
Library             Dialogs
Library             ExcelReader
Library             SystemInformation
Librsry             venv/Lib/site-packages/robot/libraries/String.py
Suite Setup         Initialize Test Data

*** Keywords ***
#master keyword to be used in suite-setup
Initialize Test Data
    Select The Excel Sheet To Be Used
    Ask User To Run Scripts On Which Environment

#low level keywords
Select The Excel Sheet To Be Used
    ${path}=  catenate  SEPARATOR=  ${exec_dir}  \\test_data\\test_data.xlsx
    choose excel sheet  ${path}
    ${content_path}=  catenate  SEPARATOR=  ${exec_dir}  \\test_data\\web-portal_content_list.xlsx
    choose excel sheet  ${content_path}

Get Device Information
    #get device info
    ${os}=  get platform name
    ${os_version}=  get platform version
    ${processor_name}=  get processor info
    ${architecture}=  get platform architecture
    ${architecture}=  convert to string  ${architecture}
    ${architecture}=  fetch from left  ${architecture}  ,
    ${architecture}=  remove string  ${architecture}  '  (
    set test message  THE TESTS ARE EXECUTED ON: ${os} ${os_version} ${architecture} with ${processor_name}

#set test-data dependent on environment
Ask User To Run Scripts On Which Environment
    ${env}=  get value from user  HELLO AMIGOS! PLEASE ENTER VALUE 'Prod' TO TEST IN PRODUCTION ENVIRONMENT AND 'Pre-Prod' TO TEST PRE-PRODUCTION ENVIRONMENT
    set global variable  ${env}
    run keyword if  "${env}"=="Prod"  run keyword  Set Test Data For Prod Environment
    ...  ELSE IF  "${env}"=="Pre-Prod"  run keyword  Set Test Data For Pre-Prod Environment
    ...  ELSE  Ask User To Run Scripts On Which Environment

Set Test Data For Prod Environment
    ${url}=  get value from corresponding row  environment_setup  Environment  Web_Portal-Prod  Server_URL
    set global variable  ${url}
    ${signin_sheet}=  set variable  prod_sign-in
    set global variable  ${signin_sheet}
    ${signup_sheet}=  set variable  prod_sign-up
    set global variable  ${signup_sheet}

Set Test Data For Pre-Prod Environment
    ${url}=  get value from corresponding row  environment_setup  Environment  Web_Portal-Pre_Prod  Server_URL
    set global variable  ${url}
    ${signin_sheet}=  set variable  pre-prod_sign-in
    set global variable  ${signin_sheet}
    ${signup_sheet}=  set variable  pre-prod_sign-up
    set global variable  ${signup_sheet}