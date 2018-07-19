*** Settings ***
Documentation       Subscribe to a plan using various payment modes
Resource            ../keywords/webportal/high_level_keywords/authentication.robot
Resource            ../keywords/webportal/high_level_keywords/subscription.robot
Resource            ../test_data/credentials.robot
Resource            ../test_data/card_details.robot
Resource            ../keywords/webportal/low_level_keywords/web_common.robot
Suite Setup         Open Browser And Navigate To SunNXT Website
Test Setup          Login Into Web Portal  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown       Logout From Web Portal
Suite Teardown      Close Opened Browser
Test Template       Subscribe A Plan From Pop-Up
Force Tags          Smoke

*** Test Cases ***                                                              content              subscription_plan      payment_mode     card_type        card_number          name_on_card            expiry_month             expiry_year             card_cvv        auto_renewal
TEST-SCENARIO 58: SUBSCRIBE MONTHLY USING DEBIT CARD                           Sathya               Monthly                Debit Card       Rupay Cards      ${dc-card_num}       ${dc-card_name}        ${dc-month_expire}        ${dc-year_expire}       ${dc-cvv}       No
TEST-SCENARIO 59: SUBSCRIBE ANNUAL USING CREDIT CARD                        Oru kuchi oru kulfi  Annual                 Credit Card      NA               ${cc-card_num}       ${cc-card_name}        ${cc-month_expire}        ${cc-year_expire}       ${cc-cvv}       No
TEST-SCENARIO 60: SUBSCRIBE QUARTERLY USING INTERNATIONAL CREDIT CARD          Asathal Chutties     Quarterly              Credit Card      NA               ${cc_int-card_num}   ${cc_int-card_name}    ${cc_int-month_expire}    ${cc_int-year_expire}   ${cc_int-cvv}   No