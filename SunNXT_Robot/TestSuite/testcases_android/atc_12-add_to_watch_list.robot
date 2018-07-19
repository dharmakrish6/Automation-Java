*** Settings ***
Documentation    Suite description
Resource         ../keywords/android_app/high_level_keywords/watch_list.robot
Resource         ../keywords/android_app/high_level_keywords/authentication.robot
Resource         ../keywords/android_app/low_level_keywords/android_common.robot
Resource         ../test_data/credentials.robot
Test Setup       LOGIN VIA APP  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown    CLOSE APP
Test Template    Add Content To Watch List

*** Test Cases ***                                                          content_language    content_tab    carousel_title           content_name
TEST-SCENARIO 113: ADD TAMIL MOVIE TO WATCHLIST                     TAMIL               MOVIES         LATEST MOVIES IN HD      Meesaya Murukku