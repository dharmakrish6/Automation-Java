*** Settings ***
Documentation       STREAM A LIVE TV, MOVIE, TV SHOW, MUSIC VIDEO & COMEDY CLIP FOR EACH LANGUAGE
Resource            ../keywords/webportal/high_level_keywords/authentication.robot
Resource            ../keywords/webportal/high_level_keywords/player.robot
Resource            ../locators/webportal/content/content_home.robot
Resource            ../test_data/credentials.robot
Suite Setup         Open Browser And Navigate To SunNXT Website
Test Setup          Login Into Web Portal  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown       Logout From Web Portal
Suite Teardown      Close Opened Browser
Test Template       Stream Content
Force Tags          Smoke

*** Test Cases ***                                                  content_source  content_language    content
TEST-SCENARIO 37: STREAM TAMIL LIVE TV FROM HOME SECTION            HOME            TAMIL              Sun Music
TEST-SCENARIO 38: STREAM TAMIL MOVIE FROM HOME SECTION              HOME            TAMIL              Iravukku Aayiram Kangal
TEST-SCENARIO 39: STREAM TAMIL TV SHOW FROM HOME SECTION            HOME            TAMIL              Priyamanaval
TEST-SCENARIO 40: STREAM TAMIL MUSIC VIDEO FROM HOME SECTION        HOME            TAMIL              Ciciliya
TEST-SCENARIO 41: STREAM TAMIL COMEDY CLIP FROM HOME SECTION        HOME            TAMIL              Bramman - Soori Heroine Galatta

TEST-SCENARIO 42: STREAM TELUGU LIVE TV FROM HOME SECTION           HOME            TELUGU             Gemini TV
TEST-SCENARIO 43: STREAM TELUGU MOVIE FROM HOME SECTION             HOME            TELUGU             Agnyaathavaasi
TEST-SCENARIO 44: STREAM TELUGU TV SHOW FROM HOME SECTION           HOME            TELUGU             Nandini
TEST-SCENARIO 45: STREAM TELUGU MUSIC VIDEO FROM HOME SECTION       HOME            TELUGU             Emi
#TEST-SCENARIO 46: STREAM TELUGU COMEDY CLIP FROM HOME SECTION      HOME            TELUGU

TEST-SCENARIO 47: STREAM KANNADA LIVE TV FROM HOME SECTION          HOME            KANNADA            Udaya Movies
TEST-SCENARIO 48: STREAM KANNADA MOVIE FROM HOME SECTION            HOME            KANNADA            Thirupathi Express
TEST-SCENARIO 49: STREAM KANNADA TV SHOW FROM HOME SECTION          HOME            KANNADA            Sarayoo
TEST-SCENARIO 50: STREAM KANNADA MUSIC VIDEO FROM HOME SECTION      HOME            KANNADA            Vajrakaya
#TEST-SCENARIO 51: STREAM KANNADA COMEDY CLIP FROM HOME SECTION     HOME            KANNADA

TEST-SCENARIO 52: STREAM MALAYALAM LIVE TV FROM HOME SECTION        HOME            MALAYALAM          Surya Comedy
TEST-SCENARIO 53: STREAM MALAYALAM MOVIE FROM HOME SECTION          HOME            MALAYALAM          Villain
TEST-SCENARIO 54: STREAM MALAYALAM TV SHOW FROM HOME SECTION        HOME            MALAYALAM          Gulumal
TEST-SCENARIO 55: STREAM MALAYALAM MUSIC VIDEO FROM HOME SECTION    HOME            MALAYALAM          Manjadum
#TEST-SCENARIO 56: STREAM MALAYALAM COMEDY CLIP FROM HOME SECTION   HOME            MALAYALAM