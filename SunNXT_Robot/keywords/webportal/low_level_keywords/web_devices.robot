*** Settings ***
Documentation    Suite description
Library             AppiumLibrary
Library             Dialogs
Resource            ../locators/webportal/devices.robot

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
    run keyword if  "${status}"=="False"  log many  DEVICES STILL LOGGED IN

Input Code To Enter Code TextField
    ${auth_code}=  get value from user  ENTER ACTIVATION CODE  default
    input text  ${input_field}  ${auth_code}

Activate Device
    click element  ${btn_activate}