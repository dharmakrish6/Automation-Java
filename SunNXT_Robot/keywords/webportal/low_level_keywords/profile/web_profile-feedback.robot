*** Settings ***
Documentation    Suite description
Resource            locators/webportal/profile/feedback.robot

*** Keywords ***
Enter Feedback
    wait until page contains element  ${feedback_popup}  timeout=${extended_wait}
    input text  ${feedback_text_box}  THIS IS A TEST FEEDBACK. PLEASE IGNORE IT.

Submit Feedback
    click element  ${submit_feedback}


Check If Feedback Is Submitted Or Not
    ${status}=  run keyword and return status  Check For Success Message
    run keyword if  "${status}"=="True"  Dismiss Feedback Popup
    ...  ELSE  Check For Error Message

Check For Success Message
    wait until page contains element  ${feedback_success}
    element should be visible  ${feedback_success}

Check For Error Message
    wait until page contains element  ${feedback_submit_error}
    ${status}=  run keyword and return status  element should be visible  ${feedback_submit_error}
    run keyword if  "${status}"=="True"  fail  FEEDBACK IS NOT SUBMITTED

Dismiss Feedback Popup
    click element  ${feedback_dismiss}
    pass execution