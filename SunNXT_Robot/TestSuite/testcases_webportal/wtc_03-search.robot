*** Settings ***
Documentation       SEARCH FOR MOVIE, TV SHOW AND MUSIC VIDEO FOR DIFFERENT CONTENT LANGUAGE
Resource         keywords/webportal/high_level_keywords/search.robot
Test Setup          Open Browser And Navigate To SunNXT Website
Test Teardown       Close Opened Browser
Test Template       Search For A Movie, Tv Show And Music Video
Force Tags          Smoke

*** Test Cases ***                                  content_language           content_name
TEST-SCENARIO 25: SEARCH FOR TAMIL MOVIE            Tamil                      Mass Engira Masilamani
TEST-SCENARIO 28: SEARCH FOR TELUGU MOVIE           Telugu                     Agnyaathavaasi
TEST-SCENARIO 31: SEARCH FOR KANNADA MOVIE          Kannada                    Vayuputra
TEST-SCENARIO 34: SEARCH FOR MALAYALAM MOVIE        Malayalam                  Solo
#
TEST-SCENARIO 26: SEARCH FOR TAMIL TV SHOW          Tamil                      Amma pillai
TEST-SCENARIO 29: SEARCH FOR TELUGU TV SHOW         Telugu                     Maavidakulu
TEST-SCENARIO 32: SEARCH FOR KANNADA TV SHOW        Kannada                    Brahmastra
TEST-SCENARIO 35: SEARCH FOR MALAYALAM TV SHOW      Malayalam                  Gauri

TEST-SCENARIO 27: SEARCH FOR TAMIL MUSIC VIDEO      Tamil                      Therikuthu Therikuthu Mass
TEST-SCENARIO 30: SEARCH FOR TELUGU MUSIC VIDEO     Telugu                     Chiniki Chiniki
TEST-SCENARIO 33: SEARCH FOR KANNADA MUSIC VIDEO    Kannada                    Saaluthillave
TEST-SCENARIO 36: SEARCH FOR MALAYALAM MUSIC VIDEO  Malayalam                  Ee Pooyavayilil