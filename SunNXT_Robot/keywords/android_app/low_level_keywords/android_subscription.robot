*** Settings ***
Library             AppiumLibrary  run_on_failure=Capture Page Screenshot
Library             venv/Lib/site-packages/robot/libraries/String.py
Resource            locators/android_app/subscription.robot
Resource            keywords/android_app/low_level_keywords/android_common.robot

*** Keywords ***
Select Subscription Plan From Subscription Pop-Up
    [Arguments]  ${subscription_plan}
    wait until element is visible  ${popup_list}
    run keyword if  "${subscription_plan}"=="Monthly"  click text  ${subs_popup-monthly}
    run keyword if  "${subscription_plan}"=="Quarterly"  click text  ${subs_popup-quarterly}
    run keyword if  "${subscription_plan}"=="Annual"  click text  ${subs_popup-annual}

Select Payment Mode
    [Arguments]  ${card_type}
    wait until element is visible  ${available payment_modes}
    run keyword if  "${card_type}"=="Credit Card" or "${card_type}"=="Credit Card International"  click text  ${credit_card}
    run keyword if  "${card_type}"=="Debit Card"  click text  ${debit_card}
    run keyword if  "${card_type}"=="PayTM"  click text  ${paytm}
    click text  ${proceed_subs}
    wait until page contains  Selected Package  timeout=10

Select Card Type
    [Arguments]  ${card_type}
    ${card_type}=  get value from corresponding row  card_details  Card Type  ${card_type}  Card
    ${status}=  run keyword and return status  page should contain text  ${dc_cardtype}
    run keyword if  "${status}"=="True"  click text  ${dc_cardtype}
    wait until page contains element  ${popup_list}
    run keyword if  "${status}"=="True"  click text  ${card_type}
    wait until page contains  ${card_type}

Enter Card Number
    [Arguments]  ${card_type}
    ${cont}=  get current context
    log many  ${cont}
    ${card_number}=  get value from corresponding row  card_details  Card Type  ${card_type}  Card Number
    Input Text  ${card_num}  ${card_number}

Enter Card Name
    [Arguments]  ${card_type}
    ${name_on_card}=  get value from corresponding row  card_details  Card Type  ${card_type}  Card Name
    Input Text  ${card_name}  ${name_on_card}
#    hide keyboard

Select Card Expiry Month
    [Arguments]  ${card_type}
    ${expiry_month}=  get value from corresponding row  card_details  Card Type  ${card_type}  Expiry Month
    set global variable  ${expiry month}
    ${expiry_month}=  catenate  SEPARATOR=  xpath=//android.widget.CheckedTextView[@text='  ${expiry_month}  ']
    click text  ${month}
    wait until page contains element  ${popup_list}  timeout=10
    set global variable  ${expiry_month}
    :FOR    ${index}    IN RANGE    10
    \  Swipe Up Dropdown
#    \  swipe  ${x}  ${y2}  ${x}  ${y}
    \  ${status}=  run keyword and return status  element should be visible  ${expiry_month}
    \  continue for loop if  "${status}"=="False"
    \  run keyword if  "${status}"=="True"      click element  ${expiry_month}
    \  exit for loop if  "${status}"=="True"

Select Card Expiry Year
    [Arguments]  ${card_type}
    ${expiry_year}=  get value from corresponding row  card_details  Card Type  ${card_type}  Expiry Year
    set global variable  ${expiry_year}
    ${expiry_year}=  catenate  SEPARATOR=  xpath=//android.widget.CheckedTextView[@text='  ${expiry_year}  ']
    click text  ${year}
    wait until page contains element  ${popup_list}  timeout=10
    :FOR    ${index}    IN RANGE    10
    \  Swipe Up Dropdown
#    \  swipe  ${x}  ${y2}  ${x}  ${y}
    \  ${status}=  run keyword and return status  element should be visible  ${expiry_year}
    \  continue for loop if  "${status}"=="False"
    \  run keyword if  "${status}"=="True"      click element  ${expiry_year}
    \  exit for loop if  "${status}"=="True"


Enter CVV Of Card
    [Arguments]  ${card_type}
    ${card_cvv}=  get value from corresponding row  card_details  Card Type  ${card_type}  CVV
    Input Text  ${cvv}  ${card_cvv}

De-Authorize Auto-Renewal
    [Arguments]  ${auto_renewal}
    run keyword if  "${auto_renewal}"=="No"  click element  ${checkbox}

Proceed With Subcription
    swipe by percent  ${sd-x_starts}  ${sd-y_starts}  ${sd-x_ends}  ${sd-y_ends}
    click text  ${cc_pay}