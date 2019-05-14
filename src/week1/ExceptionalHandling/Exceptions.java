package week1.ExceptionalHandling;

class ExceptionProgation{

    private void method1(int number){

         if(number <100 )
        throw new ArithmeticException("number below 100 causes division with zero");
         else
            System.out.println("executed fine");


    }

    void p(int number){
        try{
            method1(number);
        }catch(Exception e){System.out.println("exception handeled");}
    }

}



public class Exceptions {

    public static void main(String args[]){

        ExceptionProgation exceptionProgation = new ExceptionProgation();
        exceptionProgation.p(99);

    }


}
