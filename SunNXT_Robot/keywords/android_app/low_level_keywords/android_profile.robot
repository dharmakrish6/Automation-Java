*** Settings ***
Documentation           Contains keywords related to operations performed in profile screen
Library                 AppiumLibrary  run_on_failure=Capture Page Screenshot
Library                 Dialogs
Resource                ../locators/android_app/profile/devices.robot
Resource                ../locators/android_app/profile/downloads.robot
Resource                ../locators/android_app/profile_screen.robot
Resource                ../locators/android_app/common.robot
Resource                ../test_data/sleep_variables.robot
Resource                ../locators/android_app/profile/watch_list.robot
*** Keywords ***
#switch profile operation
Tap On Switch Profile
    click element  ${switch_profile}

#edit profile operation
Tap On Edit Profile
    click text  ${edit_profile}

#change content language operation

#change app language

#download operation
Tap On Download
    wait until page contains  ${downloads}
    click text  ${downloads}

Check Whether Vod Is Downloading Or Not
    sleep  ${wait_download}
    ${content_name}=  get text  ${downloading_content}
    run keyword if  "${content_name}"=="${content_streamed}"  log many  CONTENT DOWNLOADED IS AVAILABLE IN DOWNLOADS SECTION
    ${d_status}=  get text  ${download_percent}
    log many  VOD DOWNLOADED AFTER ${wait_download}s IS: ${d_status}

Check If Download Is Completed Or Not
    ${content_name}=  get text  ${downloading_content}
    run keyword if  "${content_name}"=="${content_streamed}"  log many  CONTENT DOWNLOADED IS AVAILABLE IN DOWNLOADS SECTION
    ${d_status}=  run keyword and return status  wait until page does not contain element  ${download_percent}  timeout=${wait_download_complete}

Stream Downloaded Content
    click element  ${download_play/pause}
    sleep  ${stream_content}

#watchlist operation
Tap On Watchlist
    click text  ${watchlist}

Verify If Content Bas Been Added Or Not
    run keyword and ignore error  wait until page does not contain element  xpath=/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout  timeout=15
    page should contain text  ${content_streamed}

#favourite actor operation
Tap On Favourite Actors
    click text  ${favourite_actors}

Verify Actor/Actress Selected Are Displayed
    page should contain  #no element found

#device operation
Tap On Devices
    click text  ${devices}

Authenticate Device
    ${status}=  run keyword and return status  wait until page contains element  ${activation_code_input}
    run keyword if  "${status}"=="True"  Input Activation Code
    ${status}=  run keyword and return status  wait until page contains element  ${alert_btn1}
    run keyword if  "${status}"=="True"  click element  ${alert_btn1}
    ...  ELSE  log many  DEVICE AUTHENTICATION FAILED

Input Activation Code
    ${activation_code}=  get value from user  ENTER ACTIVATION CODE  default
    input text  ${activation_code_input}  ${activation_code}
    click text  ${activate_device}

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

Tap On Logout Text
    click text  ${log_out}

#login
Click Login Text
    wait until page contains element  id=com.suntv.sunnxt:id/imageView1  timeout=3
    click text  ${log_in}
    wait until page contains element  id=com.suntv.sunnxt:id/logo_background