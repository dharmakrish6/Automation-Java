*** Settings ***
Documentation       Suite description
Resource            ../keywords/android_app/high_level_keywords/stream_content.robot
Resource            ../keywords/android_app/high_level_keywords/authentication.robot
Resource            keywords/android_app/low_level_keywords/android_common.robot
Resource            ../test_data/credentials.robot
Test Setup          Login Via App  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown       Close App
Test Template       Navigate To And Stream Any Content

*** Test Cases ***                                                          content_language    content_header    carousel_title                content_name
TEST-SCENARIO 25: STREAM TAMIL MOVIE FROM HOME SECTION                      TAMIL               HOME              LATEST MOVIES IN HD           Iravukku Aayiram Kangal
TEST-SCENARIO 26: STREAM TAMIL TV SHOW FROM HOME SECTION                    TAMIL               HOME              TV SERIAL IN HD               Nandini
TEST-SCENARIO 27: STREAM TAMIL MUSIC VIDEO FROM HOME SECTION                TAMIL               HOME              SUPERHIT SONGS IN HD          Yathe Yathe
TEST-SCENARIO 28: STREAM TAMIL COMEDY CLIP FROM HOME SECTION                TAMIL               HOME              BEST OF SETHIL-GOUNDAMANI     Abirami - Senthil Chennai Entry

TEST-SCENARIO 29: STREAM TELUGU MOVIE FROM HOME SECTION                     TELUGU              HOME              COMEDY MOVIES IN HD           Malligadu Marriage Bureau
TEST-SCENARIO 30: STREAM TELUGU TV SHOW FROM HOME SECTION                   TELUGU              HOME              LATEST EPISODES IN HD         Anugraham - July 11, 2018
TEST-SCENARIO 31: STREAM TELUGU MUSIC VIDEO FROM HOME SECTION               TELUGU              HOME              MELODY SONGS                  O Sakkanoda
#TEST-SCENARIO 32: STREAM TELUGU COMEDY CLIP FROM HOME SECTION                TELUGU              HOME

TEST-SCENARIO 33: STREAM KANNADA MOVIE FROM HOME SECTION                    KANNADA             HOME              ROMANCE MOVIES                College Kumar
TEST-SCENARIO 34: STREAM KANNADA TV SHOW FROM HOME SECTION                  KANNADA             HOME              TV SHOWS IN HD                Best of Best Harate
TEST-SCENARIO 35: STREAM KANNADA MUSIC VIDEO FROM HOME SECTION              KANNADA             HOME              RECENTLY ADDED MUSIC ALBUMS   Chowka
TEST-SCENARIO 36: STREAM KANNADA COMEDY CLIP FROM HOME SECTION              KANNADA             HOME              COMEDIANS                     Sharan and Ramesh Bhat

TEST-SCENARIO 37: STREAM MALAYALAM MOVIE FROM HOME SECTION                  MALAYALAM           HOME              EVERGREEN COMEDY MOVIES       Moookkilla Rajyathu
TEST-SCENARIO 38: STREAM MALAYALAM TV SHOW FROM HOME SECTION                MALAYALAM           HOME              LATEST EPISODES IN HD         Gauri - July 10, 2018
TEST-SCENARIO 39: STREAM MALAYALAM MUSIC VIDEO FROM HOME SECTION            MALAYALAM           HOME              HARIHARAN HITS                Oro Nokil
#TEST-SCENARIO 40: STREAM MALAYALAM COMEDY CLIP FROM HOME SECTION            MALAYALAM           HOME

TEST-SCENARIO 41: STREAM TAMIL MOVIE FROM MOVIES SECTION                    TAMIL               MOVIES            HORROR MOVIES IN HD      Devi
TEST-SCENARIO 42: STREAM TELUGU MOVIE FROM MOVIES SECTION                   TELUGU              MOVIES            ACTION MOVIES            Karthikeya
TEST-SCENARIO 43: STREAM KANNADA MOVIE FROM MOVIES SECTION                  KANNADA             MOVIES            RECOMMENDED MOVIES       Jackson
TEST-SCENARIO 44: STREAM MALAYALAM MOVIE FROM MOVIES SECTION                MALAYALAM           MOVIES            THRILLER MOVIES          Vettah

TEST-SCENARIO 45: STREAM TAMIL SERIAL FROM TV-SHOWS SECTION                 TAMIL               TV SHOWS          TV SERIALS IN HD         Nandini
TEST-SCENARIO 46: STREAM TELUGU MOVIE FROM TV-SHOWS SECTION                 TELUGU              TV SHOWS          TV SHOWS IN HD           Sakala Siddhi
TEST-SCENARIO 47: STREAM KANNADA FROM TV-SHOWS SECTION                      KANNADA             TV SHOWS          KAVERI RECENT EPISODES   Kaveri - July 10, 2018
TEST-SCENARIO 48: STREAM MALAYALAM MOVIE FROM TV SHOWS SECTION              MALAYALAM           TV SHOWS          NANDINI RECENT EPISODES  Nandini - July 10, 2018

TEST-SCENARIO 49: STREAM TAMIL MUSIC VIDEO FROM MUSIC VIDEOS SECTION        TAMIL               MUSIC VIDEOS      ROMANTIC SONGS           Mun Andhi
TEST-SCENARIO 50: STREAM TELUGU MUSIC VIDEO FROM MUSIC VIDEOS SECTION       TELUGU              MUSIC VIDEOS      MELODY SONGS             Nesthamai
TEST-SCENARIO 51: STREAM KANNADA MUSIC VIDEO FROM MUSIC VIDEOS SECTION      KANNADA             MUSIC VIDEOS      SHREYA GHOSHAL SONGS     Matthe Maleyagide
TEST-SCENARIO 52: STREAM MALAYALAM MUSIC VIDEO FROM MUSIC VIDEOS SECTION    MALAYALAM           MUSIC VIDEOS      ASIF ALI HITS            Innale

TEST-SCENARIO 53: STREAM TAMIL COMEDY CLIP FROM COMEDY SECTION              TAMIL               MUSIC VIDEOS      VIVEK COMEDY SCENES      Aayutham Seivom - Vivek Court Comedy
TEST-SCENARIO 54: STREAM MALAYALAM MUSIC VIDEO FROM MUSIC VIDEOS SECTION    TELUGU              MUSIC VIDEOS      COMEDY CLIPS             Allu Arjun and Kajal Agarwal in Romance Scene from Aarya 2
TEST-SCENARIO 55: STREAM MALAYALAM MUSIC VIDEO FROM MUSIC VIDEOS SECTION    KANNADA             COMEDY            COMEDIANS                Sharan and Chikkanna Dance
TEST-SCENARIO 56: STREAM MALAYALAM MUSIC VIDEO FROM MUSIC VIDEOS SECTION    MALAYALAM           MUSIC VIDEOS      COMEDY CLIPS             ISHTAM - Wedding Scene