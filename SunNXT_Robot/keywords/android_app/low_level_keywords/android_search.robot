*** Settings ***
Resource            ../locators/android_app/search.robot
*** Keywords ***
Enter Search Query
    [Arguments]  ${content_name}
    wait until page contains element  ${search_query}
    input text  ${search_query}  ${content_name}
    hide keyboard

Choose Search Content Type
    [Arguments]  ${content_type}
    run keyword if  "${content_type}"=="ALL"  click text  ${search_all}
    run keyword if  "${content_type}"=="MOVIES"  click text  ${search_movies}
    run keyword if  "${content_type}"=="TV SHOWS"  click text  ${search_tvshows}
    run keyword if  "${content_type}"=="MUSIC"  click text  ${search_musicvideos}
    run keyword if  "${content_type}"=="COMEDY"  click text  ${search_comedy}

Validate Search
    [Arguments]  ${content_name}  ${content_type}
    page should contain element  xpath=//android.widget.TextView[@text='${content_name}']
    page should contain element   xpath=//android.widget.TextView@text='${content_type}']

