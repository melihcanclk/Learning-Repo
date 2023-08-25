package main

import (
	"strings"

	"golang.org/x/tour/wc"
)

func WordCount(s string) map[string]int {
	wordArray := strings.Split(s, " ")
	wordMap := make(map[string]int)

	for i := range wordArray {
		word := wordArray[i]
		elem, ok := wordMap[word]
		if ok {
			wordMap[word] = elem + 1
		} else {
			wordMap[word] = 1
		}
	}

	return wordMap

}

func main() {
	wc.Test(WordCount)
}
