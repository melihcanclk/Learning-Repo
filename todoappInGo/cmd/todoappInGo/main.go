package main

import (
	"bufio"
	"fmt"
	"os"

	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/additional"
	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/todo"
)

var todolist todo.TodoList

func main() {
	scanner := bufio.NewScanner(os.Stdin)

	todo1 := &todo.Todo{
		Id:       1,
		Context:  "asdasdasdas",
		Deadline: *additional.GetTimeAfter(5.4),
	}
	todolist.Todos = append(todolist.Todos, *todo1)

	for {
		fmt.Println("\nChoose an action:")
		fmt.Println("1. Add Item")
		fmt.Println("2. List Items")
		fmt.Println("3. Delete Item")
		fmt.Println("4. Update Item")
		fmt.Println("5. Quit")

		scanner.Scan()
		choice := scanner.Text()

		switch choice {
		case "1":
			fmt.Print("Enter item title: ")
			scanner.Scan()
			title := scanner.Text()
			fmt.Println(title)
		case "2":
			fmt.Println(todolist)

		case "3":
			fmt.Print("Enter item ID to delete: ")
			scanner.Scan()
			id := scanner.Text()
			fmt.Println(id)
		case "4":
			fmt.Print("Enter item ID to update: ")
			scanner.Scan()
			id := scanner.Text()
			fmt.Println(id)

		case "5":
			fmt.Println("Goodbye!")
			os.Exit(0)
		default:
			fmt.Println("Invalid choice. Please choose a valid option.")
		}
	}
}
