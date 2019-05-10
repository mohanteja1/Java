package week1.OOPsFundamentals.polymorphism;


class Animal{
    int Avariable = 100;
    void eat(){System.out.println(Avariable+" eating");}


    public int getAvariable() {
        return Avariable;
    }
}
class Dog extends Animal{
    int Avariable = 10;
    void eat(){System.out.println( Avariable+" eating fruits");}


    @Override
    public int getAvariable() {
        return Avariable;
    }
}
class BabyDog extends Dog{
    int Avariable = 20;

    void eat(){

        System.out.println(Avariable+ " drinking milk");}



    @Override
    public int getAvariable() {
        return Avariable;
    }
}
public class Multilevel {

    public static void main(String args[]){
        Animal a1,a2,a3;
        a1=new Animal();
        a2=new Dog();
        a3=new BabyDog();
        a1.eat();

        System.out.println(a1.getAvariable());
        a2.eat();
        System.out.println(a2.getAvariable());

        a3.eat();
        System.out.println(a3.getAvariable());

        System.out.println(a1.Avariable);
        System.out.println(a2.Avariable);
        System.out.println(a3.Avariable);




    }

}
class Bike{
    int speedlimit=90;
}
class Honda3 extends Bike {
    int speedlimit = 150;


}
class CheckVariablePolymorphism{

    public static void main(String args[]) {
        Bike obj = new Honda3();
        System.out.println(obj.speedlimit);//90
    }
}