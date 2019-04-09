package testcode;

import java.util.ArrayList;

public class JDK6914126 {

	// https://bugs.openjdk.java.net/browse/JDK-6795161
	public static void main(String[] args) {
		JDK6914126 test = new JDK6914126();
		test.ObjectCreation();
	}
	
    public void ObjectCreation() {
        int nObjects=100000;
        for(int i=0; i < 1000; i++){
            ArrayList<String> a = new ArrayList<String>();
        }

        for(int i=0; i < nObjects; i++){

            ArrayList<String> a = new ArrayList<String>();
        }

     }

}