public class threadEx1 {
    public static void main(String[] args)
    {
        System.out.println("Main ThreadId : " +
                Thread.currentThread().getId()
        );
//        Thread1 thr1= new Thread1();
        for(int i=0;i<3;i++)
        {
            new Thread1().start();
        }

        PrintNumbers.printNumbers();
    }
}

class Thread1 extends Thread
{
    @Override
    public void run()
    {
        System.out.println("Thread1 id: " +
                Thread.currentThread().getId()
        );
        PrintNumbers.printNumbers();
    }
}

class PrintNumbers
{
    static public void printNumbers()
    {
        for(int i=0;i<100;i++)
        {
            System.out.println(
                    Thread.currentThread().getId() + " : " + i
            );
        }
    }
}
