*** Settings ***
Documentation           Contains keywords related to video-details screen of content
Library                 SeleniumLibrary
Library                 BuiltIn
Library                 String
Resource                ../locators/webportal/vod_details_screen.robot

*** Keywords ***
Check If Streamed Content Is Added In Continue Watching Section Or Not
    should be equal as strings  ${latest_streamed}  ${content_streamed}

Play And Pause Content
    click element  ${play_redbutton}
    sleep       3s
    click element  ${pause_redbutton}

Record Streamed Content
    ${content_streamed}  get text  ${vod_name}
    convert to string  ${content_streamed}
    ${content_streamed}  convert to lowercase  ${content_streamed}
    set global variable  ${content_streamed}

Click On Play Button Red
    ${title}=  get title
    run keyword if  "${title}"!="SUNNXT::LIVE"  click element  css:div#app div.movie_details-btn-div > button[type="button"]