*** Settings ***
Library         AppiumLibrary  30
Documentation   SunNXT Mobile Automation - Android
Resource        E:/Automation-Java/SunNXT_Robot/keywords/android_app/android_authentication.robot
Resource        E:/Automation-Java/SunNXT_Robot/keywords/android_app/android_stream_vod.robot
Resource        E:/Automation-Java/SunNXT_Robot/variable/android_variable.robot
Suite Setup     Open Application  ${server}  platformName=${os}   platformVersion=${version}  deviceName=${udid}  app=${app}  appPackage=${app}  appActivity=${activity}
Suite Teardown  Quit Application

*** Test Cases ***
TESTCASE 03: STREAM A VOD
    [Tags]  SANITY
    AUTHENTICATE APP
    STREAM CONTENT AND CHECK PLAYBACK CONTROLS

#fails on selecting quality of video - some other app opens up