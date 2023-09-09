package menu

import (
	"fmt"
	"os"

	"github.com/eiannone/keyboard"
	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/additional/constants"
	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/todo"
)

func ChoiceMenu(todolist *todo.TodoList, choiceChar string) error {

	switch choiceChar {
	case constants.Choices[0]:
		listAddMenu(todolist)

	case constants.Choices[1]:
		listMenu(todolist)

	case constants.Choices[2]:
		listDeleteMenu(todolist)

	case constants.Choices[3]:
		listUpdateMenu(todolist)

	case constants.Choices[4]:
		fmt.Println("Goodbye!")
		os.Exit(0)
	default:
		fmt.Println("Invalid choice. Please choose a valid option.")
	}
	fmt.Println("Press any key to go back to main menu...")

	if err := keyboard.Open(); err != nil {
		return err
	}
	defer func() {
		_ = keyboard.Close()
	}()

	_, key, err := keyboard.GetKey()

	if err != nil {
		return err
	}

	switch key {
	case keyboard.KeyCtrlC, keyboard.KeyCtrlZ:
		fmt.Println("Interrupted")
		keyboard.Close()
		return fmt.Errorf("interrupted")

	default:
		keyboard.Close()
	}
	return nil
}
