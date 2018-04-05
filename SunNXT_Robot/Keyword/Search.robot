*** Settings ***
Documentation    Suite description
Library          SeleniumLibrary
Library          BuiltIn
Resource         ../Locators/SunNXThome.robot
Resource         ../Variable/Variables.robot
*** Keywords ***
Click on Search icon
    Click Element  ${search_icon}

Click on Search box
    Click Element  ${search_field}

Enter Search query for movie
    Input Text     ${search_field}   ${movie_name}
    Press Key      ${search_field}   ${Enter_key}