*** Settings ***
Documentation           Contains keywords related to subscription flow for Credit Card & Debit Card
Library                 SeleniumLibrary
Resource                E:/Automation-Java/SunNXT_Robot/locators/webportal/subscription.robot
Resource                E:/Automation-Java/SunNXT_Robot/test_data/card_details.robot
Resource                E:/Automation-Java/SunNXT_Robot/test_data/web_portal/assertions.robot

*** Keywords ***
Check Whether Subscription Pop-Up Is Displayed Or Not
    wait until element is visible  ${subscription_popup}
    log many    authentication pop-up is displayed

Click On Ok Button Of Sun Direct Message
    click element  ${sundirect_message}

Click On Annual Subscription Plan In Pop-Up
    wait until page contains element  ${popup_annual}
    click element  ${popup_annual}

Select Monthly Plan
    click element  ${monthly_subsplan}

Select Quarterly Plan
    click element  ${quarterly_subsplan}

Select Annual Plan
    click element  ${annual_subsplan}

#DEBIT CARD
Select Debit Card As Payment Mode
    click element  ${debitcard}

Select Debit Card Type
    click element  ${dc_cardtype}
    click element  ${rupay}

Enter Debit Card Number
    input text  ${cardnum}  ${dc-card_number}

Enter Name On Debit Card
    input text  ${cardname}  ${dc-name_on_card}

Select Month Validity Of Card
    click element  ${dc_month}
    click link  ${dc-valid_upto_month}

Select Year Validity Of Card
    click element  ${dc_year}
    click link  ${dc-valid_upto_year}

Enter Cvv Of The Card
    input text  ${cvv}  ${dc-cvv}

Uncheck 'Save This Card For Faster Payments'
    click element  ${dc_savecard}

Proceed With The Payment
    click element  ${dc_paybtn}

Check Whether Navigated Page Is Rupay E-Pay Or Not
    sleep  3s
    title should be  ${epay}


#CREDIT CARD
Select Credit Card As Payment Mode
    click element  ${creditcard}

Enter Credit Card Number
    input text  ${cardnum}  ${cc-card_number}

Enter Name On Credit Card
    input text  ${cardname}  ${cc-name_on_card}

Select Month Validity Of Credit Card
    sleep  1s
    click element  ${cc_month}
    click link  ${cc-valid_upto_month}

Select Year Validity Of Credit Card
    click element  ${cc_year}
    click link  ${cc-valid_upto_year}

Enter Cvv Of Credit Card
    input text  ${cvv}  ${cc-cvv}

Check Whether Subscription Is Available Or Not
    ${a_subs}  get text  ${a_no_subscription}
    convert to string  ${a_subs}