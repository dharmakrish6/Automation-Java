*** Settings ***
Library             AppiumLibrary
Documentation       SEARCH FOR MOVIE, TV SHOW AND MUSIC VIDEO FOR DIFFERENT CONTENT LANGUAGE
Resource            ../keywords/android_app/low_level_keywords/android_common.robot
Resource            ../keywords/android_app/high_level_keywords/authentication.robot
Resource            ../test_data/credentials.robot
Test Setup          LOGIN VIA APP  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown       Close App

*** Keywords ***
Stream Sun TV
    :FOR    ${index}    IN RANGE    1000
    \   ${status}=  run keyword and return status  page should contain element  ${sun_tv}
    \   run keyword and return if  "${status}"=="False"     Swipe Down
    \   click element  ${sun_tv}
    \   exit for loop if  "${status}"=="True"

*** Variables ***
${sun_tv}       xpath=//android.support.v7.widget.RecyclerView[@index='2']/android.widget.RelativeLayout[@index='0']

*** Test Cases ***
Test Scenario Test:
    Stream Sun TV
