package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class OpdrachtDatabank {
	
	List<Opdracht> opdrachten;
	
	public OpdrachtDatabank(String filename){
		opdrachten = new ArrayList<>();
		fileReader(filename);
	}

	public Opdracht getOpdrachtByOpdrachtID(int opdrachtID){
		Opdracht opdrachtResult = null;
		for(Opdracht opdracht:opdrachten){
			if(opdracht.getOpdrachtID() == opdrachtID) opdrachtResult = opdracht;
		}
		return opdrachtResult;
	}
	
	public List<Opdracht> getOpdrachten() {
		return opdrachten;
	}
	
	public void voegToe(Opdracht opdracht){
		if(opdracht == null){
			throw new IllegalArgumentException("De opdracht mag niet null zijn.");
		}
		opdrachten.add(opdracht);
	}
	
	public int getAantal(){
		return opdrachten.size();
	}
	
	private void fileReader(String filename) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filename));
			while(sc.hasNextLine()){
				Scanner line = new Scanner(sc.nextLine());
				line.useDelimiter("\t");
				int opdrachtID = Integer.parseInt(line.next());
				String vraag = line.next();
				String antwoord = line.next();
				Boolean isHoofdletterGevoelig = Boolean.parseBoolean(line.next());
				String antwoordHint = line.next();
				String categorie = line.next();
				String auteur = line.next();
				Opdracht opdracht = null;
				if(antwoordHint.isEmpty()){
					opdracht = new Opdracht(opdrachtID, vraag, antwoord, isHoofdletterGevoelig, categorie, auteur);					
//					System.out.println(opdracht);
				}else{
					opdracht = new Opdracht(opdrachtID, vraag, antwoord, isHoofdletterGevoelig, antwoordHint, categorie, auteur);
//					System.out.println(opdracht);
				}
				if(opdracht != null) voegToe(opdracht);
				line.close();
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e.getMessage());
		} finally {
			if(sc != null){
				sc.close();
			}
		}
	}
	
}
