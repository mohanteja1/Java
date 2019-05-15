package week2.Collections.List.LinkedList;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

class Human implements Comparable<Human> , Serializable {

    String humanName ;
    int age ;
    String ethinicity;

    public Human(String humanName, int age, String ethinicity) {
        this.humanName = humanName;
        this.age = age;
        this.ethinicity = ethinicity;
    }

    @Override
    public String toString() {
        return "Human{" +
                "humanName='" + humanName + '\'' +
                ", age=" + age +
                ", ethinicity='" + ethinicity + '\'' +
                '}';
    }

    @Override
    public int compareTo(Human o) {

        //less than 0 -> indicates that the object is before the passed in object.
        //more than 0 -> the object is after the passed object
        //equal to 0 -> the two objects are at same level


        if(o.age>this.age)
            return 1;
        else
            return -1;
    }
}


public class LinkedListBasics {

    public static void main(String args[]){

//lined list 1
        LinkedList<Human> humans = new LinkedList<Human>();
        humans.add(new Human("h1",21,"arabian"));
        humans.add(new Human("h2",22,"indian"));
        humans.add(new Human("h3",12,"cucassian"));
        humans.add(new Human("h4",55,"american"));
        humans.add(new Human("h5",6,"maxican"));
        humans.add(new Human("h6",2,"arab"));
        humans.add(new Human("h7",13,"african"));
        humans.add(new Human("h8",28,"european"));
        humans.add(new Human("h9",15,"chinese"));


// humans2

        LinkedList<Human> humans1 = new LinkedList<Human>();
        humans1.add(new Human("hh1",21,"arabian"));
        humans1.add(new Human("hh2",22,"indian"));
        humans1.add(new Human("hh3",12,"cucassian"));
        humans1.add(new Human("hh4",55,"american"));
        humans1.add(new Human("hh5",6,"maxican"));
        humans1.add(new Human("hh6",2,"arab"));
        humans1.add(new Human("hh7",13,"african"));
        humans1.add(new Human("hh8",28,"european"));
        humans1.add(new Human("hh9",15,"chinese"));
        humans1.add(new Human("h9",15,"chinese"));


     //sort

        humans.addFirst(new Human("man",33,"indian"));

        System.out.println("beforeSort" + humans);

        humans.sort(Human::compareTo);

        System.out.println("afterSort" + humans);

      //iterators
        Iterator<Human> iterator = humans.descendingIterator();

        while(iterator.hasNext()){

            System.out.println(iterator.next().toString());
        }


        System.out.println(humans.get(3).toString());
        System.out.println(humans.getFirst().toString());
        System.out.println(humans.getLast().toString());

       System.out.println(humans.contains(humans1.getLast()));

       humans.retainAll(humans1);

       System.out.println("after retianing all" + humans);

       // iteratoring

        humans.forEach(human -> {
            System.out.println(human.toString());
        });

         



       humans.clear();
       humans1.clear();




    }

}
