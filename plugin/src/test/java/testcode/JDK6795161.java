package testcode;

class EATester_Class_1 {
    static String var_1;

    static void badFunc(int size)
    {
        try {
          for (int i = 0; i < 1; (new byte[size-i])[0] = 0, i++) {}
        } catch (Exception e) {
          // don't comment it out, it will lead to correct results ;)
          //System.out.println("Got exception: " + e);
        }
    }
}

public class JDK6795161 {
    static String var_1_copy = EATester_Class_1.var_1;

    static byte var_check;

    public static void main(String[] args)
    {
        var_check = 1;

        EATester_Class_1.badFunc(-1);

        System.out.println("EATester.var_check = " + JDK6795161.var_check + " (expected 1)\n");
    }
}
