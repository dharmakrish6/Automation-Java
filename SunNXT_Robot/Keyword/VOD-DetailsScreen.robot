*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Library          String
Resource         ../Locators/VOD-DetailsScreen.robot
Resource         ../Variable/Variables.robot

*** Keywords ***
#Click on Play button
 #   Click Element  ${play_redbutton}

Check if streamed content is added in continue watching section or not
    Should Be Equal As Strings  ${latest_streamed}  ${content_streamed}
    #Run Keyword If  "${latest_streamed}"=="${content_streamed}"  Pass Execution

Play and pause content
    Click Element  ${play_redbutton}
    sleep       3s
    Click Element  ${pause_redbutton}

Record streamed content
    ${content_streamed}  Get Text  ${vod_name}
    convert to string  ${content_streamed}
    ${content_streamed}  convert to lowercase  ${content_streamed}
    set global variable  ${content_streamed}