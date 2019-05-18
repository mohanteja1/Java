package week2.Collections.Map.HashMap;

import java.util.*;

public class HashMapBasics {
    public static void main(String args[]){

//initialization
        Map<String,Integer> wordsHashCode = new HashMap<String, Integer>();
        wordsHashCode.put("mohanteja","mohanteja".hashCode());
        wordsHashCode.put("mohanteja1","mohanteja1".hashCode());
        wordsHashCode.put("mohanteja2","mohanteja2".hashCode());
        wordsHashCode.put("mohanteja3","mohanteja3".hashCode());
        wordsHashCode.put("mohanteja4","mohanteja4".hashCode());
        wordsHashCode.put("mohanteja5","mohanteja5".hashCode());
        wordsHashCode.put("mohanteja6","mohanteja6".hashCode());

        System.out.println(wordsHashCode.get("mohan"));




        //iteration or traversing : note Map has to be converted to set traverse

         wordsHashCode.forEach((word,hashcode)->{

             System.out.println(word + " " + hashcode);
         });






         // hash maps entry set

        Set<Map.Entry<String,Integer>> wordAndHcodes = wordsHashCode.entrySet();

        Iterator<Map.Entry<String,Integer>> iterator =  wordAndHcodes.iterator();

        while(iterator.hasNext()){
            Map.Entry<String,Integer> entryObject = iterator.next();
            System.out.println("Entryobject key = " + entryObject.getKey() + "and" + "Entryobject Value =" + entryObject.getValue());


        }


        //another method

        wordsHashCode.entrySet().forEach(element->{
            //do something here

        });



        //yep this is new
        wordAndHcodes.forEach(System.out::println);

        // only hashcodes
        //since keys should be unique right so the KeySet() return a Set
        // values can be similar so values() returns Collection

        Set<String> words = wordsHashCode.keySet();
        Collection<Integer> hashcode = wordsHashCode.values();

        hashcode.forEach(element->{
            System.out.println(element);
        });





















    }

}
