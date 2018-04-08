package netwrokingPackache;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class main {
	/*
    public static void main(String args[]) {

//10.48.238.98 9001
    	
// declaration section:
// declare a server socket and a client socket for the server
// declare an input and an output stream
        ServerSocket echoServer = null;
        String line;
        Scanner is;
        PrintStream os;
        Socket clientSocket = null;
// Try to open a server socket on port 9999
// Note that we can't choose a port less than 1023 if we are not
// privileged users (root)
        try {
           echoServer = new ServerSocket(9001);
        }
        catch (IOException e) {
           System.out.println(e);
        }   
// Create a socket object from the ServerSocket to listen and accept 
// connections.
// Open input and output streams
    try {
           clientSocket = echoServer.accept();
           is = new Scanner(clientSocket.getInputStream());
           os = new PrintStream(clientSocket.getOutputStream());
// As long as we receive data, echo that data back to the client.
           while (true) {
             line = is.next();
             System.out.println(line);
             os.println("Lily Sucks Dick"); 
           }
        }   
    catch (IOException e) {
           System.out.println(e);
        }
    }
    */

	public static void main(String[] args) {
		// declaration section:
		// smtpClient: our client socket
		// os: output stream
		// is: input stream
		        Socket smtpSocket = null;  
		        DataOutputStream os = null;
		        Scanner is = null;
		// Initialization section:
		// Try to open a socket on port 25
		// Try to open input and output streams
		        try {
		            smtpSocket = new Socket("10.47.29.179", 9001);
		            os = new DataOutputStream(smtpSocket.getOutputStream());
		            is = new Scanner(smtpSocket.getInputStream());
		        } catch (UnknownHostException e) {
		            System.err.println("Don't know about host: hostname");
		        } catch (IOException e) {
		            System.err.println("Couldn't get I/O for the connection to: hostname");
		        }
		// If everything has been initialized then we want to write some data
		// to the socket we have opened a connection to on port 25
		    if (smtpSocket != null && os != null && is != null) {
		            try {
		// The capital string before each colon has a special meaning to SMTP
		// you may want to read the SMTP specification, RFC1822/3
		        os.writeBytes("HELO\n");    
		                os.writeBytes("MAIL From: k3is@fundy.csd.unbsj.ca\n");
		                os.writeBytes("RCPT To: k3is@fundy.csd.unbsj.ca\n");
		                os.writeBytes("DATA\n");
		                os.writeBytes("From: k3is@fundy.csd.unbsj.ca\n");
		                os.writeBytes("Subject: testing\n");
		                os.writeBytes("Hi there\n"); // message body
		                os.writeBytes("\n.\n");
		        os.writeBytes("QUIT");
		// keep on reading from/to the socket till we receive the "Ok" from SMTP,
		// once we received that then we want to break.
		                String responseLine;
		                while ((responseLine = is.nextLine()) != null) {
		                    System.out.println("Server: " + responseLine);
		                    if (responseLine.indexOf("Ok") != -1) {
		                      break;
		                    }
		                }
		// clean up:
		// close the output stream
		// close the input stream
		// close the socket
		        os.close();
		                is.close();
		                smtpSocket.close();   
		            } catch (UnknownHostException e) {
		                System.err.println("Trying to connect to unknown host: " + e);
		            } catch (IOException e) {
		                System.err.println("IOException:  " + e);
		            }
		        }
		    }           
}