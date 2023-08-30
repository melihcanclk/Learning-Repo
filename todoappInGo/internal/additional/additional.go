package additional

import "time"

func GetTimeAfter(time_ref float64) *time.Time {
	duration := time.Duration(time_ref * float64(time.Hour))
	x := time.Now().Add(duration)
	return &x
}
