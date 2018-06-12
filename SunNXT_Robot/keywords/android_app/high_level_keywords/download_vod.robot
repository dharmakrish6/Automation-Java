*** Settings ***
Documentation           Flow to download any content in android smatphone
Resource                E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_common.robot
Resource                E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_stream_vod.robot
Resource                E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_downloads.robot
Resource                E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_videodetailsscreen.robot
Resource                E:/Automation-Java/SunNXT_Robot/keywords/android_app/low_level_keywords/android_profile.robot


*** Keywords ***
Download Video And Verify
    [Arguments]  ${content_header}  ${carousel_title}  ${content_name}  ${download_quality}
    Select Content Tab  ${content_header}
    Navigate To Content Details Screen  ${carousel_title}  ${content_name}
    Dismiss Displayed Coach Mark
    Wait Until Content Is Ready To Stream
    Click Download Button
    Select Download Quality  ${download_quality}
    Go Back
    Tap On Profile Button
    Dismiss Displayed Coach Mark
    Click On Download
    Check Whether Vod Is Downloading Or Not
