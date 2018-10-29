import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class geneNameAnnovar {

	private static BufferedReader bRA;

	public static void main(String args[]) {

		if (args.length < 2) {

			try {

				String folder = "/Users/renanmartin/1000gNewMendel/1325/";
				String annovarFile = "1325_MendelSamplesAnnovarVCF_001BurdenGenesNew.tbi";

				FileReader frA = new FileReader(folder + annovarFile);

				bRA = new BufferedReader(frA);



				String lineAnnovar = "";

				lineAnnovar = bRA.readLine();
				
				String [] genes5 = {"","","","",""};
				

				while (lineAnnovar != null) {

					String[] annovar = lineAnnovar.split("\t");
					
					if (annovar[5].equals("exonic")) {
						
						boolean flag = false;
						
						for (int i =0;i<genes5.length;i++) {
							
							if (annovar[6].equals(genes5[i])){
								
								flag = true;
								
							}
							
						}
							
							if (!flag) {
								
								System.out.println(annovar[6]);
								
								genes5[4] = genes5[3];
								genes5[3] = genes5[2];
								genes5[2] = genes5[1];
								genes5[1] = genes5[0];
								genes5[0] = annovar[6];
								
								
							}
							
						
						
						
						
						
						
					}
					
					lineAnnovar = bRA.readLine();
					

				}

			} catch (IOException e) {
				System.err.printf("File error: %s.\n", e.getMessage());
			}

		}

	}

}
