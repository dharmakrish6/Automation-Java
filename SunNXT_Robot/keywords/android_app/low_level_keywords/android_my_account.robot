*** Settings ***
Documentation    Suite description
Resource                ../locators/android_app/my_account.robot
Resource                ../locators/android_app/common.robot

*** Keywords ***
Tap On My Info
    wait until page does not contain element  ${g_loading_animation}
    wait until page does not contain element  ${loading_animation}
    click text  ${my_info}

Get Value For Name and Verify
    ${name}=  get text  ${mi_name}
    run keyword and continue on failure  should be equal  ${name}  ${v_full_name}  msg=DIDNOT MATCH  values=True

Get Value For Email-ID and Verify
    ${email_id}=  get text  ${mi_email}
    run keyword and continue on failure  should be equal  ${email_id}"=="${v_email_id}"  msg=DIDNOT MATCH  values=True

Get Value For Mobile Number and Verify
    ${mob_num}=  get text  ${mi_mob_num}
    run keyword and continue on failure  should be equal  ${mob_num}  ${v_mob_num}  msg=DIDNOT MATCH  values=True

Get Value For Country and Verify
    ${country}=  get text  ${mi_country}
    run keyword and continue on failure  should be equal  ${country}  ${v_country}  msg=DIDNOT MATCH  values=True

Get Value For State and Verify
    ${state}=  get text  ${mi_state}
    run keyword and continue on failure  should be equal  ${state}  ${v_state}  msg=DIDNOT MATCH  values=True

Get Value For Age and Verify
    ${age}=  get text  ${mi_age}
    run keyword and continue on failure  should be equal  ${age}  ${v_age}  msg=DIDNOT MATCH  values=True