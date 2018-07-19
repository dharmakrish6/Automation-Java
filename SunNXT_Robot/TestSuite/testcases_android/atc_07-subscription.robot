*** Settings ***
Documentation       Subscribe to a plan using various payment modes
Resource            ../keywords/android_app/low_level_keywords/android_common.robot
Resource            ../keywords/android_app/high_level_keywords/authentication.robot
Resource            ../test_data/credentials.robot
Resource            ../keywords/android_app/high_level_keywords/subscription.robot
Resource            ../test_data/card_details.robot
Test Setup          LOGIN VIA APP  ${reg_id-sd_exp}  ${reg_pass-sd_exp}
Test Teardown       Close App
Test Template       Subscribe A Plan From Pop-Up

*** Test Cases ***                                                     content_language  content_header  carousel_title       content              subscription_plan      payment_mode     card_type        card_number          name_on_card            expiry_month             expiry_year             card_cvv        auto_renewal
TEST-SCENARIO 89: SUBSCRIBE MONTHLY USING DEBIT CARD                   TAMIL             MOVIES          ACTION MOVIES        Thalaivaa               Monthly                Debit Card       RUPAY CARDS      ${dc-card_num}       ${dc-card_name}        ${dc-month_expire}        ${dc-year_expire}       ${dc-cvv}        No
#TEST-SCENARIO 90: SUBSCRIBE ANNUAL USING CREDIT CARD                   TELUGU            LIVE TV         NA                   NA                   Annual                 Credit Card      NA               ${cc-card_num}       ${cc-card_name}        ${cc-month_expire}        ${cc-year_expire}       ${cc-cvv}       No
#TEST-SCENARIO 91: SUBSCRIBE QUARTERLY USING INTERNATIONAL CREDIT CARD  KANNADA           TV SHOWS        TV SHOWS IN HD       Best of Best Harate  Quarterly              Credit Card      NA               ${cc_int-card_num}   ${cc_int-card_name}    ${cc_int-month_expire}    ${cc_int-year_expire}   ${cc_int-cvv}   No