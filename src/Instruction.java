
public class Instruction {

	String name;
	int startcycle;
	int endcycle;
	int actualtime;
	public Instruction(String name){
		if(name.equals("add")){
			this.name="add";
		}
		if(name.equals("sub")){
			this.name="sub";
		}
		if(name.equals("mul")){
			this.name="mul";
		}
		if(name.equals("div")){
			this.name="div";
		}
		if(name.equals("ld")){
			this.name="ld";
		}
		if(name.equals("sw")){
			this.name="sw";
		}
		if(name.equals("jmp")){
			this.name="jmp";
		}
		if(name.equals("addi")){
			this.name="addi";
		}
		if(name.equals("beq")){
			this.name="beq";
		}
		if(name.equals("brne")){
			this.name="brne";
		}
		this.startcycle = -1;
		this.endcycle=-1;
		this.actualtime = -1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStartcycle() {
		return startcycle;
	}
	public void setStartcycle(int startcycle) {
		this.startcycle = startcycle;
	}
	public int getEndcycle() {
		return endcycle;
	}
	public void setEndcycle(int endcycle) {
		this.endcycle = endcycle;
	}
	public int getActualtime() {
		return actualtime;
	}
	public void setActualtime(int actualtime) {
		this.actualtime = actualtime;
	}
	
	
}
