*** Settings ***
Librsry             venv/Lib/site-packages/robot/libraries/Process.py
Library                 OperatingSystem
Librsry             venv/Lib/site-packages/robot/libraries/String.py
Library                 ExcelReader
Library                 Dialogs
Library                 AppiumLibrary
Resource                locators/android_app/playstore.robot
Resource         keywords/android_app/low_level_keywords/android_keystrokes.robot
Suite Setup             Initialize The Test Data
Suite Teardown          Teardown

*** Keywords ***
#master keyword
Initialize The Test Data
    Select The Excel Sheet To Be Used
    Restart ADB Server
    Gather Device Information
    Verify UiAutomator To Be Used
    Ask User To Run Scripts On Which Environment
    Check Whether SunNXT App Is Installed Or Not
    Open Sunnxt App

Teardown
   capture page screenshot
   terminate all processes
   close application

Open Sunnxt App
    ${app}=  get value from corresponding row  environment_setup  Environment  Android  App
    ${activity}=  get value from corresponding row  environment_setup  Environment  Android  Activity
    ${appwait}=  get value from corresponding row  environment_setup  Environment  Android  App Wait Activity
    open application   ${server}  platformName=${os}   platformVersion=${deviceVersion}  deviceName=${deviceID}  automationName=${automationName}  appPackage=${app}  appActivity=${activity}  appWaitActivity=${activity},${appwait}  appWaitDuration=${duration}
    ${lang_activity}=  get value from corresponding row  environment_setup  Environment  Android  App Wait Activity
    set global variable  ${lang_activity}
    wait activity  ${lang_activity}  timeout=15
    set suite documentation  THE TESTS ARE EXECUTED ON: ${manufacturer} ${model} with ${os} ${deviceVersion}

Select The Excel Sheet To Be Used
    ${path}=  catenate  SEPARATOR=  ${exec_dir}  \\test_data\\test_data.xlsx
    choose excel sheet  ${path}
    ${content_sheet}=  catenate  SEPARATOR=  ${exec_dir}  \\test_data\\android_content_list.xlsx
    choose excel sheet  ${content_sheet}


Restart ADB Server
    run process  adb  kill-server
    run process  adb  start-server

#keywords to be run once
Gather Device Information
    #run adb processes and get device info
    run process  adb  shell  getprop  ro.product.manufacturer  stdout=manufacturer.txt
    run process  adb  shell  getprop  ro.product.model  stdout=model.txt
    run process  adb  shell  getprop  ro.build.version.release  stdout=deviceVersion.txt
    run process  adb  shell  getprop  ro.serialno  stdout=deviceID.txt
    run process  adb  shell  pm  list  packages  com.suntv.sunnxt  stdout=appAvailability.txt
    #fetch device info to variables
    ${manufacturer}=  get file  manufacturer.txt
    ${model}=    get file  model.txt
    ${deviceID}=  get file  deviceID.txt
    ${deviceVersion}=  get file  deviceVersion.txt
    #access variables outside of the keyword
    set global variable  ${manufacturer}
    set global variable  ${model}
    set global variable  ${deviceID}
    set global variable  ${deviceVersion}

Verify UiAutomator To Be Used
    ${deviceVersion}=  fetch from left  ${deviceVersion}  .
    ${check_deviceVersion}=  convert to integer  ${deviceVersion}
    set global variable  ${check_deviceVersion}
    run keyword if  ${check_deviceVersion}>=6  Set UiAutomator Type For Android v6 And Above
    ...  ELSE IF  ${check_deviceVersion}<6  Set UiAutomator Type For Below Android v6

Set UiAutomator Type For Android v6 And Above
    ${automationName}=  set variable  UiAutomator2
    set global variable  ${automationName}

Set UiAutomator Type For Below Android v6
    ${automationName}=  set variable  Appium
    set global variable  ${automationName}

Check Whether SunNXT App Is Installed Or Not
    ${appAvailability}=  get file  appAvailability.txt
    ${appAvailability}=  strip string  ${appAvailability}  mode=right
    set global variable  ${appAvailability}
    Install Sunnxt App

