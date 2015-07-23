import java.util.*;
import java.io.*;
import java.net.*;

public class SimpleClient{
    public static void main(String [] args){
	try{
	    InetAddress ip = InetAddress.getByName(args[0]);
	    Socket me = new Socket(ip, 1234);
	    PrintWriter writer = new PrintWriter(me.getOutputStream(), true);
	    BufferedReader reader = new BufferedReader(new InputStreamReader(me.getInputStream()));
	    writer.println("Hello, World");
	    String response = reader.readLine();
	    me.close();
	    System.out.println("The other system said:\n" + response);
	}
	catch(IOException e){
	    System.err.println("An input/output error occurred:  " + e.getMessage());
	    e.printStackTrace();
	}
	catch(Exception e){
	    System.err.println("An error occurred:  " + e.getMessage());
	    e.printStackTrace();
	}
    }
}
