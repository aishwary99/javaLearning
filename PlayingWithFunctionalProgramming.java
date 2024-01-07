import java.util.*;
import java.util.stream.*;
import java.math.*;

public class PlayingWithFunctionalProgramming {
    
    // Example 1: Demonstrating stream count operation in two ways
    private static void exampleOne(List<Integer> numbers) {
        // First way: Using stream count()
        int totalNumbers = (int) numbers.stream().count();
        System.out.println("Total numbers (first way): " + totalNumbers);
        
        // Second way: Using Stream.of and count()
        System.out.println("Total numbers (second way): " + Stream.of(12, 9, 13, 14).count());
    }
    
    // Example 2: Demonstrating various stream operations on an array of integers
    private static void exampleTwo(int[] numbers) {
        // Calculating sum using reduce operation
        System.out.println("Sum of numbers: " + Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).reduce(0, Integer::sum));
        
        // Counting the number of elements in the array
        System.out.println("Count of numbers: " + Arrays.stream(numbers).count());
        
        // Calculating sum using sum() method
        System.out.println("Sum of numbers (sum() method): " + Arrays.stream(numbers).sum());
        
        // Finding minimum and maximum values in the array
        System.out.println("Minimum value: " + Arrays.stream(numbers).min().orElse(0));
        System.out.println("Maximum value: " + Arrays.stream(numbers).max().orElse(0));
    }
    
    // Example 3: Demonstrating IntStream operations for range, rangeClosed, and iterate
    private static void exampleThree() {
        // Printing numbers in the range [1, 10) using IntStream
        IntStream.range(1, 10).forEach(System.out::println);
        
        System.out.println("-----");
        
        // Summing numbers in the range [1, 10)
        System.out.println("Sum of numbers: " + IntStream.range(1, 10).sum());
        
        System.out.println("-----");
        
        // Counting numbers in the range [1, 10)
        System.out.println("Count of numbers: " + IntStream.range(1, 10).count());
        
        System.out.println("-----");
        
        // Summing numbers in the range [1, 10] (inclusive)
        System.out.println("Sum of numbers (inclusive): " + IntStream.rangeClosed(1, 10).sum());
        
        System.out.println("-----");
        
        // Summing odd numbers using iterate and limiting to 10 elements
        System.out.println("Sum of odd numbers: " + IntStream.iterate(1, index -> index + 2)
            .limit(10).peek(System.out::println).sum());
            
        System.out.println("-----");
        
        // Summing even numbers using iterate and limiting to 10 elements
        System.out.println("Sum of even numbers: " + IntStream.iterate(2, index -> index + 2)
            .limit(10).peek(System.out::println).sum());
            
        System.out.println("-----");
        
        // Exponential progression using iterate and limiting to 10 elements
        System.out.println("Exponential progression: " + IntStream.iterate(2, index -> index * 2)
            .limit(10).peek(System.out::println).sum());
    }
    
    // Example 4: Demonstrating LongStream operations for rangeClosed and reduce
    public static void exampleFour() {
        // Calculating factorial of 20 using reduce
        System.out.println("Factorial of 20: " + LongStream.rangeClosed(1, 20).reduce(1, (a, b) -> a * b));
        
        System.out.println("-----");
        
        // Calculating factorial of 50 using mapToObj and reduce with BigInteger
        System.out.println("Factorial of 50: " + LongStream.rangeClosed(1, 50)
            .mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
    }
    
    // Example 5: Demonstrating stream operations on a list of strings
    public static void exampleFive(List<String> courses) {
        // Joining courses with space as a delimiter
        System.out.println("Joined courses: " + courses.stream().collect(Collectors.joining(" ")));
        
        System.out.println("-----");
        
        // Splitting each course string into an array of characters
        System.out.println("List of characters: " + courses.stream()
            .map(course -> course.split(""))
            .flatMap(Arrays::stream)
            .collect(Collectors.toList()));
    }
    
    public static void main(String args[]) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int[] numbersArray = {12, 9, 13, 4, 6, 2, 4, 12, 15};
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices"
        , "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        
        // Uncomment the desired example method below to execute
        // exampleOne(numbers);
        // exampleTwo(numbersArray);
        // exampleThree();
        // exampleFour();
        // exampleFive(courses);
    }
}