*** Settings ***
Documentation           Flow for navigating to a content based on language choosen, streaming the content and testing playback controls
Resource                keywords/webportal/low_level_keywords/web_player.robot
Resource                keywords/webportal/low_level_keywords/web_common.robot
Resource                keywords/webportal/low_level_keywords/content/web_homepage.robot
Resource                keywords/webportal/low_level_keywords/web_vod_detailsscreen.robot
Resource                keywords/webportal/high_level_keywords/authentication.robot

*** Keywords ***
Stream Content
    [Arguments]  ${page_source}  ${content_language}
    Authenticate Web Portal  ID_Email_Subs
    Select Source Page  ${page_source}
    Select Content Language  ${content_language}
    Click On Content Carousel  ${page_source}  ${content_language}
    Check If Channel Being Streamed Is HD Supported Or Not
    Click On Play Button Red
    Wait For Content To Start Streaming
    Click On Full-Screen Button
    Change Audio Status (Mute/Unmute)
    Change Quality Of Player
    Click On Forward & Rewind Button
    Change Audio Status (Mute/Unmute)
    Turn Subtitle On/Off
    Exit Full-Screen Mode


Content Streaming Teardown
    Check For Any Player Error Message
    Close Opened Browser