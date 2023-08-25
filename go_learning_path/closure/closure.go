package main

import "fmt"

func multByTwo() func() int {
	i := 1

	return func() int {
		i *= 2
		return i
	}
}

func fibonacci() func() int {
	a := 0
	b := 1

	return func() int {
		a, b = b, a+b
		return b - a
	}
}

func fibonacci2() func() int {

	a := -1
	b := 0
	return func() int {
		if a == -1 {
			a, b = b, a+b
			b = 1
		} else {
			a, b = b, a+b
		}
		return a
	}

}

func main() {
	f := fibonacci()
	f2 := fibonacci2()
	for i := 0; i < 10; i++ {
		fmt.Printf("%v - %v", f(), f2())
	}
}
