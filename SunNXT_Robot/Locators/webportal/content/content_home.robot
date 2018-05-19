*** Variables ***
# sliding carousels
${sc_content#1}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]
${sc_content#2}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[2]/a[1]/div[1]/div[1]
${sc_content#3}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[3]/a[1]/div[1]/div[1]
${sc_content#4}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[4]/a[1]/div[1]/div[1]
${sc_content#5}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[5]/a[1]/div[1]/div[1]
${sc_content#6}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[6]/a[1]/div[1]/div[1]

# carousel indicators
${sc_indicator#1}           css=.home_banner .flickity-page-dots .dot:nth-of-type(1)
${sc_indicator#2}           css=.home_banner .flickity-page-dots .dot:nth-of-type(2)
${sc_indicator#3}           css=.home_banner .flickity-page-dots .dot:nth-of-type(3)
${sc_indicator#4}           css=.home_banner .flickity-page-dots .dot:nth-of-type(4)
${sc_indicator#5}           css=.home_banner .flickity-page-dots .dot:nth-of-type(5)
${sc_indicator#6}           css=.home_banner .flickity-page-dots .dot:nth-of-type(6)

# browse-row 1
${hbr#1_rowtitle}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[2]/div[1]/h2[1]
${hbr#1_content#1}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[2]/div[1]/div[1]/div[1]/a[1]/h2[1]
${hbr#1_content#2}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[2]/div[1]/div[1]/div[2]/a[1]/h2[1]
${hbr#1_content#3}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[2]/div[1]/div[1]/div[3]/a[1]/h2[1]
${hbr#1_content#4}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[2]/div[1]/div[1]/div[4]/a[1]/h2[1]
${hbr#1_content#5}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[2]/div[1]/div[1]/div[5]/a[1]/h2[1]
${hbr#1_viewall}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[2]/div[1]/h2[1]/a[1]/span[1]

# browse-row 2
${hbr#2_rowtitle}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[3]/div[1]/h2[1]/a[1]
${hbr#2_content#1}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[3]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#2_content#2}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[3]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#2_content#3}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[3]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#2_content#4}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[3]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#2_content#5}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[3]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#2_content#6}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[3]/div[1]/div[2]/div[6]/a[1]/h2[1]
${hbr#2_viewall}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[3]/div[1]/h2[1]/a[1]/span[1]

# discover section
${d_title}                  xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[4]/div[1]/h2[1]
${d_romance}                css=.row-badge:nth-of-type(1) .b-item:nth-of-type(1) .text-uppercase
${d_action}                 css=.row-badge:nth-of-type(1) .b-item:nth-of-type(2) .text-uppercase
${d_familydrama}            css=.row-badge:nth-of-type(1) .b-item:nth-of-type(3) .text-uppercase
${d_musicvideos}            css=.row-badge:nth-of-type(1) .b-item:nth-of-type(4) .text-uppercase
${d_comedy}                 css=.row-badge:nth-of-type(2) .b-item:nth-of-type(1) .text-uppercase
${d_horror}                 css=.row-badge:nth-of-type(2) .b-item:nth-of-type(2) .text-uppercase
${d_thriller}               css=.row-badge:nth-of-type(2) .b-item:nth-of-type(3) .text-uppercase
${d_classics}               css=.row-badge:nth-of-type(2) .b-item:nth-of-type(4) .text-uppercase

# browse-row 3
${hbr#3_rowtitle}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[5]/div[1]/h2[1]/a[1]
${hbr#3_content#1}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[5]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#3_content#2}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[5]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#3_content#3}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[5]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#3_content#4}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[5]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#3_content#5}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[5]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#3_content#6}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[5]/div[1]/div[2]/div[6]/a[1]/h2[1]
${hbr#3_viewall}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[5]/div[1]/h2[1]/a[1]/span[1]

# browse-row 4
${hbr#4_rowtitle}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[6]/div[1]/h2[1]/a[1]
${hbr#4_content#1}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[6]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#4_content#2}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[6]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#4_content#3}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[6]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#4_content#4}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[6]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#4_content#5}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[6]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#4_viewall}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[6]/div[1]/h2[1]/a[1]/span[1]

# browse-row 5
${hbr#5_rowtitle}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[7]/div[1]/h2[1]/a[1]
${hbr#5_content#1}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[7]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#5_content#2}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[7]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#5_content#3}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[7]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#5_content#4}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[7]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#5_content#5}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[7]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#5_content#6}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[7]/div[1]/div[2]/div[6]/a[1]/h2[1]
${hbr#5_viewall}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[7]/div[1]/h2[1]/a[1]/span[1]

# browse-row 6
${hbr#6_rowtitle}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[8]/div[1]/h2[1]/a[1]
${hbr#6_content#1}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[8]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#6_content#2}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[8]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#6_content#3}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[8]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#6_content#4}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[8]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#6_content#5}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[8]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#6_viewall}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[8]/div[1]/h2[1]/a[1]/span[1]

# browse-row 7
${hbr#7_rowtitle}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[9]/div[1]/h2[1]/a[1]
${hbr#7_content#1}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[9]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#7_content#2}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[9]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#7_content#3}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[9]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#7_content#4}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[9]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#7_content#5}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[9]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#7_content#6}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[9]/div[1]/div[2]/div[6]/a[1]/h2[1]
${hbr#7_viewall}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[9]/div[1]/h2[1]/a[1]/span[1]

# browse-row 8
${hbr#8_rowtitle}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[10]/div[1]/h2[1]/a[1]
${hbr#8_content#1}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[10]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#8_content#2}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[10]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#8_content#3}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[10]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#8_content#4}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[10]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#8_content#5}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[10]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#8_viewall}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[10]/div[1]/h2[1]/a[1]/span[1]

# browse-row 9
${hbr#9_rowtitle}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[11]/div[1]/h2[1]/a[1]
${hbr#9_content#1}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[11]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#9_content#2}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[11]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#9_content#3}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[11]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#9_content#4}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[11]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#9_content#5}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[11]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#9_viewall}             xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[11]/div[1]/h2[1]/a[1]/span[1]

# browse-row 10
${hbr#10_rowtitle}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[12]/div[1]/h2[1]/a[1]
${hbr#10_content#1}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[12]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#10_content#2}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[12]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#10_content#3}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[12]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#10_content#4}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[12]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#10_content#5}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[12]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#10_viewall}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[12]/div[1]/h2[1]/a[1]/span[1]

# browse-row 11
${hbr#11_rowtitle}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[13]/div[1]/h2[1]/a[1]
${hbr#11_content#1}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[13]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#11_content#2}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[13]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#11_content#3}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[13]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#11_content#4}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[13]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#11_content#5}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[13]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#11_viewall}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[13]/div[1]/h2[1]/a[1]/span[1]

# browse-row 12
${hbr#12_rowtitle}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[14]/div[1]/h2[1]/a[1]
${hbr#12_content#1}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[14]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#12_content#2}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[14]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#12_content#3}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[14]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#12_content#4}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[14]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#12_content#5}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[14]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#12_content#6}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[14]/div[1]/div[2]/div[6]/a[1]/h2[1]
${hbr#12_viewall}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[14]/div[1]/h2[1]/a[1]/span[1]

# browse-row 13
${hbr#13_rowtitle}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[15]/div[1]/h2[1]/a[1]
${hbr#13_content#1}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[15]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#13_content#2}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[15]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#13_content#3}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[15]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#13_content#4}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[15]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#13_content#5}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[15]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#13_viewall}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[15]/div[1]/h2[1]/a[1]/span[1]

# browse-row 14
${hbr#14_rowtitle}           xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[16]/div[1]/div[2]/h2[1]/a[1]
${hbr#14_content#1}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[16]/div[1]/div[2]/div[1]/div[1]/a[1]/h2[1]
${hbr#14_content#2}          xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[16]/div[1]/div[2]/div[1]/div[2]/a[1]/h2[1]
${hbr#14_viewall}            xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[16]/div[1]/div[2]/h2[1]/a[1]/span[1]

# browse-row 14 split
${hbr#14-split_rowtitle}     xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[16]/div[2]/div[2]/h2[1]
${hbr#14-split_content#1}    xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[16]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/h2[1]
${hbr#14-split_content#2}    xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[16]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#14-split_content#3}    xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[16]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]/h2[1]
${hbr#14-split_content#4}    xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[16]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/a[1]/h2[1]
${hbr#14-split_viewall}      xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[16]/div[2]/div[2]/h2[1]/a[1]/span[1]

${hbr#14-split_indicator#1}       css=.whatsnew_list .flickity-page-dots .dot:nth-of-type(1)
${hbr#14-split_indicator#2}       css=.whatsnew_list .flickity-page-dots .dot:nth-of-type(2)
${hbr#14-split_indicator#3}       css=.whatsnew_list .flickity-page-dots .dot:nth-of-type(3)
${hbr#14-split_indicator#4}       css=.whatsnew_list .flickity-page-dots .dot:nth-of-type(4)

# browse-row 15
${hbr#15_rowtitle}        xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[17]/div[1]/h2[1]/a[1]
${hbr#15_content#1}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[17]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#15_content#2}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[17]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#15_content#3}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[17]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#15_content#4}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[17]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#15_content#5}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[17]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#15_content#6}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[17]/div[1]/div[2]/div[6]/a[1]/h2[1]
${hbr#15_viewall}         xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[17]/div[1]/h2[1]/a[1]/span[1]

# browse-row 16
${hbr#16_rowtitle}        xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[18]/div[1]/h2[1]/a[1]
${hbr#16_content#1}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[18]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#16_content#2}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[18]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#16_content#3}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[18]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#16_content#4}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[18]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#16_content#5}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[18]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#16_viewall}         xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[18]/div[1]/h2[1]/a[1]/span[1]

# browse-row 17
${hbr#17_rowtitle}        xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[19]/div[1]/h2[1]/a[1]
${hbr#17_content#1}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[19]/div[1]/div[2]/div[1]/a[1]/h2[1]
${hbr#17_content#2}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[19]/div[1]/div[2]/div[2]/a[1]/h2[1]
${hbr#17_content#3}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[19]/div[1]/div[2]/div[3]/a[1]/h2[1]
${hbr#17_content#4}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[19]/div[1]/div[2]/div[4]/a[1]/h2[1]
${hbr#17_content#5}       xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[19]/div[1]/div[2]/div[5]/a[1]/h2[1]
${hbr#17_viewall}         xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/section[19]/div[1]/h2[1]/a[1]/span[1]