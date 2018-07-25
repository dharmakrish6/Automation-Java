*** Settings ***
Documentation           Check sign-in validity for different credentials
Resource                ../keywords/webportal/low_level_keywords/web_common.robot
Resource                ../test_data/credentials.robot
Default Tags            Quick
Library                 SeleniumLibrary
Library                 Dialogs

*** Test Cases ***
Testing Pre-Prod Web-site
    create webdriver  Chrome  executable_path=env_setup/chromedriver.exe
    set selenium timeout  1 seconds
#    create webdriver  Firefox  executable_path=env_setup/geckodriver.exe
#    create webdriver  Opera  executable_path=env_setup/operadriver.exe
    maximize browser window
    ${env}=  get value from user  ENTER ENVIRONMENT IN WHICH THE TEST SHOULD RUN
    run keyword if  "${env}"=="Production"  go to  https://www.sunnxt.com
    ...  ELSE  run keyword  go to  https://presunportal:f@Furious.@www.sunnxt.in
    Click On Profile Authentication Icon
