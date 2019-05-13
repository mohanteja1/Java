package week1.OOPsFundamentals.abstraction;


abstract class AbstractParent{

    //final variable in abstract class
    final int RATE_OF_PAY;
    int parentAge=34;
    abstract int Earn(int time);

    // Abstract class constructor

    AbstractParent(int rateofpay){
        //initializing final variables through abstract constructor
      RATE_OF_PAY=rateofpay;
    }

    //non abstract method and this is not possible in interfaces :(
    int riskFactor(int jobTime){
        return this.parentAge*jobTime;
    }



}

class ChildClass extends AbstractParent{

    final int RATE_OF_PAY;

    int Earn(int time){

        return (this.RATE_OF_PAY + super.RATE_OF_PAY)*time;
    }

    ChildClass(){
        super(45);
        this.RATE_OF_PAY=45;
    }

    ChildClass(int parentRateofPay,int hisRateofPay){
        super(parentRateofPay);
        this.RATE_OF_PAY = hisRateofPay;
    }


}




class Abstract {

    public static void main(String args[]) {
        ChildClass childClass1 = new ChildClass(23, 33);
        System.out.println("totalPay =" + childClass1.Earn(33));

        System.out.println("risk factor = " + childClass1.riskFactor(33));


    }
}
