package week1.ExceptionalHandling.CustomException;

public class MyException extends Exception{

    MyException(String exceptionMessage){
        super(exceptionMessage);
    }

}


class DriverProgram{
    public static void main(String args[]){

        try {
         throw new MyException("some error");


        }
        catch(Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        }

    }



}