import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class removeIndelVCF {

	private static BufferedReader bRV;

	public static void main(String args[]) {

		if (args.length < 2) {

			try {


				FileReader frV = new FileReader(args[0]);

			
				bRV = new BufferedReader(frV);

				boolean header = false;

				String lineVCF = "";

				while (!header) {

					lineVCF = bRV.readLine();

					if (lineVCF.split("\t")[0].equals("#CHROM")) {

						header = true;

					}
					
					System.out.println(lineVCF);


				}

				lineVCF = bRV.readLine();


				while (lineVCF != null) {

					String[] vcf = lineVCF.split("\t");
					
					if (vcf[3].length() != vcf[4].length()) {
						
						lineVCF = bRV.readLine();

						
						
					}
					
					else {
						
						System.out.println(lineVCF);
						lineVCF = bRV.readLine();

						
					}
					

					

				}

			} catch (IOException e) {
				System.err.printf("File error: %s.\n", e.getMessage());
			}

		}

	}

}
