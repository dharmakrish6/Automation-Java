*** Variables ***
${subscription_popup}       xpath=//div[@id='subsribe-modal']//div[@class='modal-dialog']//div[@class='modal-content']//div[@class='modal-body']
${sundirect_message}        xpath=//button[@type='button'][contains(text(),'OK')]

${popup_annual}             xpath=//*[@id="subsribe-modal"]/div/div/div/div/div/ul/li[3]/div/a[2]

#Subscription Page
${monthly_subsplan}         xpath=/html[1]/body[1]/div[2]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/a[1]
${quarterly_subsplan}   `   xpath=//*[@id="app"]/div[1]/div[2]/section/div/div/div/ul/li[2]/div/a
${annual_subsplan}          xpath=/html[1]/body[1]/div[2]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/a[1]

#Payment Mode
${credit_card}               xpath=/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/section[1]/ul[1]/li[1]/a[1]
${debit_card}                xpath=/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/section[1]/ul[1]/li[2]/a[1]
${coupon_code}               xpath=/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[4]/h3[1]/a[1]

#Enter Debit Card Details
${dc_cardtype}              xpath=//html//form[@id='payment_cc_form']/div[@class='form-group']//button[1]
${visa}                     xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]
${master}                   xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]
${maestro}                  xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]
${rupay}                    xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]

${card_num}               xpath=//input[@id='frm_cc_num']
${card_name}              xpath=//input[@id='frm_cc_name']

${dc_month}             xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/button[1]
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

${dc_year}                  xpath=/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/button[1]
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
${dc_save_card}          xpath=//input[@id='checkbox5']

${dc_pay_btn}            xpath=//input[@id='frm_cc_pay_btn']


${cc_month}              xpath=//span[@class='filter-option pull-left'][contains(text(),'Select Month')]
${10}                    xpath=/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[11]/a[1]

${cc_year}               xpath=//span[@class='filter-option pull-left'][contains(text(),'Select Year')]
${2019}                  xpath=/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]

${no_active_plan}         css=[class="col-md-12 subscribe_wrap"] > p:nth-child(2)