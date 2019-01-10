*** Settings ***
Resource            keywords/webportal/low_level_keywords/content/web_homepage.robot
Resource            keywords/webportal/low_level_keywords/web_common.robot
Resource            keywords/webportal/low_level_keywords/web_favourite.robot
Resource            keywords/webportal/high_level_keywords/authentication.robot

*** Keywords ***
Add Content As Favourite
    [Arguments]  ${page_source}  ${content_language}
    Authenticate Web Portal  ID_Email_Subs
    Select Source Page  ${page_source}
    Select Content Language  ${content_language}
    Click On Content Carousel  ${page_source}  ${content_language}
    Click Fav Button
    Click On Profile Icon
    Click On Profile Link
    Check Favourites