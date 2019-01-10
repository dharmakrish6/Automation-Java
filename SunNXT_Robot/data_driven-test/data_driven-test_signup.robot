*** Settings ***
Documentation           Check sign-in validity for different credentials
Resource                data_driven-test/excel_reader/Test_Template.robot
Resource                keywords/webportal/low_level_keywords/web_common.robot
Resource                test_data/credentials.robot
Test Setup              Open Browser And Navigate To SunNXT Website
Test Teardown           Close Opened Browser
Test Template           SignUp And Check The New Method
Default Tags            Quick

*** Test Cases ***                                                  signup_type
#TEST-SCENARIO 08: REGISTERED CREDENTIAL                             Email_Subs_UID
#TEST-SCENARIO 09: UNREGISTERED CREDENTIAL xxx@xxxx.xxx
TEST-SCENARIO 10: VALID EMAIL FORMAT xx.xxx@xxxx.xxx                Valid_Email_#1
#TEST-SCENARIO 11: VALID EMAIL FORMAT xx.xxx@xxxx.xx.xxx             Valid_Email_#2
TEST-SCENARIO 12: INVALID EMAIL FORMAT xx.xxxx.xxx                  Invalid_Email_#1
#TEST-SCENARIO 13: INVALID EMAIL FORMAT xxxx@.xxx.xx                 Invalid_Email_#2
#TEST-SCENARIO 14: INVALID EMAIL FORMAT xxx.xx.xxx                   Invalid_Email_#3
#TEST-SCENARIO 15: INVALID EMAIL FORMAT xxx@xxxx.x                   Invalid_Email_#4
#TEST-SCENARIO 16: INVALID EMAIL FORMAT xxxx@.xxx.xxx                Invalid_Email_#5
#TEST-SCENARIO 17: INVALID EMAIL FORMAT .xxxx@xxxx.xxx               Invalid_Email_#6
#TEST-SCENARIO 18: INVALID EMAIL FORMAT xxxx()*.xxx                  Invalid_Email_#7
#TEST-SCENARIO 19: INVALID EMAIL FORMAT xxxx..1234@xxxx.xxx          Invalid_Email_#8
#TEST-SCENARIO 20: INVALID EMAIL FORMAT xxxx 1234@xxxx.xxx           Invalid_Email_#9
#TEST-SCENARIO 21: INVALID PASSWORD FORMAT xxx                       Invalid_Pass_#1
#TEST-SCENARIO 22: INVALID PASSWORD FORMAT xx xx                     Invalid_Pass_#2
#TEST-SCENARIO 23: INVALID MOBILE NUMBER FORMAT xxxxxxxxx            Invalid_Mob_#1
#TEST-SCENARIO 24: INVALID MOBILE NUMBER FORMAT xxxxxxxxxxx          Invalid_Mob_#2