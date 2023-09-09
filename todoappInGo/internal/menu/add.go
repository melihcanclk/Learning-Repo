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

func listAddMenu(todoList *todo.TodoList) {
	fmt.Println("Add Menu")
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Print("Enter content: ")
	scanner.Scan()
	content := scanner.Text()

	// ask if user wants to add a deadline
	fmt.Print("Do you want to add a deadline? (y/n): ")
	scanner.Scan()
	choice := scanner.Text()

	var date time.Time
	var err error
	if choice == "y" {
		for choice == "y" {
			fmt.Print("Enter deadline (" + constants.DateTemplateWithTime + " or " + constants.DateTemplateWithoutTime + "): ")
			scanner.Scan()
			deadline := scanner.Text()

			date, err = additional.ConvertStringToDate(deadline)

			if err != nil {
				fmt.Println("Invalid date. Please enter a valid date.")
				fmt.Print("Do you want to add a deadline? (y/n): ")
				scanner.Scan()
				choice = scanner.Text()
			} else {
				choice = "n"
			}

		}
	}

	// ask if user wants to add a priority
	fmt.Print("Do you want to add a priority? (y/n): ")
	scanner.Scan()
	choice = scanner.Text()

	var priority string
	if choice == "y" {
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

	} else {
		priority = ""
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
