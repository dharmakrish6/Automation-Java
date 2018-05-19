*** Settings ***
Documentation       Check validation for sign-up flow (email-id)
Library             AppiumLibrary
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_common.robot
Resource            E:/Automation-Java/SunNXT_Robot/keywords/android_app/high_level_keywords/signup.robot
Resource            E:/Automation-Java/SunNXT_Robot/test_data/credentials.robot
Test Setup          OPEN SUNNXT APP
Test Teardown       QUIT APPLICATION
Test Template       SIGNUP

*** Test Cases ***                                     userid                               userpass
REGISTERED CREDENTIAL                          ${reg_id-email_subs}                 ${reg_pass-email_subs}
UNREGISTERED CREDENTIAL xxx@xxxx.xxx           ${v_id-email_xxx@xxxx.xxx}           ${v_pass-@xx123}
#VALID EMAIL FORMAT xx.xxx@xxxx.xxx             ${v_id-email_xx.xxx@xxxx.xxx}        ${v_pass-@xx123}
VALID EMAIL FORMAT xx.xxx@xxxx.xx.xxx          ${v_id-email_xx.xxx@xxxx.xx.xxx}     ${v_pass-xxxx}
INVALID EMAIL FORMAT xx.xxxx.xxx               ${iv_id-email_xx.xxxx.xxx}           ${v_pass-@xx123}
#INVALID EMAIL FORMAT xxxx@.xxx.xx              ${iv_id-email_xxxx@.xxx.xx}          ${v_pass-@xx123}
#INVALID EMAIL FORMAT xxx.xx.xxx                ${iv_id-email_@xxx.xx.xxx}           ${v_pass-@xx123}
#INVALID EMAIL FORMAT xxx@xxxx.x                ${iv_id-email_xxx@xxxx.x}            ${v_pass-@xx123}
#INVALID EMAIL FORMAT xxxx@.xxx.xxx             ${iv_id-email_xxxx@.xxx.xxx}         ${v_pass-@xx123}
#INVALID EMAIL FORMAT .xxxx@xxxx.xxx            ${iv_id-email_.xxxx@xxxx.xxx}        ${v_pass-@xx123}
#INVALID EMAIL FORMAT xxxx()*.xxx               ${iv_id-email_xxxx()*.xxx}           ${v_pass-@xx123}
#INVALID EMAIL FORMAT xxxx..1234@xxxx.xxx       ${iv_id-email_xxxx..1234@xxxx.xxx}   ${v_pass-@xx123}
#INVALID EMAIL FORMAT xxxx 1234@xxxx.xxx        ${iv_id-email_xxxx 1234@xxxx.xxx}    ${v_pass-@xx123}
#INVALID PASSWORD                               ${v_ide-verify}                      ${iv_pass-xxx}
INVALID PASSWORD                                ${v_ide-verify}                      ${iv_pass-xxx}