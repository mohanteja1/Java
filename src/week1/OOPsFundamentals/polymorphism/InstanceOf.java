package week1.OOPsFundamentals.polymorphism;


import week1.OOPsFundamentals.singletonexample.Singleton;

class Simple{
    int checkVariable=90;

}

class NotSimple extends Simple{

    int checkVariable=100;

    static NotSimple typeCastDown(Simple s){

        NotSimple ns=null;

        if(s instanceof NotSimple){
          ns = (NotSimple) s;
        }
        return ns;
    }

}


public class InstanceOf {

 public static void main(String arg[]){

     Simple simple = new Simple();

     // object instanceof Classname

     System.out.println(simple instanceof Simple);
     //System.out.println(simple instanceof Multilevel);

     simple =null;

     System.out.println(simple instanceof Simple);
   // outputs false


     //when subclass refers to the object of parent class it is called downcasting then compilers throughs compilation errps: false

       //Dog dog = new Animal();   //throws compilation error


     //Dog dog = (Dog) new Animal();  // throws ClassCastException so not possible to refer a parent object with child class reference

     //System.out.println(dog.getAvariable());


     Simple a = new NotSimple();

     System.out.println(a.checkVariable);

     NotSimple ns= null;

     ns = NotSimple.typeCastDown(a);


     System.out.println(ns.checkVariable);

     System.out.println("lets see the two objects are similar");

     System.out.println(System.identityHashCode(ns));
     System.out.println(System.identityHashCode(a));

     // both are same objects








 }








}
