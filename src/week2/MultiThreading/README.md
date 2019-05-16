###MULTI THREADING

 executing multiple threads
 
 thread = light weight sub-process
 
 advantages:
  
 1. perform multiple operations at the same time
 1. saves time
 1. if thread broke then it doesn't effect other threads since it is 
    independent.
   
  
 Runnable interface
    void run();
    
    
 Thread method:
 
 Thread scheduler:
 
   part of jvm it decides which thread should run
   only one thread at a time runs in single process
   
   Preemptive scheduling: highest priority completes first
   
   Time sclicing : predefined time for each process
                   and reenters pool of ready threads
                   
   
    
    
    
    