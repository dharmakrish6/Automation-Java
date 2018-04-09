*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Variable/Variables.robot
Resource         ../Locators/Authentication.robot
Resource         ../Locators/SunNXThome.robot

*** Keywords ***
Open Browser
    Create Webdriver  Chrome  executable_path=F:/Selenium-required files/chromedriver/chromedriver.exe
    Maximize Browser Window

Navigate to SunNXT web-portal
    Go To  ${URL}
    Log Many  Navigated to web-page

Verify the homepage title
    Title should be  ${title}
    Log Many   Homepage title verified

Click on Profile authentication icon
    Click Element   ${profile_auth}

Click on Profile icon
    Click Element   ${profile_icon}

Click on profile link
    Click Element   ${profile_profile}

Click on subscription link
    Click Element   ${profile_subscription}

Click on Sign In link from dropdown
    Click Link      ${signin_link}

Enter UserID
    Input Text    ${user_name}    soumya.sunnxt@123.com

Enter Password
    Input Password  ${password}   123456

Click on Submit button
    Click Element   ${login_button}

Click on Profile button
    Click Element   ${profile_icon}

Click on Logout link
    Click Element   ${profile_logout}

Enter UserID with no subscription
    Input Text      ${user_name}    amy@yahoo.com