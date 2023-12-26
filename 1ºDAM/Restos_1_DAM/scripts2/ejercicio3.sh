#!/bin/bash

read -p "¿A que carpeta lo deseas copiar?" carpeta
cp $1 $carpeta
ls -lrt $carpeta

