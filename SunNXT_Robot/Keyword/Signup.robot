*** Settings ***
Documentation    Suite description
Resource         ../Locators/Authentication.robot
Resource        ../Variable/Variables.robot

*** Keywords ***
Click on Sign-Up link
    Wait Until Element Is Visible  ${signup_link}
    Click Element  ${signup_link}

Enter new user UserID
    Input Text  ${signup_user}   testpython05@mail.com

Enter registered user UserID
    Input Text  ${signup_user}  9538646030

Enter new user Password
    Input Password  ${signup_password}   123456

Enter name of the user
    Input Text  ${signup_name}  Natsu Dragneel

Select age of the person
    Click Element  ${signup_age}
    Click Link  ${signup_18-25}

Select gender as male
    Click Element  ${signup_male}

Select residing country of the user
    Click Element  ${signup_country}
    Wait Until Element Is Visible  ${signup_country-IN}
    Click Link  ${signup_country-IN}

Select residing state of the user
    sleep  1s
    #Wait Until Element Is Visible  ${signup_state}
    Click Element  ${signup_state}
    Wait Until Element Is Visible  ${signup_state-AP}
    Click Link  ${signup_state-AP}

Click 'Agree Terms' checkbox
    sleep  1s
    Click Element At Coordinates  ${agree_checkbox}  -140   0

Click on Submit button to create new credential
    Click Button  ${submit_button}

Error Message displayed is:
    Wait Until Element Is Visible  ${signup_error}  timeout=15s
    ${error_message} =  Get Text  ${signup_error}
    Log Many  ${error_message}

Check whether user is navigated to Homepage or not
    Wait Until Element Is Visible  ${sunnxt_logo}
    Log Location