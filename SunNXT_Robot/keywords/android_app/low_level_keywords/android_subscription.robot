*** Settings ***
Library             AppiumLibrary  run_on_failure=Capture Page Screenshot
Library             String
Resource            ../locators/android_app/subscription.robot
Resource            ../keywords/android_app/low_level_keywords/android_common.robot

*** Keywords ***
Select Subscription Plan From Subscription Pop-Up
    [Arguments]  ${subscription_plan}
    wait until element is visible  ${popup-subs_list}
    run keyword if  "${subscription_plan}"=="Monthly"  click text  ${subs_popup-monthly}
    run keyword if  "${subscription_plan}"=="Quarterly"  click text  ${subs_popup-quarterly}

Select Payment Mode
    [Arguments]  ${payment_mode}
    wait until element is visible  ${available payment_modes}
    run keyword if  "${payment_mode}"=="Credit Card"  click text  ${credit_card}
    run keyword if  "${payment_mode}"=="Debit Card"  click text  ${debit_card}
    run keyword if  "${payment_mode}"=="PayTM"  click text  ${paytm}
    click text  ${proceed_subs}
    wait until page contains  Selected Package  timeout=10

Select Card Type
    [Arguments]  ${card_type}
    ${status}=  run keyword and return status  page should contain text  ${dc_cardtype}
    run keyword if  "${status}"=="True"  click text  ${dc_cardtype}
    run keyword if  "${status}"=="True"  click text  ${card_type}

Enter Card Number
    [Arguments]  ${card_number}
    Input Text  ${card_num}  ${card_number}

Enter Card Name
    [Arguments]  ${name_on_card}
    Input Text  ${card_name}  ${name_on_card}
    hide keyboard

Select Card Expiry Month
    [Arguments]  ${expiry_month}
    set global variable  ${expiry month}
    click text  ${month}
    Swipe Up Dropdown
    ${expiry_month}=  catenate  SEPARATOR=  xpath=//android.widget.CheckedTextView[@text='  ${expiry_month}  ']
    set global variable  ${expiry_month}

    :FOR    ${index}    IN RANGE    10
    \  swipe  ${x}  ${y2}  ${x}  ${y}
    \  ${status}=  run keyword and return status  element should be visible  ${expiry_month}
    \  continue for loop if  "${status}"=="False"
    \  run keyword if  "${status}"=="True"      click element  ${expiry_month}
    \  exit for loop if  "${status}"=="True"

Select Card Expiry Year
    [Arguments]  ${expiry_year}
    click text  ${year}
    Swipe Up Dropdown
    ${expiry_year}=  catenate  SEPARATOR=  xpath=//android.widget.CheckedTextView[@text='  ${expiry_year}  ']
    set global variable  ${expiry_year}

    :FOR    ${index}    IN RANGE    10
    \  swipe  ${x}  ${y2}  ${x}  ${y}
    \  ${status}=  run keyword and return status  element should be visible  ${expiry_year}
    \  continue for loop if  "${status}"=="False"
    \  run keyword if  "${status}"=="True"      click element  ${expiry_year}
    \  exit for loop if  "${status}"=="True"


Enter CVV Of Card
    [Arguments]  ${card_cvv}
    Input Text  ${cvv}  ${card_cvv}

De-Authorize Auto-Renewal
    [Arguments]  ${auto_renewal}
    run keyword if  "${auto_renewal}"=="No"  click element  ${checkbox}

Proceed With Subcription
    click text  ${cc_pay}