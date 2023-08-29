package main

import (
	"fmt"
	"time"
)

func hello(ch *string) {
	// Send a string through the channel

	sum := ""
	for i := 0; i < 5; i++ {
		time.Sleep(200 * time.Millisecond)
		sum += "Hello "
	}
	*ch += sum
}

func world(ch *string) {
	sum := ""
	for i := 0; i < 5; i++ {
		sum += "World "
		time.Sleep(300 * time.Millisecond)
	}
	*ch += sum
}

func hello_ch(ch chan string) {
	// Send a string through the channel

	sum := ""
	for i := 0; i < 5; i++ {
		time.Sleep(200 * time.Millisecond)
		sum += "Hello "
	}
	ch <- sum
}

func world_ch(ch chan string) {
	sum := ""
	for i := 0; i < 5; i++ {
		sum += "World "
		time.Sleep(300 * time.Millisecond)
	}
	ch <- sum
}

func main() {
	// Create a channel
	s := ""
	var ch *string = &s

	start := time.Now()
	hello(ch)
	world(ch)
	// msg, msg2 := <-ch, <-ch

	fmt.Println(*ch)
	fmt.Println(time.Since(start))

	// without go routines, functions are now working. hello func executes and result assigned
	// then world func starts working
	// in channel impl,
	ch_ch := make(chan string)

	start_ch := time.Now()
	go hello_ch(ch_ch)
	go world_ch(ch_ch)
	msg, msg2 := <-ch_ch, <-ch_ch

	fmt.Println(msg, msg2)
	fmt.Println(time.Since(start_ch))
}
