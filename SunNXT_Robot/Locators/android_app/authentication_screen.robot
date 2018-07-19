*** Variables ***
#loading animation
${login_loading_animation}      `
${login_loading_popup}          id=	android:id/body
${login_loading_text}           id=android:id/message
#Loading...


#login page
${username}           id=com.suntv.sunnxt:id/phnEditTextLoginPage
${email_password}     id=com.suntv.sunnxt:id/emailPasswordField
${mob_password}       xpath=//android.widget.EditText[contains(@resource-id,'phonePasswordField')]
${regex}              [0-9]{10}
${sunnxt_banner}      id=com.suntv.sunnxt:id/logo_background

#links
${l_signup_in}   id=com.suntv.sunnxt:id/signUpText

#signup page
${s_userid}       id=com.suntv.sunnxt:id/userIDEditTextLoginPage
${s_password}     id=com.suntv.sunnxt:id/passwordField
${s_fullname}     id=com.suntv.sunnxt:id/fullName
${s_age}          id=com.suntv.sunnxt:id/ageSpinner
${s_male}         xpath=//android.widget.ImageView[contains(@resource-id, 'maleIcon')]
${s_female}       xpath=//android.widget.ImageView[contains(@resource-id, 'femaleIcon')]
${s_country}      id=com.suntv.sunnxt:id/countrySpinner
${s_state}        id=com.suntv.sunnxt:id/stateSpinner

#age dropdown
${s_age_18}        18-25 Years

#country dropdown
${s_country_IN}  India

#state dropdown
${s_state_ANI}     Andaman and Nicobar Islands

#button
${btn_login}      id=com.suntv.sunnxt:id/login_button
${btn_submit}     id=com.suntv.sunnxt:id/submitSignUp_button

#assertions
${a_signin}       SIGN IN
${a_signup}       SIGN UP