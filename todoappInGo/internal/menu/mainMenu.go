package menu

import (
	"bufio"
	"fmt"
	"os"

	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/additional"
	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/todo"
)

func ChoiceMenu(todolist *todo.TodoList, choiceChar string) error {

	scanner := bufio.NewScanner(os.Stdin)
	switch choiceChar {
	case additional.Choices[0]:
		fmt.Print("Enter content of ToDo: ")
		scanner.Scan()
		content := scanner.Text()
		fmt.Println(content)

	case additional.Choices[1]:
		err := listMenu(todolist)
		if err != nil {
			return err
		}

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
	return nil
}
