*** Variables ***

#player frame
${player_frame}                 id=com.suntv.sunnxt:id/cardmediasubitemvideo_exovideopreview
${content_title}                xpath=//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.widget.TextView
${loading_animation}            id=com.suntv.sunnxt:id/cardmediasubitemvideo_progressbar

#playback controls
${btn_back}                     class=android.widget.ImageButton
${btn_play_pause}               id=com.suntv.sunnxt:id/playpause_btn
${btn_seek_left}                id=com.suntv.sunnxt:id/seekLeftText
${btn_seek_right}               id=com.suntv.sunnxt:id/seekRightImage
${seek_bar}                     id=com.suntv.sunnxt:id/mediacontroller_progress
${btn_subtitle}                 id=com.suntv.sunnxt:id/sub_titles
${btn_gear}                     id=com.suntv.sunnxt:id/video_settings
${btn_fullscreen}               id=com.suntv.sunnxt:id/playerfullscreenimage
${total time}                   id=com.suntv.sunnxt:id/playertotaltime
${elapsed_time}                 id=com.suntv.sunnxt:id/playerexpiredtime
${seek_bar}                     id=com.suntv.sunnxt:id/mediacontroller_progress

#quality
${auto}                         AUTO
${low}                          LOW
${medium}                       MEDIUM
${hd}                           HD

#AD
${btn_visitAdvertiser}         Visit Advertiser