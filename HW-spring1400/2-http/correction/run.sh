#!/bin/sh

set -o errexit
set -o nounset

start_point="$(pwd)"

when_fail="--allow"

if [ $# -ge 1 ] && [ -n "$1" ]
then
    when_fail="$1"
fi

try_delete(){
    rm -r "$1" > /dev/null 2>&1 || true
}

clean() {
    cd "$start_point"
    find . -name '*.class' -delete
    try_delete "sandbox"
}

terminate(){
    clean
    exit 1
}

test_fail(){
    if [ "$when_fail" = "--fail" ] || [ "$when_fail" = "-f" ]; then
        terminate
    else [ "$when_fail" = "--allow" ] || [ "$when_fail" = "-a" ];
        true
    fi;
}


#clear #screen
clean

mkdir sandbox

#echo "-> copying files to sandbox"
cp junit-jars/*.jar sandbox/
cp -r tests/project/* sandbox/ > /dev/null 2>&1  || true
cp -r sol/* sandbox/
cp -r tests/test/* sandbox/

cd sandbox/

#echo "-> comiling project"
find . -name "*.java" > sources.txt
javac -Xmaxerrs 2 -cp .:junit.jar:j2.jar:json.jar @sources.txt || terminate

#echo "-> running tests"
java -cp .:junit.jar:j2.jar:json.jar org.junit.runner.JUnitCore "MyTest"
#java -cp .:junit.jar:j2.jar:json.jar TestRunner || true

cd ../

#echo "-> cleaning up."
clean
#echo "-> Done"
