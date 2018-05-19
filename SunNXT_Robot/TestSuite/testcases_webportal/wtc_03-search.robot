*** Settings ***
Documentation       Search a movie, tvshow and music-video using different sets of credential
Resource              E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/search.robot
Resource              E:/Automation-Java/SunNXT_Robot/variable/credentials.robot
Suite Setup         run keyword  AUTHENTICATE WEB PORTAL WITH VALID  ${reg_id-email_subs}  ${reg_pass-email_subs}
Test Teardown       CLOSE CHROME BROWSER
Test Template       SEARCH FOR A MOVIE, TV SHOW AND MUSIC VIDEO
Force Tags          Smoke

*** Test Cases ***          content_name
SEARCH FOR A MOVIE                4
SEARCH FOR A TV SHOW          Amma Pillai
SEARCH FOR A MUSIC VIDEO    Therikuthu Therikuthu Mass