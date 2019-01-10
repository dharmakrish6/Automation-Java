*** Settings ***
Documentation    Suite description
Library                 SeleniumLibrary
Library                 Dialogs
Resource                locators/webportal/profile.robot

*** Keywords ***
Click On Edit Profile Icon
    click element  ${editprofile_icon}

Wait Until Edit Profile Slide-In Is Displayed
    wait until page contains element  ${edit_profile-slide_in}

#profile name slide-in
Change Profile Name
    [Arguments]  ${user_name}
    clear text  ${p-username}
    input text  ${p-username}  ${user_name}

Get Profile Name Value And Verify
    [Arguments]  ${user_name}
    ${v_username}=  get text  ${p-username}
    run keyword if  "${v_username}"=="${user_name}"  log many  PROFILE NAME CHANGE WAS SUCCESSFUL
    ...  ELSE  log many  PROFILE NAME WAS NOT CHANGED

#profile mail-id slide-in
Change Profile Email-ID
    [Arguments]  ${email_id}
    clear text  ${p-email_id}
    input text  ${p-email_id}  ${email_id}

Get Profile Email-ID Value And Verify
    [Arguments]  ${email_id}
    ${v_email_id}=  get text  ${p-email_id}
    run keyword if  "${v_email_id}"=="${email_id}"  log many  EMAIL ID CHANGE WAS SUCCESSFUL
    ...  ELSE  log many  EMAIL ID WAS NOT CHANGED

Save Changes Made in Profile Slide-In
    click element  ${p-btn_done}

Navigate to Edit Complete Profile Page
    click element  ${p-edit_complete_profile}

Wait Until Navigated To Edit Complete Profile Page
    wait until page contains element  ${edit_profile_page}

#Name in Edit Profile Page
Change Name in Edit Complete Profile
    [Arguments]  ${new_username}
    clear text  ${ep_name}
    input text  ${ep_name}  ${new_username}
    ${status}=  page should not contain element  ${ep_last_name}
    run keyword and ignore error  should be true  ${status}==True

Get Value Of Name in Edit Complete Profile And Verify
    [Arguments]  ${new_username}
    ${v_ep-name}=  get text  ${ep_name}
    run keyword if  "${v_ep-name}"=="${new_username}"  log many  NAME CHANGE WAS SUCCESSFUL
    ...  ELSE  log many  NAME WAS NOT CHANGED

Try To Edit Mobile Number
    clear text  ${ep_mobile}
    input text  ${ep_mobile}  9999999999



Try To Edit Email ID
    clear text  ${ep_email_id}
    input text  ${ep_email_id}  wtcihaveedited@this.element

Change Age In Edit Profile
    [Arguments]  ${new_age}
    click element  ${ep_age}
    click text  ${new_age}

# Change Gender
Change Selected Gender
    [Arguments]  ${new_gender}
    set global variable  ${new_gender}
    run keyword if  "${new_gender}"=="MALE"  Select Gender Male
    ...  ELSE IF  "${new_gender}"=="FEMALE"  Select Gender Female
    ...  ELSE  Gender Entered In Test Data Is Already Selected Or Invalid

Select Gender Male
    ${status-male_selected}=  run keyword and return status  page should not contain element  ${ep_gender_m-selected}
    run keyword if  "${status-male_selected}"=="True"  click element  ${ep_gender_m}
    ...  ELSE  Gender Entered In Test Data Is Already Selected Or Invalid

Select Gender Female
    ${status-female_selected}=  run keyword and return status  page should not contain element  ${ep_gender_f-selected}
    run keyword if  "${status-female_selected}"=="True"  click element  ${ep_gender_f}
    ...  ELSE  Gender Entered In Test Data Is Already Selected Or Invalid

Gender Entered In Test Data Is Already Selected Or Invalid
    ${new_gender}=  get value from user  ENTERED GENDER "${new_gender}" IS ALREADY SELECTED OR INVALID. ENTER A NEW ONE
    set global variable  ${new_gender}
    Change Selected Gender

#
Change Selected Country
    [Arguments]  ${new_country}
    click element  ${ep_country}
    click text  ${new_country}

Get Value Of Selected Country And Verify
    [Arguments]  ${new_country}
    ${v_country}=  get text  ${ep_country-selected}
    run keyword if  "${v_country}"=="${new_country}"  log many  COUNTRY NAME CHANGE WAS SUCCESSFUL
    ...  ELSE  log many  COUNTRY NAME WAS NOT CHANGED

Change Selected State
    [Arguments]  ${new_state}
    click element  ${ep_state}
    click text  ${new_state}

Get Value Of Selected State And Verify
    [Arguments]  ${new_state}
    ${v_state}=  get text  ${ep_country-selected}
    run keyword if  "${v_state}"=="${new_state}"  log many  STATE NAME CHANGE WAS SUCCESSFUL
    ...  ELSE  log many  STATE NAME WAS NOT CHANGED

Save Profile Changes
    click element  ${ep_btn_done}