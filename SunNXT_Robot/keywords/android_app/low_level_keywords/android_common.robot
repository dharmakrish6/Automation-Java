*** Settings ***
Documentation           Contains keywords for elements available either at max number of screens or used commonly in Work-flow
Library                 AppiumLibrary  run_on_failure=Capture Page Screenshot
Library                 OperatingSystem
Library                 ../venv/Lib/site-packages/robot/libraries/DateTime.py
Library                 ../venv/Lib/site-packages/robot/libraries/Process.py
Library                 String
Resource                ../test_data/android_app/test_environment.robot
Resource                ../locators/android_app/language_selection.robot
Resource                ../locators/android_app/common.robot
Resource                ../test_data/android_app/swipe_variables.robot

*** Keywords ***
Restart ADB Server
    run process  adb  kill-server
    run process  adb  start-server

Gather Device Information
    run process  adb  shell  getprop  ro.build.version.release  alias=version  stdout=deviceVersion.txt
    run process  adb  shell  getprop  ro.serialno  alias=deviceID  stdout=deviceID.txt
    run process  adb  shell  pm  list  packages  com.suntv.sunnxt  stdout=appAvailability.txt
    ${deviceID}=  get file  deviceID.txt
    set suite variable  ${deviceID}
    ${deviceVersion}=  get file  deviceVersion.txt
    set suite variable  ${deviceVersion}

Check Whether SunNXT App Is Installed Or Not
    ${appAvailability}=  get file  appAvailability.txt
    ${appAvailability}=  strip string  ${appAvailability}  mode=right
    run keyword if  "${appAvailability}"!="package:com.suntv.sunnxt"  Install Sunnxt App

Open Sunnxt App
    Restart ADB Server
    Gather Device Information
    Check Whether SunNXT App Is Installed Or Not
    terminate all processes
    Verify UiAutomator To Be Used
    start process  adb  logcat  *:E  FINDSTR  com.suntv.sunnxt  alias=crashlog  stdout=crash.txt
    open application   ${server}  platformName=${os}   platformVersion=${deviceVersion}  deviceName=${deviceID}  automationName=${automationName}  appPackage=${app}  appActivity=${activity}
#    Restart ADB Server

Install Sunnxt App
     run process  adb  install  ${install_path}  alias=appInstall  stderr=install_log.txt
     wait for process  handle=appInstall  timeout=30  on_timeout=kill
     run process  adb  shell  pm  list  packages  com.suntv.sunnxt  stdout=appAvailability.txt
     ${appAvailability}=  get file  appAvailability.txt
     ${appAvailability}=  strip string  ${appAvailability}  mode=right
     should be true  "${appAvailability}"=="package:com.suntv.sunnxt"

Verify UiAutomator To Be Used
    ${deviceVersion}=  fetch from left  ${deviceVersion}  .
    ${check_deviceVersion}=  convert to integer  ${deviceVersion}
    run keyword if  ${check_deviceVersion}>=6  Set UiAutomator Type For Android v6 And Above
    ...  ELSE  Set UiAutomator Type For Below Android v6


Set UiAutomator Type For Android v6 And Above
    ${automationName}=  set variable  UiAutomator2
    set suite variable  ${automationName}

Set UiAutomator Type For Below Android v6
    ${automationName}=  set variable  Appium
    set suite variable  ${automationName}

Close App
#    Check If App Crashed
    capture page screenshot
    quit application
    terminate process  handle=crashlog

Change Content Language
    [Arguments]  ${content_language}
    tap on action overflow icon
    navigate to change content language

Select Content Language
    [Arguments]  ${content_language}
    click element  ${action_overflow}
    click text  ${change_content_language}
    click text  ${cl_tamil}
    run keyword if  "${content_language}"=="TAMIL"  click text  ${cl_tamil}
    run keyword if  "${content_language}"=="TELUGU"  click text  ${cl_telugu}
    run keyword if  "${content_language}"=="KANNADA"  click text  ${cl_kannada}
    run keyword if  "${content_language}"=="MALAYALAM"  click text  ${cl_malayalam}
    click element  ${btn_save}
    wait until page contains element  ${page_loaded}  timeout=15s


Tap On Action Overflow Icon
    click element  ${action_overflow}

Navigate To Change Content Language
    click text  ${change_content_language}

Tap On My Account
    click text  ${my_account}

Select Content Tab
    [Arguments]  ${content_tab}
    run keyword if  "${content_tab}"=="HOME"  Navigate To Home
    run keyword if  "${content_tab}"=="MOVIES"  Navigate To Movies
    run keyword if  "${content_tab}"=="TV SHOWS"  Navigate To Tv-Shows
    run keyword if  "${content_tab}"=="MUSIC VIDEOS"  Navigate To Music Videos
    run keyword if  "${content_tab}"=="COMEDY"  Navigate To Comedy

Navigate To Home
    click text  ${home}

Navigate To Movies
    click text  ${movies}

Navigate To Tv-Shows
    click text  ${tv_shows}

Navigate To Comedy
    Collect Header Co-Ordinate
    Switch To Comedy

