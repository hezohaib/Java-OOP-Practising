package learning_oop;

abstract class PaymentMethod {
    String userName;

    PaymentMethod(String userName) {
        this.userName = userName;
    }
    
    abstract void pay(int amount);

    public void printReceipt(int amount) {
        System.out.println("RECIPT: " + userName + " had transfered the Rs: " + amount);
    }
}

class SadaPay extends PaymentMethod {
    String phoneNumber;

    SadaPay(String userName, String phoneNumber) {
        super(userName);
        this.phoneNumber = phoneNumber;
    }
    
    @Override 
    void pay(int amount) {
        System.out.println("Payment is transferring from SadaPay App ");
        System.out.println("OTP sent to " + phoneNumber);
        System.out.println("RS " + amount + " has successfully transferred.");
    }
}

class Bankcard extends PaymentMethod {
    String cardNumber;

    Bankcard(String username, String cardNumber) {
        super(username);
        this.cardNumber = cardNumber;
    }
    
    @Override
    void pay(int amount) {
        System.out.println("Payment is transferring from Bankcard ");
        System.out.println("System is scanning " + cardNumber + " Cardnumber ");
        System.out.println("RS :" + amount + " has been credit from your account ");
    }
}

public class PaymentApp {
    public static void main(String[] args) {
        System.out.println("<<< WELCOME TO THE PAYMENT APP >>>");
        
        SadaPay User1 = new SadaPay("Ali", "0311111111");
        User1.pay(1500);
        User1.printReceipt(1500);

        System.out.println("\n-----------------------------");

        Bankcard User2 = new Bankcard("Ahmed", "4214-xxxx-xxxx");
        User2.pay(5000);        
        User2.printReceipt(5000); 
    }
}