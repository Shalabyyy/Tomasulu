
public class DataMemory {
	 int[] memory;

	public DataMemory() {
		this.memory = new int[1000];
	}
	public int  getData(int address){
		return memory[address];
		
	}
	public void writeData(int address,int data){
		memory[address]=data;
	}

}
