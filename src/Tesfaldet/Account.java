package Tesfaldet;

public class Account {

    private double _balance=0.0;
    private double _interestRate=1.2;
    private int _accountNumber = 1000;
    private static int uid = 0;


    public Account() {
        uid++;
        this._accountNumber += uid;
    }

    public double getInterestRate()
    {
        return _interestRate;

    }

    public double getBalance()
    {
        return _balance;
    }

    public int getAccountNumber()
    {
        return _accountNumber;
    }

    public void setInterestRate(double rate) {
        this._interestRate = rate;
    }


    public void deposit(double deposit) {
        this._balance = this._balance + deposit;

    }
    public boolean withdrawal(double withdraw) {
        if(withdraw > this._balance) {
            System.out.println("Not enough balance to withdraw");
            return false;
        }
        this._balance = this._balance - withdraw;
        return true;
    }
}


/*
Börja med att implementera klassen Account som ska hantera följande information:


Kontonummer ska vara unika för hela banken, inte bara för en enskild kund (se Big Java Late Objects på s. 400
		Ladda ner Big Java Late Objects på s. 400för tips på lösning). Det första kontot som skapas får kontonummer
1001, nästa får kontonummer 1002 och så vidare. Kontonummer återanvänds inte, om ett konto tas bort så kommer
inget nytt konto att få dess kontonummer.

Man ska till exempel kunna utföra transaktioner (insättning/uttag), hämta kontonummer, beräkna ränta
(saldo * räntesats/100) samt hämta presentationsinformation om kontot: (kontonummer saldo kontotyp räntesats).

*/