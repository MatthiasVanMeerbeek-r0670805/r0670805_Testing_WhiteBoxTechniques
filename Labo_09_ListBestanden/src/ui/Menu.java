package ui;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
import domain.OpdrachtDatabank;

public class Menu {

	OpdrachtDatabank o1 = new OpdrachtDatabank("Opdrachten-1.txt");
	
	public void start(){
		while(true){
			String inputStr = JOptionPane.showInputDialog("Maak je keuze:\n"
					+ "1: Bekijk een opdracht\n"
					+ "2: Krijg een opdracht\n"
					+ "\n0: Quit");
			if(inputStr == null) return;
			if(!checkInt(inputStr.trim())){
				JOptionPane.showMessageDialog(null, "Geen geldige input");
				continue;
			}
			
			int inputInt = Integer.parseInt(inputStr);
			
			switch(inputInt){
				case 0:
					return;
				case 1:
					kiesOpdracht();
					return;
				case 2:
					startQuiz();
					return;
			}
		}
	}

	private void kiesOpdracht() {
		while(true){
			String inputStr = JOptionPane.showInputDialog("Geef de id van de opdracht waarvan je de gegevens wilt bekijken.\n"
					+ "(1 - " + o1.getAantal() + ")");
			if(inputStr == null){
				start();
				return;
			}
			if(!checkInt(inputStr.trim())){
				JOptionPane.showMessageDialog(null, "Geen geldige input");
				continue;
			}
			
			int inputInt = Integer.parseInt(inputStr);
			
			JOptionPane.showMessageDialog(null, o1.getOpdrachtByOpdrachtID(inputInt));
		}
	}	
	
	private void startQuiz() {
		int randomInt = ThreadLocalRandom.current().nextInt(1, o1.getAantal()+1);
		JOptionPane.showMessageDialog(null, o1.getOpdrachtByOpdrachtID(randomInt));
		start();
	}
	
	//CHECK INT (check if string is an integer)
	private boolean checkInt(String inputStr) {
		if(inputStr == null) return false;
		if(inputStr.isEmpty()) return false;
		int i = 0;
		if(inputStr.charAt(i) == '-' && inputStr.length() == 1){
			return false;
		}else{
			i = 1;
		}
		for(i = 0; i < inputStr.length(); i++){
			char c = inputStr.charAt(i);
	        if (c < '0' || c > '9') return false;
		}
		return true;
	}
}
