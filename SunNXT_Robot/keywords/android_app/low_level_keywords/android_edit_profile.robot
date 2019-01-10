*** Settings ***
Documentation    Suite description
Library                 AppiumLibrary
Library                 Dialogs
Library                 ExcelReader
Resource                locators/android_app/profile/edit_profile.robot
Resource                keywords/android_app/low_level_keywords/android_common.robot

*** Keywords ***
Save Edited Changes
    wait until page contains  ${save_changes}
    click text  ${save_changes}

Verify User Type Is Primary
    ${edit_profile-user_type}=  get text  ${user_type}

Tap On Change Password
    click text  ${p_change_password}

Change Password
    [Arguments]  ${user_type}
    ${current_password}=  get value from corresponding row  ${signin_sheet}  User Type  ${user_type}  Password
    ${new_password}=  get value from corresponding row  ${signin_sheet}  User Type  ${user_type}  New Password
    wait until page contains  ${assert_change_password}
    input text  ${old_pass}  ${current_password}
    input text  ${new_pass}  ${new_password}
    input text  ${re-enter_pass}  ${new_password}
    click text  ${save_pass}
    edit a cell and save file  ${path}  prod_sign-in  11  4  ${current_password}
    edit a cell and save file  ${path}  prod_sign-in  11  3  ${new_password}


Tap On Edit Complete Profile
    wait until page does not contain element  ${g_loading_popup}  timeout=10
    click text  ${p_edit_complete_profile}

#full name
Get Value From Full Name Field
    ${v_full_name}=  get text  ${full_name}
    hide keyboard
    set global variable  ${v_full_name}

Edit Full Name
    ${new_full_name}=  get value from corresponding row  edit_profile  New Info  New User Info#1  Modified Name
    set global variable  ${new_full_name}
    wait until page contains element  ${assert_edit_complete_profile}
    Get Value From Full Name Field
    ${exisiting_name}=  get text  ${full_name}
    clear text  ${full_name}
    input text  ${full_name}  ${new_full_name}
    edit a cell and save file  ${path}  edit_profile  3  2  ${exisiting_name}

#mobile number
Get Value From Mobile Number
    ${v_mob_num}=  get text  ${mob_num}
    set global variable  ${v_mob_num}

Try To Edit Mobile Number
    ${change_mobile}=  get value from corresponding row  edit_profile  New Info  New User Info#1  Modified Mobile
    run keyword and ignore error  clear text  ${mob_num}
    run keyword and ignore error  input text  ${mob_num}  ${change_mobile}

#email id
Get Value From Email-ID
    ${v_email_id}=  get text  ${email_id}
    set global variable  ${v_email_id}

Try To Edit Email-ID
    ${change_email}=  get value from corresponding row  edit_profile  New Info  New User Info#1  Modified Email
    run keyword and ignore error  clear text  ${email_id}
    run keyword and ignore error  input text  ${email_id}  atcihaveedited@this.element
#age
Get Value From Age Spinner
    ${v_age}=  get text  ${age}
    set global variable  ${v_age}

Edit Age
    ${new_age}=  get value from corresponding row  edit_profile  New Info  New User Info#1  Modified Age
    set global variable  ${new_age}
#    Get Value From Age Spinner
    click element  ${age}
    wait until page contains element  ${popup_list}  timeout=10
    click text  ${new_age}

Edit Gender
    ${new_gender}=  get value from corresponding row  edit_profile  New Info  New User Info#1  Modified Gender
    run keyword if  "${new_gender}"=="MALE"  click element  ${gender_male}
    run keyword if  "${new_gender}"=="FEMALE"  click element  ${gender_female}

#country
Get Value From Country Spinner
    ${v_country}=  get text  ${country}
    set global variable  ${v_country}

Edit Country
    ${new_country}=  get value from corresponding row  edit_profile  New Info  New User Info#1  Modified Country
    set global variable  ${new_country}
#    Get Value From Country Spinner
    click element  ${country}
    wait until page contains element  ${popup_list}  timeout=10
    ${new_country}=  catenate  SEPARATOR=  xpath=//android.widget.CheckedTextView[@text='  ${new_country}  ']
    :FOR    ${index}    IN RANGE    20
#    \  swipe  ${x}  ${y2}  ${x}  ${y}
    \  ${status}=  run keyword and return status  element should be visible  ${new_country}
    \  run keyword if  "${status}"=="True"      click element  ${new_country}
    \  run keyword if  "${status}"=="False"  Swipe Up Dropdown
    \  continue for loop if  "${status}"=="False"
    \  exit for loop if  "${status}"=="True"

#state
Get Value From State Spinner
    ${v_state}=  get text  ${state}
    set global variable  ${v_state}

Edit State
    ${new_state}=  get value from corresponding row  edit_profile  New Info  New User Info#1  Modified State
    set global variable  ${new_state}
#    Get Value From State Spinner
    click element  ${state}
    ${new_state}=  catenate  SEPARATOR=  xpath=//android.widget.CheckedTextView[@text='  ${new_state}  ']
    :FOR    ${index}    IN RANGE    20
#    \  swipe  ${x}  ${y2}  ${x}  ${y}
    \  ${status}=  run keyword and return status  element should be visible  ${new_state}
    \  run keyword if  "${status}"=="True"      click element  ${new_state}
    \  run keyword if  "${status}"=="False"  Swipe Up Dropdown
    \  continue for loop if  "${status}"=="False"
    \  exit for loop if  "${status}"=="True"

#submit changes
Tap On Done Button
    click text  ${btn_done}

Edit Complete Profile
    Edit Full Name
#    hide keyboard
    Try To Edit Mobile Number
    Try To Edit Email-ID
    hide keyboard
    Edit Age
    Edit Gender
    Swipe Down
    Edit Country
    Edit State
    Tap On Done Button

Verify Full Name
    Get Value From Full Name Field
    should be equal  ${v_full_name}  ${new_full_name}

Verify Age
    Get Value From Age Spinner
    should be equal  ${v_age}  ${new_age}

Verify Country
    Get Value From Country Spinner
    should be equal  ${v_country}  ${new_country}

Verify State
    Get Value From State Spinner
    should not be equal  ${v_state}  ${new_state}