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
                   
   Runnable Vs Thread:
      : no multiple inheritance so Runnable is better
      
   Executors framework:
   
      1. easy to create more no of threads with single initialization
      1. multi threaded applications will have 1000 or more threads its 
         make sense to separate thread creation and management from 
         rest of application
      
   framework:
     helps u with:
        
        1. thread creation
        2. Thread Management
        3. Task submission and execution
     
   interfaces in the Java concurrency API    
       Executor 
       ExecutorService
       ScheduledExecutoService
       
       Executors class
    
    
    