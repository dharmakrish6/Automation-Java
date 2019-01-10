*** Settings ***
Documentation           Contains keywords for operations related to Sign-In & Sign-Up at lower level
Library                 AppiumLibrary  run_on_failure=Capture Page Screenshot
Library                 venv/Lib/site-packages/robot/libraries/String.py
Library                 ExcelReader
Library                 OCRLibrary
Resource                locators/android_app/authentication_screen.robot
Resource                test_data/android_app/swipe_variables.robot
Resource                locators/android_app/authentication_screen.robot
Resource                locators/android_app/common.robot

*** Keywords ***
Enter User Id
    [Arguments]  ${user_type}
    ${userid}=  get value from corresponding row  ${signin_sheet}  User Type  ${user_type}  Log-in ID
    ${userid}=  convert to string  ${userid}
    set global variable  ${userid}
     input text  ${username}  ${userid}

Enter Password
    [Arguments]  ${user_type}
    ${userpass}=  get value from corresponding row  ${signin_sheet}  User Type  ${user_type}  Password
    ${check_pass}=  run keyword and return status  should match regexp  ${userid}  ${regex_ten_num}
    ${check_email}=  run keyword and return status  should match regexp  ${userid}  ${regex_email}
    run keyword if  "${check_email}"=="False" and "${check_pass}"=="False"  pass execution  PASSWORD FIELD NOT VISIBLE FOR INVALID MOBILE NUMBER
    wait until page does not contain element  ${sunnxt_banner}
    ${pass}=  run keyword and return status  should match regexp  ${userid}  ${regex_only_num}
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

Validate Using Message Displayed
    [Arguments]  ${user_type}
    ${toast_message}=  get value from corresponding row  ${signin_sheet}  User Type  ${user_type}  Toast Message
    set suite variable  ${toast_message}
    ${alert_message}=  get value from corresponding row  ${signin_sheet}  User Type  ${user_type}  Alert Message
    set suite variable  ${alert_message}
    ${pop-up_message}=  get value from corresponding row  ${signin_sheet}  User Type  ${user_type}  Pop-up Message
    set suite variable  ${pop-up_message}
    set suite variable  ${user_type}
    run keyword if  "${toast_message}"!="NA"  Verify Toast Message
    ...  ELSE IF  "${alert_message}"!="NA"  Verify Alert Message
    ...  ELSE IF  "${pop-up_message}"!="NA"  Verify Pop-up Message

Verify Toast Message
    capture page screenshot  filename=sign-up.png
    image should contain text  ${EXEC_DIR}\\verify.png  eng  ${toast_message}

Verify Alert Message
    ${alert}=  catenate  SEPARATOR=  //android.widget.TextView[contains(@resource-id,'alert_message') and @text='  ${alert_message}  ']
    page should contain element  xpath=${alert}
    click element  ${alert_ok}

Verify Pop-up Message
    ${pop-up}=  catenate  SEPARATOR=  //android.widget.TextView[contains(@resource-id,'message') and @text='  ${pop-up_message}  ']
    page should contain element  xpath=${pop-up}
    run keyword if  "${user_type}"=="Already Registered Credential  click element  ${alert_btn1}

Wait Until Navigated To Home-Screen
    [Arguments]  ${user_type}
    ${status}=  run keyword and return status  should contain  ${user_type}  Already
    run keyword if  "${status}"=="True"  credential used for sign-up already exists
    run keyword if  "${user_type}"=="ID_SunDirect_Subs" or "ID_SunDirect_Exp"  Sun Direct Message
     ${status}=  run keyword and return status  ALERT MESSAGE
#     run keyword if  "${status}"=="True"
     run keyword if  "${status}"=="False"  SIGNIN/SIGNUP VALIDATION

Sun Direct Message
    ${status}=  run keyword and return status  wait until page contains element  ${alert_btn1}
    run keyword if  "${status}"=="True"  Sun Direct Validation

Sun Direct Validation
    click element  ${alert_btn1}
    wait until page contains  FEATURED VIDEOS

