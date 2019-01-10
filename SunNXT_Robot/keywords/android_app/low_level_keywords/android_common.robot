*** Settings ***
Documentation           Contains keywords for elements available either at max number of screens or used commonly in Work-flow
Library                 AppiumLibrary  run_on_failure=Capture Page Screenshot
Library                 OperatingSystem
Library                 venv/Lib/site-packages/robot/libraries/DateTime.py
Library                 venv/Lib/site-packages/robot/libraries/Process.py
Library                 venv/Lib/site-packages/robot/libraries/String.py
Library                 ExcelReader
Resource                locators/android_app/language_selection.robot
Resource                locators/android_app/common.robot
Resource                test_data/android_app/swipe_variables.robot

*** Keywords ***

#keywords to begin setup to automate android device

Launch App
    ${activity}=  get activity
    run keyword if  "${activity}"!="${lang_activity}"  launch application
    wait activity  ${lang_activity}  timeout=10
#    ${activity}=  run keyword and return status  should not contain  ${activity}  com.suntv.sunnxt
#    run keyword if  "${activity}"=="True"  launch application

Close App
    run keyword and ignore error  capture page screenshot
    quit application
#    terminate process  handle=crashlog

#operations for app
Navigate To Change Content Language
    tap on action overflow icon
    Tap On Change Content Language

Select Content Language
    [Arguments]  ${content_language}
    wait until page contains  ${cl_tamil}  timeout=10
    click text  ${cl_tamil}
    run keyword if  "${content_language}"=="Tamil"  click text  ${cl_tamil}
    run keyword if  "${content_language}"=="Telugu"  click text  ${cl_telugu}
    run keyword if  "${content_language}"=="Kannada"  click text  ${cl_kannada}
    run keyword if  "${content_language}"=="Malayalam"  click text  ${cl_malayalam}
    click element  ${btn_save}
    wait until page contains element  ${page_loaded}  timeout=15s


Tap On Action Overflow Icon
    click element  ${action_overflow}
    wait until page contains element  xpath=//android.widget.FrameLayout[@index='0']  timeout=10

Tap On Change Content Language
    click text  ${change_content_language}

Tap On Settings Option
    click element  ${settings}

Tap On My Account
    click text  ${my_account}

Select Content Tab
    [Arguments]  ${content_header}
    wait until page contains  FEATURED VIDEOS  timeout=10
    run keyword if  "${content_header}"=="home"  Navigate To Home
    run keyword if  "${content_header}"=="movies"  Navigate To Movies
    run keyword if  "${content_header}"=="tv shows"  Navigate To Tv-Shows
    run keyword if  "${content_header}"=="music videos"  Navigate To Music Videos
    run keyword if  "${content_header}"=="comedy"  Navigate To Comedy

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
    \  wait until page contains element  ${page_loaded}  timeout=10
    \  run keyword  Coach Mark Dismiss

Coach Mark Dismiss
#    [Timeout]  10
    run keyword and ignore error  wait until page contains element  xpath=//android.widget.RelativeLayout[@index='0']  timeout=30
    ${status}=  run keyword and return status  page should contain element  ${coach_mark}
    run keyword if  "${status}"=="True"  click text  ${thanks_text}
    ...  ELSE  Exit For Loop

Check For Current Activity
    ${current_activity}=  get activity
    should be equal  ${current_activity}  com.android.myplex.ui.sun.activities.MainActivity

Accept Imei Sharing
    wait until page does not contain element  id=com.suntv.sunnxt:id/languageText  timeout=10
    click element  ${alert_btn1}
    wait until page contains  FEATURED VIDEOS  timeout=10

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
    ${x}=  convert to integer  ${x}
    set global variable  ${x}

    ${y}=  evaluate  ${height}/3
    ${y}=  convert to integer  ${y}
    set global variable  ${y}

    ${y2}=  evaluate  ${height}/1.4
    ${y2}=  convert to integer  ${y2}
    set global variable  ${y2}

    swipe  ${x}  ${y2}  ${x}  ${y}

Swipe Down
    swipe by percent  ${sd-x_starts}  ${sd-y_starts}  ${sd-x_ends}  ${sd-y_ends}

Collect Header Co-Ordinate
    ${home_coordinate}=  Get Element Location  xpath=//android.widget.TextView[@text='HOME']
    ${y}=  convert to string  ${home_coordinate}
    ${y}=  convert to string  ${home_coordinate}
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
    [Arguments]  ${content_language}  ${content_header}
    ${carousel_title}=  get value from corresponding row  ${content_header}  Language  ${content_language}  Carousel Title
    ${content_name}=  get value from corresponding row  ${content_header}  Language  ${content_language}  Content Name
    set suite variable  ${content_name}
    ${content#1}=  catenate  SEPARATOR=  //android.widget.TextView[contains(@resource-id,'name') and @text='  ${content_name}  ']
    Convert Content Name
    ${content#2}=  catenate  SEPARATOR=  //android.widget.TextView[contains(@resource-id,'movie_title_big_item') and @text='  ${caps_content}  ']
    set suite variable  ${content#1}
    set suite variable  ${content#2}
    :for  ${swiping}  in range  1000
    \  ${status}=  run keyword and return status  page should contain text  ${carousel_title}
    \  run keyword if  "${status}"=="False"  swipe by percent  50  40  50  10
    \  continue for loop if  "${status}"=="False"
    \  ${status#1}=  run keyword and return status  page should contain element  xpath=${content#1}
    \  ${status#2}=  run keyword and return status  page should contain element  xpath=${content#2}
    \  run keyword if  "${status#1}"=="False" and "${status#2}"=="False"  swipe by percent  50  40  50  10
    \  ${status#1}=  run keyword and return status  page should contain element  xpath=${content#1}
    \  ${status#2}=  run keyword and return status  page should contain element  xpath=${content#2}
    \  run keyword if  "${status#1}"=="True"  click element  xpath=${content#1}
    \  run keyword if  "${status#2}"=="True"  click element  xpath=${content#2}
    \  exit for loop

Convert Content Name
    ${caps_content}=  convert to uppercase  ${content_name}
    set suite variable  ${caps_content}

Accept Alert
    wait until page contains element  ${popup_list}  timeout=15
    click element  ${alert_btn1}

Check Whether App Has Navigated To Home Screen Or Not
    wait until page contains  FEATURED VIDEOS  timeout=10

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
