package ui;
/**
* @author Diego Hidalgo Lopez
*/
import java.util.Scanner;
import model.*;
public class Menu{
	
	//Main Menu options
	private final static int ADD_EMPLOYEE = 1;
	private final static int FIRE_EMPLOYEE = 2;
	private final static int UPDATE_EMPLOYEE_DATA = 3;
	private final static int ADD_HEADCOACH_TO_TEAM = 4;
	private final static int ADD_ASSISTANT_TO_TEAM = 5;
	private final static int ADD_PLAYER_TO_TEAM = 6;
	private final static int ADD_ALIGNMENT_TO_TEAM = 7;
	private final static int ADD_COACH_TO_OFFICE = 8;
	private final static int ADD_PLAYER_TO_DRESSING_ROOM = 9;
	private final static int SHOW_OFFICES = 10;
	private final static int SHOW_DRESSING_ROOMS = 11;
	private final static int SHOW_TEAM_INFO = 12;
	private final static int SHOW_TEAM_ALIGNMENTS = 13;
	private final static int SHOW_EMPLOYEE_INFO= 14;
	private final static int SHOW_ALL_INFO = 15;
	private final static int EXIT = 16;
	
	//Employee types options
	private final static int PLAYER = 1;
	private final static int HEADCOACH = 2;
	private final static int TECHNICAL_ASSISTANT = 3;
	
	//Update options
	private final static int UPDATE_SALARY = 1;
	private final static int UPDATE_NUMBER = 2;
	private final static int UPDATE_GOALS = 3;
	private final static int UPDATE_AVERAGE_SCORE = 4;
	private final static int UPDATE_POSITION = 5;
	private final static int UPDATE_EXP_YEARS = 6;
	private final static int UPDATE_AMOUNT_CHAMPIONSHIPS = 7;
	private final static int UPDATE_EXPERTISES = 8;
	
	private static Scanner sc = new Scanner(System.in);
	private Club app;
	
	/**
	* Constructor of the Menu class. <br>
	* <b>pre:</b>.<br>
	* <b>post:</b> Menu class object created. <br>
	*/
	public Menu(){
		this.app = readInitialData();
	}
	
	/**
	* reads the data necessary to create a Club object. <br> 
	* <b>pre:</b> 
	* <b>post:</b> a Club object has been created. <br>
	*/
	public Club readInitialData(){
		System.out.print("Nombre del club: ");
		String name = sc.nextLine();
		System.out.print("NIT del club: ");
		String nit = sc.nextLine();
		System.out.print("Fecha de fundacion del club: ");
		String foundationDate = sc.nextLine();
		app = new Club(name, nit, foundationDate);
		return app;
	}
	
	/**
	* Options of the menu. <br>
	* <b>pre:</b><br>
	* <b>post:</b> Shows the options menu available. <br>
	*/
	public void showMenu(){
		System.out.print("\n");
		System.out.println("Que desea hacer?");
		System.out.println(" [1] Agregar un empleado al club");
		System.out.println(" [2] Despedir un empleado del club");
		System.out.println(" [3] Actualiza datos de un empleado");
		System.out.println(" [4] Agregar entrenador principal a un equipo");
		System.out.println(" [5] Agregar asistente tecnico a un equipo");
		System.out.println(" [6] Agregar jugador a un equipo");
		System.out.println(" [7] Agregar alineacion a un equipo");
		System.out.println(" [8] Asignar un entrenador a una oficina");
		System.out.println(" [9] Asignar un jugador a un vestidor");
		System.out.println("[10] Mostrar informacion de las oficinas");
		System.out.println("[11] Mostrar informacion de los vestidores");
		System.out.println("[12] Mostrar informacion de un equipo");
		System.out.println("[13] Mostrar alineaciones de un equipo");
		System.out.println("[14] Mostrar informacion de un empleado");
		System.out.println("[15] Mostrar toda la informacion");
		System.out.println("[16] Salir");
		System.out.print("Opcion: ");
	}
	