Ask User To Run Scripts On Which Environment
    ${env}=  get value from user  HELLO AMIGOS! PLEASE ENTER VALUE 'Prod' TO TEST IN PRODUCTION ENVIRONMENT AND 'Pre-Prod' TO TEST PRE-PRODUCTION ENVIRONMENT
    set global variable  ${env}
    run keyword if  "${env}"=="Prod"  run keyword  Set Test Data For Prod Environment
    ...  ELSE IF  "${env}"=="Pre-Prod"  run keyword  Set Test Data For Pre-Prod Environment
    ...  ELSE  Ask User To Run Scripts On Which Environment

Install Sunnxt App
    run keyword if  "${env}"=="Prod"  Install Prod APK
    ...  ELSE IF  "${env}"=="Pre-Prod"  Install Pre-Prod APK
#    run process  adb  shell  pm  list  packages  com.suntv.sunnxt  stdout=appAvailability.txt
#    ${appAvailability}=  get file  appAvailability.txt
#    ${appAvailability}=  strip string  ${appAvailability}  mode=right

Install Prod APK
#    ${path}=  get value from corresponding row  environment_setup  Environment  Android  Install_Path-Prod
#    run process  adb  install  ${path}  alias=appInstall  stderr=install_log.txt
    ${server}=  get value from corresponding row  environment_setup  Environment  Android  Server_URL
    set global variable  ${server}
    ${os}=  get value from corresponding row  environment_setup  Environment  Android  OS
    set global variable  ${os}
    ${duration}=  convert to integer  50000
    set global variable  ${duration}
    ${play_store}=  get value from corresponding row  environment_setup  Environment  Playstore  App
    ${store_activity}=  get value from corresponding row  environment_setup  Environment  Playstore  Activity
    open application   ${server}  platformName=${os}   platformVersion=${deviceVersion}  deviceName=${deviceID}  automationName=${automationName}  appPackage=${play_store}  appActivity=${store_activity}  appWaitDuration=${duration}
    wait activity  .AssetBrowserActivity  timeout=60
    run keyword if  "${appAvailability}"!="package:com.suntv.sunnxt"  Install From Playstore
    ...  ELSE  Update From Playstore

Install From Playstore
    wait until page contains element  ${ps_search}
    click element  ${ps_search}
    input text  ${ps_searchbox}  ${app_name}
    wait until page contains element  ${suggested_app}  timeout=15
    click element  ${suggested_app}
    wait until page contains  ${app_name}  timeout=15
    click text  ${app_name}
    wait until page contains element  ${install}  timeout=15
    ${status}=  run keyword and return status  page should contain element  ${install}
    run keyword if  "${status}"=="True"  Install App From Playstore
    ...  ELSE  close application
   Wait Until App Is Installed Or Updated
#    sleep  20

Update From Playstore
    wait until page contains element  ${ps_search}
    click element  ${ps_search}
    input text  ${ps_searchbox}  ${app_name}
    wait until page contains element  ${suggested_app}  timeout=15
    click element  ${suggested_app}
    wait until page contains  ${app_name}  timeout=15
    click text  ${app_name}
    wait until page contains element  ${uninstall}  timeout=15
    ${status}=  run keyword and return status  page should contain element  ${update}
    run keyword if  "${status}"=="True"  click element  ${update}
    ...  ELSE  close application
    Wait Until App Is Installed Or Updated

Install App From Playstore
    click element  ${install}
    wait until page contains element  ${accept}  timeout=15
    click element  ${accept}

Install Pre-Prod APK
    ${path}=  get value from corresponding row  environment_setup  Environment  Android  Install_Path-Pre_Prod
    run process  adb  install  ${path} alias=appInstall  stderr=install_log.txt

Set Test Data For Prod Environment
    ${signin_sheet}=  set variable  prod_sign-in
    set global variable  ${signin_sheet}
    ${signup_sheet}=  set variable  prod_sign-up
    set global variable  ${signup_sheet}

Set Test Data For Pre-Prod Environment
    ${signin_sheet}=  set variable  pre-prod_sign-in
    set global variable  ${signin_sheet}
    ${signup_sheet}=  set variable  pre-prod_sign-up
    set global variable  ${signup_sheet}

Wait Until App Is Installed Or Updated
    :FOR  ${index}  IN RANGE  200
    \  ${status}=  run keyword and return status  page should contain element  ${uninstall}
    \  run keyword if  "${status}"=="False"  sleep  6
    \  continue for loop if  "${status}"=="False"
    \  run keyword if  "${status}"=="True"  close application
    \  exit for loop if  "${status}"=="True"