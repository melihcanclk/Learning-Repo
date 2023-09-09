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
	if checkIfDateIsValid(date, constants.DateTemplateWithTime) {
		return time.Parse(constants.DateTemplateWithTime, date)
	} else if checkIfDateIsValid(date, constants.DateTemplateWithoutTime) {
		return time.Parse(constants.DateTemplateWithoutTime, date)
	} else {
		return time.Time{}, constants.ErrInvalidName
	}
}

func checkIfDateIsValid(date string, template string) bool {
	_, err := time.Parse(template, date)
	return err == nil
}
