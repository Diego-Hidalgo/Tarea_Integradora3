package model;
/**
* @author Diego Hidalgo Lopez
*/
import model.*;
import java.util.*;
public class Club{
	
	//constants
	private final static int ROWS_DR1 = 7; //First dressing room rows
	private final static int COLUMNS_DR1 = 6; //First dressing room columns
	private final static int ROWS_DR2 = 7; //Second dressing room rows
	private final static int COLUMNS_DR2 = 7; //Second dressing room columns
	private final static int ROWS_OFFICE = 6; //Office rows
	private final static int COLUMNS_OFFICE = 6; //Office rows
	private final static int AMOUNT_TEAMS = 2; //Amount teams
	
	//attributes
	private String name; //Club name
	private String nit; //Club nit
	private String foundationDate; //Club foundation date
	private ArrayList<Employee> employees; //Club employees 
	private Team[] teams; //Club teams
	private Coach[][] coachesOffice; //Club coaches offices building
	private Player[][] firstDressingRoom; //Club first dressing room building
	private Player[][] secondDressingRoom; //Club second dressing room building
	
	/**
	* constructor of the Club class. <br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> Club class object created. <br>
	* @param name. Club name. name != null. name != ""
	* @param nit Club nit. nit != null. nit != ""
	* @param foundationDate. Club foundation date. foundationDate != null. foundationDate != ""
	*/
	public Club(String name, String nit, String foundationDate){
		this.name = name;
		this.nit = nit;
		this.foundationDate = foundationDate;
		employees = new ArrayList<Employee>();
		teams = new Team[AMOUNT_TEAMS];
		coachesOffice = new Coach[ROWS_OFFICE][COLUMNS_OFFICE];
		firstDressingRoom = new Player[ROWS_DR1][COLUMNS_DR1];
		secondDressingRoom = new Player[ROWS_DR2][COLUMNS_DR2];
		addTeam("A");
		addTeam("B");
	}
	
	/**
	* changes the Club name <br>
	* <b>pre:</b> name is initialized.<br>
	* <b>post:</b> name has been changed.<b>
	* @param name. New Club name. name != null. name != ""
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	* returns the Club name.<br>
	* <b>pre:</b> name is initialized.<br>
	* <b>post:</b> Club name.<br>
	*/
	public String getName(){
		return name;
	}
	
	/**
	* changes the Club nit.<br>
	* <b>pre:</b> nit is initialized.<br>
	* <b>post:</b> Club nit has been changed.<br>
	* @param nit. Club nit. nit != null. nit != ""
	*/
	public void setNit(String nit){
		this.nit = nit;
	}
	
	/**
	* returns the Club nit.<br>
	* <b>pre:</b> nit is initialized.<br>
	* <b>post:</b> Club nit.<br>
	*/
	public String getNit(){
		return nit;
	}
	
	/**
	* changes the Club foundation date.<br>
	* <b>pre:</b> foundationDate is initialized.<br>
	* <b>post:</b> Club foundation date has been changed.<br>
	* @param foundationDate. Club foundation date. foundationDate != null. foundationDate != ""
	*/
	public void setFoundationDate(String foundationDate){
		this.foundationDate = foundationDate;
	}
	
	/**
	* returns the Club formation date.<br>
	* <b>pre:</b> foundationDate is initialized.<br>
	* <b>post:</b> Club foundationDate.<br>
	*/
	public String getFoundationDate(){
		return foundationDate;
	}
	
	/**
	* searches for an input on an array.<br>
	* <b>pre:</b> input is initialized.<br>
	* <b>post:</b> true if found. false if not<br>
	* @param tactic. input to search. tactic != null
	*/
	public boolean verifyTactic(String tactic){
		boolean verify = false;
		Tactic[] list = Tactic.values();
		for(int i = 0; i<list.length && !verify; i++){
			if(list[i].toString().equals(tactic)){
				verify = true;
			}
		}
		return verify;
	}
	
