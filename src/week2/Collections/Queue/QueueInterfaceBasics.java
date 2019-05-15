package week2.Collections.Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueInterfaceBasics {
    public static void main(String arg[]){

//initialization with parent reference to linkedlist

        Queue<String> theatreQueue = new LinkedList<String>();

        theatreQueue.add("mohanteja");
        theatreQueue.add("aman");
        theatreQueue.add("john deep");
        theatreQueue.add("bill gates");
        theatreQueue.add("Warren buffet");
        theatreQueue.add("dontknowHisName");

        System.out.println("the theatre list "+ "\\n" +theatreQueue);

        //remove() method
        System.out.println(theatreQueue.remove());

        //pool() similar to remove() and it returns null if the queue is empty


           System.out.println(theatreQueue.poll());


           // isempty();

            //size();


               //get the element at the front of the queue using element() method
              // throws NoSuchElementException
             String person = theatreQueue.element();

             System.out.println(person);

             //peek() is similar to element() method but it returns null if empty
             System.out.println(theatreQueue.peek());

             //iterators are same

          theatreQueue.forEach(pers ->{
              System.out.println(pers);

          });

        Iterator<String> iterator = theatreQueue.iterator();

        iterator.forEachRemaining(guy ->{
            System.out.println(guy);

        });

        







    }

}
