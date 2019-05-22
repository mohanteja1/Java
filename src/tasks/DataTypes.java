package tasks;

import java.util.Scanner;

/*Java has 8 primitive data types; char, boolean, byte, short, int, long, float, and double. For this exercise, we'll work with the primitives used to hold integer values (byte, short, int, and long):

A byte is an 8-bit signed integer.
A short is a 16-bit signed integer.
An int is a 32-bit signed integer.
A long is a 64-bit signed integer.

** Challenge to solve : Given an input integer, you must determine which primitive data types are capable of properly storing that input. **

Input Format:

The first line contains an integer T, denoting the number of test cases.
Each test case T, is comprised of a single line with an integer n, which can be arbitrarily large or small.

Output Format

For each input variable  and appropriate primitive n, you must determine if the given primitives are capable of storing it. If yes, then print:

n can be fitted in:
* dataType
If there is more than one appropriate data type, print each one on its own line and order them by size (i.e.: byte < short < int < long).

If the number cannot be stored in one of the four aforementioned primitives, print the line:

n can't be fitted anywhere.

Sample Input:

5
-150
150000
1500000000
213333333333333333333333333333333333
-100000000000000

Sample Output:

-150 can be fitted in:
* short
* int
* long
150000 can be fitted in:
* int
* long
1500000000 can be fitted in:
* int
* long
213333333333333333333333333333333333 can't be fitted anywhere.
-100000000000000 can be fitted in:
* long

Explanation:

-150 can be stored in a short, an int, or a long.

213333333333333333333333333333333333 is very large and is outside of the allowable range of values for the primitive data types discussed in this problem.
*/
public class DataTypes {


    public static boolean findDatatypesToStore(String value){

        boolean negative;
        boolean number=true;
        int dot=-1;

        if(value.charAt(0)=='-') negative = true;
        else negative = false;

        char digit;
        for(int i =0;i<value.length();i++){


            digit = value.charAt(i);

            if(digit=='.'){ dot=i; continue;}

            if(digit<'0' || digit >'9') number=false;

        }

        if(!number){
            System.out.println(value + " can't be fitted anywhere.");
            return false;
        }

        int lengthOfnumber=value.length() + (negative ? -1:0);

        boolean byteFlag=false,intFlag=false,shortFlag=false,longFlag=false;

        // check for byte short int long type

        if(dot<0){ //dot = -x indicates the number is not double or float type
            //byte
            if(lengthOfnumber <= 3 && lengthOfnumber > 0){
                if(Integer.parseInt(value)>-129 && negative)byteFlag=true;
                if(Integer.parseInt(value)<128 && !negative) byteFlag =true;
            }
            //short
            if(!byteFlag && lengthOfnumber <=5 && lengthOfnumber > 0){
                if(Integer.parseInt(value)> -32769 && negative) shortFlag=true;
                if(Integer.parseInt(value)< 32767 && !negative) shortFlag=true;
             }

            //int
            if(!shortFlag && lengthOfnumber <=10 && lengthOfnumber > 0){
                if(Integer.parseInt(value)>= -2147483648 && negative) intFlag=true;
                if(Integer.parseInt(value) <= 2147483647 && !negative) intFlag=true;
            }
            //long
            if(!intFlag && lengthOfnumber <=19 && lengthOfnumber > 0){
                if(Long.parseLong(value)>= Long.MIN_VALUE && negative) longFlag=true;
                if(Long.parseLong(value)<=Long.MAX_VALUE && !negative) longFlag=true;
            }

        }

        //print
        if(dot>=0 || !byteFlag && !shortFlag && !intFlag && !longFlag){
            System.out.println(value + " can't be fitted anywhere.");
            return false;
        }

        System.out.println(value + " can be fitted in:");
        if(byteFlag){
            System.out.println("* byte");
            System.out.println("* short");
            System.out.println("* int");
            System.out.println("* long");
            return true;
        }
        if(shortFlag){
            System.out.println("* short");
            System.out.println("* int");
            System.out.println("* long");
            return true;
        }

        if(intFlag){
            System.out.println("* int");
            System.out.println("* long");
            return true;
        }
        if(longFlag){
            System.out.println("* long");
            return true;
        }


        return  true;
    }



    public static void main(String[] args) {
        int testcases;
        String value=null;
        Scanner scanner = new Scanner(System.in);
        testcases= scanner.nextInt();

        while(testcases-- >0){

            value= scanner.next();
            findDatatypesToStore(value);

        }

    }
}
