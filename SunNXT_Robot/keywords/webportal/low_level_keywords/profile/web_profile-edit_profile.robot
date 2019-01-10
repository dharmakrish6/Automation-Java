*** Settings ***
Documentation    Suite description
Resource            locators/webportal/profile.robot
Library             ExcelReader

*** Keywords ***
Modify The Provided Name Of User
    [Arguments]  ${user_info}
    ${new_name}=  get value from corresponding row  edit_profile  New Info  ${user_info}  Modified Name
    clear element text  ${ep_name}
    input text  ${ep_name}  ${new_name}
    set global variable  ${new_name}

Last Name Should Not Be Present In The Page
    run keyword and ignore error  page should not contain element  ${ep_last_name}

Try To Edit Mobile Number
    [Arguments]  ${user_info}
    run keyword and ignore error  Clear And Input Mobile Number Field  ${user_info}
    ${mob}=  get text  ${ep_mobile}
    set global variable  ${mob}

Clear And Input Mobile Number Field
    [Arguments]  ${user_info}
    ${new_mobile}=  get value from corresponding row  edit_profile  New Info  ${user_info}  Modified Mobile
    clear text  ${ep_mobile}
    input text  ${ep_mobile}  ${new_mobile}

Try To Edit E-Mail ID
    [Arguments]  ${user_info}
    ${new_email}=  get value from corresponding row  edit_profile  New Info  ${user_info}  Modified Email
    run keyword and ignore error  Clear And Input in Email ID Field
    ${email}=  get text  ${ep_email_id}
    set global variable  ${email}
    run keyword and ignore error  input text  ${ep_email_id}  ${new_email}

Clear And Input in Email ID Field
    clear element text  ${ep_email_id}
    input text  ${ep_email_id}  ihaveedited@this.element

Edit Age Of The User
    [Arguments]  ${user_info}
    ${new_age}=  get value from corresponding row  edit_profile  New Info  ${user_info}  Modified Age
    click element  ${ep_age}
    click link  ${new_age}

Change Gender Of The User
    [Arguments]  ${user_info}
    ${new_gender}=  get value from corresponding row  edit_profile  New Info  ${user_info}  Modified Gender
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
    [Arguments]  ${user_info}
    ${new_country}=  get value from corresponding row  edit_profile  New Info  ${user_info}  Modified Country
    set global variable  ${new_country}
    click element  ${ep_country}
    input text  css: div#selectcountry_chosen input  ${new_country}
    ${new_country}=  catenate  SEPARATOR=  //div[@id='selectcountry_chosen']//ul[@class='chosen-results']/li[.='  ${new_country}  ']
    click element  xpath:${new_country}

Select State
    [Arguments]  ${user_info}
    ${new_state}=  get value from corresponding row  edit_profile  New Info  ${user_info}  Modified State
    set global variable  ${new_state}
    click element  ${ep_state}
    input text  css: #stateid_chosen .chosen-search-input  ${new_state}
    ${new_state}=  catenate  SEPARATOR=  //div[@id='stateid_chosen']//ul[@class='chosen-results']/li[.='  ${new_state}  ']
    click element  xpath:${new_state}

Save Edited Changes
    click element  ${ep_btn_done}