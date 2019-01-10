*** Settings ***
Documentation    Suite description
Library          OCRLibrary
Resource            locators/android_app/videodetails_screen.robot

*** Keywords ***
Select Download Quality
    [Arguments]  ${download_quality}
    log many  ${download_quality}
    wait until page contains element  ${download_popup}  timeout=10
    run keyword if  "${download_quality}"=="Data Saver"  click element  ${download-data_saver}
    run keyword if  "${download_quality}"=="Good"  click element  ${download-good}
    run keyword if  "${download_quality}"=="Best"  click element  ${download-best}
    run keyword if  "${download_quality}"=="HD"    click element  ${download-hd}

Verify If Content Is Set To Download
    sleep  3
    capture page screenshot  filename=verify.png
    image should contain text  ${EXEC_DIR}\\verify.png  eng  ${content_streamed}

