*** Settings ***
Documentation    Suite description
Suite Setup      Create Webdriver  Chrome  executable_path=F:/Selenium-required files/chromedriver/chromedriver.exe

*** Test Cases ***
Test title
    [Tags]    DEBUG
    Provided precondition
    When action
    Then check expectations

*** Keywords ***
Provided precondition
    Setup system under test