*** Settings ***
Documentation           Check sign-in validity for different credentials
Resource                ../keywords/webportal/high_level_keywords/authentication.robot
Resource                ../keywords/webportal/low_level_keywords/web_common.robot
Resource                ../test_data/credentials.robot
Test Setup              Open Browser And Navigate To SunNXT Website
Test Teardown           Close Opened Browser
Test Template           AUTHENTICATE WEB PORTAL
Default Tags            Quick

*** Test Cases ***                                                   userid                   userpass
TEST-SCENARIO 01: REGISTERED CREDENTIAL WITH SUBSCRIPTION        ${reg_id-email_subs}         ${reg_pass-email_subs}
#TEST-SCENARIO 02: REGISTERED CREDENTIAL WITH NO SUBSCRIPTION     ${reg_id-email_exp}          ${reg_pass-email_exp}
#TEST-SCENARIO 03: SUNDIRECT CREDENTIAL WITH SUBSCRIPTION         ${reg_id-sd_subs}            ${reg_pass-sd_subs}
#TEST-SCENARIO 04: SUNDIRECT CREDENTIAL WITH NO SUBSCRIPTION      ${reg_id-sd_exp}             ${reg_pass-sd_exp}
#TEST-SCENARIO 05: REGISTED CREDENTIAL WITH INVALID PASSWORD      ${reg_id-email_subs}         ${iv_pass-xxx}
#TEST-SCENARIO 06: UNREGISTERED CREDENTIAL                        ${unreg_id-mob}              ${unreg_id-mob}
#TEST-SCENARIO 07: UNREGISTED CREDENTIAL WITH INVALID PASSWORD    ${unreg_id-mob}              ${iv_pass-xx xx}