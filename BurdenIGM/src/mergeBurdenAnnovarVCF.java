import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class mergeBurdenAnnovarVCF {

	private static BufferedReader bRA;
	private static BufferedReader bRV;

	public static void main(String args[]) {

		if (args.length == 2) {

			try {
				
				
				
				
			//	String folder = "/Users/renanmartin/Desktop/1000G/BurdenMendel/";
			//	String annovarFile = "BurdenPhenoAnnovarTW.txt";
			//	String vcfFile = "Burden1000gGT.vcf";
				
				

				FileReader frA = new FileReader(args[0]);
				bRA = new BufferedReader(frA);

				FileReader frV = new FileReader(args[1]);
				bRV = new BufferedReader(frV);

				boolean header = false;

				String lineVCF = "";

				String lineAnnovar = "";

				while (!header) {

					lineVCF = bRV.readLine();

					if (lineVCF.split("\t")[0].equals("#CHROM")) {

						header = true;

					}

				}

				lineAnnovar = bRA.readLine();
				
				System.out.println(lineAnnovar + "\t" + lineVCF);
				
				lineVCF = bRV.readLine();

				lineAnnovar = bRA.readLine();

				while (lineVCF != null) {

					
					
					String[] annovar = lineAnnovar.split("\t");
					
					boolean print = false;
					
					if (annovar[6].equals("exonic") || annovar[6].equals("splicing")) {
						
						print = true;
						
					}
					
					
					double annovar19;
					double annovar23;
					double annovar24;
					double annovar25;
					double annovar26;
					double annovar27;
					double annovar28;
					double annovar29;
					double annovar30;
				
					
					
					if (annovar[19].equals("") || annovar[19].equals(".")) {
						
						annovar19 = 0;
						
					}
					
					else {
						
						annovar19 = Double.parseDouble(annovar[19]);
						
					}
					
					
					
					
					if (annovar[23].equals("") || annovar[23].equals(".")) {
						
						annovar23 = 0;
						
					}
					
					else {
						
						annovar23 = Double.parseDouble(annovar[23]);
						
					}
					
					if (annovar[24].equals("") || annovar[24].equals(".")) {
						
						annovar24 = 0;
						
					}
					
					else {
						
						annovar24 = Double.parseDouble(annovar[24]);
						
					}
					
					if (annovar[25].equals("") || annovar[25].equals(".")) {
						
						annovar25 = 0;
						
					}
					
					else {
						
						annovar25 = Double.parseDouble(annovar[25]);
						
					}
					
					if (annovar[26].equals("") || annovar[26].equals(".")) {
						
						annovar26 = 0;
						
					}
					
					else {
						
						annovar26 = Double.parseDouble(annovar[26]);
						
					}
					
					if (annovar[27].equals("") || annovar[27].equals(".")) {
						
						annovar27 = 0;
						
					}
					
					else {
						
						annovar27 = Double.parseDouble(annovar[27]);
						
					}
					
					if (annovar[28].equals("") || annovar[28].equals(".")) {
						
						annovar28 = 0;
						
					}
					
					else {
						
						annovar28 = Double.parseDouble(annovar[28]);
						
					}
					
					if (annovar[29].equals("") || annovar[29].equals(".")) {
						
						annovar29 = 0;
						
					}
					
					else {
						
						annovar29 = Double.parseDouble(annovar[29]);
						
					}
					
					if (annovar[30].equals("") || annovar[30].equals(".")) {
						
						annovar30 = 0;
						
					}
					
					else {
						
						annovar30 = Double.parseDouble(annovar[30]);
						
					}
					
					
					
					if (annovar19 > 0.01) {
						
						print = false;
						
					}
					
					
					if (annovar23 > 0.01) {
						
						print = false;
						
					}

					if (annovar24 > 0.01) {
						
						print = false;
						
					}
					
					if (annovar25 > 0.01) {
						
						print = false;
						
					}
					
					if (annovar26 > 0.01) {
						
						print = false;
						
					}
					
					if (annovar27 > 0.01) {
						
						print = false;
						
					}
					
					if (annovar28 > 0.01) {
						
						print = false;
						
					}
					
					if (annovar29 > 0.01) {
						
						print = false;
						
					}
					
					if (annovar30 > 0.01) {
						
						print = false;
						
					}
					
					
					
					
					if (print) {
						
						System.out.println(lineAnnovar + "\t" + lineVCF);
						
					}
					
					lineVCF = bRV.readLine();

					lineAnnovar = bRA.readLine();
					
					

				}

			} catch (IOException e) {
				System.err.printf("File error: %s.\n", e.getMessage());
			}

		}

	}

}
