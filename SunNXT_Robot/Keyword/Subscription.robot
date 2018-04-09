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

Select Quarterly Plan
    Click Element  ${Quarterly_subsplan}

Select Annual Plan
    Click Element  ${Annual_subsplan}

#Debit Card
Select Debit Card as Payment Mode
    Click Element  ${DebitCard}

Select Debit Card Type
    sleep   2s
    Click Element  ${DC_CardType}
    Click Element  ${RUPAY}

Enter Debit Card Number
    Input Text  ${CardNum}  6072642455505890

Enter Name on Debit Card
    Input Text  ${CardName}  AMEET KUMAR PRADHAN

Select Month Validity of Card
    sleep   1s
    Click Element  ${DC_Month}
    Click Element  ${06}

Select Year Validity of Card
    Click Element  ${DC_year}
    Click Element  ${2025}

Enter CVV of the Card
    Input Text  ${cvv}  810

Uncheck 'SAVE THIS CARD FOR FASTER PAYMENTS'
    Click Element  ${DC_SaveCard}

Proceed with the payment
    Click Element  ${DC_PayBtn}

Check whether navigated page is Rupay e-Pay or not
    sleep  3s
    Title should be  ${ePay}


#Credit Card
Select Credit Card as Payment Mode
    Click Element  ${CreditCard}

Enter Credit Card Number
    Input Text  ${CardNum}  371299929307592

Enter Name on Credit Card
    Input Text  ${CardName}  Ashley Davis

Select Month validity of Credit Card
    sleep  1s
    Click Element  ${CC_Month}
    Click Link  10

Select Year validity of Credit Card
    Click Element  ${CC_Year}
    Click Link  2019

Enter CVV of Credit Card
    Input Text  ${cvv}  311