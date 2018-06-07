*** Settings ***
Documentation       SEARCH FOR MOVIE, TV SHOW AND MUSIC VIDEO FOR DIFFERENT CONTENT LANGUAGE
Resource            E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/search.robot
Resource            E:/Automation-Java/SunNXT_Robot/test_data/credentials.robot
Suite Setup         run keyword  LOGIN INTO WEB PORTAL  ${reg_id-email_subs}  ${reg_pass-email_subs}
Suite Teardown      CLOSE CHROME BROWSER
Test Template       SEARCH FOR A MOVIE, TV SHOW AND MUSIC VIDEO
Force Tags          Smoke

*** Test Cases ***                                  content_language           content_name
TEST-SCENARIO 25: SEARCH FOR TAMIL MOVIE                 TAMIL               Mass Engira Masilamani
TEST-SCENARIO 26: SEARCH FOR TAMIL TV SHOW               TAMIL                    Amma Pillai
TEST-SCENARIO 27: SEARCH FOR TAMIL MUSIC VIDEO           TAMIL             Therikuthu Therikuthu Mass
TEST-SCENARIO 28: SEARCH FOR TELUGU MOVIE                TELUGU                Agyaanthavaasi
TEST-SCENARIO 29: SEARCH FOR TELUGU TV SHOW              TELUGU                  Maavidakulu
TEST-SCENARIO 30: SEARCH FOR TELUGU MUSIC VIDEO          TELUGU                Chiniki Chiniki
TEST-SCENARIO 31: SEARCH FOR KANNADA MOVIE               KANNADA                 Vayuputra
TEST-SCENARIO 32: SEARCH FOR KANNADA TV SHOW             KANNADA                 Brahmastra
TEST-SCENARIO 33: SEARCH FOR KANNADA MUSIC VIDEO         KANNADA                Saaluthillave
TEST-SCENARIO 34: SEARCH FOR MALAYALAM MOVIE             MALAYALAM                  Solo
TEST-SCENARIO 35: SEARCH FOR MALAYALAM TV SHOW           MALAYALAM                  Gauri
TEST-SCENARIO 36: SEARCH FOR MALAYALAM MUSIC VIDEO       MALAYALAM              Ee Pooyavayilil