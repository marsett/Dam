 #!/bin/bash

#Inicializamos una variable a 0 que vamos a utilizar para guardar la elección del menú

var=0

#Damos vueltas sobre el menú hasta que no se cumpla la opción 4 (salir)

while [ ! $var -eq 4 ]; do

#Escribimos las distintas opciones del usuario por pantalla


echo "¿Que opción desea ejecutar?"
echo "1. Mostrar doble"
echo "2. ¿Par o impar?"
echo "3. Mostrar cuadrado"
echo "4. Salir "

#Guardamos la opción escogida en la variable que hemos inicializado anteriormente

read var

#Evaluamos la primera opción, el cálculo del doble

if [ $var -eq 1 ]; then
		
#Calculamos el doble del número que se ha introducido como parámetro

		doble=$(($1*2))

#Lo mostramos por pantalla

echo "El doble es $doble"
	
#Evaluamos la segunda opción, el cálculo de par o impar

	elif [ $var -eq 2 ]; then

#Calculamos el módulo de 2 del parámetro introducido

		mod=$(($1%2))

#Si el módulo da 0 es par
		if [ $mod -eq 0 ]; then	
			echo "El número es par"

#Si el módulo da 1 es impar
		else
			echo "El número es impar"
		fi

#Evaluamos la tercera opción, el cálculo del cuadrado

	elif [ $var -eq 3 ]; then

		#Calculamos el cuadrado del parámetro introducido

		cuadrado=$(($1*$1))

		#Lo mostramos por pantalla

		echo "El cuadrado es $cuadrado"

	fi
#Cerramos el bucle

sleep 3
clear
done

#Si el usuario ha pulsado el número 4 salimos del menú y nos despedimos

echo "Adiós"

