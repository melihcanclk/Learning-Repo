package constants

import (
	"errors"
)

const SCREEN_CLEAR string = "\033[H\033[2J"

var Choices = []string{
	"Add Item",
	"List Items",
	"Delete Item",
	"Update Item",
	"Quit",
}

var Priorities = []int{}
var NumberOfPriorities = 5

func init() {
	for i := 1; i <= NumberOfPriorities; i++ {
		Priorities = append(Priorities, i)
	}
}

var DateTemplateWithTime = "02/01/2006 - 15:04:00"
var DateTemplateWithoutTime = "02/01/2006"

var IdConstant = 0

var ErrInvalidName error = errors.New("invalid date")
