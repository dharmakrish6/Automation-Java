*** Variables ***
${user_type}                     id=com.suntv.sunnxt:id/primaryUserText

${p_user_name}                   id=com.suntv.sunnxt:id/editProfilenameText
${p_email_id}                    id=com.suntv.sunnxt:id/editProfileemailText
${p_mob_num}                     id=com.suntv.sunnxt:id/editProfileNumberText

${p_edit_complete_profile}       Edit Complete Profile
${p_change_password}             Change Password

${save_changes}                  Save

#edit complete profile
${assert_edit_complete_profile}  id=com.suntv.sunnxt:id/logo_background
${full_name}                    id=com.suntv.sunnxt:id/firstName
${mob_num}                       id=com.suntv.sunnxt:id/mobileNumber
${email_id}                      id=com.suntv.sunnxt:id/email
${age}                           id=com.suntv.sunnxt:id/ageSpinner
${gender_male}                   id=com.suntv.sunnxt:id/maleIcon
${gender_female}                 id=com.suntv.sunnxt:id/femaleIcon
${country}                       id=com.suntv.sunnxt:id/countrySpinner
${state}                         id=com.suntv.sunnxt:id/stateSpinner
${btn_done}                      DONE

#change password
${assert_change_password}        CHANGE PASSWORD
${old_pass}                      id=com.suntv.sunnxt:id/oldPasswordfield
${new_pass}                      id=com.suntv.sunnxt:id/newPasswordfield
${re-enter_pass}                 id=com.suntv.sunnxt:id/confirmNewPasswordfield
${save_pass}                     SAVE
${cancel_pass}                   CANCEL