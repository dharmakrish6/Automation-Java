import pytesseract
from PIL import Image
from robot.api.deco import keyword


class OCRLibrary:
    _author_ = "Ameet Kumar Pradhan"
    _copyright_ = "Copyright (C) 2018 Ameet Kumar Pradhan"
    _version_ = 0.2
    ROBOT_EXIT_ON_FAILURE = True

    @keyword
    def image_should_contain_text(self, path_to_image_file, language, verifiable_text):
        image_file = Image.open(path_to_image_file)
        converted_text = pytesseract.image_to_string(image_file, lang=language)
        if verifiable_text in converted_text:
            print('Text ' + verifiable_text + ' is present in the screen')
