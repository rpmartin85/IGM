import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class removeIndelAnnovar {

	private static BufferedReader bRA;

	public static void main(String args[]) {

		if (args.length < 2) {

			try {

	//			String folder = "/Users/renanmartin/1000gNewMendel/1325/";
	//			String annovarFile = "1325_MendelSamples.avinput.hg19_multianno.txt";

				FileReader frA = new FileReader(args[0]);

				// FileReader frA = new FileReader(args[0]);
				bRA = new BufferedReader(frA);

				// FileReader frV = new FileReader(args[1]);

				boolean header = false;

				String lineAnnovar = "";

				lineAnnovar = bRA.readLine();

				while (lineAnnovar != null) {

					String[] annovar = lineAnnovar.split("\t");

					String tmpAnnovar = annovar[0] + annovar[1] + annovar[3] + annovar[4];

					if (tmpAnnovar.contains("-")) {

						lineAnnovar = bRA.readLine();

					}

					else {

						System.out.println(lineAnnovar);

						lineAnnovar = bRA.readLine();

						// test = test + 1;

						// System.out.println(test + " Diferente");

					}

				}

			} catch (IOException e) {
				System.err.printf("File error: %s.\n", e.getMessage());
			}

		}

	}

}
