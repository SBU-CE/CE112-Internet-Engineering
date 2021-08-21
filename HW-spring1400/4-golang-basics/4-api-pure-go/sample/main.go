package main

import (
	"encoding/json"
	"fmt"
	"log"
	"net/http"
)

type History struct {
	Size int `json:"size"`
}

type Request struct {
	Task string `json:"task"`
}

type Reponse struct {
	Task    string `json:"Task"`
	Code    int    `json:"code"`
	Message string `json:"message"`
}

var history History = History{
	Size: 0,
}

func calculatorHandler(w http.ResponseWriter, req *http.Request) {
	if req.Method != "POST" {
		w.WriteHeader(405)
		fmt.Fprintf(w, "405 error : method not allowed\n")
		// TODO : send json instead
		return
	}

	var request Request
	err := json.NewDecoder(req.Body).Decode(&request)
	if err != nil {
		w.WriteHeader(400)
		fmt.Fprintf(w, "400 error : bad request\n")
		// TODO : send json instead
		return
	}

	// here we can use request

	history.Size++
	response := Reponse{
		Task:    request.Task,
		Code:    200,
		Message: "Task done successfully!",
	}

	w.WriteHeader(200)
	jsonBytes, err := json.Marshal(response)
	if err != nil {
		// TODO : handle error
	}
	w.Write(jsonBytes)
}

func historyHandler(w http.ResponseWriter, req *http.Request) {
	if req.Method != "GET" {
		w.WriteHeader(405)
		fmt.Fprintf(w, "405 error : method not allowed\n")
		// TODO : send json instead
		return
	}
	w.WriteHeader(200)
	jsonBytes, err := json.Marshal(history)
	if err != nil {
		// TODO : handle error
	}
	w.Write(jsonBytes)
}

func notFoundHandler(w http.ResponseWriter, req *http.Request) {
	w.WriteHeader(404)
	fmt.Fprintf(w, "404 error : not found\n")
	// TODO : send json instead
}

func main() {

	http.HandleFunc("/calculator", calculatorHandler)
	http.HandleFunc("/history", historyHandler)
	http.HandleFunc("/", notFoundHandler)

	log.Fatal(http.ListenAndServe(":80", nil))
}
