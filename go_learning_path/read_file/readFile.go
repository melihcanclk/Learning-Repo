package main

import (
	"fmt"
	"io"
	"os"
)

func main() {
	r, err := os.Open("test.txt")
	if err != nil {
		panic(err)
	}

	b := make([]byte, 8)
	for {
		n, err := r.Read(b)
		fmt.Printf("n = %v err = %v b = %v\n", n, err, b)
		fmt.Printf("b[:n] = %q\n", b[:n])
		if err == io.EOF {
			break
		}
	}
}
