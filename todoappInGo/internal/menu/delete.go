package menu

import (
	"bufio"
	"fmt"
	"os"

	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/todo"
)

func listDeleteMenu(todoList *todo.TodoList) {
	fmt.Println("Delete Menu")
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Print("Enter item name: ")
	scanner.Scan()
	name := scanner.Text()
	fmt.Println(name)
}
