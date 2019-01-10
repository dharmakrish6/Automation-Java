*** Settings ***
Documentation    Suite description
Library         AppiumLibrary
Resource         keywords/android_app/high_level_keywords/favourite_actors.robot
Test Setup       Launch App
Test Teardown    Close App
Test Template    Add Actor/Actress To Favourite List

*** Test Cases ***                                     user_type       content_language    content_header
TEST-SCENARIO 113: ADD AN ACTOR TO FAVOURITE LIST      ID_Email_Subs   Tamil               home