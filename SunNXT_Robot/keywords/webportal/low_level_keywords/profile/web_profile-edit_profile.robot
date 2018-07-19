*** Settings ***
Documentation    Suite description
Resource            ../locators/webportal/profile.robot

*** Keywords ***
Modify The Provided Name Of User
    [Arguments]  ${new_name}
    clear element text  ${ep_name}
    input text  ${ep_name}  ${new_name}

Last Name Should Not Be Present In The Page
    run keyword and ignore error  page should not contain element  ${ep_last_name}

Try To Edit Mobile Number
    run keyword and ignore error  Clear And Input Mobile Number Field
    ${mob}=  get text  ${ep_mobile}
    set global variable  ${mob}

Clear And Input Mobile Number Field
    clear text  ${ep_mobile}
    input text  ${ep_mobile}  9999999901

Try To Edit E-Mail ID
    run keyword and ignore error  Clear And Input in Email ID Field
    ${email}=  get text  ${ep_email_id}
    set global variable  ${email}

Clear And Input in Email ID Field
    clear element text  ${ep_email_id}
    input text  ${ep_email_id}  ihaveedited@this.element

Edit Age Of The User
    [Arguments]  ${new_age}
    click element  ${ep_age}
    ${age}=  set variable if  "${new_age}"=="18-25 Years"  1
    ...  "${new_age}"=="26-30 Years"  2
    ...  "${new_age}"=="31-35 Years"  3
    ...  "${new_age}"=="36-40 Years"  4
    ...  "${new_age}"=="41-50 Years"  5
    ...  "${new_age}"=="51-60 Years"  6
    ...  "${new_age}"=="61-70 Years"  7
    ...  "${new_age}"=="71-80 Years"  8
    ...  "${new_age}"=="81-90 Years"  9
    ${age}=  catenate  SEPARATOR=  css: form [data-original-index="  ${age}  "] .text
    click element  ${age}

Change Gender Of The User
    [Arguments]  ${new_gender}
    run keyword if  "${new_gender}"=="FEMALE"  Change Gender As Female
    ...  ELSE IF  "${new_gender}"=="MALE"  Change Gender As Male

Change Gender As Male
    ${m_selected}=  run keyword and return status  page should contain element  ${ep_gender_m-selected}
    run keyword if  "${m_selected}"=="True"  log many  SELECTING GENDER AS FEMALE
    run keyword if  "${m_selected}"=="True"  click element  ${ep_gender_f}
    ...  ELSE  click element  ${ep_gender_m}

Change Gender As Female
    ${f_selected}=  run keyword and return status  page should contain element  ${ep_gender_f-selected}
    run keyword if  "${f_selected}"=="True"  log many  SELECTING GENDER AS MALE
    run keyword if  "${f_selected}"=="True"  click element  ${ep_gender_m}
    ...  ELSE  click element  ${ep_gender_f}

Select Country
    [Arguments]  ${new_country}
    input text  ${ep_country}  ${new_country}
    click link  ${new_country}

Select State
    [Arguments]  ${new_state}
    input text  ${ep_state}  ${new_state}
    click link  ${new_state}

Save Edited Changes
    click element  ${ep_btn_done}