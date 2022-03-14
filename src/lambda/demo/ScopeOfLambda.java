package lambda.demo;

class Lasttname{
    String lastname = "lokani";
}

public class ScopeOfLambda extends Lasttname{
    public String firstname = "avinash";

    interface Name{
        String getname();
    }

    public void method(String name){
        System.out.println(name);
        System.out.println(this.firstname);
        System.out.println(super.lastname);

        Name name1 = () ->{
            System.out.println(name);
            System.out.println(this.firstname);
            System.out.println(super.lastname);
            return firstname+name+lastname;
        };

        System.out.println(name1.getname());
    }

    public static void main(String[] args){
        new ScopeOfLambda().method("vardhan");
    }
}
