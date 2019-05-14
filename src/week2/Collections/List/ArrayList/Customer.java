package week2.Collections.List.ArrayList;

import java.util.List;

public class Customer {

    private String id;
    private String name;
    private List<Food> orderList;
    int calculteCost(){

        int totalcost =0;

        for (Food item:this.orderList) {
             totalcost += item.getCost();
        }

        return totalcost;

    }






    public Customer(String id, String name, List<Food> orderList) {
        this.id = id;
        this.name = name;
        this.orderList = orderList;
    }

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Food> getOrderList() {
        return orderList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrderList(List<Food> orderList) {
        this.orderList = orderList;
    }
}
