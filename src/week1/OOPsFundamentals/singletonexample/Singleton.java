package week1.OOPsFundamentals.singletonexample;

import com.sun.org.apache.xalan.internal.xsltc.dom.SingletonIterator;

public class Singleton {

    int xCoordinate=23,yCoordinate=45;

    private static Singleton singleton = null;


    private Singleton(){
    }

    public static Singleton getInstance(){
        if(singleton==null)
        {
            singleton=new Singleton();
        }
        return singleton;
    }

    // addd your methods

    protected void modifySingletonContents(int xCoordinate,int yCoordinate){
        this.xCoordinate=xCoordinate;
        this.yCoordinate=yCoordinate;
    }

    protected void printCoordinates(){
        System.out.println("x coordinate = " + this.xCoordinate );
        System.out.println("y coordinate = " + this.yCoordinate );

    }


}
