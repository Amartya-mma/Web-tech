
import java.util.Scanner;
class ques3{
    public static void main(String[] args){


        Scanner input = new Scanner(System.in);
        int month = input.nextInt();               //input month number

        switch(month){
            case 1:
            {
                System.out.println("Month: January, Days: 31");
                break;
            }
            case 2:
            {
                System.out.println("Month: February, Days: 28");
                break;
            }
            case 3:
            {
                System.out.println("Month: March, Days: 31");
                break;
            }
            case 4:
            {
                System.out.println("Month: April, Days: 30");
                break;
            }
            case 5:
            {
                System.out.println("Month: May, Days: 31");
                break;
            }
            case 6:
            {
                System.out.println("Month: June, Days: 28");
                break;
            }
            case 7:
            {
                System.out.println("Month: July, Days: 31");
                break;
            }
            case 8:
            {
                System.out.println("Month: August, Days: 31");
                break;
            }
            case 9:
            {
                System.out.println("Month: September, Days: 30");
                break;
            }
            case 10:
            {
                System.out.println("Month: October, Days: 31");
                break;
            }
            case 11:
            {
                System.out.println("Month: November, Days: 30");
                break;
            }
            case 12:
            {
                System.out.println("Month: December, Days: 31");
                break;
            }
        }
    }
}
