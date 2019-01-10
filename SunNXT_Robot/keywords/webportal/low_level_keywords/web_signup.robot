*** Settings ***
Documentation           Contains keywords for signup operation at lower-level
Library                 SeleniumLibrary
Library                 ExcelReader
Resource                locators/webportal/authentication.robot
Resource                locators/webportal/homepage.robot
Resource                keywords/webportal/low_level_keywords/web_common.robot

*** Keywords ***
Click On Sign Up Link
    wait until element is visible  ${signup_link}
    click element  ${signup_link}

Input Userid
    [Arguments]  ${user_type}
    ${userid}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  Log-in ID
    input text  ${signup_user}   ${userid}

Input Password
    [Arguments]  ${user_type}
    ${userpass}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  Password
    input text  ${signup_password}   ${userpass}

Enter Name Of The User
    [Arguments]  ${user_type}
    ${user_full_name}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  Full Name
    input text  ${signup_name}  ${user_full_name}

Select Age Of The Person
    [Arguments]  ${user_type}
    ${user_age}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  Age
    click element  ${signup_age}
    click link  ${user_age}

Select Gender As Male
    [Arguments]  ${user_type}
    ${gender}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  Gender
    run keyword if  "${gender}"=="Male"  click element  ${signup_male}
    ...  ELSE  click element  ${signup_female}

Select Residing Country Of The User
    [Arguments]  ${user_type}
    ${user_country}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  Country
    click element  ${signup_country}
    input text  ${signup_country/state_input}  ${user_country}
    ${country}=  catenate  SEPARATOR=  xpath: //div[@id='selectcountry_chosen']//ul[@class='chosen-results']/li[.='  ${user_country}  ']
    wait until element is visible  ${country}
    click element  ${country}


Select Residing State Of The User
    [Arguments]  ${user_type}
    ${user_state}=  get value from corresponding row  ${signup_sheet}  Verification Types  ${user_type}  State
    click element  ${signup_state}
    input text  ${signup_country/state_input}  ${user_state}
    ${state}=  catenate  SEPARATOR=  xpath: //div[@id='stateid_chosen']//li[.='  ${user_state}  ']
    wait until element is visible  ${state}
    click element  ${state}

Click 'Agree Terms' Checkbox
    click element at coordinates  ${agree_checkbox}  -140   0

Click On Submit Button
    wait until element is visible  ${submit}  timeout=${extended_wait}
    click button  ${submit}

#Check For Signup Error Message
#    ${status}=  run keyword and return status  page should contain element  ${signup_error}  timeout=${extended_wait}
#    run keyword if  "${status}"=="True"  Get Sign Up Error
#
#Get Sign Up Error
#    ${signup_error_message}=  get text  ${signup_error}
#    set global variable  ${signup_error_message}
#
#Check For Credential Error Message
#    ${error_userid}=  run keyword and return status  page should contain element  ${userid_error}  timeout=${extended_wait}
#    ${error_pass}=  run keyword and return status  page should contain element  ${password_error}  timeout=${extended_wait}
#    run keyword if  "${error_userid}"=="Pass"  Error Message For User ID Error
#    ...  ELSE IF  "${error_pass}"=="Pass"  Error Message For Password Error
#    log many  ${credential_error_message}
#
#
#Error Message For User ID Error
#    ${credential_error_message} =  get text  ${userid_error}
#    set global variable  ${credential_error_message}
#
#Error Message For Password Error
#    ${credential_error_message} =  get text  ${password_error}
#    set global variable  ${credential_error_message}
#
#Validate Sign-Up
#    ${status#1} =  run keyword and return status  CHECK FOR SIGNUP ERROR MESSAGE
#    run keyword if   "${status#1}"=="True"  log many  ${signup_error_message}
#    ${status#2} =  run keyword and return status  CHECK FOR CREDENTIAL ERROR MESSAGE
#    run keyword if  "${status#2}"=="True"  log many  ${credential_error_message}
#    run keyword if  "${status#1}"=="False" and "${status#2}"=="False"  CHECK IF POP-UP IS DISMISSED

Validate Sign-Up
    ${status}=  run keyword and return status  element should be visible  ${userid_error}
    ${status#2}=  run keyword and return status  element should be visible  ${password_error}
    ${status#3}=  run keyword and return status  element should be visible  ${signup_error}
    ${status#4}=  run keyword and return status  element should be visible  ${home}
    run keyword if  "${status}"=="True"  Error In New User ID Entered
    ...  ELSE IF  "${status#2}"=="True"  Error In New Password Entered
    ...  ELSE IF  "${status#3}"=="True"  Error In Entered Credential
    ...  ELSE IF  "${status#4}"=="True"  Signup Success
    ...  ELSE  fail


Error In New User ID Entered
    ${error_txt}=  get text  ${userid_error}
    ${error_txt}=  convert to uppercase  ${error_txt}
    set test message  ${error_txt}

Error In New Password Entered
    ${error_txt}=  get text  ${password_error}
    ${error_txt}=  convert to uppercase  ${error_txt}
    set test message  ${error_txt}

Error In Entered Credential
    ${error_txt}=  get text  ${signup_error}
    ${error_txt}=  convert to uppercase  ${error_txt}
    set test message  ${error_txt}

Signup Success
    ${on_page}=  log location
    set test message  SIGN UP WAS SUCCESSFUL AND USER IS NAVIGATED TO ${on_page}