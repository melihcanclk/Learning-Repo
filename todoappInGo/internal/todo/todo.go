package todo

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"time"

	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/additional/constants"
	additional "github.com/melihcanclk/Learning-Repo/todoappInGo/internal/additional/functions"
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

func getInput(selection string) bool {
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Print("Do you want to add " + selection + "? (y/n): ")
	scanner.Scan()
	choice := scanner.Text()

	for choice != "y" && choice != "n" {
		fmt.Println("Invalid input. Please enter y or n.")
		fmt.Print("Do you want to add " + selection + "? (y/n): ")
		scanner.Scan()
		choice = scanner.Text()
	}

	return choice == "y"
}

func CreateTodo() *Todo {
	scanner := bufio.NewScanner(os.Stdin)
	var err error
	var content string
	var date time.Time
	var priority string

	if getInput("content") {
		fmt.Print("Enter content: ")
		scanner.Scan()
		content = scanner.Text()
	}

	var getDeadline bool = getInput("deadline")
	for getDeadline {
		fmt.Print("Enter deadline (" + constants.DateTemplateWithTime + " or " + constants.DateTemplateWithoutTime + "): ")
		scanner.Scan()
		deadline := scanner.Text()
		date, err = additional.ConvertStringToDate(deadline)
		if err != nil {
			fmt.Println(err)
			getDeadline = true
		} else {
			getDeadline = false
		}

	}

	if getInput("priority") {
		var firstPrioInt int
		var lastPrioInt int
		firstPrioInt = constants.Priorities[0]
		lastPrioInt = constants.Priorities[constants.NumberOfPriorities-1]

		fmt.Printf("Enter priority (%d-%d): ", firstPrioInt, lastPrioInt)
		scanner.Scan()
		priority = scanner.Text()

		priorityInt, err := strconv.Atoi(priority)
		if err != nil {
			fmt.Println("Invalid priority. Priority is set to " + strconv.Itoa(firstPrioInt) + ".")
			priority = strconv.Itoa(firstPrioInt)
		} else {
			if priorityInt < firstPrioInt || priorityInt > lastPrioInt {
				fmt.Println("Invalid priority. Priority is set to " + strconv.Itoa(firstPrioInt) + ".")
				priority = strconv.Itoa(firstPrioInt)
			}
		}
	}

	intPriority, err := strconv.Atoi(priority)
	if err != nil {
		fmt.Println("Invalid priority. Priority is set to " + strconv.Itoa(constants.Priorities[0]) + ".")
		intPriority = constants.Priorities[0]
	}

	return &Todo{
		Context:  content,
		Deadline: date,
		Priority: intPriority,
	}

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

// return index of it, if not found, return error
func (t *TodoList) Find(id int) (int, error) {
	for i := range t.Todos {
		if t.Todos[i].Id == id {
			return i, nil
		}
	}

	return -1, constants.ErrNotFound
}

func (t *TodoList) Delete(id int) error {
	index, err := t.Find(id)
	if err != nil {
		return constants.ErrNotFound
	}

	t.Todos = append(t.Todos[:index], t.Todos[index+1:]...)
	return nil
}

func (t *TodoList) Update(id int, todo *Todo) error {
	index, err := t.Find(id)
	if err != nil {
		return err
	}
	t.Todos[index] = *todo
	return nil
}
