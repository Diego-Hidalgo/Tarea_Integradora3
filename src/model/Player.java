package model;
/**
* @author Diego Hidalgo Lopez
*/
public class Player extends Employee implements Calculable{
	
	//attributes
	private String teamName; //Player team name
	private int number; //Player t-shirt number
	private int goals; //Player amount of goals
	private double averageScore; //Player average score
	private Position position; //Player position
	
	/**
	* constructor of the Player class.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> Player class object created.<br>
	* @param name. Player name. name != null. name != "".
	* @param id. Player id. id != null.
	* @param salary. Player salary. salary > 0. 
	* @param state. Player state. state is initialized.
	* @param number. Player number . number >= 0.
	* @param goals. Player goals. goals >= 0.
	* @param averageScore. Player average score >= 0.
	* @param position. Player position. position != null. position != "".
	*/
	public Player(String name, int id, double salary, boolean state, int number, int goals, double averageScore, String position){
		super(name, id, salary, state);
		this.teamName = "";
		this.number = number;
		this.goals = goals;
		this.averageScore = averageScore;
		this.position = Position.valueOf(position);
	}
	
	/**
	* constructor of the Player class.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> Player class object created.<br>
	* @param name. Player name. name != null. name != ""
	* @param id. Player id. id != null.
	* @param salary. Player salary. salary > 0. 
	* @param teamName. Player team name. teamName != null. teamName != ""
	* @param state. Player state. state is initialized
	* @param number. Player number . number >= 0
	* @param goals. Player goals. goals >= 0
	* @param averageScore. Player average score >= 0
	* @param position. Player position. position != null. position != ""
	*/
	public Player(String name, int id, double salary, boolean state, String teamName, int number, int goals, double averageScore, String position){
		super(name, id, salary, state);
		this.teamName = teamName;
		this.number = number;
		this.goals = goals;
		this.averageScore = averageScore;
		this.position = Position.valueOf(position);
	}
	
	/**
	* changes the Player teamName.<br>
	* <b>pre:</b> teamName is initialized. teamName is not null.<br>
	* <b>post:</b> Player teamName has been changed.<br>
	* @param teamName. New Player teamName. teamName != null. teamName != ""
	*/
	public void setTeamName(String teamName){
			this.teamName = teamName;
	}

	/**
	* returns the Player teamName.<br>
	* <b>pre:</b> teamName is initialized. teamName is not null.<br>
	* <b>post:</b> Player teamName.<br>
	*/
	public String getTeamName(){
		return teamName;
	}
	
	/**
	* changes the Player t-shirt number.<br>
	* <b>pre:</b> number is initialized.<br>
	* <b>post:</b> Player number has been changed.<br>
	* @param number. New Player t-shirt number. number is initialized
	*/
	public void setNumber(int number){
		this.number = number;
	}
	
	/**
	* returns the Player t-shirt number.<br>
	* <b>pre:</b> number is initialized.<br>
	* <b>post:</b> Player number.<br>
	*/
	public int getNumber(){
		return number;
	}
	
	/**
	* changes the Player amount of goals.<br>
	* <b>pre:</b> goals is initialized.<br>
	* <b>post:</b> Player amount of goals have been changed.<br>
	* @param goals. New Player goals. goals >= 0
	*/
	public void setGoals(int goals){
		this.goals = goals;
	}
	
	/**
	* returns the Player amount of goals.<br>
	* <b>pre:</b> goals is initialized.<br>
	* <b>post:</b> Player amount of goals.<br>
	*/
	public int getGoals(){
		return goals;
	}
	
	/**
	* changes the Player average score.<br>
	* <b>pre:</b> averageScore is initialized.<br>
	* <b>post:</b> Player averageScore has been changed.<br>
	* @param averageScore. New Player average score. averageScore >= 0
	*/
	public void setAverageScore(double averageScore){
		this.averageScore = averageScore;
	}
	
	/**
	* returns the Player average score.<br>
	* <b>pre:</b> average is initialized.<br>
	* <b>post:</b> Player average score.<br>
	*/
	public double getAverageScore(){
		return averageScore;
	}
	
	/**
	* changes the Player position.<br>
	* <b>pre:</b> position is initialized.<br>
	* <b>post:</b> postion has been changed.<br>
	* @param position. New player position. position != null. position != ""
	*/
	public void setPosition(String position){
		this.position = Position.valueOf(position);
	}
	
	/**
	* returns the Player position.<br>
	* <b>pre:</b> position is initialized.<br>
	* <b>post:</b> Player position.<br>
	*/
	public Position getPosition(){
		return position;
	}
	
	/**
	* calculates the Player market price. <br>
	* <b>pre:</b> .<br>
	* <b>post:</b> Player market price.<br>
	*/
	@Override
	public double calculateMarketPrice(){
		double price = 0;
		switch(position){
			case PORTERO:
				price = (getSalary()*12) + (getAverageScore()*150);
				break;
			case DEFENSOR:
				price = (getSalary()*13) + (getAverageScore()*125) + (getGoals()*100);
				break;
			case VOLANTE:
				price = (getSalary()*14) + (getAverageScore()*135) + (getGoals()*125);
				break;
			case DELANTERO:
				price = (getSalary()*15) + (getAverageScore()*145) + (getGoals()*150);
				break;
		}
		return price;
	}
	
	/**
	* calculates the level of a employee. <br>
	* <b>pre:</b> .<br>
	* <b>post:</b> employee level has been calculated.<br>
	*/
	@Override
	public double calculateLevel(){
		double level = 0;
		switch(position){
			case PORTERO:
				level = (getAverageScore()*0.9);
				break;
			case DEFENSOR:
				level = (getAverageScore()*0.9) + (getGoals()/100);
				break;
			case VOLANTE:
				level = (getAverageScore()*0.9) + (getGoals()/90);
				break;
			case DELANTERO:
				level = (getAverageScore()*0.9) + (getGoals()/80);
				break;
		}
		return level;
	}
	
	/**
	* saves the Player info in a String.<br>
	* <b>pre:</b> name, id, salary, state, teamName, number, goals, averageScore and position are initialized.<br>
	* <b>post:</b> Player info in a String.<br>
	*/
	@Override
	public String getInfo(){
		String info;
		info = super.getInfo() +
		"\nTeam name: " + getTeamName() +
		"\nT-shirt number: " + getNumber() +
		"\nScored goals: " + getGoals() +
		"\nAverage Score: " + getAverageScore() +
		"\nPosition: " + getPosition() +
		"\nMarket price: " + calculateMarketPrice() +
		"\nLevel: " + calculateLevel();
		return info;
	}

}