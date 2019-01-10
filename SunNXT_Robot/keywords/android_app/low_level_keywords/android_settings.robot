*** Settings ***
Documentation       Options present under settings
Library             AppiumLibrary
Resource            locators/android_app/settings.robot
Resource            locators/android_app/common.robot

*** Keywords ***
Tap On Feeback Option
    click text  ${feedback}

Enter Feedback In Displayed Textbox
    input text  ${textbox_feedback}  This is a test feedback. Please Ignore it.

Submit Feedback
    click element  ${btn_submit_feedback}
    wait until page contains  ${feedback}  timeout=15