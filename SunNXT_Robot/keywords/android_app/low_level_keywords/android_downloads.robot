*** Settings ***
Documentation    Suite description
Resource            E:/Automation-Java/SunNXT_Robot/locators/android_app/videodetails_screen.robot

*** Keywords ***
Select Download Quality
    [Arguments]  ${download_quality}
    log many  ${download_quality}
    wait until page contains  ${download_popup}
    run keyword if  "${download_quality}"=="Data Saver"  click element  ${download-data_saver}
    run keyword if  "${download_quality}"=="Good"  click element  ${download-good}
    run keyword if  "${download_quality}"=="Best"  click element  ${download-best}
    run keyword if  "${download_quality}"=="HD"    click element  ${download-hd}
