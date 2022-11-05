class Employee{
    private String name;                  //all members made private to ensure the security so that they are accessible only through public set/get functions
    private int year_of_joining;
    private String address;
    Employee(String name, int year_of_joining, String address){    //to initalize the objects of the employee class
        this.name = name;
        this.year_of_joining = year_of_joining;
        this.address = address;
    } 
    void print_details(){                        //to print the attributes of an instance of the employee class
        System.out.println(this.name + " " + this.year_of_joining + " " + this.address);
    }
}
class Ques2{
    public static void main(String args[]){
        Employee emp1 = new Employee("Robert", 1994, "64C- WallStreat");
        Employee emp2 = new Employee("Sam   ", 2000, "64D- WallStreat");
        Employee emp3 = new Employee("John  ", 1999, "26B- WallStreat");
        System.out.println("Name    Year of Joining    Address");
        
        emp1.print_details();
        emp2.print_details();
        emp3.print_details();

    }

}