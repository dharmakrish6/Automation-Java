*** Settings ***
Documentation    Suite description
Library             AppiumLibrary  run_on_failure=Capture Page Screenshot
Library             Dialogs
Resource            ../locators/android_app/profile/switch_profile.robot
Resource            ../locators/android_app/common.robot

*** Keywords ***
Switch To Primary Profile
    click element  ${primary_profile}

Switch To First Secondary Profile
    click element  ${secondary_profile0}

Switch To Second Secondary Profile
    click element  ${secondary_profile1}

Switch To Third Secondary Profile
    click element  ${secondary_profile2}

Verify If Selected Profile is Primary Profile
    ${status}=  run keyword and return status  element should be enabled  ${selected-primary_profile}
    run keyword if  "S{status}"=="True"  Set Value For Primary Profile
    log many  PRIMARY PROFILE IS SELECTED

Set Value For Primary Profile
    set global variable  ${selected_profile}=  Primary

Verify If Selected Profile is First Secondary Profile
    ${status}=  run keyword and return status  element should be enabled  ${selected-secondary_profile0}
    run keyword if  "S{status}"=="True"  Set Value For First Secondary Profile
    log many  FIRST SECONDARY PROFILE IS SELECTED

Set Value For First Secondary Profile
    set global variable  ${selected_profile}=  First Secondary

Verify If Selected Profile is Second Secondary Profile
    ${status}=  run keyword and return status  element should be enabled  ${selected-secondary_profile1}
    run keyword if  "S{status}"=="True"  Set Value For Second Secondary Profile
    log many  SECOND SECONDARY IS SELECTED

Set Value For Second Secondary Profile
    ${selected_profile}=  Second Secondary
    set global variable  ${selected_profile}

Verify If Selected Profile is Third Secondary Profile
    ${status}=  run keyword and return status  element should be enabled  ${selected-secondary_profile2}
    run keyword if  "S{status}"=="True"  Set Value For Third Secondary Profile
    log many  THIRD SECONDARY PROFILE IS SELECTED

Set Value For Third Secondary Profile
    set global variable  ${selected_profile}=  Third Secondary

Veirfy The Selected Profile
    :FOR  ${index}  IN RANGE  1
    \  Verify If Selected Profile is Primary Profile
    \  exit for loop if  "S{status}"=="True"
    \  Verify If Selected Profile is First Secondary Profile
    \  exit for loop if  "S{status}"=="True"
    \  Verify If Selected Profile is Second Secondary Profile
    \  exit for loop if  "S{status}"=="True"
    \  Verify If Selected Profile is Third Secondary Profile

Switch To Desired Profile
    [Arguments]  ${profile_type}
    wait until page does not contain element  ${g_loading_popup}  timeout=10
    Veirfy The Selected Profile
    run keyword if  "${selected_profile}"=="${profile_type}"  Desired Profile Same As Selected
    run keyword if  "${profile_type}"=="Primary"  Switch To Primary Profile
    ...  ELSE IF  "${profile_type}"=="First Secondary"  Switch To First Secondary Profile
    ...  ELSE IF  "${profile_type}"=="Second Secondary"  Switch To Second Secondary Profile
    ...  ELSE IF  "${profile_type}"=="Third Secondary"  Switch To Third Secondary Profile
    wait until page contains  FEATURED VIDEOS  timeout=10

Desired Profile Same As Selected
    log many  DESIRED PROFILE IS SAME AS SELECTED
    ${selected_profile}=  get value from user  PROFILE ${selected_profile} IS SELECTED. PLEASE ENTER DIFFERENT PROFILE TYPE  default