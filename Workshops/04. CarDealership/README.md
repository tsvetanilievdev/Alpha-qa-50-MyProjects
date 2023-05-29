## OOP Workshop - Car Dealership

## Preface

Before you start coding, read this document from top to bottom. It has some valuable information that will make your work way easier.

## Description

Implement a vehicle tracking system for a famous car dealership called `Safe Travel`. The application already accepts commands and outputs text for each submitted command, what you need to do is build the OO classes hierarchy. The user can create different models (`Car, Motorcycle, Train`), as well as list them. Make sure to follow the Object Orientated Programming best practices and conventions that we have talked about during the lectures.

## Architecture

Your task is to design an object-oriented class hierarchy to model the Dealership, using the best practices for object-oriented design (OOD) and object-oriented programming (OOP). Avoid duplicated code though abstraction, inheritance, and polymorphism and encapsulate correctly all fields.

Your focus should be on the `models` packages, where you need to finish the already created classes, using the provided interfaces in the `contracts` package.

You are given **all** Java interfaces that you need (`Vehicle`, `Car`, `Motorcycle`, `Truck`).

## Models

> Note: All validation intervals are inclusive (closed).

### Fields and Validation

There are three types of vehicles in the Car Dealership for now, **Car**, **Motorcycle** and **Truck**.

#### **Car**

- `Make` - a string with length between `2` and `15`.
- `Model` - a string with length between `1` and `15`.
- `Price` - a number between `0.0` and `1000000.0`.
- `Seats` - a number between `1` and `10`.
- `Wheels` are always `4`
- Should be convertible to **String** in the format:

```none
#. Car:
Make: VALUE
Model: VALUE
Wheels: VALUE
Price: VALUE
Seats: VALUE
```

#### **Motorcycle**

- `Make` - a string with length between `2` and `15`.
- `Model` - a string with length between `1` and `15`.
- `Price` - a number between `0.0` and `1000000.0`.
- `Category` - a string with length between `3` and `10`.
- `Wheels` are always `2`
- Should be convertible to **String** in the format:

```none
#. Motorcycle:
Make: VALUE
Model: VALUE
Wheels: VALUE
Price: VALUE
Category: VALUE
```

#### **Truck**

- `Make` - a string with length between `2` and `15`.
- `Model` - a string with length between `1` and `15`.
- `Price` - a number between `0.0` and `1000000.0`.
- `Weigth Capacity` - a string with length between `1` and `100`.
- `Wheels` are always `8`
- Should be convertible to **String** in the format:

```none
#. Truck:
Make: VALUE
Model: VALUE
Wheels: VALUE
Price: VALUE
Weigth Capacity: VALUE
```

There is also **User** and **Comment**.

#### **User**

- `Username`
- `First Name`
- `Last Name`
- `Password`
- `User role` - an enum of type `Normal`, `VIP` or `Admin`
   - If the user is admin he cannot add a vehicle
   - If the user is not VIP he cannot add more than 5 vehicles
- `Vehicle`

- The users can **AddVehicle**, **RemoveVehicle**, **AddComment** and **RemoveComment**
- Every user has collection of **Vehicles** and every **Vehicle** in this collection has collection of **Comments**.
- Users should **register** and **login** before doing anything in the Car Dealership.
If a user is not logged or there is another user logged in he cannot do anything.

#### **Comment**

- `Author`
- `Content` - a string with length between `3` and `200`.
- Should be convertible to **String** in the format:

```none
----------
VALUE
User: VALUE
----------
```

**IMPORTANT**: In order to successfully build the project you need to implement the hierarchy first!

### Printing

```none
--USER {Username}--
1. {Vehicle type}:
Make: {Make}
Model: {Model}
Wheels: {Wheels}
Price: ${Price}
Category/Weight capacity/Seats: {Category/Weight capacity/Seats}
--COMMENTS--
----------
{Content}
User: {Comment Username}
----------
----------
{Content}
User: {Comment username}
----------
--COMMENTS--
2. {Vehicle type}:
Make: {Make}
Model: {Model}
Wheels: {Wheels}
Price: ${Price}
Category/Weight capacity/Seats: {Category/Weight capacity/Seats}
--NO COMMENTS--
```

- Price has `$` in front of the value and has no trailing zeros *(e.g. `Price: $10000`)*
- This is already done for you. You don't need to change anything, but you can try to follow the logic behind the solution implemented!

```
Example:
Price: $10000
```
> Hint: Trailing zeros are removed by this method:

```java
public static String removeTrailingZerosFromDouble(double number) {
    BigDecimal num = BigDecimal.valueOf(number).stripTrailingZeros();
    return num.toPlainString();
}
```

