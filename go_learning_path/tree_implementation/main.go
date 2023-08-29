package main

import (
	"golang.org/x/tour/tree"
	"fmt"
)

// Walk walks the tree t sending all values
// from the tree to the channel ch.
func Walk(t *tree.Tree, ch chan int) {
	if t != nil {
        ch <- t.Value
        Walk(t.Left, ch)
        Walk(t.Right, ch)
    }	
}
// Same determines whether the trees
// t1 and t2 contain the same values.
func Same(t1, t2 *tree.Tree) bool{
	values := make(map[int]bool)
    ch := make(chan int)
    go func() {
        Walk(t1, ch)
        Walk(t2, ch)
        close(ch)
    }()
    for val := range ch {
        if _, ok := values[val]; ok {
            delete(values, val)
        } else {
            values[val] = true
        }
    }
    return len(values) == 0
}

func main() {
	
    fmt.Println(Same(tree.New(1), tree.New(2)))
    fmt.Println(Same(tree.New(1), tree.New(1)))
	
}
