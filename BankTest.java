// package java_stack.oop.bankAccount;

public class BankTest {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount("John", 50,500);
        BankAccount account2 = new BankAccount("Jenny", 60,600);
        BankAccount account3 = new BankAccount("Katie", 70,700);
        account1.deposit(30,'c');
        account1.printBalances();
        account2.deposit(25,'s');
        account2.printBalances();
        account3.deposit(46,'c');
        account3.printBalances();
        account3.withdraw(1000,'c');
        account3.withdraw(50,'c');
        account3.withdraw(50,'s');
        System.out.printf("The bank holds accounts for %d customers and has a total of $%.2f in assets.",BankAccount.getAccountCount(), BankAccount.getTotalMoney());
    }
}
