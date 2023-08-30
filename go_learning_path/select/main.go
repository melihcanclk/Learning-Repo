package main

import (
	"fmt"
	"time"
)

func main() {

	c := make(chan string)

	go func() {
		time.Sleep(1 * time.Second)
		c <- "one"
	}()
	go func() {
		time.Sleep(2 * time.Second)
		c <- "two"
	}()

	start := time.Now()
	for i := 0; i < 2; i++ {
		select {
		case msg1 := <-c:
			fmt.Println("received", msg1, time.Since(start))
			
		case msg2 := <-c:
			fmt.Println("received", msg2, time.Since(start))
		}
	}
}