Navigate To Music Videos
    Collect Header Co-Ordinate
    Switch To Music Videos

Select Language And Proceed To Home-Screen
    wait until page contains element  ${next_btn}  timeout=15
    click text  ${tamil}
    click element  ${next_btn}

Tap On Search Button
    wait until page contains element  ${button_search}
    click element  ${button_search}

Tap On Profile Button
     wait until page contains element  ${button_profile}
     click element  ${button_profile}

Dismiss Displayed Coach Mark
    :FOR    ${index}    IN RANGE    3
    \  wait until page contains element  ${page_loaded}
    \  run keyword  Coach Mark Dismiss

Coach Mark Dismiss
    ${status}=  run keyword and return status  page should contain element  ${coach_mark}
    run keyword if  "${status}"=="True"  click text  ${thanks_text}
    ...  ELSE  Exit For Loop

Check For Current Activity
    ${current_activity}=  get activity
    should be equal  ${current_activity}  com.android.myplex.ui.sun.activities.MainActivity

Accept Imei Sharing
    wait until page does not contain element  id=com.suntv.sunnxt:id/languageText  timeout=10
    click element  ${alert_btn1}

Deny Imei Sharing
    click element  ${alert_btn2}

Get Window Resolution
    ${width}    get window width
    ${height}   get window height
    log many  ${width}  ${height}

Swipe Up Dropdown
    ${height}=  get window height
    ${width}=  get window width
    ${x}=  evaluate  ${width}/2
    set global variable  ${x}

    ${y}=  evaluate  ${height}/4
    set global variable  ${y}
    ${y2}=  evaluate  ${height}/1.4
    set global variable  ${y2}

Swipe Down
    swipe by percent  ${sd-x_starts}  ${sd-y_starts}  ${sd-x_ends}  ${sd-y_ends}

Collect Header Co-Ordinate
    ${home_coordinate}=  Get Element Location  xpath=//android.widget.TextView[@text='HOME']
    ${y}=  convert to string  ${home_coordinate}0
    ${y}=  convert to string  ${home_coordinate}0
    ${y}=  fetch from right  ${y}  ,
    ${y}=  remove string using regexp  ${y}  ('y':)|}
    set global variable  ${y}

    ${x}=  convert to string  ${home_coordinate}
    ${x}=  fetch from left  ${x}  ,
    ${x}=  remove string using regexp  ${x}  {'x':
    set global variable  ${x}

    ${music_coordinate}=  Get Element Location  xpath=//android.widget.TextView[@text='MUSIC VIDEOS']
    ${x2}=  convert to string  ${music_coordinate}
    ${x2}=  fetch from left  ${x2}  ,
    ${x2}=  remove string using regexp  ${x2}  {'x':
    set global variable  ${x2}

Switch To Music Videos
    :FOR    ${index}    IN RANGE    3
    \  swipe  ${x2}  ${y}  ${x}  ${y}
    \  ${status}=  run keyword and return status  page should contain text  MUSIC VIDEOS
    \  continue for loop if  "${status}"=="False"
    \  run keyword if  "${status}"=="True"  click text  ${music_videos}
    \  exit for loop if  "${status}"=="True"

Switch To Comedy
    :FOR    ${index}    IN RANGE    4
    \  swipe  ${x2}  ${y}  ${x}  ${y}
    \  ${status}=  run keyword and return status  page should contain text  COMEDY
    \  continue for loop if  "${status}"=="False"
    \  run keyword if  "${status}"=="True"  click text  ${comedy}
    \  capture page screenshot
    \  exit for loop if  "${status}"=="True"

Navigate To Content Details Screen
    [Arguments]  ${carousel_title}  ${content_name}
    :for  ${swiping}  in range  1000
    \  ${status}=  run keyword and return status  page should contain text  ${carousel_title}
    \  run keyword if  "${status}"=="False"  swipe by percent  50  40  50  10
    \  continue for loop if  "${status}"=="False"
    \  ${status}=  run keyword and return status  page should contain text  ${content_name}
    \  run keyword if  "${status}"=="False"  swipe by percent  50  40  50  10
    \  wait until page contains  ${content_name}  timeout=10
    \  click text  ${content_name}
    \  exit for loop

Accept Alert Message
    click text  ${alert_ok}

Check Whether App Has Navigated To Home Screen Or Not
    wait until page contains  FEATURED VIDEOS

Check If App Crashed
#    ${crash_msg#1}=  run keyword and return status  page should contain element  ${crash_pop_up#1}
#    ${crash_msg#2}=  run keyword and return status  page should contain element  ${crash_pop_up#2}
#    run keyword if  "${crash_msg#1}"=="True"  or  "${crash_msg#2}"=="True"
     Get Crash Logs

Get Crash Logs
#    Crash File Name Generator

#    process should be stopped  handle=crashlog
#    terminate process  handle=crashlog

Crash File Name Generator
    ${current_date}=  get current date  time_zone=local  result_format=%d.%m.%y
    ${crash_file}=  catenate  SEPARATOR=  crash-  ${current_date}  .txt
    convert to string  ${crash_file}
    set suite variable  ${crash_file}
