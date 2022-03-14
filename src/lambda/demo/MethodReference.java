package lambda.demo;

interface Name{
    void getname(String s1,String s2);
}

interface Name1{
    void getname(String s);
}

public class MethodReference {
    public void Method1(String name,String name2){
        Name name1 = (s1,s2) -> System.out.println(s1+s2);
        name1.getname(name,name2);

        Name name3 = MethodReference :: getlength;
        name3.getname(name,name2);
        MethodReference reference = new MethodReference();

        Name1 name4 = reference :: getl;
        name4.getname(name);
    }

    private static void getlength(String s, String s1) {
        System.out.println((s + s1).length());

    }

    public void getl(String s){
        System.out.println(s.length());
    }

    public static void main(String[] args){
        new MethodReference().Method1("avinash","vardhan");
    }
}
