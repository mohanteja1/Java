package week1.OOPsFundamentals.abstraction;


abstract class AbstractParent{

    //final variable in abstract class
    final int RATE_OF_PAY;

    abstract int Earn(int time);

    // Abstract class constructor

    AbstractParent(int rateofpay){
      RATE_OF_PAY=rateofpay;
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
        System.out.println(childClass1.Earn(33));


    }


}
