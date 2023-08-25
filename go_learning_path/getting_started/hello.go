package main

import "fmt"

type Vertex struct {
	Long, Latt float64
}

func main() {
	// Set properties of the predefined Logger, including
	// the log entry prefix and a flag to disable printing
	// the time, source file, and line number.
	// log.SetPrefix("greetings: ")
	// log.SetFlags(0)

	// names := []string{"Ahmet", "Mehmet", "Melihcan"}
	// message, err := greetings.Hellos(names)
	// if err != nil {
	// 	log.Fatal(err)
	// }

	// randName := names[rand.Intn(len(names))]

	// fmt.Println(message[randName])

	m := make(map[string]Vertex)
	m["Gebze"] = Vertex{40.68433, -74.39967}
	fmt.Println(m["Gebze"])
}

