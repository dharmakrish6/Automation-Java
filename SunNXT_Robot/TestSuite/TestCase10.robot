*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Keyword/Common.robot
Resource         ../Keyword/Content/HomePage.robot
Resource         ../Keyword/Player.robot
Resource         ../Keyword/VOD-DetailsScreen.robot
Resource         ../Keyword/Content/HomePage.robot
Resource         ../Variable/Variables.robot
Resource         ../Keyword/Subscription.robot

*** Test Cases ***
TestCase 3: Login with valid credentials and stream a Live TV channel
    [Documentation]     This is to verify valid login for SunNXT web-page and logout
    [Tags]              Content Streaming
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
        Enter Name on Card
        Select Month Validity of Card
        Select Year Validity of Card
        Enter CVV of the Card
        Uncheck 'SAVE THIS CARD FOR FASTER PAYMENTS'
        Proceed with the payment
        Check whether navigated page is PayUbiz or not

    [Teardown]
        Close Browser