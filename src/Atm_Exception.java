import java.util.Scanner;

class User_Balance{


    private int balance=10000;
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String errorMessage){
        super(errorMessage);
    }
}
class InvalidAmountException extends Exception{
    public InvalidAmountException(String errorMessage2){
        super(errorMessage2);
    }
}

public class Atm_Exception {

    static void withdraw(int amount,int balance) throws InsufficientFundsException, InvalidAmountException {
        if(amount>balance){
            throw new InsufficientFundsException("Withdraw amount greater than balance");
        }
        else if(amount<=0){
            throw new InvalidAmountException("Withdraw amount is Invalid");
        }
        else{
            System.out.println("New Balance is "+(balance-amount));
        }
    }
    static void deposit(int amount,int balance) throws InvalidAmountException {
        if(amount<=0){
            throw new InvalidAmountException("Deposit amount is Invalid");
        }
        else{
            System.out.println("New Balance is "+(balance+amount));
        }
    }


    public static void main(String[] args){
        User_Balance userBalance=new User_Balance();


        Scanner scanner=new Scanner(System.in);

        int option;
        do {
            System.out.print("Enter 1 to Deposit or 2 to Withdraw or 3 to check balance or 4 to exit: ");

            option = scanner.nextInt();

            int amount;
            try {
                if (option == 1) {
                    System.out.println("Enter amount to deposit: ");
                    amount = scanner.nextInt();
                    deposit(amount, userBalance.getBalance());
                    userBalance.setBalance(amount+ userBalance.getBalance());
                }
                else if (option ==2) {
                    System.out.println("Enter amount to withdraw: ");
                    amount = scanner.nextInt();
                    withdraw(amount, userBalance.getBalance());
                    userBalance.setBalance(userBalance.getBalance()-amount);
                }
                else if (option ==3){
                    System.out.println("Balance :"+userBalance.getBalance());
                }
                else if (option ==4){
                    break;
                }
                else{
                    System.out.println("Invalid option");
                }
            } catch (InvalidAmountException invalidAmountException) {
                System.out.println(invalidAmountException.getMessage());
            } catch (InsufficientFundsException insufficientFundsException) {
                System.out.println(insufficientFundsException.getMessage());
            }
        }
        while(true);


    }
}