*** Variables ***
${view_all-movies}          /movie/inside/
${view_all-tv_shows}        /tv/inside/
${view_all_music_videos}    /music/inside/

#filter
${filter#1}                 css= .list-filter li:nth-of-type(1) > [type]
${btn_filter#1}             css= .list-filter li:nth-of-type(1) [disabled] [type='button']:nth-of-type(2)

${filter#2}                 css= .list-filter li:nth-of-type(2) > [type]
${btn_filter#2}             css= .list-filter li:nth-of-type(2) [disabled] [type='button']:nth-of-type(2)