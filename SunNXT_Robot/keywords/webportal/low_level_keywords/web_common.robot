*** Settings ***
Documentation       Contains common actions performed in all scenarios
Library               SeleniumLibrary
Library               BuiltIn
Resource              E:/Automation-Java/SunNXT_Robot/test_data/web_portal/test_environment.robot
Resource              E:/Automation-Java/SunNXT_Robot/locators/webportal/authentication.robot
Resource              E:/Automation-Java/SunNXT_Robot/locators/webportal/homepage.robot
Resource              E:/Automation-Java/SunNXT_Robot/test_data/web_portal/assertions.robot

*** Keywords ***
OPEN CHROME BROWSER
    create webdriver  Chrome  executable_path=E:/automationrequisite/selenium-webdriver/chromedriver.exe
    set selenium speed  ${selenium_speed}
    set selenium implicit wait  10
    maximize browser window
    go to  ${url}
    log many  NAVIGATED TO WEB-PAGE

CLOSE CHROME BROWSER
    close browser

VERIFY HOMEPAGE TITLE
    title should be  ${title}
    log many   HOMEPAGE TITLE VERIFIED

CLICK ON PROFILE AUTHENTICATION ICON
    wait until element is visible  ${profile_auth}
    click element   ${profile_auth}

CLICK ON PROFILE ICON
    wait until element is visible  ${profile_icon}
    click element   ${profile_icon}

CLICK ON PROFILE LINK
    click element   ${profile_profile}

CLICK ON SUBSCRIPTION LINK
    click element   ${profile_subscription}

CLICK ON SIGN IN LINK
    click link      ${signin_link}

ENTER REGISTERED CREDENTIAL
    [Arguments]  ${userid}
    wait until element is visible  ${user_name}
    input text    ${user_name}    ${userid}

ENTER PASSWORD
    [Arguments]  ${userpass}
    sleep  5s
      input text  ${password}   ${userpass}

CLICK ON LOGIN BUTTON
    sleep  5s
    click element   ${login_button}

CLICK ON LOGOUT LINK
    click element   ${profile_logout}

CHECK IF POP-UP IS DISMISSED
    wait until page does not contain element  ${popup}  timeout=30s
    page should not contain element  ${popup}  message=pop-up is not dismissed
    title should be  ${title}

CHECK IF ERROR MESSAGE IS DISPLAYED
    wait until page contains element  ${signin_error}  timeout=15s
    ${error_message} =  get text  ${signin_error}
    set global variable  ${error_message}

VALIDATE SIGN-IN
    ${status#1} =  run keyword and return status  CHECK IF ERROR MESSAGE IS DISPLAYED
     run keyword if   "${status#1}"=="true"  log many  ${error_message}
    ${status#2} =  run keyword and return status  check if pop-up is dismissed
    run keyword if   "${status#2}"=="true"  log many  SIGN-IN IS SUCCESSFUL