*** Settings ***
Documentation       Contains actions to be performed on video-details screen of content
Library               SeleniumLibrary
Library               BuiltIn
Library               String
Resource              E:/Automation-Java/SunNXT_Robot/locators/webportal/vod_details_screen.robot

*** Keywords ***
CHECK IF STREAMED CONTENT IS ADDED IN CONTINUE WATCHING SECTION OR NOT
    should be equal as strings  ${latest_streamed}  ${content_streamed}

PLAY AND PAUSE CONTENT
    click element  ${play_redbutton}
    sleep       3s
    click element  ${pause_redbutton}

RECORD STREAMED CONTENT
    ${content_streamed}  get text  ${vod_name}
    convert to string  ${content_streamed}
    ${content_streamed}  convert to lowercase  ${content_streamed}
    set global variable  ${content_streamed}

CLICK ON PLAY BUTTON RED
    ${title}=  get title
    run keyword if  "${title}"!="SUNNXT::LIVE"  click element  ${play_redbutton}