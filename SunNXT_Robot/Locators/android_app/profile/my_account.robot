*** Variables ***
${my_content_history}           css: .accordionmenu .panel_accr:nth-of-type(1) [data-toggle]

#my info accordion
${my_info}                      css: .accordionmenu .panel_accr:nth-of-type(2) [data-toggle]
${mi_name}                      css: .myinfo .user_info:nth-of-type(1) b
${mi_email}                     css: .myinfo .user_info:nth-of-type(2) b
${mi_mob}                       css: .myinfo .user_info:nth-of-type(3) b
${mi_country}                   css: .myinfo .user_info:nth-of-type(4) b
${mi_state}                     css: .myinfo .user_info:nth-of-type(5) b
${mi_age}                       css: .myinfo .user_info:nth-of-type(6) b
${mi_gender}                    css: .myinfo .user_info:nth-of-type(7) b
${mi_login_method}              css: .myinfo .user_info:nth-of-type(8) b

#devices in my info
${device#1-dev_num}             css: .table-bordered tr td:nth-of-type(1)
${device#1-dev_manufacturer+os}  css: .table-bordered tr td:nth-of-type(2)
${device#1-dev_model}           css: .table-bordered tr td:nth-of-type(3)


${my_subscriptions}             css: .accordionmenu .panel_accr:nth-of-type(3) [data-toggle]

#clear watch history
${clear_my_watch_history}       css: .accordionmenu .panel_accr:nth-of-type(4) > [data-toggle]
${btn-clear_watch_history}      id: success-btn
${btn-cancel_clear_history}     css: .modal-footer [type]