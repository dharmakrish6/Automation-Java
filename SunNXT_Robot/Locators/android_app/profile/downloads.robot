*** Variables ***

${downloading_content}          xpath=//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[1]
${download_percent}             id=com.suntv.sunnxt:id/download_percentage
${cancel_downloading}           Cancel Download

${download_play/pause}          id=com.suntv.sunnxt:id/download_pause_play
${delete_downloaded_content}    id=com.suntv.sunnxt:id/deleteIcon