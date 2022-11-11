import java.time.YearMonth;
class Customer{
    protected String first_name;
    protected String last_name;
    protected int age;
    protected int phone_number;
    protected boolean isMale;
    protected String city;
    //all these members should only be accesible in the same or a child class
    Customer(String first_name, String last_name, int age, int phone_number, boolean isMale, String city){
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.phone_number = phone_number;
        this.isMale = isMale;
        this.city = city;
    }
}
class Account extends Customer{
    private int acc_number;
    private double acc_balance;
    private int year_of_acc_opening;
    private String bank;
    //all these members cannot & should not be accessed outside this class

    Account(String first_name, String last_name, int age, int phone_number, boolean isMale, String city,
         String bank){
            //to initialize the base class data members
            super(first_name, last_name, age,phone_number,isMale,city);
            this.year_of_acc_opening = YearMonth.now().getYear(); //current year
            this.bank = bank;
            if(bank == "SBI") 
                {
                acc_number = ++(SBI.num_of_active_accounts); //auto increment account number for a given bank
                acc_balance = SBI.min_acc_balance;
                }
            if(bank == "ICICI") 
                {acc_number = ++(ICICI.num_of_active_accounts); //auto increment account number for a given bank
                acc_balance = ICICI.min_acc_balance;
                }
            
            if(bank == "PNB") 
                acc_number = ++(PNB.num_of_active_accounts); //auto increment account number for a given bank
                acc_balance = PNB.min_acc_balance;

            update();        //to accrue the interest acculumlated till the present year 

    }
    public void deposit(double amt){
        this.acc_balance+=amt;
    }
    public void withraw(double amt, double min_acc_balance){
        if(this.acc_balance - amt >= min_acc_balance)     
            this.acc_balance-=amt;
        else 
        {    
            System.out.println("invalid operation" );
            System.out.println("account balance cannot be less than " + min_acc_balance); //cant witdraw if post withdrawal amount is less than the minimum balance allowed
        }  
    }
    public void dispDetail(){
        System.out.println("Account number: " + this.acc_number);
        System.out.println("Account balance: " + this.acc_balance);
        System.out.println("Bank:" + bank);
        //not printing other details to avoid redundancy
    }
    private void update(){
        this.acc_balance = this.acc_balance + (SBI.sbi_interest/100)*this.acc_balance*(2023 - year_of_acc_opening); //for testing purposes the current year is taken 2023 so that some interest can be accrued, because the year of opening of account will be for this year 2022 and so will be the current year else we can use YearMonth.now().getYear() - year of opening to get the interest
        //assumed Simple Interest for simplification
    }

}
class RBI{
    protected static double interest_rate = 4.0;
    protected static double max_withrawal_limit = 50000;
    protected static double min_acc_balance = 1000;
    //fixed values provided by RBI to the various banks in India
}
class SBI extends RBI{
    public static int num_of_active_accounts = 0;               //static because all objects of the class have to share this and it is used to keep track of num of accounts to provide account number for a new account creation
    public static double sbi_interest = interest_rate + 3.5;    //cant override static memebers of the super class so we need to create a new memeber for different interest rate
    public void deposit(Account acc, double amt){      //deposit and withrawal need account info which they get through the object of the account from which money has to be transacted
        acc.deposit(amt);
    }
    public void withraw(Account acc, double amt){
        if(amt < max_withrawal_limit)                     //withrawal amount cant be greater than the withrawal limit
            acc.withraw(amt, SBI.min_acc_balance);
        else 
        {    
            System.out.println("invalid operation" );
            System.out.println("max withrawal limit is " + max_withrawal_limit);
        }    
    }
}
class ICICI extends RBI{
    public static int num_of_active_accounts = 0;               //static because all objects of the class have to share this and it is used to keep track of num of accounts to provide account number for a new account creation
    public static double icici_interest = interest_rate + 2.5;    //cant override static memebers of the super class so we need to create a new memeber for different interest rate
    public void deposit(Account acc, double amt){      //deposit and withrawal need account info which they get through the object of the account from which money has to be transacted
        acc.deposit(amt);
    }
    public void withraw(Account acc, double amt){
        if(amt < max_withrawal_limit)                     //withrawal amount cant be greater than the withrawal limit
            acc.withraw(amt, ICICI.min_acc_balance);
        else 
        {    
            System.out.println("invalid operation" );
            System.out.println("max withrawal limit is " + max_withrawal_limit);
        }    
    }
}
class PNB extends RBI{
    public static int num_of_active_accounts = 0;               //static because all objects of the class have to share this and it is used to keep track of num of accounts to provide account number for a new account creation
    public static double pnb_interest = interest_rate + 3.5;    //cant override static memebers of the super class so we need to create a new memeber for different interest rate
    public void deposit(Account acc, double amt){      //deposit and withrawal need account info which they get through the object of the account from which money has to be transacted
        acc.deposit(amt);
    }
    public void withraw(Account acc, double amt){
        if(amt < max_withrawal_limit)                     //withrawal amount cant be greater than the withrawal limit
            acc.withraw(amt, PNB.min_acc_balance);
        else 
        {    
            System.out.println("invalid operation" );
            System.out.println("max withrawal limit is " + max_withrawal_limit);
        }    
    }
}
class Ques2{
    public static void main(String args[]){
        //tester code
       SBI sbi = new SBI();
       PNB pnb = new PNB();
       ICICI icici = new ICICI();

       Account a1 = new Account("Amartya", "Sharma", 21, 42367, true, "chandigarh", "SBI");
       Account a2 = new Account("John", "Doe", 22, 40867, true, "delhi", "SBI");
       Account a3 = new Account("Jane", "Doe", 19, 86742, false, "mumbai", "PNB");
       Account a4 = new Account("Jack", "Sheets", 21, 49167, true, "tamil nadu", "ICICI");

        //to view changes after depositing 10000 in a1 account
       a1.dispDetail();
       System.out.println();
       sbi.deposit(a1, 10000);
       a1.dispDetail();
       System.out.println();

        //to view changes after depositing 10000 in a1 account
       a2.dispDetail();
       System.out.println();
       sbi.withraw(a2, 100000);
       System.out.println();
       a2.dispDetail();
       System.out.println();

        //display a3 & a4 accounts
       a3.dispDetail();
       System.out.println();

       a4.dispDetail();

       

    }
}