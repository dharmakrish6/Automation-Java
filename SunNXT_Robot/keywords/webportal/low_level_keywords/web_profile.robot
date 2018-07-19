*** Settings ***
Documentation           Contains keywords related to operations perfomed in profile page
Library                 String
Resource                ../locators/webportal/profile.robot

*** Keywords ***
Record Latest Content In Continue Watching
    ${latest_streamed}  get text  ${recently_streamed}
    convert to string  ${latest_streamed}
    ${latest_streamed}  convert to lowercase  ${latest_streamed}
    set global variable  ${latest_streamed}

Click On Edit Profile Icon
    click element  ${editprofile_icon}

Wait Until Profile Slide-In Appears
    wait until element is visible  ${edit_profile-slide_in}

Click On 'Edit Complete Profile' Button
    click element  ${p-edit_complete_profile}

Wait Until Edit Complete Profile Page Appears
    wait until element is visible  ${edit_profile_page}

Fetch UserName And Verify
    ${profile_displayed}=  get text  ${profile_username}
    convert to string  ${profile_displayed}
    should be true  "${profile_selected}"=="${profile_displayed}"