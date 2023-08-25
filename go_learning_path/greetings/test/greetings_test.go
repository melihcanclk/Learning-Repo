package main

import (
	"regexp"
	"testing"

	"github.com/melihcanclk/Learning-Repo/go_learning_path/greetings"
)

func TestHelloName(t *testing.T) {
	name := "Melihcan"
	expected := regexp.MustCompile(`\b` + name + `\b`)
	message, err := greetings.Hello("Melihcan")
	if !expected.MatchString(message) || err != nil {
		t.Fatalf(`Hello("Melihcan") = %q, %v, want match for %#q, nil`, message, err, expected)
	}
}

func TestHelloIsEmpty(t *testing.T) {
	name := ""
	message, err := greetings.Hello(name)
	if message != "" || err == nil {
		t.Fatalf(`Hello("") = %q, %v, want "", error`, message, err)
	}
}
