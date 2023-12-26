#!/bin/bash

if [[ -d $1 ]]; then
	echo "Es un directorio"

elif [[ -e $1 ]]; then

	echo "Es un fichero"
else
	echo "No existe"
fi
