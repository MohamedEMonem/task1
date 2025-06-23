# Java Console Calculator

A simple yet powerful console-based calculator implementation in Java that supports basic arithmetic operations with proper operator precedence.

## Features

- Basic arithmetic operations (addition, subtraction, multiplication, division)
- Proper operator precedence handling
- Continuous calculation mode until user exits
- Error handling for:
  - Division by zero
  - Invalid input format
  - Invalid numbers
  - Invalid operators
- Method overloading demonstration
- User-friendly interface

## How to Use

1. Compile and run the program
2. Enter mathematical expressions with spaces between numbers and operators
   - Example: `2 + 2 - 1 * 3 / 4`
3. Type 'exit' to quit the calculator

## Project Structure

- `src/App.java`: Contains the main calculator implementation
- `lib/`: Folder for dependencies (if any)
- `bin/`: Contains compiled class files

## Technical Implementation Details

The calculator implements the following key concepts:

1. **Object-Oriented Programming**
   - Modular code structure
   - Method overloading for the add() method

2. **Data Structures**
   - Uses Stack for operator precedence handling
   - Arrays for token processing

3. **Error Handling**
   - Try-catch blocks for robust error management
   - Specific exception handling for different error cases

4. **Input/Output**
   - Scanner class for user input
   - Formatted output using printf

## Code Highlights

- **Method Overloading**: Demonstrated with two versions of the add() method
- **Error Handling**: Comprehensive exception handling for various error cases
- **Operator Precedence**: Proper implementation of mathematical operator precedence
- **Input Validation**: Robust input checking and validation

## Development Environment

- Java Development Kit (JDK)
- Visual Studio Code
- No external dependencies required

## Author

[Your Name]

## License

This project is open source and available under the MIT License.

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
