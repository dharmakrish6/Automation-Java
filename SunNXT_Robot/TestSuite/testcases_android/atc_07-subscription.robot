*** Settings ***
Documentation       Subscribe to a plan using various payment modes
Library             AppiumLibrary
Resource         keywords/android_app/low_level_keywords/android_common.robot
Resource         keywords/android_app/high_level_keywords/subscription.robot
Test Setup          Launch App
Test Teardown       Close App
Test Template       Subscribe A Plan From Pop-Up

*** Test Cases ***                                                     user_type        content_language  content_header  subscription_plan  card_type                  auto_renewal
TEST-SCENARIO 89: SUBSCRIBE MONTHLY USING DEBIT CARD                   ID_SunDirect_Exp     Tamil             movies          Annual             Debit Card                 Yes
#TEST-SCENARIO 90: SUBSCRIBE ANNUAL USING CREDIT CARD                   ID_SunDirect_Exp Telugu           live tv          Monthly            Credit Card               Yes
#TEST-SCENARIO 91: SUBSCRIBE QUARTERLY USING INTERNATIONAL CREDIT CARD  ID_Email_Exp     Kannada           tv shows        Quarterly          Credit Card International No