Accept Alert Message
    ${status}=  wait until page contains element  ${alert_btn1}  timeout=10
    run keyword if  "${status}"=="True"  OK ALERT

Ok Alert
    click element  ${alert_btn1}
    wait until page contains  FEATURED VIDEOS

Signin/Signup Validation
    ${home_status}=  run keyword and return status  page should contain text  FEATURED VIDEOS  timeout=10
    run keyword if  "${home_status}"=="True"    log many  SUCCESSFULLY NAVIGATED TO HOMESCREEN AFTER SIGN-IN/SIGN-UP
    ...  ELSE IF   "${userid}"=="ID_Unregistered"  log many  UNREGISTERED ID CANNOT BE USED FOR LOG-IN
    ...  Unable To Login

Credential Used For Sign-Up Already Exists
    ${credential_exists}=  catenate  SEPARATOR=  xpath=android.widget.TextView[contains(@resource,'message') and @text='user with email  ${userid}  has already been registered']
    ${signup_exisiting}=  run keyword and return status  page should contain element  ${credential_exists}
    click element  ${alert_btn1}
    log many  CREDENTIAL USED ALREADY EXISTS


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
     wait until page contains  SIGN UP  timeout=15

Input User-Id
    [Arguments]  ${user_type}
    ${userid}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  Log-in ID
    ${userid}=  convert to string  ${userid}
    ${status}=  run keyword and return status  should start with  ${userid}  @
    run keyword if  "${status}"=="True"  Escape @ In User-Id  ${userid}
    ...  ELSE  set global variable  ${userid}
    input text  ${s_userid}  ${userid}


Escape @ In User-Id
    [Arguments]  ${userid}
    ${es_userid}=  catenate  SEPARATOR=  \\  ${userid}
    ${userid}=  set variable  ${es_userid}
    set suite variable  ${userid}


Input Signup Password
    [Arguments]  ${user_type}
    ${userpass}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  Password
    input password  ${s_password}  ${userpass}

Input Full Name Of User
    [Arguments]  ${user_type}
    ${user_full_name}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  Full Name
    input text  ${s_fullname}  ${user_full_name}

Select Age Of User
    [Arguments]  ${user_type}
    ${user_age}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  Age
     click element  ${s_age}
     wait until page contains element  ${popup_list}  timeout=10
     :FOR  ${index}  in range  20
     \   ${status}=  run keyword and return status  page should contain text  ${user_age}
     \   run keyword if  "${status}"=="False"  Swipe Up Dropdown
     \   exit for loop if  "${status}"=="True"
     \   continue for loop
     click text     ${user_age}
     wait until page contains element  ${s_age}

Select Gender Of User
    [Arguments]  ${user_type}
    ${gender}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  Gender
    run keyword if  "${gender}"=="Male"  click element  ${s_male}
    ...  ELSE IF  "${gender}"=="Female"  click element  ${s_female}

Select Residing Country Of User
    [Arguments]  ${user_type}
    ${user_country}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  Country
     click element   ${s_country}
     wait until page contains element  ${popup_list}  timeout=10
     :FOR  ${index}  in range  1000
     \   ${status}=  run keyword and return status  page should contain text  ${user_country}
     \   run keyword if  "${status}"=="False"  Swipe Up Dropdown
     \   exit for loop if  "${status}"=="True"
     \   continue for loop
     click text     ${user_country}
     wait until page contains element  ${s_country}

Select Residing State Of User
    [Arguments]  ${user_type}
    ${user_state}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  State
     click element   ${s_state}
     wait until page contains element  ${popup_list}  timeout=10
     :FOR  ${index}  in range  1000
     \  ${status}=  run keyword and return status  page should contain text  ${user_state}
     \  run keyword if  "${status}"=="False"  Swipe Up Dropdown
     \   exit for loop if  "${status}"=="True"
     \   continue for loop
     click text     ${user_state}
     wait until page contains element  ${s_state}

Click On Submit
     swipe by percent  ${sd-x_starts}  ${sd-y_starts}  ${sd-x_ends}  ${sd-y_ends}
     click element  ${btn_submit}