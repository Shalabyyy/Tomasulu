import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class User {

	int instbuffer=0;
	int loadresstations=0;
	int arithresstations=0;

	//Latencues
	int loadcycles=0;
	int storecycles=0;
	int addcycles=0;
	int subcycles=0;
	int mulcycles=0;
	int divcycles=0;
	int addicycles=0;
	int BRNEcycles=0;
	int BEQcycles=0;
	int JMPcycles=0;

	//Running Variables (Controlled);
	int startingaddress;
	int noOfInst;
	ArrayList<Instruction> program;
	String[] splittedProgram = new String[1000];
	InstructionStatus IS;
	Register RS;
	DataMemory memory;
	Scanner sc;
	Scanner sc2;

	//Trackers
	int current_cycle=1;
	int row_number;
	String map[][];

	public User() {
		this.RS = new Register();
		this.memory = new DataMemory();
		this.map= new String[7][25];
		map[0][0]= "Instruction";
		map[0][1]= "RS";
		map[0][2]= "RD";
		map[0][3]= "Line Number";
		map[0][4]= "WAW?";
		map[0][5]= "RAW?";
		map[0][5]= "Exec Rem";
		this.row_number = 1;
		//user = new User();
		sc = new Scanner(System.in);
		sc2 = new Scanner(System.in);
		this.program = new ArrayList<Instruction>();
		this.IS= new InstructionStatus();

	}
	public void displayMap(){
		for (int row = 0; row < map.length; row++) {
			System.out.println(
					map[row][0]+"|"+map[row][1]+"|"+
							map[row][2]+"|"+map[row][3]+"|"+
							map[row][4]+"|"+map[row][5]+"|");
		}

	}
	public String toString() {

		String s = " ";
		for (int i = 0; i < program.size(); i++) {
			s += program.get(i).toString();
		}
		return s;
	}

	public void controlUnit(String inst, String RD, String RS) {
		String rd_data = this.RS.read(RD);
		String rs_data = "";
		if (RS.charAt(0) == 'R') {
			rs_data = this.RS.read(RS);
		} else {
			System.out.println("Not a Register Operation");
			rs_data = RS;
		}

		int rs = Integer.parseInt(rs_data.trim());
		int rd = Integer.parseInt(rd_data.trim());
		int result = 0;

		if (inst.equals("ADD")) {
			result = rs + rd;
			this.RS.write(RD, result + "");
		} else if (inst.equals("SUB")) {
			result = rs - rd;
			this.RS.write(RD, result + "");
		} else if (inst.equals("MUL")) {
			result = rs * rd;
			this.RS.write(RD, result + "");
		} else if (inst.equals("DIV")) {
			result = rs / rd;
			this.RS.write(RD, result + "");
		} else if (inst.equals("ADDI")) {
			result = rs + rd;
			this.RS.write(RD, result + "");
		} else if (inst.equals("LOAD")) {
			// Assume in The Address is given as integer
			result = memory.getData(rs);
			this.RS.write(RD, result + "");

		} else if (inst.equals("STORE")) {
			memory.writeData(rs, rd);

		}

	}

	public void Tomasulo(){
		boolean done = false;
		while(!done){
			if(current_cycle==1)
				IS.issue(this.row_number, this.current_cycle);
			else{

			} 


		}
	}
	public void populateIS(){
		int counter = 0;
		for (int row = 1; row < map.length; row++) {
			if(map[row][0]!=null)
				IS.addInst(map[row][0]);
		}
		System.out.println("Instuction Status was Populates by "+counter+" Entries");

	}
	public void detectWAW(){
		System.out.println("Detecting WAW...");
		boolean waw = false;
		for (int row = 2; row < this.map.length; row++) {
			String currentRD = this.map[row][1];
			if(currentRD==null){
				break;
			}
			//System.out.println(row);
			int uprow =row-1;
			while(true){
				if(uprow==0){
					break;
				}
				if(this.map[uprow][1].equals(currentRD)){
					System.out.println("WAW Deteced: "+"this instruction has a conflict with instruction at row "+uprow);
					this.map[row][4]="TRUE";
					waw=true;
				}
				else{
					this.map[row][4]="FALSE";
				}
				uprow--;
			}
			
		}
		if(!waw){
			System.out.println("No WAWs were detected in The Program");
		}
	}
	public void detectRAW(){
		System.out.println("Detecting RAW...");
		boolean raw = false;
		for (int row = 2; row < this.map.length; row++) {
			String currentRD = this.map[row][2];
			if(currentRD==null){
				break;
			}
			//System.out.println(row);
			int uprow =row-1;
			while(true){
				if(uprow==0){
					break;
				}
				if(this.map[uprow][1].equals(currentRD)){
					System.out.println("RAW Deteced: "+"this instruction has a conflict with instruction at row "+uprow);
					this.map[row][5]="TRUE";
					raw=true;
				}
				else{
					this.map[row][5]="FALSE";
				}
				uprow--;
			}
			
		}
		if(!raw){
			System.out.println("No RAWs were detected in The Program");
		}
	}

	public static void main(String[] args) {
		User user = new User();
		System.out.println("Enter Size of Instruction Buffer:");
		user.instbuffer = user.sc.nextInt();
		// System.out.println(user.instbuffer);

		System.out.println("Enter Number of reservation stations LOAD:");
		user.loadresstations = user.sc.nextInt();
		// System.out.println(user.loadresstations);

		System.out.println("Enter Number of reservation stations ARITHMETIC:");
		user.arithresstations = user.sc.nextInt();
		// System.out.println(user.arithresstations);

		// System.out.println("Enter Number of ROB entries:");
		// user.robentries = sc.nextInt();
		// System.out.println(user.robentries);

		System.out.println("Enter Number of cycles for LOAD:");
		user.loadcycles = user.sc.nextInt();
		// System.out.println(user.loadcycles);

		System.out.println("Enter Number of cycles for STORE:");
		user.storecycles = user.sc.nextInt();
		// System.out.println(user.storecycles);

		System.out.println("Enter Number of cycles for ADD:");
		user.addcycles = user.sc.nextInt();
		// System.out.println(user.addcycles);

		System.out.println("Enter Number of cycles for SUB:");
		user.subcycles = user.sc.nextInt();
		// System.out.println(user.subcycles);

		System.out.println("Enter Number of cycles for MUL:");
		user.mulcycles = user.sc.nextInt();
		// System.out.println(user.mulcycles);

		System.out.println("Enter Number of cycles for DIV:");
		user.divcycles = user.sc.nextInt();
		// System.out.println(user.divcycles);

		System.out.println("Enter Number of cycles for ADDI:");
		user.addicycles = user.sc.nextInt();
		// System.out.println(user.addicycles);

		System.out.println("Enter Starting Address:");
		user.startingaddress = user.sc.nextInt();
		// System.out.println(user.numberofways);

		System.out.println("Enter Number Of Instructions :");
		user.noOfInst = user.sc.nextInt();

		System.out.println("Write the program :");
		for ( int i=0; i<user.noOfInst; i++){
			String input = user.sc2.nextLine();
			String [] parts = input.split(" ",3);
			String type =parts[0];
			user.map[user.row_number][0]= parts[0]; // Add The Instruction type
			user.map[user.row_number][1]= parts[1]; // Add RD
			user.map[user.row_number][2]= parts[2]; // Add RS
			user.map[user.row_number][3]= ""+user.row_number; // Add Instruction sequential number
			Instruction inst = new Instruction(type);	  // Create by Instruction name
			if(type.equals("add")){
				inst.setActualtime(user.addcycles);
				user.map[user.row_number][6]=""+user.addcycles;
			}
			else if(type.equals("sub")){
				inst.setActualtime(user.subcycles);
				user.map[user.row_number][6]=""+user.subcycles;
			}
			else if(type.equals("mul")){
				inst.setActualtime(user.mulcycles);
				user.map[user.row_number][6]=""+user.mulcycles;
			}
			else if(type.equals("div")){
				inst.setActualtime(user.divcycles);
				user.map[user.row_number][6]=""+user.divcycles;
			}
			else if(type.equals("ld")){
				inst.setActualtime(user.loadcycles);
				user.map[user.row_number][6]=""+user.loadcycles;
			}
			else if(type.equals("sw")){
				inst.setActualtime(user.storecycles);
				user.map[user.row_number][6]=""+user.storecycles;
			}
			else if(type.equals("addi")){
				inst.setActualtime(user.addicycles);
				user.map[user.row_number][6]=""+user.addicycles;
			}
			else if(type.equals("brne")){
				inst.setActualtime(user.BRNEcycles);
				user.map[user.row_number][6]=""+user.BRNEcycles;
			}
			else if(type.equals("beq")){
				inst.setActualtime(user.BEQcycles);
				user.map[user.row_number][6]=""+user.BEQcycles;
			}
			user.row_number++;
			user.program.add(inst);
			int x = user.noOfInst-i-1;
			System.out.println("You Added: "+input+" You have "+x+" Remaining");
		}
		System.out.println("All Instructions have been added!");
		System.out.println("Starting Hazard Detection");

		user.detectWAW();
		user.detectRAW();
		user.displayMap();
		user.populateIS();

	}
}
