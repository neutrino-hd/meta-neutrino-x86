#!/bin/sh

process="mediathek_view"

class="mediathekview"

	workspace="7:video"

if ps -e | grep -w -q "$process";then
        	if i3-msg -t get_workspaces | grep -q "\"$workspace\",\"visible\":true,\"focused\":true";then
			{ killall -9 java && wait java; } 2>/dev/null
                else
                    	i3-msg workspace "$workspace"
                fi
else
	i3-msg workspace $workspace; exec mediathek_view && i3-msg "[class=$class] focus"
fi
