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
    public void deposit(double amount, char accountType){
        System.out.printf("Depositing $%.2f to %s's %s acct.\n",amount,this.customerName, accountType =='c'? "Checking": "Savings");
        if(accountType == 'c'){
            this.checkingBalance += amount;
        } else 
        {
            this.savingsBalance += amount;

        }
        totalMoney += amount;
    }

    public void withdraw(double amount, char accountType){
        if(accountType == 's'){
            if(amount>this.savingsBalance){
                System.out.println("Sorry, insufficient funds.");
            } else {
                System.out.printf("Withdrawing $%.2f from %s's savings acct.\n",amount,this.customerName);
                this.savingsBalance -= amount;
                totalMoney -= amount;
            }
        } else
        {
            if(amount>this.checkingBalance){
                System.out.println("Sorry, insufficient funds.");
            } else {
                System.out.printf("Withdrawing $%.2f from %s's checking acct.\n",amount,this.customerName);
                this.checkingBalance -= amount;
                totalMoney -= amount;
            }
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
            acctNum += digit;
        }
        return acctNum;
    }

}