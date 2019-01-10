*** Settings ***
Documentation    Suite description
Resource         keywords/webportal/low_level_keywords/web_common.robot
Resource         keywords/webportal/high_level_keywords/filter_content.robot
Test Setup          Open Browser And Navigate To SunNXT Website
Test Template       Filter Content In View All Section
Test Teardown       Close Opened Browser

*** Test Cases ***                          page_source
TEST-SCENARIO 71: Filter a Movie            movies
TEST-SCENARIO 72: Filter a TV Show          tv shows
TEST-SCENARIO 73: Filter a Music Video      music videos
