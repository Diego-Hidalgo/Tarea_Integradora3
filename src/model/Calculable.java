package model;
/**
* @author Diego Hidalgo Lopez
*/
public interface Calculable{
	
	/**
	* calculates the market price of a employee. <br>
	* <b>pre:</b> .<br>
	* <b>post:</b> employee market price has been calculated.<br>
	*/
	public double calculateMarketPrice();
	
	/**
	* calculates the level of a employee. <br>
	* <b>pre:</b> .<br>
	* <b>post:</b> employee level has been calculated.<br>
	*/
	public double calculateLevel();

}