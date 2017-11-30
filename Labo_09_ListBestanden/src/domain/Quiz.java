package domain;

import java.util.List;

public class Quiz {
	
	private List<Opdracht> opdrachten;
		
	public Quiz(){}
	
	public Quiz(List<Opdracht> opdrachten){
		this.opdrachten = opdrachten;
	}
		
		// hoeveel opdracht objecten zitten er in de opdrachtenCollectie
	public int getAantalOpdrachten(){
		return opdrachten.size();
	}
		
	public boolean isLeeg(){
		return opdrachten.isEmpty();
	}
		
	//return opdrachtobject op plaats index in de opdrachtenCollectie
	public Opdracht getOpdracht(int index) {
		return opdrachten.get(index);
	}
		
	// zet op de plaats index in de opdrachteRij het opdrachtobject opdrachtNieuw
	// en returned de eventuele opdracht die op plaats index in de opdrachtenCollectie al aanwezig is
	public Opdracht setOpdracht(int index, Opdracht opdrachtNieuw) {
		return opdrachten.set(index, opdrachtNieuw);
	}
		
	//voegt een nieuwe opdracht toe achteraan de opdrachtenCollectie
	
	public boolean voegOpdrachtToe(Opdracht opdrachtNieuw){
		opdrachten.add(opdrachtNieuw);
		return true;
	}
		
	//voegt een nieuwe opdracht toe op de plaats index in de opdrachtenCollectie
		public boolean voegOpdrachtToe(int index,Opdracht opdrachtNieuw) {
			opdrachten.add(index, opdrachtNieuw);
			return true;
	}
		
	//verwijder de eventuele opdracht op plaats index in de opdrachtenCollectie
	//geeft de verwijderde opdracht terug
	public Opdracht verwijderOpdracht(int index) {
		return opdrachten.remove(index);
	}	
		
	//elke opdracht uit de opdrachtenCollectie(volgens toString van Opdracht klasse), elke
	//opdracht op een nieuwe lijn
	public String toString(){
		String info = "";
		for(Opdracht opdracht: opdrachten){
			info = info + opdracht.toString() + "\n";
		}
		return info;
	}
}
