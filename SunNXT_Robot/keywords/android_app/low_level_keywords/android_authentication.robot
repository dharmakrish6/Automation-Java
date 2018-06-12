*** Settings ***
Documentation           Contains keywords for operations related to Sign-In & Sign-Up at lower level
Library                 AppiumLibrary
Library                 String
Resource                E:/Automation-Java/SunNXT_Robot/locators/android_app/authentication_screen.robot
Resource                E:/Automation-Java/SunNXT_Robot/test_data/android_app/swipe_variables.robot
Resource                E:/Automation-Java/SunNXT_Robot/locators/android_app/authentication_screen.robot
Resource                E:/Automation-Java/SunNXT_Robot/locators/android_app/common.robot

*** Keywords ***
Enter User Id
    [Arguments]  ${userid}
     input text  ${username}  ${userid}
     ${pass}=  run keyword and return status  should match regexp  ${userid}  ${regex}
     set global variable  ${pass}

Enter Password
    [Arguments]  ${userid}  ${userpass}
    wait until page does not contain element  ${sunnxt_banner}
    run keyword if  "${pass}"=="True"  ENTER PASSWORD FOR MOBILE  ${userpass}
    ...  ELSE  ENTER PASSWORD FOR EMAIL-ID  ${userpass}

Enter Password For Email-Id
    [Arguments]  ${userpass}
    input password  ${email_password}  ${userpass}

Enter Password For Mobile
    [Arguments]  ${userpass}
    input password  ${mob_password}  ${userpass}

Click Login Button
     click element  ${btn_login}

Wait Until Navigated To Home-Screen
     ${status}=  run keyword and return status  ALERT MESSAGE
#     run keyword if  "${status}"=="True"
     run keyword if  "${status}"=="False"  SIGNIN/SIGNUP VALIDATION

Alert Message
    ${status}=  wait until page contains element  ${alert_btn1}  timeout=10
    run keyword if  "${status}"=="True"  OK ALERT

Ok Alert
    click element  ${alert_btn1}
    wait until page contains  FEATURED VIDEOS

Signin/Signup Validation
    ${home_status}=  run keyword and return status  wait until page contains  FEATURED VIDEOS
    run keyword if  "${home_status}"=="True"  page should contain text  FEATURED VIDEOS
    ...  Else  Unable To Login

Unable To Login
    ${status}=  run keyword and return status  wait until page contains element  ${ii_alert}
    run keyword if  "${status}"=="True"  click element  ${ii_alert}
    page should contain text  SIGN IN
    log many  Credential Entered Is Either Incorrect Or Invalid Or Already Exists

Create New User Id
#     ${e}=  catenate  user with email  ${s_userid}  has already been registered
#     log many  ${e}

     #navigate to signup screen
Click On Signup/Signin Link
     click element  ${l_signup_in}

Input User-Id
    [Arguments]  ${userid}
     input text  ${s_userid}  ${userid}

Input Signup Password
    [Arguments]  ${userpass}
     input password  ${s_password}  ${userpass}

Input Full Name Of User
     input text  ${s_fullname}  Kaneki Ken

Select Age Of User
     click element  ${s_age}
     text should be visible  ${s_age_18}
     click text     ${s_age_18}
     wait until page contains element  ${s_age}

Select Gender Of User
     click element  ${s_male}

Select Residing Country Of User
     click element   ${s_country}
     text should be visible  ${s_country_IN}
     click text     ${s_country_IN}
     wait until page contains element  ${s_country}

Select Residing State Of User
     click element   ${s_state}
     text should be visible  ${s_state_ANI}
     click text     ${s_state_ANI}
     wait until page contains element  ${s_state}

Click On Submit
     swipe by percent  ${sd-x_starts}  ${sd-y_starts}  ${sd-x_ends}  ${sd-y_ends}
     click element  ${btn_submit}