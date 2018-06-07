*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Keyword/Common.robot
Resource         ../Variable/Variables.robot
Resource         ../Keyword/Subscription.robot

*** Test Cases ***
TestCase 11: Login with a credential with no subscription and navigate till 'Enter OTP' page using Credit Card
    #NOTE: Payment Fails as Credit Card Test Data provided is dummy one
    [Documentation]     This is to verify subscription flow for Credit Card works properly or not
    [Tags]              Subscription
    [Setup]
    [Template]
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
        Select Credit Card as Payment Mode
        Enter Credit Card Number
        Enter Name on Credit Card
        Select Month Validity of Credit Card
        Select Year Validity of Credit Card
        Enter CVV of Credit Card
        Uncheck 'SAVE THIS CARD FOR FASTER PAYMENTS'
        Proceed with the payment
        sleep  10s

    [Teardown]
        Close Browser