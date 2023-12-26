#!/bin/bash

lineas=$(cat $1 | wc -l)

if [[ $lineas -lt 25 ]]; then

	cat $1

fi
