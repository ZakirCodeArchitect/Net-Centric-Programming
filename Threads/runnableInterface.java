//import java.lang;

public class runnableInterface {
    public static void main(String[] args)
    {
        test t = new test();    // object of test class
        Thread thr = new Thread(t);     // object of thread class, t here tells in parameter which method to override.
        thr.start();    // start method is only in thread not in runnable interface that's why we first create thread above. [ starting the thread ]
    }
}
// test is not abstract and does not override abstract method run() in runnable.
class test implements Runnable
{
    // run() method is blank, means it does nothing so we override it to specify what work the thread should perform.
    @Override
    public void run()   // it is an abstract method
    {
        System.out.println("I am from the thread");
    }
}

/*
    -> Runnable is better than extending thread class because:
        1. once extended a class cannot extend it again.
        2. java does not allow multiple inheritance.
        3. Example:
            - class A extends B -> now class A cannot extend Thread
            - class A extends B implements Runnable -> now here implementing thread and also extending a class.
 */