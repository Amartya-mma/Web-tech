class Ques2{
    static int add(int num1, int num2){
        try{
            if(num1 < 0 || num2 < 0) throw new ArithmeticException("negative number");  //customized exception created
            return num1 + num2;                //return this in case of no exception
        }
        catch(ArithmeticException e){
            System.out.println(e);            //print the exception
        }
        return -1;                            //return -1 incase of an exception
    }
    static int subtract (int num1, int num2){
        try{
            if(num1 < 0 || num2 < 0) throw new ArithmeticException("negative number");
            return num1 - num2;

        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
        return -1;
    }
    public static void main(String args[]){
        //tester code;
        
        System.out.println(add(10, 10));
        System.out.println(subtract(10, 10));
        add(-3, 10);
        subtract(10, -10);
        
    }
}