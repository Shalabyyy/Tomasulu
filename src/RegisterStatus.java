
public class RegisterStatus {
	 String[][] RegStatus;

	public RegisterStatus() {
		this.RegStatus = new String[8][2];
		RegStatus[0][0] = "R0";
		RegStatus[0][1] = "R1";
		RegStatus[0][2] = "R2";
		RegStatus[0][3] = "R3";
		RegStatus[0][4] = "R4";
		RegStatus[0][5] = "R5";
		RegStatus[0][6] = "R6";
		RegStatus[0][7] = "R7";
	}
	public  String getValue(String register){
		if(register.equals("R0")){
			return getregR0();
		}
		else if(register.equals("R1")){
			return getregR1();
		}
		else if(register.equals("R2")){
			return getregR2();
		}
		else if(register.equals("R3")){
			return getregR3();
		}
		else if(register.equals("R4")){
			return getregR4();
		}
		else if(register.equals("R5")){
			return getregR5();
		}
		else if(register.equals("R6")){
			return getregR6();
		}
		else if(register.equals("R7")){
			return getregR7();
		}
		return null;
	}
	public void writeValue(String register, String value){
		if(register.equals("R0")){
			 setregR0(value);
		}
		else if(register.equals("R1")){
			 setregR1(value);
		}
		else if(register.equals("R2")){
			 setregR2(value);
		}
		else if(register.equals("R3")){
			 setregR3(value);
		}
		else if(register.equals("R4")){
			 setregR4(value);
		}
		else if(register.equals("R5")){
			 setregR5(value);
		}
		else if(register.equals("R6")){
			 setregR6(value);
		}
		else if(register.equals("R7")){
			 setregR7(value);
		}
		
		
	}
	
	public  String getregR0() {
		return RegStatus[1][0];
	}
	public  String getregR1() {
		return RegStatus[1][1];
	}
	public  String getregR2() {
		return RegStatus[1][2];
	}
	public  String getregR3() {
		return RegStatus[1][3];
	}
	public  String getregR4() {
		return RegStatus[1][4];
	}
	public  String getregR5() {
		return RegStatus[1][5];
	}
	public  String getregR6() {
		return RegStatus[1][6];
	}
	public  String getregR7() {
		return RegStatus[1][7];
	}
	
	public  void setregR0(String x) {
		RegStatus[1][0]=x;
	}
	public  void setregR1(String x) {
		RegStatus[1][1]=x;
	}
	public  void setregR2(String x) {
		RegStatus[1][2]=x;
	}
	public  void setregR3(String x) {
		RegStatus[1][3]=x;
	}
	public  void setregR4(String x) {
		RegStatus[1][4]=x;
	}
	public  void setregR5(String x) {
		RegStatus[1][5]=x;
	}
	public  void setregR6(String x) {
		RegStatus[1][6]=x;
	}
	public  void setregR7(String x) {
		RegStatus[1][7]=x;
	}
	
	public  void clearregR0() {
		RegStatus[1][0]= null; //Zeros?
	}
	public  void clearregR1() {
		RegStatus[1][1]=null;
	}
	public  void clearregR2() {
		RegStatus[1][2]=null;
	}
	public  void clearregR3() {
		RegStatus[1][3]=null;
	}
	public  void clearregR4() {
		RegStatus[1][4]=null;
	}
	public  void clearregR5() {
		RegStatus[1][5]=null;
	}
	public  void clearregR6() {
		RegStatus[1][6]=null;
	}
	public  void clearregR7() {
		RegStatus[1][7]=null;
	} 

}
