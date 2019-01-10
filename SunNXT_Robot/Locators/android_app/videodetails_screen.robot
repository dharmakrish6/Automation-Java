*** Variables ***

${btn_play}                     id=com.suntv.sunnxt:id/playButton
${btn_download}                 id=com.suntv.sunnxt:id/download

#download options
${download_popup}               xpath=/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout
${download-data_saver}          id=com.suntv.sunnxt:id/data_saver_button
${download-good}                id=com.suntv.sunnxt:id/good_button
${download-best}                id=com.suntv.sunnxt:id/best_button
${download-hd}                  id=com.suntv.sunnxt:id/hd_button

#content operation
${content_thumbnail}            id=com.suntv.sunnxt:id/controller_view
${content_info}                 id=com.suntv.sunnxt:id/briefInfoOfCategories
${btn_favourite}                id=com.suntv.sunnxt:id/fav_icon
${btn_share}                    id=com.suntv.sunnxt:id/share
${description}                  id=com.suntv.sunnxt:id/movieDescription
${star_cast}                    id=com.suntv.sunnxt:id/sub_text

#starcast
${assert_starcast}              PILLARS
${btn_starcast_fav}             id=com.suntv.sunnxt:id/like_button

#ratings(only for movies)
${edit_rating}                  id=com.suntv.sunnxt:id/editImage