- The weight capacity has `t` after the value *(e.g. `Weight capacity: 40t`)*
- **Look into the example below to get better understanding of the printing format.**

### Additional Notes

Currently, the engine supports the following commands:

- **RegisterUser** **(username, firstName, lastName, password, role)** - registers user, if there is no such user already
- **Login** **(username, password)** - logs in user if there is no already logged in and there is such registered user
- **Logout** - logs out the current logged in user
- **AddVehicle** **(type, make, model, price, [category/seats/weightCapacity])** - adds a vehicle to the current user. The fourth parameter depends on the type of the vehicle
- **RemoveVehicle** **(vehicleIndex)** - remove the vehicle on that index if there is such
- **AddComment** **(content, author, vehicleIndex)** - add a comment with the content provided to the vehicle with that index and sets the author
- **RemoveComment** **(vehicleIndex, commentIndex, username)** - removes the comment from the vehicle
- **ShowUsers** - shows all the users registered
- **ShowVehicles** **(username)** - shows all the vehicles of the user

**All commands return appropriate success messages. In case of invalid operation or error, the engine returns appropriate error messages.**

### Constraints

- You are allowed to create new and modify existing **classes** in the `models` package.
- You are allowed to modify the **VehicleDealershipRepositoryImpl**.
- ***You are NOT allowed to modify any other existing interfaces!***
- ***You are NOT allowed to modify any other existing classes, enumerations and packages!***

### Step by step guide
1. If you try to build the Skeleton it won't compile. Do not worry.
2. Navigate to the `models` package.
Inspect what classes are there and think about what interfaces do they need to implement.
Is there an opportunity to introduce an abstract class?
3. After implementing and encapsulating the needed models head over to the `VehicleDealershipRepositoryImpl` class.
> Hint: Like in Hansel & Gretel follow the crumbs - `TODOs` and `UnsupportedOperationException`
### Sample Input

```none
RegisterUser p Petar Petrov 123456
RegisterUser pesh0= Petar Petrov 123456
RegisterUser pesh0 Petar Petrov 1234
RegisterUser pesh0 Petar P 123456
RegisterUser pesh0 P Petrov 123456
RegisterUser pesho Petar Petrov 123456
AddVehicle Motorcycle K Z1000 9999 Race
AddVehicle Motorcycle Kawasaki Z1000 -1000 Race
AddVehicle Motorcycle Kawasaki Z1000 9999 N
AddVehicle Car Opel Vectra 5000 -1
AddVehicle Truck Volvo FH4 11800 200
AddVehicle Motorcycle Kawasaki Z 9999 Race
AddVehicle Car Opel Vectra 5000 5
AddVehicle Car Mazda 6 10000 5
AddVehicle Motorcycle Suzuki V-Strom 7500 CityEnduro
AddVehicle Car BMW Z3 11200 2
AddVehicle Car BMW Z3 11200 2
AddVehicle Car BMW Z3 11200 2
AddComment {{U}} pesho 1
AddComment {{Amazing speed and handling!}} pesho 1
ShowUsers
RegisterUser pesho Petar Petrov 123457
Logout
RegisterUser pesho Petar Petrov 123457
RegisterUser gosho Georgi Georgiev 123457 VIP
Logout
Login pesho 123456
Login gosho 123457
Logout
Login gosho 123457
AddComment {{I like this one! It is faster than all the rest!}} pesho 1
RemoveComment 1 1 pesho
RemoveComment 2 5 pesho
AddVehicle Motorcycle Suzuki GSXR1000 8000 Racing
AddVehicle Car Skoda Fabia 2000 5
AddVehicle Car BMW 535i 7200 5
AddVehicle Motorcycle Honda Hornet600 4150 Race
AddVehicle Car Mercedes S500L 15000 5
AddVehicle Car Opel Zafira 8000 5
AddVehicle Car Opel Zafira 7450 5
AddVehicle Truck Volvo FH4 11800 40
ShowUsers
Logout
RegisterUser ivancho Ivan Ivanov admin Admin
AddVehicle Car Skoda Fabia 2000 5
ShowUsers
ShowVehicles gosho
ShowVehicles ivanch0
AddComment {{Empty comment}} pencho 1
AddComment {{Empty comment}} pesho 20
RemoveComment 1 1 pesho
ShowVehicles pesho
Logout
Login pesho 123456
AddComment {{I dream of having this one one day.}} pesho 1
Logout
Login ivancho admin
AddComment {{What is the mileage on it?}} pesho 3
Logout
Login pesho 123456
AddComment {{This one passed my by on the highway today. So pretty!}} pesho 3
ShowVehicles pesho
ShowVehicles gosho
ShowVehicles ivancho
Logout
Login gosho 123457
RemoveComment 1 2 pesho
ShowVehicles pesho
Logout
Login pesho 123456
RemoveVehicle 1
ShowVehicles pesho
Exit

```

