public class notifyAll {
    public static void main(String[] args) throws InterruptedException {
        account8 zakir = new account8(2000);

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
                try {
                    zakir.withdraw(40000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thr3 = new Thread(new Runnable() {
            @Override
            public void run() {
                zakir.deposit(40000);
            }
        });

        thr1.start();
        thr2.start();
        thr3.start();

        thr1.join();
        thr2.join();
        thr3.join();

        System.out.println("Amount: " + zakir.balance);

    }
}

class account8
{
    public int balance;

    public account8(int balance)
    {
        this.balance = balance;
    }

    public synchronized void withdraw(int amount) throws InterruptedException {
        System.out.println("Withdrawal !!!");
        // Use while loop to keep checking until the balance is sufficient
        while (amount > this.balance) {
            System.out.println("Insufficient balance. Waiting...");
            wait(); // Thread waits until notified
        }
        // Proceed to withdraw after sufficient balance
        System.out.println("Withdrawing amount currently!");
        this.balance = this.balance - amount;
        System.out.println("Withdrawn " + amount + " successfully");
    }


    public synchronized void deposit(int deposit)
    {
        System.out.println("I am depositing");
        this.balance = this.balance + deposit;
        System.out.println("Notifying");
        notifyAll();
        System.out.println("Deposited " + deposit + " successfully");
    }

}
