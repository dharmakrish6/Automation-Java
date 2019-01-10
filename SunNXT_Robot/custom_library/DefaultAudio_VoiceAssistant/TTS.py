from gtts import gTTS
from playsound import playsound

text = "Sayonara! until we meet again"

file_name = "sample_file"

language = 'en'

voice_obj = gTTS(text=text, lang=language, slow=False)

voice_obj.save(file_name + ".mp3")

playsound(file_name + '.mp3')
print("sound play ends")
