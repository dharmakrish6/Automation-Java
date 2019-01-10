*** Settings ***
Documentation       Suite description
Library             ExcelLibrary
Library             Dialogs

*** Keywords ***
Test title
    ${env_setup}=  get value from user  ENTER THE ENVIRONMENT THAT YOU NEED TO RUN SCRIPTS ON
    set global variable  ${env_setup}
    Choose Environment In Which Test Scripts Are To Be Run
    ${open_excel}=  open excel document  filename=test_data/credentials.xlsx  doc_id=cred
    set global variable  ${open_excel}
    ${primary_user}=  set variable  Primary
    ${credential}=  set variable  Reg_ID_Subs
    set global variable  ${credential}
    run keyword if  "${primary_user}"=="Primary"  Read The Cell For Primary

Read The Cell For Primary
    run keyword if  "${credential}"=="Reg_ID_Subs"  Assign Value to User ID

Assign Value to User ID
    ${user_id}=  read excel cell  3  2  sheet_name=${sheet_name}

Choose Environment In Which Test Scripts Are To Be Run
    run keyword if  "${env_setup}"=="Prod"  Set Sheet Name For Prod Credentials
    ...  ELSE IF  "${env_setup}"=="Pre-Prod"  Set Sheet Name For Pre-Prod Credentials
    ...  ELSE  Choose Environment In Which Test Scripts Are To Be Run

Set Sheet Name For Prod Credentials
    ${sheet_name}=  set variable  Prod_Credential
    set global variable  ${sheet_name}

Set Sheet Name For Pre-Prod Credentials
    ${sheet_name}=  set variable  Pre-Prod_Credential
    set global variable  ${sheet_name}