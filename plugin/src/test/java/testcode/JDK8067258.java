package testcode;

import java.io.IOException; 
import java.time.ZoneId; 
import java.util.TimeZone; 

class LongTest { 
    public static int test1(int count) { 
        Integer sum = 0; 

        for(int i = 0; i <= count - 1; ++i) 
            sum += i; 

        return sum; 
    } 

    public static long test2(int count) { 
        int sum = 0; 
   
        for (int i = 0; i <= count - 1; ++i) 
            sum += i; 

        return sum; 
    } 
} 

public class JDK8067258 { 
    public static void main(String[] args) { 
        int k = 0; 
        int count = 200; 
        int N = 200000; 
        for (int i = 0; i != N; ++i) { 
            k += LongTest.test1(count); 
            k += LongTest.test2(count); 
        } 

        System.out.println(k); 
         
        { 
            long startTime = System.nanoTime(); 
            k += LongTest.test1(Integer.MAX_VALUE); 
            long endTime = System.nanoTime(); 
            System.out.println((endTime - startTime) / 1.0e9); 
        } 
        { 
            long startTime = System.nanoTime(); 
            k += LongTest.test2(Integer.MAX_VALUE); 
            long endTime = System.nanoTime(); 
            System.out.println((endTime - startTime) / 1.0e9); 
        } 
         
        System.out.println(k); 
         
        return; 
    } 
} 

