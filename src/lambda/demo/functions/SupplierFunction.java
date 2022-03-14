package lambda.demo.functions;


import java.util.function.Supplier;

public class SupplierFunction {
    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6,7};
        Supplier<Integer> supplier = () ->(arr.length);
        System.out.println(supplier.get());
    }
}
