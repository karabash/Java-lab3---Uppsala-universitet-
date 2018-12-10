package game_stenSaxP�se;
import Table.Exiter;
import Table.PlayerGreeting;
import Table.Score;
import messages.Message;

public class GameTable implements Exiter, Message{
	private Player player1 = new Player(); 
	private static String player1NameHolder="Player";

	 void askName() {
		System.out.println("Vad heter du?");
	}
	
	 String setName(String name){
		try{
			if(name == null || name.length() == 0 ) {
				player1.setName(player1NameHolder);
				System.out.println(this.getPlayer1Name());
				return player1.getName();
			}


			else {
				player1.setName(name);
				return player1.getName();
			}


		}catch(StringIndexOutOfBoundsException e) {
			System.out.println("Invalid name use character! - Run the game agin!");
			System.exit(0);

		}
		return player1.getName();
	}

	public String getPlayer1Name() {
		return this.player1.getName();
	}

	
	
	 void greatUser() {
		PlayerGreeting g = p -> getPlayer1Name();
		
			System.out.print("** HEJ OCH V�LKOMMEN "+ g.greatingUser((getPlayer1Name())) + " TILL MIN SPEL STEN-SAX-P�SE ** \nSpelet d�r sten krossar sax,"
					+ " sax klipper p�se och p�se f�ngar sten. B�st av fem vinner.\n");
			this.giveGameExitInfo(getPlayer1Name());
		}
	
	
	 String getScore(int computerScore, int playerScore, String playerName, String computerName) {
	final	String po�ng = "'s po�ng �r ";
	

	Score	sc = (cS,pS, pN) ->  {return  ("\nGame Score: ").concat(playerName + po�ng + playerScore +". "
			+computerName +po�ng+ computerScore+"\n");};
		sc.getScore(computerScore, playerScore, playerName).length();
		return sc.getScore(computerScore, playerScore, playerName);
	      
	 		 	 
	}
	 void giveGameExitInfo(String playerName) {
		System.out.println( "F�rresten vill du  avsluta programmet "+ playerName +", kan du g�ra det genom att skriva Q.");
		}

	@Override
	public boolean isExitDesired(String userInput) {
		return userInput.substring(0, 1).equalsIgnoreCase("q"); 		
	}

	@Override
	public void exitMessage(String name) {
		System.out.println("Ha en trevlig dag "+ name);
		
	}

	@Override
	public void invalidValueMessage() {
		System.out.println("Ogiltigt v�rde. Giltiga v�rden �r sten, sax eller p�se.\n");
		
	}

	@Override
	public void winnerMessage(int pcScore, int playerScore) {
		if(playerScore>pcScore)
			System.out.println("winner is "+ getPlayer1Name() + playerScore);
			else if(pcScore>playerScore)
				System.out.println("winner is Datorn " + pcScore);		
			else
				System.out.println("Tie " + pcScore);		

	}

	@Override
	public void tieMessage() {
		System.out.println("There is no winner ");		
	}
	
	 String methodPrinter(String winnerChoice,  String methodName, String looserChoice) {
		String result = winnerChoice + " " + methodName + " "+ looserChoice;
		System.out.print(result + " ");
		return result;
	}                       

	 void printUserChoice(String userInput) {
		System.out.println("Ditt val �r "+ userInput);
	}

	 void makeChoose() {
		System.out.println(player1.getName() + " g�r ditt val (sten, sax eller p�se): ");
	}
	
}
