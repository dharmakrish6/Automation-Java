*** Variables ***
${profile_auth}           css: #show_sign [href="\#"]
${signin_link}            Sign In
${popup}                  css: .popup_footer

#signin popup
${user_name}              id: email-up
${password}               id: password
${login_button}           css: button.btn.btn-red
${signin_error}           css: [role="form"] .error

#signup popup
${signup_link}            css: [role="form"] .already_memb a
${signup_user}            id:  email-in
${signup_password}        id:  password1
${signup_name}            id:  first
${signup_age}             css: #signup_form .filter-option
${signup_male}            css: .male_select
${signup_female}          css: .female_select
${signup_country}         css: #signup_form .form-group:nth-of-type(1) [type="search"]
${signup_state}           css: #signup_form .form-group:nth-of-type(2) [type="search"]
${agree_checkbox}         css: [for="term1"]
${submit}                 css: #signup_form [type="submit"]
${signup_error}           css: #signup_form .error
${credential_error}       css: .errormsg3