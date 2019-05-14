package week1.OOPsFundamentals.staticUsage;

abstract class A{

    public void show(){
        System.out.println("printn 1");
    }
}

class B extends A{

    public void show(){

        System.out.println("jjj");
    }
}

public class Driver {

    public static void main(String arg[]){

        A a= new B();
        a.show();




//        StaticMethod.product(23,34);   // to call  static method just call class.method();
//        System.out.println(StaticMethod.number); // accessing static class variable
//
//        StaticMethod staticMethod = new StaticMethod();
//        StaticMethod staticMethod1 = new StaticMethod();
//
//        staticMethod.number=30;
//
//        System.out.println(staticMethod.getNumber());
//
//        staticMethod1.number =40;
//
//        System.out.println(staticMethod1.getNumber());
//
//
//        System.out.println(StaticMethod.number); // accessing static class variable

  //      System.out.println(staticMethod.getNumber());

//        short i=2;
//        short b=3;
//
//        i=(short) (i+b);
//
//        int c;
//        c = (34 * b);
//
//
//        System.out.println(i + (short)c);
//


    }

}
