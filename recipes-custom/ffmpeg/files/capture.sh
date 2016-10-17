# a simple bash script for creating screen captures using ffmpeg under X11

Array=($(pidof ffmpeg))

if [ ${Array[@]} -ne 0 ]; then 
	for i in ${Array[@]}; do
		kill -9 $i
	done
	exit 0
fi

comp="-c:v libx264 -preset ultrafast -qp 0"

whole_screen()
{
 ffmpeg -f alsa \
 	-ac 2 \
 	-f x11grab \
 	-r 15 \
 	-s $(xrandr --current | grep '*' | uniq | awk '{print $1}' | cut -d 'x' -f1)"x"$(xrandr --current \
 		| grep '*' | uniq | awk '{print $1}' | cut -d 'x' -f2) \
 	-i :0.0+$(xwininfo -root | grep -oEe 'Corners: +\+[0-9]+\+[0-9]+' \
 		| grep -oEe '[0-9]+\+[0-9]+' | sed -e 's/\+/,/' ) \
 	-acodec pcm_s16le \
 	$comp \
 	-y ~/movies/$(date +%F_%H%M%S_%N).mkv
}
 
active_window() 
{
 ffmpeg -f alsa \
 	-ac 2 \
 	-f x11grab \
 	-r 15 \
 	-s $(xwininfo -frame | grep -oEe 'geometry [0-9]+x[0-9]+' | grep -oEe '[0-9]+x[0-9]+') \
 	-i :0.0+$(xwininfo -frame | grep -oEe 'Corners: +\+[0-9]+\+[0-9]+' \
 		| grep -oEe '[0-9]+\+[0-9]+' | sed -e 's/\+/,/' ) \
 	-acodec pcm_s16le \
 	$comp \
 	-y ~/movies/$(date +%F_%H%M%S_%N).mkv
}


if   [ "$2" = "-c" ]; then
comp="-c:v libx264 -preset veryslow -qp 0"
fi

if   [ "$1" = "-w" ]; then
	whole_screen
elif [ "$1" = "-a" ]; then
	active_window
else 
	echo -e "missing parameter:\n -w (whole screen)\n -a (active_window)\n\nappend -c for compressed output"
fi
