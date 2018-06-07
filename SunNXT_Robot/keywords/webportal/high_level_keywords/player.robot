*** Settings ***
Documentation    Suite description
Library            SeleniumLibrary
Resource           E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_player.robot
Resource           E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_common.robot
Resource           E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/content/web_homepage.robot
Resource           E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_vod_detailsscreen.robot

*** Keywords ***
Stream Content
    [Arguments]  ${content_source}  ${content_language}  ${content}
    Select Source Page  ${content_source}
    Select Language  ${content_language}
    Click On Content Carousel  ${content}
    Click On Play Button Red
    Wait For Content To Start Streaming
    Stream In Full-Screen Mode
    Change Audio Status (Mute/Unmute)
    Change Quality Of Player
    Click On Forward & Rewind Button
    Change Audio Status (Mute/Unmute)
    Stream In Full-Screen Mode
    Turn Subtitle On/Off
    Go Back