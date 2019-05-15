package week2.Collections.Queue.ArrayDeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeBasic {

    public static void main(String args[]){


        Deque<String> deque = new ArrayDeque<String>();
        deque.add("mohan");
        deque.add("teja");
        deque.add("jsdjl");
        deque.add("kjdk");
        deque.add("jdkf");

        System.out.println(deque);

        //methods
        // poll();
        //pollFirst();
        //pollLast();

        System.out.println(deque.pollFirst());
        System.out.println(deque.poll());
        System.out.println(deque.pollLast());


        //offer() offerLast() offerFirst()

        //similar but insertion









    }

}
