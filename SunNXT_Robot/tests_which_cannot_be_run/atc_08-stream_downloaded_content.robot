*** Settings ***
Documentation    Suite description
Library             BuiltIn
Resource            ../keywords/android_app/high_level_keywords/stream_downloaded_content.robot
Resource            ../keywords/android_app/high_level_keywords/authentication.robot
Resource            ../test_data/credentials.robot
Test Setup          Login Via App  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown       Close App
Test Template       Download Video And Stream It

*** Test Cases ***                                                              content_language       content_header          carousel_title               content_name           download_quality
#TEST-SCENARIO 92: DOWNLOAD A MOVIE AND STREAM IT OFFLINE
#TEST-SCENARIO 93: DOWNLOAD A TV-SHOW AND STREAM IT OFFLINE
TEST-SCENARIO 94: DOWNLOAD A MUSIC-VIDEO AND STREAM IT OFFLINE                  TELUGU                 MUSIC VIDEOS            DANCE SONGS                  Podaade Poda Poda      HD
#TEST-SCENARIO 95: DOWNLOAD A COMEDY CLIP AND STREAM IT OFFLINE