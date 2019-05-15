package week2.Collections.List.Stack;
import week2.Collections.List.LinkedList.*;

import java.util.Stack;

public class StackBasics {

    public static void main(String arg[]){


        //initialization  no primitive types or use wrapper classes

        Stack<Integer> integersStack = new Stack<Integer>();

        //important methods:
        //Object push(Object element)
        integersStack.push(new Integer(23));
        integersStack.push(new Integer(33));
        integersStack.push(new Integer(13));
        integersStack.push(new Integer(63));
        integersStack.push(new Integer(23));
        integersStack.push(new Integer(73));
        integersStack.push(new Integer(93));

        integersStack.forEach(integer ->{

            System.out.println(integer.toString());

        });
        //Object pop( )

        integersStack.pop();













        //Object peek( )

        System.out.println(integersStack.peek());










        //int search(Object element)
        // Searches for element in the stack. If found, its offset from
        // the top of the stack is returned. Otherwise, -1 is returned.


        System.out.println(integersStack.search(new Integer(22)));

        // boolean empty()
        integersStack.clear();

        System.out.println(integersStack.isEmpty()+""+integersStack.empty());



    }


}
