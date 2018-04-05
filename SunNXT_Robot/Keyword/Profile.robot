*** Settings ***
Library    String
Resource   ../Variable/Variables.robot

*** Keywords ***
Record Latest content in continue watching
    ${latest_streamed}  Get Text  ${recently_streamed}
    convert to string  ${latest_streamed}
    ${latest_streamed}  convert to lowercase  ${latest_streamed}
    set global variable  ${latest_streamed}