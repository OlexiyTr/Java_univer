import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class task_8 {
    public static void main(String[] args) {
        Account acc = new Account(757);
        Transaction[] transactions = {
                new Transaction(acc, 200),
                new Transaction(acc, 100),
                new Transaction(acc, 150),
                new Transaction(acc, 50),
                new Transaction(acc, 100),
                new Transaction(acc, 400)
        };

        for (Transaction t : transactions) {
            t.start();
        }

        for (Transaction t : transactions) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total:" + acc.get());
    }
}

class Account {

    private int money;
    private Lock lock = new ReentrantLock();

    public Account(int money) {
        this.money = money;
    }

    public int get() {
        return money;
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            if (money >= amount) {
                money -= amount;
            }
        } finally {
            lock.unlock();
        }
    }
}

class Transaction extends Thread {

    private Account account;
    private int amount;

    public Transaction(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(System.currentTimeMillis() % 50);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        account.withdraw(amount);
    }
}