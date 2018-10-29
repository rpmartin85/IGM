import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class filterMutect2Strelka2 {

	private static BufferedReader bRS;
	private static BufferedReader bRM;

	public static void main(String args[]) {

		if (args.length == 2) {

			try {
				
		//		String str = "/Users/renanmartin/Desktop/OM_GERM_VS_SOMATIC/BH7691_SOMATIC_STRELKA2.vcf";
		//		String mut = "/Users/renanmartin/Desktop/OM_GERM_VS_SOMATIC/BH7691_SOMATIC_MUTECT2.vcf";
				
				String str = args[0];
				
				String mut = args[1];

				
				

				FileReader mutect_vcf = new FileReader(mut);
				
				

			
				
				
				
				
				bRM = new BufferedReader(mutect_vcf);

				boolean header = false;

				String lineVCFMutect = "";

				String lineVCFStrelka = "";
				

				while (!header) {

					lineVCFMutect = bRM.readLine();
						

					if (lineVCFMutect.split("\t")[0].equals("#CHROM")) {

						header = true;
						

					}
					
					System.out.println(lineVCFMutect);
					

				}
				
				
				
				
				lineVCFMutect = bRM.readLine();
				
				
				
				while (lineVCFMutect != null) {
					
					FileReader strelka_vcf = new FileReader(str);
					
					bRS = new BufferedReader(strelka_vcf);
					
					header = false;
					
					
					while (!header) {

						lineVCFStrelka = bRS.readLine();
						
					

						if (lineVCFStrelka.split("\t")[0].equals("1")) {

							header = true;
							
							

						}
						
						
						lineVCFStrelka = bRS.readLine();
						
						

					}
					
					String mutect = lineVCFMutect.split("\t")[0] + lineVCFMutect.split("\t")[1] + lineVCFMutect.split("\t")[3] + lineVCFMutect.split("\t")[4];
					
					while (lineVCFStrelka != null) {
						
									
						String strelka = lineVCFStrelka.split("\t")[0] + lineVCFStrelka.split("\t")[1] + lineVCFStrelka.split("\t")[3] + lineVCFStrelka.split("\t")[4];
						
						if (mutect.equals(strelka)) {
							
							if (lineVCFMutect.split("\t")[6].equals("PASS")) {
								
								System.out.println(lineVCFMutect);
								
								
								
								
							}
							
							lineVCFStrelka = null;
							
							
						}
						
						else {
							
							lineVCFStrelka = bRS.readLine();
							
						}
						
						
				
						
					}
					
				
					
					lineVCFMutect = bRM.readLine();

					
					
					
					
				}
				
	
			} catch (IOException e) {
				System.err.printf("File error: %s.\n", e.getMessage());
			}

		}

	}

}
