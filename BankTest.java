// package java_stack.oop.bankAccount;

public class BankTest {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount("John", 50,500);
        BankAccount account2 = new BankAccount("Jenny", 60,600);
        BankAccount account3 = new BankAccount("Katie", 70,700);
        account1.depositChecking(30);
        account1.printBalances();
        account2.depositSavings(25);
        account2.printBalances();
        account3.depositChecking(46);
        account3.printBalances();
        System.out.printf("The bank holds accounts for %d customers and has a total of $%.2f in assets.",BankAccount.getAccountCount(), BankAccount.getTotalMoney());
    }
}
