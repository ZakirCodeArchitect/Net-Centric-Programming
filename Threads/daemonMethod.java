public class daemonMethod {
    public static void main(String[] args)
    {
        System.out.println("Main Thread"); // if this is not invoked there will be no ouput because only then daemon thread will do something when main thread will do something.
        daemon d = new daemon();
        d.setDaemon(true);
        d.start();
    }
}

class daemon extends Thread
{
    @Override
    public void run()
    {
        if(Thread.currentThread().isDaemon())
        {
            System.out.println("Daemon Thread");
        }
        else
        {
            System.out.println("Child thread");
        }
    }
}

/*

    -> Daemon Thread
        - runs in the background of the thread.
        - provides service to the threads.
        - Garbage collector, finalizer, spelling checker in WORD etc.
        - Methods:
            1. public final void setDaemon(boolean b)
            2. public final boolean isDaemon()
        - Programs:
            1. t.setDaemon(true)
        - Cases:
            1. set Daemon thread always before start() / starting the thread otherwise it'll give IllegalThreadStateException.
            2. We cannot create main thread as Daemon thread -> [ Thread.currentThread().setDaemon(true) ] this way it'll give Exception.

        - To get service from Daemon , start the main thread too.
        - Life of Daemon thread depends on the life of thread of the main thread or the thread on which it is running in background.
        - Properties of Daemon thread are inherited from its parent Thread. Priorities of both will be same. ( Nature ).
        - JVM role:
            1. JVM does not depend on Daemon thread,but it does depends on other threads.
                - For example: If all threads are completed , but Daemon thread is still not
                                in dead state, so JVM will put that Daemon thread in dead state and then shutdown.
        - Daemon thread has low priority but we can change it's priority according to our needs.

 */
