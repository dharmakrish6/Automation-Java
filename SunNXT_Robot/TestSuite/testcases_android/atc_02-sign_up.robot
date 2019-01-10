*** Settings ***
Documentation       Check validation for sign-up flow (email-id)
Library             AppiumLibrary
Resource         keywords/android_app/high_level_keywords/authentication.robot
Test Setup          Launch App
Test Teardown       Close App
Test Template       Sign-up

*** Test Cases ***                                                  user_type
TEST-SCENARIO 09: REGISTERED CREDENTIAL                             Already Registered Credential
TEST-SCENARIO 10: UNREGISTERED CREDENTIAL xxx@xxxx.xxx              Unregistered Credential
TEST-SCENARIO 11: VALID EMAIL FORMAT xx.xxx@xxxx.xxx                Valid Email ID of Format xx.xxxx@xxxxx.xxx
TEST-SCENARIO 12: VALID EMAIL FORMAT xx.xxx@xxxx.xx.xxx             Valid Email ID of Format xx.xxxx@xxx.xxx.xxx
TEST-SCENARIO 13: INVALID EMAIL FORMAT xx.xxxx.xxx                  Invalid Email ID of Format xxx.xxxx.xxx
TEST-SCENARIO 14: INVALID EMAIL FORMAT xxxx@.xxx.xx                 Invalid Email ID of Format xxxx@.xxx.xxx
TEST-SCENARIO 15: INVALID EMAIL FORMAT @xxx.xx.xxx                  Invalid Email ID of Format @xxx.xx.xxx
TEST-SCENARIO 16: INVALID EMAIL FORMAT xxx@xxxx.x                   Invalid Email ID of Format xxx@xxxx.x
TEST-SCENARIO 17: INVALID EMAIL FORMAT xxxx@.xxx.xxx                Invalid Email ID of Format xxxx@.xxx.xxx
TEST-SCENARIO 18: INVALID EMAIL FORMAT .xxxx@xxxx.xxx               Invalid Email ID of Format .xxxx@xxxx.xxx
TEST-SCENARIO 19: INVALID EMAIL FORMAT xxxx()*.xxx                  Invalid Email ID of Format xxxx()*.xxx
TEST-SCENARIO 20: INVALID EMAIL FORMAT xxxx..1234@xxxx.xxx          Invalid Email ID of Format xxxx..zzzz@xxxx.xxx
TEST-SCENARIO 21: INVALID EMAIL FORMAT xxxx 1234@xxxx.xxx           Invalid Email ID of Format xxxx 1234@xxxx.xxx
TEST-SCENARIO 22: INVALID PASSWORD FORMAT xxx                       Invalid Password zzz
TEST-SCENARIO 23: INVALID PASSWORD FORMAT xx xx                     Invalid Password zz zzz
TEST-SCENARIO 24: INVALID MOBILE NUMBER FORMAT xxxxxxxxx            Invalid Mobile Number of Format zzzzzzzzz
TEST-SCENARIO 25: INVALID MOBILE NUMBER FORMAT xxxxxxxxxxx          Invalid Mobile Number of Format zzzzzzzzzzz