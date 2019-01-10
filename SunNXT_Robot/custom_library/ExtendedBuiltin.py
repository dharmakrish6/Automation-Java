from robot.api.deco import keyword


class ExtendedBuiltin(object):
    _author_ = "Ameet Kumar Pradhan"
    _copyright_ = "Copyright (C) 2018 Ameet Kumar Pradhan"
    _version_ = 0.1
    ROBOT_EXIT_ON_FAILURE = True

    @keyword
    def should_be_an_integer(self, variable):
        if int(variable) == variable:
            message = 'Variable ' + variable + ' is an integer'
            return message
