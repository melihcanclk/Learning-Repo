package menu

import (
	"fmt"

	"github.com/eiannone/keyboard"
	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/additional/constants"
	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/todo"
)

func RunMenu(todoList todo.TodoListInterface) error {

	selectedIndex := 0

	for {
		if err := keyboard.Open(); err != nil {
			return err
		}
		defer func() {
			_ = keyboard.Close()
		}()
		// Clear the screen
		fmt.Print(constants.SCREEN_CLEAR)

		// Print the menu with constants
		for index, choice := range constants.Choices {
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

			if selectedIndex == 0 {
				selectedIndex = len(constants.Choices) - 1
			} else if selectedIndex > 0 {
				selectedIndex--
			}

		case keyboard.KeyArrowDown:

			if selectedIndex == len(constants.Choices)-1 {
				selectedIndex = 0
			} else if selectedIndex < len(constants.Choices)-1 {
				selectedIndex++
			}

		case keyboard.KeyCtrlC, keyboard.KeyCtrlZ:
			fmt.Println("Interrupted")
			keyboard.Close()
			return nil

		case keyboard.KeyEnter:
			if selectedIndex == len(constants.Choices)-1 {
				fmt.Println("Goodbye!")
				return nil
			}
			// Call the corresponding function based on selectedIndex
			fmt.Printf("You choose: %s\n", constants.Choices[selectedIndex])
			keyboard.Close()
			// wait 2 seconds for simulation purpose
			err := ChoiceMenu(todoList, constants.Choices[selectedIndex])
			if err != nil {
				if err.Error() == "interrupted" {
					keyboard.Close()
					return nil
				}
				return err
			}
		default:
			fmt.Println("Use the arrow keys to navigate and press Enter to select.")
		}

	}
}
