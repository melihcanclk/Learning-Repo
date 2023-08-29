package main

import (
	"fmt"
	"time"
)

func sayHello() {
	for i := 0; i < 5; i++ {
		fmt.Println("Hello")
		time.Sleep(2 * time.Second)
	}
}

func sayWorld() {
	for i := 0; i < 5; i++ {
		fmt.Println("World")
		time.Sleep(3 * time.Second)
	}
}

func main() {
	go sayHello()
	sayWorld()

}
