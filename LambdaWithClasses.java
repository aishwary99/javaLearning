import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int numberOfStudents;
    
    public Course(String name, String category, int reviewScore, int numberOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.numberOfStudents = numberOfStudents;
    }
    
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
    
    public String toString() {
        return this.name + ":" + this.numberOfStudents + ":" + this.reviewScore;
    }
}

public class LambdaWithClasses {
    public static void main(String args[]) {
        List<Course> courses = List.of(
            new Course("Spring", "Framework", 98, 20000),
            new Course("Spring Boot", "Framework", 98, 20000),
            new Course("API", "Framework", 94, 10000),
            new Course("Micorservices", "Micorservices", 96, 25000),
            new Course("AWS", "Cloud", 91, 2000),
            new Course("Azure", "Cloud", 91, 1000),
            new Course("GCP", "Cloud", 90, 400)
            );
            
        Predicate<Course> reviewScoreGreatherThan95 = 
            course -> course.getReviewScore() > 95;
            
        Predicate<Course> reviewScoreGreatherThan90 = 
            course -> course.getReviewScore() > 90;

        System.out.println(courses.stream()
            .allMatch(reviewScoreGreatherThan90));
            
        System.out.println(courses.stream()
            .noneMatch(reviewScoreGreatherThan90));
            
        System.out.println(courses.stream()
            .anyMatch(reviewScoreGreatherThan90));
        
        // Criteria : Compare by number of students in increasing order
        Comparator<Course> comparingByNumberOfStudentsIncreasing = 
            Comparator.comparing(Course::getNumberOfStudents);
        
        // Criteria : Compare by number of students in decreasing order
        Comparator<Course> comparingByNumberOfStudentsDecreasing = 
            Comparator.comparing(Course::getNumberOfStudents)
            .reversed();
        
        // Criteria : Compare by number of students & number of reviews in increasing order
        Comparator<Course> comparingByNumberOfStudentsAndNumberOfReviews = 
            Comparator.comparing(Course::getNumberOfStudents)
            .thenComparing(Course::getReviewScore)
            .reversed();
        
        
        System.out.println(courses.stream()
            .sorted(comparingByNumberOfStudentsAndNumberOfReviews)
            .skip(2)
            .limit(5)
            .collect(Collectors.toList()));
            
        System.out.println("------------------------------------------");
        
        System.out.println(courses.stream()
            .takeWhile(course -> course.getReviewScore() >= 95)
            .collect(Collectors.toList()));
            
        System.out.println("------------------------------------------");
        
        System.out.println(courses.stream()
            .max(comparingByNumberOfStudentsAndNumberOfReviews));
        
        System.out.println("------------------------------------------");
        
        System.out.println(courses.stream()
            .min(comparingByNumberOfStudentsAndNumberOfReviews));
        
        System.out.println("------------------------------------------");
        
        System.out.println(courses.stream()
            .filter(reviewScoreGreatherThan95)
            .findFirst());
            
        System.out.println("------------------------------------------");
        
        System.out.println(courses.stream()
            .filter(reviewScoreGreatherThan95)
            .findAny());
        
        System.out.println("------------------------------------------");
        
        // similar methods -> average(), count(), max(), min() - returns Optional<>
        System.out.println(courses.stream()
            .filter(reviewScoreGreatherThan95)
            .mapToInt(Course::getNumberOfStudents)
            .sum());
            
        System.out.println("------------------------------------------");
        
        System.out.println(courses.stream()
            .collect(Collectors.groupingBy(Course::getCategory)));
            
        System.out.println("------------------------------------------");
        
        System.out.println(courses.stream()
            .collect(Collectors.groupingBy(Course::getCategory,
                    Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
    }
}