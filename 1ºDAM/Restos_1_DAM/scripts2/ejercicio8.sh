#!/bin/bash

carpeta=$(cat /etc/passwd | grep $1 | cut -d ":" -f6)

if [[ -d $carpeta ]];then
	ls -lrt $carpeta
else
	echo "Usuario no existe"
fi


