package week1.OOPsFundamentals.polymorphism;

import java.lang.reflect.Array;

public class CovariantReturnType {

    String[] multiply(final int a, int b){

        String[] A= {"hai","hjj"};

        return A;
    }


}

class Child extends CovariantReturnType{

//   String multiply(int a , int b){
//
//        String[] A= {"hai","hjj"};
//        return A[1];
//    }

    public static void main(String args[]){
        Child child = new Child();
        child.multiply(4,5);

    }


}