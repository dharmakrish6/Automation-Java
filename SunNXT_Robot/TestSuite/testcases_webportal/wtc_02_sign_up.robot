*** Settings ***
Documentation       Check validation for sign-up flow (email-id)
Resource         keywords/webportal/high_level_keywords/authentication.robot
Resource         keywords/webportal/low_level_keywords/web_common.robot
Test Setup          Open Browser And Navigate To SunNXT Website
Test Template       Signup Using Credential
Test Teardown       Close Opened Browser

*** Test Cases ***                                                  user_type
TEST-SCENARIO 08: REGISTERED CREDENTIAL                             Already Registered Credential
TEST-SCENARIO 09: UNREGISTERED CREDENTIAL xxx@xxxx.xxx              Unregistered Credential
TEST-SCENARIO 10: VALID EMAIL FORMAT xx.xxx@xxxx.xxx                Valid Email ID of Format xx.xxxx@xxxxx.xxx
TEST-SCENARIO 11: VALID EMAIL FORMAT xx.xxx@xxxx.xx.xxx             Valid Email ID of Format xx.xxxx@xxx.xxx.xxx
TEST-SCENARIO 12: INVALID EMAIL FORMAT xx.xxxx.xxx                  Invalid Email ID of Format xxx.xxxx.xxx
TEST-SCENARIO 13: INVALID EMAIL FORMAT xxxx@.xxx.xx                 Invalid Email ID of Format xxxx@.xxx.xxx
TEST-SCENARIO 14: INVALID EMAIL FORMAT @xxx.xx.xxx                  Invalid Email ID of Format @xxx.xx.xxx
TEST-SCENARIO 15: INVALID EMAIL FORMAT xxx@xxxx.x                   Invalid Email ID of Format xxx@xxxx.x
TEST-SCENARIO 16: INVALID EMAIL FORMAT xxxx@.xxx.xxx                Invalid Email ID of Format xxxx@.xxx.xxx
TEST-SCENARIO 17: INVALID EMAIL FORMAT .xxxx@xxxx.xxx               Invalid Email ID of Format .xxxx@xxxx.xxx
TEST-SCENARIO 18: INVALID EMAIL FORMAT xxxx()*.xxx                  Invalid Email ID of Format xxxx()*.xxx
TEST-SCENARIO 19: INVALID EMAIL FORMAT xxxx..1234@xxxx.xxx          Invalid Email ID of Format xxxx..zzzz@xxxx.xxx
TEST-SCENARIO 20: INVALID EMAIL FORMAT xxxx 1234@xxxx.xxx           Invalid Email ID of Format xxxx 1234@xxxx.xxx
TEST-SCENARIO 21: INVALID PASSWORD FORMAT xxx                       Invalid Password zzz
TEST-SCENARIO 22: INVALID PASSWORD FORMAT xx xx                     Invalid Password zz zzz
TEST-SCENARIO 23: INVALID MOBILE NUMBER FORMAT xxxxxxxxx            Invalid Mobile Number of Format zzzzzzzzz
TEST-SCENARIO 24: INVALID MOBILE NUMBER FORMAT xxxxxxxxxxx          Invalid Mobile Number of Format zzzzzzzzzzz