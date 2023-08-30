package main

import (
	"fmt"
	"time"
)

func worker(id int, jobs <-chan int, results chan<- int) {

	for j := range jobs {
		fmt.Println("worker", id, "started  job", j)
		time.Sleep(2 * time.Second)
		fmt.Println("worker", id, "finished job", j)
		results <- j * 2
	}
}

func main() {

	numOfJobs := 5
	jobs := make(chan int, 5)
	results := make(chan int, 5)

	for w := 1; w <= 3; w++ {
		go worker(w, jobs, results)
	}

	for j := 1; j <= numOfJobs; j++ {
		jobs <- j
	}

	go func() {
		close(jobs)
	}()

	for a := 1; a <= numOfJobs; a++ {
		fmt.Println(<-results)
	}
}
