import java.io.*;
import java.util.*;

public class satpixCheck {

    public static void main(String[] args)  {
    	String[] inputFileNames = {"bigPicture.txt", "bigPicture2.txt", "bigPicture3.txt", "bigPicture4.txt", "bigPicture5.txt"};
        String[] outputFileNames = {"bigPictureOut.txt","bigPicture2Out.txt", "bigPicture3Out.txt", "bigPicture4Out.txt", "bigPicture5Out.txt"};
    	
        long startTime = System.currentTimeMillis();
        try 
        {
	        for (int x = 0; x < 5; x++)
	        {
	        	SatPix.runSatPix(inputFileNames[x], outputFileNames[x]);
	        	Scanner scanner = new Scanner(new File(outputFileNames[x]));
	        	System.out.println(inputFileNames[x] + ": " + scanner.nextInt());
	        }
        }
    	catch (Exception ex)
    	{
    		System.out.println("Exception: " + ex.toString());
    	}
        long endTime = System.currentTimeMillis();
        System.out.println("YOUR SCORE: "+ (10000 - (endTime - startTime)));
    	System.exit(0);
    }
    	
}
