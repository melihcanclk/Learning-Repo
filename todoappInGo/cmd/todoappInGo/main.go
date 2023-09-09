package main

import (
	"bufio"
	"fmt"
	"os"

	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/additional"
	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/todo"

	"github.com/eiannone/keyboard"
)

var todolist todo.TodoList

func choice(choiceChar string) {

	scanner := bufio.NewScanner(os.Stdin)
	switch choiceChar {
	case additional.Choices[0]:
		fmt.Print("Enter item title: ")
		scanner.Scan()
		title := scanner.Text()
		fmt.Println(title)
	case additional.Choices[1]:
		fmt.Println(todolist)

	case additional.Choices[2]:
		fmt.Print("Enter item ID to delete: ")
		scanner.Scan()
		id := scanner.Text()
		fmt.Println(id)
	case additional.Choices[3]:
		fmt.Print("Enter item ID to update: ")
		scanner.Scan()
		id := scanner.Text()
		fmt.Println(id)

	case additional.Choices[4]:
		fmt.Println("Goodbye!")
		os.Exit(0)
	default:
		fmt.Println("Invalid choice. Please choose a valid option.")
	}
}

func runMenu() error {

	selectedIndex := 0

	for {
		if err := keyboard.Open(); err != nil {
			return err
		}
		defer func() {
			_ = keyboard.Close()
		}()
		// Clear the screen
		fmt.Print(additional.SCREEN_CLEAR)

		// Print the menu with selection
		for index, choice := range additional.Choices {
			if index == selectedIndex {
				fmt.Printf("➡ %s\n", choice)
			} else {
				fmt.Printf("   %s\n", choice)
			}
		}

		_, key, err := keyboard.GetKey()
		if err != nil {
			return err
		}

		switch key {
		case keyboard.KeyArrowUp:
			if selectedIndex > 0 {
				selectedIndex--
			}

		case keyboard.KeyArrowDown:
			if selectedIndex < len(additional.Choices)-1 {
				selectedIndex++
			}

		case keyboard.KeyCtrlC, keyboard.KeyCtrlZ:
			fmt.Println("Interrupted")
			keyboard.Close()

			return nil

		case keyboard.KeyEnter:
			if selectedIndex == len(additional.Choices)-1 {
				fmt.Println("Goodbye!")
				return nil
			}
			// Call the corresponding function based on selectedIndex
			fmt.Printf("You choose: %s\n", additional.Choices[selectedIndex])
			keyboard.Close()
			// wait 2 seconds for simulation purpose
			choice(additional.Choices[selectedIndex])
		default:
			fmt.Println("Use the arrow keys to navigate and press Enter to select.")
		}

	}
}

func main() {

	todo1 := &todo.Todo{
		Id:       1,
		Context:  "asdasdasdas",
		Deadline: *additional.GetTimeAfter(5.4),
	}
	todolist.Todos = append(todolist.Todos, *todo1)

	if err := runMenu(); err != nil {
		panic(err)
	}
}
