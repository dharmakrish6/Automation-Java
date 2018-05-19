*** Settings ***
Documentation         Check sign-in validity for different credentials
Resource                E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/common.robot
Resource                E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_common.robot
Resource                E:/Automation-Java/SunNXT_Robot/variable/credentials.robot
Test Setup             OPEN CHROME BROWSER
Test Teardown         CLOSE CHROME BROWSER
Test Template         AUTHENTICATE WEB PORTAL


*** Test Cases ***                                               userid                   userpass
REGISTERED CREDENTIAL WITH SUBSCRIPTION                    ${reg_id-email_subs}         ${reg_pass-email_subs}
REGISTERED CREDENTIAL WITH NO SUBSCRIPTION                 ${reg_id-email_exp}          ${reg_pass-email_exp}
SUNDIRECT CREDENTIAL WITH SUBSCRIPTION                     ${reg_id-sd_subs}            ${reg_pass-sd_subs}
SUNDIRECT CREDENTIAL WITH NO SUBSCRIPTION                  ${reg_id-sd_exp}             ${reg_pass-sd_exp}
UNREGISTERED CREDENTIAL                                    ${unreg_ud-mob}              ${unreg_id-mob}