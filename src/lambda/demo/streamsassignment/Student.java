package lambda.demo.streamsassignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Student {
    //id,name,age,gender,engDepartment,year of enrollment ,perTillDate
    static int avg;
    static  List<Student> studentList = new ArrayList<>();

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

    Student(int id,String name,int age,String gender,String engDepartment,int year,double perTillDate){
        this.age = age;
        this.engDepartment = engDepartment;
        this.gender = gender;
        this.perTillDate = perTillDate;
        this.year = year;
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args){

         addStudents();


        //1. Print the name of all departments in the college?
        Function<Student,String> studentStringFunction = i -> i.engDepartment;
        studentList.stream().distinct().map(studentStringFunction).distinct().forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------");

        //2.Get the names of all students who have enrolled after 2018?
        Function<Student,String> studentStringFunction1 = i -> i.name;
        List<String> studentList1 = studentList.stream().filter(i -> i.year > 2018).map(studentStringFunction1).toList();
        System.out.println(studentList1.toString());
        System.out.println("-------------------------------------------------------------------------");

        // 3. Get the details of all male student in the computer sci department?
        Predicate<Student> predicate = i -> i.gender.equalsIgnoreCase("male");
        Predicate<Student> predicate1 = i -> i.engDepartment.equalsIgnoreCase("computer science");
        List<Student> malecs = studentList.stream().filter(predicate.and(predicate1)).toList();
        System.out.println(malecs.toString());
        System.out.println("-------------------------------------------------------------------------");

        // 4. How many male and female student are there ? (HINT:use Collectors.groupingBy() for grouping based on gender)
        Map<String, List<Student>> map = studentList.stream().collect(Collectors.groupingBy(e -> e.getGender()));
        long MaleCount =  map.get("Male").stream().count();
        long FemaleCount =  map.get("Female").stream().count();
        System.out.println("Male = " +MaleCount+ " Female = "+FemaleCount);
        System.out.println("-------------------------------------------------------------------------");


        //5.What is the average age of male and female students?
        Consumer<Integer> consumer = i -> avg = avg + i;
        map.get("Male").stream().map(i -> i.age).forEach(consumer);
        float MaleAvg = avg/MaleCount; avg = 0;
        map.get("Female").stream().map(i -> i.age).forEach(consumer);
        float FemaleAvg = avg/FemaleCount;
        System.out.println("MaleAverage : "+MaleAvg + " FemaleAvg : "+FemaleAvg);
        System.out.println("-------------------------------------------------------------------------");

        // 6.Get the details of highest student having highest percentage ?
        System.out.println(studentList.stream().max(Comparator.comparingDouble(Student::getPerTillDate)).toString());
        System.out.println("-------------------------------------------------------------------------");

        //7.Count the number of students in each department? (Hint :use Collectors.groupingBy())
        Map<String,List<Student>> map1 = studentList.stream().collect(Collectors.groupingBy(Student::getEngDepartment));
        map1.entrySet().stream().forEach(i -> System.out.println(i.getKey() + " " +i.getValue().size()));
        System.out.println("-------------------------------------------------------------------------");

        //8. What is the average percentage achieved in each department?
        map1.entrySet().stream().forEach(i -> System.out.println(i.getKey() + " " +i.getValue().stream().map(k -> k.perTillDate).toList().stream().mapToDouble(Double::doubleValue).average()));
        System.out.println("-------------------------------------------------------------------------");

        //9. Get the details of youngest male student in the Electronic department?(Hint :Use Collectors.minBy)
        System.out.println(map.get("Male").stream().filter(i -> i.getEngDepartment().equalsIgnoreCase("Electronic")).min(Comparator.comparingInt(Student::getAge)));
        System.out.println("-------------------------------------------------------------------------");

        // 10.How many male and female students are there in the computer science department?
        Map<String, List<Student>> ComputerScienceList = map1.get("Computer Science").stream().collect(Collectors.groupingBy(Student::getGender));
        MaleCount = ComputerScienceList.get("Male").stream().count();
        FemaleCount = ComputerScienceList.get("Female").stream().count();
        System.out.println("Malecount  = "+MaleCount + " FemaleCount = "+FemaleCount);
        System.out.println("-------------------------------------------------------------------------");
    }

    public static void addStudents(){

        studentList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        studentList.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        studentList.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        studentList.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        studentList.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        studentList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        studentList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        studentList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        studentList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        studentList.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        studentList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        studentList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        studentList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        studentList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        studentList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        studentList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        studentList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));
    }

}
