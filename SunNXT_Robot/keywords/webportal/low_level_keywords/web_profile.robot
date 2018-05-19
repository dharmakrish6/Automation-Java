*** Settings ***
Documentation       Contains actions that can be performed in profile page
Library               String
Resource              E:/Automation-Java/SunNXT_Robot/locators/webportal/profile.robot

*** Keywords ***
Record Latest content in continue watching
    ${latest_streamed}  Get Text  ${recently_streamed}
    convert to string  ${latest_streamed}
    ${latest_streamed}  convert to lowercase  ${latest_streamed}
    set global variable  ${latest_streamed}