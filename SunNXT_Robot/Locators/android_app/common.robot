*** Variables ***

#splash screen
${splash_screen}                    id=com.suntv.sunnxt:id/splashView
${loading_animation}                id=com.suntv.sunnxt:id/progressBar

#popup
${popup_list}                       xpath=//android.widget.FrameLayout[@index='0']

#crash
${crashlog_command}

#coach marks
${coach_mark}                       id=com.suntv.sunnxt:id/cartoon
${thanks_text}                      Thanks! Got It

#buttons
${button_livetv}                    id=com.suntv.sunnxt:id/live_tv
${button_profile}                   id=com.suntv.sunnxt:id/root
${button_search}                    id=com.suntv.sunnxt:id/action_search
${button_actionbar}                 id=com.suntv.sunnxt:id/action_settings

#title bar
${home}                             HOME
${movies}                           MOVIES
${tv_shows}                         TV SHOWS
${music_videos}                     MUSIC VIDEOS
${comedy}                           COMEDY

#alert dialog box
${alert_btn1}                       id=android:id/button1
${alert_btn2}                       id=android:id/button2
${alert_ok}                         id=com.suntv.sunnxt:id/ok_button
${alert_cancel}                     id=com.suntv.sunnxt:id/cancel_button

#action bar
${action_overflow}                  id=com.suntv.sunnxt:id/action_settings
${profile_button}                   id=com.suntv.sunnxt:id/root1
${live_tv}                          id=com.suntv.sunnxt:id/live_tv
${search_icon}                      id=com.suntv.sunnxt:id/action_search

#action bar pop-up
${change_content_language}          Change content language
${change_app_language}              Change app language
${geo_location_toggle}              id=com.suntv.sunnxt:id/geo_switch
${privacy_policy}                   Privacy Policy
${my_account}                       My Account
${settings}                         id=com.suntv.sunnxt:id/settings

#change content language
${cl_tamil}                         Tamil
${cl_telugu}                        Telugu
${cl_malayalam}                     Malayalam
${cl_kannada}                       Kannada

#page loaded validation
${page_loaded}              class=android.widget.TextView
#id=com.suntv.sunnxt:id/textview_genre_title

#change content language buttons
${btn_save}         id=com.suntv.sunnxt:id/save_button
${btn_cancel}       id=com.suntv.sunnxt:id/cancel_button

#loading green
${g_loading_popup}          id=android:id/body
${g_loading_animation}      id=android:id/progress
${g_loading_message}        id=	android:id/message

#crash messages
${crash_pop_up#1}           xpath=//android.widget.TextView[@text='Unfortunately, Sun NXT has stopped.']
${crash_pop_up#2}           xpath=//android.widget.TextView[@text='Sun NXT has stopped']