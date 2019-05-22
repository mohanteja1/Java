package tasks;

import java.util.Scanner;

public class MealCost {

    public static void main(String[] args) {
        int tipPercentage,taxPercentage;
        double bill;

        Scanner scanner = new Scanner(System.in);

        bill = scanner.nextDouble();
        tipPercentage= scanner.nextInt();
        taxPercentage= scanner.nextInt();

        int totalBill=(int)Math.round((bill + (bill*( (double)tipPercentage/100))+(bill*((double)taxPercentage/100))) );
        System.out.println(String.format("The total bill is %d dollars",totalBill));

    }


}
