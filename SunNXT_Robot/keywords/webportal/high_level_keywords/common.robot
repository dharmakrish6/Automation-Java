*** Settings ***
Documentation    SunNXT Web-portal
Library          String
Resource         E:/Automation-Java/SunNXT_Robot/keywords/webportal/low_level_keywords/web_common.robot

*** Keywords ***
AUTHENTICATE WEB PORTAL
    [Arguments]  ${userid}  ${userpass}
    CLICK ON PROFILE AUTHENTICATION ICON
    CLICK ON SIGN IN LINK
    ENTER REGISTERED CREDENTIAL  ${userid}
    ENTER PASSWORD  ${userpass}
    CLICK ON LOGIN BUTTON
    VALIDATE SIGN-IN

LOGIN INTO WEB PORTAL
    [Arguments]  ${userid}  ${userpass}
    OPEN CHROME BROWSER
    CLICK ON PROFILE AUTHENTICATION ICON
    CLICK ON SIGN IN LINK
    ENTER REGISTERED CREDENTIAL  ${userid}
    ENTER PASSWORD  ${userpass}
    CLICK ON LOGIN BUTTON
    VALIDATE SIGN-IN
    sleep  5s

SELECT LANGUAGE
    [Arguments]  ${sourcelanguage}
    click element  ${language_selector}
    run keyword if  "${sourcelanguage}"=="TAMIL"  click element  ${language_tamil}
    run keyword if  "${sourcelanguage}"=="TELUGU"  click element  ${language_telugu}
    run keyword if  "${sourcelanguage}"=="KANNADA"  click element  ${language_kannada}
    run keyword if  "${sourcelanguage}"=="MALAYALAM"  click element  ${language_malayalam}
    wait until element contains  css=span.filter-option.pull-left  ${sourcelanguage}  timeout=10s
    sleep  5s
    wait until page contains element  ${language_selector}  timeout=10s

SELECT SOURCE PAGE
    [Arguments]  ${contentsource}
    run keyword if  "${contentsource}"=="home"  click element  ${home}
    run keyword if  "${contentsource}"=="movie"  click link  ${movies}
    run keyword if  "${contentsource}"=="tv show"  click link  ${tvshows}
    run keyword if  "${contentsource}"=="live tv"  click link  ${livetv}
    run keyword if  "${contentsource}"=="music video"  click link  ${livetv}