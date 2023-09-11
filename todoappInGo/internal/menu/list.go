package menu

import (
	"fmt"

	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/todo"
)

func listMenu(todoList todo.TodoListInterface) {
	fmt.Println(todoList)

}
