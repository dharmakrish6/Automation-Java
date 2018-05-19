*** Variables ***

#cast content
${chromecast_disconnected}      xpath=//android.view.View[@content-desc='Cast button. Disconnected']
${chromecast_connected}         xpath=//android.view.View[@content-desc='Cast button. Connected']
${casting_device_list}          Cast to
${cast_dialog}                  Want to Cast
${cast_to_device}               xpath=//android.widget.Button[@text='Cast']
${play_in_device}               Play Local
${cancel_cast}                  Cancel

#receiver cast screen
${play_pause_btn}               id=com.suntv.sunnxt:id/play_pause_toggle
${next_content}                 id=com.suntv.sunnxt:id/next
${previous_content}             id=com.suntv.sunnxt:id/previous
${toggle_subtitle}              id=com.suntv.sunnxt:id/cc