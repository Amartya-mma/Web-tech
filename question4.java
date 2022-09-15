public class question4{
    public static void main(String[] args){
        
        
        int a = 10;
        int b = 20;

        
        System.out.println("ques 4:");

        System.out.println("Before swapping, a: " + a + " b: " + b);


        //using temp variable
        int temp = a;
        a = b;
        b = temp;

        System.out.println("After swapping, a: " + a + " b: " + b);


        System.out.println("Before swapping, a: " + a + " b: " + b);


        //without using temp
        a = a^b;
        b = a^b;
        a = b^a;

        System.out.println("After swapping, a: " + a + " b: " + b);




    }
}