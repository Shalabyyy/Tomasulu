public class Register {
	 final  String R0 = "0";
	 String R1;
	 String R2;
	 String R3;
	 String R4;
	 String R5;
	 String R6;
	 String R7;
	 
	 public Register(){
		 this.R1="";
		 this.R2="";
		 this.R3="";
		 this.R4="";
		 this.R5="";
		 this.R6="";
		 this.R7="";
	 }
	public String read(String register){
		 if(register.equals("R1")){
			return getR1();
		}
		else if(register.equals("R2")){
			return getR2();
		}
		else if(register.equals("R3")){
			return getR3();
		}
		else if(register.equals("R4")){
			return getR4();
		}
		else if(register.equals("R5")){
			return getR5();
		}
		else if(register.equals("R6")){
			return getR6();
		}
		else if(register.equals("R7")){
			return getR7();
		}
		return "";
		 
	}
	public void write(String register, String value){
		if(register.equals("R1")){
			 setR1(value);
		}
		else if(register.equals("R2")){
			 setR2(value);
		}
		else if(register.equals("R3")){
			 setR3(value);
		}
		else if(register.equals("R4")){
			 setR4(value);
		}
		else if(register.equals("R5")){
			 setR5(value);
		}
		else if(register.equals("R6")){
			 setR6(value);
		}
		else if(register.equals("R7")){
			 setR7(value);
		}
		
	}
	
	public  String getR0() {
		return R0;
	}

	public  String getR1() {
		return R1;
	}

	public void setR1(String r1) {
		R1 = r1;
	}

	public  String getR2() {
		return R2;
	}

	public void setR2(String r2) {
		R2 = r2;
	}

	public  String getR3() {
		return R3;
	}

	public void setR3(String r3) {
		R3 = r3;
	}

	public  String getR4() {
		return R4;
	}

	public void setR4(String r4) {
		R4 = r4;
	}

	public  String getR5() {
		return R5;
	}

	public void setR5(String r5) {
		R5 = r5;
	}

	public  String getR6() {
		return R6;
	}

	public void setR6(String r6) {
		R6 = r6;
	}

	public  String getR7() {
		return R7;
	}

	public void setR7(String r7) {
		R7 = r7;
	}

	public static void main(String[] args) {
		Register r = new Register();
		System.out.println(r.R0);
	}

}
