public class interupttedMethod {
    public static void main(String[] args)
    {
        test10 thr = new test10();
        thr.start();
        thr.interrupt();    // only works when thread is in sleeping or waiting state.
    }
}

class test10 extends Thread
{
    @Override
    public void run()
    {
//        System.out.println(Thread.currentThread().isInterrupted()); // true but it will not change it to false
        System.out.println("A : " + Thread.interrupted()); // prints and converts true -> false
        try
        {
            for(int i=0;i<5;i++)
            {
                System.out.println(i);
                Thread.sleep(2000); // so this will know that thread will not interupt so it'll cotinue // false value of interupt
                System.out.println("B : " + Thread.interrupted());
            }
        }catch (Exception e)
        {
            System.out.println("Thread Interupted");
        }

    }
}

