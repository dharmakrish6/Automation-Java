*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Variable/Variables.robot
Resource         ../Locators/Player.robot
Resource         ../Locators/VOD-DetailsScreen.robot

*** Keywords ***
Click on Play button
    Click Element  ${play_redbutton}
    sleep   ${stream_content}

Click on Play button for Live TV
    Click Element  ${live_playbtn}

Switch to full-screen mode streaming
    Click Element  ${vod_fullscreen}

Forward VOD to 30 seconds
    :FOR    ${index}    IN RANGE    3
     \   Click Element  ${forward_icon}

Rewind VOD to 30 seconds
    :FOR    ${index}    IN RANGE    3
     \   Click Element  ${rewind_icon}

Change audio status (mute/unmute)
    Click Element  ${volume_icon}

Change Quality of VOD Player
    Wait Until Page Contains Element  ${quality_option}
    :FOR    ${index}    IN RANGE    4
     \  sleep  ${stream_content}
     \  Click Element  ${quality_option}
     \   Run Keyword If  ${index}==0  Click Link  ${vquality_medium}
     \   Run Keyword If  ${index}==1  Click Link  ${vquality_Auto}
     \   Run Keyword If  ${index}==2  Click Link  ${vquality_low}
     \   Run Keyword If  ${index}==3  Click Link  ${vquality_HD}

Change Quality of Live TV Player
    Wait Until Page Contains Element  ${quality_option}
    :FOR    ${index}    IN RANGE    7
     \  sleep  ${stream_content}
     \  Click Element  ${quality_option}
     \   Run Keyword If  ${index}==0  Click Link  ${lquality_180p160k}
     \   Run Keyword If  ${index}==1  Click Link  ${lquality_180p96k}
     \   Run Keyword If  ${index}==2  Click Link  ${lquality_180p288k}
     \   Run Keyword If  ${index}==3  Click Link  ${lquality_auto}
     \   Run Keyword If  ${index}==4  Click Link  ${lquality_360p1088k}
     \   Run Keyword If  ${index}==5  Click Link  ${lquality_270p544k}
     \   Run Keyword If  ${index}==6  Click Link  ${lquality_270p800k}

Turn OFF subtitle
    Click Element  ${subtitle_option}
    Click Element  ${subs_OFF}

Turn ON subtitle
    Click Element  ${subtitle_option}
    Click Element  ${subs_ON}

#Change Speed of VOD Player
#    :FOR    ${index}    IN RANGE    5
#    \  sleep  ${stream}
#    \   Click Element  ${vgear_icon}
#    \   Click Element  ${vspeed_option}
#    \   Run Keyword If  ${index}==0  Click Element  ${vspeed_slow}
#    \   Run Keyword If  ${index}==1  Click Element  ${vspeed_fastersmooth}
#    \   Run Keyword If  ${index}==2  Click Element  ${vspeed_slow}
#    \   Run Keyword If  ${index}==3  Click Element  ${vspeed_faster}
#    \   Run Keyword If  ${index}==4  Click Element  ${vspeed_normal}

Wait for content to start streaming
   Wait Until Page Contains Element  ${live_seekbar}