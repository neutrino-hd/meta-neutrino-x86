#!/bin/sh
if ps -e | grep -w "vdr";then 
	killall -9 vdr
else
	i3-msg workspace 7:Video; exec vdr_userspace && i3-msg "[title=softhddevice] focus"
fi
