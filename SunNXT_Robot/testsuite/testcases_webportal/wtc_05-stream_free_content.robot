*** Settings ***
Documentation       Stream free-tag content from home section using credential with no subscription
Resource            E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/common.robot
Resource            E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/player.robot
Resource            E:/Automation-Java/SunNXT_Robot/locators/webportal/content/content_home.robot
Resource            E:/Automation-Java/SunNXT_Robot/test_data/credentials.robot
Suite Setup         run keyword  LOGIN INTO WEB PORTAL  ${reg_id-sd_exp}  ${reg_pass-sd_exp}
Suite Teardown      CLOSE CHROME BROWSER
Test Template       STREAM CONTENT
Force Tags          Smoke

*** Test Cases ***                  contentsource         contentlanguage                content
STREAM FREE-TAG LIVE TV               home                     TAMIL              ${hbr#2_content#3}
STREAM FREE_TAG TRAILER(TELUGU)       home                    TELUGU              ${hbr#10_content#1}
#STREAM FREE_TAG TRAILER(MALAYALAM)    home                   MALAYALAM            ${hbr#8_content#1}
#STREAM FREE_TAG TRAILER(TAMIL)        home                     TAMIL              ${hbr#12_content#1}
#STREAM FREE_TAG TRAILER(KANNADA)      home                    KANNNADA            ${hbr#8_content#1}

