*** Settings ***
Documentation    Suite description
Resource            locators/webportal/profile.robot
Resource            locators/webportal/homepage.robot


*** Keywords ***
Check If Selected Profile Is Primary Or Not
    ${status}=  run keyword and return status  page should contain element  ${primary_profile_selected}
    run keyword if  "${status}"=="False"  Switch To Primary User

Switch To Primary User
    click element  ${user_profile#1}
    click element  ${confirm_switch_profile}

Check and Proceed As Per Availability Of Profiles
    ${status}=  run keyword and return status  page should contain element  ${add_user_profile}
    run keyword if  "${status}"=="True"  Profile #4 Does Not Exist
    ...  ELSE  Profile #4 Exists

Profile #4 Does Not Exist
    Add User Profile
    Delete User Profile

Profile #4 Exists
    Delete User Profile
    Add User Profile

Add User Profile
    click element  ${add_user_profile}
    input text  ${profile_name}  Optimus Prime
    wait until element is visible  ${btn-add_profile}  timeout=${extended_wait}
    click element  ${btn-add_profile}
    wait until page contains  Optimus Prime  timeout=${extended_wait}

Delete User Profile
    wait until element is visible  xpath: /html//div[@id='switch-profile']/div[@class='modal-dialog']//div[@class='user-profile-item-container']/a[4]//div[@class='btn-group']/a[1]
    ${delete_prof}=  get text  xpath: /html//div[@id='switch-profile']/div[@class='modal-dialog']//div[@class='user-profile-item-container']/a[4]//div[@class='btn-group']/a[2]
    click element  xpath: /html//div[@id='switch-profile']/div[@class='modal-dialog']//div[@class='user-profile-item-container']/a[4]//div[@class='btn-group']/a[2]
    wait until element is visible  ${delete_profile_pop-up}  timeout=${extended_wait}
    click element  xpath: /html//div[@id='profile-delete-modal']/div[@class='modal-dialog']//div[@class='modal-footer']/button[2]
    wait until element is visible  ${profile_icon}
    wait until element is not visible  ${delete_profile_pop-up}  timeout=${extended_wait}
    click link  ${profile-switchprofile}
    wait until page contains element  ${add_user_profile}  timeout=${extended_wait}
    page should contain  ${add_user_profile}