	/**
	* Employee options. <br>
	* <b>pre:</b><br>
	* <b>post:</b> Shows the Employee options menu available. <br>
	*/
	public void showEmployeeTypes(){
		System.out.println("Que tipo de empleado desea agregar?");
		System.out.println("[1] Jugador");
		System.out.println("[2] Entrenador principal");
		System.out.println("[3] Asistente tecnico");
		System.out.print("Opcion: ");
	}
	
	/**
	* Update options. <br>
	* <b>pre:</b><br>
	* <b>post:</b> Shows the update options menu available. <br>
	*/
	public void showUpdateOptions(){
		System.out.print("\n");
		System.out.println("Que desea actualizar?");
		System.out.println("[1] Actualizar salario de un empleado");
		System.out.println("[2] Actualizar numero de un jugador");
		System.out.println("[3] Actualizar cantidad de goles de un jugador");
		System.out.println("[4] Actualizar calificacion promedio de un jugador");
		System.out.println("[5] Actualizar posicion de un jugador");
		System.out.println("[6] Actualizar anios de experiencia de un entrenador");
		System.out.println("[7] Actualizar cantidad de campeonatos conseguidos de un entrenador principal");
		System.out.println("[8] Actualizar experticias de un asistente tecnico");
		System.out.print("Opcion: ");
	}
	
