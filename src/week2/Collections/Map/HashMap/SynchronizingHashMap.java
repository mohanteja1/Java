package week2.Collections.Map.HashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

public class SynchronizingHashMap {
    //what we are trying to achieve is HashMap is not thread safe so we have to
    //explicitly Synchronize concurrent modification

    static void increaseScore(int increament,Map<String,Integer> Scores,String university){

        synchronized (Scores){
            int score = Scores.get(university);
            Scores.put(university,score+increament);
        }


    }


    public static void main(String args[]){



        Map<String,Integer> adaptiveUscores = Collections.synchronizedMap(new HashMap<String,Integer>());

        // take for example AdaptiveU of Full user visits universities and scores in the university depends on the videos watched

        //current scores
        adaptiveUscores.put("H-RInduction",120);
        adaptiveUscores.put("Full",230);

        // now i opened multiple tabs in the browser and watching different videos from same university (FULL)

        //lets create 10 tabs .No these 10 tabs acts on these Scores
        ExecutorService executorService=  newFixedThreadPool(10);

        //create task
        Runnable task=()->{

            increaseScore(2,adaptiveUscores,"Full");
        };

        for(int i = 0; i < 100; i++) {
            executorService.submit(task);
        }

        executorService.shutdown();


        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (Exception e){
            e.printStackTrace();
        }


        System.out.println(adaptiveUscores);



    }




}
