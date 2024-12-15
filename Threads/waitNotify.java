public class waitNotify {
    public static void main(String[] args) throws InterruptedException {
        account5 zakir = new account5(2000);

        Thread thr1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    zakir.withdraw(30000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                zakir.deposit(40000);
            }
        });

        thr1.start();
        thr2.start();

        thr1.join();
        thr2.join();

        System.out.println("Amount: " + zakir.balance);

    }
}

class account5
{
    public int balance;

    public account5(int balance)
    {
        this.balance = balance;
    }

    public synchronized void withdraw(int amount) throws InterruptedException {
        System.out.println("Withdrawal !!!");
        if(amount>this.balance)
        {
            System.out.println("Waiting");
            wait();
        }
        System.out.println("Withdrawing amount currently!");
        this.balance = this.balance - amount;
    }

    public synchronized void deposit(int deposit)
    {
        System.out.println("I am depositing");
        this.balance = this.balance + deposit;
        System.out.println("Notifying");
        notify();
    }

}
