 import java.util.Scanner;
 class ques1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double score = input.nextDouble();        //take the score input

        if(score > 80 && score < 90) score+=5;

        System.out.println(score);                 
    }
}

