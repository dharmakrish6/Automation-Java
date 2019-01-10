*** Settings ***
Documentation           Contains keyword operations related to casting VOD's at lower level
Resource                locators/android_app/content_cast.robot
Resource                locators/android_app/player.robot
Resource                test_data/android_app/test_environment.robot

*** Keywords ***
Verify If Chromecast Is Present
    Chromecast Device Disconnected
    run keyword if  "${status}"=="False"  Chromecast Device Connected
    run keyword if  "${status}"=="False"  log 'Chromecast icon is not present'

Chromecast Device Disconnected
#    log  'Chromecast Device Is Disconnected'
    tap  ${player_frame}
    ${status}=  run keyword and return status  page should contain element  ${chromecast_disconnected}
#    tap  ${player_frame}
    run keyword if  "${status}"=="True"  click element  ${chromecast_disconnected}
    set global variable  ${status}

Chromecast Device Connected
#    log  Chromecast Device Is Connected'
    tap  ${player_frame}
    ${status}=  run keyword and return status  page should contain element  ${CHROMECAST_CONNECTED}
    run keyword if  "${status}"=="True"  click element  ${chromecast_connected}

Cast To Device
    click text  ${casting_device}
    wait until page contains  ${cast_dialog}
    click element  ${cast_to_device}
    wait until page contains  ${play_pause_btn}  timeout=10