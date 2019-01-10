*** Variables ***
${profile_auth}           css= #show_sign [href="\#"]
${signin_link}            Sign In
${popup}                  css= [role="document"] .modal-content
${close_popup}            css= .close

#signin popup
${user_name}              id= email-up
${password}               id= password
${login_button}           css= [role='form'] [type='submit']
${signin_error}           css= [role="form"] .error

#signup popup
${signup_link}            css= [role="form"] .already_memb a
${signup_user}            id=  email-in
${signup_password}        id=  password1
${signup_name}            id=  first
${signup_age}             css= #signup_form .filter-option
${signup_male}            css= .male_select
${signup_female}          css= .female_select
${signup_country}         id=  selectcountry_chosen
${signup_country/state_input}  css= input.chosen-search-input
${signup_state}           id=  stateid_chosen
${agree_checkbox}         css= [for="term1"]
${submit}                 css= #signup_form [type="submit"]
${signup_error}           css= #signup_form .error
${userid_error}           css= .errormsg3
${password_error}         css= .errormsg