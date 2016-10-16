#!/bin/sh
# a simple script to create screenshots using imagemagicks "import"

whole_screen()
{
import -window root ~/pictures/$(date +%F_%H%M%S_%N).jpg
}

selection()
{
import -frame ~/pictures/$(date +%F_%H%M%S_%N).jpg
}


active_window()
{
activeWinLine=$(xprop -root | grep "_NET_ACTIVE_WINDOW(WINDOW)")
activeWinId=${activeWinLine:40}
import -window "$activeWinId" ~/pictures/$(date +%F_%H%M%S_%N).jpg
}

if   [ "$1" = "-w" ]; then
	whole_screen
elif [ "$1" = "-s" ]; then
	selection
elif [ "$1" = "-a" ]; then
	active_window
else echo -e "missing parameter:\n -w (whole screen)\n -s (selection)\n -a (active_window)"
fi    

