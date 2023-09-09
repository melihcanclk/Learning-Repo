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
	if checkIfDateIsValidWithTime(date) {
		return time.Parse(constants.DateTemplateWithTime, date)
	} else if checkIfDateIsValidWithoutTime(date) {
		return time.Parse(constants.DateTemplateWithoutTime, date)
	} else {
		return time.Time{}, constants.ErrInvalidName
	}
}

func checkIfDateIsValidWithTime(date string) bool {
	_, err := time.Parse(constants.DateTemplateWithTime, date)
	return err == nil
}

func checkIfDateIsValidWithoutTime(date string) bool {
	_, err := time.Parse(constants.DateTemplateWithoutTime, date)
	return err == nil
}