	/**
	* Reads the option to select by the user. <br>
	* <b>pre: option is initialized.</b><br>
	* <b>post:</b> the option selected by the user. <br>
	*/
	public int readOption(){
		int option = sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	/**
	* Reads and validates an employee id. <br>
	* <b>pre:</b> . <br>
	* <b>post:</b> an Employee id. <br>
	*/
	public int chooseEmployeeId(){
		System.out.print(app.getEmployeesId());
		System.out.print("\nId correspondiente del empleado: ");
		int id = sc.nextInt();
		sc.nextLine();
		while(!app.verifyEmployeeId(id)){
			System.out.println("Id invalido");
			System.out.print("\nId correspondiente del empleado: ");
			id = sc.nextInt();
			sc.nextLine();
		}
		return id;
	}
	
	/**
	* Reads and validates a Team index. <br>
	* <b>pre:</b> . <br>
	* <b>post:</b> a Team index. <br>
	*/
	public int chooseTeamIndex(){
		System.out.print(app.getTeamsNames());
		System.out.print("\nNumero correspondiente del equipo: ");
		int teamIndex = sc.nextInt();
		sc.nextLine();
		while(teamIndex < 1 || teamIndex > app.amountTeams()){
			System.out.println("Indice invalido");
			System.out.print("\nNumero correspondiente del equipo: ");
			teamIndex = sc.nextInt();
			sc.nextLine();
		}
		return teamIndex;
	}
	
	/**
	* Reads and validates a Coach id. <br>
	* <b>pre:</b> . <br>
	* <b>post:</b> an Coach id. <br>
	*/
	public int chooseCoachId(){
		System.out.print(app.getCoachesId());
		System.out.print("\nId correspondiente del entrenador: ");
		int id = sc.nextInt();
		sc.nextLine();
		while(!app.verifyEmployeeId(id)){
			System.out.println("Id invalido");
			System.out.print("\nId correspondiente del entrenador: ");
			id = sc.nextInt();
			sc.nextLine();
		}
		return id;
	}
	
	/**
	* Reads and validates a HeadCoach id. <br>
	* <b>pre:</b> . <br>
	* <b>post:</b> a HeadCoach id. <br>
	*/
	public int chooseHeadCoachId(){
		System.out.print(app.getHeadCoachesId());
		System.out.print("\nId correspondiente del entrenador principal: ");
		int id = sc.nextInt();
		sc.nextLine();
		while(!app.verifyEmployeeId(id)){
			System.out.println("Id invalido");
			System.out.print("\nId correspondiente del entrenador principal: ");
			id = sc.nextInt();
			sc.nextLine();
		}
		return id;
	}
	
	/**
	* Reads and validates a TechnicalAssistant id. <br>
	* <b>pre:</b> . <br>
	* <b>post:</b> a TechnicalAssistant id. <br>
	*/
	public int chooseAssistantId(){
		System.out.print(app.getTechnicalAssistantsId());
		System.out.print("\nId correspondiente del asistente tecnico: ");
		int id = sc.nextInt();
		sc.nextLine();
		while(!app.verifyEmployeeId(id)){
			System.out.println("Id invalido");
			System.out.print("\nId correspondiente del asistente tecnico tecnico: ");
			id = sc.nextInt();
			sc.nextLine();
		}
		return id;
	}
	
	/**
	* Reads and validates a player id. <br>
	* <b>pre:</b> . <br>
	* <b>post:</b> an Player id. <br>
	*/
	public int choosePlayerId(){
		System.out.print(app.getPlayersId());
		System.out.print("\nId correspondiente del jugador: ");
		int id = sc.nextInt();
		sc.nextLine();
		while(!app.verifyEmployeeId(id)){
			System.out.println("Id invalido");
			System.out.print("\nId correspondiente del jugador: ");
			id = sc.nextInt();
			sc.nextLine();
		}
		return id;
	}
	
	/**
	* Reads the common data of an Employee. <br>
	* <b>pre:</b><br>
	* <b>post:</b> Employee has been created. <br>
	*/
	public void addEmployee(){
		System.out.print("\n");
		System.out.print("Nombre: ");
		String name = sc.nextLine();
		System.out.print("Id: ");
		int id = sc.nextInt();
		sc.nextLine();
		while(app.verifyEmployeeId(id)){
			System.out.println("La id ingresada ya se encuentra en uso, pruebe otra");
			System.out.print("Id: ");
			id = sc.nextInt();
		}
		System.out.print("Salario: ");
		double salary = sc.nextDouble();
		sc.nextLine();
		showEmployeeTypes();
		int option = readOption();
		switch(option){
			case PLAYER:
				addPlayer(name, id, salary);
				break;
			case HEADCOACH:
				addHeadCoach(name, id, salary);
				break;
			case TECHNICAL_ASSISTANT:
				addTechnicalAssistant(name, id, salary);
				break;
			default:
				System.out.println("Opcion invalida");
		}
	}
	
	/**
	* Reads the necessary data to add a Player. <br>
	* <b>pre:</b><br>
	* <b>post:</b> Player has been created. <br>
	* @param name. Employee name. name != null. name != ""
	* @param id. Employee id. id != null.
	* @param salary. Employee salary. salary > 0
	*/
	public void addPlayer(String name, int id, double salary){
		System.out.print("Numero de la camiseta: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Cantidad de goles: ");
		int goals = sc.nextInt();
		sc.nextLine();
		System.out.print("Calificacion promedio: ");
		double avScore = sc.nextDouble();
		sc.nextLine();
		System.out.print("Posiciones disponibles");
		System.out.print("\n- Portero \n- Defensor \n- Volante \n- Delantero \n");
		System.out.print("Posicion: ");
		String position = sc.nextLine().toUpperCase();
		while(!app.verifyPosition(position)){
			System.out.println("Posicion invalida");
			System.out.print("Posicion: ");
			position = sc.nextLine().toUpperCase();
		}
		app.addEmployee(name, id, salary, number, goals, avScore, position);
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to add a HeadCoach. <br>
	* <b>pre:</b><br>
	* <b>post:</b> HeadCoach has been created. <br>
	* @param name. Employee name. name != null. name != ""
	* @param id. Employee id. id != null. 
	* @param salary. Employee salary. salary > 0
	*/
	public void addHeadCoach(String name, int id, double salary){
		System.out.print("Anios de experiencia: ");
		int expYears = sc.nextInt();
		sc.nextLine();
		System.out.print("Cantidad de equipos que dirige: ");
		int leadingTeams = sc.nextInt();
		sc.nextLine();
		System.out.print("Campeonatos conseguidos: ");
		int achievedChampionShips = sc.nextInt();
		sc.nextLine();
		app.addEmployee(name, id, salary, expYears, leadingTeams, achievedChampionShips);
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to add a TechnicalAssistant. <br>
	* <b>pre:</b><br>
	* <b>post:</b> TechnicalAssistant has been created. <br>
	* @param name. Employee name. name != null. name != ""
	* @param id. Employee id. id != null.
	* @param salary. Employee salary. salary > 0
	*/
	public void addTechnicalAssistant(String name, int id, double salary){
		String[] expertises = new String[4];
		System.out.print("Anios de experiencia: ");
		int expYears = sc.nextInt();
		sc.nextLine();
		System.out.println("Fue un jugador profesional?");
		System.out.println("[1] Si");
		System.out.println("[cualquier otro numero] No");
		System.out.print("Opcion: ");
		int answer = readOption();
		boolean professionalPlayer;
		if(answer == 1){
			professionalPlayer = true;
		}
		else{
			professionalPlayer = false;
		}
		int i = 0;
		boolean stop = false;
		int option = 0;
		while(!stop && i < 4){
			System.out.print("OPCIONES: ");
			System.out.print("\n[1] Agregar Experticias \n[cualquier otro numero] Dejar de agregar");
			System.out.print("\nOpcion: ");
			option = sc.nextInt();
			sc.nextLine();
			if(option == 1){
				System.out.print("Experticias disponibles");
				System.out.print("\n- Ofensivo \n- Defensivo \n- Posesivo \n- Laboratorio \n");
				System.out.print("Experticia: ");
				String expertise = sc.nextLine().toUpperCase();
				if(!app.verifyExpertise(expertise)){
					System.out.println("Experticia invalida");
				}
				else{
					expertises[i] = expertise;
					++ i;
				}
			}
			else if(expertises[0] == null){
				System.out.println("Debe haber por lo menos una experticia");
			}
			else{
				stop = true;
			}
		}
		app.addEmployee(name, id, salary, expYears, professionalPlayer, expertises);
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to fire an Employee.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> Employee has been fired.<br>
	*/
	public void fireEmployee(){
		int id = chooseEmployeeId();
		app.fireEmployee(id);
		sc.nextLine();
	}
	
	/**
	* Decides the update to be executed. <br>
	* <b>pre:</b> . <br>
	* <b>post:</b> result of the option selected. <br>
	*/
	public void updateEmployeeData(){
		showUpdateOptions();
		int option = readOption();
		switch(option){
			case UPDATE_SALARY:
				updateSalary();
				break;
			case UPDATE_NUMBER:
				if(app.amountPlayers() < 1){
					System.out.println("\nDebe haber por lo menos un jugador para usar esta opcion");
					sc.nextLine();
				}
				else{
					updateNumber();
				}
				break;
			case UPDATE_GOALS:
				if(app.amountPlayers() < 1){
					System.out.println("\nDebe haber por lo menos un jugador para usar esta opcion");
					sc.nextLine();
				}
				else{
					updateGoals();
				}
				break;
			case UPDATE_AVERAGE_SCORE:
				if(app.amountPlayers() < 1){
					System.out.println("\nDebe haber por lo menos un jugador para usar esta opcion");
					sc.nextLine();
				}
				else{
					updateAvScore();
				}
				break;
			case UPDATE_POSITION:
				if(app.amountPlayers() < 1){
					System.out.println("\nDebe haber por lo menos un jugador para usar esta opcion");
					sc.nextLine();
				}
				else{
					updatePosition();
				}
				break;
			case UPDATE_EXP_YEARS:
				if(app.amountCoaches() < 1){
					System.out.println("\nDebe haber por lo menos un entrenador para usar esta opcion");
					sc.nextLine();
				}
				else{
					updateCoachExpYears();
				}
				break;
			case UPDATE_AMOUNT_CHAMPIONSHIPS:
				if(app.amountHeadCoaches() < 1){
					System.out.println("\nDebe haber por lo menos un entrenador principal para usar esta opcion");
					sc.nextLine();
				}
				else{
					updateHeadCoachChampionShips();
				}
				break;
			case UPDATE_EXPERTISES:
				if(app.amountAssistants() < 1){
					System.out.println("\nDebe haber por lo menos un tecnico asistente para usar esta opcion");
					sc.nextLine();
				}
				else{
					updateAssistantExpertises();
				}
				break;
			default:
				System.out.println("Opcion invalida");
		}
	}
	
	/**
	* updates an employee salary.<br>
	* <b>pre:</b> . <br>
	* <b>post:</b> salary has been changed. <br>
	*/
	public void updateSalary(){
		int id = chooseEmployeeId();
		System.out.print("Nuevo salario: ");
		double newSalary = sc.nextDouble();
		sc.nextLine();
		app.updateEmployeeSalary(id, newSalary);
		sc.nextLine();
	}
	
	/**
	* reads the data necessary to update the number of a player.<br>
	* <b>pre:</b> . <br>
	* <b>post:</b> number has been changed. <br>
	*/
	public void updateNumber(){
		int id = choosePlayerId();
		System.out.print("Nuevo numero: ");
		int newNumber = sc.nextInt();
		sc.nextLine();
		app.updatePlayerNumber(id, newNumber);
		sc.nextLine();
	}
	
	/**
	* reads the data necessary to update a players amount of goals.<br>
	* <b>pre:</b> . <br>
	* <b>post:</b> goals haven been changed. <br>
	*/
	public void updateGoals(){
		int id = choosePlayerId();
		System.out.print("Nueva cantidad de goles: ");
		int newGoals = sc.nextInt();
		sc.nextLine();
		app.updatePlayerGoals(id, newGoals);
		sc.nextLine();
	}
	
	/**
	* reads the data necessary to update a player average score.<br>
	* <b>pre:</b> . <br>
	* <b>post:</b> average score has been changed. <br>
	*/
	public void updateAvScore(){
		int id = choosePlayerId();
		System.out.print("Nueva calificacion promedio: ");
		int newAvScore = sc.nextInt();
		sc.nextLine();
		app.updatePlayerAvScore(id, newAvScore);
		sc.nextLine();
	}
	
	/**
	* reads the data necessary to update a player position.<br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> position has been changed. <br>
	* @param playerId. player to update. playerId is initialized
	* @param newPosition. New player position. newPosition != null. newPosition != ""
	*/
	public void updatePosition(){
		int id = choosePlayerId();
		System.out.print("Posiciones disponibles");
		System.out.print("\n- Portero \n- Defensor \n- Volante \n- Delantero \n");
		System.out.print("Nueva Posicion: ");
		String newPosition = sc.nextLine().toUpperCase();
		while(!app.verifyPosition(newPosition)){
			System.out.println("Posicion invalida");
			System.out.print("Posicion: ");
			newPosition = sc.nextLine().toUpperCase();
		}
		app.updatePlayerPosition(id, newPosition);
		sc.nextLine();
	}
	
	/**
	* reads the data necessary to update a coach experience years.<br>
	* <b>pre:</b> . <br>
	* <b>post:</b> expYears have been changed. <br>
	*/
	public void updateCoachExpYears(){
		int id = chooseCoachId();
		System.out.print("Nuevos anios de experiencia: ");
		int newExpYears = sc.nextInt();
		sc.nextLine();
		app.updateCoachExpYears(id, newExpYears);
		sc.nextLine();
	}
	
	/**
	* reads the data necessary to update a headCoach amount of achieved championships.<br>
	* <b>pre:</b> . <br>
	* <b>post:</b> championships have been changed. <br>
	*/
	public void updateHeadCoachChampionShips(){
		int id = chooseHeadCoachId();
		System.out.print("Nueva cantidad de campeonatos conseguidos: ");
		int newChampions = sc.nextInt();
		sc.nextLine();
		app.updateHeadCoachChampionShips(id, newChampions);
		sc.nextLine();
	}
	
	/**
	* reads the data necessary to update a technicalAssistant expertises.<br>
	* <b>pre:</b> . <br>
	* <b>post:</b> expertises have been updated. <br>
	*/
	public void updateAssistantExpertises(){
		int id = chooseAssistantId();
		String[] newExpertises = new String[4];
		int i = 0;
		boolean stop = false;
		int option = 0;
		while(!stop && i < 4){
			System.out.print("OPCIONES: ");
			System.out.print("\n[1] Agregar Experticias \n[cualquier otro numero] Dejar de agregar");
			System.out.print("\nOpcion: ");
			option = sc.nextInt();
			sc.nextLine();
			if(option == 1){
				System.out.print("Experticias disponibles");
				System.out.print("\n- Ofensivo \n- Defensivo \n- Posesivo \n- Laboratorio \n");
				System.out.print("Experticia: ");
				String expertise = sc.nextLine().toUpperCase();
				if(!app.verifyExpertise(expertise)){
					System.out.println("Experticia invalida");
				}
				else{
					newExpertises[i] = expertise;
					++ i;
				}
			}
			else if(newExpertises[0] == null){
				System.out.println("Debe haber por lo menos una experticia");
			}
			else{
				stop = true;
			}
		}
		app.updateAssistantExpertises(id, newExpertises);
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to add a HeadCoach to a team.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> HeadCoach has been added to a team.<br>
	*/
	public void addHeadCoachToTeam(){
		int teamIndex = chooseTeamIndex();
		int headCoachId = chooseHeadCoachId();
		app.addHeadCoachToTeam(teamIndex, headCoachId);
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to add a TechnicalAssistant to a team.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> TechnicalAssistant has been added to a team.<br>
	*/
	public void addAssistantToTeam(){
		int teamIndex = chooseTeamIndex();
		int assistantCoachId = chooseAssistantId();
		System.out.println(app.addAssistantToTeam(teamIndex, assistantCoachId));
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to add a player to a team.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> Player has been added to a team.<br>
	*/
	public void addPlayerToTeam(){
		int teamIndex = chooseTeamIndex();
		int playerId = choosePlayerId();
		System.out.println(app.addPlayerToTeam(teamIndex, playerId));
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to add an Alignment to a team.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> Alignment has been added to a team.<br>
	*/
	public void addAlignmentToTeam(){
		int teamIndex = chooseTeamIndex();
		System.out.print("Fecha: ");
		String date = sc.nextLine();
		while(app.verifyAlignmentDate(teamIndex, date)){
			System.out.println("Ya existe una tactica para esa fecha, pruebe otra fecha");
			System.out.print("Fecha: ");
			date = sc.nextLine();
		}
		System.out.print("Tacticas disponibles");
		System.out.print("\n- Posesion \n- Contraataque \n- Presionalta \n- Presionbaja \n");
		System.out.print("tactica: ");
		String tactic = sc.nextLine().toUpperCase();
		while(!app.verifyTactic(tactic)){
			System.out.println("tactica invalida");
			System.out.print("tactic: ");
			tactic = sc.nextLine().toUpperCase();
		}
		System.out.print("Alineacion separada por ( - ): ");
		String alignment = sc.nextLine();
		while(!app.verifyAlignmentAmountPlayers(alignment)){
			System.out.println("alineacion invalida");
			System.out.print("Alineacion separada por ( - ): ");
			alignment = sc.nextLine();
		}
		app.addAlignmentToTeam(teamIndex, date, tactic, alignment);
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to add a Coach to a Office.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> Coach has been added to a Office.<br>
	*/
	public void addCoachToOffice(){ 
		int coachId = chooseCoachId();
		System.out.println(app.addCoachToOffice(coachId));
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to add a Player to a dressing room.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> Player has been added to a dressing room.<br>
	*/
	public void addPlayerToDressingRoom(){
		int playerId = choosePlayerId();
		System.out.println(app.addPlayerToDressingRoom(playerId));
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to display a team info.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> info of a team.<br>
	*/
	public void showTeamInfo(){
		int teamIndex = chooseTeamIndex();
		System.out.println(app.getTeamInfo(teamIndex));
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to display a team alignment info.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> info of a team alignment.<br>
	*/
	public void showTeamAlignments(){
		int teamIndex = chooseTeamIndex();
		System.out.print(app.getTeamAlignmentsInfo(teamIndex));
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to display an Employee info.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> info of an Employee.<br>
	*/
	public void showEmployeeInfo(){
		int id = chooseEmployeeId();
		System.out.println(app.getEmployeeInfo(id));
		sc.nextLine();
	}
	
	/**
	* Decides the option to be executed. <br>
	* <b>pre:</b> option is initialized. <br>
	* <b>post:</b> result of the option previously selected. <br>
	* @param option Option selected previously on the menu. option >0. option != null.
	*/
	public void doOperation(int option){
		switch(option){
			case ADD_EMPLOYEE:
				addEmployee();
				break;
			case FIRE_EMPLOYEE:
				if(app.amountEmployees() < 1){
					System.out.println("\nDebe haber por lo menos un empleado para usar esta opcion");
					sc.nextLine();
				}
				else{
					fireEmployee();
				}
				break;
			case UPDATE_EMPLOYEE_DATA:
				if(app.amountEmployees() < 1){
					System.out.println("\nDebe haber por lo menos un empleado para usar esta opcion");
					sc.nextLine();
				}
				else{
					updateEmployeeData();
				}
				break;
			case ADD_HEADCOACH_TO_TEAM:
				if(app.amountHeadCoaches() < 1 || app.amountTeams() < 1){
					System.out.println("\nDebe haber por lo menos un entrenador principal para usar esta opcion");
					sc.nextLine();
				}
				else{
					addHeadCoachToTeam();
				}
				break;
			case ADD_ASSISTANT_TO_TEAM:
				if(app.amountAssistants() < 1 || app.amountTeams() < 1){
					System.out.println("\nDebe haber por lo menos un asistente tecnico o equipo para usar esta opcion");
					sc.nextLine();
				}
				else{
					addAssistantToTeam();
				}
				break;
			case ADD_PLAYER_TO_TEAM:
				if(app.amountPlayers() < 1 || app.amountTeams() < 1){
					System.out.println("\nDebe haber por lo menos un jugador o equipo para usar esta opcion");
					sc.nextLine();
				}
				else{
					addPlayerToTeam();
				}
				break;
			case ADD_ALIGNMENT_TO_TEAM:
				if(app.amountTeams() < 1){
					System.out.println("\nDebe haber por lo menos un equipo para usar esta opcion");
					sc.nextLine();
				}
				else{
					addAlignmentToTeam();
				}
				break;
			case ADD_COACH_TO_OFFICE:
				if(app.amountCoaches() < 1){
					System.out.println("\nDebe haber por lo menos un entrenador para usar esta opcion");
					sc.nextLine();
				}
				else{
					addCoachToOffice();
				}
				break;
			case ADD_PLAYER_TO_DRESSING_ROOM:
				if(app.amountPlayers() < 1){
					System.out.println("\nDebe haber por lo menos un jugador para usar esta opcion");
					sc.nextLine();
				}
				else{
					addPlayerToDressingRoom();
				}
				break;
			case SHOW_OFFICES:
				System.out.println("\nMostrando distribucion de las instalaciones... (X = Vacio. O = Ocupado)\n");
				System.out.println("\nMostrando distribucion de las oficinas de entrenadores...\n" + app.getOfficesInfo());
				sc.nextLine();
				break;
			case SHOW_DRESSING_ROOMS:
				System.out.println("\nMostrando distribucion de las instalaciones... (X = Vacio. O = Ocupado)\n");
				System.out.println("\nMostrando distribucion del primer vestidor (Equipo A)...\n" + app.getFirstDressingRoomInfo());
				System.out.println("\nMostrando distribucion del segundo vestidor (Equipo B)...\n" + app.getSecondDressingRoomInfo());
				sc.nextLine();
				break;
			case SHOW_TEAM_INFO:
				showTeamInfo();
				break;
			case SHOW_TEAM_ALIGNMENTS:
				showTeamAlignments();
				break;
			case SHOW_EMPLOYEE_INFO:
				showEmployeeInfo();
				break;
			case SHOW_ALL_INFO:
				System.out.println(app.getAllInfo());
				sc.nextLine();
				break;
			case EXIT:
				break;
			default:
				System.out.println("Opcion invalida");
		}
	}
	
	/**
	* Allows the user to use the class services. <br>
	* <b>pre:</b>
	* <b>post:</b> The result of the action executed. <br>
	*/
	public void startProgram(){
		int option;
		do{
			showMenu();
			option = readOption();
			doOperation(option);
		}while(option != 16);
	}
}