import java.lang.Math;
import java.util.Scanner;
class ques5{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= 4; j++){
                int ans = (int)Math.pow(i,j);
                System.out.print(ans);
                System.out.print(" ");
            }
            System.out.println("");
        }

    }
}