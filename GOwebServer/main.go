package main

import (
	"github.com/go-martini/martini"
	"github.com/martini-contrib/render"

	"net/http"
	"log"
	"io/ioutil"
)

type Person struct {
	Name string
	Description string
	ServerIP string
}

func main() {
	// Initalize the webserver on the localhost:8001
	m := martini.Classic()



	m.Use(render.Renderer(render.Options{
		IndentJSON: true, //make json readable
	}))


	m.NotFound(func(r render.Render) {
		r.HTML(200, "index", "nope mate")
	})

	m.Get("/", func(r render.Render){
		r.JSON(200, Person{"Martin", "flott fyr!", getServerIP()})
		r.JSON(200, Person{"Martin", "flott fyr!", getServerIP()})
	})

	m.Get("/test", func(r render.Render){
		r.JSON(200, Person{"Martin", "flo111111111111111111r!", getServerIP()})
	})

	m.RunOnAddr(":8001")
	m.Run()


}

func getServerIP() string{
	readApi, err := http.Get("https://api.ipify.org")
	if err != nil {log.Fatal(err)}
	bytes, err := ioutil.ReadAll(readApi.Body)
	if err != nil {log.Fatal(err)}
	return string(bytes)
}
