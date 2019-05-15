package week2.Collections.List.Vector;

import java.util.Enumeration;
import java.util.Vector;

public class VectorBasics {

public static void main(String arg[]){
    //constructors
    // Vector() //This creates a default vector, which has an initial size of 10.
    //Vector(int size) //This creates a vector whose initial capacity is specified by size.
    //Vector(int size, int incr) //This creates a vector whose initial capacity is specified by size and whose
    //increment is specified by incr. The increment specifies the number of elements to allocate each time
    //when a vector is resized for addition of objects.
    //Vector(Collection c)

    Vector<Integer> integerVector=new Vector<Integer>(10,10);

    for(int i=0;i<10;i++) {
        integerVector.set(i,new Integer(i));
    }



    //methods
    // void addElement(E element)	adds element to the Vector

    integerVector.addElement(new Integer(33));


    //E elementAt(int index)	returns the element at specified index

    System.out.println(integerVector.elementAt(10));

    //Enumeration elements()	returns an enumeration of element in vector

    Enumeration<Integer> list = integerVector.elements();

    System.out.println(list);



    //E firstElement()	returns first element in the Vector

    System.out.println(integerVector.firstElement());




    //E lastElement()	returns last element in the Vector

    System.out.println(integerVector.lastElement());
    //void removeAllElements()	removes all elements of the Vector
    integerVector.removeAllElements();






}

}

