import java.net.*;
import java.util.*;
import java.io.*;

public class SimpleServer{
    public static void main(String [] args){
	try{
	    ServerSocket ss = new ServerSocket(1234);
	    while(true){
		Socket client = ss.accept();
		PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String line = reader.readLine();
		writer.println("You said: " + line);
		client.close();
	    }
	}
	catch(IOException e){
	    System.err.println("An error has occurred with the inputs/outputs:  " + e.getMessage());
	    e.printStackTrace();
	}
	catch(Exception e){
	    System.err.println("An error occurred:  " + e.getMessage());
	    e.printStackTrace();
	}
    }
}
