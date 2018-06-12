*** Variables ***

#carousel indicators - home banner
${hb_indicator_one}         css: .home_banner .flickity-page-dots .dot:nth-of-type(1)
${hb_indicator_two}         css: .home_banner .flickity-page-dots .dot:nth-of-type(2)
${hb_indicator_three}       css: .home_banner .flickity-page-dots .dot:nth-of-type(3)
${hb_indicator_four}        css: .home_banner .flickity-page-dots .dot:nth-of-type(4)
${hb_indicator_five}        css: .home_banner .flickity-page-dots .dot:nth-of-type(5)
${hb_indicator_six}         css: .home_banner .flickity-page-dots .dot:nth-of-type(6)
${hb_indicator_current}     css: .home_banner li.dot.is-selected

#change content-language
${language_selector}        css: span.bs-caret

#available content-language
${language_tamil}           Tamil
${language_telugu}          Telugu
${language_kannada}         Kannada
${language_malayalam}       Malayalam

#links @ header
${movies}                 /movie/
${tvshows}                /tv/
${livetv}                 /live/
${home}                   css:
${music videos}           /music/
${comedy}                 /comedy/
${news}                   /news/

#profile dropdown
${profile_icon}           css: #showuser_profile .icon-icn_profile
${profile-profile}        Profile
${profile-my_account}     My Account
${profile-switchprofile}  Switch Profile
${profile-feedback}       Feedback
${feedback-cancel}        css: [src="\/images\/close_icon_white\.png"]
${profile-device}         Devices
${profile-subscription}   Subscriptions
${profile-applycoupon}    Apply Coupon
${profile-logout}         Logout

#search content
${search_icon}            css= a.call_search_update
${search_field}           css= #mainSearch

#links in footer (links having common text has css selector)
${footer_home}            home
${footer_movies}          css: .footer [href="\/movie\/"]
${footer_tvshows}         css: .footer [href="\/tv\/"]
${footer_news}            css: [href="\/exclusives\/"]  #should be news and not exclusives
${footer_comedy}          css: [href="\/comedy"]
${footer_music}           css: .footer [href="\/music\/"]
${footer_live}            css: .footer [href="\/live\/"]
${footer_channels}        channels
${footer_aboutus}         about us
${footer_feedback}        Feedback
${footer_faqs}            faq’s
${footer_privacypolicy}   privacy policy
${footer_termsofuse}      Terms of Use
${footer_cookiepolicies}  Cookie Policies