## Employee

| SurrogateId   | EmployeeId    | Name  | Mobile        | Email         | ReservationCategory  |
| ------------- |:-------------:| -----:| ------------- |:-------------:| ------------------:  |
| 1             | 101010        |Manish | 9XXXXXX0      | mxxxx@abc.com |  Unreserved          |
| 2             | 101011        |Nikhil | 9XXXXXX1      | nxxxx@abc.com |   Executive          |

## Vehicle

| SurrogateId   | VehicleNumber | Type  | EmployeeId    | 
| ------------- |:-------------:| -----:| ------------- |
| 1             | MH14-XXXX1    |4      | 1             | 
| 2             | MH14-XXXX2    |2      | 2             | 


## Slots

| SurrogateId   | VehicleType   | VehicleId  | Status   | ReservationCategory  |
| ------------- |:-------------:| -----:     | :--------: | :------------------:  |
| 1             | 4             |1           | Occupied | Unreserved           |
| 2             | 2             |null            | Unoccupied | Executive            |


