---Pre-requisites----

* install android sdk (only sdk is enough) and open sdk manager and download tools, platform-tools, build tools & google usb driver
* install testNG, android developer tools (by google inc) and maven plugins in eclipse
* import the project in eclipse as General->existing project or Maven->existing project
  and wait for dependencies to download(jars if it doesn't already exists)
* [install appium in D: or any driver other than C:]   or   [copy installed appium folder to any driver other than C:]
* give the appium path in config.properties file present in the project folder
* give the app package and app activity in config.properties file


---project folder structure----

* src/test/java contains all the test related codes
* pages, testCases and utilities are the packages under src/test/java
* pages contains all the page objects of app screens and also the methods related to the objects on respective screens
* testCases contains all the test scripts which calls the methods written in respective pages
* utilities contains appiumServerUtils(to start and start appium), TestNGEventHandler(testNG listener) & ReporterUtils(custom report if required)