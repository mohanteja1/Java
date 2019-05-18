package week2.Collections.Map.TreeMap;


import week2.Collections.Map.LinkedHashMap.WebSites;

import java.util.Comparator;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapBasics {
    public static void main(String args[]){

        TreeMap<Integer, WebSites> ipindexing = new TreeMap<Integer, WebSites>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        ipindexing.put(30,new WebSites("123.0.1.44","google.com",400));
        ipindexing.put(31,new WebSites("123.0.1.42","yahoo.com",500));
        ipindexing.put(32,new WebSites("123.0.3.3","web.com",600));
        ipindexing.put(33,new WebSites("123.0.44.32","facebook.com",422));
        ipindexing.put(34,new WebSites("123.0.22.55","redit.com",421));
        ipindexing.put(35,new WebSites("123.0.22.44","netflix.com",424));
        ipindexing.put(36,new WebSites("123.0.44.33","amazon.com",445));
        ipindexing.put(37,new WebSites("123.0.44.33","random.com",467));
        ipindexing.put(38,new WebSites("123.0.23.55","abandonware.com",433));
        ipindexing.put(39,new WebSites("123.0.45.44","ransomeware.com",498));

        //move the contents to hashmap

        HashMap<String,Integer> ipPortTable=new HashMap<String, Integer>();

        ipindexing.forEach((port,website)->{
            ipPortTable.put(website.getIp(),port);
        });

        System.out.println("detailsof iptable :" + ipPortTable);


        System.out.println("searching for website with port 33:");

        if(ipindexing.containsKey(33)){

            System.out.println(ipindexing.get(33).toString());
        }
        System.out.println("printing first entry and last entry");

        System.out.println(ipindexing.firstEntry().toString());
        System.out.println(ipindexing.lastEntry().toString());

        //find the key who is just less than the lower than the provided entry
        System.out.println("find the key who is just less than the lower than the provided entry 35:");

        System.out.println(ipindexing.lowerEntry(35)); //may return 36
        System.out.println("find the key who is just less than the higher than the provided entry 35 :");

        System.out.println(ipindexing.higherEntry(35)); // may return 34


        //removing entries
        System.out.println("remove a single entry");

        ipindexing.remove(34);

        System.out.println("print current tree");

        System.out.println(ipindexing);

        //remove first entry

        System.out.println("remove first entry and last entry using poll that returns object:");
        System.out.println(ipindexing.pollFirstEntry());
        //remove last entry
        System.out.println(ipindexing.pollLastEntry());


















    }

}
