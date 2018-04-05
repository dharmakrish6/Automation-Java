*** Settings ***
Documentation    SunNXT Web-portal
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Locators/Content/HomePage.robot
Resource         ../Locators/SunNXThome.robot

*** Keywords ***
Click on 1st Carousel Indicator
    Wait Until Page Contains Element  ${carousel_one}
    Double Click Element  ${CIndicator_one}

Click on 1st Carousel Content
    Wait Until Page Contains Element  ${carousel_one}
    Click Element  ${carousel_one}

Click on 4th Carousel Indicator
    Wait Until Page Contains Element  ${carousel_four}
    Double Click Element  ${CIndicator_four}

Click on 4th Carousel Content
    Wait Until Page Contains Element  ${carousel_four}
    Click Element  ${carousel_four}

Click on Free-tag content
    Wait Until Page Contains Element  ${#0_Content3}
    Click Element  ${#0_Content3}

Click on Content-carousel in row 1
    Wait Until Page Contains Element  ${#0_Content2}
    Click Element  ${#0_Content2}

Click on Content-carousel in row 7
    Wait Until Page Contains Element  ${#7_Content4}
    Click Element  ${#7_Content4}

Click on Live TV header link
    Click Link  ${header_livetv}