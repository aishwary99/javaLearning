# Java Functional Programming with Streams

This repository contains code examples and explanations for functional programming concepts in Java, with a focus on Java 8 features such as Streams, Lambdas, and Functional Interfaces.

## Table of Contents

1. [Introduction](#introduction)
2. [Examples](#examples)
   - [Example 1: Filtering and Mapping](#example-1-filtering-and-mapping)
   - [Example 2: Squaring Numbers and String Operations](#example-2-squaring-numbers-and-string-operations)
   - [Example 3: Using Reduce and Comparator](#example-3-using-reduce-and-comparator)
   - [Example 4: Collecting to List](#example-4-collecting-to-list)
   - [Example 5: Introduction to Functional Interfaces](#example-5-introduction-to-functional-interfaces)
   - [Example 6: Exploring Other Functional Interfaces](#example-6-exploring-other-functional-interfaces)
   - [Example 7: Method References](#example-7-method-references)
3. [Functional Programming Concepts](#functional-programming-concepts)
   - [Lambdas](#lambdas)
   - [Functional Interfaces](#functional-interfaces)
   - [Streams](#streams)
   - [Predicate](#predicate)
   - [Function](#function)
   - [Consumer](#consumer)
   - [BinaryOperator](#binaryoperator)
   - [Supplier](#supplier)
   - [UnaryOperator](#unaryoperator)
   - [BiPredicate, BiFunction, BiConsumer](#bipredicate-bifunction-biconsumer)
4. [How to Use](#how-to-use)

## Introduction

Functional programming is a programming paradigm that treats computation as the evaluation of mathematical functions and avoids changing-state and mutable data. In Java, functional programming features were introduced in Java 8, including Streams and Lambda Expressions. This repository serves as a guide to understanding and using these features effectively.

## Examples

### Example 1: Filtering and Mapping

In this example, we demonstrate how to use Streams to filter and print even numbers from a list and filter and print specific courses.

```
// Code example for filtering and mapping even numbers and courses
public static void printOddNumbersInList(List<Integer> numbers) {
    numbers.stream()
        .filter(number -> number % 2 == 0) // Filtering even numbers
        .forEach(System.out::println);     // Printing each even number
}

public static void printCoursesInList(List<String> courses) {
    courses.stream()
        .filter(course -> course.length() >= 4)  // Filtering courses with length >= 4
        .filter(course -> course.startsWith("S")) // Filtering courses starting with "S"
        .forEach(System.out::println);            // Printing each filtered course
}
```

### Example 2: Squaring Numbers and String Operations
This example showcases mapping and printing the squares of even numbers and mapping and printing the length of each course name along with the course name.

```
// Code example for mapping and printing squares and performing string operations
public static void printSquaresOfNumbers(List<Integer> numbers) {
    numbers.stream()
        .filter(number -> number % 2 == 0) // Filtering even numbers
        .map(number -> number * number)     // Mapping to their squares
        .forEach(System.out::println);      // Printing each squared number
}

public static void printCharsCountInCourses(List<String> courses) {
    courses.stream()
        .map(course -> course + ", " + course.length()) // Mapping to course name + length
        .forEach(System.out::println);                  // Printing each mapped result
}

```

### Example 3: Using Reduce and Comparator
This example illustrates the use of the reduce function to add all numbers in a list and demonstrates sorting and printing based on different criteria.

```
// Code example for using reduce, sorting, and printing based on different criteria
private static void addList(List<Integer> numbers) {
    int sum = numbers.stream()
        .reduce(0, Integer::sum); // Using reduce to calculate the sum

    System.out.println("Sum >> " + sum);
}

private static void listOperations(List<String> courses, List<Integer> numbers, boolean sortByCourses, boolean useComparator) {
    if (sortByCourses) {
        courses.stream()
            .distinct()
            .sorted()
            .forEach(System.out::println);
    } else {
        numbers.stream()
            .distinct()
            .sorted((a, b) -> b - a)
            .forEach(System.out::println);
    }

    if (useComparator) {
        courses.stream()
            .distinct()
            .sorted()
            .forEach(System.out::println);
    } else {
        // Custom comparator: Sorting courses based on their length
        courses.stream()
            .distinct()
            .sorted(Comparator.comparing(String::length))
            .map(String::toLowerCase)
            .forEach(System.out::println);
    }
}

```

### Example 4: Collecting to List
In this example, we collect the squares of numbers into a list using the Collectors.toList() method.

```
// Code example for collecting the squares of numbers into a list
public static void listToListOperations(List<Integer> numbers) {
    List<Integer> squaresOfNumbers = numbers.stream()
        .map(number -> number * number)
        .collect(Collectors.toList()); // Collecting to a new list

    squaresOfNumbers.forEach(System.out::println);
}

```

### Example 5: Introduction to Functional Interfaces
We introduce various functional interfaces such as Predicate, Function, Consumer, and BinaryOperator.

```
// Code example for introducing functional interfaces
public static void lambdaAndFunctions() {
    // Predicate: Checks if a number is even
    Predicate<Integer> isEvenPredicate = number -> number % 2 == 0;

    // Function: Squares a number
    Function<Integer, Integer> squareFunction = number -> number * number;

    // Consumer: Prints a number
    Consumer<Integer> sysoutConsumer = System.out::println;

    // BinaryOperator: Adds two numbers
    BinaryOperator<Integer> sumBinaryOperator = Integer::sum;

    // Note: Lambdas are objects of these functional interfaces.
}

```

### Example 6: Exploring Other Functional Interfaces
This example explores other functional interfaces like Supplier, UnaryOperator, BiPredicate, BiFunction, and BiConsumer.

```
// Code example for exploring other functional interfaces
public static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
    numbers.stream()
        .filter(predicate)
        .forEach(System.out::println);
}

public static void exploringSupplier() {
    // Supplier: Generates a constant value of 2
    Supplier<Integer> randomIntegerSupplierOne = () -> 2;

    // Supplier: Generates a random integer between 0 and 9
    Supplier<Integer> randomIntegerSupplierTwo = () -> {
        Random random = new Random();
        return random.nextInt(10);
    };

    System.out.println(randomIntegerSupplierTwo.get());
}

// Similar snippets for UnaryOperator, BiPredicate, BiFunction, BiConsumer

```

### Example 7: Method References
Here, we demonstrate the use of method references for uppercase conversion and printing.

```
// Code example for using method references
public static void exploringMethodReferences(List<String> courses) {
    courses.stream()
        .map(String::toUpperCase)                    // Method reference: Calling a static method
        .forEach(LambdaAndFunctionalInterfaces::printInput); // Method reference: Referring to a method
}

// Definition of the referenced method
public static void printInput(String input) {
    System.out.println(input);
}

```

### Functional Programming Concepts
## Lambdas
Lambda expressions are a concise way to express instances of single-method interfaces (functional interfaces). They enable you to treat functionality as a method argument.

## Functional Interfaces
Functional interfaces have exactly one abstract method. They can have multiple default or static methods but only one abstract method.

## Streams
Streams provide a sequence of elements supporting sequential and parallel aggregate operations.

## Predicate
Predicate is a functional interface representing a boolean-valued function of one argument. It is commonly used for filtering.

## Function
Function is a functional interface representing a function that accepts one argument and produces a result.

## Consumer
Consumer is a functional interface representing an operation that accepts a single argument and returns no result.

## BinaryOperator
BinaryOperator is a functional interface representing an operation upon two operands and producing a result of the same type as the operands.

## Supplier
Supplier is a functional interface representing a supplier of results.

## UnaryOperator
UnaryOperator is a functional interface representing an operation upon a single operand.

## BiPredicate, BiFunction, BiConsumer
BiPredicate, BiFunction, and BiConsumer are functional interfaces that take two parameters.