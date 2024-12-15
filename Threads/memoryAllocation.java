class Test extends Thread {
    public void run() {
        int a = 5;
        addMethod();
    }

    public void addMethod() {
        int b = 6;
        resultMethod();
    }

    public void resultMethod() {
        StackTraceElement[] k = this.currentThread().getStackTrace(); // curentThread is a static method
        for (StackTraceElement s : k) {
            System.out.println(s.getMethodName());
        }
        System.out.println("Here is the result");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.start(); // Start the thread
    }
}

//run - contains the logic and entry point of thread. defines what thread will do.
//start() - creates a new thread and execute run() concurrently.
