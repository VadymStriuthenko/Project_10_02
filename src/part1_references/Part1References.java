package part1_references;
public class Part1References {
    public static void main(String[] args) {
        // Part 1.1 Assignments
        System.out.println("Part 1.1 Assignments");
        // make a new car object
        Car car1 = new Car("Toyota", 2015);
        // car2 gets the same reference, so there is still only one object
        Car car2 = car1;
        // change the model using car1
        car1.model = "Honda";
        System.out.println("After changing model with car1:");
        System.out.println("car1: " + car1.model + ", " + car1.year);
        System.out.println("car2: " + car2.model + ", " + car2.year);
        // now change the year using car2
        car2.year = 2020;
        System.out.println("After changing year with car2:");
        System.out.println("car1: " + car1.model + ", " + car1.year);
        System.out.println("car2: " + car2.model + ", " + car2.year);
        // both variables point to the same object, so we see the changes in both
        System.out.println("Is it the same object? " + (car1 == car2));
        // Part 1.2 Arguments
        System.out.println();
        System.out.println("Part 1.2 Arguments");
        // make a new student object
        Student student = new Student("Anna", 3);
        System.out.println("Before the method: " + student.name + ", course " + student.course);
        // send the object to the method
        changeCourse(student);
        // check the object after the method, the course is changed
        System.out.println("After the method: " + student.name + ", course " + student.course);
    }
    // this method changes the course of the student we gave to it
    public static void changeCourse(Student s) {
        System.out.println("Inside the method, old course: " + s.course);
        s.course = 4; // we change the original object here, not a copy
        System.out.println("Inside the method, new course: " + s.course);
    }
}
// class for part 1.1
class Car {
    String model;
    int year;
    Car(String model, int year) {
        this.model = model;
        this.year = year;
    }
}
// class for part 1.2
class Student {
    String name;
    int course;
    Student(String name, int course) {
        this.name = name;
        this.course = course;
    }
}