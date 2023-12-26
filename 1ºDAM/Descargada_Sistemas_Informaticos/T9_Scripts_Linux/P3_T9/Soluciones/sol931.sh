#!/bin/bash

#Evaluamos si es un fichero y si NO tiene permisos de ejecución

if [ ! -x $1 ]; then

#Preguntamos si queremos cambiar los permisos al fichero e indicamos las opciones de las que disponemos para responder "s" o "n"

echo "¿Desea cambiar los permisos? s/n"

#Guardamos la respuesta en la variable var

read var

#Evaluamos la respuesta si es positiva, comprobamos mayúsculas también

	if [ $var == "s" ] || [ $var == "S" ]; then
#Cambiamos los permisos para que pueda ser ejecutado por el propietario

		chmod u+x $1
	fi
fi

