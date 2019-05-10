package week1.OOPsFundamentals.singletonexample;

public class SingletonDemo {

    public static void main(String args[]){
        Singleton singleton = Singleton.getInstance();

        singleton.printCoordinates();

        singleton.modifySingletonContents(45,66);

        singleton.printCoordinates();

    }

}
