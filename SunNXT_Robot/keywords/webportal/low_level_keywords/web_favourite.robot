*** Settings ***
Documentation    Suite description
Resource         locators/webportal/vod_details_screen.robot

*** Keywords ***
Click Fav Button
    click element  ${favourite_button}
    wait until element is visible  ${favorite_message}  timeout=${extended_wait}

Check Favourites
    page should contain  ${content_name}