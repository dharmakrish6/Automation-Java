*** Settings ***
Documentation       Stream content from home section using credential with active subscription
Resource            E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/common.robot
Resource            E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/player.robot
Resource            E:/Automation-Java/SunNXT_Robot/locators/webportal/content/content_home.robot
Resource            E:/Automation-Java/SunNXT_Robot/test_data/credentials.robot
Suite Setup         run keyword  LOGIN INTO WEB PORTAL  ${reg_id-email_subs}  ${reg_pass-email_subs}
Suite Teardown      CLOSE CHROME BROWSER
Test Template       STREAM CONTENT
Force Tags          Smoke

*** Test Cases ***           contentsource         sourcelanguage           content
STREAM A LIVE TV                home                  TAMIL              ${hbr#2_content#6}
STREAM A MOVIE                  home                  TAMIL              ${hbr#3_content#1}
STREAM A TV SHOW                home                 MALAYALAM           ${hbr#12_content#1}
STREAM A MUSIC VIDEO            home                  TELUGU             ${hbr#13_content#1}
STREAM A COMEDY CLIP            home                  KANNADA            ${hbr#17_content#3}