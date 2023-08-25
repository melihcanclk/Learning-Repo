package linkedlist

import (
	"errors"
	"fmt"
)

type Node[T comparable] struct {
	next *Node[T]
	val  T
}

type LinkedList[T comparable] struct {
	head   *Node[T]
	length int
}

func (l *LinkedList[T]) Construct() {
	l.head = nil
	l.length = 0
}

func (l *LinkedList[T]) ConstructWithParameter(t T) {
	l.head = &Node[T]{nil, t}
	l.length = 1
}

func (l *LinkedList[T]) Add(t T) {
	node := &Node[T]{nil, t}

	if l.head == nil {
		l.head = node
		return
	}

	temp := l.head
	for temp.next != nil {
		temp = temp.next
	}
	temp.next = node
}

func (l *LinkedList[T]) Remove(t T) (T, error) {
	if l.head == nil {
		return t, errors.New("linkedlist is empty")
	}
	temp := l.head
	for temp.next != nil {
		if temp.next.val == t {
			temp.next = temp.next.next
			return t, nil
		}
		temp = temp.next
	}

	if temp != nil {
		if temp.val == t {
			temp = nil
		}
	}

	return t, errors.New("element not found")
}

func (l LinkedList[T]) String() string {

	var res string
	for l.head != nil {
		res += fmt.Sprintf("%v ", l.head.val)
		l.head = l.head.next
	}
	return res
}

func main() {
	ll := LinkedList[int]{}
	ll.Construct()
	ll.Add(2)
	ll.Add(5)
	ll.Add(6)
	ll.Add(7)
	ll.Add(8)
	fmt.Println(ll)

	ll.Remove(8)
	fmt.Println(ll)

}
