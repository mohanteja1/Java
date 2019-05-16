package week2.Collections.Map.LinkedHashMap;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class WebSites implements Comparable<WebSites>,Cloneable, Serializable {
    String ip;
    String domainName;
    int users;

    public WebSites(String ip, String domainName, int users) {
        this.ip = ip;
        this.domainName = domainName;
        this.users = users;
    }

    @Override
    public int compareTo(WebSites o) {
        if(this.users>o.users)
            return 1;
        if(this.users<o.users)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "WebSites{" +
                "ip='" + ip + '\'' +
                ", domainName='" + domainName + '\'' +
                ", users=" + users +
                '}';
    }




}



public class LinkedHashMapBasics {
    public static void main(String args[]){


        Map<Integer,WebSites> portMatching = new LinkedHashMap<Integer, WebSites>();

        WebSites webSites=new WebSites("123.0.1.44","google.com",400);
        portMatching.put(30,new WebSites("123.0.1.44","google.com",400));
        portMatching.put(31,new WebSites("123.0.1.42","yahoo.com",500));
        portMatching.put(32,new WebSites("123.0.3.3","web.com",600));
        portMatching.put(33,new WebSites("123.0.44.32","facebook.com",422));
        portMatching.put(34,new WebSites("123.0.22.55","redit.com",421));
        portMatching.put(35,new WebSites("123.0.22.44","netflix.com",424));
        portMatching.put(36,new WebSites("123.0.44.33","amazon.com",445));
        portMatching.put(37,new WebSites("123.0.22.33","random.com",467));
        portMatching.put(38,new WebSites("123.0.23.55","abandonware.com",433));
        portMatching.put(39,new WebSites("123.0.45.44","ransomeware.com",498));

        //its is not gonna put this in the map since it is already availabale
        portMatching.putIfAbsent(33,new WebSites("122.33.44.54","facebook",4000));



         System.out.println(portMatching);


         // containskey() ,containsValue(),

        System.out.println(portMatching.containsKey(33));


        // Map.Entry now compareByvalue reverse etc

        Iterator<Map.Entry<Integer,WebSites>> iterator = portMatching.entrySet().iterator();

        portMatching.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        System.out.println("comparingbyvalue");

        portMatching.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        System.out.println("comparingByValue in reverse order");

        portMatching.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

        //sort by costume object values
        System.out.println("sort by custome object values in a map");
        portMatching.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, WebSites>>() {
            @Override
            public int compare(Map.Entry<Integer, WebSites> o1, Map.Entry<Integer, WebSites> o2) {
             return new Integer(o1.getValue().users).compareTo(new Integer(o2.getValue().users)) ;
            }
        }).forEach(System.out::println);




    }



}
