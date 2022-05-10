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
import java.util.Scanner;

public class Server {
private static Integer port = 8080;

	public static void main(String args[]) throws Exception {

		String resClient_1 = "";
		String resClient_2 = "";
		String inputClient_1;
		String inputClient_2;
		String player1 ="";
		String player2 = "";
		
		System.out.println("Welcome To Rock Paper Scissors Game \n Waiting for players to join");
                ServerSocket welcomeSocket = new ServerSocket(Server.port);

		while (!welcomeSocket.isClosed()) {
			Socket client_1 = welcomeSocket.accept();
			DataOutputStream outClient_1 = new DataOutputStream(client_1.getOutputStream());
			BufferedReader inClient_1 = new BufferedReader(new InputStreamReader(client_1.getInputStream()));

			if (client_1.isConnected()) {
				player1 = inClient_1.readLine();
				System.out.println("\nPlayer one " + player1 +" has joined, waiting for player two!");
			}
			Socket client_2 = welcomeSocket.accept();
			DataOutputStream outClient_2 = new DataOutputStream(client_2.getOutputStream());
			BufferedReader inClient_2 = new BufferedReader(new InputStreamReader(client_2.getInputStream()));

			if (client_2.isConnected()) {
				player2 = inClient_2.readLine();
				
				System.out.println("\nPlayer two "+ player2 +" has joined");
			}	
			inputClient_1 = inClient_1.readLine();
			inputClient_2 = inClient_2.readLine();
			if (inputClient_1.equals(inputClient_2) && !inputClient_1.equals("Q") && !inputClient_2.equals("Q")) {
				resClient_1 = "Draw";
				resClient_2 = "Draw";
				System.out.println("It's a draw.");
			}
			else if (inputClient_1.equals("1") && inputClient_2.equals("3")) {
				resClient_1 = "You win";
				resClient_2 = "You lose";
				System.out.println( player1 +" wins.");

			}
			else if (inputClient_1.equals("3") && inputClient_2.equals("1")) {
				resClient_1 = "You lose";
				resClient_2 = "You win";
				System.out.println(player2 +" wins.");
			}
			else if (inputClient_1.equals("1") && inputClient_2.equals("2")) {
				resClient_1 = "You lose";
				resClient_2 = "You win";
				System.out.println(player2 +" wins.");
			}
			else if (inputClient_1.equals("2") && inputClient_2.equals("1")) {
				resClient_1 = "You win";
				resClient_2 = "You lose";
				System.out.println(player1 + " wins.");
			}
			else if (inputClient_1.equals("3") && inputClient_2.equals("2")) {
				resClient_1 = "You win";
				resClient_2 = "You lose";
				System.out.println(player1 + " wins.");
			}
			else if (inputClient_1.equals("2") && inputClient_2.equals("3")) {
				resClient_1 = "You lose";
				resClient_2 = "You win";
				System.out.println(player2 +" wins.");
			}
			if (!inputClient_2.equals("Q")) {
				outClient_1.writeBytes(resClient_1.toUpperCase());
				client_1.close();	
			}
			if (!inputClient_2.equals("Q")) {
				outClient_2.writeBytes(resClient_2.toUpperCase());
				client_2.close();	
			}
		System.out.println("Waiting for new players to join");
		}
	}
}
