import java.util.*;
import java.util.stream.*;
import java.util.function.*;

// Class representing a course with various attributes
class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int numberOfStudents;
    
    // Constructor to initialize the course object
    public Course(String name, String category, int reviewScore, int numberOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.numberOfStudents = numberOfStudents;
    }

    // Getter and setter methods for accessing and modifying course attributes
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getReviewScore() {
        return this.reviewScore;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfStudents() {
        return this.numberOfStudents;
    }

    // Override toString method for better object representation
    @Override
    public String toString() {
        return this.name + ":" + this.numberOfStudents + ":" + this.reviewScore;
    }
}

// Main class demonstrating the usage of Lambda expressions with Stream and Comparator in Java
public class LambdaWithClasses {
    public static void main(String args[]) {
        // Create a list of Course objects
        List<Course> courses = List.of(
            new Course("Spring", "Framework", 98, 20000),
            new Course("Spring Boot", "Framework", 98, 20000),
            new Course("API", "Framework", 94, 10000),
            new Course("Micorservices", "Micorservices", 96, 25000),
            new Course("AWS", "Cloud", 91, 2000),
            new Course("Azure", "Cloud", 91, 1000),
            new Course("GCP", "Cloud", 90, 400)
        );

        // Predicate to check if the review score is greater than 95
        Predicate<Course> reviewScoreGreatherThan95 = 
            course -> course.getReviewScore() > 95;

        // Predicate to check if the review score is greater than 90
        Predicate<Course> reviewScoreGreatherThan90 = 
            course -> course.getReviewScore() > 90;

        // Stream operations to demonstrate matching methods (allMatch, noneMatch, anyMatch)
        System.out.println("All courses have a review score greater than 90: " +
                courses.stream().allMatch(reviewScoreGreatherThan90));
        System.out.println("No courses have a review score greater than 90: " +
                courses.stream().noneMatch(reviewScoreGreatherThan90));
        System.out.println("Any course has a review score greater than 90: " +
                courses.stream().anyMatch(reviewScoreGreatherThan90));

        // Comparator for sorting courses based on the number of students and reviews
        Comparator<Course> comparingByNumberOfStudentsAndNumberOfReviews = 
            Comparator.comparing(Course::getNumberOfStudents)
            .thenComparing(Course::getReviewScore)
            .reversed();

        // Stream operations to demonstrate sorting, skipping, limiting, and collecting
        System.out.println("Courses sorted by number of students and reviews (skip 2, limit 5): " +
                courses.stream()
                        .sorted(comparingByNumberOfStudentsAndNumberOfReviews)
                        .skip(2)
                        .limit(5)
                        .collect(Collectors.toList()));

        System.out.println("------------------------------------------");

        // Stream operations demonstrating takeWhile, max, min, filter, and other methods
        System.out.println("Courses with a review score greater than or equal to 95: " +
                courses.stream().takeWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList()));

        System.out.println("------------------------------------------");

        System.out.println("Course with the maximum number of students and reviews: " +
                courses.stream().max(comparingByNumberOfStudentsAndNumberOfReviews));

        System.out.println("------------------------------------------");

        System.out.println("Course with the minimum number of students and reviews: " +
                courses.stream().min(comparingByNumberOfStudentsAndNumberOfReviews));

        System.out.println("------------------------------------------");

        System.out.println("Any course with a review score greater than 95: " +
                courses.stream().filter(reviewScoreGreatherThan95).findFirst());

        System.out.println("------------------------------------------");

        System.out.println("Any course with a review score greater than 95 (find any): " +
                courses.stream().filter(reviewScoreGreatherThan95).findAny());

        System.out.println("------------------------------------------");

        // Similar methods -> average(), count(), max(), min() - returns Optional<>
        System.out.println("Sum of the number of students in courses with a review score greater than 95: " +
                courses.stream().filter(reviewScoreGreatherThan95)
                        .mapToInt(Course::getNumberOfStudents)
                        .sum());

        System.out.println("------------------------------------------");

        // Stream operations demonstrating groupingBy in Collectors
        System.out.println("Courses grouped by category: " +
                courses.stream().collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println("------------------------------------------");

        System.out.println("Maximum review score in each category: " +
                courses.stream().collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
    }
}