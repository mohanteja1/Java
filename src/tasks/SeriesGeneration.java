package tasks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//We use the integers a, b, and n to create the following series:
//
//(a + 2^0 * b), (a + 2^0 * b + 2^1 * b), ...... , (a + 2^0 * b + 2^1 * b + ... + 2^n-1 * b)
//
//You are given q queries in the form of a, b, and n. For each query, print the series corresponding to the given a, b, and n values as a single line of n space-separated integers.
//
//Input Format
//
//The first line contains an integer, q, denoting the number of queries.
//Each line i of the q subsequent lines contains three space-separated integers describing the respective a, b, and n values for that query.
//
//Constraints:
//0 <= q <= 500
//0 <= a,b <= 50
//1 <= n <= 15
//
//Output Format
//
//For each query, print the corresponding series on a new line. Each series must be printed in order as a single line of n space-separated integers.
//
//Sample Input:
//
//2
//0 2 10
//5 3 5
//
//Sample Output:
//
//2 6 14 30 62 126 254 510 1022 2046
//8 14 26 50 98
public class SeriesGeneration {
    public static void generateSeries(int a,int b,int n){
          //generate this series
        //(a + 2^0 * b), (a + 2^0 * b + 2^1 * b), ...... , (a + 2^0 * b + 2^1 * b + ... + 2^n-1 * b)

        int value=a;

        for(int i =0; i<n;i++) {
            value= (int)(value + Math.pow(2,i)*b);
            System.out.print(String.format("%d ",value));
        }
        System.out.println();
    }

    public static void main(String args[]) throws  Exception{
        int testCases ;
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(reader.readLine());
        //testCases = Integer.parseInt(st.nextToken());

        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextInt();
       // System.out.println(testCases);
        String testcase=null;
        scanner.nextLine();
        while(testCases-- > 0){

            String tokenString=scanner.nextLine();
           // System.out.println(tokenString);
           StringTokenizer st1 = new StringTokenizer(tokenString);
           generateSeries(Integer.parseInt(st1.nextToken()),Integer.parseInt(st1.nextToken()),Integer.parseInt(st1.nextToken()));


        }

    }



}
