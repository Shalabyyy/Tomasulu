
public class InstructionStatus {

	 String[][] instStatus;
	 int instruction_number;

	public InstructionStatus() {
		this.instStatus = new String[50][4];
		this.instStatus[0][0] = "Instructions";
		this.instStatus[0][1] = "Issue";
		this.instStatus[0][2] = "Execute";
		this.instStatus[0][3] = "Write";
		this.instruction_number=1; //this one will always be the same as the one in User class
	}

	public  void addInst(String inst) {
		inst = inst+instruction_number;
		instStatus[instruction_number][0] = inst;
		instStatus[instruction_number][1] = "NULL";
		instStatus[instruction_number][2] = "NULL";
		instStatus[instruction_number][3] = "NULL";
		instruction_number++;
	}
	public boolean issue(int row_from_user, int current_cycle){ 
		//(user.rowofinst that wants to be issued, user.currentCycle)
		
		String current = this.instStatus[row_from_user][0];
		current=current.substring(0, current.length() - 1);		//remove instruction number to check in RS
		
		boolean can_issue = false;
		//TODO Check if we can Issue In Reservation Station, If it can issue set flag to true

		if(can_issue){
			instStatus[row_from_user][1] = "C"+current_cycle;
			return true;							//Instruction was Issued
		}
		else{
			return false;							//Instruction was not Issued
		}	
	}
	public  boolean addInstIssue(String inst, int cycles) {
		boolean flag = false;
		for (int j = 0; j < instStatus[0].length; j++) {
			if (flag == true)
				break;
			if (instStatus[j][1] == null) {
				instStatus[j][1] = inst;
				flag = true;
				return true;
			}
			// Check reservation station
		}
		return false;
	}

	public  boolean addInstExecute(String x,int current_cycle,int cycles_rem ) {
		for (int j = 0; j < instStatus[0].length; j++) {

			if (instStatus[j][1] != null) {// check if issued
				instStatus[j][2] = x;
				return true;
			}
			// check raw hazard
		}
		return false;
	}
	public  boolean addInstWrite(String x) {
		for (int j = 0; j < instStatus[0].length; j++) {

			if (instStatus[j][2] != null) {// check if executed
				instStatus[j][3] = x;
				return true;
			}
			// check if another is writing 
		}
		return false;
	}

	public static void main(String[] args) {
		InstructionStatus k = new InstructionStatus();
		k.addInst("r");
		for (int i = 0; i < k.instStatus.length; i++) {
			for (int j = 0; j < k.instStatus[0].length; j++) {
				System.out.println(k.instStatus[i][j]);
			}
		}
	}
}
