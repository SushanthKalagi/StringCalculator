
# String Calculator

This project implements the [String Calculator](https://codingdojo.org/kata/StringCalculator/) in Java.

## Features

- Add, subtract, and multiply numbers from a string input.
- Supports custom delimiters (e.g., `//;\n1;2;3`).
- Handles newlines and commas as default delimiters.
- Throws exceptions for invalid input and negative numbers.

## Usage

The main logic is in the `StringCalculator` class (`src/main/java/sushanth/dac/StringCalculator.java`).

Example:
```java
StringCalculator calculator = new StringCalculator();
calculator.input = "1,2,3";
String sum = calculator.add(); // "6"
String diff = calculator.sub(); // "-4"
String product = calculator.mul(); // "6"