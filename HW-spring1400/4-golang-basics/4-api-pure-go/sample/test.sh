#!/usr/bin/sh

curl --request POST \
    --url http://localhost/calculator \
    --header 'content-type: application/json' \
    --data '{ "task" : "mean" }'

echo ""

curl --request GET \
    --url http://localhost/history \
    --header 'content-type: application/json'

