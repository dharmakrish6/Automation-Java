*** Variables ***
#sun-direct pop-up
${sundirect_message}        css= #sampleModel .modal-content
${popup_ok}                 css= #sampleModel .modal-footer [type]
${subscription_popup}       css=#subsribe-modal .modal-body

#subscription plans pop-up
${popup_monthly}            css= div#subsribe-modal li:nth-child(1) > div > a:nth-child(2)
${popup_quarterly}          css= div#subsribe-modal li:nth-child(   2) > div > a:nth-child(2)
${popup_annual}             css= div#subsribe-modal li:nth-child(3) > div > a:nth-child(2)

#payment modes
${available payment_modes}  class: card_tab_form
${credit_card}              css= .card_tab #btnCreditCard:nth-of-type(1) .btn
${debit_card}               css= .card_tab #btnCreditCard:nth-of-type(2) .btn
${paytm}                    css= .card_tab #btnCreditCard:nth-of-type(3) .btn
${coupon_code}              Click Here

#page load
${loading_subscription}     id=loading

#card payment
${card_num}                 id= frm_cc_num
${card_name}                id= frm_cc_name
${month}                    css= form#payment_cc_form div:nth-child(1) > div > button[type="button"]
${month_pop-up}             css= .form-horizontal [class=' col-xs-6 ']:nth-of-type(1) div:nth-child(2) div
${year_pop-up}              css= .form-horizontal [class=' col-xs-6 ']:nth-of-type(2) div:nth-child(2) div
${year}                     css= form#payment_cc_form div > div:nth-child(2) > div > button[type="button"] > span.filter-option.pull-left
${cvv}                      id= frm_cc_cvv
${checkbox}                 id= checkbox5
${cc_pay}                   id= frm_cc_pay_btn

#exclusive for debit card
${dc_cardtype}              css= .form-horizontal .form-group:nth-child(2) [type]
${dc_cardtype_dropdown}     css= .form-horizontal .form-group:nth-child(2) .inner

#paytm
${mob&otp}                  id= mobile
${btn_login}                css= button.btn-primary-new

#paytm subscription
${p_available_balance}      css= span#balance-used

#paytm payment modes
${p_debit_card}             link: #dc-card
${p_credit_card}            link: #cc-card
${p_net_banking}            link: #nb-card
${p_bhim_upi}               link: #upi-mode

#paytm card payment
${p_month}                  id= dcExpMonth
${p_year}                   id= dcExpYear
${p_cvv}                    id= dcCvvBox
${p_checkbox}               class: tick cb-icon-check
${p_cancel_pay}             class: cancel

#paytm debit card
${p_card_num}               id= cn1
${p_dc_pay}                 id= dcSubmit

#paytm credit card
${p_card_num}               id= cn
${p_cc_pay}                 id= ccSubmit

#paytm net banking
${p_select_bank}            id= nbSelect
${p_nb_pay}                 id= nbSubmit

#paytm vpa
${p_upi_id}                 name: vpaID
${p_upi_pay}                id= upiSubmit

#Subscription Page
${monthly_subsplan}         xpath=/html[1]/body[1]/div[2]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/a[1]
${quarterly_subsplan}   `   xpath=//*[@id="app"]/div[1]/div[2]/section/div/div/div/ul/li[2]/div/a
${annual_subsplan}          xpath=/html[1]/body[1]/div[2]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/a[1]

#plan
${no_active_plan}         css=[class="col-md-12 subscribe_wrap"] > p:nth-child(2)