*** Settings ***
Documentation    Suite description
Resource         ../Locators/Subscription.robot
Resource        ../Variable/Variables.robot

*** Keywords ***
Check whether subscription pop-up is displayed or not
    Wait Until Element Is Visible  ${subscription_popup}
    Log Many    Authentication pop-up is displayed


Select Monthly Plan
    Click Element  ${Monthly_subsplan}

Select Debit Card as Payment Mode
    Click Element  ${DebitCard}

Select Debit Card Type
    sleep   2s
    Click Element  ${DC_CardType}
    Click Element  ${RUPAY}

Enter Debit Card Number
    Input Text  ${DC_CardNum}  6072642455505890

Enter Name on Card
    Input Text  ${DC_CardName}  AMEET KUMAR PRADHAN

Select Month Validity of Card
    Click Element  ${DC_Month}
    Click Element  ${06}

Select Year Validity of Card
    Click Element  ${DC_year}
    Click Element  ${2025}

Enter CVV of the Card
    Input Text  ${DC_cvv}  810

Uncheck 'SAVE THIS CARD FOR FASTER PAYMENTS'
    Click Element  ${DC_SaveCard}

Proceed with the payment
    Click Element  ${DC_PayBtn}

Check whether navigated page is PayUbiz or not
    sleep  3s
    Title should be  ${ePay}