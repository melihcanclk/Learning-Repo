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
	time, err := time.Parse(constants.TimeTemplate, date)
	if err != nil {
		return time, err
	}
	return time, nil
}
