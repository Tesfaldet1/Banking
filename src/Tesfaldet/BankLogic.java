package Tesfaldet;

import java.util.ArrayList;

public class BankLogic {


    //private static final int SavingAccount = 0;
    static ArrayList<Customer> _customers = new ArrayList<Customer>();

    public static void main(String[] args) {

        System.out.println("BankLogic Class running below!");

        //System.out.println("Customers before createCustomer: " + _customers);
        createCustomer();
        //ArrayList<String> theCustomer = getCustomer("8505221898");
        //System.out.println( theCustomer);

        //Account acc = getAccount("8505221898", 1002);
        //System.out.println( acc.getAccountNumber() + " " + acc.balance + " " + acc.interestRate);

		/*String newPNo = "8505221898";
		if(changeCustomerName("Aron", "Fili", newPNo)) {
			for(int i=0; i<_customers.size(); i++) {
				System.out.println("Customer nr: " + (i+1) + " name: "+ _customers.get(i).first_name + " " + _customers.get(i).last_name + " pNr: " + _customers.get(i).personal_number
						+ " account number: " + _customers.get(i).account.AccountNumber);
			}
		} else {
			System.out.println("No customer with " + newPNo + " that personal number ");
		}*/

        String newPNo = "8505221898";
        // System.out.println(getCustomer(newPNo) );

        //getAllCustomers();

        //deposit(1002, 230.5);
        //withdrawal(newPNo, 1002, 75.9);

        //closeAccount(newPNo, 1002);

        ArrayList<String> deletCustomer = deleteCustomer(newPNo);
        System.out.println("this customer " + deletCustomer +" is deleted" );

        getAllCustomers();
    }

    public static void createCustomer() {



        String 	customerName;
        String 	customerSurname;
        String 	personalNumber;

        customerName = "Olle";
        customerSurname = "Ohlsson";
        personalNumber = "0005221898";

        Customer newCustomer = new Customer(customerName, customerSurname, personalNumber);
        _customers.add(newCustomer);
        createSavingAccount(newCustomer);
        customerName = "Karl";
        customerSurname = "Carlsson";
        personalNumber = "8505221898";

        Customer newCustomer2 = new Customer(customerName, customerSurname, personalNumber);
        createSavingAccount(newCustomer2);
        _customers.add(newCustomer2);

        // #4 Create customer with a persunal number that already exists
        customerName = "Donald";
        customerSurname = "Duck";
        personalNumber = "8505221898";

        Customer newCustomer3 = new Customer(customerName, customerSurname, personalNumber);
        createSavingAccount(newCustomer3);
        _customers.add(newCustomer3);

        // #5 Create customer
        customerName = "Pelle";
        customerSurname = "Persson";
        personalNumber = "6911258876";

        newCustomer = new Customer(customerName, customerSurname, personalNumber);
        createSavingAccount(newCustomer);
        _customers.add(newCustomer);

        // #6 Create customer
        customerName = "Lotta";
        customerSurname = "Larsson";
        personalNumber = "7505121231";

        newCustomer = new Customer(customerName, customerSurname, personalNumber);
        createSavingAccount(newCustomer);
        _customers.add(newCustomer);

    }

    public static ArrayList<Customer> getAllCustomersTesfe() {
        return _customers;
    }

    public static ArrayList<String> getAllCustomers() {

        ArrayList<String> allCustomers = new ArrayList<String>();

        for(int i=0; i<_customers.size(); i++) {

            allCustomers.add(_customers.get(i).getFirstname());
            allCustomers.add(_customers.get(i).getLastname());
            allCustomers.add(_customers.get(i).getPersonalNumber());
            allCustomers.add(String.valueOf(_customers.get(i).getAccount().getAccountNumber()));
        }

        for(int i=0; i<allCustomers.size(); i++) {

            System.out.println(allCustomers.get(i));
        }
        return allCustomers;
    }

