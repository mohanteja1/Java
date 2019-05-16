package week2.MultiThreading;

class ThreadCreationUsingRunnable implements Runnable{

    @Override
    public void run() {

        System.out.println("created thread ");
    }

}

class ThreadCreationUsingThreadExtension extends Thread{

    public void someFunction(){
        System.out.println("crated thread");
    }



}




public class ThreadMethods {
    public static void main(){

        //get curent thread name
        System.out.println(Thread.currentThread().getName());



        // thread creation using Runnable interface

        ThreadCreationUsingRunnable threadCreationUsingRunnable = new ThreadCreationUsingRunnable();
        Thread thread1 = new Thread(threadCreationUsingRunnable);
        thread1.start();


        // thread creation by extending Thread class

        ThreadCreationUsingThreadExtension threadCreationUsingThreadExtension = new ThreadCreationUsingThreadExtension();
        threadCreationUsingThreadExtension.start();


        //thread creation using Anonymous class
        System.out.println("Creating Runnable...");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside : " + Thread.currentThread().getName());
            }
        };


        System.out.println("Creating Thread...");
        Thread thread = new Thread(runnable);


        //thread creation using lambda expression

        Runnable runnable2 = () -> {
            System.out.println("Inside : " + Thread.currentThread().getName());

        };


        //Thread anonymous creation

        // Create Thread 1
        Thread thread2 = new Thread(() -> {
            System.out.println("Entered Thread 2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Exiting Thread 2");
        });

        thread2.start();

   // thread 2







        //public void run(): is used to perform action for a thread.




        //public void start(): starts the execution of the thread.JVM calls the run() method on the thread.

        //public void sleep(long miliseconds): Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds.

        //public void join(): waits for a thread to die.


        //public void join(long miliseconds): waits for a thread to die for the specified miliseconds.

        //public int getPriority(): returns the priority of the thread.

        //public int setPriority(int priority): changes the priority of the thread.

        //public String getName(): returns the name of the thread.

        //public void setName(String name): changes the name of the thread.

        //public Thread currentThread(): returns the reference of currently executing thread.

        //public int getId(): returns the id of the thread.



        //public Thread.State getState(): returns the state of the thread.

        //public boolean isAlive(): tests if the thread is alive.

        //public void yield(): causes the currently executing thread object to temporarily pause and allow other threads to execute.

        //public void suspend(): is used to suspend the thread(depricated).

        //public void resume(): is used to resume the suspended thread(depricated).

        //public void stop(): is used to stop the thread(depricated).

        //public boolean isDaemon(): tests if the thread is a daemon thread.

        //public void setDaemon(boolean b): marks the thread as daemon or user thread.

        //public void interrupt(): interrupts the thread.

        //public boolean isInterrupted(): tests if the thread has been interrupted.

        //public static boolean interrupted(): tests if the current thread has been interrupted.





    }

}
