package menu

import (
	"bufio"
	"fmt"
	"os"
	"strconv"

	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/todo"
)

func listDeleteMenu(todoList todo.TodoListInterface) {
	fmt.Println("Delete Menu")
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Print("Enter ID of todo that you want to delete: ")
	scanner.Scan()
	name := scanner.Text()

	id, err := strconv.Atoi(name)
	if err != nil {
		fmt.Printf("cannot convert %s to id", name)
		return
	}

	err = todoList.Delete(id)
	if err != nil {
		fmt.Println(err)
		return
	}

}
