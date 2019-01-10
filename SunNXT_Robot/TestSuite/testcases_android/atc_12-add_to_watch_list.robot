*** Settings ***
Documentation    Suite description
Library             AppiumLibrary
Resource         keywords/android_app/high_level_keywords/watch_list.robot
Test Setup       Launch App
Test Teardown    Close App
Test Template    Add Content To Watch List

*** Test Cases ***                                   user_type      content_language    content_header
TEST-SCENARIO 113: ADD TAMIL MOVIE TO WATCHLIST      ID_Email_Subs  Tamil               movies

