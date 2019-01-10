*** Settings ***
Documentation       Suite description
Library             AppiumLibrary
Resource         keywords/android_app/high_level_keywords/stream_downloaded_content.robot
Test Setup          Launch App
Test Teardown       Close App
Test Template       Download Video And Stream It

*** Test Cases ***                                                              content_language       content_header   download_quality
#TEST-SCENARIO 92: DOWNLOAD A MOVIE AND STREAM IT OFFLINE
#TEST-SCENARIO 93: DOWNLOAD A TV-SHOW AND STREAM IT OFFLINE
TEST-SCENARIO 94: DOWNLOAD A MUSIC-VIDEO AND STREAM IT OFFLINE                  Telugu                 music videos      HD
#TEST-SCENARIO 95: DOWNLOAD A COMEDY CLIP AND STREAM IT OFFLINE