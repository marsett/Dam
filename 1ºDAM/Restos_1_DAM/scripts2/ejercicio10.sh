#!/bin/bash

read -p "Dame un fichero " fichero

if [[ ! -s $fichero ]];then

	echo "Ahora ya no está vacío" > $fichero

fi

cat $fichero

