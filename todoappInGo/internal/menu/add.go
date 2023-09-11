package menu

import (
	"fmt"

	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/todo"
)

func listAddMenu(todoList *todo.TodoList) {
	fmt.Println("Add Menu")
	todo := todo.CreateTodo()
	todoList.Add(todo)
	fmt.Println("Todo is added successfully.")
}
