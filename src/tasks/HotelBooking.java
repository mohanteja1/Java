package tasks;
/*
Challenge:

Rohit would like to book a hotel with cheapest price for N number of days based on his preferred star rating.
 Each Hotel can have rating as (5star or 3star or 1star), and each hotel's per day cost is mentioned below.
  Based on Rohit's star preference and money he has, find if he can get any cheapest hotel.

Constraints:

 1.  N - no of days ranging from 1 to 31

 2.  star rating - will be any one of (5,3,1)

 3.  amount - the total amount Rohit can spent max.

 Hotel Details:

 1. The Park, 5 star hotel, will cost $90/day, but if customer stays more than 2 days, then customer gets 20% off on total cost.

 2. Hotel Hyaat, 5 star hotel, will cost $82/day, but if customer stays more than 3 days, then customer gets 12% off on total cost.

 3. Raddisson, 3 star hotel, will cost $60/day, but if customer stays more than 3 days, then customer gets 18% off on total cost.

 4. RainTree, 3 star hotel, will cost $58/day, but if customer stays more than 2 days, then customer gets 15% off on total cost.

 5. Accord, 1 star hotel, will cost $41.55/day, but if customer stays more than 3 days, then customer gets 11.8% off on total cost.

 6. Fortune, 1 star hotel, will cost $43/day, but if customer stays more than 4 days, then customer gets 14.8% on total cost.

Challenge:

Create a static method "bookHotel" with 3 arguments and return type as string,

 1. money (Double dataType) -  total amount customer has

 2. days  (Integer dataType) - no.of.days customer like to stay.

 3. rating (Integer dataType) - preferred star rating for the hotel.

 Based on given input, if cheapest hotel is found return string like below,

 'Hotel Booked for "days" days in "star" star Hotel "hotel name" for the cost of "totalCost for hotel"'

 Example:

 "Hotel Booked for 2 days in 3 star hotel The Park for the cost of $186.5"

 If no cheapest hotel is found for the customer, the return string like below,

Example:

 'Sorry! you dont have sufficient amount to book any hotel'


*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Hotel {
    private String hotelName;
    private double costPerDay;
    private int rating;
    private int stayDaysToGetOffer;
    private double offerPercentage;

    public Hotel(String hotelName, double costPerDay, int rating, int stayDaysToGetOffer, double offerPercentage) {
        this.hotelName = hotelName;
        this.costPerDay = costPerDay;
        this.rating = rating;
        this.stayDaysToGetOffer = stayDaysToGetOffer;
        this.offerPercentage = offerPercentage;
    }


    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getStayDaysToGetOffer() {
        return stayDaysToGetOffer;
    }

    public void setStayDaysToGetOffer(int stayDaysToGetOffer) {
        this.stayDaysToGetOffer = stayDaysToGetOffer;
    }

    public double getOfferPercentage() {
        return offerPercentage;
    }

    public void setOfferPercentage(int offerPercentage) {
        this.offerPercentage = offerPercentage;
    }

    public double calculateCost(int days) {

        return (costPerDay * days) * ((days > stayDaysToGetOffer) ? ((100.0 - offerPercentage) / 100) : (1));

    }

}

class HotelBooking {
    static List<Hotel> hotelList = new ArrayList<>();


    public static String bookHotel(double money, int days, int rating) {


        List<Hotel> searchList = new ArrayList<>();
        //now filter the rating and the money
        for (Hotel hotel : hotelList
        ) {
            if (hotel.getRating() >= rating && hotel.calculateCost(days) <= money) {
                searchList.add(hotel);
            }

        }
        //sort based on the descending order of cost;
        searchList.sort(new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
                double cost1 = o1.calculateCost(days);
                double cost2 = o2.calculateCost(days);
                return Double.compare(cost1, cost2);
            }
        });

        if(!searchList.isEmpty())
        return String.format("\"Hotel Booked for %d days in %d star Hotel %s for the cost of %f\"",days,searchList.get(0).getRating(),searchList.get(0).getHotelName(),searchList.get(0).calculateCost(days));
        else
            return "'Sorry! you dont have sufficient amount to book any hotel'";

    }

    public static void main(String[] args) {

        //hotels


        hotelList.add(new Hotel("The Park", 90, 5, 2, 20));
        hotelList.add(new Hotel("Hotel Hyaat", 82, 5, 3, 12));
        hotelList.add(new Hotel("Raddisson", 60, 3, 3, 18));
        hotelList.add(new Hotel("RainTree", 58, 3, 2, 15));
        hotelList.add(new Hotel("Accord", 41.55, 1, 3, 11.8));
        hotelList.add(new Hotel("Fortune", 43, 1, 4, 14.8));

        //take inputs from rohit:

        /* 1.  N - no of days ranging from 1 to 31
           2.  star rating - will be any one of (5,3,1)
           3.  amount - the total amount Rohit can spent max.*/



        Scanner scanner = new Scanner(System.in);

        int days,rating;
        double money;

        while(true){
            System.out.println("enter the details of your preffered search");
            System.out.println("enter amount of money you have");
            money=scanner.nextDouble();
            System.out.println("enter no of days you stay");
            days=Integer.parseInt(scanner.next());
            System.out.println("enter the hotel rating you preffer :");
            rating= Integer.parseInt(scanner.next());
            System.out.println(bookHotel(money,days,rating));

            System.out.println("do you want to search again ? enter : Y / N");
            if(scanner.next().equalsIgnoreCase("Y")) continue;
            else break;




        }

    }





}