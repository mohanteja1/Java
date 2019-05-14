package week1.StringsStringBuffersStringBuilders;
import java.util.Scanner;
import java.util.regex.*;


public class RegularExpressions {


     public static void main(String args[]){
         //steps 1.create pattern
         //      2.match it with the a string using matcher
         //      3. do operations required




         Pattern singleChar = Pattern.compile(".M"); //   .singleLetter
         Matcher matcher = singleChar.matcher("i am inevitable");
         boolean b= matcher.matches();

         System.out.print("is pattern matched: " + b);


          //single line code

         boolean isPatternMatched = Pattern.compile(".i").matcher("i am inevitable").matches(); //without creating any objects

         // .(dot) singlechar .s = second letter is s , ...s = fourth letter should be s


         System.out.println(Pattern.matches(".o","mohanteja")); //true

         System.out.println(Pattern.matches("...a","mohanteja"));

         System.out.println("[] brackets {] repeatition");
         /*  [abc] a or b or c
         *   [^abc] excluding a b c
         *   [a-bA-z] a to z and A to Z
         *   [a-d[m-p] = [a-dm-p]
         *   [a-z&&[def]] = a to z intersection d e f = d e f
         *   [a-z&&[^bc]] = a to z intersection [^bc] = a , d-z = [ad-z]
         *   ? occurs once or not at all
         *   + occurs once or more times
         *   * occurs zero or more times
         *   {n} occurs n times
         *   {y,z} occurs at least y times but less than z times
         *
         * */
         System.out.println(Pattern.matches("[abc]{2}","babb")); //makes sure first two letter are from abc
         System.out.println(Pattern.matches("[abc]{2}","rtbbabb")); //makes sure first two letter are from abc
         System.out.println();

         /*
         * Regex metachars
         *
         * . any character
         * \d any digit 0-9
         * \s any white space
         * \S any not white space character [^\s]
         * \w any word [a-zA-z_0-9]
         * \W any non word character [^\w]
         * \b avord boundary
         * \B an non word boundary
         *
         *
         * */

         System.out.println("metacharacters D....");// \\D means non-digit
         System.out.println("remember to type \\ double forward slash since they are escape characters ");


         System.out.println(Pattern.matches("\\D", "abc"));//false (non-digit but comes more than once)
         System.out.println(Pattern.matches("\\D", "1"));//false (digit)
         System.out.println(Pattern.matches("\\D", "4443"));//false (digit)
         System.out.println(Pattern.matches("\\D", "323abc"));//false (digit and char)
         System.out.println(Pattern.matches("\\D", "m"));


             Scanner sc=new Scanner(System.in);
             System.out.println("Enter regex pattern:");
             Pattern pattern = Pattern.compile(sc.nextLine());
             System.out.println("Enter text:");
             Matcher matcher1 = pattern.matcher(sc.nextLine());
             boolean found = false;
             while (matcher1.find()) {
                 System.out.println("I found the text " + matcher1.group() + " starting at index " +
                         matcher1.start() + " and ending at index " + matcher1.end());
                 found = true;
             }
             if (!found) {
                 System.out.println("No match found.");
             }









         }




}
