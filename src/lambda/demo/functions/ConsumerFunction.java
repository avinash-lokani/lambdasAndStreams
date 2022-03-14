package lambda.demo.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunction {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        Consumer<Integer> consumer = (i) -> list.add(i);
        Consumer<Integer> consumer1 = (i) -> consumer.accept(i);
        consumer.accept(10);
        consumer1.accept(11);
        consumer1.accept(12);
        consumer1.accept(13);
        consumer.andThen(consumer1);
        List<Integer> list1 = list.stream().toList();
        System.out.println(list1);
    }
}
