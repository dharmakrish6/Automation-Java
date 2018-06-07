*** Settings ***
Documentation       Stream free-tag content from home section using credential with no subscription
Resource            E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/common.robot
Resource            E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/player.robot
Resource            E:/Automation-Java/SunNXT_Robot/locators/webportal/content/content_tvshows.robot
Resource            E:/Automation-Java/SunNXT_Robot/test_data/credentials.robot
Suite Setup         run keyword  LOGIN INTO WEB PORTAL  ${reg_id-sd_subs}  ${reg_pass-sd_subs}
Suite Teardown      CLOSE CHROME BROWSER
Test Template       STREAM CONTENT
Force Tags          Smoke

*** Test Cases ***      contentsource       sourcelanguage               content
