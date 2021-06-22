#!/usr/bin/env bash

set -e

reset

mkdir cleaned 2> /dev/null || true

for folder in ./9* ; do

    echo "--> $folder"
    cd "$folder"
    unzip -qu ./*.zip 2> /dev/null || true
    rm -rf ../sol || true
    mkdir ../sol
    cp -r main ../sol/

    cd ..
    ./run.sh || true

    echo ""
    
    #read -n1 -r -p "Press any key to next..." key

    #rm "$folder/result.txt" 2> /dev/null || true
    #rm -- "$folder"/*.zip 2> /dev/null || true

    #mv "$folder" cleaned
done


