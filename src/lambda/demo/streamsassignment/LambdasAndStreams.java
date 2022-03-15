package lambda.demo.streamsassignment;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class LambdasAndStreams {
    //id,name,age,gender,engDepartment,year of enrollment ,perTillDate
    static List<Student> studentList;
    static int avg;


    public static void main(String[] args){
        Student student = new Student();
         studentList = student.addStudents();


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


        //5.What is the average age of male and female students? //reduce
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
        System.out.println(map.get("Male").stream().filter(i -> i.getEngDepartment()
                .equalsIgnoreCase("Electronic"))
                .min(Comparator.comparingInt(Student::getAge)));
        System.out.println("-------------------------------------------------------------------------");

        // 10.How many male and female students are there in the computer science department?
        Map<String, List<Student>> ComputerScienceList = map1.get("Computer Science").stream().collect(Collectors.groupingBy(Student::getGender));
        MaleCount = ComputerScienceList.get("Male").stream().count();
        FemaleCount = ComputerScienceList.get("Female").stream().count();
        System.out.println("Malecount  = "+MaleCount + " FemaleCount = "+FemaleCount);
        System.out.println("-------------------------------------------------------------------------");
    }



}
