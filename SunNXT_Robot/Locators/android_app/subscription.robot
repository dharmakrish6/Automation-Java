*** Variables ***

#subscription plans popup
${subs_popup-monthly}           50.0
#//android.widget.TextView[@text='50.0']
${subs_popup-quarterly}         130.0
#//android.widget.TextView[@text='130.0']
${subs_popup-annual}            480.0
#//android.widget.TextView[@text='480.0']
${subs_popup-coupon_code}       Enter code
#//android.widget.TextView[@text='Enter code']

#payment modes
${available_payment_modes}      recycleListPaymentMode
#id: recycleListPaymentMode
${credit_card}                  Credit Card
${debit_card}                   Debit Card
${paytm}                        Paytm
${coupon_code}                  Enter Coupon Code
${proceed_subs}                 Proceed To Pay

#card payment
${card_num}                     xpath=//android.widget.EditText[contains(@resource-id, 'frm_cc_num')]
${card_name}                    xpath=//android.widget.EditText[contains(@resource-id, 'frm_cc_name')]
${month}                        SELECT MONTH  
${year}                         SELECT YEAR  
${cvv}                          xpath=//android.widget.EditText[contains(@resource-id, 'frm_cc_cvv')]
${checkbox}                     id=checkbox5
${cc_pay}                       Pay Now

#exclusive for debit card
${dc_cardtype}                  SELECT DEBIT CARD TYPE