import java.util.*;
import java.util.stream.*;

public class Example1 {

    // Example 1 begins here
    public static void printOddNumbersInList(List<Integer> numbers) {
        numbers.stream()
        // filter takes predicate
        // predicate is used to test each element of stream
        // it returns true/false post evaluation
        // based on some condition
            .filter(number -> number % 2 == 0)
        /*
        he forEach method takes a Consumer as its argument. 
        A Consumer is a functional interface in the java.util.function 
        package that represents an operation that accepts a single input
        argument and returns no result.
        */
            .forEach(System.out::println);
    }

    public static void printCoursesInList(List<String> courses) {
        courses.stream()
            .filter(course -> course.length() >= 4)
            .filter(course -> course.startsWith("S"))
            .forEach(System.out::println);
    }
    // Example 1 ends here

    // Example 2 starts here

    public static void printSquaresOfNumbers(List<Integer> numbers) {
        numbers.stream()
            .filter(number -> number % 2 == 0)
            .map(number -> number * number)
            .forEach(System.out::println);
    }

    public static void printCharsCountInCourses(List<String> courses) {
        courses.stream()
            .map(course -> course + ", " + course.length())
            .forEach(System.out::println);
    }

    // Example 2 ends here

    // Example 3 starts here

    private static int sum(int a, int b) {
        return a + b;
    }

    private static void addList(List<Integer> numbers) {
        int sum = numbers.stream()
        /**
         * reduce function takes one identity & accumulator expression
         * it starts with identity & evaluates accumulator expression result
         * to produce one single result
         * 
         * T reduce(T identity, BinaryOperator<T> accumulator)
         * 
         * it is used to perform aggregation :)
         */
            // .reduce(0, Example1::sum);
            // .reduce(0, (a, b) -> a + b);
            .reduce(0, Integer::sum);


        /**
         * Example -
         * 12, 9, 13, 4, 6, 2, 4, 12, 15
         * 0 + 12 = 12
         * 12 + 9 = 21
         * 21 + 13 = 34
         */

        System.out.println("Sum >> " + sum);
    }

    private static void listOperations(List<String> courses, List<Integer> numbers, boolean flag, boolean useComparator) {
        /**
         *
         * Making use of - sorted(), distinct() functions
         * along with custom and pre-defined comparators
         * 
         **/
        if (flag) {
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
            // custom comparator
            courses.stream()
            .distinct()
            .sorted(Comparator.comparing(input -> input.length()))
            .map(input -> input.toLowerCase())
            .forEach(System.out::println);
        }
    }

    // Example 3 ends here
    
    // Example 4 starts here
    
    public static void listToListOperations(List<Integer> numbers) {
        /**
         * toList() -> In Java, the toList() function is commonly used in conjunction with streams to collect the elements
         * of a stream into a List. This function is part of the Collectors utility class in the java.util.stream package.
         * 
         * The toList() method returns a Collector that accumulates the elements of a stream into a List. 
         * When you use this collector with the collect method on a stream, it creates a List containing all
         * the elements of the stream.
         * 
         **/
        List<Integer> squaresOfNumbers = numbers.stream()
            .map(number -> number * number)
            .collect(Collectors.toList());
            
        squaresOfNumbers.stream()
            .forEach(System.out::println);
    }
    
    // Example 4 ends here
    
    // Example 5 starts here
    
    public static void lambdaAndFunctions() {
        /**
        In Java 8, a functional interface is an interface that contains only one abstract method. 
        These interfaces are also known as Single Abstract Method (SAM) interfaces or, more commonly,
        functional interfaces. Java 8 introduced functional interfaces to support the new features like lambda expressions
        and the @FunctionalInterface annotation is used to ensure that the interface qualifies as a functional interface.
        **/
        
        /**
         * 
         * Behind the scenes - the instance of declared functions are created
         * and lambda's behaviour is injected - sort of...
         * 
         * Basic idea was to make lambda functions compatible with existing java i.e backward compatability...
         * 
         **/
        Predicate<Integer> isEvenPredicate = number -> number % 2 == 0;
        
        /**
        Predicate<Integer> isEvenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number % 2 == 0;
            }
        };
        **/
        
        Function<Integer, Integer> squareFunction = number -> number * number;
        
        /**
        Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return number * number;
            }
        };
        **/
        
        Consumer<Integer> sysoutConsumer = System.out::println;
        
        /**
        Consumer<Integer> sysoutConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                System.out.println(number);
            }
        };
        **/
        
        // Important Note - Lambda's are also objects of these classes - because classes are first class citizens in Java :)
    }
    
    // Example 5 ends here

    
    public static void main(String args[]) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices"
        , "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        
        // printOddNumbersInList(numbers);
        // printCoursesInList(courses);
        // printSquaresOfNumbers(numbers);
        // printCharsCountInCourses(courses);
        // addList(numbers);
        // listOperations(courses, numbers, false, false);
        // listToListOperations(numbers);
    }
}