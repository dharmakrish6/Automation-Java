*** Settings ***
Documentation    Suite description
Library             ExcelReader
Library             AppiumLibrary

*** Keywords ***
Press Back Button
#    ${hw_back}=  get value from corresponding row  keystrokes  OS  Android  Back_Key
    press keycode  ${hw_back}
#    press keycode  KEYCODE_BACK

Press Home Button
    ${hw_home}=  get value from corresponding row  keystrokes  OS  Android  Home_Key
    press keycode  ${hw_home}

Press Recents Button
    ${hw_app_switch}=  get value from corresponding row  keystrokes  OS  Android  App_Switch_Key
    press keycode  ${hw_app_switch}

Press Search Button
    ${search_key}=  get value from corresponding row  keystrokes  OS  Android  Search_Key
    press keycode  ${search_key}

*** Variables ***
${hw_back}     4