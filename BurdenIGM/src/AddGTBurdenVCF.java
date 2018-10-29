import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AddGTBurdenVCF {

	private static BufferedReader bR;

	public static void main(String args[]) {

		if (args.length == 1) {

			try {

				FileReader fr = new FileReader(args[0]);
				bR = new BufferedReader(fr);

				boolean header = false;

				int countRow = 0;

				String lineVCF = "";

				while (!header) {

					countRow = countRow + 1;

					lineVCF = bR.readLine();

					if (countRow == 8) {

						lineVCF = lineVCF + "\n##FORMAT=<ID=GT,Number=1,Type=String,Description=\"Genotype\">";

					}

					if (lineVCF.split("\t")[0].equals("#CHROM")) {

						lineVCF = lineVCF + "\tFORMAT\tBurden";

						header = true;
						
						
						if (lineVCF.split("\t")[4].charAt(0) == '<') {
							
							lineVCF = bR.readLine();
							
							
						}
						
						
						else {
							
							System.out.println(lineVCF);
							
							lineVCF = bR.readLine();
							
							
						}

					}
					
					
					System.out.println(lineVCF);

				}
				
				lineVCF = bR.readLine();
				
				while (lineVCF != null) {
					
					
					System.out.println(lineVCF + "\tGT\t0/1");
					
					lineVCF = bR.readLine();
				}

				

				

			} catch (IOException e) {
				System.err.printf("File error: %s.\n", e.getMessage());
			}

		}

		else {

			System.out.println("Enter the VCF file to include Genotype data");

		}

	}

}
