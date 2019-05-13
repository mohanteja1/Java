package week1.StringsStringBuffersStringBuilders;


import java.util.ArrayList;

public class StringMethods {

    public static void main(String arg[]){
        String name = "mohanteja";

        System.out.println(name.length());
        System.out.println(name.concat("chitturi"));
        System.out.println(name.charAt(4));
        String string = String.format("name of the person is : %s",name );
        System.out.println(string);
        //sub string
        String s1= "mohanteja" ;
        System.out.println(s1.substring(2,4));
        System.out.println(s1.substring(2));

        //boolean contains(CharSequence sequence)

        String name1="what do you know about me";
        System.out.println(name1.contains("do you know"));
        System.out.println(name1.contains("about"));
        System.out.println(name1.contains("hello"));

        //public static String join(CharSequence delimiter, CharSequence... elements)
        //and
        //public static String join(CharSequence delimiter, Iterable<? extends CharSequence> elem

        String joinedString = String.join("=","ac" ,"ad","ba");
        System.out.println(joinedString);

        String date = String.join("/","30","12","1996");
        System.out.println(date);

        // String equals

        String s3= "java";
        String s4= "java";
        String sd = "c++";
        System.out.println(s1.equals(s4));
        System.out.println(s3.equals(s4));


  // usage of equals

        String str1 = "Mukesh";
        ArrayList<String> list = new ArrayList<>();
        list.add("Ravi");
        list.add("Mukesh");
        list.add("Ramesh");
        list.add("Ajay");
        for (String str : list) {
            if (str.equals(str1)) {
                System.out.println("Mukesh is present");
            }
        }

   // boolean isEmpty()

        String ran = "";
        System.out.println(ran.isEmpty());


        //concat

        String s11="java string";
        s11.concat("is immutable");
        System.out.println(s11);
        s11=s11.concat(" is immutable so assign it explicitly");
        System.out.println(s11);


   //replace

        String ReplaceString= s11.replace('a','t');
        System.out.println(ReplaceString);
        ReplaceString = s11.replace("java" ,"c++");
        System.out.println(ReplaceString);


        //equalIgnoreCase() regionalMatches()

        // split()

        String str = "mohanteja";
        System.out.println("Returning words:");
        String[] arr = str.split("t", 0);
        for (String w : arr) {
            System.out.println(w);
        }

        //indexOf
        String s21="this is index of example";
         //passing substring
        int index1=s21.indexOf("is");//returns the index of is substring
        int index2=s21.indexOf("index");//returns the index of index substring
        System.out.println(index1+"  "+index2);//2 8

         //passing substring with from index
        int index3=s21.indexOf("is",4);//returns the index of is substring after 4th index
        System.out.println(index3);//5 i.e. the index of another is

          //passing char value
        int index4=s21.indexOf('s');//returns the index of s char value
        System.out.println(index4);//3


        //intern() returns string from string pool






    }




}
