package model;
/**
* @author Diego Hidalgo Lopez
*/
public class TechnicalAssistant extends Coach{

	//attributes
	private boolean professionalPlayer; //TechnicalAssistant professionalPlayer info
	private Expertise[] expertise; //TechnicalAssistant expertise
	
	/**
	* constructor of the TechnicalAssistant class.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> TechnicalAssistant class object created.<br>
	* @param name. TechnicalAssistant name. name != null. name != ""
	* @param id. TechnicalAssistant id. id != null.
	* @param salary. TechnicalAssistant salary. salary > 0. 
	* @param state. TechnicalAssistant state. state is initialized
	* @param expYears. TechnicalAssistant experience years. years >= 0
	* @param professionalPlayer. TechnicalAssistant professionalPlayer info. professionalPlayer is initialized
	* @param expertise. TechnicalAssistant expertise. expertise is initialized
	*/
	public TechnicalAssistant(String name, int id, double salary, boolean state ,int expYears, boolean professionalPlayer, Expertise[] expertise){
		super(name, id, salary, state, expYears );
		this.professionalPlayer = professionalPlayer;
		this.expertise = expertise;
	}
	
	/**
	* changes the TechnicalAssistant professionalPlayer info.<br>
	* <b>pre:</b> professionalPlayer is initialized.<br>
	* <b>post:</b> TechnicalAssistant professionalPlayer has been changed.<br>
	* @param professionalPlayer. TechnicalAssistant professionalPlayer info. professionalPlayer is initialized
	*/
	public void setProfessionalPlayer(boolean professionalPlayer){
		this.professionalPlayer = professionalPlayer;
	}
	
	/**
	* returns the TechnicalAssistant professionalPlayer info.<br>
	* <b>pre:</b> professionalPlayer is initialized.<br>
	* <b>post:</b> professionalPlayer.<br>
	*/
	public boolean getProfessionalPlayer(){
		return professionalPlayer;
	}
	
	/**
	* changes the TechnicalAssistant expertise.<br>
	* <b>pre:</b> expertise is initialized.<br>
	* <b>post:</b> expertise has been changed.<br>
	* @param expertise. TechnicalAssistant set of expertise. expertise is initialized
	*/
	public void setExpertise(Expertise[] expertise){
		this.expertise = expertise;
	}
	
	/**
	* returns the TechnicalAssistant expertise.<br>
	* <b>pre:</b> expertise is initialized.<br>
	* <b>post:</b> expertise.<br>
	*/
	public Expertise[] getExpertise(){
		return expertise;
	}
	
	/**
	* returns the TechnicalAssistant expertise info in a String.<br>
	* <b>pre:</b> expertise is initialized.<br>
	* <b>post:</b> TechnicalAssistant expertise info.<br>
	*/
	public String expertiseInfo(){
		String info = "";
		for(int i = 0; i < 4; i ++){
			if(expertise[i] != null){
				info += expertise[i] + " ";
			}
		}
		return info;
	}
	
	/**
	* saves the TechnicalAssistant info in a String.<br>
	* <b>pre:</b> name, id, salary, state, expYears, professionalPlayer and expertise are initialized.<br>
	* <b>post:</b> TechnicalAssistant info in a String.<br>
	*/
	@Override
	public String getInfo(){
		String info;
		info = super.getInfo() +
		"\nProfessional player: " + getProfessionalPlayer() +
		"\nExpertise: " + expertiseInfo();
		return info;
	}

}