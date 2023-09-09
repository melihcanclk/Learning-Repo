package todo

import (
	"fmt"
	"time"

	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/additional/constants"
)

type Todo struct {
	Id       int
	Context  string
	Deadline time.Time
	Priority int
}

type TodoList struct {
	Todos []Todo
}

func chunkString(s string, chunkSize int) []string {
	var chunks []string
	for len(s) > chunkSize {
		chunks = append(chunks, s[:chunkSize])
		s = s[chunkSize:]
	}
	if len(s) > 0 {
		chunks = append(chunks, s)
	}
	return chunks
}

func (t *Todo) String() string {
	formatted := fmt.Sprintf("%-5d", t.Id)

	chunks := chunkString(t.Context, 60)
	deadline := t.Deadline.Format(constants.DateTemplateWithTime)
	if t.Deadline.IsZero() {
		deadline = "No deadline"
	}

	priority := fmt.Sprintf("%d", t.Priority)

	if len(chunks) == 0 {
		formatted += fmt.Sprintf("|%-60s| -> deadline : %s", "", deadline)
		formatted += fmt.Sprintf(" -> priority : %d\n", t.Priority)
	} else {

		for i := 0; i < len(chunks); i++ {
			if i == 0 {
				formatted += fmt.Sprintf("|%-60s| -> deadline : %s", chunks[i], deadline)
				formatted += fmt.Sprintf(" -> priority : %s\n", priority)
			} else {
				formatted += fmt.Sprintf("     |%-60s| \n", chunks[i])
			}
		}
	}
	// add priority
	return formatted
}

func (t *TodoList) String() string {
	for _, val := range t.Todos {
		fmt.Println(&val)
	}
	return ""
}

func (t *TodoList) Add(todo *Todo) {
	constants.IdConstant++
	todo.Id = constants.IdConstant
	t.Todos = append(t.Todos, *todo)
}
