*** Settings ***
Documentation           Contains keywords related to subscription flow for Credit Card & Debit Card
Library                 SeleniumLibrary
Resource                ../locators/webportal/subscription.robot
Resource                ../test_data/web_portal/assertions.robot

*** Keywords ***
Dismiss Sun Direct Expiry Pop-up
    ${status}=  run keyword and return status  page should contain element  ${sundirect_message}  timeout=10
    run keyword if  "${status}"=="True"  click element  ${popup_ok}
#    wait until element is not visible  ${sundirect_message}  timeout=10
    alert should be present

Select Subscription Plan From Subscription Pop-Up
    [Arguments]  ${subscription_plan}
    wait until element is visible  ${subscription_popup}
    run keyword if  "${subscription_plan}"=="Monthly"  click element  ${popup_monthly}
    run keyword if  "${subscription_plan}"=="Quarterly"  click element  ${popup_quarterly}
    run keyword if  "${subscription_plan}"=="Annual"  click element  ${popup_annual}

Select Payment Mode
    [Arguments]  ${payment_mode}
    wait until element is visible  ${available payment_modes}
    run keyword if  "${payment_mode}"=="Credit Card"  click element  ${credit_card}
    run keyword if  "${payment_mode}"=="Debit Card"  click element  ${debit_card}
    run keyword if  "${payment_mode}"=="PayTM"  click element  ${paytm}

Select Card Type
    [Arguments]  ${card_type}
    ${status}=  run keyword and return status  page should contain element  ${dc_cardtype}
    run keyword if  "${status}"=="True"  click element  ${dc_cardtype}
    run keyword if  "${status}"=="True"  click link  ${card_type}

Enter Card Number
    [Arguments]  ${card_number}
    Input Text  ${card_num}  ${card_number}

Enter Card Name
    [Arguments]  ${name_on_card}
    Input Text  ${card_name}  ${name_on_card}

Select Card Expiry Month
    [Arguments]  ${expiry_month}
    wait until element is visible  ${month}  timeout=10
    click element  ${month}
    click link  ${expiry_month}

Select Card Expiry Year
    [Arguments]  ${expiry_year}
    click element  ${year}
    click link  ${expiry_year}

Enter CVV Of Card
    [Arguments]  ${card_cvv}
    Input Text  ${cvv}  ${card_cvv}

De-Authorize Auto-Renewal
    [Arguments]  ${auto_renewal}
    run keyword if  "${auto_renewal}"=="No"  click element  ${checkbox}

Proceed With Subcription
    click element  ${cc_pay}

Check If Navigated To OTP Screen Or Not
    title should be  ${epay}



    select from list by value