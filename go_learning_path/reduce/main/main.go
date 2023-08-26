package main

import (
	"fmt"

	"github.com/melihcanclk/Learning-Repo/go_learning_path/reduce"
)

func main() {

	arr := []int{4, 53, 6, 27, 98, 234}

	res := reduce.Reduce(arr, func(acc int, cur int) int {
		return acc + cur
	}, 0)

	fmt.Println(res)
}
