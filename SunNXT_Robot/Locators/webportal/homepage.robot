*** Variables ***

#carousel indicators - home banner
${hb_indicator_one}         css= .home_banner .flickity-page-dots .dot:nth-of-type(1)
${hb_indicator_two}         css= .home_banner .flickity-page-dots .dot:nth-of-type(2)
${hb_indicator_three}       css= .home_banner .flickity-page-dots .dot:nth-of-type(3)
${hb_indicator_four}        css= .home_banner .flickity-page-dots .dot:nth-of-type(4)
${hb_indicator_five}        css= .home_banner .flickity-page-dots .dot:nth-of-type(5)
${hb_indicator_six}         css= .home_banner .flickity-page-dots .dot:nth-of-type(6)
${hb_indicator_current}     css= .home_banner li.dot.is-selected

#change content-language
${language_selector}        css= [class='col-md-6 col-sm-6 top_search'] .filter-option
${language_dropdown}        css= [class='col-md-6 col-sm-6 top_search'] .inner
${lang2}                    css= [class='col-md-6 col-sm-6 top_search'] .filter-option

#available content-language
${language_tamil}           css= [class='col-md-6 col-sm-6 top_search'] [data-original-index='0'] .text
${language_telugu}          css= [class='col-md-6 col-sm-6 top_search'] [data-original-index='1'] .text
${language_kannada}         css= [class='col-md-6 col-sm-6 top_search'] [data-original-index='2'] .text
${language_malayalam}       css= [class='col-md-6 col-sm-6 top_search'] [data-original-index='3'] .text

#links @ header
${movies}                 /movie/
${tvshows}                /tv/
${livetv}                 /live/
${home}                   css=img.desk_on
${music_videos}           /music/
${comedy}                 /comedy/
${news}                   /news/

#continue watching
${title_continue_watching}      xpath= //div[@id='app']//section[@class='container_wrap']/section[@action='portalContinueWatching']//h2[@class='title']

#profile dropdown
${profile_icon}           css= #showuser_profile
${profile-profile}        Profile
${profile-my_account}     My Account
${profile-switchprofile}  Switch Profile
${profile-feedback}       Feedback
${feedback-cancel}        css= [src="\/images\/close_icon_white\.png"]
${profile-device}         Devices
${profile-subscription}   Subscriptions
${profile-applycoupon}    Apply Coupon
${profile-logout}         Logout

#search content
${search_icon}            css= a.call_search_update
${search_field}           css= #mainSearch

#links in footer (links having common text has css selector)
${footer_home}            home
${footer_movies}          css= .footer [href="\/movie\/"]
${footer_tvshows}         css= .footer [href="\/tv\/"]
${footer_news}            css= [href="\/exclusives\/"]  #should be news and not exclusives
${footer_comedy}          css= [href="\/comedy"]
${footer_music}           css= .footer [href="\/music\/"]
${footer_live}            css= .footer [href="\/live\/"]
${footer_channels}        channels
${footer_aboutus}         about us
${footer_feedback}        Feedback
${footer_faqs}            faq’s
${footer_privacypolicy}   privacy policy
${footer_termsofuse}      Terms of Use
${footer_cookiepolicies}  Cookie Policies