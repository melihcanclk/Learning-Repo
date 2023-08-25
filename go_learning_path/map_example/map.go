package main

import (
	"fmt"
	"strings"
)

type IPAddr [4]byte

// TODO: Add a "String() string" method to IPAddr.
func (i IPAddr) String() string {
	// concat ip address
	var ip string
	for _, v := range i {
		ip += fmt.Sprintf("%v.", v)
	}
	// remove last dot
	ip = strings.TrimSuffix(ip, ".")
	return ip
}

func main() {
	hosts := map[string]IPAddr{
		"loopback":  {127, 0, 0, 1},
		"googleDNS": {8, 8, 8, 8},
	}
	for name, ip := range hosts {
		fmt.Printf("%v: %v\n", name, ip)
	}
}
