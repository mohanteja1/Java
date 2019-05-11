package week1.OOPsFundamentals.polymorphism;

interface I{

}

class Bank {

    float getRateOfInterest(){
        return 8.f;
    }
}

class Sbi extends Bank{

    float getRateOfInterest(){
        return 3;

    }
}

class Icic extends Bank{
     float getRateOfInterest(){
         return 4.5f;
     }


}

class Axis extends Bank{

    @Override
    float getRateOfInterest() {
        return 8.8f;
    }
}



public class RuntimePolymorphismOrDynamicDispatch {


    // parent reference child objects

    public static void main(String ard[]){

     Bank b = new Sbi();

     System.out.println(b.getRateOfInterest());

     b= new Icic();
     System.out.println(b.getRateOfInterest());

     b = new Axis();


     System.out.println(b.getRateOfInterest());




    }





}
