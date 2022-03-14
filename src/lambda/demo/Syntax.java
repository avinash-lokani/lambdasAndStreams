package lambda.demo;

public class Syntax {

    interface Square{
        int getSquare(int n);
    }



    public static void main(String[] args){
/*
        Square square = new math();
        System.out.println(square.getSquare(5));
*/


        // syntax
        // () -> body

        Square square1 = (n) -> n*n;
        System.out.println(square1.getSquare(10));
    }
}

/*
class math implements Syntax.Square {

    @Override
    public int getSquare(int n) {
        return n*n;
    }
}*/
