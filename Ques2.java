import java.util.Scanner;
class Ques2{
    public static void main(String args[]){
        System.out.println("enter the size of the array");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //size of input array
        
        int arr[] = new int[n];

        System.out.println("enter the elements of the array");
        for(int i = 0; i < n; i++) 
            arr[i] = input.nextInt();

        int count[] = new int[22]; //count of every element from 0 to 20 
        for(int i = 0; i < n; i++) 
            count[arr[i] + 1]++;   //count[i] stores the count of (i - 1) in arr
                                    // so that it can store the count of all elements occuring before it in the sorted sequence
        for(int i = 1; i < 22; i++)
            count[i] += count[i - 1]; // for count[i] to store the count of all elements occuring before it in the sorted sequence
        
        int res[] = new int[n]; // resultant sorted array
        for(int i = 0; i < n; i++)
        {
            res[count[arr[i]]++] = arr[i]; //position of arr[i] in res array is count[arr[i]] for the first occurance of arr[i] and then count[arr[i]] + 1 for the next and so on
        }
        for(int x: res)
            System.out.println(x);
    
    }
}