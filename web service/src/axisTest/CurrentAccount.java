package axisTest;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CurrentAccount extends Account {

    private long creditCardNumber;
    private double overdraft;
    long smallest = 1000_0000_0000_0000L;
    long biggest =  9999_9999_9999_9999L;

    public CurrentAccount(){

        this.creditCardNumber= ThreadLocalRandom.current().nextLong(smallest, biggest+1);

    }


    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public void withdraw(double solde){


    }

}
