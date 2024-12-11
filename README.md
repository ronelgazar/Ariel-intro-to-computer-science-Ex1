# Ex1

## Overview

This project implements a number formatting converter and calculator that supports bases from binary (2) to hexadecimal (16). The numbers are represented as strings in the format `<number><b><base>`. For example:
- `135bA` (base 10)
- `100111b2` (base 2)
- `12345b6` (base 6)
- `012b5` (base 5)
- `123bG` (base 16)
- `EFbG` (base 16)

The following are NOT in the correct format:
- `b2`
- `0b1`
- `123b`
- `1234b11`
- `3b3`
- `-3b5`
- `3 b4`
- `GbG`
- ``
- `null`

## Features

- **Validation**: Check if a string is a valid number in the specified format.
- **Conversion**: Convert a number from a string representation in a given base to an integer and vice versa.
- **Arithmetic**: Perform addition and multiplication on numbers in different bases.
- **Equality Check**: Check if two numbers (in different bases) are equal.
- **Maximum Value**: Find the maximum value in an array of numbers represented in different bases.

## Usage

### Running the Program

To run the program, follow these steps:

1. Open the project in IntelliJ.
2. Select `Ex1Main` and press `Run`.

To run the test:

1. Select `Ex1Test` and press `Run`.

**Note**: It is important that JUnit is installed on your machine to run the tests. You can add JUnit to your project by hovering the mouse over the import statements in Ex1Test and clicking on `Install` when prompted by IntelliJ.


### Example Interaction

```sh
Ex1 class solution:
Enter a string as number#1 (or "quit" to end the program): 
1001b2
num1= 1001b2 is number: true , value: 9
Enter a string as number#2 (or "quit" to end the program): 
11b3
num2= 11b3 is number: true , value: 4
Enter a base for output: (a number [2,16])
10
1001b2 + 11b3 = 13
1001b2 * 11b3 = 36
Max number over [1001b2,11b3,13,36] is: 36
```
The program will continue to ask for new numbers until "quit" is entered.
