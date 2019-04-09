package testcode;

public class EADataCorruption {

	static boolean unauthorized;

	//https://bugs.openjdk.java.net/browse/JDK-6795161
	public static void main(String[] args) {
		unauthorized = true;

		int size = -1;
		try {
			for (int i = 0; i < 1; (new byte[size - i])[0] = 0, i++) {}
		} catch (Exception e) {
			System.out.println("Array failed to create");
		}

		if (unauthorized) {
			System.out.println("User is unauthorized to access this data");
		} else {
			System.out.println("Login successful, key is 8392jd");
		}
	}
}