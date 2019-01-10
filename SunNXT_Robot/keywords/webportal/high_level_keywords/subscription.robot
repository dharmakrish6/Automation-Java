*** Settings ***
Documentation           Flow to subscribe a plan through various payment modes available
Resource                keywords/webportal/low_level_keywords/web_subscription.robot
Resource                keywords/webportal/low_level_keywords/content/web_homepage.robot
Resource                keywords/webportal/low_level_keywords/web_vod_detailsscreen.robot
Resource                keywords/webportal/low_level_keywords/web_common.robot
Resource         keywords/webportal/high_level_keywords/authentication.robot

*** Keywords ***
Subscribe A Plan From Pop-Up
    [Arguments]  ${page_source}  ${content_language}  ${subscription_plan}  ${card_type}
    Authenticate Web Portal  ID_SunDirect_Exp
    Select Source Page  ${page_source}
    Select Content Language  ${content_language}
    Click On Content Carousel  ${page_source}  ${content_language}
    Click On Play Button Red
    Dismiss Sun Direct Expiry Pop-up
    Select Subscription Plan From Subscription Pop-Up  ${subscription_plan}
    Select Payment Mode  ${card_type}
    Select Card Type  ${card_type}
    Enter Card Number  ${card_type}
    Enter Card Name  ${card_type}
    Select Card Expiry Month  ${card_type}
    Select Card Expiry Year  ${card_type}
    Enter CVV Of Card  ${card_type}
    De-Authorize Auto-Renewal  ${card_type}
    Proceed With Subcription