package todo

import (
	"fmt"
	"time"
)

type Todo struct {
	Id       int
	Context  string
	Deadline time.Time
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

func (t Todo) String() string {
	formatted := fmt.Sprintf("%-5d", t.Id)

	chunks := chunkString(t.Context, 60)

	for i := 0; i < len(chunks); i++ {
		if i == 0 {
			formatted += fmt.Sprintf("|%-60s| -> deadline : %s\n", chunks[i], t.Deadline.Format("02-01-2006 15:04:05"))
		} else {
			formatted += fmt.Sprintf("     |%-60s| \n", chunks[i])
		}
	}
	return formatted
}

func (t TodoList) String() string {
	for _, val := range t.Todos {
		fmt.Println(val)
	}
	return ""
}
