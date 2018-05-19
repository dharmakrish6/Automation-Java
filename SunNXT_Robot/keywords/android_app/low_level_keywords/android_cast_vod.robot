*** Settings ***
Documentation
Resource                E:/Automation-Java/SunNXT_Robot/locators/android_app/content_cast.robot
Resource                E:/Automation-Java/SunNXT_Robot/locators/android_app/player.robot
Resource                E:/Automation-Java/SunNXT_Robot/test_data/android_app/test_environment.robot

*** Keywords ***
VERIFY IF CHROMECAST IS PRESENT
    CHROMECAST DEVICE DISCONNECTED
    run keyword if  "${status}"=="False"  CHROMECAST DEVICE CONNECTED
    run keyword if  "${status}"=="False"  log 'Chromecast icon is not present'

CHROMECAST DEVICE DISCONNECTED
#    log  'CHROMECAST DEVICE IS DISCONNECTED'
    tap  ${player_frame}
    ${status}=  run keyword and return status  page should contain element  ${chromecast_disconnected}
#    tap  ${player_frame}
    run keyword if  "${status}"=="True"  click element  ${chromecast_disconnected}
    set global variable  ${status}

CHROMECAST DEVICE CONNECTED
#    log  'CHROMECAST DEVICE IS CONNECTED'
    tap  ${player_frame}
    ${status}=  run keyword and return status  page should contain element  ${CHROMECAST_CONNECTED}
    run keyword if  "${status}"=="True"  click element  ${chromecast_connected}

CAST TO DEVICE
    click text  ${casting_device}
    wait until page contains  ${cast_dialog}
    click element  ${cast_to_device}
    wait until page contains  ${play_pause_btn}  timeout=10
