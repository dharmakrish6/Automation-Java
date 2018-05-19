*** Settings ***
Documentation     Contains actions on different elements related to subscription flow
Library             SeleniumLibrary
Resource            E:/Automation-Java/SunNXT_Robot/locators/webportal/subscription.robot
Resource            E:/Automation-Java/SunNXT_Robot/variable/card_details.robot
Resource            E:/Automation-Java/SunNXT_Robot/variable/webportal/assertions.robot

*** Keywords ***
CHECK WHETHER SUBSCRIPTION POP-UP IS DISPLAYED OR NOT
    wait until element is visible  ${subscription_popup}
    log many    authentication pop-up is displayed

CLICK ON OK BUTTON OF SUN DIRECT MESSAGE
    click element  ${sundirect_message}

CLICK ON ANNUAL SUBSCRIPTION PLAN IN POP-UP
    wait until page contains element  ${popup_annual}
    click element  ${popup_annual}

SELECT MONTHLY PLAN
    click element  ${monthly_subsplan}

SELECT QUARTERLY PLAN
    click element  ${quarterly_subsplan}

SELECT ANNUAL PLAN
    click element  ${annual_subsplan}

#DEBIT CARD
SELECT DEBIT CARD AS PAYMENT MODE
    click element  ${debitcard}

SELECT DEBIT CARD TYPE
    click element  ${dc_cardtype}
    click element  ${rupay}

ENTER DEBIT CARD NUMBER
    input text  ${cardnum}  ${dc-card_number}

ENTER NAME ON DEBIT CARD
    input text  ${cardname}  ${dc-name_on_card}

SELECT MONTH VALIDITY OF CARD
    click element  ${dc_month}
    click link  ${dc-valid_upto_month}

SELECT YEAR VALIDITY OF CARD
    click element  ${dc_year}
    click link  ${dc-valid_upto_year}

ENTER CVV OF THE CARD
    input text  ${cvv}  ${dc-cvv}

UNCHECK 'SAVE THIS CARD FOR FASTER PAYMENTS'
    click element  ${dc_savecard}

PROCEED WITH THE PAYMENT
    click element  ${dc_paybtn}

CHECK WHETHER NAVIGATED PAGE IS RUPAY E-PAY OR NOT
    sleep  3s
    title should be  ${epay}


#CREDIT CARD
SELECT CREDIT CARD AS PAYMENT MODE
    click element  ${creditcard}

ENTER CREDIT CARD NUMBER
    input text  ${cardnum}  ${cc-card_number}

ENTER NAME ON CREDIT CARD
    input text  ${cardname}  ${cc-name_on_card}

SELECT MONTH VALIDITY OF CREDIT CARD
    sleep  1s
    click element  ${cc_month}
    click link  ${cc-valid_upto_month}

SELECT YEAR VALIDITY OF CREDIT CARD
    click element  ${cc_year}
    click link  ${cc-valid_upto_year}

ENTER CVV OF CREDIT CARD
    input text  ${cvv}  ${cc-cvv}

CHECK WHETHER SUBSCRIPTION IS AVAILABLE OR NOT
    ${a_subs}  get text  ${a_no_subscription}
    convert to string  ${a_subs}