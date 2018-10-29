import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class getRefSeqData {

	private static BufferedReader bR;

	public static void main(String args[]) {

		try {

			FileReader fr = new FileReader(args[0]);
			bR = new BufferedReader(fr);
			
			String header = bR.readLine();
			
			String line = "";
			
			for (int i = 0; i<10;i++) {
				
				line = line + header.split("\t")[i] + "\t";
				
			}
			
			System.out.println(line);
			
			String annovarLine = bR.readLine();
			
			while (annovarLine != null) {
				
				
				line = "";
				
				for (int i = 0; i<10;i++) {
					
					line = line + annovarLine.split("\t")[i] + "\t";
					
				}
				
				
				
				System.out.println(line);
				
				annovarLine = bR.readLine();
				
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
