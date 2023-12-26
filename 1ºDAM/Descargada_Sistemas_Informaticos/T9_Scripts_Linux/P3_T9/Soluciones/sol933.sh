#!/bin/bash

#Inicializamos una variable a 0 que vamos a utilizar para guardar la elección del menú

var=0

#Damos vueltas sobre el menú hasta que no se cumpla la opción 4 (salir)

while [ ! $var -eq 4 ]; do

#Escribimos las distintas opciones del usuario por pantalla

echo "¿Que opción desea ejecutar?"
echo "1. Mostrar contenido"
echo "2. Número de elementos que contiene la carpeta"
echo "3. Ampliar permisos de la carpeta"
echo "4. Salir "

#Guardamos la opción escogida en la variable que hemos inicializado anteriormente

read var

	#Evaluamos la primera opción, mostrar el contenido de la carpeta

if [ $var -eq 1 ]; then

#Listamos los elemento de la carpeta

ls -lrt $1

#Evaluamos la segunda opción, mostramos el número de elementos que tiene la carpeta

elif [ $var -eq 2 ]; then

#Ejecutamos el comando ls -lrt y contamos el número de líneas

elementos=$(ls -lrt $1 | wc -l)
((elementos=elementos-1))


echo "El directorio tiene $elementos elementos"

#Ampliamos los permisos de la  carpeta

elif [ $var -eq 3 ]; then

#Ejecutamos el comando chmod 777 para dar permisos a todos los usuarios
		chmod 777 $1
	fi
#Cerramos el bucle
done

#Si el usuario ha pulsado el número 4 salimos del menú y nos despedimos
echo "Adiós"
