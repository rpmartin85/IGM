import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class removeDuplicates {
	
	private static BufferedReader bR;

	
	public static void main (String args[]) {
		
		try {

			FileReader fr = new FileReader(args[0]);
			
			
			
			bR = new BufferedReader(fr);
			
			String line = bR.readLine();
			
			System.out.println(line);
			
			
			
			line = bR.readLine();
			
			while(line != null) {
				
				String line2 = bR.readLine();
				
			//	System.out.println(line2);
				
				if (line2!= null && line2.equals(line)) {
					

					
				}
				
				else {
					
					System.out.println(line);
					
					line = line2;
					
				}
				
				
				
				
				
			}
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			
		}

		
		
		
		
	}
	
	
	
	

}
