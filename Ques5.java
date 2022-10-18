import java.util.*;
class Ques5{
    static int[][] dp = new int[1001][1001];
    static ArrayList<ArrayList<String>> res= new ArrayList<ArrayList<String>>();
    public static int dfs(String s1, String s2, int i, int j){
        if(j == 0 && i == 0) return 0;
        if(i == 0) return s2.length() - j;
        if(j == 0) return s1.length() - i;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) 
            return dp[i][j] = dfs(s1, s2, i - 1, j - 1);
        else
            {
            return dp[i][j] = 1 + Math.min(dfs(s1, s2, i - 1, j), 
            Math.min(dfs(s1, s2, i, j - 1), dfs(s1, s2, i - 1, j - 1)));
            }
        
    }
    static void printAllChanges(String s1,
                                String s2, ArrayList<String> changes)
    {
 
        int i = s1.length();
        int j = s2.length();
 
        // Iterate till end
        while (true) {
 
            if (i == 0 || j == 0) {
 
                // Add this list to our List of lists.
                res.add(changes);
                break;
            }
 
            // If same
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                i--;
                j--;
            }
 
            else {
                boolean if1 = false, if2 = false;
 
                // Replace
                if (dp[i][j] == dp[i - 1][j - 1] + 1) {
 
                    // Add this step
                    changes.add("Change " + s1.charAt(i - 1)
                                + " to " + s2.charAt(j - 1));
                    i--;
                    j--;
 
                    // note whether this 'if' was true.
                    if1 = true;
                }
 
                // Delete
                if (dp[i][j] == dp[i - 1][j] + 1) {
                    if (if1 == false) {
                        changes.add("Delete " + s1.charAt(i - 1));
                        i--;
                    }
                    else {
                        // If the previous method was true,
                        // create a new list as a copy of previous.
                        ArrayList<String> changes2 = new ArrayList<String>();
                        changes2.addAll(changes);
 
                        // Remove last operation
                        changes2.remove(changes.size() - 1);
 
                        // Add this new operation
                        changes2.add("Delete " + s1.charAt(i));
 
                        // initiate new new instance of this
                        // function with remaining substrings
                        printAllChanges(s1.substring(0, i),
                                        s2.substring(0, j + 1), changes2);
                    }
 
                    if2 = true;
                }
 
                // Add character step
                if (dp[i][j] == dp[i][j - 1] + 1) {
                    if (if1 == false && if2 == false) {
                        changes.add("Add " + s2.charAt(j - 1));
                        j--;
                    }
                    else {
 
                        // Add steps
                        ArrayList<String> changes2 = new ArrayList<String>();
                        changes2.addAll(changes);
                        changes2.remove(changes.size() - 1);
                        changes2.add("Add " + s2.charAt(j));
 
                        // Recursively call for the next steps
                        printAllChanges(s1.substring(0, i + 1),
                                        s2.substring(0, j), changes2);
                    }
                }
            }
        }
    }
    static void printWays(String s1, String s2,
                          ArrayList<String> changes)
    {
 
        // Function to print all the ways
        printAllChanges(s1, s2, new ArrayList<String>());
 
        int i = 1;
 
        // print all the possible ways
        for (ArrayList<String> ar : res) {
            System.out.println("\nMethod " + i++ + " : \n");
            for (String s : ar) {
                System.out.println(s);
            }
        }
    }
    public static void main(String args[]){
        String s1 = "abcdef";
        String s2 = "axcdfdh";
        for(int i = 0; i < 1001; i++)
            for(int j = 0; j < 1001; j++)
                dp[i][j] = -1;


        int min_ways = dfs(s1, s2, s1.length() - 1, s2.length() - 1);
        
        printWays(s1, s2, new ArrayList<String>());
        // System.out.println(min_ways);

        }
    }

