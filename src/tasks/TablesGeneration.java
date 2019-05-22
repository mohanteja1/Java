package tasks;

import java.util.Scanner;

public class TablesGeneration {
    public static void generateMultiplicationTable(int tableNo ,int range){
        for(int i =1 ;i<=range;i++)
        {
            System.out.println(String.format("%d * %d = %d",tableNo,i,tableNo*i));
        }

    }

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the multiplication table you want");
        int tableNo = Integer.parseInt(scanner.next());
        generateMultiplicationTable(tableNo,10);


    }










}
