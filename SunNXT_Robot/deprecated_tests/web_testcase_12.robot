*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Keyword/Common.robot
Resource         ../Variable/Variables.robot
Resource         ../Keyword/Content/HomePage.robot
Resource         ../Keyword/Player.robot
Resource         ../Keyword/Subscription.robot

*** Test Cases ***
TestCase 12: Login with a Sun-Direct credential with no subscription and navigate till 'Enter OTP' page
    [Documentation]     This is to verify subscription flow for SunDirect users via Debit Card works properly or not
    [Tags]              Subscription
    [Setup]
        Open Browser
        Navigate to SunNXT web-portal
        Verify the homepage title
        Click on Profile authentication icon
        Click on Sign In link from dropdown
        sleep       1s
        Enter SunDirect Credential UserID with no subscription
        Enter Password
        sleep       1s
        Click on Submit button
        sleep       ${timeout}
        Click on Movie header link
        sleep   7s
        Click on Play Now button in movies
        Click on Play button
        Click on OK button of Sun Direct message
        Click on Annual Subscription Plan in pop-up
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