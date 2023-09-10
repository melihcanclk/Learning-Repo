package constants

import "errors"

var ErrInvalidName error = errors.New("invalid date")
var ErrDateBeforeNow error = errors.New("date is before now")
var ErrNotFound error = errors.New("todo not found")
