*** Settings ***
Documentation    Suite description
Library          ExcelLibrary
Library          SeleniumLibrary
Resource         data_driven-test/excel_reader/sign-in.robot
Resource        locators/webportal/authentication.robot


*** Keywords ***
 Input User-Id To Test New Method
     input text  ${signup_user}  ${userid}

Input Password To Test New Method
    input text  ${signup_password}   ${userpass}

Enter Name Of The User To Test New Method
    input text  ${signup_name}  ${user_full_name}

Select Age Of The Person To Test New Method
    click element  ${signup_age}
    click link  ${user_age}

Select Residing Country Of The User To Test New Method
    input text  ${signup_country}  ${user_country}
    click link  ${user_country}

Select Residing State Of The User To Test New Method
    wait until element is visible  ${signup_state}  timeout=10
    input text  ${signup_state}  ${user_state}
    click link  ${user_state}

Fetch Sign-up Info Based On The Data Provided
    [Arguments]  ${signup_type}
    ${open_excel}=  open excel document  filename=test_data/credentials.xlsx  doc_id=cred
    set global variable  ${open_excel}
    run keyword if  "${signup_type}"=="Valid_Email_#1"    Fetch Details For Valid Email ID #1
    ...  ELSE IF  "${signup_type}"=="Invalid_Email_#1"    Fetch Details For Invalid Email ID #1


Fetch Details For Valid Email ID #1
    ${userid}=  read excel cell  12  2  sheet_name=Prod_Credential
    set global variable  ${userid}
    ${userpass}=  read excel cell  12  3  sheet_name=Prod_Credential
    set global variable  ${userpass}
    ${user_full_name}=  read excel cell  12  4  sheet_name=Prod_Credential
    set global variable  ${user_full_name}
    ${user_age}=  read excel cell  12  5  sheet_name=Prod_Credential
    set global variable  ${user_age}
    ${user_country}=  read excel cell  12  7  sheet_name=Prod_Credential
    set global variable  ${user_country}
    ${user_state}=  read excel cell  12  8  sheet_name=Prod_Credential
    set global variable  ${user_state}

Fetch Details For Invalid Email ID #1
    ${userid}=  read excel cell  15  2  sheet_name=Prod_Credential
    set global variable  ${userid}
    ${userpasss}=  read excel cell  15  3  sheet_name=Prod_Credential
    set global variable  ${userpass}
    ${user_full_name}=  read excel cell  15  4  sheet_name=Prod_Credential
    set global variable  ${user_full_name}
    ${user_age}=  read excel cell  15  5  sheet_name=Prod_Credential
    set global variable  ${user_age}
    ${user_country}=  read excel cell  15  7  sheet_name=Prod_Credential
    set global variable  ${user_country}
    ${user_state}=  read excel cell  15  8  sheet_name=Prod_Credential
    set global variable  ${user_state}