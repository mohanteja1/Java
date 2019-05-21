package tasks;

//Nishanth wants to add his meetings and other events to Calendar as day basis and wants to retrieve the events for the given date.
//
//Constraints:
// 1.  Date - a valid date in (dd-MM-YYYY) format
// 2.  events for the day can have events name, time
//
// He can add any number of events for any number of dates.
//
// Once added the events, he should be able to retrieve any particular date events by passing date as input.

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;

class BusinessDay implements Comparable<BusinessDay>,Serializable {

    private Date date = null;
    private Multimap<Time,String> events=null;

    public BusinessDay() {
        events= ArrayListMultimap.create();
    }

    public BusinessDay(Date date, Multimap<Time, String> events) {
        this.date = date;
        this.events = events;
    }


    public void addEvent(Time time,String eventName){
        this.events.put(time,eventName);
    }


    @Override
    public int compareTo(BusinessDay o) {
        return 0;
    }
}
public class CalendarEvents {

    // map
    //to store entrys date and events
    Multimap<Date,BusinessDay> calendarEntries = TreeMultimap.create();



    public void addEvent(){



    }



    public void runApplication(){

        //greet
        //show options add,remove,list
        //


    }






}
