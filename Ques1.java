import java.util.Scanner;
import java.util.Vector;
class Ques1{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);  
        int size = sc.nextInt();            // to get user defined size

        Vector v = new Vector(size);

        System.out.println("Enter elements (enter done when done)") 
        for(int i = 0; i < size; i++){
            String tmp = sc.next();
            if(tmp.equals("done"))           //when the user has no more elements but we have some space in the vector we break out of the loop
                break;
            else
                v.addElement(tmp);
        }

        for(int i = 0; i < v.size(); i++)
            System.out.println(v.elementAt(i));
    }
}