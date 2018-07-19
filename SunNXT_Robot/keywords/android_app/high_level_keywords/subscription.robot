*** Settings ***
Resource            ../keywords/android_app/low_level_keywords/android_subscription.robot
Resource            ../keywords/android_app/low_level_keywords/android_stream_vod.robot
Resource            ../keywords/android_app/low_level_keywords/android_stream_vod.robot
*** Keywords ***
Subscribe A Plan From Pop-Up
    [Arguments]  ${content_language}  ${content_header}  ${carousel_title}  ${content_name}  ${subscription_plan}  ${payment_mode}  ${card_type}  ${card_number}  ${name_on_card}  ${expiry_month}  ${expiry_year}  ${card_cvv}  ${auto_renewal}
    Select Content Language  ${content_language}
    Select Content Tab  ${content_header}
    Navigate To Content Details Screen  ${carousel_title}  ${content_name}
    Dismiss Displayed Coach Mark
    Start Streaming
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