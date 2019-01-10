*** Settings ***
Documentation       Flow to stream a content whose title is provided in test-case (to be used in Suite/Test Setup)
Resource            locators/android_app/player.robot
Resource            keywords/android_app/low_level_keywords/android_stream_vod.robot
Resource            keywords/android_app/low_level_keywords/android_common.robot
Resource            test_data/credentials.robot

*** Keywords ***
Navigate To And Stream Any Content
    [Arguments]  ${content_language}  ${content_header}  ${carousel_title}  ${content_name}
    Navigate To Change Content Language
    Select Content Language  ${content_language}
    Select Content Tab  ${content_header}
    Navigate To Content Details Screen  ${carousel_title}  ${content_name}
    Dismiss Displayed Coach Mark
    Wait Until Content Is Ready To Stream
    Wait Until Ad Streams
    Dismiss Displayed Coach Mark
#    ${status}=  run keyword and return status  page should contain element  ${loading_animation}
    ${status}=  run keyword and return status  page should contain element  ${btn_play_pause}  timeout=10
    run keyword if  "${status}"=="False"  tap  ${player_frame}
    get element location  ${seek_bar}
    get element size  ${seek_bar}
    Go Back
