#!/bin/sh
case "$1" in
	"class" )
		count=`xdotool search --class "$2" | wc -l`
		i3wm_criteria="class";;
	"instance" )
		count=`xdotool search --classname "$2" | wc -l`
		i3wm_criteria="instance";;
	"name" )
		count=`xdotool search --name "$2" | wc -l`
		i3wm_criteria="title";;
esac

if [ $3 = kodi ];then
	if [ "$count" -eq 1 ]; then
		dbus-launch $3
	fi
elif [ "$count" -eq 0 ]; then
	 dbus-launch $3
fi
