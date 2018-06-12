*** Settings ***
Documentation           Contains keywords for elements available either at max number of screens or used commonly in Work-flow
Library                 AppiumLibrary
Library                 String
Resource                E:/Automation-Java/SunNXT_Robot/test_data/android_app/test_environment.robot
Resource                E:/Automation-Java/SunNXT_Robot/locators/android_app/language_selection.robot
Resource                E:/Automation-Java/SunNXT_Robot/locators/android_app/common.robot
Resource                E:/Automation-Java/SunNXT_Robot/test_data/android_app/swipe_variables.robot

*** Keywords ***
Open Sunnxt App
    open application   ${server}  platformName=${os}   platformVersion=${version}  deviceName=${udid}  app=${app}  appPackage=${app}  appActivity=${activity}

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
    wait until page contains element  ${page_loaded}


Tap On Action Overflow Icon
    click element  ${action_overflow}

Navigate To Change Content Language
    click text  ${change_content_language}

Select Content Tab
    [Arguments]  ${content_source}
    run keyword if  "${content_source}"=="HOME"  Navigate To Home
    run keyword if  "${content_source}"=="MOVIES"  Navigate To Movies
    run keyword if  "${content_source}"=="TV SHOWS"  Navigate To Tv-Shows
    run keyword if  "${content_source}"=="MUSIC VIDEOS"  Navigate To Music Videos
    run keyword if  "${content_source}"=="COMEDY"  Navigate To Comedy

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
    Switch To Comedy

Select Language And Proceed To Home-Screen
    wait until page contains element  ${next_btn}  timeout=15
    click text  ${tamil}
    click element  ${next_btn}

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

Accept Imei Sharing
    click element  ${alert_btn1}

Deny Imei Sharing
    click element  ${alert_btn2}

Get Window Resolution
    ${width}    get window width
    ${height}   get window height
    log many  ${width}  ${height}

Swipe Down
    swipe by percent  ${sd-x_starts}  ${sd-y_starts}  ${sd-x_ends}  ${sd-y_ends}

Collect Header Co-Ordinate
    ${home_coordinate}=  Get Element Location  xpath=//android.widget.TextView[@text='HOME']
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