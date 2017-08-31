#!/bin/sh
if ps -e | grep -w "chrome";then 
	killall -9 chrome
else
	i3-msg workspace 2:web; exec google-chrome && i3-msg "[class=Google-chrome] focus"
fi