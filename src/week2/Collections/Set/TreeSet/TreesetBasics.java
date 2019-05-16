package week2.Collections.Set.TreeSet;

import java.util.TreeSet;

public class TreesetBasics {
    public static void main(String arg[]){
        TreeSet<String> Brands = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Brands.add("Ntpc");
        Brands.add("Axis Bank");
        Brands.add("Walmart");
        Brands.add("State Grid");
        Brands.add("Sinopec");
        Brands.add("China Natural Petroleum");
        Brands.add("Volkswagen");
        Brands.add("BP");
        Brands.add("Exxon Mobil");
        Brands.add("Berkshire Hathaway");
        Brands.add("Apple");
        Brands.add("Alphabet ");
        Brands.add("Tencent");
        Brands.add("Alibaba");
        Brands.add("Amazon");
        Brands.add("Facebook");
        Brands.add("Facebook");


        Brands.forEach(System.out::println);


        //methods are similar to treeMap
        //poll first last etc

        //remove
        Brands.removeIf(name -> name=="Apple");

        System.out.println("after removing apple");

        Brands.forEach(System.out::println);








    }


}
