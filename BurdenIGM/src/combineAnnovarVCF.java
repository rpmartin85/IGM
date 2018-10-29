import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class combineAnnovarVCF {

	private static BufferedReader bRA;
	private static BufferedReader bRV;

	public static void main(String args[]) {

		if (args.length < 2) {

			try {

				//String folder = "/Users/renanmartin/1000gNewMendel/1325/";
				//String annovarFile = "1325_MendelSamples.avinput.hg19_multianno.txt";
				//String vcfFile = "1325_MendelSamplesGTOnly.vcf";

				//FileReader frA = new FileReader(folder + annovarFile);
				//FileReader frV = new FileReader(folder + vcfFile);

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

				System.out.println(lineAnnovar
						+ "\tQUAL1\tAnnovar\tchrom\tpos\tid\tref\talt\tqual2\tfilter\tinfo\tformat\tburden\t"
						+ lineVCF);

				lineVCF = bRV.readLine();

				lineAnnovar = bRA.readLine();

				int test = 0;

				while (lineVCF != null) {

					String[] annovar = lineAnnovar.split("\t");

					String[] vcf = lineVCF.split("\t");

					String tmpAnnovar = annovar[80] + annovar[81] + annovar[83] + annovar[84];

					String tmpVcf = vcf[0] + vcf[1] + vcf[3] + vcf[4];

					if (tmpAnnovar.equals(tmpVcf)) {

						System.out.println(lineAnnovar + "\t" + lineVCF);

						lineAnnovar = bRA.readLine();

						// test = test + 1;

						// System.out.println(test + " Diferente");

					}

					

						lineVCF = bRV.readLine();
				//		System.out.println(tmpAnnovar + "\t" + tmpVcf);

					

				}

			} catch (IOException e) {
				System.err.printf("File error: %s.\n", e.getMessage());
			}

		}

	}

}
