public class interupt {
    public static void main(String[] args)
    {
        test9 thr = new test9();
        thr.start();
        thr.interrupt();    // only works when thread is in sleeping or waiting state.
    }
}

class test9 extends Thread
{
    @Override
    public void run()
    {
        try
        {
            for(int i=0;i<5;i++)
            {
                System.out.println(i);
                Thread.sleep(2000);
            }
        }catch (Exception e)
        {
            System.out.println("Thread Interupted");
        }

    }
}