	/**
	* searches for an input on an array.<br>
	* <b>pre:</b> input is initialized.<br>
	* <b>post:</b> true if found. false if not<br>
	* @param position. input to search. position != null
	*/
	public boolean verifyPosition(String position){
		boolean verify = false;
		Position[] list = Position.values();
		for(int i = 0; i<list.length && !verify; i++){
			if(list[i].toString().equals(position)){
				verify = true;
			}
		}
		return verify;
	}
	
	/**
	* searches for an input on an array.<br>
	* <b>pre:</b> input is initialized.<br>
	* <b>post:</b> true if found. false if not<br>
	* @param expertise. input to search. expertise != null
	*/
	public boolean verifyExpertise(String expertise){
		boolean verify = false;
		Expertise[] list = Expertise.values();
		for(int i = 0; i<list.length && !verify; i++){
			if(list[i].toString().equals(expertise)){
				verify = true;
			}
		}
		return verify;
	}
	
	/**
	* searches for an Employee id.<br>
	* <b>pre:</b> id is initialized.<br>
	* <b>post:</b> true if found. false if not <br>
	* @param id. id to search. id != null
	*/
	public boolean verifyEmployeeId(int id){
		boolean verify = false;
		for(int i = 0; i<employees.size() && !verify; i++){
			if(employees.get(i).getId() == id){
				verify = true;
			}
		}
		return verify;
	}
	
	/**
	* searches for an alignment date on a team.<br>
	* <b>pre:</b> parameters are initialized. teamIndex >= 1<br>
	* <b>post:</b> true if found. false if not.<br>
	* @param teamIndex. team index to search. teamIndex >= 1
	* @param date. date to search. date != null
	*/
	public boolean verifyAlignmentDate(int teamIndex, String date){
		boolean verify = false;
		for(int i = 0; i<teams.length && !verify; i++){
			if(teams[i] != null && i == (teamIndex-1)){
				verify = teams[i].verifyAlignmentDate(date);
			}
		}
		return verify;
	}
	
