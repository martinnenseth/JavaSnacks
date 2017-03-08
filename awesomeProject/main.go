package main

import (
	"fmt"
	"os"
	"io/ioutil"
	"log"
)



func main() {
	readFile("test.txt")
	writeFile()
}

func readFile(filename string) {
	file, _ := os.Open(filename)

	b, err := ioutil.ReadAll(file)
	if err != nil{
		log.Fatal(err)
	}

	fmt.Printf("%s", b)
}

func writeFile() {
	data := []byte ("heiheihei/n is this a new line?")

	ioutil.WriteFile("test.txt", data, 0777)
}


