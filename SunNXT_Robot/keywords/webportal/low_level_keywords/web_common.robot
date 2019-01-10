*** Settings ***
Documentation           Contains keywords for elements available either at max number of screens or used commonly in Work-flow
Library                 SeleniumLibrary
Library             venv/Lib/site-packages/robot/libraries/String.py
Library                 BuiltIn
Library                 Dialogs
Library                 ExcelReader
Library                 ScreenRecorder
Resource                locators/webportal/authentication.robot
Resource                locators/webportal/homepage.robot
Resource                test_data/web_portal/assertions.robot
Resource                test_data/web_portal/timeout.robot
Resource                locators/webportal/common.robot

*** Keywords ***
Open Browser And Navigate To SunNXT Website
#    start screen recording
    open browser  ${url}  chrome
#    ${options}=     Evaluate    sys.modules['selenium.webdriver'].ChromeOptions()       sys
#    ${options.binary_location}=     Set Variable    C:/Users/Amy/AppData/Local/Programs/Opera/launcher.exe
#    open browser  ${url}  opera  ${options}
#    open browser  ${url}  headlessfirefox
#    create webdriver  Chrome
#    go to  ${url}
    maximize browser window
    wait until element is not visible  ${content_loading_animation}  timeout=${wait_for_page_to_load}
#    press key  tag:body  ${f11_key}
    log many  NAVIGATED TO WEB-PAGE

Close Opened Browser
    ${status}=  run keyword and return status  element should be visible  ${popup}
    run keyword if  "${status}"=="True"  click element  ${close_popup}
    ${status}=  run keyword and return status  element should be visible  ${profile_icon}
    run keyword if  "${status}"=="True"  Logout From Web-Portal
    ...  ELSE  close browser
    stop screen recording

Logout From Web-Portal
    click on profile icon
    click on logout link
    delete all cookies
    close all browsers

Verify Homepage Title
    title should be  ${title}
    log many   HOMEPAGE TITLE VERIFIED

Click On Profile Authentication Icon
    wait until element is visible  ${profile_auth}  timeout=${extended_wait}
    wait until element is enabled  ${profile_auth}
    click element   ${profile_auth}

Click On Devices Link
    click link  ${profile-device}

Click On Feedback Link
    click link  ${profile-feedback}

Click On Profile Icon
    wait until element is visible  ${profile_icon}
    wait until element is enabled  ${profile_icon}
    click element   ${profile_icon}

Click On Profile Link
    click link   ${profile-profile}

Click On Switch Profile Link
    click link  ${profile-switchprofile}

Click On Apply Coupon Link
    click link  ${profile-applycoupon}

Click On My Account Link
    click link  ${profile-my_account}

Click On Subscription Link
    click link  ${profile-subscription}

Click On Sign In Link
    click link      ${signin_link}

Enter Registered Credential
    [Arguments]  ${user_type}
    wait until element is visible  ${popup}  timeout=${extended_wait}
#    ${pkey}=  convert to string  User Type
#    ${value}=  convert to string  Log-in ID
    ${userid}=  get value from corresponding row  ${signin_sheet}  User Type  ${user_type}  Log-in ID
    click element  ${user_name}
    input text  ${user_name}  ${userid}

Enter Password
    [Arguments]  ${user_type}
    ${sheet_name}=  convert to string  prod_sign-in
#    ${pkey}=  convert to string  User Type
#    ${value}=  convert to string  Password
    ${userpass}=  get value from corresponding row  ${signin_sheet}  User Type  ${user_type}  Password
    click element  ${password}
    input text  ${password}  ${userpass}

Click On Login Button
    sleep  2s
    click element   ${login_button}

Click On Logout Link
    click link   ${profile-logout}

Check If Pop-Up Is Dismissed
    element should not be visible  ${popup}  message=pop-up is not dismissed
    title should be  ${title}

Check If Error Message Is Displayed
    [Arguments]  ${user_type}
    ${status}=  run keyword and return status  page should contain element  ${signin_error}  timeout=${extended_wait}
    ${validity}=  get value from corresponding row  ${signin_sheet}  User Type  ${user_type}  Validity
    run keyword if  '${status}'=='True' and '${validity}'=='Valid'  fail
    ${error_message} =  get text  ${signin_error}
    ${error_message}=  convert to uppercase  ${error_message}
    set global variable  ${error_message}

Validate Sign-In
    [Arguments]  ${user_type}
    ${status#1} =  run keyword and return status  CHECK IF POP-UP IS DISMISSED
     run keyword if   "${status#1}"=="True"  set test message  SUCCESSFULLY LOGGED IN TO SUNNXT
    ${status#2} =  run keyword and return status  CHECK IF ERROR MESSAGE IS DISPLAYED  ${user_type}
    run keyword if   "${status#2}"=="True"  set test message  ${error_message}
    ${status}=  run keyword and return status  page should contain element  ${content_loading_animation}
    run keyword if  "${status}"=="True"  reload page
    wait until element is not visible  ${content_loading_animation}  timeout=${wait_for_page_to_load}


Select Content Language
    [Arguments]  ${content_language}
    ${language}=  get text  ${language_selector}
    ${select_language}=  catenate  SEPARATOR=  //div[@class='col-md-6 col-sm-6 top_search']//span[contains(@class, 'filter-option pull-left')  and contains(., '  ${content_language}  ')]
    ${language_to_select}=  convert to uppercase  ${content_language}
    run keyword if  "${language_to_select}"!="${language}"  Click Content Language As Provided  ${content_language}
#    wait until element is not visible  xpath:${selected_language}  timeout=${extended_wait}
    wait until element is visible  xpath:${select_language}  timeout=${extended_wait}
    wait until element is not visible  ${content_loading_animation}  timeout=${wait_for_page_to_load}
    :FOR  ${index}  IN RANGE  10000
    \  ${title}=  get title
    \  ${check}=  run keyword and return status  should contain  ${title}  ${content_language}
    \  continue for loop if  "${check}"=="False"
    \  exit for loop if  "${check}"=="True"
    ${language_selected}=  get text  ${language_selector}
    ${content_language}=  convert to uppercase  ${content_language}
    run keyword if  "${content_language}"!="${language_selected}"  fail

Click Content Language As Provided
    [Arguments]  ${content_language}
    wait until page contains element  ${language_selector}  timeout=${extended_wait}
    click element  ${language_selector}
    wait until element is visible  ${language_dropdown}
    sleep  ${extended_wait}
    capture page screenshot
    run keyword if  "${content_language}"=="Tamil"  click element  ${language_tamil}
    ...  ELSE IF  "${content_language}"=="Telugu"  click element  ${language_telugu}
    ...  ELSE IF  "${content_language}"=="Malayalam"  click element  ${language_malayalam}
    ...  ELSE IF  "${content_language}"=="Kannada"  click element  ${language_kannada}
    capture page screenshot

Select Source Page
    [Arguments]  ${content_source}
    run keyword if  "${content_source}"=="home" or "${content_source}"=="trailers"  click element  ${home}
    run keyword if  "${content_source}"=="movies"  click link  ${movies}
    run keyword if  "${content_source}"=="tv shows"  click link  ${tvshows}
    run keyword if  "${content_source}"=="live tv"  click link  ${livetv}
    run keyword if  "${content_source}"=="music videos"  click link  ${music_videos}
    run keyword if  "${content_source}"=="comedy"    click link  ${comedy}

Verify If Continue Watching Has Been Removed Or Not
    page should not contain element  ${title_continue_watching}