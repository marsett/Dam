#!/bin/bash

uid=$(cat /etc/passwd | grep $1 | cut -d ":" -f3)

echo $uid
