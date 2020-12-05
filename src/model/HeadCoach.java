package model;
/**
* @author Diego Hidalgo Lopez
*/
public class HeadCoach extends Coach implements Calculable{
	
	//attributes
	private int leadingTeams; //HeadCoach amount of leading teams
	private int achievedChampionShips; //HeadCoach amount of achieved championships
	
	/**
	* constructor of the HeadCoach class.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> HeadCoach class object created.<br>
	*/
	public HeadCoach(){
		super();
		leadingTeams = 0;
		achievedChampionShips = 0;
	}
	
	/**
	* construcotr of the HeadCoach class.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> HeadCoach class object created.<br>
	* @param id. HeadCoach id. id != null, id != ""
	* @param salary. HeadCoach salary. salary > 0. 
	* @param state. HeadCoach state. state is initialized
	* @param expYears. HeadCoach experience years. years >= 0
	* @param leadingTeams. HeadCoach leading teams. leadingTeams is initialized
	* @param achievedChampionShips. HeadCoach achieved championships. achievedChampionShips is initialized
	*/
	public HeadCoach(String name, int id, double salary, boolean state, int expYears, int leadingTeams, int achievedChampionShips){
		super(name, id, salary, state, expYears);
		this.leadingTeams = leadingTeams;
		this.achievedChampionShips = achievedChampionShips;
	}
	
	/**
	* changes the HeadCoach amount of leading teams.<br>
	* <b>pre:</b> leadingTeams is initialized.<br>
	* <b>post:</b> HeadCoach amount of leading teams has been changed.<br>
	* @param leadingTeams. New HeadCoach amount of leading teams. leadingTeams is initialized
	*/
	public void setLeadingTeams(int leadingTeams){
		this.leadingTeams = leadingTeams;
	}
	
	/**
	* returns the HeadCoach amount of leading teams.<br>
	* <b>pre:</b> leadingTeams is initialized.<br>
	* <b>post:</b> HeadCoach leadingTeams.<br>
	*/
	public int getLeadingTeams(){
		return leadingTeams;
	}
	
	/**
	* changes the HeadCoach amount of achieved championships.<br>
	* <b>pre:</b> achievedChampionShips is initialized.<br>
	* <b>post:</b> achievedChampionShips has been changed.<br>
	* @param achievedChampionShips. New HeadCoach amount of achieved championships. achievedChampionShips is initialized
	*/
	public void setAchievedChampionShips(int achievedChampionShips){
		this.achievedChampionShips = achievedChampionShips;
	}
	
	/**
	* returns de HeadCoach amount of achieved championships.<br>
	* <b>pre:</b> achievedChampionShips is initialized.<br>
	* <b>post:</b> HeadCoach achievedChampionShips.<br>
	*/
	public int getAchievedChampionShips(){
		return achievedChampionShips;
	}
	
	/**
	* calculates the HeadCoach market price. <br>
	* <b>pre:</b> .<br>
	* <b>post:</b> HeadCoach market price has been calculated.<br>
	*/
	@Override
	public double calculateMarketPrice(){
		double price;
		price = (getSalary()*10) + (getExpYears()*100) + (getAchievedChampionShips()*50);
		return price;
	}
	
	/**
	* calculates the HeadCoach level. <br>
	* <b>pre:</b> .<br>
	* <b>post:</b> HeadCOach level has been calculated.<br>
	*/
	@Override
	public double calculateLevel(){
		double level;
		level = 5 + (getAchievedChampionShips()/10);
		return level;
	}
	
	/**
	* saves the HeadCoach info on a string.<br>
	* <b>pre:</b> name, id, salary, expYears, leadingTeams and achievedChampionShips are initialized.<br>
	* <b>post:</b> String with the HeadCoach info.<br>
	*/
	@Override
	public String getInfo(){
		String info;
		info = super.getInfo() +
		"\nAmount of leading teams: " + getLeadingTeams() +
		"\nAmount of achieved championships: " + getAchievedChampionShips() +
		"\nMarket price: " + calculateMarketPrice() + 
		"\nLevel: " + calculateLevel();
		return info;
	}

}