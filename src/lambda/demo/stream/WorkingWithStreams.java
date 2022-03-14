package lambda.demo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class WorkingWithStreams {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        Predicate<Integer> predicate = (k) -> k > 5;
        Predicate<Integer> predicate1 = (k) -> k < 50;

        list.add(1);
        list.add(20);
        list.add(30);

       /* List<Integer> list1 = list.stream().filter(predicate.and(predicate1)).toList();
        System.out.println(list1);
*/
        list.stream().filter(predicate.and(predicate1)).forEach(System.out::println);

        // creating STREAMS

        Stream<Integer> stream = Stream.of(10,20,30,40,50);

        Integer[] arr = {10,20,30,40,50};
        Stream<Integer> stream1 = Stream.of(arr);

        Stream<Integer> stream2 = Stream.iterate(1,(i) -> i<10,(i) -> i+1);
        stream2.forEach(System.out::print);
    }
}
