package model;
/**
* @author Diego Hidalgo Lopez
*/
public abstract class Employee{
	
	//attributes
	private String name; //Employee name
	private int id; //Employee id
	private double salary; //Employee salary
	private boolean state; //Employee state
	
	/**
	* constructor of the Employee class.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> .<br>
	*/
	public Employee(){
		name = "";
		id = 0;
		salary = 0.0;
		state = false;
	}
	
	/**
	* constructor of the Employee class.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> Employee class object created.<br>
	* @param name. Employee name. name != null. name != ""
	* @param id. Employee id. id != null.
	* @param salary. Employee salary. salary > 0
	* @param state. Employee state. state is initialized
	*/
	public Employee(String name, int id, double salary, boolean state){
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.state = state;
	}
	
	/**
	* changes the Employee name.<br>
	* <b>pre:</b> name is initialized.<br>
	* <b>post:</b> name has been changed.<br>
	* @param name. New Employee name. name != null. name != ""
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	* returns the Employee name.<br>
	* <b>pre:</b> name is initialized. name is not null<br>
	* <b>post:</b> Employee name.<br>
	*/
	public String getName(){
		return name;
	}
	
	/**
	* changes the Employee id.<br>
	* <b>pre:</b> id is initialized. id is not null.<br>
	* <b>post:</b> Employee id has been changed.<br>
	* @param id. New Employee id. id != null. 
	*/
	public void setId(int id){
		this.id = id;
	}
	
	/**
	* returns de Employee id.<br>
	* <b>pre:</b> id is initialized.<br>
	* <b>post:</b> Employee id.<br>
	*/
	public int getId(){
		return id;
	}
	
	/**
	* changes the Employee salary.<br>
	* <b>pre:</b> salary is initialized. salary is not null.<br>
	* <b>post:</b> Employee salary has been changed.<br>
	* @param salary. New Employee salary. salary > 0
	*/
	public void setSalary(double salary){
		this.salary = salary;
	}

	/**
	* returns the Employee salary.<br>
	* <b>pre:</b> salary is initialized.<br>
	* <b>post:</b> Employee salary.<br>
	*/
	public double getSalary(){
		return salary;
	}
	
	/**
	* changes the Employee state.<br>
	* <b>pre:</b> state is initialized.<br>
	* <b>post:</b> Employee state has been changed.<br>
	* @param state. New Employee state. state is initialized
	*/
	public void setState(boolean state){
		this.state = state;
	}
	
	/**
	* returns the Employee state.<br>
	* <b>pre:</b> state is initialized. state is not null.<br>
	* <b>post:</b> Employee state.<br>
	*/
	public boolean getState(){
		return state;
	}
	
	/**
	* returns a String with the Employee state info.<br>
	* <b>pre:</b> state is initialized. state is no null.<br>
	* <b>post:</b> String with the Employee state.<br>
	*/
	public String getStateInfo(){
		String info;
		if(getState()){
			info = "ACTIVO";
		}
		else{
			info = "INACTIVO";
		}
		return info;
	}
	
	/**
	* saves the Employee info in a String.<br>
	* <b>pre:</b> name, id, salary and state are initialized.<br>
	* <b>post:</b> String with the Employee info.<br>
	*/
	public String getInfo(){
		String info;
		info = "\nName: " + getName() +
		"\nId: " + getId() +
		"\nSalary: " + getSalary() +
		"\nState: " + getStateInfo();
		return info;
	}

}