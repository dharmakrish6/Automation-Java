*** Variables ***

${play_redbutton}          xpath=//button[@type='button'][contains(text(),'Play')]
${share_button}            xpath=//div[@class='share-text'][contains(text(),'Share')]
${favourite_button}        xpath=//div[@class='share-text'][contains(text(),'Favourite')]
${pause_redbutton}         xpath=//*[@id="app"]/div[1]/section[1]/div[2]/div[2]/div/div/div[4]/button

#video details locators
${vod_name}                xpath=//h2[@id='banner-player-title']

${vod_#1}                  xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]
#   vod_#1   - year for Movie
#            - language for TV Show
#            -

${vod_#2}                  xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]
#   vod #2   - language for movie
#            - type of show for TV Show
#            - language for music video
#            - language for comedy

${vod_#3}                   xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]
#   vod #3   - genre for movie
#            - genre for music video
#            - genre for comedy

${vod_#4}                   xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[2]/li[1]
#   vod #4   - type of content for TV Show

${vod_#5}                   xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]
#   vod #5   - content quality in movies

${liveTV_streamingnow}      xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[2]/div[3]/div[1]/h2[1]

${favorite_message}         xpath=//div[@class='mini-toastr-notification__message']

#ratings
${rating#1}                xpath=//html//section[@class='rating_form']//span[@style='cursor: default;']/div[1]
${rating#2}                xpath=//html//section[@class='rating_form']//span[@style='cursor: default;']/div[2]
${rating#3}                xpath=//html//section[@class='rating_form']//div[3]
${rating#4}                xpath=//html//section[@class='rating_form']//div[4]
${rating#5}                xpath=//html//section[@class='rating_form']//div[5]

${submit_button}           xpath=//button[@class='btn']