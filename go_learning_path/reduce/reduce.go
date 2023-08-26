package reduce

func Reduce[T, M any](s []T, f func(T, M) M, initState M) M {
	acc := initState

	for _, val := range s {
		acc = f(val, acc)
	}

	return acc
}
