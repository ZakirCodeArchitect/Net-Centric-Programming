import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;

public class writeCharactersThread {
    public static void main(String[] args)
    {
        processfile1 file1 = new processfile1();       // thread is created over here
        // if file1.run(); then thread is not created simple method is created.
        file1.start();  // thread is started -> thread is invoked but is only done once, if done again it'll throw exception.
        System.out.println("Writing in File A");

    }
}
// thread class:
class processfile1 extends Thread
{
    // independent path of execution 1
    // we here in thread class override the run() method to specify the task directly within the thread class.
    // this approach coupled the task with the thread, which can also limit the reusability.
    @Override
    public void run()   // it is an abstract method
    {
        File file1 = new File("fileA.txt");
        // must be written in try-catch block -> Mandatory
        try
        {
            FileOutputStream fout = new FileOutputStream(file1);
            for(int i=0;i<100;i++)
            {
                System.out.println("Writing in File A: " + i);
                fout.write(i);
            }
            fout.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}

/*
    -> 2    Ways to create a thread:
        1. Thread ( class ).            -> java.lang
        2. Runnable ( Interface ).      -> predefined interface. ( Better way , increased performances )

    -> LIFE CYCLE OF THREAD: using Thread(class)
        1. thread is created.
        2. thread is sent to runnable state.    // JVM allocates processor to thread. Thread scheduler decides which thread to call to get started based on algorithms like short-job-first etc.
        3. thread is running.
        4. thread can also go to sleep state, waiting state , temporarily suspends the execution. ( going to non-runnable state ).
        5. thread after completion is dead.

 */