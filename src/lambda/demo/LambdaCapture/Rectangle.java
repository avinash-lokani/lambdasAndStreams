package lambda.demo.LambdaCapture;

public class Rectangle {
    int l = 10;
    int w = 20;
    static int r = 5;
    public void capture(int l,int b){ // local variables..
       // l = 10;
        Shape shape = () -> (l*b);
        System.out.println(shape.draw());
        this.l = 50;
        Shape shape1 = () -> (this.l * this.w); // instance variables
        System.out.println(shape1.draw());

        r = 10;
        Shape shape2 = () -> (int) (r*3.14);
        System.out.println(shape2.draw());
    }
}
