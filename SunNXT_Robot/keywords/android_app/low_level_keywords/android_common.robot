*** Settings ***
Library          AppiumLibrary  30
Resource         E:/Automation-Java/SunNXT_Robot/test_data/android_app/test_environment.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/android_app/language_selection.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/android_app/common.robot
*** Keywords ***
OPEN SUNNXT APP
    Open Application   ${server}  platformName=${os}   platformVersion=${version}  deviceName=${udid}  app=${app}  appPackage=${app}  appActivity=${activity}
SELECT LANGUAGE AND PROCEED TO HOME-SCREEN
    wait until page contains element  ${next_btn}  timeout=15
    click text  ${tamil}
    click element  ${next_btn}

DISMISS DISPLAYED COACH MARK
    :FOR    ${index}    IN RANGE    3
    \  wait until page contains element  ${page_loaded}
    \  run keyword  COACH MARK DISMISS

COACH MARK DISMISS
    ${status}=  run keyword and return status  page should contain element  ${coach_mark}
    run keyword if  "${status}"=="True"  click text  ${thanks_text}
    ...  ELSE  Exit For Loop

ACCEPT IMEI SHARING
    click element  ${alert_btn1}

DENY IMEI SHARING
    click element  ${alert_btn2}

GET WINDOW RESOLUTION
    ${width}    get window width
    ${height}   get window height
    log many  ${width}  ${height}