package lambda.demo.functions;


import java.util.function.Predicate;

public class PredicateFunctions {
    public static void main(String[] args){

        Predicate<Integer> predicate = (i) -> (i > 5);
        Predicate<Integer> predicate1 = (i) -> (i > 0);
        System.out.println(predicate.test(10));

        System.out.println(predicate.and(predicate1).test(1));
        System.out.println(predicate.or(predicate1).test(1));
        System.out.println(predicate.negate().test(1));
        System.out.println(Predicate.not(predicate1).test(1));

    }
}
