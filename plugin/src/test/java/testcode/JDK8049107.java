package testcode;

import java.util.HashMap; 

public class JDK8049107 { 
    public static void main(String[] args) { 
        HashMap<Integer, String> m = new HashMap<Integer, String>(); 

        for (int i=0;i<100000;i++) { 
            if (check(m)) { 
                System.out.println("True"); 
            } 
        } 
    } 

    private static boolean check(HashMap<Integer, String> m) { 
        boolean check = false; 
        for(int i = 0; i < 1000; i++) { 
            check |= m.get(new Integer(i)) != null; 
        } 
        return check; 
    } 
} 
