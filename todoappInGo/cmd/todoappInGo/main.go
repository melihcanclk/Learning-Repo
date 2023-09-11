package main

import (
	additional "github.com/melihcanclk/Learning-Repo/todoappInGo/internal/additional/functions"
	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/menu"
	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/todo"
)

func main() {
	var todolist todo.TodoList

	todo1 := &todo.Todo{
		Id:       1,
		Context:  "asdasdasddasasdasdasddasasdasdasddasas",
		Deadline: *additional.GetTimeAfter(5.4),
	}
	todo2 := &todo.Todo{
		Id:       1,
		Context:  "asdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddasasdasdasddas",
		Deadline: *additional.GetTimeAfter(5.4),
	}
	todolist.Add(todo1)
	todolist.Add(todo2)

	if err := menu.RunMenu(&todolist); err != nil {
		panic(err)
	}
}
