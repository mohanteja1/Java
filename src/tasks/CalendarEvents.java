package tasks;
//task
/*Nishanth wants to add his meetings and other events to Calendar as day basis and wants to retrieve the events for the given date.

Constraints:
 1.  Date - a valid date in (dd-MM-YYYY) format
 2.  events for the day can have events name, time

 He can add any number of events for any number of dates.

 Once added the events, he should be able to retrieve any particular date events by passing date as input.
*/

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.codehaus.groovy.util.ListHashMap;

import java.io.*;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//--------------------------------------------Day class----------------------------------------------//
class Day implements Comparable<Day>,Serializable {

    private Date date = null;
    private Multimap<Time,String> events = null;

    public Day() {
        events= ArrayListMultimap.create();
    }

    public Day(String date, Multimap<Time, String> events) {
        this.date = convertFormatedDateToDate(date);
        this.events = events;
    }

    public Date convertFormatedDateToDate(String Date) {

         return null;
    }

    public String getDateInRequiredFormat() {

        return null;
    }

    public void addEvent(Time time,String eventName){
        this.events.put(time,eventName);
    }

    @Override
    public int compareTo(Day o) {
        return 0;
    }
}
//--------------------------------------------Day class----------------------------------------------//


//---------------------------------------------memory RW code-------------------------------------------------//
class MemoryStorage implements Runnable {
    int task;
    boolean serialize;
    boolean deserialize;
    String filename;

    //data to be stored
    TreeMap<Date,Day> dataToBeStored = null;
    TreeMap<Date,Day> dataTeBeSent=null;

    public int getTask() {
        return task;
    }

    public TreeMap<Date, Day> getDataTeBeSent() {
        return dataTeBeSent;
    }

    public void setTask(int task) {
        this.task = task;
    }

    public boolean isSerialize() {
        return serialize;
    }

    public void setSerialize(boolean serialize) {
        this.serialize = serialize;
    }

    public boolean isDeserialize() {
        return deserialize;
    }

    public void setDeserialize(boolean deserialize) {
        this.deserialize = deserialize;
    }

    @Override
    public void run() {
        if(deserialize)
            deserializePreviousData(task,filename);

        if(serialize)
            serializeCurrentData(dataToBeStored,filename);
    }

    public MemoryStorage(int task,boolean serialize,boolean deserialize,String filename,TreeMap<Date,Day> dataToBeStored) {
        this.task = task;
        this.serialize=serialize;
        this.deserialize=deserialize;
        this.filename=filename;
        this.dataToBeStored=dataToBeStored;
    }

    private void serializeCurrentData(TreeMap<Date,Day> data, String fileName) {

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);

            objectOutputStream.close();
            outputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }

    }

    private void deserializePreviousData(int task,String filename) {

        try {
            //create files if not found
            //create file,object streams
            if (task == 1 ) {
                File contactsFile = new File(filename);
                contactsFile.createNewFile();
                ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(filename));
                this.dataTeBeSent= (TreeMap<Date, Day>) objectInputStream1.readObject();
                objectInputStream1.close();

            }


        } catch(EOFException e){
            e.printStackTrace();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
//---------------------------------------------memory RW code-------------------------------------------------//


public class CalendarEvents {


    //flags
    boolean DEBUG_CODE = true;
    String dataFileName = "events.txt" ;
    Scanner scanner = new Scanner(System.in);
    TreeMap<Date,Day> daysWithEvents;

    //--------------------------------------------saving state of application-------------------------------//
    private void serialize(){
        Runnable task = new MemoryStorage(1,true,false,dataFileName,daysWithEvents);
        ExecutorService serializeService = Executors.newSingleThreadExecutor();
        serializeService.submit(task);
        serializeService.shutdown();
        while(!serializeService.isTerminated()){

        }
    }

    private void deserialize(){
        ExecutorService deserializaionService = Executors.newSingleThreadExecutor();
        Runnable task = new MemoryStorage(1,false,true,dataFileName,daysWithEvents);
        deserializaionService.submit(task);
        deserializaionService.shutdown();
        //wait for the threads to close
        while(!deserializaionService.isTerminated()){

        }
        MemoryStorage memoryStorage = (MemoryStorage) task;
        daysWithEvents = ((MemoryStorage) task).getDataTeBeSent();

    }

    private void exit() {

        //check for closing files and stream readers and writers if any and close
        //serialize the data once before closing
        serialize();
        System.exit(0);

    }


    //--------------------------------------------saving state of application-------------------------------//




    //------------------------------------------display part------------------------------------------------//
    private void menuDisplay(boolean needWelcome) {
        //displays menu or options available
        if(needWelcome)
            System.out.println("Hello user Welcome to the Calendar Events Application");

        System.out.println("----------------------Options-------------------------");
        System.out.println("\t 1.Add event");
        System.out.println("\t 2.List Events of a particular date");
        System.out.println("\t 3.Show all the Events Stored");
        System.out.println("\t 4.Exit");
        System.out.println("please enter your choice :");
    }








    //------------------------------------------display part------------------------------------------------//

    private void searchEventByDate(String date) {


    }

    public void getEventDetailsFromUser( ) {

    }



    public void addEvent(){
        System.out.println("Do you want to consider today's date" + );





    }



    public void runApplication(){

        // variables
        boolean doNotExitVariable = true;
        int optionInput = 0;
        final int NO_OF_THREADS = 1;

        // deserialize data on boot/start ----- retrieve previous data stored in the file
        deserialize();

        while (doNotExitVariable) {
            menuDisplay(true);
            optionInput = scanner.nextInt();


            //menu selection

            switch (optionInput) {
                case 1:
                    //add event

                    break;
                case 2:

                    //list event of particulat day

                    break;
                case 3:
                    //show all events

                    break;
                case 4:
                    //exit application

                    exit();

                    break;
                default:
                    System.out.println("please enter valid input [1-4]");
                    break;

            }


        }


    }
    }



class Driver{
    public static void main(String[] args) {
        CalendarEvents calendarEvents = new CalendarEvents();
        calendarEvents.runApplication();
    }
}