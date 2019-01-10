*** Settings ***
Documentation    Suite description
Library          AppiumLibrary
Resource         keywords/android_app/high_level_keywords/download_vod.robot
Test Setup       Launch App
Test Teardown    Close App
Test Template    DOWNLOAD VIDEO AND VERIFY

*** Test Cases ***       content_language   content_header     download_quality    download_operation
MOVIE                    Tamil              movies          HD                  Cancel
#                                                                                                                                Delete
#                                                                                                                                NA