import java.util.Random;

public class BankAccount {
    Random rand = new Random();
    private String customerName;
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    private static int accounts;
    private static double totalMoney;

    public BankAccount(String customerName, double checkingBalance, double savingsBalance){
        this.customerName = customerName;
        this.accountNumber = createAccountNumber();
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        accounts++;
        totalMoney += (checkingBalance+savingsBalance);
        System.out.println("Account #"+this.accountNumber+" has been created account for: "+ customerName);
    }
    // GETTERS:
    public double getSavingsBalance(){
        return this.savingsBalance;
    }
    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public static int getAccountCount(){
        return accounts;
    }
    public static double getTotalMoney(){
        return totalMoney;
    }
    //METHODS:
    public void depositSavings(double amount){
        System.out.printf("Depositing $%.2f to %s's savings acct.\n",amount,this.customerName);
        this.savingsBalance += amount;
        totalMoney += amount;
    }
    public void depositChecking(double amount){
        System.out.printf("Depositing $%.2f to %s's checking acct.\n",amount,this.customerName);
        this.checkingBalance += amount;
        totalMoney += amount;
    }
    public void withdrawSavings(double amount){
        if(amount>this.savingsBalance){
            System.out.println("Sorry, insufficient funds.");
        } else {
            System.out.printf("Withdrawing $%.2f to %s's savings acct.\n",amount,this.customerName);
            this.savingsBalance -= amount;
            totalMoney -= amount;
        }
    }
    public void withdrawChecking(double amount){
        if(amount>this.checkingBalance){
            System.out.println("Sorry, insufficient funds.");
        } else {
            System.out.printf("Withdrawing $%.2f to %s's checking acct.\n",amount,this.customerName);
            this.checkingBalance -= amount;
            totalMoney -= amount;
        }
    }
    public void printBalances(){
        System.out.printf("The checking balance in this account is $%.2f.\n",this.checkingBalance);
        System.out.printf("The savings balance in this account is $%.2f.\n",this.savingsBalance);
    }
    private String createAccountNumber(){
        String acctNum = "";
        for(int i = 0 ; i<10; i++){
            Integer digit = rand.nextInt(10);
            // System.out.println(digit);
            acctNum += digit;
        }
        // System.out.println("returning acctNum: "+acctNum);
        return acctNum;
    }

}