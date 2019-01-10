*** Variables ***

#player frame
${btn_play}                     id=com.suntv.sunnxt:id/playButton
${player_frame}                 id=com.suntv.sunnxt:id/cardmediasubitemvideo_exovideopreview
#id=com.suntv.sunnxt:id/media_controller_controls_root
${content_title}                xpath=//android.widget.TextView[@index='1']
#xpath=/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView
${loading_animation}            id=com.suntv.sunnxt:id/cardmediasubitemvideo_progressbar
#/hierarchy
#playback controls
${btn_back}                     xpath=//android.widget.ImageButton[@index='4']
${btn_play_pause}               id=com.suntv.sunnxt:id/playpause_btn
${btn_seek_left}                id=com.suntv.sunnxt:id/seekLeftText
${btn_seek_right}               id=com.suntv.sunnxt:id/seekRightImage
${seek_bar}                     id=com.suntv.sunnxt:id/exo_progress
${btn_subtitle}                 id=com.suntv.sunnxt:id/sub_titles
${btn_gear}                     id=com.suntv.sunnxt:id/video_settings
${btn_fullscreen}               id=com.suntv.sunnxt:id/playerfullscreenimage
${total time}                   id=com.suntv.sunnxt:id/playertotaltime
${elapsed_time}                 id=com.suntv.sunnxt:id/playerexpiredtime


#quality
${quality_options}              id=com.suntv.sunnxt:id/quality_selection_grid
${auto}                         AUTO
${low}                          LOW
${medium}                       MEDIUM
${hd}                           HD

#AD
${btn_visitAdvertiser}         Visit Advertiser