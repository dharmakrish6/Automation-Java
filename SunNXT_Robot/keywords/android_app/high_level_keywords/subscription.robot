*** Settings ***
Resource            keywords/android_app/low_level_keywords/android_subscription.robot
Resource            keywords/android_app/low_level_keywords/android_stream_vod.robot
Resource            keywords/android_app/low_level_keywords/android_stream_vod.robot
Resource            keywords/android_app/high_level_keywords/authentication.robot

*** Keywords ***
Subscribe A Plan From Pop-Up
    [Arguments]  ${user_type}  ${content_language}  ${content_header}  ${subscription_plan}  ${card_type}  ${auto_renewal}
    Authenticate App  ${user_type}
    Navigate To Change Content Language
    Select Content Language  ${content_language}
    Select Content Tab  ${content_header}
    Navigate To Content Details Screen  ${content_language}  ${content_header}
    Dismiss Displayed Coach Mark
    Start Streaming
    Select Subscription Plan From Subscription Pop-Up  ${subscription_plan}
    Select Payment Mode  ${card_type}
    Select Card Type  ${card_type}
    Enter Card Number  ${card_type}
    Enter Card Name  ${card_type}
    Select Card Expiry Month  ${card_type}
    Select Card Expiry Year  ${card_type}
    Enter CVV Of Card  ${card_type}
    De-Authorize Auto-Renewal  ${auto_renewal}
    Proceed With Subcription