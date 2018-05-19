*** Settings ***
Documentation    Suite description
Library          AppiumLibrary  30  run_on_failure=Capture Page Screenshot
Library          String
Resource         E:/Automation-Java/SunNXT_Robot/locators/android_app/authentication_screen.robot
Resource         E:/Automation-Java/SunNXT_Robot/test_data/android_app/swipe_variables.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/android_app/profile_screen.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/android_app/authentication_screen.robot
Resource         E:/Automation-Java/SunNXT_Robot/locators/android_app/common.robot

*** Keywords ***
CLICK LOGIN TEXT
    wait until page contains element  id=com.suntv.sunnxt:id/imageView1  timeout=3
    click text  ${log_in}
    wait until page contains element  id=com.suntv.sunnxt:id/logo_background

ENTER USER ID
    [Arguments]  ${userid}
     input text  ${username}  ${userid}
     ${pass}=  run keyword and return status  should match regexp  ${userid}  ${regex}
     set global variable  ${pass}

ENTER PASSWORD
    [Arguments]  ${userid}  ${userpass}
    wait until page does not contain element  ${sunnxt_banner}
    run keyword if  "${pass}"=="True"  ENTER PASSWORD FOR MOBILE  ${userpass}
    ...  ELSE  ENTER PASSWORD FOR EMAIL-ID  ${userpass}

ENTER PASSWORD FOR EMAIL-ID
    [Arguments]  ${userpass}
    input password  ${email_password}  ${userpass}

ENTER PASSWORD FOR MOBILE
    [Arguments]  ${userpass}
    input password  ${mob_password}  ${userpass}

CLICK LOGIN BUTTON
     click element  ${btn_login}

WAIT UNTIL NAVIGATED TO HOME-SCREEN
     ${status}=  run keyword and return status  ALERT MESSAGE
#     run keyword if  "${status}"=="True"
     run keyword if  "${status}"=="False"  SIGNIN/SIGNUP VALIDATION

ALERT MESSAGE
    ${status}=  wait until page contains element  ${alert_btn1}  timeout=10
    run keyword if  "${status}"=="True"  OK ALERT

OK ALERT
    click element  ${alert_btn1}
    wait until page contains  FEATURED VIDEOS

SIGNIN/SIGNUP VALIDATION
    ${home_status}=  run keyword and return status  wait until page contains  FEATURED VIDEOS
    run keyword if  "${home_status}"=="True"  page should contain text  FEATURED VIDEOS
    ...  ELSE  UNABLE TO LOGIN

UNABLE TO LOGIN
    ${status}=  run keyword and return status  wait until page contains element  ${ii_alert}
    run keyword if  "${status}"=="True"  click element  ${ii_alert}
    page should contain text  SIGN IN
    log many  CREDENTIAL ENTERED IS EITHER INCORRECT OR INVALID OR ALREADY EXISTS


TAP ON PROFILE BUTTON
    #click on profile icon
     wait until page contains element  ${button_profile}
     click element  ${button_profile}

CREATE NEW USER ID
#     ${e}=  catenate  user with email  ${s_userid}  has already been registered
#     log many  ${e}

     #navigate to signup screen
CLICK ON SIGNUP LINK
     click element  ${l_signup_in}

INPUT USER-ID
    [Arguments]  ${userid}
     input text  ${s_userid}  ${userid}

INPUT SIGNUP PASSWORD
    [Arguments]  ${userpass}
     input password  ${s_password}  ${userpass}

INPUT FULL NAME OF USER
     input text  ${s_fullname}  Kaneki Ken

SELECT AGE OF USER
     click element  ${s_age}
     text should be visible  ${s_age_18}
     click text     ${s_age_18}
     wait until page contains element  ${s_age}

SELECT GENDER OF USER
     click element  ${s_male}

SELECT RESIDING COUNTRY OF USER
     click element   ${s_country}
     text should be visible  ${s_country_IN}
     click text     ${s_country_IN}
     wait until page contains element  ${s_country}

SELECT RESIDING STATE OF USER
     click element   ${s_state}
     text should be visible  ${s_state_ANI}
     click text     ${s_state_ANI}
     wait until page contains element  ${s_state}

CLICK ON SUBMIT
     swipe by percent  ${sd-x_starts}  ${sd-y_starts}  ${sd-x_ends}  ${sd-y_ends}
     click element  ${btn_submit}