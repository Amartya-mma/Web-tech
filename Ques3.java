import java.util.Scanner;
import java.lang.Math;
class Marks{
    protected String name;
    protected int rno;
    protected double marks;
    //these data members are only needed in its own or a child class
    Marks(){
        this.marks = Math.random()*100; // to generate random marks b/w 0 to 100 ie out of 100
    }
}
class Physics extends Marks{
    static double sum = 0; // to maintain the sum of marks in physics
    Physics()
    {
        super();
        sum+=this.marks;
    }

}
class Chemistry extends Marks{
    static double sum = 0;     // to maintain the sum of marks in chemistry
    Chemistry()
    {
        super();
        sum+=this.marks;
    } 
}
class Mathematics extends Marks{
    static double sum = 0;   // to maintain the sum of marks in math
    Mathematics(){
    super();
    sum+=this.marks;
    }
}
class Ques3{
    public static void main(String args[]){
        Scanner inp = new Scanner(System.in);
        int num_of_students = 10;

        Marks m[] = new Marks[num_of_students];
        
        Physics phy[] = new Physics[num_of_students];
        Chemistry chem[] = new Chemistry[num_of_students];
        Mathematics math[] = new Mathematics[num_of_students];

        for(int i = 1; i <= num_of_students; i++){
            phy[i - 1] = new Physics();
            chem[i - 1] = new Chemistry();
            math[i - 1] = new Mathematics();      //initialise the phy, chem, math objects for each student

            phy[i - 1].rno = 
            chem[i - 1].rno = 
            math[i - 1].rno = i;                  //auto generation of roll number for each student

        }

        for(int i = 0; i < num_of_students; i++){
            System.out.println("Student rno:" + phy[i].rno);
            System.out.println("Sum of this students marks:" + (phy[i].marks + chem[i].marks + math[i].marks));
            System.out.println("Average of this students marks:" + (phy[i].marks + chem[i].marks + math[i].marks)/3);
            System.out.println();
        }
        System.out.println("sum of physics marks:" + Physics.sum);
        System.out.println("average of physics marks:" + Physics.sum/num_of_students);

        System.out.println("sum of Chemistry marks:" + Chemistry.sum);
        System.out.println("average of chemistry marks:" + Physics.sum/num_of_students);

        System.out.println("sum of Mathematics marks:" + Mathematics.sum);
        System.out.println("average of mathematics marks:" + Physics.sum/num_of_students);
    }
}
