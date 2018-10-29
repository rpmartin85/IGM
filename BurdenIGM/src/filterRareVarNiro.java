import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class filterRareVarNiro {

	private static BufferedReader bR;
	private static double frequency = 0.01;

	public static void main(String args[]) {

		String path = "/Users/renanmartin/Desktop/bcg/ALL_BCG_FILTERED.tbl";

		try {

			FileReader fr = new FileReader(path);
			bR = new BufferedReader(fr);

			String header = bR.readLine();

			System.out.println(header);

			String annovarLine = bR.readLine();
			
			int total = 0;
			
			int rares = 0;

			while (annovarLine != null) {

				boolean rare = true;

				for (int i = 59; i < 84; i++) {

					String annovarField = annovarLine.split("\t")[i];

					if (annovarField.equals(".") || annovarField.equals("")) {

						annovarField = "0";

					}

					if (Double.parseDouble(annovarField) > frequency) {

						rare = false;
						
					//	rares = rares + 1;
						
				//		System.out.println(annovarField);

					}

				}
				
				total = total + 1;
				
				
				
			//	System.out.println(rares + " " + rare);

				if (rare) {
					
					rares = rares +1;

				//	System.out.println(annovarLine);
					
					System.out.println(rares + "_" + total + " " + annovarLine);

				}

				annovarLine = bR.readLine();

			}

		} catch (

		FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(getMan());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(getMan());
		}

	}

	private static String getMan() {

		String man = "Usage:\tjava filterRareVariantsAnnovar <in.annovar> [options]\n\n";

		man = man
				+ "Options:\n\t-f\tset frequency (0.01 standard)\n\t-g\tlist of target genes (comma separated / all genes standard)\n\t-S\tlist of samples to be included (comma separated / all samples standard)\n\t-s\tlist of samples to be excluded (comma separated / all samples standard)\n\n\n";

		return man;
	}

}
