*** Settings ***
Documentation    Suite description
Library             SeleniumLibrary
Library             Dialogs
Library             ExcelReader
Resource            locators/webportal/devices.robot

*** Keywords ***
Deactivate Devices Displayed In List
    :FOR    ${index}    IN RANGE    5
    \  run keyword  Deactivate Devices

Deactivate Devices
    ${status}=  run keyword and return status  wait until page contains element  ${btn_deactivate}
    run keyword if  "${status}"=="True"  click element  ${btn_deactivate}
    ...  ELSE  exit for loop

Check If All Devices Are Deactivated
    ${status}=  run keyword and return status  page should not contain  ${btn_deactivate}
    run keyword if  "${status}"=="False"  Unsuccessful Device Deactivation

Unsuccessful Device Deactivation
    set test message  DEACTIVATING DEVICES FAILED
    fail

Input Code To Enter Code TextField
    [Arguments]  ${device}
    ${auth_code}=  get value from corresponding row  auth_code  Device  ${device}  Code
    input text  ${input_field}  ${auth_code}

Activate Device
    click element  ${btn_activate}

Validate Device Activation
    [Arguments]  ${device}
    ${code_status}=  get value from corresponding row  auth_code  Device  ${device}  Code Status
    ${auth_error}=  run keyword and return status  page should contain element  ${error_msg}
    run keyword if  "${code_status}"=="Valid"  Success In Auth Code Validation
    ...  ELSE IF  "${auth_error}"=="True" and "${code_status}"=="Invalid"  Error In Auth Code Entered
    ...  ELSE  fail

Issue In Device Auth Code
    set test message  DETAILS OF CODE ENTERED ARE AS FOLLOWS: CODE VALIDITY- ${code_status} ERROR MESSAGE DISPLAYED- ${auth_error} SUCCESS MESSAGE DISPLAYED- ${successful_activation}
    fail

Error In Auth Code Entered
    ${error}=  get text  ${error_msg}
    set test message  ERROR MESSAGE '${error}'  WAS DISPLAYED UPON ENTERING ${code_status} code.

Success In Auth Code Validation
    ${success}=  get text  ${success_msg}
    set test message  MESSAGE '${success}' WAS DISPLAYED UPON ENTERING ${code_status} code.