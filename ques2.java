 import java.util.Scanner;
class ques2{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();       //take 3 numbers as input
                                       //a -> number 1
                                       //b -> number 2
                                       //c -> number 3

       
       //checking if a is less than b and c
       if( a <= b && a <= c) 
       System.out.println(a);

       //checking if b is less than a and c
       else if( b <= a && b <= c) 
       System.out.println(b);

       //checking if c is less than b and a
       else
       System.out.println(c);


    }
}
