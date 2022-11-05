class Number{
    private double n;
    Number(double n){
        this.n = n;             //initialize the object
    }
    boolean isZero(){
        return (this.n == 0);
    }
    boolean isPositive(){
        return (this.n > 0);
    }
    boolean isNegative(){
        return (this.n < 0);
    }
    boolean isOdd(){  //only an integer can be even or odd so we check if it is an integer and then if it is not divisble by 2
        return (this.n == (int)(this.n) && this.n%2 != 0);
    }
    boolean isEven(){  //only an integer can be even or odd so we check if it is an integer and then if it is divisble by 2
        return (this.n == (int)(this.n) && this.n%2 == 0);
    }
    boolean isPrime(){
        if(this.n != (int)(this.n)) return false;  //only an integer can be prime or non prime
        for(int i = 2; i < this.n; i++)
            if((this.n%i) == 0) return false;      //if it has any other factor other than 1 and the number itself then it is not prime
        
        return true;
    }
    boolean isAmstrong(){
        double amstrong = 0;
        int beforeDecimal = (int)this.n; //to get the number before the decimal place 

        while(beforeDecimal > 0){  
            amstrong += (beforeDecimal%10)*(beforeDecimal%10)*(beforeDecimal%10); //to sum cube of the last digit of beforeDecimal in amstrong
            beforeDecimal/=10;                                                             //to remove the last digit of beforeDecimal hence through this loop we are able to sum the cube of all digits of a beforeDecimal 
        }

        int afterDecimal = getAfterDecimal(this.n - (int)this.n);  //to get the number after the decimal place 

        while(afterDecimal > 0){
            amstrong += (afterDecimal%10)*(afterDecimal%10)*(afterDecimal%10);  //similarly we cube the last digit of afterDecimal
            afterDecimal/=10;                                                     // and add it to amstrong
        }
        return (amstrong == this.n);                              // amstrong number if the sum of the cubes of its digits is equal to the number itself.
    }
    double getFactorial(){
        double factorial = 1;
        for(int i = 2; i <= this.n; i++)
            factorial*=i;                 //multiple all numbers 1 through n to get the factorial of the number
        return factorial;
    }
    double getSqrt(){
        //use binary search on numbers between 1 and this.n to get the square root of the double variable
        // Max and min are used to take into account numbers less than 1
        double lo = 1 < this.n?1:this.n, hi = 1>this.n?1:this.n, mid = -1;

        // Update the bounds to be off the target by a factor of 10
        while(100 * lo * lo < n) lo *= 10;
        while(0.01 * hi * hi > n) hi *= 0.1;

        for(int i = 0 ; i < 100 ; i++){
            mid = (lo+hi)/2;
            if(mid*mid == n) return mid;
            if(mid*mid > n) hi = mid;
            else lo = mid;
        }
        return mid;
    }
            
    double getSqr(){
        return (this.n * this.n);         //multiple the number witht itself to get the square of itself
    }
    double sumDigits(){
        double sum = 0;
        int beforeDecimal = (int)this.n; // to get the number before the decimal point
        while(beforeDecimal > 0){
            sum += (beforeDecimal%10);      //extract the last digit of beforeDecimal and add it to the sum
            beforeDecimal /= 10;            //remove the last digit of beforeDecimal
        }
        int afterDecimal = getAfterDecimal(this.n - (int)this.n);  // to get the number after the decimal point
        while(afterDecimal > 0){                             
            sum += (afterDecimal%10);                           //extract the last digit of AfterDecimal and add it to the sum
            afterDecimal /= 10;                                 //remove the last digit of AfterDecimal
        }
        return sum;
    }
    double getReverse(){
        double reverseAfterDecimal = 0;
        double reverseBeforeDecimal = 0;

        int beforeDecimal = (int)this.n;                 //get the number before
        int afterDecimal = getAfterDecimal(this.n - (int)this.n); // and after the decimal
        while(afterDecimal > 0){
            reverseAfterDecimal = reverseAfterDecimal* 10 + (afterDecimal%10); //build the reverse of after decimal taking its last digit and adding it to the ans consider its position
            afterDecimal /= 10;                                                            // remove the last digit of after decimal
        }

        for(int i = 10; beforeDecimal > 0; i*=10){
        reverseBeforeDecimal += (double)(beforeDecimal%10)/i;  //build the reverse of before decimal by taking the last digit and adding it to the ans considering it has to be present as a decimal in the final ans
        beforeDecimal/=10;                                            //remove the last digit of before decimal
    }
        
        return reverseAfterDecimal + reverseBeforeDecimal;        //add reversed of afterDecimal to reverse of beforeDecimal to get the ans
    }
    void listFactor(){
        if(this.n != (int)this.n){
            System.out.println("no factors because factors can only be calculated for integers");
            return;
        }
        System.out.print("factors:");

        for(int i = 1; i <= this.n; i++)
            if((this.n%i) == 0)                       // the numbers which can divide the given number with no remainder are the factors of it
                System.out.print(i + " ");
        System.out.println();
    }
    void dispBinary(){
        System.out.print("in binary:");
        int tmp = (int)this.n;
        printBinary(tmp);           //first print binary of the number before decimal point
        System.out.print(".");
        printBinary(getAfterDecimal(this.n - (int)this.n));      //then print the binary of the number after the decimal point
    }
    void printBinary(int x){
        if(x == 1 || x == 0){     //base case for recursion to get the binary representation of a number
            System.out.print(x);
            return;
        }
        printBinary(x/2);        //recursive call 
        System.out.print(x%2);
    }
    int getAfterDecimal(double d){
        while( d - (int)d > 0.001) d*=10; //this gets the fractional part upto a certain accuracy ie 1e-3 since we keep on moving the decimal point to the right till the fractional part isnt less than 1e-03
        return (int)d;                     //discard the fractional part that is less than 1e-03
    }
}
class Ques3{
    public static void main(String args[]){
        Number num = new Number(16.8d);
        System.out.println("is zero:" + num.isZero());
        System.out.println("is positive:" + num.isPositive());
        System.out.println("is negative:" + num.isNegative());
        System.out.println("is odd:" + num.isOdd());
        System.out.println("is even:" + num.isEven());
        System.out.println("is prime:" + num.isPrime());
        System.out.println("is amstrong:" + num.isAmstrong());

        System.out.println("factorial:" + num.getFactorial());
        System.out.println("square root:" + num.getSqrt());
        System.out.println("square:" + num.getSqr());
        System.out.println("sum of digits:" + num.sumDigits());
        System.out.println("reverse:" + num.getReverse());

        num.listFactor();
        num.dispBinary();
    }
}
