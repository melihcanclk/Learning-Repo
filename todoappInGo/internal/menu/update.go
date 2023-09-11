package menu

import (
	"bufio"
	"fmt"
	"os"
	"strconv"

	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/todo"
)

func listUpdateMenu(todoList todo.TodoListInterface) {
	fmt.Println("Update Menu")
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Print("Enter id that you want to update: ")
	scanner.Scan()
	text := scanner.Text()

	id, err := strconv.Atoi(text)
	if err != nil {
		fmt.Println("Invalid id. Please enter a valid id.")
		return

	}

	todo := todo.CreateTodo()
	todo.Id = id
	err = todoList.Update(id, todo)
	if err != nil {
		fmt.Println(err)
		return
	}

	fmt.Println("Todo is updated.")
}
