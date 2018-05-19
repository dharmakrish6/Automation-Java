*** Variables ***
${tv_viewall}       VIEW ALL TV SHOWS

# browse row 1
${tbr#1_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/h2[1]/a[1]
${tbr#1_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[1]/a[1]/h2[1]
${tbr#1_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[2]/a[1]/h2[1]
${tbr#1_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[3]/a[1]/h2[1]
${tbr#1_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[4]/a[1]/h2[1]
${tbr#1_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[5]/a[1]/h2[1]
${tbr#1_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/h2[1]/a[1]/span[1]

# browse row 2
${tbr#2_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/h2[1]/a[1]
${tbr#2_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/div[2]/div[1]/a[1]/h2[1]
${tbr#2_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/div[2]/div[2]/a[1]/h2[1]
${tbr#2_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/div[2]/div[3]/a[1]/h2[1]
${tbr#2_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/div[2]/div[4]/a[1]/h2[1]
${tbr#2_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/div[2]/div[5]/a[1]/h2[1]
${tbr#2_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/h2[1]/a[1]/span[1]

# browse row 3
${tbr#3_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[2]/h2[1]/a[1]
${tbr#3_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[2]/div[1]/div[1]/a[1]/h2[1]
${tbr#3_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[2]/div[1]/div[2]/a[1]/h2[1]
${tbr#3_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[2]/h2[1]/a[1]/span[1]

# browse-row 3 split
${tbr#3-split_rowtitle}         xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[2]/div[2]/h2[1]
${tbr#3-split_content#1}        xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/h2[1]
${tbr#3-split_content#2}        xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/h2[1]
${tbr#3-split_content#3}        xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]/h2[1]
${tbr#3-split_content#4}        xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/a[1]/h2[1]
${tbr#3-split_content#5}        xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/a[1]/h2[1]
${tbr#3-split_content#6}        xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/a[1]/h2[1]
${tbr#3-split_viewall}          xpath=/html[1]/body[1]/div[2]/div[1]/section[3]/div[2]/div[2]/h2[1]/a[1]/span[1]

${tbr#3-split_indicator#1}       css=.flickity-page-dots .dot:nth-of-type(1)
${tbr#3-split_indicator#2}       css=.flickity-page-dots .dot:nth-of-type(2)
${tbr#3-split_indicator#3}       css=.flickity-page-dots .dot:nth-of-type(3)
${tbr#3-split_indicator#4}       css=.flickity-page-dots .dot:nth-of-type(4)
${tbr#3-split_indicator#5}       css=.flickity-page-dots .dot:nth-of-type(5)
${tbr#3-split_indicator#6}       css=.flickity-page-dots .dot:nth-of-type(6)

# browse row 4
${tbr#4_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[4]/div[1]/h2[1]/a[1]
${tbr#4_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[4]/div[1]/div[2]/div[1]/a[1]/h2[1]
${tbr#4_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[4]/div[1]/div[2]/div[2]/a[1]/h2[1]
${tbr#4_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[4]/div[1]/div[2]/div[3]/a[1]/h2[1]
${tbr#4_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[4]/div[1]/div[2]/div[4]/a[1]/h2[1]
${tbr#4_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[4]/div[1]/div[2]/div[5]/a[1]/h2[1]
${tbr#4_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[4]/div[1]/h2[1]/a[1]/span[1]

# browse row 5
${tbr#5_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/h2[1]/a[1]
${tbr#5_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/div[2]/div[1]/a[1]/h2[1]
${tbr#5_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/div[2]/div[2]/a[1]/h2[1]
${tbr#5_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/div[2]/div[3]/a[1]/h2[1]
${tbr#5_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/div[2]/div[4]/a[1]/h2[1]
${tbr#5_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/div[2]/div[5]/a[1]/h2[1]
${tbr#5_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[5]/div[1]/h2[1]/a[1]/span[1]

# browse row 6
${tbr#6_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/h2[1]/a[1]
${tbr#6_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/div[2]/div[1]/a[1]/h2[1]
${tbr#6_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/div[2]/div[2]/a[1]/h2[1]
${tbr#6_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/div[2]/div[3]/a[1]/h2[1]
${tbr#6_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/div[2]/div[4]/a[1]/h2[1]
${tbr#6_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/div[2]/div[5]/a[1]/h2[1]
${tbr#6_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[6]/div[1]/h2[1]/a[1]/span[1]

# browse row 7
${tbr#7_rowtitle}               xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/h2[1]/a[1]
${tbr#7_content#1}              xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/div[2]/div[1]/a[1]/h2[1]
${tbr#7_content#2}              xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/div[2]/div[2]/a[1]/h2[1]
${tbr#7_content#3}              xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/div[2]/div[3]/a[1]/h2[1]
${tbr#7_content#4}              xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/div[2]/div[4]/a[1]/h2[1]
${tbr#7_content#5}              xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/div[2]/div[5]/a[1]/h2[1]
${tbr#7_viewall}                xpath=/html[1]/body[1]/div[2]/div[1]/section[7]/div[1]/h2[1]/a[1]/span[1]

# browse row 8
${tbr#8_rowtitle}               xpath=
${tbr#8_content#1}              xpath=
${tbr#8_content#2}              xpath=
${tbr#8_content#3}              xpath=
${tbr#8_content#4}              xpath=
${tbr#8_content#5}              xpath=
${tbr#8_content#6}              xpath=
${tbr#8_viewall}                xpath=

# browse row 1
${tbr#1_rowtitle}               xpath=
${tbr#1_content#1}              xpath=
${tbr#1_content#2}              xpath=
${tbr#1_content#3}              xpath=
${tbr#1_content#4}              xpath=
${tbr#1_content#5}              xpath=
${tbr#1_content#6}              xpath=
${tbr#1_viewall}                xpath=

# browse row 1
${tbr#1_rowtitle}               xpath=
${tbr#1_content#1}              xpath=
${tbr#1_content#2}              xpath=
${tbr#1_content#3}              xpath=
${tbr#1_content#4}              xpath=
${tbr#1_content#5}              xpath=
${tbr#1_content#6}              xpath=
${tbr#1_viewall}                xpath=

# browse row 1
${tbr#1_rowtitle}               xpath=
${tbr#1_content#1}              xpath=
${tbr#1_content#2}              xpath=
${tbr#1_content#3}              xpath=
${tbr#1_content#4}              xpath=
${tbr#1_content#5}              xpath=
${tbr#1_content#6}              xpath=
${tbr#1_viewall}                xpath=

# browse row 1
${tbr#1_rowtitle}               xpath=
${tbr#1_content#1}              xpath=
${tbr#1_content#2}              xpath=
${tbr#1_content#3}              xpath=
${tbr#1_content#4}              xpath=
${tbr#1_content#5}              xpath=
${tbr#1_content#6}              xpath=
${tbr#1_viewall}                xpath=

# browse row 1
${tbr#1_rowtitle}               xpath=
${tbr#1_content#1}              xpath=
${tbr#1_content#2}              xpath=
${tbr#1_content#3}              xpath=
${tbr#1_content#4}              xpath=
${tbr#1_content#5}              xpath=
${tbr#1_content#6}              xpath=
${tbr#1_viewall}                xpath=

# browse row 1
${tbr#1_rowtitle}               xpath=
${tbr#1_content#1}              xpath=
${tbr#1_content#2}              xpath=
${tbr#1_content#3}              xpath=
${tbr#1_content#4}              xpath=
${tbr#1_content#5}              xpath=
${tbr#1_content#6}              xpath=
${tbr#1_viewall}                xpath=

# browse row 1
${tbr#1_rowtitle}               xpath=
${tbr#1_content#1}              xpath=
${tbr#1_content#2}              xpath=
${tbr#1_content#3}              xpath=
${tbr#1_content#4}              xpath=
${tbr#1_content#5}              xpath=
${tbr#1_content#6}              xpath=
${tbr#1_viewall}                xpath=

# browse row 1
${tbr#1_rowtitle}               xpath=
${tbr#1_content#1}              xpath=
${tbr#1_content#2}              xpath=
${tbr#1_content#3}              xpath=
${tbr#1_content#4}              xpath=
${tbr#1_content#5}              xpath=
${tbr#1_content#6}              xpath=
${tbr#1_viewall}                xpath=

# browse row 1
${tbr#1_rowtitle}               xpath=
${tbr#1_content#1}              xpath=
${tbr#1_content#2}              xpath=
${tbr#1_content#3}              xpath=
${tbr#1_content#4}              xpath=
${tbr#1_content#5}              xpath=
${tbr#1_content#6}              xpath=
${tbr#1_viewall}                xpath=

# browse row 1
${tbr#1_rowtitle}               xpath=
${tbr#1_content#1}              xpath=
${tbr#1_content#2}              xpath=
${tbr#1_content#3}              xpath=
${tbr#1_content#4}              xpath=
${tbr#1_content#5}              xpath=
${tbr#1_content#6}              xpath=
${tbr#1_viewall}                xpath=