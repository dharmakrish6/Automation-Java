*** Settings ***
Documentation       Contains actions that can be performed in profile page
Library               String
Resource              E:/Automation-Java/SunNXT_Robot/locators/webportal/profile.robot

*** Keywords ***
Record Latest Content In Continue Watching
    ${latest_streamed}  get text  ${recently_streamed}
    convert to string  ${latest_streamed}
    ${latest_streamed}  convert to lowercase  ${latest_streamed}
    set global variable  ${latest_streamed}