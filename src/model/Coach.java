package model;
/**
* @author Diego Hidalgo Lopez
*/
public abstract class Coach extends Employee{

	//attributes
	private int expYears; //Coach experience years
	
	/**
	* constructor of the Coach class.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> Coach class object created.<br>
	*/
	public Coach(){
		super();
		this.expYears = 0;
	}
	
	/**
	* constructor of the Coach class.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> Coach class object created.<br>
	* @param name. Coach name. name != null. name != ""
	* @param id. Coach id. id != null.
	* @param salary. Coach salary. salary > 0. 
	* @param state. Coach state. state is initialized
	* @param expYears. Coach experience years. years >= 0
	*/
	public Coach(String name, int id, double salary, boolean state, int expYears){
		super(name, id, salary, state);
		this.expYears = expYears;
	}
	
	/**
	* changes the Coach experience years.<br>
	* <b>pre:</b> expYears is initialized. expYears > 0.<br>
	* <b>post:</b> expYears have been changed.<br>
	*/
	public void setExpYears(int expYears){
		this.expYears = expYears;
	}
	
	/**
	* returns de Coach experience years.<br>
	* <b>pre:</b> expYears is initialized.<br>
	* <b>post:</b> experience years of the Coach.<br>
	*/
	public int getExpYears(){
		return expYears;
	}
	
	/**
	* saves the Coach info in a String.<br>
	* <b>pre:</b> name, id, salary, state and expYears are initialized.<br>
	* <b>post:</b> info of the Coach.<br>
	*/
	@Override
	public String getInfo(){
		String info;
		info = super.getInfo() +
		"\nYears of experience: " + getExpYears();
		return info;
	}

}