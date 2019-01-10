import threading
from ctypes import windll

import cv2
import numpy
from PIL import ImageGrab
from robot.api.deco import keyword

# fix for fullscreen image capture in windows
user32 = windll.user32
user32.SetProcessDPIAware()

screen = ImageGrab.grab()
size = screen.size
codec = cv2.VideoWriter_fourcc('D', 'I', 'V', 'X')
out = cv2.VideoWriter('video.avi', codec, 9.85, size)


class ScreenRecorder:

    def screen_capture(self):
        while True:
            cap_frame = ImageGrab.grab()
            continuous_grab = numpy.array(cap_frame)

            frame = cv2.cvtColor(continuous_grab, cv2.COLOR_BGR2RGB)

            out.write(frame)

    @keyword
    def start_recording(self):
        global video
        video = threading.Thread(target=self.screen_capture)
        video.daemon = True
        print(threading.enumerate())
        video.start()
        print(threading.enumerate())

    @keyword
    def stop_screen_capture(self):
        out.release()
        video.join()
