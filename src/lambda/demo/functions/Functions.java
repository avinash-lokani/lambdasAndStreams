package lambda.demo.functions;

import java.util.function.Function;

class shape{
    int k;
    shape(int k){
        this.k = k;
    }

    int area(String s){

        if(s.equalsIgnoreCase("circle"))
            return (int)3.14*k;
        else
            return k*k;
    }
}

public class Functions {
    public static void main(String[] args){
        Function<Integer,shape> function = (k) -> new shape(k);
        System.out.println( function.apply(10).area("circle"));
        System.out.println(function.apply(20).area("square"));
    }
}
