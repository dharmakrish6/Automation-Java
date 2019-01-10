*** Settings ***
Documentation       Subscribe to a plan using various payment modes
Resource         keywords/webportal/high_level_keywords/subscription.robot
Resource         keywords/webportal/low_level_keywords/web_common.robot
Test Setup          Open Browser And Navigate To SunNXT Website
Test Teardown       Close Opened Browser
Test Template       Subscribe A Plan From Pop-Up
Force Tags          Smoke

*** Test Cases ***                                                             page_source     content_language     subscription_plan  card_type
TEST-SCENARIO 58: SUBSCRIBE MONTHLY USING DEBIT CARD                           home            Telugu               Monthly            Debit Card
TEST-SCENARIO 59: SUBSCRIBE ANNUAL USING CREDIT CARD                           movies          Tamil                Annual             Credit Card
TEST-SCENARIO 60: SUBSCRIBE QUARTERLY USING INTERNATIONAL CREDIT CARD          live tv         Kannada              Quarterly          Credit Card International