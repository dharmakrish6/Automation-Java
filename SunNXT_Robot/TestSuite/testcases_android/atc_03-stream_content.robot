*** Settings ***
Documentation    Suite description
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/high_level_keywords/stream_content.robot
Resource         E:/Automation-Java/SunNXT_Robot/keywords/android_app/high_level_keywords/authentication.robot
Resource         E:/Automation-Java/SunNXT_Robot/test_data/credentials.robot
Resource         E:/Automation-Java/SunNXT_Robot/test_data/android_app/swipe_variables.robot
Test Setup       LOGIN VIA APP  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown    QUIT APPLICATION
Test Template    STREAM A VOD

*** Test Cases ***                                       content_language    content_header       carousel_title           content_name
TEST-SCENARIO 25: STREAM TAMIL MOVIE FROM HOME SECTION            TAMIL               HOME          LATEST MOVIES IN HD       Meesaya Murukku
TEST-SCENARIO 26: STREAM TELUGU MOVIE FROM HOME SECTION           TELUGU              HOME           BLOCKBUSTER MOVIES           Guru
TEST-SCENARIO 27: STREAM KANNADA MOVIE FROM HOME SECTION          KANNADA             HOME           RECOMMENDED MOVIES          Ganapa
TEST-SCENARIO 28: STREAM MALAYALAM MOVIE FROM HOME SECTION       MALAYALAM            HOME        EVERGREEN COMEDY MOVIES    Moookkilla Rajyathu
TEST-SCENARIO 29: STREAM TAMIL MOVIE FROM MOVIES SECTION          TAMIL              MOVIES         HORROR MOVIES IN HD           Devi
TEST-SCENARIO 30: STREAM TELUGU MOVIE FROM MOVIES SECTION         TELUGU             MOVIES            ACTION MOVIES            Karthikeya
TEST-SCENARIO 31: STREAM KANNADA MOVIE FROM MOVIES SECTION        KANNADA            MOVIES           THRILLER MOVIES            Dhairyam
TEST-SCENARIO 32: STREAM MALAYALAM MOVIE FROM MOVIES SECTION     MALAYALAM           MOVIES           ROMANTIC MOVIES           100% Love