package week1.OOPsFundamentals.polymorphism;

public class MethodOverloading {

        static int add(int a,int b){return a+b;}
        static double add(int a,float b){return a+b;}

//overloading main
    public static void main(String[] args){System.out.println("main with String[]");}
    public static void main(String args){System.out.println("main with String");}
    public static void main(){System.out.println("main without args");}

}

class Driver{

    public static void main(String args[]){

        String[] A= {"hai","hjj"};
        MethodOverloading.main();
        MethodOverloading.main(A);
        MethodOverloading.main("kkk");


    }
}