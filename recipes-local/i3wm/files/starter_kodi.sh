#!/bin/sh

process="kodi.bin"

class="kodi"

	workspace="10:kodi"

if ps -e | grep -w -q "$process";then
        	if i3-msg -t get_workspaces | grep -q "\"$workspace\",\"visible\":true,\"focused\":true";then
			{ killall -9 $process && wait $process; } 2>/dev/null
                else
                    	i3-msg workspace "$workspace"
                fi
else
	i3-msg workspace $workspace; exec kodi && i3-msg "[class=$class] focus"
fi
