package testcode;

// Issue with this classes
import java.util.zip.ZipFile;


public class JDK7013538 {

	//https://bugs.openjdk.java.net/browse/JDK-6795161
	public static void main(String[] args) {
		// Classes from above import can cause memory leak
		ZipFile m;
		//java.util.zip.ZipFile$ZipFileInputStream

	}
}