    public static ArrayList<String> getCustomer(String pNr){
        ArrayList<String> customer = new ArrayList<String>();
        for(int i=0; i<_customers.size(); i++) {
            if(_customers.get(i).getPersonalNumber().equals(pNr)) { //ketewadadr keleka string entade koynu
                customer.add(_customers.get(i).getFirstname());
                customer.add(_customers.get(i).getLastname());
                customer.add(_customers.get(i).getPersonalNumber());
                customer.add(String.valueOf(_customers.get(i).getAccount().getAccountNumber()));
                break;
            }
        }
        return customer;
    }

    public static Account getAccount(String pNo, int accountId) {
        Account theAccount = new Account();
        for(int i=0; i<_customers.size(); i++) {
            if(_customers.get(i).getPersonalNumber().equals(pNo) && _customers.get(i).getAccount().getAccountNumber() == accountId ) {
                theAccount = _customers.get(i).getAccount();
                break;
            }
        }
        return theAccount;
    }

    public static boolean changeCustomerName(String name, String surname, String pNo) {
        for(int i=0; i<_customers.size(); i++) {
            if(_customers.get(i).getPersonalNumber().equals(pNo)) {
                _customers.get(i).setFirstname(name);    // first_name = name;
                _customers.get(i).setLastname(surname);    //.last_name = surname;
                return true;
            }
        }
        return false;

    }

    public static int createSavingAccount(Customer customer) {

        for (int i = 0; i<_customers.size(); i++) {
            if(customer.createSavingAccount()) {
                // System.out.println(getCustomer(cus.personal_number));
                return customer.getAccount().getAccountNumber();
            }
        }
        return -1;
    }

    public static boolean deposit(int AccountNumber, double amount) {
        for (int i = 0; i < _customers.size(); i++){
            if (_customers.get(i).getAccount().getAccountNumber() == AccountNumber){
                _customers.get(i).getAccount().deposit(amount);
                System.out.println("the account is ");
                System.out.println(_customers.get(i).getAccount().getAccountNumber());
                System.out.println(_customers.get(i).getAccount().getBalance());
                System.out.println(_customers.get(i).getAccount().getInterestRate());
                return true;
            }
        }
        return false;

    }

    public static boolean withdrawal(String pNo, int accountId, double amount) {
        for (int i = 0; i < _customers.size(); i++){
            if (_customers.get(i).getPersonalNumber().equals(pNo) && _customers.get(i).getAccount().getAccountNumber() == accountId){
                _customers.get(i).getAccount().withdrawal(amount);
                System.out.println("you withdrew: ");
                System.out.println(amount);
                System.out.println("remaining is ");
                System.out.println(_customers.get(i).getAccount().getBalance());


            }

        }
        return false;
    }

    public static boolean closeAccount(String pNo, int accountId) {
        for (int i = 0; i < _customers.size(); i++){
            if (_customers.get(i).getPersonalNumber().equals(pNo) && _customers.get(i).getAccount().getAccountNumber() == accountId){
                _customers.get(i).getAccount().withdrawal(accountId);
                System.out.println("this accountID is : "+ accountId  + ":  closed");
                return true;



            }

        }
        return false;

    }

    public static ArrayList<String> deleteCustomer(String pNo) {
        ArrayList<String> customer = new ArrayList<String>();
        for (int i = 0; i < _customers.size(); i++){
            if (_customers.get(i).getPersonalNumber().equals(pNo)) {
                if(_customers.get(i).deleteCustomer(_customers.get(i))) {
                    customer.add(_customers.get(i).getFirstname());
                    customer.add(_customers.get(i).getLastname());
                    customer.add(_customers.get(i).getPersonalNumber());
                    customer.add(String.valueOf(_customers.get(i).getAccount().getAccountNumber()));
                    _customers.remove(_customers.get(i));
                    break;
                }
            }
        }
        return customer;
    }
}


/*

 "public" tebay-abdege "static" tebay-abwushti "boolean/Account/int" nay-wuxit-aynet shim-method(tiwesdo-aynet/aynetat mis shimu){
 	eti mesrih

 	timelso-wuxit;
 }
 */
