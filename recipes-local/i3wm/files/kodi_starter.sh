#!/bin/bash
if ps -e | grep -w "kodi";then 
	killall -9 kodi && killall -9 kodi.bin
else
	i3-msg workspace 10:kodi; exec kodi && i3-msg "[class=Kodi] focus"
fi		

