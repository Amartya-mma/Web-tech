class Ques1{
    public static void main(String args[]){
        String s1 = "ao";
        String s2 = "ae";
        int len = (s1.length() < s2.length()) ? s1.length(): s2.length();
        int i = 0;
        for(; i < len; i++){
            if(s1.charAt(i) == s2.charAt(i)) continue;
            else if(s1.charAt(i) > s2.charAt(i)){
                System.out.println(s1 + " is bigger");
                break;
            }
            else{
                System.out.println(s2 + " is bigger");
                break;
            }
        }
        if(i < s1.length() - 1) System.out.println(s1 + " is bigger");
        if(i < s2.length() - 1) System.out.println(s2 + " is bigger");

        
    }
}