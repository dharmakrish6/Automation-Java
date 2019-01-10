*** Settings ***
Documentation    Suite description
Resource         keywords/webportal/low_level_keywords/web_common.robot
Resource         keywords/webportal/high_level_keywords/profile/add_favourite.robot
Test Setup              Open Browser And Navigate To SunNXT Website
Test Template       Add Content As Favourite
Test Teardown       Close Opened Browser

*** Test Cases ***                                      page_source         content_language
TEST-SCENARIO 67: ADD TAMIL VIDEO AS FAVOURITE          tv shows            Tamil
TEST-SCENARIO 68: ADD KANNADA VIDEO AS FAVOURITE        movies              Kannada
TEST-SCENARIO 69: ADD MALAYALAM VIDEO AS FAVOURITE      comedy              Malayalam
TEST-SCENARIO 70: ADD TELUGU VIDEO AS FAVOURITE         music videos        Telugu
