*** Variables ***
#carousel
${carousel_one}           xpath=  /html[1]/body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]
${carousel_two}           xpath=  /html[1]/body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[2]/a[1]/div[1]/div[1]
${carousel_three}         xpath=  /html[1]/body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[3]/a[1]/div[1]/div[1]
${carousel_four}          xpath=  /html[1]/body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[4]/a[1]/div[1]/div[1]
${carousel_five}          xpath=  /html[1]/body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[5]/a[1]/div[1]/div[1]
${carousel_six}           xpath=  /html[1]/body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[6]/a[1]/div[1]/div[1]

#content row 0
${#0_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[2]/div/h2/a
${#0_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[2]/div/div[2]/div[1]/a/h2
${#0_Content2}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[2]/div[1]/div[2]/div[2]/a[1]/h2[1]
${#0_Content3}       xpath=  //*[@id="app"]/div[1]/section/section[2]/div/div[2]/div[3]/a/h2
${#0_Content4}       xpath=  //*[@id="app"]/div[1]/section/section[2]/div/div[2]/div[4]/a/h2
${#0_Content5}       xpath=  //*[@id="app"]/div[1]/section/section[2]/div/div[2]/div[5]/a/h2
${#0_Content6}       xpath=  //*[@id="app"]/div[1]/section/section[2]/div/div[2]/div[6]/a/h2
${#0_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[2]/div/h2/a/span

#Discover
${D_Romance}         xpath=  //*[@id="app"]/div[1]/section/section[3]/div/div/div/div[1]/div[1]/div[1]/a
${D_Action}          xpath=  //*[@id="app"]/div[1]/section/section[3]/div/div/div/div[1]/div[1]/div[2]/a
${D_FamilyDrama}     xpath=  //*[@id="app"]/div[1]/section/section[3]/div/div/div/div[1]/div[1]/div[3]/a
${D_MusicVideos}     xpath=  //*[@id="app"]/div[1]/section/section[3]/div/div/div/div[1]/div[1]/div[4]/a
${D_Comedy}          xpath=  //*[@id="app"]/div[1]/section/section[3]/div/div/div/div[1]/div[2]/div[1]/a
${D_Horror}          xpath=  //*[@id="app"]/div[1]/section/section[3]/div/div/div/div[1]/div[2]/div[2]/a
${D_Thriller}        xpath=  //*[@id="app"]/div[1]/section/section[3]/div/div/div/div[1]/div[2]/div[3]/a
${D_Classics}        xpath=  //*[@id="app"]/div[1]/section/section[3]/div/div/div/div[1]/div[2]/div[4]/a

#content row 1
${#1_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[4]/div/h2/a
${#1_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[4]/div/div[2]/div[1]/a/h2
${#1_Content2}       xpath=  //*[@id="app"]/div[1]/section/section[4]/div/div[2]/div[2]/a/h2
${#1_Content3}       xpath=  //*[@id="app"]/div[1]/section/section[4]/div/div[2]/div[3]/a/h2
${#1_Content4}       xpath=  //*[@id="app"]/div[1]/section/section[4]/div/div[2]/div[4]/a/h2
${#1_Content5}       xpath=  //*[@id="app"]/div[1]/section/section[4]/div/div[2]/div[5]/a/h2
${#1_Content6}       xpath=  //*[@id="app"]/div[1]/section/section[4]/div/div[2]/div[6]/a/h2
${#1_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[4]/div/h2/a/span

#content row 2
${#2_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[5]/div/h2/a
${#2_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[5]/div/div[2]/div[1]/a/h2
${#2_Content2}       xpath=  //*[@id="app"]/div[1]/section/section[5]/div/div[2]/div[2]/a/h2
${#2_Content3}       xpath=  //*[@id="app"]/div[1]/section/section[5]/div/div[2]/div[3]/a/h2
${#2_Content4}       xpath=  //*[@id="app"]/div[1]/section/section[5]/div/div[2]/div[4]/a/h2
${#2_Content5}       xpath=  //*[@id="app"]/div[1]/section/section[5]/div/div[2]/div[5]/a/h2
${#2_Content6}       xpath=  //*[@id="app"]/div[1]/section/section[5]/div/div[2]/div[6]/a/h2
${#2_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[5]/div/h2/a/span

#content row 3
${#3_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[6]/div/h2/a
${#3_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[6]/div/div[2]/div[1]/a/h2
${#3_Content2}       xpath=  //*[@id="app"]/div[1]/section/section[6]/div/div[2]/div[2]/a/h2
${#3_Content3}       xpath=  //*[@id="app"]/div[1]/section/section[6]/div/div[2]/div[3]/a/h2
${#3_Content4}       xpath=  //*[@id="app"]/div[1]/section/section[6]/div/div[2]/div[4]/a/h2
${#3_Content5}       xpath=  //*[@id="app"]/div[1]/section/section[6]/div/div[2]/div[5]/a/h2
${#3_Content6}       xpath=  //*[@id="app"]/div[1]/section/section[6]/div/div[2]/div[6]/a/h2
${#3_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[6]/div/h2/a/span

#content row 4
${#4_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[7]/div/h2/a
${#4_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[7]/div/div[2]/div[1]/a/h2
${#4_Content2}       xpath=  //*[@id="app"]/div[1]/section/section[7]/div/div[2]/div[2]/a/h2
${#4_Content3}       xpath=  //*[@id="app"]/div[1]/section/section[7]/div/div[2]/div[3]/a/h2
${#4_Content4}       xpath=  //*[@id="app"]/div[1]/section/section[7]/div/div[2]/div[4]/a/h2
${#4_Content5}       xpath=  //*[@id="app"]/div[1]/section/section[7]/div/div[2]/div[5]/a/h2
${#4_Content6}       xpath=  //*[@id="app"]/div[1]/section/section[7]/div/div[2]/div[6]/a/h2
${#4_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[7]/div/h2/a/span

#content row 5
${#5_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[8]/div/h2/a
${#5_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[8]/div/div[2]/div[1]/a/h2
${#5_Content2}       xpath=  //*[@id="app"]/div[1]/section/section[8]/div/div[2]/div[2]/a/h2
${#5_Content3}       xpath=  //*[@id="app"]/div[1]/section/section[8]/div/div[2]/div[3]/a/h2
${#5_Content4}       xpath=  //*[@id="app"]/div[1]/section/section[8]/div/div[2]/div[4]/a/h2
${#5_Content5}       xpath=  //*[@id="app"]/div[1]/section/section[8]/div/div[2]/div[5]/a/h2
${#5_Content6}       xpath=  //*[@id="app"]/div[1]/section/section[8]/div/div[2]/div[6]/a/h2
${#5_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[8]/div/h2/a/span

#content row 6
${#6_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[9]/div/h2/a
${#6_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[9]/div/div[2]/div[1]/a/h2
${#6_Content2}       xpath=  //*[@id="app"]/div[1]/section/section[9]/div/div[2]/div[2]/a/h2
${#6_Content3}       xpath=  //*[@id="app"]/div[1]/section/section[9]/div/div[2]/div[3]/a/h2
${#6_Content4}       xpath=  //*[@id="app"]/div[1]/section/section[9]/div/div[2]/div[4]/a/h2
${#6_Content5}       xpath=  //*[@id="app"]/div[1]/section/section[9]/div/div[2]/div[5]/a/h2
${#6_Content6}       xpath=  //*[@id="app"]/div[1]/section/section[9]/div/div[2]/div[6]/a/h2
${#6_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[9]/div/h2/a/span

#content row 7
${#7_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[10]/div/h2/a
${#7_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[10]/div/div[2]/div[1]/a/h2
${#7_Content2}       xpath=  //*[@id="app"]/div[1]/section/section[10]/div/div[2]/div[2]/a/h2
${#7_Content3}       xpath=  //*[@id="app"]/div[1]/section/section[10]/div/div[2]/div[3]/a/h2
${#7_Content4}       xpath=  //*[@id="app"]/div[1]/section/section[10]/div/div[2]/div[4]/a/h2
${#7_Content5}       xpath=  //*[@id="app"]/div[1]/section/section[10]/div/div[2]/div[5]/a/h2
${#7_Content6}       xpath=  //*[@id="app"]/div[1]/section/section[10]/div/div[2]/div[6]/a/h2
${#7_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[10]/div/h2/a/span

#content row 8
${#8_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[11]/div/h2/a
${#8_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[11]/div/div[2]/div[1]/a/h2
${#8_Content2}       xpath=  //*[@id="app"]/div[1]/section/section[11]/div/div[2]/div[2]/a/h2
${#8_Content3}       xpath=  //*[@id="app"]/div[1]/section/section[11]/div/div[2]/div[3]/a/h2
${#8_Content4}       xpath=  //*[@id="app"]/div[1]/section/section[11]/div/div[2]/div[4]/a/h2
${#8_Content5}       xpath=  //*[@id="app"]/div[1]/section/section[11]/div/div[2]/div[5]/a/h2
${#8_Content6}       xpath=  //*[@id="app"]/div[1]/section/section[11]/div/div[2]/div[6]/a/h2
${#8_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[11]/div/h2/a/span

#content row 9
${#9_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[12]/div/h2/a
${#9_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[12]/div/div[2]/div[1]/a/h2
${#9_Content2}       xpath=  //*[@id="app"]/div[1]/section/section[12]/div/div[2]/div[2]/a/h2
${#9_Content3}       xpath=  //*[@id="app"]/div[1]/section/section[12]/div/div[2]/div[3]/a/h2
${#9_Content4}       xpath=  //*[@id="app"]/div[1]/section/section[12]/div/div[2]/div[4]/a/h2
${#9_Content5}       xpath=  //*[@id="app"]/div[1]/section/section[12]/div/div[2]/div[5]/a/h2
${#9_Content6}       xpath=  //*[@id="app"]/div[1]/section/section[12]/div/div[2]/div[6]/a/h2
${#9_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[12]/div/h2/a/span

#content row 10
${#10_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[13]/div/h2/a
${#10_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[13]/div/div[2]/div[1]/a/h2
${#10_Content2}       xpath=  //*[@id="app"]/div[1]/section/section[13]/div/div[2]/div[2]/a/h2
${#10_Content3}       xpath=  //*[@id="app"]/div[1]/section/section[13]/div/div[2]/div[3]/a/h2
${#10_Content4}       xpath=  //*[@id="app"]/div[1]/section/section[13]/div/div[2]/div[4]/a/h2
${#10_Content5}       xpath=  //*[@id="app"]/div[1]/section/section[13]/div/div[2]/div[5]/a/h2
${#10_Content6}       xpath=  //*[@id="app"]/div[1]/section/section[13]/div/div[2]/div[6]/a/h2
${#10_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[13]/div/h2/a/span

#content row 11
${#11_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[14]/div/h2/a
${#11_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[14]/div/div[2]/div[1]/a/h2
${#11_Content2}       xpath=  //*[@id="app"]/div[1]/section/section[14]/div/div[2]/div[2]/a/h2
${#11_Content3}       xpath=  //*[@id="app"]/div[1]/section/section[14]/div/div[2]/div[3]/a/h2
${#11_Content4}       xpath=  //*[@id="app"]/div[1]/section/section[14]/div/div[2]/div[4]/a/h2
${#11_Content5}       xpath=  //*[@id="app"]/div[1]/section/section[14]/div/div[2]/div[5]/a/h2
${#11_Content6}       xpath=  //*[@id="app"]/div[1]/section/section[14]/div/div[2]/div[6]/a/h2
${#11_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[14]/div/h2/a/span

#content row 12
${#12_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[15]/div[1]/div[2]/h2/a
${#12_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[15]/div[1]/div[2]/div/div[1]/a/h2
${#12_Content2}       xpath=  //*[@id="app"]/div[1]/section/section[15]/div[1]/div[2]/div/div[2]/a/h2
${#12_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[15]/div[1]/div[2]/h2/a/span

#content row 12 splitted
${#12s_ContentTitle}   xpath=  //*[@id="app"]/div[1]/section/section[15]/div[2]/div[2]/h2
${#12s_Content1}       xpath=  //*[@id="app"]/div[1]/section/section[15]/div[2]/div[2]/div/div/div/div/div/div[1]/div/a/h2
${#12s_Content2}       xpath=  //*[@id="app"]/div[1]/section/section[15]/div[2]/div[2]/div/div/div/div/div/div[2]/div/a/h2
${#12s_ViewAll}        xpath=  //*[@id="app"]/div[1]/section/section[15]/div[2]/div[2]/h2/a/span
${#12s_indicator1}     xpath=  //*[@id="app"]/div[1]/section/section[15]/div[2]/div[2]/div/div/div/ol/li[1]
${#12s_indicator2}     xpath=  //*[@id="app"]/div[1]/section/section[15]/div[2]/div[2]/div/div/div/ol/li[2]
${#12s_indicator3}     xpath=  //*[@id="app"]/div[1]/section/section[15]/div[2]/div[2]/div/div/div/ol/li[3]
${#12s_indicator4}     xpath=  //*[@id="app"]/div[1]/section/section[15]/div[2]/div[2]/div/div/div/ol/li[4]

#content row 13
${#13_ContentTitle}    xpath=  //*[@id="app"]/div[1]/section/section[16]/div/h2/a
${#13_Content1}        xpath=  //*[@id="app"]/div[1]/section/section[16]/div/div[2]/div[1]/a/h2
${#13_Content2}        xpath=  //*[@id="app"]/div[1]/section/section[16]/div/div[2]/div[2]/a/h2
${#13_Content3}        xpath=  //*[@id="app"]/div[1]/section/section[16]/div/div[2]/div[3]/a/h2
${#13_Content4}        xpath=  //*[@id="app"]/div[1]/section/section[16]/div/div[2]/div[4]/a/h2
${#13_Content5}        xpath=  //*[@id="app"]/div[1]/section/section[16]/div/div[2]/div[5]/a/h2
${#13_Content6}        xpath=  //*[@id="app"]/div[1]/section/section[16]/div/div[2]/div[6]/a/h2
${#13_ViewAll}         xpath=  //*[@id="app"]/div[1]/section/section[16]/div/h2/a/span

#content row 14
${#14_ContentTitle}    xpath=  //*[@id="app"]/div[1]/section/section[17]/div/h2/a
${#14_Content1}        xpath=  //*[@id="app"]/div[1]/section/section[17]/div/div[2]/div[1]/a/h2
${#14_Content2}        xpath=  //*[@id="app"]/div[1]/section/section[17]/div/div[2]/div[2]/a/h2
${#14_Content3}        xpath=  //*[@id="app"]/div[1]/section/section[17]/div/div[2]/div[3]/a/h2
${#14_Content4}        xpath=  //*[@id="app"]/div[1]/section/section[17]/div/div[2]/div[4]/a/h2
${#14_Content5}        xpath=  //*[@id="app"]/div[1]/section/section[17]/div/div[2]/div[5]/a/h2
${#14_Content6}        xpath=  //*[@id="app"]/div[1]/section/section[17]/div/div[2]/div[6]/a/h2
${#14_ViewAll}         xpath=  //*[@id="app"]/div[1]/section/section[17]/div/h2/a/span

#content row 15
${#15_ContentTitle}    xpath=  //*[@id="app"]/div[1]/section/section[19]/div/h2/a
${#15_Content1}        xpath=  //*[@id="app"]/div[1]/section/section[19]/div/div[2]/div[1]/a/h2
${#15_Content2}        xpath=  //*[@id="app"]/div[1]/section/section[19]/div/div[2]/div[2]/a/h2
${#15_Content3}        xpath=  //*[@id="app"]/div[1]/section/section[19]/div/div[2]/div[3]/a/h2
${#15_Content4}        xpath=  //*[@id="app"]/div[1]/section/section[19]/div/div[2]/div[4]/a/h2
${#15_Content5}        xpath=  //*[@id="app"]/div[1]/section/section[19]/div/div[2]/div[5]/a/h2
${#15_Content6}        xpath=  //*[@id="app"]/div[1]/section/section[19]/div/div[2]/div[6]/a/h2
${#15_ViewAll}         xpath=  //*[@id="app"]/div[1]/section/section[19]/div/h2/a/span

#content row 16
${#15_ContentTitle}    xpath=  //*[@id="app"]/div[1]/section/section[20]/div/h2/a
${#15_Content1}        xpath=  //*[@id="app"]/div[1]/section/section[20]/div/div[2]/div[1]/a/h2
${#15_Content2}        xpath=  //*[@id="app"]/div[1]/section/section[20]/div/div[2]/div[2]/a/h2
${#15_Content3}        xpath=  //*[@id="app"]/div[1]/section/section[20]/div/div[2]/div[3]/a/h2
${#15_Content4}        xpath=  //*[@id="app"]/div[1]/section/section[20]/div/div[2]/div[4]/a/h2
${#15_Content5}        xpath=  //*[@id="app"]/div[1]/section/section[20]/div/div[2]/div[5]/a/h2
${#15_Content6}        xpath=  //*[@id="app"]/div[1]/section/section[20]/div/div[2]/div[6]/a/h2
${#15_ViewAll}         xpath=  //*[@id="app"]/div[1]/section/section[20]/div/h2/a/span

#content row 17
${#15_ContentTitle}    xpath=  //*[@id="app"]/div[1]/section/section[21]/div/h2/a
${#15_Content1}        xpath=  //*[@id="app"]/div[1]/section/section[21]/div/div[2]/div[1]/a/h2
${#15_Content2}        xpath=  //*[@id="app"]/div[1]/section/section[21]/div/div[2]/div[2]/a/h2
${#15_Content3}        xpath=  //*[@id="app"]/div[1]/section/section[21]/div/div[2]/div[3]/a/h2
${#15_Content4}        xpath=  //*[@id="app"]/div[1]/section/section[21]/div/div[2]/div[4]/a/h2
${#15_Content5}        xpath=  //*[@id="app"]/div[1]/section/section[21]/div/div[2]/div[5]/a/h2
${#15_Content6}        xpath=  //*[@id="app"]/div[1]/section/section[21]/div/div[2]/div[6]/a/h2

#content row 18
${#15_ContentTitle}    xpath=  //*[@id="app"]/div[1]/section/section[22]/div/h2/a
${#15_Content1}        xpath=  //*[@id="app"]/div[1]/section/section[22]/div/div[2]/div[1]/a/h2
${#15_Content2}        xpath=  //*[@id="app"]/div[1]/section/section[22]/div/div[2]/div[2]/a/h2
${#15_Content3}        xpath=  //*[@id="app"]/div[1]/section/section[22]/div/div[2]/div[3]/a/h2
${#15_Content4}        xpath=  //*[@id="app"]/div[1]/section/section[22]/div/div[2]/div[4]/a/h2
${#15_Content5}        xpath=  //*[@id="app"]/div[1]/section/section[22]/div/div[2]/div[5]/a/h2
