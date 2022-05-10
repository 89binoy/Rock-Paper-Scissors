/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse438;

/**
 *
 * @author Asus
 */
import java.io.*;
import java.net.*;

class Client1 {
    private static String host = "localhost";
    private static Integer port = 8080;
    public static void main(String args[]) throws Exception {
	String input = "";
	String input1 = "";
	String response;

	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	Socket clientSocket = new Socket(Client1.host, Client1.port);
	DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	
	
	System.out.println("To start, Please Enter Your Name:");
        input1 = inFromUser.readLine();
	outToServer.writeBytes(input1 + "\n");

	do {
		System.out.println("\n Welcome to Rock Paper Scissor Game \n to play you have to enter:\n '1' for Rock \n '2' for Paper \n '3' for Scissor \n 'Q' for Exit\n\n Please enter your choice:");

	    input = inFromUser.readLine();
	} while (!input.equals("1") && !input.equals("2") && !input.equals("3")&& !input.equals("Q"));

	outToServer.writeBytes(input + "\n");
	if(!input.equals("Q")) {

	System.out.println("\nYour input is transmitted to the server. You have to wait for the result");
	response = inFromServer.readLine();
	System.out.println("\nAnd the result is: " + response);
				}
	clientSocket.close();
    }
}

