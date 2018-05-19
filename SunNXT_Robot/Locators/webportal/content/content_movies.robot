*** Variables ***
${mov_viewall}      VIEW ALL MOVIES
${mov_playbtn}      PLAY

# browse row 1
${mbr#1_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/h2[1]/a[1]
${mbr#1_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#1_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#1_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#1_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#1_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#1_content#6}              xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#1_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/h2[1]/a[1]/span[1]

# browse row 2
${mbr#2_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/h2[1]/a[1]
${mbr#2_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#2_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#2_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#2_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#2_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#2_content#6}              xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#2_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/h2[1]/a[1]/span[1]

# discover section
${d_title}                      xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[4]/div[1]/h2[1]
${d_romance}                    css=.row-badge:nth-of-type(2) .b-item:nth-of-type(1) .text-uppercase
${d_action}                     css=.row-badge:nth-of-type(1) .b-item:nth-of-type(1) .text-uppercase
${d_familydrama}                css=.row-badge:nth-of-type(2) .b-item:nth-of-type(2) .text-uppercase
${d_musicvideos}                css=.row-badge:nth-of-type(1) .b-item:nth-of-type(4) .text-uppercase
${d_comedy}                     css=.row-badge:nth-of-type(1) .b-item:nth-of-type(2) .text-uppercase
${d_horror}                     css=.row-badge:nth-of-type(1) .b-item:nth-of-type(3) .text-uppercase
${d_thriller}                   css=.row-badge:nth-of-type(2) .b-item:nth-of-type(3) .text-uppercase
${d_classics}                   css=.row-badge:nth-of-type(2) .b-item:nth-of-type(4) .text-uppercase222

# browse row 3
${mbr#3_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/h2[1]/a[1]
${mbr#3_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#3_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#3_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#3_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#3_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#3_content#6}              xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#3_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/h2[1]/a[1]/span[1]

# browse row 4
${mbr#4_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/h2[1]/a[1]
${mbr#4_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#4_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#4_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#4_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#4_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#4_content#6}              xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#4_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/h2[1]/a[1]/span[1]

# browse row 5
${mbr#5_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/h2[1]/a[1]
${mbr#5_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#5_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#5_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#5_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#5_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#5_content#6}              xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#5_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/h2[1]/a[1]/span[1]

# browse row 6
${mbr#6_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[8]/div[1]/h2[1]/a[1]
${mbr#6_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[8]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#6_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[8]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#6_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[8]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#6_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[8]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#6_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[8]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#6_content#6}              xpath=/html[1]/body[1]/div[2]/div[1]/section[8]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#6_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[8]/div[1]/h2[1]/a[1]/span[1]

# browse row 7
${mbr#7_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[9]/div[1]/h2[1]/a[1]
${mbr#7_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[9]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#7_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[9]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#7_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[9]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#7_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[9]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#7_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[9]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#7_content#6}              xpath=/html[1]/body[1]/div[2]/div[1]/section[9]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#7_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[9]/div[1]/h2[1]/a[1]/span[1]

# browse row 8
${mbr#8_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[10]/div[1]/h2[1]/a[1]
${mbr#8_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[10]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#8_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[10]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#8_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[10]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#8_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[10]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#8_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[10]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#8_content#6}              xpath=/html[1]/body[1]/div[2]/div[1]/section[10]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#8_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[10]/div[1]/h2[1]/a[1]/span[1]

# browse row 9
${mbr#9_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[11]/div[1]/h2[1]/a[1]
${mbr#9_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[11]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#9_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[11]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#9_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[11]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#9_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[11]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#9_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[11]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#9_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[11]/div[1]/h2[1]/a[1]/span[1]

# browse row 10
${mbr#10_rowtitle}              xpath=/html[1]/body[1]/div[2]/div[1]/section[12]/div[1]/h2[1]/a[1]
${mbr#10_content#1}             xpath=/html[1]/body[1]/div[2]/div[1]/section[12]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#10_content#2}             xpath=/html[1]/body[1]/div[2]/div[1]/section[12]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#10_content#3}             xpath=/html[1]/body[1]/div[2]/div[1]/section[12]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#10_content#4}             xpath=/html[1]/body[1]/div[2]/div[1]/section[12]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#10_content#5}             xpath=/html[1]/body[1]/div[2]/div[1]/section[12]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#10_content#6}             xpath=/html[1]/body[1]/div[2]/div[1]/section[12]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#10_viewall}               xpath=/html[1]/body[1]/div[2]/div[1]/section[12]/div[1]/h2[1]/a[1]/span[1]

# browse row 11
${mbr#11_rowtitle}              xpath=/html[1]/body[1]/div[2]/div[1]/section[13]/div[1]/h2[1]/a[1]
${mbr#11_content#1}             xpath=/html[1]/body[1]/div[2]/div[1]/section[13]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#11_content#2}             xpath=/html[1]/body[1]/div[2]/div[1]/section[13]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#11_content#3}             xpath=/html[1]/body[1]/div[2]/div[1]/section[13]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#11_content#4}             xpath=/html[1]/body[1]/div[2]/div[1]/section[13]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#11_content#5}             xpath=/html[1]/body[1]/div[2]/div[1]/section[13]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#11_content#6}             xpath=/html[1]/body[1]/div[2]/div[1]/section[13]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#11_viewall}               xpath=/html[1]/body[1]/div[2]/div[1]/section[13]/div[1]/h2[1]/a[1]/span[1]

# browse row 12
${mbr#12_rowtitle}              xpath=/html[1]/body[1]/div[2]/div[1]/section[14]/div[1]/h2[1]/a[1]
${mbr#12_content#1}             xpath=/html[1]/body[1]/div[2]/div[1]/section[14]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#12_content#2}             xpath=/html[1]/body[1]/div[2]/div[1]/section[14]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#12_content#3}             xpath=/html[1]/body[1]/div[2]/div[1]/section[14]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#12_content#4}             xpath=/html[1]/body[1]/div[2]/div[1]/section[14]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#12_content#5}             xpath=/html[1]/body[1]/div[2]/div[1]/section[14]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#12_content#6}             xpath=/html[1]/body[1]/div[2]/div[1]/section[14]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#12_viewall}               xpath=/html[1]/body[1]/div[2]/div[1]/section[14]/div[1]/h2[1]/a[1]/span[1]

# browse row 13
${mbr#13_rowtitle}              xpath=/html[1]/body[1]/div[2]/div[1]/section[15]/div[1]/h2[1]/a[1]
${mbr#13_content#1}             xpath=/html[1]/body[1]/div[2]/div[1]/section[15]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#13_content#2}             xpath=/html[1]/body[1]/div[2]/div[1]/section[15]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#13_content#3}             xpath=/html[1]/body[1]/div[2]/div[1]/section[15]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#13_content#4}             xpath=/html[1]/body[1]/div[2]/div[1]/section[15]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#13_content#5}             xpath=/html[1]/body[1]/div[2]/div[1]/section[15]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#13_content#6}             xpath=/html[1]/body[1]/div[2]/div[1]/section[15]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#13_viewall}               xpath=/html[1]/body[1]/div[2]/div[1]/section[15]/div[1]/h2[1]/a[1]/span[1]

# browse row 14
${mbr#14_rowtitle}              xpath=/html[1]/body[1]/div[2]/div[1]/section[16]/div[1]/h2[1]/a[1]
${mbr#14_content#1}             xpath=/html[1]/body[1]/div[2]/div[1]/section[16]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#14_content#2}             xpath=/html[1]/body[1]/div[2]/div[1]/section[16]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#14_content#3}             xpath=/html[1]/body[1]/div[2]/div[1]/section[16]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#14_content#4}             xpath=/html[1]/body[1]/div[2]/div[1]/section[16]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#14_content#5}             xpath=/html[1]/body[1]/div[2]/div[1]/section[16]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#14_content#6}             xpath=/html[1]/body[1]/div[2]/div[1]/section[16]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#14_viewall}               xpath=/html[1]/body[1]/div[2]/div[1]/section[16]/div[1]/h2[1]/a[1]/span[1]

# browse row 15
${mbr#15_rowtitle}              xpath=/html[1]/body[1]/div[2]/div[1]/section[17]/div[1]/h2[1]/a[1]
${mbr#15_content#1}             xpath=/html[1]/body[1]/div[2]/div[1]/section[17]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#15_content#2}             xpath=/html[1]/body[1]/div[2]/div[1]/section[17]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#15_content#3}             xpath=/html[1]/body[1]/div[2]/div[1]/section[17]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#15_content#4}             xpath=/html[1]/body[1]/div[2]/div[1]/section[17]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#15_content#5}             xpath=/html[1]/body[1]/div[2]/div[1]/section[17]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#15_content#6}             xpath=/html[1]/body[1]/div[2]/div[1]/section[17]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#15_viewall}               xpath=/html[1]/body[1]/div[2]/div[1]/section[17]/div[1]/h2[1]/a[1]/span[1]

# browse row 16
${mbr#16_rowtitle}              xpath=/html[1]/body[1]/div[2]/div[1]/section[18]/div[1]/h2[1]/a[1]
${mbr#16_content#1}             xpath=/html[1]/body[1]/div[2]/div[1]/section[18]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#16_content#2}             xpath=/html[1]/body[1]/div[2]/div[1]/section[18]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#16_content#3}             xpath=/html[1]/body[1]/div[2]/div[1]/section[18]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#16_content#4}             xpath=/html[1]/body[1]/div[2]/div[1]/section[18]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#16_viewall}               xpath=/html[1]/body[1]/div[2]/div[1]/section[18]/div[1]/h2[1]/a[1]/span[1]

# browse row 17
${mbr#17_rowtitle}              xpath=/html[1]/body[1]/div[2]/div[1]/section[19]/div[1]/h2[1]/a[1]
${mbr#17_content#1}             xpath=/html[1]/body[1]/div[2]/div[1]/section[19]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#17_content#2}             xpath=/html[1]/body[1]/div[2]/div[1]/section[19]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#17_content#3}             xpath=/html[1]/body[1]/div[2]/div[1]/section[19]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#17_content#4}             xpath=/html[1]/body[1]/div[2]/div[1]/section[19]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#17_content#5}             xpath=/html[1]/body[1]/div[2]/div[1]/section[19]/div[1]/div[2]/div[5]/a[1]/h2[1]
${mbr#17_content#6}             xpath=/html[1]/body[1]/div[2]/div[1]/section[19]/div[1]/div[2]/div[6]/a[1]/h2[1]
${mbr#17_viewall}               xpath=/html[1]/body[1]/div[2]/div[1]/section[19]/div[1]/h2[1]/a[1]/span[1]

# browse row 18
${mbr#18_rowtitle}              xpath=/html[1]/body[1]/div[2]/div[1]/section[20]/div[1]/h2[1]/a[1]
${mbr#18_content#1}             xpath=/html[1]/body[1]/div[2]/div[1]/section[20]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#18_content#2}             xpath=/html[1]/body[1]/div[2]/div[1]/section[20]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#18_content#3}             xpath=/html[1]/body[1]/div[2]/div[1]/section[20]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#18_content#4}             xpath=/html[1]/body[1]/div[2]/div[1]/section[20]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#18_viewall}               xpath=/html[1]/body[1]/div[2]/div[1]/section[20]/div[1]/h2[1]/a[1]/span[1]

# browse row 19
${mbr#19_rowtitle}              xpath=/html[1]/body[1]/div[2]/div[1]/section[21]/div[1]/h2[1]/a[1]
${mbr#19_content#1}             xpath=/html[1]/body[1]/div[2]/div[1]/section[21]/div[1]/div[2]/div[1]/a[1]/h2[1]
${mbr#19_content#2}             xpath=/html[1]/body[1]/div[2]/div[1]/section[21]/div[1]/div[2]/div[2]/a[1]/h2[1]
${mbr#19_content#3}             xpath=/html[1]/body[1]/div[2]/div[1]/section[21]/div[1]/div[2]/div[3]/a[1]/h2[1]
${mbr#19_content#4}             xpath=/html[1]/body[1]/div[2]/div[1]/section[21]/div[1]/div[2]/div[4]/a[1]/h2[1]
${mbr#19_viewall}               xpath=/html[1]/body[1]/div[2]/div[1]/section[21]/div[1]/h2[1]/a[1]/span[1]