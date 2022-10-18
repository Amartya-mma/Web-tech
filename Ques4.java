import java.util.Scanner;
class Ques4{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        while(n != 1){
            System.out.println(n);
            if((n & 1) != 0) n = n * 3 + 1;
            else n = n / 2;
        }
        System.out.println(n);
    }
}