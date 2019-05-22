package week2.Collections.List.ArrayList;

import java.io.Serializable;
import java.util.*;

class Coordiantes implements Comparable<Coordiantes> , Serializable {
    private int xCoordinate;
    private int yCoordinate;

    public Coordiantes(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    @Override
    public String toString() {
        return "Coordiantes@"+this.hashCode()+"{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }

    static <T> void print(List<T> list){
        for (T element:list) {
            System.out.println(element.toString());

        }
    }

    static <T> void printCmd(T obj){
        System.out.println(obj.toString());
    }

    @Override
    public int compareTo(Coordiantes o) {
        if(o.xCoordinate >this.xCoordinate)
            return 1;
        else
          return 0;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}


public class ArrayListBasic {

    public static void main(String args[]){

     //initialization ----
        //parent class reference
        // 1
        List<Coordiantes> line = new ArrayList<Coordiantes>();

        line.add(new Coordiantes(2,3));
        line.add(new Coordiantes(4,5));
        line.add(new Coordiantes(8,44));
        line.add(new Coordiantes(7,8));



        line.forEach(point->{
            System.out.println(point.toString());
        });


        Coordiantes anotherlist[] = new Coordiantes[]{line.get(1),line.get(3)};

        System.out.println("created another list");

        for (Coordiantes coordiantes : anotherlist) {
            System.out.println(coordiantes.toString());

        }

        // type to
        //same class reference

        ArrayList<Coordiantes> arrayList =(ArrayList<Coordiantes>) line;

        //convert array to list and add them all
        arrayList.addAll(Arrays.asList(anotherlist));

        line.forEach(point->{
            System.out.println(point.toString());
        });

        ArrayList<Coordiantes> arrayList1= new ArrayList<Coordiantes>(5);

       arrayList1.addAll(arrayList);


//-----------------------------Methods-----------------------------------------

     //   void add(int index, E element)     It is used to insert the specified element at the specified position in a list.

     //boolean add(E e)    It is used to append the specified element at the end of a list.
     //boolean addAll(Collection<? extends E> c)  It is used to append all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator.


        //boolean addAll(int index, Collection<? extends E> c)  : It is used to append all the elements in the specified collection, starting at the specified position of the list.

        arrayList.addAll(arrayList);

        Coordiantes.print(arrayList);



        //void clear()  : It is used to remove all of the elements from this list.

        arrayList.clear();
        Coordiantes.print(arrayList);

        //void ensureCapacity(int requiredCapacity) : It is used to enhance the capacity of an ArrayList instance.
        Coordiantes.printCmd("ensure capacity");

        arrayList.addAll(arrayList1);
        Coordiantes.printCmd(arrayList.size());

        //E get(int index)  It is used to fetch the element from the particular position of the list.

        Coordiantes.printCmd(arrayList.get(1));
        //boolean isEmpty() It returns true if the list is empty, otherwise false.

        System.out.println(arrayList.isEmpty());


        //int lastIndexOf(Object o) //
        // :It is used to return the index in this list of the last occurrence of the specified element, or -1 if the list does not contain this element.

        Coordiantes.printCmd(arrayList.lastIndexOf(anotherlist[1]));

        //Object[] toArray() It is used to return an array containing all of the elements in this list in the correct order.

        Coordiantes.printCmd("converted Arraylist to object Array");
        Object[] objects = arrayList.toArray();

      //  Coordiantes[] newArray = (Coordiantes[]) objects;  //type cast

        //<T> T[] toArray(T[] a) :It is used to return an array containing all of the elements in this list in the correct order.

//        Coordiantes.printCmd("converted Arraylist to Coordinates Array");
//        Coordiantes[] anotherArray1 = new Coordiantes[arrayList.size()];
//        anotherArray1=arrayList.toArray(anotherArray1);


        //Object clone()  :It is used to return a shallow copy of an ArrayList.

        List<Coordiantes> secondAl= (List<Coordiantes>) arrayList.clone();
        Coordiantes.printCmd(secondAl);



        //boolean contains(Object o) : It returns true if the list contains the specified element

        //int indexOf(Object o) : It is used to return the index in this list of the first occurrence of the specified element, or -1 if the List does not contain this element.

        //E remove(int index) : It is used to remove the element present at the specified position in the list.

        //boolean remove(Object o): It is used to remove the first occurrence of the specified element.

        //boolean removeAll(Collection<?> c): It is used to remove all the elements from the list.

        //boolean removeIf(Predicate<? super E> filter) : It is used to remove all the elements from the list that satisfies the given predicate.

        //protected void removeRange(int fromIndex, int toIndex) : It is used to remove all the elements lies within the given range.

        //void replaceAll(UnaryOperator<E> operator): It is used to replace all the elements from the list with the specified element.

        //void retainAll(Collection<?> c) : It is used to retain all the elements in the list that are present in the specified collection.

        //E set(int index, E element)

        //It is used to replace the specified element in the list, present at the specified position.


        //void sort(Comparator<? super E> c) ; It is used to sort the elements of the list on the basis of specified comparator.





        //Spliterator<E> spliterator() : It is used to create spliterator over the elements in a list.

        //List<E> subList(int fromIndex, int toIndex) : It is used to fetch all the elements lies within the given range.

        //int size() It is used to return the number of elements present in the list.


        //void trimToSize() :It is used to trim the capacity of this ArrayList instance to be the list's current size.


//----------------------listiterator---------------------


        ListIterator<Coordiantes> pointIterator = arrayList.listIterator(arrayList.size());

        while(pointIterator.hasPrevious()){

            Coordiantes obj = pointIterator.previous();
            Coordiantes.printCmd(obj);
        }


//----------------------------iterator

        Iterator<Coordiantes> iterator = arrayList.iterator();

        while(iterator.hasNext()){

            Coordiantes obj = iterator.next();
            obj.setxCoordinate(88);
            //Coordiantes.printCmd(obj);

        }


        //--------------------------------------








    }


}
