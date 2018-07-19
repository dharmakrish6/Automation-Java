*** Settings ***
Documentation       Check validation for sign-up flow (email-id)
Resource              ../keywords/webportal/high_level_keywords/signup.robot
Resource              ../keywords/webportal/low_level_keywords/web_common.robot
Resource              ../test_data/credentials.robot
Test Setup           Open Browser And Navigate To SunNXT Website
Test Template        SIGNUP USING CREDENTIAL
Test Teardown        Close Opened Browser

*** Test Cases ***                                                  userid                               userpass
TEST-SCENARIO 08: REGISTERED CREDENTIAL                          ${reg_id-email_subs}                 ${reg_pass-email_subs}
TEST-SCENARIO 09: UNREGISTERED CREDENTIAL xxx@xxxx.xxx           ${v_id-email_xxx@xxxx.xxx}           ${v_pass-@xx123}
TEST-SCENARIO 10: VALID EMAIL FORMAT xx.xxx@xxxx.xxx             ${v_id-email_xx.xxx@xxxx.xxx}        ${v_pass-@xx123}
TEST-SCENARIO 11: VALID EMAIL FORMAT xx.xxx@xxxx.xx.xxx          ${v_id-email_xx.xxx@xxxx.xx.xxx}     ${v_pass-xxxx}
TEST-SCENARIO 12: INVALID EMAIL FORMAT xx.xxxx.xxx               ${iv_id-email_xx.xxxx.xxx}           ${v_pass-@xx123}
TEST-SCENARIO 13: INVALID EMAIL FORMAT xxxx@.xxx.xx              ${iv_id-email_xxxx@.xxx.xx}          ${v_pass-@xx123}
TEST-SCENARIO 14: INVALID EMAIL FORMAT xxx.xx.xxx                ${iv_id-email_@xxx.xx.xxx}           ${v_pass-@xx123}
TEST-SCENARIO 15: INVALID EMAIL FORMAT xxx@xxxx.x                ${iv_id-email_xxx@xxxx.x}            ${v_pass-@xx123}
TEST-SCENARIO 16: INVALID EMAIL FORMAT xxxx@.xxx.xxx             ${iv_id-email_xxxx@.xxx.xxx}         ${v_pass-@xx123}
TEST-SCENARIO 17: INVALID EMAIL FORMAT .xxxx@xxxx.xxx            ${iv_id-email_.xxxx@xxxx.xxx}        ${v_pass-@xx123}
TEST-SCENARIO 18: INVALID EMAIL FORMAT xxxx()*.xxx               ${iv_id-email_xxxx()*.xxx}           ${v_pass-@xx123}
TEST-SCENARIO 19: INVALID EMAIL FORMAT xxxx..1234@xxxx.xxx       ${iv_id-email_xxxx..1234@xxxx.xxx}   ${v_pass-@xx123}
TEST-SCENARIO 20: INVALID EMAIL FORMAT xxxx 1234@xxxx.xxx        ${iv_id-email_xxxx 1234@xxxx.xxx}    ${v_pass-@xx123}
TEST-SCENARIO 21: INVALID PASSWORD FORMAT xxx                    ${v_ide-verify}                      ${iv_pass-xxx}
TEST-SCENARIO 22: INVALID PASSWORD FORMAT xx xx                  ${v_ide-verify}                      ${iv_pass-xx xx}
TEST-SCENARIO 23: INVALID MOBILE NUMBER FORMAT xxxxxxxxx         ${iv_id-mobile_xxxxxxxxx}            ${v_pass-@xx123}
TEST-SCENARIO 24: INVALID MOBILE NUMBER FORMAT xxxxxxxxxxx       ${iv_id-mobile_xxxxxxxxxxx}          ${iv_pass-xx xx}