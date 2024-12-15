public class runnableInterfaceEx2 {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());
        // in the output of threads there is not particular sequence

        // Runnable method:
        Thread thr = new Thread(new Runnable(){
            @Override
            public void run()
            {
                System.out.println("I am from Thread1");
            }
        });
//        thr.start(); // only threads got start method.
//        thr.setPriority(10);
//        System.out.println(Thread.currentThread().getName());
        Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("I am from thread2");
            }
        });
//        thr2.start();
//        thr2.setPriority(1);
        thr.start();
        thr.join();
        thr2.start();
        thr2.join();

        System.out.println("I am from main Thread");    // for main thread default prority id 5 (Normal)
//        System.out.println(Thread.currentThread().getName());

    }
}
