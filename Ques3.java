import java.util.*;
class Ques3{
    public static void main(String args[]){
        //java provides no direct function in the string class
        // to sort a string, therefore we convert the string to a character array
        // and then use the library function to sort the character array
        // and then convert that sorted character array to a string
        String s = "thequickbrownfox";
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String res = new String(arr);
        System.out.println(res);
    }
}