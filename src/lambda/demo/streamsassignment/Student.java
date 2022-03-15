package lambda.demo.streamsassignment;

import java.util.ArrayList;
import java.util.List;

public class Student {
    static List<Student> studentList = new ArrayList<>();

    public Student() {

    }


    public String getGender() {
        return gender;
    }


    public int getAge() {
        return age;
    }


    public String getEngDepartment() {
        return engDepartment;
    }

    public double getPerTillDate() {
        return perTillDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", year=" + year +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", engDepartment='" + engDepartment + '\'' +
                ", perTillDate=" + perTillDate +
                '}';
    }

    int id,age,year;
    String name,gender,engDepartment;
    double perTillDate;

    Student(int id, String name, int age, String gender, String engDepartment, int year, double perTillDate){
        this.age = age;
        this.engDepartment = engDepartment;
        this.gender = gender;
        this.perTillDate = perTillDate;
        this.year = year;
        this.id = id;
        this.name = name;
    }

    public List<Student> addStudents(){

        Student.studentList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        Student.studentList.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        Student.studentList.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        Student.studentList.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        Student.studentList.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        Student.studentList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        Student.studentList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        Student.studentList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        Student.studentList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        Student.studentList.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        Student.studentList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        Student.studentList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        Student.studentList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        Student.studentList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        Student.studentList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        Student.studentList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        Student.studentList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));
        return studentList;
    }

}
