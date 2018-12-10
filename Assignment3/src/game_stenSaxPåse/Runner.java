package game_stenSaxP�se;
import java.util.Random;
import java.util.Scanner;

public class Runner {


		public static void main(String[] args) {
			
			Scanner scanner = new Scanner(System.in);
			String inputString = "";
			int[] score;
			String[] alternatives = {"sten", "sax", "p�se"};
			String[] methods = {"krossar", "klipper", "f�ngar"};
			boolean quit = false, isWinner;
			
			while(!quit) {
				
				System.out.println("** V�LKOMMEN TILL STEN-SAX-P�SE **");
				System.out.println("Spelet d�r sten krossar sax, sax klipper p�se och p�se f�ngar sten. B�st av fem vinner.");
				System.out.println("Avsluta programmet genom att skriva Q.");
				
				isWinner = false;
				score = new int[2];	
				
				while(!quit && !isWinner) {
					System.out.println("G�r ditt val (sten, sax eller p�se): ");
					
					inputString = scanner.nextLine().trim();
					
					if(inputString.equalsIgnoreCase("Q")) {
						System.out.println("Hej d�!");
						quit = true;
					}
					
					else {

						int input = -1;
						
						for(int i = 0; i < alternatives.length; i ++) {
							if(alternatives[i].equalsIgnoreCase(inputString)) {
								input = i;
							}
						}	
						
						if(input == -1) {
							System.out.println("Ogiltigt v�rde. Giltiga v�rden �r sten, sax eller p�se.");
						}
						
						else {										
							//here
						int computerChoice = new Random().nextInt(3);
							
							System.out.println("Datorn v�ljer " + alternatives[computerChoice] + ".");
						//	alternatives[2]-1                        2+2 = 4
							if((computerChoice - 1) == input || (computerChoice + 2) == input) {
								score[0] ++;
								System.out.println("Din " + alternatives[input] + " " + methods[input] + " datorns " + 
										alternatives[computerChoice] + " (" + score[0] + " - " + score[1] + ").");
							}
							
							else if(computerChoice == input) {
								System.out.println("Samma val, ingen vinner.");
							}
							
							else {
								
								score[1] ++;
								System.out.println("Datorns " + alternatives[computerChoice] + " " + methods[computerChoice] + 
										" din " + alternatives[input] + " (" + score[0] + " - " + score[1] + ").");
							}
							
							if(score[0] == 3 || score[1] == 3) {
								
								String winner = "Datorn";
								
								if(score[0] == 3) {
									winner = "Du";
								}
								
								System.out.println(winner + " har vunnit (" + score[0] + " - " + score[1] + ")!");
								isWinner = true;
							}
						}					
					}
				}			
			}	
			
			scanner.close();		
		}
	}



