import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class combineNonSynWithSyn {
	
	private static BufferedReader bRNS;
	private static BufferedReader bRS;
	
	public static void main (String args[]) {
		
		
		try {
			
			
			FileReader frNS = new FileReader(args[0]);
			bRNS = new BufferedReader(frNS);

			FileReader frS = new FileReader(args[1]);
			bRS = new BufferedReader(frS);
			
			String lineNS = bRNS.readLine();
			
			String lineS = bRS.readLine();
			
			
			System.out.println(lineNS);
			
			lineNS = bRNS.readLine();
			
			lineS = bRS.readLine();
			
			while (lineNS != null && lineS != null) {
				
				int numberNS = Integer.parseInt(lineNS.split("\t")[0]);
				int numberS = Integer.parseInt(lineS.split("\t")[0]);
				
				if (numberNS < numberS) {
					
					System.out.println(lineNS);
					
					lineNS = bRNS.readLine();
					
					
				}
				
				else {
					
					System.out.println(lineS);
					
					lineS = bRS.readLine();
					
					
				}
				
				
				
				
			}
			
			
			while (lineNS != null) {
				
				System.out.println(lineNS);
				
				lineNS = bRNS.readLine();
				
			}
			
			while (lineS != null) {
				
				System.out.println(lineS);
				
				lineS = bRS.readLine();
				
			}
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
