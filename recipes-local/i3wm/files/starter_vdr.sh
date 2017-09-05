#!/bin/sh

process="vdr"

class="softhddevice"

	workspace="7:video"

if ps -e | grep -w -q "$process";then
        	if i3-msg -t get_workspaces | grep -q "\"$workspace\",\"visible\":true,\"focused\":true";then
			{ killall -9 $process && wait $process; } 2>/dev/null
                else
                    	i3-msg workspace "$workspace"
                fi
else
	i3-msg workspace $workspace; exec vdr_userspace && i3-msg "[class=$class] focus"
fi
