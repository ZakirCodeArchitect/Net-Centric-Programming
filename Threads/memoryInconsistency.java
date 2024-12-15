public class memoryInconsistency {
    public static void main(String[] args) throws InterruptedException
    {
        account zakir = new account(20000);
        Thread thr1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                for(int i=0;i<50;i++)
                {
                    zakir.withdraw(100);
                }
            }
        });

        Thread thr2 = new Thread(new Runnable() {
           @Override
           public void run()
           {
               for(int i=0;i<50;i++)
               {
                   zakir.withdraw(100);
               }
           }
        });

        thr1.start();
        thr2.start();
        // without using join method, main thread will not wait for the thr1 and thr2 to complete their execution and instead just go to prints the balance.
        thr1.join();
        thr2.join();

        System.out.println("Current Balance:" + zakir.balance);
    }
}

class account
{
    public int balance;

    //constructer
    public account(int deposit)
    {
        this.balance = deposit;
    }

    public void withdraw(int amount)
    {
        this.balance = this.balance - amount;
    }

}