	/**
	* verifies if the amount of plaers on a formation with a specific format is valid.<br>
	* <b>pre:</b> alignment is initialized.<br>
	* <b>post:</b> true if valir. false if not.<br>
	* @param alignment. alignment to validate. alignment != null
	*/
	public boolean verifyAlignmentAmountPlayers(String alignment){
		int amount = 0;
		String[] alignmentArray = alignment.split("-");
		int[] arrayInfo = new int[10];
		for(int i = 0; i<alignmentArray.length; i++){
			arrayInfo[i] = Integer.parseInt(alignmentArray[i]);
			amount += arrayInfo[i];
		}
		if(amount < 7 || amount > 10){
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	* counts the amount of teams.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> amount of teams.<br>
	*/
	public int amountTeams(){
		int amount = 0;
		for(int i = 0; i<teams.length; i++){
			if(teams[i] != null){
				amount ++;
			}
		} 
		return amount;
	}
	
	/**
	* counts the amount of employees in the club.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> amount of Employees.<br>
	*/
	public int amountEmployees(){
		return employees.size();
	}
	
	/**
	* counts the amount couches in the club.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> amount of coaches.<br>
	*/
	public int amountCoaches(){
		int amount = 0;
		for(int i = 0; i<employees.size(); i++){
			if(employees.get(i) instanceof Coach){
				amount ++;
			}
		}
		return amount;
	}
	
	/**
	* counts the amount of HeadCoaches in the club.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> amount of HeadCoaches.<br>
	*/
	public int amountHeadCoaches(){
		int amount = 0;
		for(int i = 0; i<employees.size(); i++){
			if(employees.get(i) instanceof HeadCoach){
				amount ++;
			}
		}
		return amount;
	}
	
	/**
	* counts the amount of technical assistants in the club.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> amount of technical assistants.<br>
	*/
	public int amountAssistants(){
		int amount = 0;
		for(int i = 0; i<employees.size(); i++){
			if(employees.get(i) instanceof TechnicalAssistant){
				amount ++;
			}
		}
		return amount;
	}
	
	/**
	* counts the amount of PLayers in the club.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> amount of plaers.<br>
	*/
	public int amountPlayers(){
		int amount = 0;
		for(int i = 0; i<employees.size(); i++){
			if(employees.get(i) instanceof Player){
				amount ++;
			}
		}
		return amount;
	}
	
	/**
	* saves the employees ids in a String with an index.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> Employees ids in a String.<br>
	*/
	public String getEmployeesId(){
		String info = "\nMostrando IDs de los empleados disponibles...\n\n";
		for(int i = 0; i<employees.size(); i++){
			if(employees.get(i).getState()){
				info += "[" + (i+1) + "]  " + employees.get(i).getId() + "\n";
			}
		}
		return info;
	}
	
	/**
	* saves the coaches ids in a String with an index.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> coaches ids in a String.<br>
	*/
	public String getCoachesId(){
		String info = "\nMostrando IDs de los entrenadores disponibles...\n\n";
		for(int i = 0; i<employees.size(); i++){
			if(employees.get(i).getState() && employees.get(i) instanceof Coach){
				info += "[" + (i+1) + "]  " + employees.get(i).getId() + "\n";
			}
		} 
		return info;
	}
	
	/**
	* saves the HeadCoaches ids in a String with an index.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> HeadCoaches ids in a String.<br>
	*/
	public String getHeadCoachesId(){
		String info = "\nMostrando IDs de los entrenadores principales disponibles...\n\n";
		for(int i = 0; i<employees.size(); i++){
			if(employees.get(i).getState() && employees.get(i) instanceof HeadCoach){
				info += "[" + (i+1) + "] " + employees.get(i).getId() + "\n";
			}
		}
		return info;
	}
	
	/**
	* saves the technicalAssistants ids in a String with an index.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> technicalAssistants ids in a String.<br>
	*/
	public String getTechnicalAssistantsId(){
		String info = "\nMostrando IDs de los asistentes tecnicos disponibles...\n\n";
		for(int i = 0; i<employees.size(); i++){
			if(employees.get(i).getState() && employees.get(i) instanceof TechnicalAssistant){
				info += "[" + (i+1) + "] " + employees.get(i).getId() + "\n";
			}
		}
		return info;
	}
	
	/**
	* saves the players ids in a String with an index.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> players ids in a String.<br>
	*/
	public String getPlayersId(){
		String info = "\nMostrando IDs de los jugadores disponibles...\n\n";
		for(int i = 0; i<employees.size(); i++){
			if(employees.get(i).getState() && employees.get(i) instanceof Player){
				info += "[" + (i+1) + "] " + employees.get(i).getId() + "\n";
			}
		}
		return info;
	}
	
	/**
	* saves the teams names in a String with an index.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> teams names in a String.<br>
	*/
	public String getTeamsNames(){
		String info = "\nMonstrando nombres de los equipos disponibles...\n\n";
		for(int i = 0; i<teams.length; i++){
			if(teams[i] != null){
				info += "[" + (i+1) + "] " + teams[i].getName() + "\n";
			}
		}
		return info;
	}
	
	/**
	* saves the info of the employees in a String with an index.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> employees info in a String.<br>
	*/
	public String getEmployeesInfo(){
		String info = "";
		for(int i = 0; i<employees.size(); i++){
			info += "\n[" + (i+1) + "]" + employees.get(i).getInfo() + "\n";
		}
		return info;
	}
	
	/**
	* saves the info of the teams in a String with an index.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> teams info in a String.<br>
	*/
	public String getTeamsInfo(){
		String info = "";
		for(int i = 0; i<teams.length; i++){
			if(teams[i] != null){
				info += "\n[" + (i+1) + "]" +teams[i].getInfo() + "\n";
			}
		}
		return info;
	}
	
	/**
	* adds a new Employee(player).<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> a new Employee has been added.<br>
	* @param name. Player name. name != null. name != ""
	* @param id. Player id. id != null.
	* @param salary. Player salary. salary > 0. 
	* @param state. Player state. state is initialized
	* @param number. Player number . number >= 0
	* @param goals. Player goals. goals >= 0
	* @param averageScore. Player average score >= 0
	* @param position. Player position. position != null. position != ""
	*/
	public void addEmployee(String name, int id, double salary, int number, int goals, double averageScore, String position){
		Player player = new Player(name, id, salary, true, number, goals, averageScore, position);
		employees.add(player);
	}
	
	/**
	* adds a new Employee(HeadCoach).<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> a new Employee has been added.<br>
	* @param id. HeadCoach id. id != null.
	* @param salary. HeadCoach salary. salary > 0. 
	* @param state. HeadCoach state. state is initialized
	* @param expYears. HeadCoach experience years. years >= 0
	* @param leadingTeams. HeadCoach leading teams. leadingTeams is initialized
	* @param achievedChampionShips. HeadCoach achieved championships. achievedChampionShips is initialized
	*/
	public void addEmployee(String name, int id, double salary, int expYears, int leadingTeams, int achievedChampionShips){
		HeadCoach headCoach = new HeadCoach(name, id, salary, true, expYears, leadingTeams, achievedChampionShips);
		employees.add(headCoach);
	}
	 
	/**
	* adds a new Employee(TechnicalAssistant).<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> a new Employee has been added.<br>
	* @param name. TechnicalAssistant name. name != null. name != ""
	* @param id. TechnicalAssistant id. id != null.
	* @param salary. TechnicalAssistant salary. salary > 0. 
	* @param state. TechnicalAssistant state. state is initialized
	* @param expYears. TechnicalAssistant experience years. years >= 0
	* @param professionalPlayer. TechnicalAssistant professionalPlayer info. professionalPlayer is initialized
	* @param expertise. TechnicalAssistant expertise. expertise is initialized
	*/
	public void addEmployee(String name, int id, double salary, int expYears, boolean professionalPlayer, String[] expertise){
		Expertise[] newExpertise = new Expertise[4];
		for(int i = 0; i<expertise.length; i++){
			if(expertise[i] != null){
				newExpertise[i] = Expertise.valueOf(expertise[i]);
			}
		}
		TechnicalAssistant technicalAssistant = new TechnicalAssistant(name, id, salary, true, expYears, professionalPlayer, newExpertise);
		employees.add(technicalAssistant);
	}
	
	/**
	* fires an employee.<br>
	* <b>pre:</b> employeeIndex is initialized.<br>
	* <b>post:</b> an employee has been fired.<br>
	* @param employeeId. id of the employee to fire. 
	*/
	public void fireEmployee(int employeeId){
		boolean fire = false;
		for(int i = 0; i<employees.size() && !fire; i++){
			if(employees.get(i).getId() == employeeId){
				employees.get(i).setState(false);
			}
		}
	}
	
	/**
	* updates an employee salary.<br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> salary has been changed. <br>
	* @param employeeId. employee to update. employee is initialized
	* @param newSalary. New employee salary. salary > 0
	*/
	public void updateEmployeeSalary(int employeeId, double newSalary){
		boolean update = false;
		for(int i = 0; i<employees.size() && !update; i++){
			if(employees.get(i).getId() == employeeId && employees.get(i).getState()){
				employees.get(i).setSalary(newSalary);
				update = true;
			}
		}
	}
	
	/**
	* updates the number of a player.<br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> number has been changed. <br>
	* @param playerId. player to update. playerId is initialized
	* @param newNumber. New player number. newNumber > 0
	*/
	public void updatePlayerNumber(int playerId, int newNumber){
		boolean update = false;
		for(int i = 0; i<employees.size() && !update; i++){
			if(employees.get(i).getId() == playerId && employees.get(i) instanceof Player && employees.get(i).getState()){
				Player player = (Player)employees.get(i);
				player.setNumber(newNumber);
				update = true;
			}
		}
	}
	
	/**
	* updates a players amount of goals.<br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> goals haven been changed. <br>
	* @param playerId. player to update. playerId is initialized
	* @param newGoals. New player goals. newGoals is initialized
	*/
	public void updatePlayerGoals(int playerId, int newGoals){
		boolean update = false;
		for(int i = 0; i<employees.size() && !update; i++){
			if(employees.get(i).getId() == playerId && employees.get(i) instanceof Player && employees.get(i).getState()){
				Player player = (Player)employees.get(i);
				player.setGoals(newGoals);
				update = true;
			}
		}
	}
	
	/**
	* updates a player average score.<br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> average score has been changed. <br>
	* @param playerId. player to update. playerId is initialized
	* @param newAvScore. New player average score. averageScore > 0
	*/
	public void updatePlayerAvScore(int playerId, double newAvScore){
		boolean update = false;
		for(int i = 0; i<employees.size() && !update; i++){
			if(employees.get(i).getId() == playerId && employees.get(i) instanceof Player && employees.get(i).getState()){
				Player player = (Player)employees.get(i);
				player.setAverageScore(newAvScore);
				update = true;
			}
		}
	}
	
	/**
	* updates a player position.<br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> position has been changed. <br>
	* @param playerId. player to update. playerId is initialized
	* @param newPosition. New player position. newPosition != null. newPosition != ""
	*/
	public void updatePlayerPosition(int playerId, String newPosition){
		boolean update = false;
		for(int i = 0; i<employees.size() && !update; i++){
			if(employees.get(i).getId() == playerId && employees.get(i) instanceof Player && employees.get(i).getState()){
				Player player = (Player)employees.get(i);
				player.setPosition(newPosition);
				update = true;
			}
		}
	}
	
	/**
	* updates a coach experience years.<br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> expYears have been changed. <br>
	* @param coachId. coach to update. coachId is initialized
	* @param newExpYears. New coach experience years. newExpYears > 0
	*/
	public void updateCoachExpYears(int coachId, int newExpYears){
		boolean update = false;
		for(int i = 0; i<employees.size() && !update; i++){
			if(employees.get(i).getId() == coachId){
				if(employees.get(i) instanceof HeadCoach && employees.get(i).getState()){
					HeadCoach coach = (HeadCoach)employees.get(i);
					coach.setExpYears(newExpYears);
					update = true;
				}
				else if(employees.get(i) instanceof TechnicalAssistant && employees.get(i).getState()){
					TechnicalAssistant coach = (TechnicalAssistant)employees.get(i);
					coach.setExpYears(newExpYears);
					update = true;	
				}
			}
		}
	}
	
	/**
	* updates a headCoach amount of achieved championships.<br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> championships have been changed. <br>
	* @param headCoachId. headCoach id to update. headCoachId is initialized
	* @param newChampionShips. New headCoach championships. newChampionShips is initialized
	*/
	public void updateHeadCoachChampionShips(int headCoachId, int newChampionShips){
		boolean update = false;
		for(int i = 0; i<employees.size() && !update; i++){
			if(employees.get(i).getId() == headCoachId && employees.get(i) instanceof HeadCoach && employees.get(i).getState()){
				HeadCoach headCoach = (HeadCoach)employees.get(i);
				headCoach.setAchievedChampionShips(newChampionShips);
				update = true;
			}
		}
	}
	
	/**
	* updates a technicalAssistant expertises.<br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> expertises have been updated. <br>
	* @param assistantId. technicalAssistant id. assistantId is initialized
	* @param newExpertise. New technicalAssistant expertises. newExpertise != null
	*/
	public void updateAssistantExpertises(int assistantId, String[] newExpertise){
		Expertise[] newExpertises = new Expertise[4];
		for(int i = 0; i<newExpertise.length; i++){
			if(newExpertise[i] != null){
				newExpertises[i] = Expertise.valueOf(newExpertise[i]);
			}
		}
		boolean update = false;
		for(int i = 0; i<employees.size() && !update; i++){
			if(employees.get(i).getId() == assistantId && employees.get(i) instanceof TechnicalAssistant && employees.get(i).getState()){
				TechnicalAssistant assistant = (TechnicalAssistant)employees.get(i);
				assistant.setExpertise(newExpertises);
				update = true;
			}
		}
	} 
	
	/**
	* adds a new Team.<br>
	* <b>pre:</b> name is initialized.<br>
	* <b>post:</b> a new team has been added.<br>
	* @param name. Team name to add. name != null
	*/
	public String addTeam(String name){
		boolean add = false;
		String msg = "No se pudo agregar al equipo";
		for(int i = 0; i<teams.length && !add; i++){
			if(teams[i] == null){
				teams[i] = new Team(name);
				msg = "Equipo agregado correctamente";
				add = true;
			}
		}
		return msg;
	}
	
	/**
	* adds a head coach to a team.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> a new head coach has been added to a team.<br>
	* @param teamIndex. index of the team to add. teamIndex > 0
	* @param headCoachId. id of the head coach to add.
	*/
	public void addHeadCoachToTeam(int teamIndex, int headCoachId){
		boolean add = false;
		for(int i = 0; i<employees.size() && !add; i++){
			if(employees.get(i).getState() && employees.get(i).getId() == headCoachId && employees.get(i) instanceof HeadCoach){
				HeadCoach coach = (HeadCoach)employees.get(i);
				teams[teamIndex-1].setHeadCoach(coach);
				coach.setLeadingTeams(coach.getLeadingTeams()+1);
				add = true;
			}
		}
	}
	
	/**
	* adds a new technical assistant to a team.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> a new technical assistant has been added to a team.<br>
	* @param teamIndex. index of the team to add. teamIndex > 0
	* @param assistantId. id of the assistant to add.
	*/
	public String addAssistantToTeam(int teamIndex, int assistantId){
		boolean add = false;
		String msg = "No se pudo agregar al asistente al equipo";
		for(int i = 0; i<employees.size() && !add; i++){
			if(employees.get(i).getState() && employees.get(i).getId() == assistantId && employees.get(i) instanceof TechnicalAssistant){
				TechnicalAssistant assistant = (TechnicalAssistant)employees.get(i);
				boolean result = teams[teamIndex-1].addTechnicalAssistant(assistant);
				if(result){
					msg = "Asistente agregado correctamente al equipo";
					add = true;
				}
				else{
					msg = "No se pudo agregar al asistente al equipo";
				}
			}
		}
		return msg;
	}
	
	/**
	* adds a new player to a team.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> a new player has been added to a team.<br>
	* @param teamIndex. index of the team to add. teamIndex > 0
	* @param playerId. id of the player to add.
	*/
	public String addPlayerToTeam(int teamIndex, int playerId){
		boolean add = false;
		String msg = "No se pudo agregar al jugador al equipo";
		for(int i = 0; i<employees.size() && !add; i++){
			if(employees.get(i).getState() && employees.get(i).getId() == playerId && employees.get(i) instanceof Player){
				Player player = (Player)employees.get(i);
				player.setTeamName(teams[teamIndex-1].getName());
				boolean result = teams[teamIndex-1].addPlayer(player);
				if(result){
					msg = "Jugador agregado correctamente al equipo";
					add = true;
				}
				else{
					msg = "No se pudo agregar al jugador al equipo";
				}
			}
		}
		return msg;
	}
	
	/**
	* adds a new alignment to a team.<br>
	* <b>pre:</b> parametrs are initialized.<br>
	* <b>post:</b> a new alignment has been added to a team.<br>
	* @param teamIndex. index of the team to add. teamIndex > 0
	* @param date. Alignment date. date != null. date != "".
	* @param tactic. Alignment tactic. tactic != null. tactic != "".
	* @param formation. Alignemnt formation. formation != null. formation != "".
	*/
	public void addAlignmentToTeam(int teamIndex, String date, String tactic, String formation){
		teams[teamIndex-1].addAlignment(date, tactic, formation);
	}
	
	/**
	* adds a coach to a office.<br>
	* <b>pre:</b> coachIndex is initialized.<br>
	* <b>post:</b> a coach has been added to a office.<br>
	* @param coachId. index of the coach to add.
	*/
	public String addCoachToOffice(int coachId){
		String msg = "No se pudo agregar al entrenador a la oficina";
		boolean add = false;
		int distance = 0;
		for(int i = 0; i<employees.size() && !add; i++){
			if(employees.get(i).getState() && employees.get(i).getId() == coachId && employees.get(i) instanceof Coach){
				for(int j = 0; j<ROWS_OFFICE && !add; j++){
					for(int k = 0; k<COLUMNS_OFFICE && !add; k++){
						if(coachesOffice[j][k] == null){
							if(distance % 2 == 0){
								coachesOffice[j][k] = (Coach)employees.get(i);
								msg = "Entrenador agregado correctamente a la oficina";
								add = true;
							}
						}
						distance ++;
					}
					distance ++;
				}
			}
		}
		return msg;
	}
	
	/**
	* adds a player to a dressing room.<br>
	* <b>pre:</b> playerIndex is initialized.<br>
	* <b>post:</b> a player has been added to a dressing room.<br>
	* @param playerId. index of the player to add. 
	*/
	public String addPlayerToDressingRoom(int playerId){
		String msg = "No se pudo agregar al jugador al vestuario";
		boolean add = false; 
		int distance = 0;
		for(int i = 0; i<employees.size() && !add; i++){
			if(employees.get(i).getState() && employees.get(i).getId() == playerId && employees.get(i) instanceof Player){
				Player player = (Player)employees.get(i);
				if(player.getTeamName().equalsIgnoreCase("A")){
					msg = addPlayerToFirstDressingRoom(player);
					add = true;
				}
				else if(player.getTeamName().equalsIgnoreCase("B")){
					msg = addPlayerToSecondDressingRoom(player);
					add = true;
				}
			}
		}
		return msg;
	} 
	
	/**
	* adds a player to the first dressing room.<br>
	* <b>pre:</b> playerIndex is initialized.<br>
	* <b>post:</b> a player has been added to the first dressing room.<br>
	* @param player. Player to add. player != null
	*/
	public String addPlayerToFirstDressingRoom(Player player){
		String msg = "No se pudo agregar el jugador al vestuario";
		boolean add = false; 
		int distance = 0;
		for(int i = 0; i<ROWS_DR1 && !add; i++){
			for(int j = 0; j<COLUMNS_DR1 && !add; j++){
				if(firstDressingRoom[i][j] == null){
					if(distance % 2 == 0){
						firstDressingRoom[i][j] = player;
						msg = "Jugador agregado correctamente al vestidor";
						add = true;
					}
				}
				distance ++;
			}
			distance ++;
		}
		return msg;
	}
	
	/**
	* adds a player to the second dressing room.<br>
	* <b>pre:</b> playerIndex is initialized.<br>
	* <b>post:</b> a player has been added to the second dressing room.<br>
	* @param player. Player to add. player != null
	*/
	public String addPlayerToSecondDressingRoom(Player player){
		String msg = "No se pudo agregar el jugador al vestuario";
		boolean add = false; 
		int distance = 0;
		for(int i = 0; i<ROWS_DR2 && !add; i++){
			for(int j = 0; j<COLUMNS_DR2 && !add; j++){
				if(secondDressingRoom[i][j] == null){
					if(distance % 2 == 0){
						secondDressingRoom[i][j] = player;
						msg = "Jugador agregado correctamente al vestidor";
						add = true;
					}
				}
				distance ++;
			}
			distance ++;
		}
		return msg;
	}
	
	/**
	* saves the info of the office on a String.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> info of an office.<br>
	*/
	public String getOfficesInfo(){
		String info = "";
		for(int i = 0; i<ROWS_OFFICE; i++){
			for(int j = 0; j<COLUMNS_OFFICE; j++){
				if(coachesOffice[i][j] != null){
					info += "O ";
				}
				else{
					info += "X ";
				}
				if(j == (COLUMNS_OFFICE-1)){
					info += "\n";
				}
			}
		}
		return info;
	}
	
	/**
	* saves the info of the first dressing room on a String.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> info of the first dressing room.<br>
	*/
	public String getFirstDressingRoomInfo(){
		String info = "";
		for(int i = 0; i<ROWS_DR1; i++){
			for(int j = 0; j<COLUMNS_DR1; j++){
				if(firstDressingRoom[i][j] != null){
					info += "O ";
				}
				else{
					info += "X ";
				}
				if(j == (COLUMNS_DR1-1)){
					info += "\n";
				}
			}
		}
		return info;
	} 
	
	/**
	* saves the info of the second dressing room on a String.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> info of the second dressing room.<br>
	*/
	public String getSecondDressingRoomInfo(){
		String info = "";
		for(int i = 0; i<ROWS_DR2; i++){
			for(int j = 0; j<COLUMNS_DR2; j++){
				if(secondDressingRoom[i][j] != null){
					info += "O ";
				}
				else{
					info += "X ";
				}
				if(j == (COLUMNS_DR2-1)){
					info += "\n";
				}
			}
		}
		return info;
	}
	
	/**
	* saves the info of a team on a String.<br>
	* <b>pre:</b> teamIndex is initialized.<br>
	* <b>post:</b> info of team.<br>
	* @param teamIndex. index of the team to save info. teamIndex > 0
	*/
	public String getTeamInfo(int teamIndex){
		String info = "";
		info = teams[teamIndex-1].getInfo();
		return info; 
	}
	
	/**
	* saves the info of an alignment on a String.<br>
	* <b>pre:</b> teamIndex is initialized.<br>
	* <b>post:</b> info of a team alignment.<br>
	* @param teamIndex. index of the team to save info. teamIndex > 0
	*/
	public String getTeamAlignmentsInfo(int teamIndex){
		String info;
		info = teams[teamIndex-1].getAlignmentsInfo();
		return info; 
	}
	
	/**
	* saves the info of an employee on a String.<br>
	* <b>pre:</b> employeeIndex is initialized.<br>
	* <b>post:</b> info of an employee.<br>
	* @param employeeId. id of the employee to save info. 
	*/
	public String getEmployeeInfo(int employeeId){
		boolean find = false;
		String info = ""; 
		for(int i = 0; i<employees.size() && !find; i++){
			if(employees.get(i).getId() == employeeId){
				info = employees.get(i).getInfo();
				find = true;
			}
		}
		
		return info;
	}
	
	/**
	* saves the info of the Club in a String.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> Club info in a String.<br>
	*/
	public String getInfo(){
		String info;
		info = "\nName: " + getName() +
		"\nNit: " + getNit() +
		"\nFoundation Date: " + getFoundationDate();
		return info; 
	}
	
	/**
	* saves all the info of the Club in a String.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> All Club info in a String.<br>
	*/
	public String getAllInfo(){
		String info;
		info = "\nMostrando informacion del club...\n" + getInfo() +
		"\n\nMostrando informacion de los equipos...\n" + getTeamsInfo() +
		"\nMostrando informacion de los empleados...\n" + getEmployeesInfo() +
		"\nMostrando distribucion de las instalaciones... (X = Vacio. O = Ocupado)\n" +
		"\nMostrando distribucion de la oficina de entrenadores...\n" + getOfficesInfo() +
		"\nMostrando distribucion del primer vestidor (Equipo A)...\n" + getFirstDressingRoomInfo() +
		"\nMostrando distribucion del segundo vestidor (Equipo B)...\n" + getSecondDressingRoomInfo();
		return info;
	}
	
}