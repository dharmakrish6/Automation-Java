*** Variables ***
${subscription_popup}       xpath=//div[@id='subsribe-modal']//div[@class='modal-dialog']//div[@class='modal-content']//div[@class='modal-body']

#Subscription Page
${Monthly_subsplan}         xpath=/html[1]/body[1]/div[2]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/a[1]
${Quarterly_subsplan}   `   xpath=//*[@id="app"]/div[1]/div[2]/section/div/div/div/ul/li[2]/div/a
${Annual_subsplan}          xpath=/html[1]/body[1]/div[2]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/a[1]

#Payment Mode
${CreditCard}               xpath=/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/section[1]/ul[1]/li[1]/a[1]
${DebitCard}                xpath=/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/section[1]/ul[1]/li[2]/a[1]
${CouponCode}               xpath=/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[4]/h3[1]/a[1]

#Enter Debit Card Details
${DC_CardType}              xpath=//html//form[@id='payment_cc_form']/div[@class='form-group']//button[1]
${VISA}                     xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]
${MASTER}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]
${MAESTRO}                  xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]
${RUPAY}                    xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]

${CardNum}               xpath=//input[@id='frm_cc_num']
${CardName}              xpath=//input[@id='frm_cc_name']

${DC_Month}             xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/button[1]
${01}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]
${02}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]
${03}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]
${04}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]
${05}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[6]/a[1]/span[1]
${06}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[7]/a[1]/span[1]
${07}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[8]/a[1]/span[1]
${08}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[9]/a[1]/span[1]
${09}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[10]/a[1]/span[1]
${10}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[11]/a[1]/span[1]
${11}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[12]/a[1]/span[1]
${12}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[13]/a[1]/span[1]

${DC_year}                  xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/button[1]
${2018}                 xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]
${2019}                 xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]
${2020}                 xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]
${2021}                 xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]
${2022}                 xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[6]/a[1]/span[1]
${2023}                 xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[7]/a[1]/span[1]
${2024}                 xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[8]/a[1]/span[1]
${2025}                 xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[9]/a[1]/span[1]
${2068}                 xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[52]/a[1]/span[1]

${cvv}                  xpath=//*[@id="frm_cc_cvv"]
${DC_SaveCard}          xpath=//input[@id='checkbox5']

${DC_PayBtn}            xpath=//input[@id='frm_cc_pay_btn']


${CC_Month}              xpath=//span[@class='filter-option pull-left'][contains(text(),'Select Month')]
${10}                    xpath=/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[11]/a[1]

${CC_Year}               xpath=//span[@class='filter-option pull-left'][contains(text(),'Select Year')]
${2019}                  xpath=/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]

