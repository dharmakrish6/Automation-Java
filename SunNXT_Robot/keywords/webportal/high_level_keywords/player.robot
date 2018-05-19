*** Settings ***
Documentation    Suite description
Library            SeleniumLibrary
Resource           E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_player.robot
Resource           E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/common.robot
Resource           E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/content/web_homepage.robot
Resource           E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_vod_detailsscreen.robot

*** Keywords ***
STREAM CONTENT
    [Arguments]  ${contentsource}  ${sourcelanguage}  ${content}
    SELECT SOURCE PAGE  ${contentsource}
    SELECT LANGUAGE  ${sourcelanguage}
    CLICK ON CONTENT CAROUSEL  ${content}
    CLICK ON PLAY BUTTON RED
    WAIT FOR CONTENT TO START STREAMING
    STREAM IN FULL-SCREEN MODE
    CHANGE AUDIO STATUS (MUTE/UNMUTE)
    CHANGE QUALITY OF PLAYER
    CLICK ON FORWARD & REWIND BUTTON
    CHANGE AUDIO STATUS (MUTE/UNMUTE)
    STREAM IN FULL-SCREEN MODE
    TURN SUBTITLE ON/OFF
    GO BACK