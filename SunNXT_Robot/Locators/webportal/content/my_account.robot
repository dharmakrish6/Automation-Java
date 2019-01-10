*** Variables ***
${asset_my_account}         My Account

${my_content_history}       css= .accordionmenu .panel_accr:nth-of-type(1) [data-toggle]
#content name locators
${content_streamed#1}       css= .table-content tr:nth-of-type(1) td:nth-of-type(2)
${content_streamed#2}       css= .table-content tr:nth-of-type(2) td:nth-of-type(2)
${content_streamed#3}       css= .table-content tr:nth-of-type(3) td:nth-of-type(2)
${content_streamed#4}       css= .table-content tr:nth-of-type(4) td:nth-of-type(2)
${content_streamed#5}       css= .table-content tr:nth-of-type(5) td:nth-of-type(2)
${content_streamed#6}       css= .table-content tr:nth-of-type(6) td:nth-of-type(2)
${content_streamed#7}       css= .table-content tr:nth-of-type(7) td:nth-of-type(2)
${content_streamed#8}       css= .table-content tr:nth-of-type(8) td:nth-of-type(2)
${content_streamed#9}       css= .table-content tr:nth-of-type(9) td:nth-of-type(2)
${content_streamed#10}      css= .table-content tr:nth-of-type(10) td:nth-of-type(2)
#content streamed time
${content_time#1}           css= tr:nth-of-type(1) td:nth-of-type(3)
${content_time#2}           css= tr:nth-of-type(2) td:nth-of-type(3)
${content_time#3}           css= tr:nth-of-type(3) td:nth-of-type(3)
${content_time#4}           css= tr:nth-of-type(4) td:nth-of-type(3)
${content_time#5}           css= tr:nth-of-type(5) td:nth-of-type(3)
${content_time#6}           css= tr:nth-of-type(6) td:nth-of-type(3)
${content_time#7}           css= tr:nth-of-type(7) td:nth-of-type(3)
${content_time#8}           css= tr:nth-of-type(8) td:nth-of-type(3)
${content_time#9}           css= tr:nth-of-type(9) td:nth-of-type(3)
${content_time#10}          css= tr:nth-of-type(10) td:nth-of-type(3)

${my_info}                  css= .accordionmenu .panel_accr:nth-of-type(2) [data-toggle]
#information of profile
${mi_name}                  css= .myinfo .user_info:nth-of-type(1) b
${mi_email}                 css= .myinfo .user_info:nth-of-type(2) b
${mi_mob_num}               css= .myinfo .user_info:nth-of-type(3) b
${mi_country}               css= .myinfo .user_info:nth-of-type(4) b
${mi_state}                 css= .myinfo .user_info:nth-of-type(5) b
${mi_age}                   css= .myinfo .user_info:nth-of-type(6) b
${mi_gender}                css= .myinfo .user_info:nth-of-type(7) b
${mi_login_method}          css= .myinfo .user_info:nth-of-type(8) b


${my_subscriptions}         css= .accordionmenu .panel_accr:nth-of-type(3) [data-toggle]
#subscription info
${package_type}             css= .accordionmenu .panel_accr:nth-of-type(3) tr:nth-of-type(1) th:nth-of-type(1)
${package_name}             css= .accordionmenu .panel_accr:nth-of-type(3) tr:nth-of-type(2) td:nth-of-type(2)
${expiry_date}              css= .accordionmenu .panel_accr:nth-of-type(3) tr:nth-of-type(3) td:nth-of-type(2)
${cost}                     css= .accordionmenu .panel_accr:nth-of-type(3) tr:nth-of-type(4) td:nth-of-type(2)

${clear_watch_history}      css= .accordionmenu .panel_accr:nth-of-type(4) > [data-toggle]
#proceed with clear watch
${done_clear_watch}         css= #success-btn
${cancel_clear_watch}       css= .modal-footer [type]