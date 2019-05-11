package week1.OOPsFundamentals.polymorphism;


import week1.OOPsFundamentals.singletonexample.Singleton;

class Simple{
    int checkVariable=90;
    public void parentMethod(){
        System.out.println("parent method = " + checkVariable);
    }



}

class NotSimple extends Simple{

    int checkVariable=100;

    public void childMethod(){
        System.out.println("child method =" + checkVariable);
    }


    static NotSimple typeCastDown(Simple s){

        NotSimple ns=null;

        if(s instanceof NotSimple){
          ns = (NotSimple) s;
        }
        return ns;
    }

}

class NotVerySimple extends Simple{
    int checkVariable = 50;
    int randomFactor =90;
    public void siblingMethod(){

        System.out.println("sibling method =" + checkVariable);

    }


}

// real use of instance of
//   1.given interface , abstract class or parent class that needs to be implemented or extended
//   2. when created no of parallel (sibling ) child class
//   3. we can use instanceof to check whether to check which class the object belongs when referenced by parent or abstract or interface variable



class TypeCaste{

    public static void invoke(Simple obj){
        if(obj instanceof NotSimple){
            NotSimple notSimple =(NotSimple)obj;
            notSimple.childMethod();
        }
        else if (obj instanceof NotVerySimple){

            NotVerySimple notVerySimple =  (NotVerySimple)obj;
            notVerySimple.siblingMethod();

        }


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
     a.parentMethod();
     System.out.println("a = " + a.checkVariable);

     NotSimple b = (NotSimple) a ;

     b.childMethod();
     b.parentMethod();

     System.out.println("b = " + b.checkVariable);

     NotSimple ns= null;

     ns = NotSimple.typeCastDown(a);

     System.out.println(ns.checkVariable);

     System.out.println("lets see the two objects are similar");

     System.out.println(System.identityHashCode(ns));
     System.out.println(System.identityHashCode(a));

     // both are same objects but when referenced by parent reference  it shows parernt variables and when referenced by child it shows child variables

     System.out.println("checking objects with instance of");

     Simple simple1 = new NotSimple();

     TypeCaste.invoke(simple1); // this prints child

     Simple simple2 = new NotVerySimple();

     TypeCaste.invoke(simple2); //this prints sibling method

















 }








}
