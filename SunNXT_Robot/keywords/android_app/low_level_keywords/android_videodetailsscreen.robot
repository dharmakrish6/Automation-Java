*** Settings ***
Documentation           Contains keywords related to operations performed in video-details screen
Resource                locators/android_app/videodetails_screen.robot
Resource                locators/android_app/common.robot

*** Keywords ***
Click Download Button
    click element  ${btn_download}


Add Content To Favourite
    click element  ${btn_favourite}
    wait until page contains element  ${alert_ok}
    ${status}=  get text  id=com.suntv.sunnxt:id/alert_message
    run keyword if  "${status}"=="Removed from your favourite"  Unfavourite And Add To Favourite
    click element  ${alert_ok}

Unfavourite And Add To Favourite
    click element  ${alert_ok}
    click element  ${btn_favourite}

Navigate To Starcast
    click element  ${star_cast}

Check If Navigated To Video Details Screen
    ${status}=  run keyword and return status  page should contain element  ${content_thumbnail}  timeout=10
    run keyword if  "${status}"=="False"  wait until page contains element  ${content_thumbnail}

Add Actor/Actress To Favourite
    wait until page contains  ${assert_starcast}
    tap  ${btn_starcast_fav}

