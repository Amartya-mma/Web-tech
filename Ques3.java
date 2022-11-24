class Calculator{
    int num1, num2;
    int addition(String a, String b){
        try{
            num1 = Integer.parseInt(a);    //throws number format exception if a is an non integer value
            num2 = Integer.parseInt(b);
            return num1 + num2;            //if no exception then return the ans
        }
        catch(Exception e){
            System.out.println(e);         //else print the exception
        }
        return -1;
    }
    int subtraction(String a, String b){
        try{
            num1 = Integer.parseInt(a);
            num2 = Integer.parseInt(b);
            return num1 - num2;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return -1;
    }
    int division(String a, String b){
        try{
            num1 = Integer.parseInt(a);
            num2 = Integer.parseInt(b);
            return num1 / num2;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return -1;
    }
    int multiplication(String a, String b){
        try{
            num1 = Integer.parseInt(a);
            num2 = Integer.parseInt(b);
            return num1 * num2;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return -1;
    }

}
class Ques3{
    public static void main(String args[]){
        //tester code
        Calculator obj = new Calculator();
        System.out.println(obj.addition("an", "cj"));      
        System.out.println(obj.subtraction("an", "cj"));
        System.out.println(obj.division("an", "cj"));
        System.out.println(obj.division("an", "cj"));
        System.out.println(obj.addition("10", "10"));
        System.out.println(obj.subtraction("10", "10"));
        System.out.println(obj.division("10", "10"));
        System.out.println(obj.division("10", "10"));


    }
}