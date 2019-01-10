*** Variables ***

${play_redbutton}          xpath=//button[contains(text(),'Play')]
${share_button}            xpath=//div[@class='share-text'][contains(text(),'Share')]
${favourite_button}        xpath=//div[@class='share-text'][contains(text(),'Favourite')]
${pause_redbutton}         xpath=//*[@id="app"]/div[1]/section[1]/div[2]/div[2]/div/div/div[4]/button
${content_streamed}        css: #banner-player-title

#video details locators
${vod_name}                css: .container-fluid [itemprop="name"]

${vod_details#1}                  css: .movie_details-div ul li:nth-of-type(1)
#   vod_#1   - year for Movie
#            - language for TV Show
#            -

${vod_details#2}                  css: .movie_details-div ul li:nth-of-type(2)
#   vod #2   - language for movie
#            - type of show for TV Show
#            - language for music video
#            - language for comedy

${vod_details#3}                   css: .movie_details-div ul li:nth-of-type(3)
#   vod #3   - genre for movie
#            - genre for music video
#            - genre for comedy

${vod_details#4}                   css: .movie_details-div ul li:nth-of-type(4)
#   vod #4   - content quality for movie

${livetv_streamingnow}            css: [class="col-md-12 intro"] h2

${favorite_message}         css: .mini-toastr__notification

#ratings
${rating#1}                xpath=//html//section[@class='rating_form']//span[@style='cursor: default;']/div[1]
${rating#2}                xpath=//html//section[@class='rating_form']//span[@style='cursor: default;']/div[2]
${rating#3}                xpath=//html//section[@class='rating_form']//div[3]
${rating#4}                xpath=//html//section[@class='rating_form']//div[4]
${rating#5}                xpath=//html//section[@class='rating_form']//div[5]

${submit_button}           xpath=//button[@class='btn']