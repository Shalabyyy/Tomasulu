//GIVE TO SHALABYYYYY
public class ReservationStation extends User {
	static int a = 0;

	static String[][] ResStation = new String[7][100];

	public ReservationStation() {
		User user = new User();
		ResStation = new String[7][100];
		ResStation[0][0] = "Name";
		ResStation[0][1] = "Busy";
		ResStation[0][2] = "Operation";
		ResStation[0][3] = "Vj";
		ResStation[0][4] = "Vk";
		ResStation[0][5] = "Qj";
		ResStation[0][6] = "Qk";
	}
	public static void display(String[][] ResStation){
		for(int i=0;i<ResStation.length;i++){
			for(int j = 0; j <100; j++){
				System.out.println(ResStation[i][j]);
			}
		}
		System.out.println("---------------------------END---------------------------------");
	}
	public static void print2D(String mat[][]) {
		// Loop through all rows
		for (int i = 0; i < mat.length; i++)

			// Loop through all elements of current row
			for (int j = 0; j < mat[i].length; j++)
				System.out.print(mat[i][j] + " ");
		System.out.println("");
	}
	public static void addInst(String x,int resStations) {
		int counter = 0;
		boolean flag = false;
		counter = resStations;
		while (counter != 0) {
			for (int j = 0; j <=6; j++) {
				if (ResStation[0][j] == null) {
					while(resStations!=0) {
						ResStation[0][a] = x;
						resStations--;
						a++;
					}
					flag = true;
					break;
				}
				counter--;
			}
			if(flag) {
				counter=0;
			}
		}
		print2D(ResStation);
		System.out.println("All Intructions Added");
	}
}

