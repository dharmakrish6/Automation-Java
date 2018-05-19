*** Variables ***

#carousel indicators
${c_indicator_one}         xpath=  //html//section[@class='home_banner']//li[1]
${c_indicator_two}         xpath=  //html//section[@class='home_banner']//li[2]
${c_indicator_three}       xpath=  //html//section[@class='home_banner']//li[3]
${c_indicator_four}        xpath=  //html//section[@class='home_banner']//li[4]
${c_indicator_five}        xpath=  //html//section[@class='home_banner']//li[5]
${c_indicator_six}         xpath=  //html//section[@class='home_banner']//li[6]
${c_indicator_current}     xpath=  //div[@class='flickity-enabled is-draggable']//ol[@class='flickity-page-dots']//li[@class='dot is-selected']

#change content-language
${language_selector}      xpath=//html//div[@class='container-fluid main_container']/header[1]/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]
#xpath=  //*[@id=\"app\"]/div[1]/header[1]/div[2]/div[1]/div/div/button/span[2]/span
${language_tamil}         xpath=  html/body/div[2]/div[1]/header[1]/div[2]/div[1]/div/div/div/ul/li[1]/a
${language_telugu}        xpath=  html/body/div[2]/div[1]/header[1]/div[2]/div[1]/div/div/div/ul/li[2]/a/span[1]
${language_kannada}       xpath=  html/body/div[2]/div[1]/header[1]/div[2]/div[1]/div/div/div/ul/li[3]/a/span[1]
${language_malayalam}     xpath=  html/body/div[2]/div[1]/header[1]/div[2]/div[1]/div/div/div/ul/li[4]/a/span[1]

#links @ header
${movies}                 /movie/
${tvshows}                /tv/
${livetv}                 /live/
${home}                   xpath=  //*[@id=\"app\"]/div[1]/header[1]/nav/div/div[1]/div/a
${music videos}                  /music/
${comedy}                 /comedy/
${news}                   /news/

#profile dropdown
${profile_icon}           xpath=  //li[@id='showuser_profile']
${profile_profile}        xpath=  html/body/div[2]/div[1]/header[1]/div[2]/div[2]/ul/li[2]/ul/li[1]/a
${profile_switchprofile}  xpath=  html/body/div[2]/div[1]/header[1]/div[2]/div[2]/ul/li[2]/ul/li[2]/a
${profile_feedback}       xpath=  html/body/div[2]/div[1]/header[1]/div[2]/div[2]/ul/li[2]/ul/li[3]/a
${feedback_cancel}        xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[10]/div/div/div/div[1]/a/img
${profile_device}         xpath=  html/body/div[2]/div[1]/header[1]/div[2]/div[2]/ul/li[2]/ul/li[4]/a
${profile_subscription}   xpath=  html/body/div[2]/div[1]/header[1]/div[2]/div[2]/ul/li[2]/ul/li[5]/a
${profile_applycoupon}    xpath=  html/body/div[2]/div[1]/header[1]/div[2]/div[2]/ul/li[2]/ul/li[6]/a
${profile_logout}         xpath=  html/body/div[2]/div[1]/header[1]/div[2]/div[2]/ul/li[2]/ul/li[7]/a

#search content
${search_icon}            css=a.call_search_update
${search_field}           css=#mainSearch

#links @ footer
${footer_home}            xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[1]/a
${footer_movies}          xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[2]/a
${footer_tvshows}         xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[3]/a
${footer_news}            xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[4]/a
${footer_comedy}          xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[5]/a
${footer_music}           xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[6]/a
${footer_live}            xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[7]/a
${footer_channels}        xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[8]/a
${footer_aboutus}         xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[9]/a
${footer_feedback}        xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[10]/a
${footer_faqs}            xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[11]/a
${footer_privacypolicy}   xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[12]/a
${footer_termsofuse}      xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[13]/a
${footer_cookiepolicies}  xpath=  html/body/div[2]/div[1]/footer/div[1]/ul/li[14]/a