*** Settings ***
Documentation           Check sign-in validity for different credentials
Resource                keywords/webportal/high_level_keywords/authentication.robot
Resource                keywords/webportal/low_level_keywords/web_common.robot
Test Setup              Open Browser And Navigate To SunNXT Website
Test Teardown           Close Opened Browser
Test Template           Authenticate Web Portal
Default Tags            Quick

*** Test Cases ***                                                   user_tyoe
TEST-SCENARIO 01: REGISTERED CREDENTIAL WITH SUBSCRIPTION            ID_Email_Subs
TEST-SCENARIO 02: REGISTERED CREDENTIAL WITH NO SUBSCRIPTION         ID_Email_Exp
TEST-SCENARIO 03: SUNDIRECT CREDENTIAL WITH SUBSCRIPTION             ID_SunDirect_Subs
TEST-SCENARIO 04: SUNDIRECT CREDENTIAL WITH NO SUBSCRIPTION          ID_SunDirect_Exp
TEST-SCENARIO 05: REGISTED CREDENTIAL MOBILE NUMBER                  ID_Mobile_Subs
TEST-SCENARIO 06: UNREGISTERED CREDENTIAL                            ID_Unregistered
TEST-SCENARIO 07: REGISTRED CREDENTIAL WITH INVALID PASSWORD         ID_Invalid_Pass
TEST-SCENARIO 08: REGISTRED CREDENTIAL WITH INVALID MOBILE NUMBER    ID_Invalid_Mobile