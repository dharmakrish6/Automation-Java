*** Settings ***
Documentation           Flow to subscribe a plan through various payment modes available
Resource                ../keywords/webportal/low_level_keywords/web_subscription.robot
Resource                ../keywords/webportal/low_level_keywords/content/web_homepage.robot
Resource                ../keywords/webportal/low_level_keywords/web_vod_detailsscreen.robot

*** Keywords ***
Subscribe A Plan From Pop-Up
    [Arguments]  ${content}  ${subscription_plan}  ${payment_mode}  ${card_type}  ${card_number}  ${name_on_card}  ${expiry_month}  ${expiry_year}  ${card_cvv}  ${auto_renewal}
    Click On Content Carousel  ${content}
    Click On Play Button Red
    Dismiss Sun Direct Expiry Pop-up
    Select Subscription Plan From Subscription Pop-Up  ${subscription_plan}
    Select Payment Mode  ${payment_mode}
    Select Card Type  ${card_type}
    Enter Card Number  ${card_number}
    Enter Card Name  ${name_on_card}
    Select Card Expiry Month  ${expiry_month}
    Select Card Expiry Year  ${expiry_year}
    Enter CVV Of Card  ${card_cvv}
    De-Authorize Auto-Renewal  ${auto_renewal}
    Proceed With Subcription