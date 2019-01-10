*** Variables ***
${profile_username}     css= .user-name
${editprofile_icon}     xpath=//span[@class='icon-icn_edit-2']
${userrole}             xpath=//div[@class='user-details']//p[@class='user-role']
${switchuser}           xpath=//div[@class='user-pic']//a[@href='#']

#continue watching section
${recently_streamed}    xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/b[1]/h3[1]/div[1]
${recently_streamed#2}  xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/a[1]/h4[1]
${recently_streamed#3}  xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[2]/div[2]/a[1]/h4[1]
${recently_streamed#4}  xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[2]/div[3]/a[1]/h4[1]
${recently_streamed#5}  xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[2]/div[4]/a[1]/h4[1]

${subscription}         xpath=//a[@href='/payment/subscription'][contains(text(),'Subscription')]
${payment}              xpath=//a[@href='/payment/billing-history']

#edit profile slide-in
${edit_profile-slide_in}          css= #edit-profile .modal-body

${p-username}                     css= #edit-profile .form-group:nth-of-type(1) [type]
${p-email_id}                     css= #edit-profile .form-group:nth-of-type(2) [type]
${p-change_password}              link: Change Password
${p-edit_complete_profile}        link: EDIT COMPLETE PROFILE

${p-btn_done}                     css= #edit-profile [type="submit"]
${p-btn_cancel}

#edit complete profile
${edit_profile_page}             css= [class="col-md-12 signup_inn_wrap"]
${ep_name}                       id= name
${ep_last_name}                  id= lastname
${ep_mobile}                     css= [name="mobile"]
${ep_email_id}                   css= #email
${ep_age}                        css= .filter-option
${ep_gender_m}                   css= span.male
${ep_gender_m-selected}          css= span.male.gender-selected
${ep_gender_f}                   css= span.male.female
${ep_gender_f-selected}          css= span.male.female.gender-selected
${ep_country}                    css= [role] [class='col-md-6 form-group']:nth-of-type(1) .chosen-search-input
${ep_state}                      css= [role] [class='col-md-6 form-group']:nth-of-type(2) .chosen-search-input

${ep_btn_back}                     link: BACK
${ep_btn_done}                     link: DONE

#change password
${current_password}                 name: current_password
${new_password}                     name: new_password
${confirm_password}                 name: confirm_password

${submit_new_password}              css= #change-password [type="submit"]
${cancel_password}                  css= #change-password [type="button"]

#switch profile
${switch_profile_pop-up}                    css= #switch-profile .modal-content
${user_profile#1}                           xpath= /html//div[@id='switch-profile']//div[@class='user-profile-item-container']/a[1]/div[@class='home_movie_wrap']
${name_profile#1}                           css= #switch-profile > div > div > div.modal-body > div > a:nth-child(1) > div > h4

${user_profile#2}                           xpath= /html//div[@id='switch-profile']//div[@class='user-profile-item-container']/a[2]/div[@class='home_movie_wrap']
${name_profile#2}                           css= #switch-profile > div > div > div.modal-body > div > a:nth-child(2) > div > h4

${user_profile#3}                           xpath= /html//div[@id='switch-profile']//div[@class='user-profile-item-container']/a[3]/div[@class='home_movie_wrap']
${name_profile#3}                           css= #switch-profile > div > div > div.modal-body > div > a:nth-child(3) > div > h4

${user_profile#4}                           xpath= /html//div[@id='switch-profile']//div[@class='user-profile-item-container']/a[4]/div[@class='home_movie_wrap']
${name_profile#4}                           css= #switch-profile > div > div > div.modal-body > div > a:nth-child(3) > div > h4

${selected_profile}                         css= .user-profile-item.selected
${primary_profile_selected}                 css= .user-profile-item.selected p.user-role

${cancel_switch_profile}
${confirm_switch_profile}                   id= doneBtn


${add_user_profile}                         css= .add-icon
${prof_img#1}                               css= [for="profile-image1"] .hm_movie_img
${prof_img#2}                               css= [for="profile-image2"] .hm_movie_img
${prof_img#3}                               css= [for="profile-image3"] .hm_movie_img
${prof_img#4}                               css= [for="profile-image4"] .hm_movie_img

#delete profile
${delete_profile_pop-up}                    css= #profile-delete-modal .modal-content

#add user
${profile_name}                             id= username
${btn-add_profile}                          css= #add-profile-form button
${btn-cancel_profile_addition}              css= #add-profile-form [type="button"]