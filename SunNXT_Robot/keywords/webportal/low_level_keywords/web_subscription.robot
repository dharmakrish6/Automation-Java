*** Settings ***
Documentation           Contains keywords related to subscription flow for Credit Card & Debit Card
Library                 SeleniumLibrary
Library                 ExcelReader
Resource                locators/webportal/subscription.robot
Resource                test_data/web_portal/assertions.robot

*** Keywords ***
Dismiss Sun Direct Expiry Pop-up
    ${status}=  run keyword and return status  element should be visible  ${sundirect_message}  timeout=${extended_wait}
    run keyword if  "${status}"=="True"  click element  ${popup_ok}

Select Subscription Plan From Subscription Pop-Up
    [Arguments]  ${subscription_plan}
    wait until element is visible  ${subscription_popup}  timeout=${extended_wait}
    run keyword if  "${subscription_plan}"=="Monthly"  click element  ${popup_monthly}
    run keyword if  "${subscription_plan}"=="Quarterly"  click element  ${popup_quarterly}
    run keyword if  "${subscription_plan}"=="Annual"  click element  ${popup_annual}

Select Payment Mode
    [Arguments]  ${card_type}
    wait until element is visible  ${available payment_modes}
    run keyword if  "${card_type}"=="Credit Card" or "${card_type}"=="Credit Card International"  click link  ${credit_card}
    run keyword if  "${card_type}"=="Debit Card"  click link  ${debit_card}
    run keyword if  "${card_type}"=="PayTM"  click link  ${paytm}

Select Card Type
    [Arguments]  ${card_type}
    wait until page does not contain element  ${loading_subscription}  timeout=${extended_wait}
    ${card_type}=  get value from corresponding row  card_details  Card Type  ${card_type}  Card
    ${status}=  run keyword and return status  page should contain element  ${dc_cardtype}
    run keyword if  "${status}"=="True"  click element  ${dc_cardtype}
    run keyword if  "${status}"=="True"  click link  ${card_type}

Enter Card Number
    [Arguments]  ${card_type}
    ${card_number}=  get value from corresponding row  card_details  Card Type  ${card_type}  Card Number
    Input Text  ${card_num}  ${card_number}

Enter Card Name
    [Arguments]  ${card_type}
    ${name_on_card}=  get value from corresponding row  card_details  Card Type  ${card_type}  Card Name
    Input Text  ${card_name}  ${name_on_card}

Select Card Expiry Month
    [Arguments]  ${card_type}
    ${expiry_month}=  get value from corresponding row  card_details  Card Type  ${card_type}  Expiry Month
    ${expiry_month}=  convert to integer  ${expiry_month}
    ${expiry_month}=  convert to string  ${expiry_month}
    wait until element is visible  ${month}  timeout=${extended_wait}
    click element  ${month}
    wait until element is visible  ${month_pop-up}  timeout=${extended_wait}
    click link  ${expiry_month}

Select Card Expiry Year
    [Arguments]  ${card_type}
    ${expiry_year}=  get value from corresponding row  card_details  Card Type  ${card_type}  Expiry Year
    ${expiry_year}=  convert to integer  ${expiry_year}
    ${expiry_year}=  convert to string  ${expiry_year}
    click element  ${year}
    wait until element is visible  ${year_pop-up}  timeout=${extended_wait}
    click link  ${expiry_year}

Enter CVV Of Card
    [Arguments]  ${card_type}
    ${card_cvv}=  get value from corresponding row  card_details  Card Type  ${card_type}  CVV
    ${card_cvv}=  convert to integer  ${card_cvv}
    ${card_cvv}=  convert to string  ${card_cvv}
    Input Text  ${cvv}  ${card_cvv}

De-Authorize Auto-Renewal
    [Arguments]  ${card_type}
    ${auto_renewal}=  get value from corresponding row  card_details  Card Type  ${card_type}  Auto Renewal
    run keyword if  "${auto_renewal}"=="No"  click element  ${checkbox}

Proceed With Subcription
    click element  ${cc_pay}

Check If Navigated To OTP Screen Or Not
    title should be  ${epay}