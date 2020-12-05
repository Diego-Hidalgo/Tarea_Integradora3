package model;
/**
* @author Diego Hidalgo Lopez. 
*/
public class Alignment{
	
	//constants
	private final static int ROWS = 10;  //Field formation rows
	private final static int COLUMNS = 7; //Field formation columns

	//attibutes
	private String date; //Alignment date
	private Tactic tactic; //Alignemnt tactic
	private int[][] fieldFormation; //Alignment field formations
	
	
	/**
	* Constructor of the Alignment class. <br>
	* <b>pre:</b> parameters are initialized.
	* <b>post:</b> Alignment class object created.
	* @param date. Alignment date. date != null. date != "".
	* @param tactic. Alignment tactic. tactic != null. tactic != "".
	*/
	public Alignment(String date, String tactic){
		this.date = date;
		this.tactic = Tactic.valueOf(tactic);
		fieldFormation = new int[ROWS][COLUMNS];
	}
	
	
	/**
	* Changes the date of the Alignment.<br>
	* <b>pre:</b> date is initialized.<br>
	* <b>post:</b> date has been changed.<br>
	* @param date. New Alignment date. date != null. date != "".
	*/
	public void setDate(String date){
		this.date = date;
	}
	
	/**
	* returns the date of the Alignment.<br>
	* <b>pre:</b> date is initialized. date is not null.<br>
	* <b>post:</b> date of the Alignemnt.<br>
	*/
	public String getDate(){
		return date;
	}
	
	/**
	* Changes the tactic of the Alignment.<br>
	* <b>pre:</b> tactic is initialized.<br>
	* <b>post:</b> tactic has been changed.<br>
	* @param tactic. New Alignemnt tactic. tactic != null. tactic != "".
	*/
	public void setTactic(String tactic){
		this.tactic = Tactic.valueOf(tactic);
	}
	
	/**
	* returns the tactic of the Alignment.<br>
	* <b>pre:</b> tactic is initialized. tactic is not null.<br>
	* <b>post:</b> tactic of the Alignemnt.<br>
	*/
	public Tactic getTactic(){
		return tactic;
	}
	
	/**
	* Changes the fieldFormation of the Alignemnt.<br>
	* <b>pre:</b> fieldFormation is initialized.<br>
	* <b>post:</b> fieldFormation has been changed.<br>
	* @param fieldFormation. New Alignemnt formation. formation is initialized.
	*/
	public void setFieldFormation(int[][] fieldFormation){
		this.fieldFormation = fieldFormation;
	}
	
	/**
	* Changes the fieldFormation of the Alignemnt.<br>
	* <b>pre:</b> fieldFormation is initialized.<br>
	* <b>post:</b> fieldFormation has been changed.<br>
	* @param formation. New Alignemnt formation. formation != null. formation != "".
	*/
	public void setFieldFormation(String formation){
		int aux = 9;
		boolean stop = false;
		int amount = 0;
		String[] array = formation.split("-");
		int[] arrayInfo = new int[10];
		for(int i = 0; i<array.length; i++){
			arrayInfo[aux] = Integer.parseInt(array[i]);
			aux--;
		}
		for(int i = 0; i<arrayInfo.length; i++){
			if(arrayInfo[i] != 0){
				amount ++;
			}
		}
		for(int i = 9; i>=0; i--){
			for(int j = 9; j>=0; j--){
				int count = 0;
				stop = false;
				if(arrayInfo[i] != 0){
					for(int k = 0; k<=COLUMNS && !stop; k++){
						if(count != arrayInfo[i]){
							if(amount < 5 && j%3 == 0){
								fieldFormation[j][k] = 1;
								count ++;
							}
							else if(amount == 5 && j%2 == 0){
								fieldFormation[j][k] = 1;
								count ++;
							}
							else if(amount > 5){
								fieldFormation[j][k] = 1;
								count ++;
							}
							
						}
						else{
							i--;
							stop = true;
						}
					}
				}
			}
		}
		organizeFieldFormation();
	}
	
	/**
	* Organizes the fieldFormation. <br>
	* <b>pre:</b> fieldFormation is initialized. <br>
	* <b>post:</b> fieldFormation has been organized. <br>
	*/
	public void organizeFieldFormation(){
		boolean organize = false;
		for(int i = 0; i<ROWS; i++){
			organize = false;
			for(int j = 0; j<COLUMNS; j++){
				for(int k = 0; k<COLUMNS && !organize; k++){
					if(fieldFormation[i][0] != fieldFormation[i][6] || fieldFormation[i][1] != fieldFormation[i][5] || fieldFormation[i][2] != fieldFormation[i][4]){
						if(fieldFormation[i][j] == 1 && fieldFormation[i][j+1] == 0){
							fieldFormation[i][j] = 0;
							fieldFormation[i][j+1] = 1;
							j = 0;
						}
					}
					else{
						organize = true;
					}
				}
			}
		}
	}
	
	/**
	* returns the fieldFormation of the Alignemnt.<br>
	* <b>pre:</b> fieldFormation is initialized.<br>
	* <b>post:</b> fieldFormation of the Alignemnt.<br>
	*/
	public int[][] getFieldFormation(){
		return fieldFormation;
	}
	
	/**
	* converts the fieldFormation Matrix to a format. <br>
	* <b>pre:</b> fieldFormation is initialized. <br>
	* <b>post:</b> fieldFormation in a specific format. <br>
	*/
	public String fieldFormationToString(){
		String info = "";
		int[] values = new int[10];
		int count = 0;
		for(int i = 0; i<10; i++){
			count = 0;
			for(int j = 0; j<COLUMNS; j++){
				if(fieldFormation[i][j] != 0){
					count ++;
				}
			}
			values[i] = count;
		}
		int amount = 0;
		for(int i = 0; i<values.length; i++){
			if(values[i] != 0){
				amount ++;
			}
		}
		int aux = 1;
		for(int i = 9; i>=0; i--){
			if(values[i] != 0){
				if(aux != amount){
					info += values[i] + "-";
					aux++;
				}
				else{
					info += values[i];
				}
			}
		}
		return info;
	}
	
	/**
	* returns the fieldFormation Matrix in a String. <br>
	* <b>pre:</b> fieldFormation is initialized. <br>
	* <b>post:</b> information of the fieldFormation in a String. <br>
	*/
	public String getFieldFormationInfo(){
		String info = "";
		for(int i = 0; i<ROWS; i++){
			for(int j = 0; j<COLUMNS; j++){
				if(j != (COLUMNS-1)){
					info += fieldFormation[i][j] + "  ";
				}
				else{
					info += fieldFormation[i][j] + "\n";
				}
			}
		}
		return info;
	}
	
	/**
	* saves the Alignemnt info on a String. <br>
	* <b>pre:</b>date, tactic, and fieldFormation are initialized. <br>
	* <b>post:</b>info of the alignment. <br>
	*/
	public String getInfo(){
		String info;
		info = "\nDate: " + getDate() +
		"\nTactic: " + getTactic() +
		"\nFormation: "+ fieldFormationToString() +
		"\nRepresentation: \n"+ getFieldFormationInfo();
		return info;
	}

}