package additional

import (
	"time"

	"github.com/melihcanclk/Learning-Repo/todoappInGo/internal/additional/constants"
)

func GetTimeAfter(time_ref float64) *time.Time {
	duration := time.Duration(time_ref * float64(time.Hour))
	x := time.Now().Add(duration)
	return &x
}

func ConvertStringToDate(date string) (time.Time, error) {
	var selection int = 0
	if checkIfDateIsValid(date, constants.DateTemplateWithTime) {
		selection = 1
	}

	if checkIfDateIsValid(date, constants.DateTemplateWithoutTime) {
		selection = 2
	}

	if selection == 0 {
		return time.Time{}, constants.ErrInvalidName
	}

	var err error
	var date_time time.Time
	switch selection {
	case 1:
		date_time, err = time.Parse(constants.DateTemplateWithTime, date)
	case 2:
		date_time, err = time.Parse(constants.DateTemplateWithoutTime, date)

	}

	if err != nil {
		return time.Time{}, err
	}

	// check if date is before now
	if date_time.Before(time.Now()) {
		return time.Time{}, constants.ErrDateBeforeNow
	}

	return date_time, nil
}

func checkIfDateIsValid(date string, template string) bool {
	// if date is before now, return false
	_, err := time.Parse(template, date)
	return err == nil
}
