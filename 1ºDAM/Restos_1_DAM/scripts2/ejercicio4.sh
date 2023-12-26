#!/bin/bash

numero=$(cat /etc/passwd | wc -l)

echo "El sistema tiene $numero usuarios"