### Sample Output

```none
Username must be between 2 and 20 characters long!
####################
Username contains invalid symbols!
####################
Password must be between 5 and 30 characters long!
####################
Lastname must be between 2 and 20 characters long!
####################
Firstname must be between 2 and 20 characters long!
####################
User pesho registered successfully!
####################
Make must be between 2 and 15 characters long!
####################
Price must be between 0.0 and 1000000.0!
####################
Category must be between 3 and 10 characters long!
####################
Seats must be between 1 and 10!
####################
Weight capacity must be between 1 and 100!
####################
pesho added vehicle successfully!
####################
pesho added vehicle successfully!
####################
pesho added vehicle successfully!
####################
pesho added vehicle successfully!
####################
pesho added vehicle successfully!
####################
You are not VIP and cannot add more than 5 vehicles!
####################
You are not VIP and cannot add more than 5 vehicles!
####################
Content must be between 3 and 200 characters long!
####################
pesho added comment successfully!
####################
You are not an admin!
####################
User pesho is logged in! Please log out first!
####################
You logged out!
####################
User pesho already exist. Choose a different username!
####################
User gosho registered successfully!
####################
You logged out!
####################
User pesho successfully logged in!
####################
User pesho is logged in! Please log out first!
####################
You logged out!
####################
User gosho successfully logged in!
####################
gosho added comment successfully!
####################
You are not the author of the comment you are trying to remove!
####################
There is no comment on this index.
####################
gosho added vehicle successfully!
####################
gosho added vehicle successfully!
####################
gosho added vehicle successfully!
####################
gosho added vehicle successfully!
####################
gosho added vehicle successfully!
####################
gosho added vehicle successfully!
####################
gosho added vehicle successfully!
####################
gosho added vehicle successfully!
####################
You are not an admin!
####################
You logged out!
####################
User ivancho registered successfully!
####################
You are an admin and therefore cannot add vehicles!
####################
--USERS--
1. Username: pesho, FullName: Petar Petrov, Role: Normal
2. Username: gosho, FullName: Georgi Georgiev, Role: VIP
3. Username: ivancho, FullName: Ivan Ivanov, Role: Admin
####################
--USER gosho--
1. Motorcycle:
Make: Suzuki
Model: GSXR1000
Wheels: 2
Price: $8000
Category: Racing
--NO COMMENTS--
2. Car:
Make: Skoda
Model: Fabia
Wheels: 4
Price: $2000
Seats: 5
--NO COMMENTS--
3. Car:
Make: BMW
Model: 535i
Wheels: 4
Price: $7200
Seats: 5
--NO COMMENTS--
4. Motorcycle:
Make: Honda
Model: Hornet600
Wheels: 2
Price: $4150
Category: Race
--NO COMMENTS--
5. Car:
Make: Mercedes
Model: S500L
Wheels: 4
Price: $15000
Seats: 5
--NO COMMENTS--
6. Car:
Make: Opel
Model: Zafira
Wheels: 4
Price: $8000
Seats: 5
--NO COMMENTS--
7. Car:
Make: Opel
Model: Zafira
Wheels: 4
Price: $7450
Seats: 5
--NO COMMENTS--
8. Truck:
Make: Volvo
Model: FH4
Wheels: 8
Price: $11800
Weight Capacity: 40t
--NO COMMENTS--
####################
There is no user with username ivanch0!
####################
There is no user with username pencho!
####################
The vehicle does not exist!
####################
You are not the author of the comment you are trying to remove!
####################
--USER pesho--
1. Motorcycle:
Make: Kawasaki
Model: Z
Wheels: 2
Price: $9999
Category: Race
--COMMENTS--
----------
Amazing speed and handling!
User: pesho
----------
----------
I like this one! It is faster than all the rest!
User: gosho
----------
--COMMENTS--
2. Car:
Make: Opel
Model: Vectra
Wheels: 4
Price: $5000
Seats: 5
--NO COMMENTS--
3. Car:
Make: Mazda
Model: 6
Wheels: 4
Price: $10000
Seats: 5
--NO COMMENTS--
4. Motorcycle:
Make: Suzuki
Model: V-Strom
Wheels: 2
Price: $7500
Category: CityEnduro
--NO COMMENTS--
5. Car:
Make: BMW
Model: Z3
Wheels: 4
Price: $11200
Seats: 2
--NO COMMENTS--
####################
You logged out!
####################
User pesho successfully logged in!
####################
pesho added comment successfully!
####################
You logged out!
####################
User ivancho successfully logged in!
####################
ivancho added comment successfully!
####################
You logged out!
####################
User pesho successfully logged in!
####################
pesho added comment successfully!
####################
--USER pesho--
1. Motorcycle:
Make: Kawasaki
Model: Z
Wheels: 2
Price: $9999
Category: Race
--COMMENTS--
----------
Amazing speed and handling!
User: pesho
----------
----------
I like this one! It is faster than all the rest!
User: gosho
----------
----------
I dream of having this one one day.
User: pesho
----------
--COMMENTS--
2. Car:
Make: Opel
Model: Vectra
Wheels: 4
Price: $5000
Seats: 5
--NO COMMENTS--
3. Car:
Make: Mazda
Model: 6
Wheels: 4
Price: $10000
Seats: 5
--COMMENTS--
----------
What is the mileage on it?
User: ivancho
----------
----------
This one passed my by on the highway today. So pretty!
User: pesho
----------
--COMMENTS--
4. Motorcycle:
Make: Suzuki
Model: V-Strom
Wheels: 2
Price: $7500
Category: CityEnduro
--NO COMMENTS--
5. Car:
Make: BMW
Model: Z3
Wheels: 4
Price: $11200
Seats: 2
--NO COMMENTS--
####################
--USER gosho--
1. Motorcycle:
Make: Suzuki
Model: GSXR1000
Wheels: 2
Price: $8000
Category: Racing
--NO COMMENTS--
2. Car:
Make: Skoda
Model: Fabia
Wheels: 4
Price: $2000
Seats: 5
--NO COMMENTS--
3. Car:
Make: BMW
Model: 535i
Wheels: 4
Price: $7200
Seats: 5
--NO COMMENTS--
4. Motorcycle:
Make: Honda
Model: Hornet600
Wheels: 2
Price: $4150
Category: Race
--NO COMMENTS--
5. Car:
Make: Mercedes
Model: S500L
Wheels: 4
Price: $15000
Seats: 5
--NO COMMENTS--
6. Car:
Make: Opel
Model: Zafira
Wheels: 4
Price: $8000
Seats: 5
--NO COMMENTS--
7. Car:
Make: Opel
Model: Zafira
Wheels: 4
Price: $7450
Seats: 5
--NO COMMENTS--
8. Truck:
Make: Volvo
Model: FH4
Wheels: 8
Price: $11800
Weight Capacity: 40t
--NO COMMENTS--
####################
--USER ivancho--
--NO VEHICLES--
####################
You logged out!
####################
User gosho successfully logged in!
####################
gosho removed comment successfully!
####################
--USER pesho--
1. Motorcycle:
Make: Kawasaki
Model: Z
Wheels: 2
Price: $9999
Category: Race
--COMMENTS--
----------
Amazing speed and handling!
User: pesho
----------
----------
I dream of having this one one day.
User: pesho
----------
--COMMENTS--
2. Car:
Make: Opel
Model: Vectra
Wheels: 4
Price: $5000
Seats: 5
--NO COMMENTS--
3. Car:
Make: Mazda
Model: 6
Wheels: 4
Price: $10000
Seats: 5
--COMMENTS--
----------
What is the mileage on it?
User: ivancho
----------
----------
This one passed my by on the highway today. So pretty!
User: pesho
----------
--COMMENTS--
4. Motorcycle:
Make: Suzuki
Model: V-Strom
Wheels: 2
Price: $7500
Category: CityEnduro
--NO COMMENTS--
5. Car:
Make: BMW
Model: Z3
Wheels: 4
Price: $11200
Seats: 2
--NO COMMENTS--
####################
You logged out!
####################
User pesho successfully logged in!
####################
pesho removed vehicle successfully!
####################
--USER pesho--
1. Car:
Make: Opel
Model: Vectra
Wheels: 4
Price: $5000
Seats: 5
--NO COMMENTS--
2. Car:
Make: Mazda
Model: 6
Wheels: 4
Price: $10000
Seats: 5
--COMMENTS--
----------
What is the mileage on it?
User: ivancho
----------
----------
This one passed my by on the highway today. So pretty!
User: pesho
----------
--COMMENTS--
3. Motorcycle:
Make: Suzuki
Model: V-Strom
Wheels: 2
Price: $7500
Category: CityEnduro
--NO COMMENTS--
4. Car:
Make: BMW
Model: Z3
Wheels: 4
Price: $11200
Seats: 2
--NO COMMENTS--
####################
```