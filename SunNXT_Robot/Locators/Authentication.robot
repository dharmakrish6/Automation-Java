*** Variables ***
${profile_auth}           xpath=//*[@id=\"show_sign\"]/a/span
${signin_link}            Sign In

#signin popup
${user_name}              id=email-up
${password}               id=password
${login_button}           css=button.btn.btn-red

#signup popup
${signup_link}            xpath=//form[@role='form']//p[@class='already_memb']//a
${signup_user}            id=email-in
${signup_password}        id=password1
${signup_name}            xpath=//*[@id="first"]
${signup_age}             xpath=//*[@id="signup_form"]/form/div[4]/div[1]/button/span[2]/span
${signup_18-25}           link=18-25 Years
${signup_male}            xpath=//*[@id="signup_form"]/form/div[5]/div[1]/label/span/span[1]
${signup_female}          xpath=//*[@id="signup_form"]/form/div[5]/div[2]/label/span/span[1]
${signup_country}         xpath=//div[@id='signup_form']/form/div[6]/div[1]/div[1]/div/i
${signup_country-IN}      link=India
${signup_state}           xpath=//*[@id="signup_form"]/form/div[6]/div[2]/div/div/i
${signup_state-AP}        link=Andhra Pradesh
${agree_checkbox}         xpath=//label[@for='term1']
${submit_button}          xpath=//*[@id="signup_form"]/form/div[8]/button
${signup_error}           xpath=/html[1]/body[1]/div[2]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/span[1]