*** Settings ***
Documentation    Suite description
Resource            locators/webportal/profile/apply_coupon.robot

*** Keywords ***
Enter Coupon Code
    ${coupon_code}=  convert to string  Invalid  #to use excel reader
    input text  ${coupon_code-text_box}  ${coupon_code}

Submit Entered Coupon Code
    click element  ${coupon_code-submit}

Dismiss Coupon Code Error Message
    handle alert  action=ACCEPT