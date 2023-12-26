#!/bin/bash

carpeta=$(cat /etc/passwd | grep $1 | cut -d ":" -f6)
ls $carpeta | wc -w
