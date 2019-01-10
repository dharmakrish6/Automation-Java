import platform

from robot.api.deco import keyword


class SystemInformation:
    _author_ = "Ameet Kumar Pradhan"
    _copyright_ = "Copyright (C) 2018 Ameet Kumar Pradhan"
    _version_ = 0.1
    ROBOT_EXIT_ON_FAILURE = True

    @keyword
    def get_platform_name(self):
        platform_name = platform.system()
        return platform_name

    @keyword
    def get_platform_version(self):
        platform_version = platform.version()
        return platform_version

    @keyword
    def get_platform_architecture(self):
        platform_architecture = platform.architecture()
        return platform_architecture

    @keyword
    def get_processor_info(self):
        processor_info = platform.processor()
        return processor_info