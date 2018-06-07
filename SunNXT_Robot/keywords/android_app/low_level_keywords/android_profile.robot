*** Settings ***
Resource            E:/Automation-Java/SunNXT_Robot/locators/android_app/profile/devices.robot
Resource            E:/Automation-Java/SunNXT_Robot/locators/android_app/profile/downloads.robot
Resource            E:/Automation-Java/SunNXT_Robot/locators/android_app/profile_screen.robot
Resource            E:/Automation-Java/SunNXT_Robot/locators/android_app/common.robot

*** Keywords ***
#download
Check Whether Vod Is Downloading Or Not
    ${content_name}=  get text  ${downloading_content}
    run keyword if  "${content_name}"=="${content_streamed}"  log many  CONTENT DOWNLOADED IS AVAILABLE IN DOWNLOADS SECTION
    ${d_status}=  get text  ${download_percent}
    log many  VOD DOWNLOAD IS AT: ${d_status}

#device deactivation
Unregister All Devices Associated With Logged Account
    :FOR    ${index}    IN RANGE    3
    \  run keyword  Deactivate Devices

Deactivate Devices
    ${status}=  run keyword and return status  wait until page contains  ${deactivate_device}
    run keyword if  "${status}"=="True"  Tap On Deactivate
    ...  ELSE  exit for loop

Check For Deactivate Text
    wait until page contains  ${deactivate_device}
    page should contain text  ${deactivate_device}

Tap On Deactivate
    click text  ${deactivate_device}
    click element  ${alert_btn1}

Click Login Text
    wait until page contains element  id=com.suntv.sunnxt:id/imageView1  timeout=3
    click text  ${log_in}
    wait until page contains element  id=com.suntv.sunnxt:id/logo_background

Click On Download
    click text  ${downloads}

Click On Devices
    click text  ${devices}
