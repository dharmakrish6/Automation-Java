*** Variables ***
${profile_username}     xpath=/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/h2[1]
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