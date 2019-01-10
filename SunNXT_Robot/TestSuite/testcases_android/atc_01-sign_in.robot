*** Settings ***
Documentation       Verify test-scenario's for Sign-In operation in Android
Library             AppiumLibrary
Resource         keywords/android_app/high_level_keywords/authentication.robot
Test Setup          Launch App
Test Teardown       Close App
Test Template       Authenticate App
Force Tags          Functional

*** Test Cases ***                                                   user_tyoe
TEST-SCENARIO 01: REGISTERED CREDENTIAL WITH SUBSCRIPTION            ID_Email_Subs
TEST-SCENARIO 02: REGISTERED CREDENTIAL WITH NO SUBSCRIPTION         ID_Email_Exp
TEST-SCENARIO 03: SUNDIRECT CREDENTIAL WITH SUBSCRIPTION             ID_SunDirect_Subs
TEST-SCENARIO 04: SUNDIRECT CREDENTIAL WITH NO SUBSCRIPTION          ID_SunDirect_Exp
TEST-SCENARIO 05: REGISTED CREDENTIAL MOBILE NUMBER                  ID_Mobile_Subs
TEST-SCENARIO 06: UNREGISTERED CREDENTIAL                            ID_Unregistered
TEST-SCENARIO 07: REGISTRED CREDENTIAL WITH INVALID PASSWORD         ID_Invalid_Pass
TEST-SCENARIO 08: REGISTRED CREDENTIAL WITH INVALID MOBILE NUMBER    ID_Invalid_Mobile
