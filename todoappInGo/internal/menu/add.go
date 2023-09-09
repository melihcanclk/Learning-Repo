package menu

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"time"

	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/additional/constants"
	additional "github.com/melihcanclk/Learning-Repo/todoappInGo/internal/additional/functions"
	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/todo"
)

func getInput(selection string) bool {
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Print("Do you want to add " + selection + "? (y/n): ")
	scanner.Scan()
	choice := scanner.Text()

	for choice != "y" && choice != "n" {
		fmt.Println("Invalid input. Please enter y or n.")
		fmt.Print("Do you want to add " + selection + "? (y/n): ")
		scanner.Scan()
		choice = scanner.Text()
	}

	return choice == "y"
}

func listAddMenu(todoList *todo.TodoList) {
	fmt.Println("Add Menu")
	scanner := bufio.NewScanner(os.Stdin)
	var content string
	var err error
	var date time.Time
	var priority string

	if getInput("content") {
		fmt.Print("Enter content: ")
		scanner.Scan()
		content = scanner.Text()
	}

	var getDeadline bool = getInput("deadline")
	for getDeadline {
		fmt.Print("Enter deadline (" + constants.DateTemplateWithTime + " or " + constants.DateTemplateWithoutTime + "): ")
		scanner.Scan()
		deadline := scanner.Text()
		date, err = additional.ConvertStringToDate(deadline)
		if err != nil {
			fmt.Println(err)
			getDeadline = true
		} else {
			getDeadline = false
		}

	}

	if getInput("priority") {
		var firstPrioInt int
		var lastPrioInt int
		firstPrioInt = constants.Priorities[0]
		lastPrioInt = constants.Priorities[constants.NumberOfPriorities-1]

		fmt.Printf("Enter priority (%d-%d): ", firstPrioInt, lastPrioInt)
		scanner.Scan()
		priority = scanner.Text()

		priorityInt, err := strconv.Atoi(priority)
		if err != nil {
			fmt.Println("Invalid priority. Priority is set to " + strconv.Itoa(firstPrioInt) + ".")
			priority = strconv.Itoa(firstPrioInt)
		} else {
			if priorityInt < firstPrioInt || priorityInt > lastPrioInt {
				fmt.Println("Invalid priority. Priority is set to " + strconv.Itoa(firstPrioInt) + ".")
				priority = strconv.Itoa(firstPrioInt)
			}
		}
	}

	intPriority, err := strconv.Atoi(priority)
	if err != nil {
		fmt.Println("Invalid priority. Priority is set to " + strconv.Itoa(constants.Priorities[0]) + ".")
		intPriority = constants.Priorities[0]
	}

	// add todo to todolist
	todoList.Add(&todo.Todo{
		Context:  content,
		Deadline: date,
		Priority: intPriority,
	})

	fmt.Println("Todo is added successfully.")
}
