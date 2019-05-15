package week2.Collections.Queue.PriorityQueue;

import java.util.PriorityQueue;

class Employees implements Comparable<Employees>{

    String EmployeeId ;
    String EmployeeGrade;

    public Employees(String employeeId, String employeeGrade) {
        EmployeeId = employeeId;
        EmployeeGrade = employeeGrade;
    }

    @Override
    public int compareTo(Employees o) {
        return this.EmployeeGrade.compareTo(o.EmployeeGrade);
    }
}



public class PriorityQueueBasics {

    public static void main(String arg[]){

        PriorityQueue<Employees> companyCanteen = new PriorityQueue<Employees>();

        companyCanteen.add(new Employees("233w","A"));
        companyCanteen.add(new Employees("222w","C"));
        companyCanteen.add(new Employees("211w","A"));
        companyCanteen.add(new Employees("234w","B"));
        companyCanteen.add(new Employees("210w","B"));
        companyCanteen.add(new Employees("255w","C"));

        System.out.println(companyCanteen);

        System.out.println(companyCanteen.add(new Employees("334m","A")));

        System.out.println(companyCanteen);

        companyCanteen.offer(new Employees("111m","D"));

        System.out.println(companyCanteen);

        companyCanteen.remove(companyCanteen.peek());

        System.out.println(companyCanteen);

        //poll = remove + retrieve head of the queue



        while(companyCanteen.isEmpty()){
            System.out.println(companyCanteen.remove());

        }





















    }



}
