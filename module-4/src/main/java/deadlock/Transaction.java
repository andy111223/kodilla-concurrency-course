package deadlock;

public class Transaction {
    public static void main(String[] args) {

        final Bank bank = new Bank();

        final BankAccount firstAccount = new BankAccount("First account", 3000.0);
        final BankAccount secondAccount = new BankAccount("Second account", 2000.0);

        final Thread bankUser1 = new Thread(() -> bank.transfer(firstAccount, secondAccount, 500));
        final Thread bankUser2 = new Thread(() -> bank.transfer(secondAccount, firstAccount, 300));

        bankUser1.start();
        bankUser2.start();
    }
}
