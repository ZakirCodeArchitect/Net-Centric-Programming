public class synchronize {
    public static void main(String[] args) throws InterruptedException
    {
        account3 zakir = new account3(20000);
        Thread thr1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    zakir.withdraw(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    zakir.deposit(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // without using join method, main thread will not wait for the thr1 and thr2 to complete their execution and instead just go to prints the balance.

        thr1.start();
        thr1.join();

        thr2.start();
        thr2.join();

        System.out.println("Current Balance:" + zakir.balance);
    }
}

class account3
{
    public int balance;

    //constructer
    public account3(int balance)
    {
        this.balance = balance;
    }

    // synchronized means that locked a block , only one thread can access it at one time for an object.
    public void withdraw(int amount) throws InterruptedException {
        synchronized (this) // only locking particular block of code not entire method.
        {
            System.out.println("Wait!! Currently withdrawing " + amount + " dollars");
            Thread.currentThread().sleep(9000);
            this.balance = this.balance - amount;
        }
        System.out.println("Money successfully withdrawn.");

    }

    public synchronized void deposit(int deposit) throws InterruptedException {
        System.out.println("Wait!! Depositing " + deposit + " dollars ");
        Thread.currentThread().sleep(9000); // holding the lock for 9 seconds
        this.balance = this.balance + deposit;
    }

}