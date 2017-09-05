#!/bin/sh

if [ $1 = google-chrome ];then
process="chrome"
elif [ $1 = vdr_userspace ];then
process="vdr"
elif [ $1 = subl ];then
process="sublime_text"
else
process="$1"
fi

if [ $1 = vdr_userspace ];then
class="softhddevice"
elif [ $1 = subl ];then
class="sublime_text"
else
class="$1"
fi

if [ $process = chrome ];then
	workspace="2:web"
elif [ $process = skypeforlinux ];then
	workspace="3:chat"
elif [ $process = xchat ];then
        workspace="3:chat"
elif [ $process = nautilus ];then
        workspace="5:file"
elif [ $process = sublime_text ];then
        workspace="5:file"
elif [ $process = vdr ];then
        workspace="7:video"
elif [ $process = deadbeef ];then
        workspace="8:audio"
elif [ $process = pavucontrol ];then
        workspace="8:audio"
elif [ $process = gimp ];then
        workspace="9:gfx"
elif [ $process = gthumb ];then
        workspace="9:gfx"
elif [ $process = kodi ];then
        workspace="10:kodi"
fi

if ps -e | grep -w -q "$process";then
        	if i3-msg -t get_workspaces | grep -q "\"$workspace\",\"visible\":true,\"focused\":true";then
			{ killall -9 $process && wait $process; } 2>/dev/null
                else
                    	i3-msg workspace "$workspace"
                fi
else
	i3-msg workspace $workspace; exec $1 && i3-msg "[class=$class] focus"
fi
