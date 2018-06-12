*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Keyword/Common.robot
Resource         ../Variable/Variables.robot
Resource         ../Keyword/Subscription.robot

*** Test Cases ***
TestCase 10: Login with a credential with no subscription and navigate till 'Enter OTP' page using Debit Card
    [Documentation]     This is to verify subscription flow for Debit Card works properly or not
    [Tags]              Subscription
    [Setup]
        Open Browser
        Navigate to SunNXT web-portal
        Verify the homepage title
        Click on Profile authentication icon
        Click on Sign In link from dropdown
        sleep       1s
        Enter UserID with no subscription
        Enter Password
        sleep       1s
        Click on Submit button
        sleep       ${timeout}
        Click on Profile button
        Click on subscription link
        Select Monthly Plan
        Select Debit Card as Payment Mode
        Select Debit Card Type
        Enter Debit Card Number
        Enter Name on Debit Card
        Select Month Validity of Card
        Select Year Validity of Card
        Enter CVV of the Card
        Uncheck 'SAVE THIS CARD FOR FASTER PAYMENTS'
        Proceed with the payment
        Check whether navigated page is Rupay e-Pay or not

    [Teardown]
        Close Browser