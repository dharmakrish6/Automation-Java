*** Settings ***
Documentation    Suite description
Resource                locators/android_app/profile/my_account.robot

*** Keywords ***
Click On My Content History Accordion
    click element  ${my_content_history}

#my info accordion
Click On My Info Accordion
    click element  ${my_info}

Fetch Name Displayed in My Info Accordion And Verify
    ${my_info-name}=  get text  ${mi_name}
    run keyword and ignore error  should be true  "${my_info-name}"=="${new_name}"

Fetch Email Displayed in My Info Accordion And Verify
    ${my_info-email}=  get text  ${mi_email}
    run keyword and ignore error  should be true  "${my_info-email}"=="${email}"

Fetch Mobile Number Displayed in My Info Accordion And Verify
    ${my_info-mobile}=  get text  ${mi_mob}
    run keyword and ignore error  should be true  "${my_info-mobile}"=="${mob}"

Fetch Country Displayed in My Info Accordion And Verify
    ${my_info-country}=  get text  ${mi_country}
    run keyword and ignore error  should be true  "${my_info-country}"=="${new_country}"

Fetch State Displayed in My Info Accordion And Verify
    ${my_info-state}=  get text  ${mi_state}
    run keyword and ignore error  should be true  "${my_info-state}"=="${new_state}"

Fetch Gender Displayed In My Info Accordion And Verify
    ${my_info-gender}=  get text  ${mi_gender}
    run keyword and ignore error  should be true  "${my_info-gender}"=="${ep_gender"


Click On My Subscriptions Accordion
    click element  ${my_subscriptions}

Click On Clear My Watch History Accordion
    click element  ${clear_my_watch_history}

Clear My Watch History
    wait until element is visible  ${btn-clear_watch_history}
    click element  ${btn-clear_watch_history}

Verify That Clear My Watch History Accordion Is Not Being Displayed
#    page should contain element
    page should not contain element  ${clear_my_watch_history}