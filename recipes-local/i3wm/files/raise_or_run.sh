#!/bin/sh

#usually the window class is named like the binary
class=$1

#define exceptions for programs that are not following unix naming standards
if [ $1 = "subl" ];then
	class="Sublime_text"
fi

#if program is running, give focus
if `wmctrl -xa $1`;then
	i3-msg [class=$class] focus
else
#else launch
	exec dbus-launch $1
fi