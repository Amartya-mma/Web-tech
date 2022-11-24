class Ques1{
    static int multiply(int num1, int num2){
        try{
            if(num1 == 0 || num2 == 0) throw new ArithmeticException("multiply with 0");  //customized exception created
            return num1*num2;                //return this in case of no exception
        }
        catch(ArithmeticException e){
            System.out.println(e);            //print the exception
        }
        return -1;                            //return -1 incase of an exception
    }
    static int divide(int num1, int num2){
        try{
            if(num1 == 0 || num2 == 0) throw new ArithmeticException("divide by 0");
            return num1/num2;

        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
        return -1;
    }
    public static void main(String args[]){
        //tester code;
        
        System.out.println(multiply(10, 10));
        System.out.println(divide(10, 10));
        multiply(10, 0);
        divide(0, 10);
        
    }
}