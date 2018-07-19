*** Settings ***
Documentation           Contains keywords for elements available either at max number of screens or used commonly in Work-flow
Library                 SeleniumLibrary
Library                 BuiltIn
Resource                ../locators/webportal/authentication.robot
Resource                ../locators/webportal/homepage.robot
Resource                ../test_data/web_portal/assertions.robot
Resource                ../test_data/web_portal/keystrokes.robot
Resource                ../test_data/web_portal/test_environment.robot

*** Keywords ***
Open Browser And Navigate To SunNXT Website
    create webdriver  Chrome  executable_path=env_setup/chromedriver.exe
#    create webdriver  Firefox  executable_path=env_setup/geckodriver.exe
#    create webdriver  Opera  executable_path=env_setup/operadriver.exe
    maximize browser window
    go to  ${url}
#    press key  tag:body  ${f11_key}
    log many  NAVIGATED TO WEB-PAGE

Close Opened Browser
    capture page screenshot
    close browser

Verify Homepage Title
    title should be  ${title}
    log many   HOMEPAGE TITLE VERIFIED

Click On Profile Authentication Icon
    wait until element is visible  ${profile_auth}  timeout=10
    wait until element is enabled  ${profile_auth}
    click element   ${profile_auth}

Click On Devices Link
    click link  ${profile-device}

Click On Profile Icon
    wait until element is visible  ${profile_icon}
    wait until element is enabled  ${profile_icon}
    click element   ${profile_icon}

Click On Profile Link
    click link   ${profile-profile}

Click On Switch Profile Link
    click link  ${profile-switchprofile}

Click On My Account Link
    click link  ${profile-my_account}

Click On Subscription Link
    click link  ${profile-subscription}

Click On Sign In Link
    click link      ${signin_link}

Enter Registered Credential
    [Arguments]  ${userid}
    wait until element is visible  ${popup}  timeout=10
    input text    ${user_name}    ${userid}

Enter Password
    [Arguments]  ${userpass}
    sleep  5s
      input text  ${password}   ${userpass}

Click On Login Button
    sleep  5s
    click element   ${login_button}

Click On Logout Link
    click link   ${profile-logout}

Check If Pop-Up Is Dismissed
    element should not be visible  ${popup}  message=pop-up is not dismissed
    title should be  ${title}

Check If Error Message Is Displayed
    wait until page contains element  ${signin_error}  timeout=15s
    ${error_message} =  get text  ${signin_error}
    set global variable  ${error_message}

Validate Sign-In
    ${status#1} =  run keyword and return status  CHECK IF POP-UP IS DISMISSED
     run keyword if   "${status#1}"=="True"  log many  SUCCESSFULLY LOGGED IN TO SUNNXT
    ${status#2} =  run keyword and return status  CHECK IF ERROR MESSAGE IS DISPLAYED
    run keyword if   "${status#2}"=="True"  log many  ${error_message}

Select Content Language
    [Arguments]  ${content_language}
    ${language_selected}=  get text  ${lang2}
    run keyword if  "${content_language}"!="${language_selected}"  Code Language Selector  ${content_language}

Code Language Selector
    [Arguments]  ${content_language}
    click element  ${language_selector}
    run keyword if  "${content_language}"=="TAMIL"  click link  ${language_tamil}
    run keyword if  "${content_language}"=="TELUGU"  click link  ${language_telugu}
    run keyword if  "${content_language}"=="KANNADA"  click link  ${language_kannada}
    run keyword if  "${content_language}"=="MALAYALAM"  click link  ${language_malayalam}
    wait until element contains  css=span.filter-option.pull-left  ${content_language}  timeout=10s
    sleep  5s
    wait until page contains element  ${language_selector}  timeout=10s

Select Source Page
    [Arguments]  ${content_source}
    run keyword if  "${contentsource}"=="HOME"  click element  ${home}
    run keyword if  "${contentsource}"=="MOVIE"  click2 link  ${movies}
    run keyword if  "${contentsource}"=="TV SHOW"  click link  ${tvshows}
    run keyword if  "${contentsource}"=="LIVE TV"  click link  ${livetv}
    run keyword if  "${contentsource}"=="MUSIC VIDEO"  click link  ${livetv}

Verify If Continue Watching Has Been Removed Or Not
    page should not contain element  ${title_continue_watching}

