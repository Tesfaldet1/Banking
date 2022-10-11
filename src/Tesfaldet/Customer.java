package Tesfaldet;

public class Customer {

    private String _first_name = "";
    private String _last_name = "";
    private String _personal_number = "";
    private Account _account = null;


    public Customer(String name, String surname, String pNr) {
        this._first_name = name;
        this._last_name = surname;
        this._personal_number = pNr;
    }

    public String getFirstname()
    {
        return _first_name;
    }

    public String getLastname()
    {
        return _last_name;
    }

    public String getPersonalNumber()
    {
        return _personal_number;
    }

    public Account getAccount() {
        return this._account;
    }


    public void setFirstname(String name) {
        this._first_name = name;
    }

    public void setLastname(String surname) {
        this._last_name = surname;
    }

    public void setPersonalNumber(String pNr) {
        this._personal_number= pNr;
    }

    public boolean createSavingAccount() {
        if (this._account == null) {
            this._account = new Account();
            return true;
        }
        return false;
    }
    public boolean deleteCustomer(Customer customer) {
        if (customer._personal_number != null) {
			/*
			this._personal_number = "";
			this._first_name = "";
			this._last_name= "";
			this._account = null;
			*/
            customer = null;
            return true;
        }
        return false;

    }
}
