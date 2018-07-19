*** Settings ***
Documentation    Suite description
Library                 AppiumLibrary
Library                 Dialogs
Resource                ../locators/android_app/profile/edit_profile.robot
Resource                ../keywords/android_app/low_level_keywords/android_common.robot

*** Keywords ***
Save Edited Changes
    wait until page contains  ${save_changes}
    click text  ${save_changes}

Verify User Type Is Primary
    ${edit_profile-user_type}=  get text  ${user_type}

Tap On Change Password
    click text  ${p_change_password}

Change Password
    [Arguments]  ${current_password}  ${new_password}
    wait until page contains  ${assert_change_password}
    input text  ${old_pass}  ${current_password}
    input text  ${new_pass}  ${new_password}
    input text  ${re-enter_pass}  ${new_password}
    click text  ${save_pass}

Tap On Edit Complete Profile
    wait until page does not contain element  ${g_loading_popup}  timeout=10
    click text  ${p_edit_complete_profile}

#full name
Get Value From Full Name Field
    ${v_full_name}=  get text  ${full_name}
    hide keyboard
    set global variable  ${v_full_name}

Edit Full Name
    [Arguments]  ${new_full_name}
    wait until page contains element  ${assert_edit_complete_profile}
    Get Value From Full Name Field
    run keyword if  "${new_full_name}"=="${v_full_name}"  ${new_full_name}=  get value from user  ENTERED NAME IS SIMILAR TO THE ONE THAT EXISTS. PLEASE ENTER A NEW ONE:
    clear text  ${full_name}
    input text  ${full_name}  ${new_full_name}

#mobile number
Get Value From Mobile Number
    ${v_mob_num}=  get text  ${mob_num}
    set global variable  ${v_mob_num}

Try To Edit Mobile Number
    run keyword and ignore error  clear text  ${mob_num}
    run keyword and ignore error  input text  ${mob_num}  8888888888

#email id
Get Value From Email-ID
    ${v_email_id}=  get text  ${email_id}
    set global variable  ${v_email_id}

Try To Edit Email-ID
    run keyword and ignore error  clear text  ${email_id}
    run keyword and ignore error  input text  ${email_id}  atcihaveedited@this.element
#age
Get Value From Age Spinner
    ${v_age}=  get text  ${age}
    set global variable  ${v_age}

Edit Age
    [Arguments]  ${new_age}
    Get Value From Age Spinner
    run keyword if  "${new_age}"=="${v_age}"  ${new_age}=  get value from user  ENTERED AGE IS SIMILAR TO THE ONE THAT EXISTS. PLEASE ENTER A NEW ONE:
    click element  ${age}
    click text  ${new_age}

Edit Gender
    [Arguments]  ${new_gender}
    run keyword if  "${new_gender}"=="MALE"  click element  ${gender_male}
    run keyword if  "${new_gender}"=="FEMALE"  click element  ${gender_female}

#country
Get Value From Country Spinner
    ${v_country}=  get text  ${country}
    set global variable  ${v_country}

Edit Country
    [Arguments]  ${new_country}
    Get Value From Country Spinner
    run keyword if  "${new_country}"=="${v_country}"  ${new_country}=  get value from user  ENTERED COUNTRY IS SIMILAR TO THE ONE THAT EXISTS. PLEASE ENTER A NEW ONE:
    click element  ${country}
    Swipe Up Dropdown
    ${new_country}=  catenate  SEPARATOR=  xpath=//android.widget.CheckedTextView[@text='  ${new_country}  ']
    set global variable  ${new_country}

    :FOR    ${index}    IN RANGE    20
    \  swipe  ${x}  ${y2}  ${x}  ${y}
    \  ${status}=  run keyword and return status  element should be visible  ${new_country}
    \  continue for loop if  "${status}"=="False"
    \  run keyword if  "${status}"=="True"      click element  ${new_country}
    \  exit for loop if  "${status}"=="True"

#state
Get Value From State Spinner
    ${v_state}=  get text  ${state}
    set global variable  ${v_state}

Edit State
    [Arguments]  ${new_state}
    Get Value From State Spinner
    run keyword if  "${new_state}"=="${v_state}"  ${new_state}=  get value from user  ENTERED STATE IS SIMILAR TO THE ONE THAT EXISTS. PLEASE ENTER A NEW ONE:
    click element  ${state}
    Swipe Up Dropdown
    ${new_state}=  catenate  SEPARATOR=  xpath=//android.widget.CheckedTextView[@text='  ${new_state}  ']
    set global variable  ${new_state}

    :FOR    ${index}    IN RANGE    20
    \  swipe  ${x}  ${y2}  ${x}  ${y}
    \  ${status}=  run keyword and return status  element should be visible  ${new_state}
    \  continue for loop if  "${status}"=="False"
    \  run keyword if  "${status}"=="True"      click element  ${new_state}
    \  exit for loop if  "${status}"=="True"

#submit changes
Tap On Done Button
    click text  ${btn_done}

Edit Complete Profile
    [Arguments]  ${new_full_name}  ${new_age}  ${new_gender}  ${new_country}  ${new_state}
    Edit Full Name  ${new_full_name}
    Try To Edit Mobile Number
    Try To Edit Email-ID
    Edit Age  ${new_age}
    Edit Gender  ${new_gender}
    Swipe Down
    Edit Country  ${new_country}
    Edit State  ${new_state}
    Tap On Done Button

Verify Full Name
    [Arguments]  ${new_full_name}
    Get Value From Full Name Field
    should be equal  ${v_full_name}  ${new_full_name}

Verify Age
    [Arguments]  ${new_age}
    Get Value From Age Spinner
    should be equal  ${v_age}  ${new_age}

Verify Country
    [Arguments]  ${new_country}
    Get Value From Country Spinner
    should be equal  ${v_country}  ${new_country}

Verify State
    [Arguments]  ${new_state}
    Get Value From State Spinner
    should not be equal  ${v_state}  ${new_state}