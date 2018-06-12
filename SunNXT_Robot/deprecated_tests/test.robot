*** Settings ***
Documentation       Stream free-tag content from home section using credential with no subscription
Library             SeleniumLibrary
Resource            E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/common.robot
Resource            E:/Automation-Java/SunNXT_Robot/keywords/webportal/high_level_keywords/player.robot
Resource            E:/Automation-Java/SunNXT_Robot/locators/webportal/content/content_tvshows.robot
Resource            E:/Automation-Java/SunNXT_Robot/locators/webportal/homepage.robot
Resource            E:/Automation-Java/SunNXT_Robot/test_data/credentials.robot
Suite Setup         OPEN CHROME BROWSER
Suite Teardown      CLOSE CHROME BROWSER

*** Test Cases ***
TestCase TEST:
    TEST KEYWORD

*** Keywords ***
TEST KEYWORD
    :for    ${scroll_down}    in range    10
    \  ${status}=  run keyword and return status  page should contain  ${carousel_title}
    \  run keyword if  "${status}"=="False"  SCROLL DOWN LOGIC
    \  continue for loop if  "${status}"=="False"
    \  ${status}=  run keyword and return status  page should contain  ${content_name}
    \  run keyword if  "${status}"=="False"  SCROLL DOWN LOGIC 2
    \  wait until page contains  ${content_name}  timeout=10
    \  click link  link:${content_name}
    \  exit for loop
    capture page screenshot

SCROLL DOWN LOGIC
    Execute Javascript  window.scrollTo(0, ${y})
    capture page screenshot
    ${y}=  evaluate  ${y} + 384
    set global variable  ${y}

SCROLL DOWN LOGIC 2
    Execute Javascript  window.scrollTo(0, ${scroll_title})
    capture page screenshot
    ${scroll_title}=  evaluate  ${scroll_title} + 192

#SCROLL TO CONTENT
#     :for    ${index}    in range    10
#     \  Press Key  tag=body  \\57365

*** Variables ***
${y}  384
${scroll_title}  384

${carousel_title}  RECOMMENDED MOVIES
${content_name}    SUNDARAPANDIAN - TERRACE DRINKING GALATTA