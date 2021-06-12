#!/usr/bin/env bash

set -e


mkdir cleaned || true

for folder in ./9* ; do
    clear

    echo "--> person $folder"
    cd "$folder"
    unzip -qu ./*.zip || true
    cd git-hw

    thunar .

    echo "--> branches :"
    git branch --list | cat


    echo "--> log :"
    git log --graph --oneline --decorate --abbrev-commit | cat

    echo "--> status :"
    git status | cat

    echo "--> diff"
    git diff HEAD | cat

    echo "--> file:"
    cat homework.txt

    echo ""
    echo "--> .gitignore :"
    cat .gitignore || echo "**no gitignore**"
    echo ""


    read -n1 -r -p "Press any key to next..." key

    cd ..
    rm result.txt || true
    rm -- *.zip

    cd ..
    mv "$folder" cleaned
done


