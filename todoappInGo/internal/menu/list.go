package menu

import (
	"fmt"

	"github.com/eiannone/keyboard"
	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/todo"
)

func listMenu(todoList *todo.TodoList) error {
	fmt.Println(todoList)
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
