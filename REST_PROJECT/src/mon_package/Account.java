package mon_package;

import java.util.Date;

public class Account {

    public static int acountNumber=0;
    private double solde;
    public Date creationSDate;


    public Account(){
        acountNumber = acountNumber+1;
        this.solde=0;
        this.creationSDate= new Date();

    }

    public double getSolde() {
        return solde;
    }

    public void deposit(double solde) {
        this.solde =this.solde+ solde;
    }


    public void withdraw(){


    }
}
