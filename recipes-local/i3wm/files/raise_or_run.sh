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
if [ "$count" -eq 0 ]; then
	dbus-launch $3
fi