package model;
/**
* @author Diego Hidalgo Lopez
*/
import java.util.*;
public class Team{
	
	//constants
	private final static int AMOUNTTA = 3; //Amount technical assistants
	private final static int AMOUNTPLAYERS = 25; //Amount players
	
	//attibutes
	private String name; //Team name
	private HeadCoach headCoach; //Team HeadCoach
	private TechnicalAssistant[] technicalAssistants; //Team TechnicalAssistant
	private Player[] players; //Team Players
	private ArrayList<Alignment> alignments; //Team alignments
	
	/**
	* Constructor of the Team class.<br>
	* <b>pre:</b> name is initialized. name != null<br>
	* <b>post:</b> Team class object has been created.<br>
	* @param name. Team name. name != null
	*/
	public Team(String name){
		this.name = name;
		this.headCoach = new HeadCoach();
		technicalAssistants = new TechnicalAssistant[AMOUNTTA];
		players = new Player[AMOUNTPLAYERS];
		alignments = new ArrayList<Alignment>();
	}
	
	/**
	* Constructor of the Team class.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> Team class object has been created.<br>
	* @param name. Team name. name != null
	* @param headCoach. Team headCoach. headCoach != null
	*/
	public Team(String name, HeadCoach headCoach){
		this.name = name;
		this.headCoach = headCoach;
		technicalAssistants = new TechnicalAssistant[AMOUNTTA];
		players = new Player[AMOUNTPLAYERS];
		alignments = new ArrayList<Alignment>();
	}
	
	/**
	* changes the Team name.<br>
	* <b>pre:</b> name is initialized.<br>
	* <b>post:</b> Team name has been changed.<br>
	* @param name. New Team name. name != null
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	* returns the Team name.<br>
	* <b>pre:</b> name is initialized.<br>
	* <b>post:</b> Team name.<br>
	*/
	public String getName(){
		return name;
	}
	
	/**
	* changes the Team headCoach.<br>
	* <b>pre:</b> headCoach is initialized.<br>
	* <b>post:</b> Team headCoach has been changed.<br>
	* @param headCoach. New Team headCoach. headCoach != null
	*/
	public void setHeadCoach(HeadCoach headCoach){
		this.headCoach = headCoach;
	}
	
	/**
	* returns the Team headCoach.<br>
	* <b>pre:</b> headCoach is initialized.<br>
	* <b>post:</b> Team headCoach.<br>
	*/
	public HeadCoach getHeadCoach(){
		return headCoach;
	}
	
	/**
	* searches an Alignment date.<br>
	* <b>pre:</b> date is initialized.<br>
	* <b>post:</b> true if the date is already in an Alignment. False if not.<br>
	* @param date. Alignment date. date != null
	*/
	public boolean verifyAlignmentDate(String date){
		String msg;
		boolean verify = false;
		for(int i = 0; i<alignments.size() && !verify; i++){
			Alignment alignment = alignments.get(i);
			if(alignment.getDate().equalsIgnoreCase(date)){
				verify = true;
			}
		}
		return verify;
	}
	
	/**
	* adds a technical assistant to the Team.<br>
	* <b>pre:</b> technicalAssistant is initialized.<br>
	* <b>post:</b> a new technicalAssistant has been added to the Team.<br>
	* @param technicalAssistant. New Team technicalAssistant. technicalAssistant != null
	*/
	public boolean addTechnicalAssistant(TechnicalAssistant technicalAssistant){
		boolean add = false;
		for(int i = 0; i<technicalAssistants.length && !add; i++){
			if(technicalAssistants[i] == null){
				technicalAssistants[i] = technicalAssistant;
				add = true;
			}
		}
		return add;
	}
	
	/**
	* saves the technicalAssistants info in a String.<br>
	* <b>pre:</b> technicalAssistants is initialized.<br>
	* <b>post:</b> technicalAssistants info in a String.<br>
	*/
	public String technicalAssistantsInfo(){
		String info = "";
		for(int i = 0; i<technicalAssistants.length; i++){
			if(technicalAssistants[i] != null){
				info += technicalAssistants[i].getId() + " ";
			}
		}
		return info;
	}
	
	/**
	* adds a player to the team.<br>
	* <b>pre:</b> player != null.<br>
	* <b>post:</b> a new player has been added to the Team.<br>
	* @param player. New Player to add. player != null
	*/
	public boolean addPlayer(Player player){
		boolean add = false;
		for(int i = 0; i<players.length && !add; i++){
			if(players[i] == null){
				players[i] = player;
				add = true;
			}
		}
		return add;
	}
	
	/**
	* calculates the amount of players in the Team.<br>
	* <b>pre:</b> players is initialized.<br>
	* <b>post:</b> amount of players in the Team.<br>
	*/
	public int amountPlayers(){
		int amount = 0;
		for(int i = 0; i<players.length; i++){
			if(players[i] != null){
				amount ++;
			}
		}
		return amount;
	}
	
	/**
	* adds an alignment to the Team.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> a new alignment has been added to the Team.<br>
	* @param date. Alignment date. Alignment date. date != null
	* @param tactic. Alignment tactic. tactic != null
	* @param formation. Alignment formation. formation != null
	*/
	public void addAlignment(String date, String tactic, String formation){
		Alignment alignment = new Alignment(date, tactic);
		alignment.setFieldFormation(formation);
		alignments.add(alignment);
	}
	
	/**
	* saves the alignments info in a String.<br>
	* <b>pre:</b> alignments is initialized.<br>
	* <b>post:</b> alignments info in a String.<br>
	*/
	public String getAlignmentsInfo(){
		String info = "";
		for(int i = 0; i<alignments.size(); i++){
			Alignment alignment = alignments.get(i);
			info += "[" + (i+1) + "]" + alignment.getInfo() + "\n";
		}
		return info;
	}
	
	/**
	* saves the Team info in a String.<br>
	* <b>pre:</b> name, headCoach, technicalAssistants, players and alignments are initialized.<br>
	* <b>post:</b> Team info in a String.<br>
	*/
	public String getInfo(){
		String info;
		info = "\nName: " + getName() +
		"\nHead coach ID: " + getHeadCoach().getId() +
		"\ntechnical Assistants IDs: " + technicalAssistantsInfo() +
		"\nAmount players: " + amountPlayers() +
		"\nAmount alignments: " + alignments.size();
		return info;
	}
	
}