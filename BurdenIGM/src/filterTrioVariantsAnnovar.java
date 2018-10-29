import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class filterTrioVariantsAnnovar {

	public static boolean hetInhMut = false;
	public static boolean hetNewMut = false;
	public static boolean compHet = false;
	public static boolean samples = false;
	public static int proband;
	public static int mother;
	public static int father;
	public static boolean print = false;

	private static BufferedReader bR;

	public static void main(String args[]) {
		
	//	String [] args = {"/Users/renanmartin/Desktop/MendelSamples/TRIO/TRIO_split/split/new/BH6905_TRIO.tbl", "-i"};

		if (args.length < 2) {

			System.out.println(getMan());

			System.exit(0);

		}

		try {

			for (int i = 0; i < args.length; i++) {

				if (args[i].equals("-n")) {

					hetNewMut = true;

				}

				if (args[i].equals("-i")) {

					hetInhMut = true;

				}

				if (args[i].equals("-s")) {

					samples = true;

					String samples = args[i + 1];

					proband = Integer.parseInt(samples.split(",")[0]);
					mother = Integer.parseInt(samples.split(",")[1]);
					father = Integer.parseInt(samples.split(",")[2]);

				}

			}

			FileReader fr = new FileReader(args[0]);

			bR = new BufferedReader(fr);

			String header = bR.readLine();

			System.out.println(header);

			if (!samples) {

				String[] headerData = header.split("\t");

				for (int i = headerData.length - 3; i < headerData.length; i++) {

					switch (headerData[i].charAt(headerData[i].length()-1)) {

					case '1':
						proband = i;
						break;

					case '2':
						mother = i;
						break;

					case '3':
						father = i;
						break;

					default:
						System.out.println(getMan());
						System.exit(0);
						break;

					}

				}

			}
			
			String line = bR.readLine();
			
			while (line != null) {
				
				print = false;
				
				String genP = line.split("\t")[proband];
				String genM = line.split("\t")[mother];
				String genF = line.split("\t")[father];
				
				
				
				if (hetNewMut) {
						
						if (genP.contains("0/1") && !genM.contains("1") && !genF.contains("1")) {
							
							print = true;
							
						}
						
						

					}
				
				
				if (hetInhMut) {
					
					if (genP.contains("0/1") && (genM.contains("1") || genF.contains("1"))) {
						
						print = true;
						
					}
					
				}
				
				
				
				
				
				if (print) {
					
					System.out.println("P: " + genP + " M: " + genM + " F: " + genF);
					
				//	System.out.println(line);
					
				}
				
				
				
				
				line = bR.readLine();
				
				
				
			}
			

			

		} catch (FileNotFoundException e) {
			System.out.println(getMan());

		} catch (IOException e) {
			System.out.println(getMan());

		}

	}

	private static String getMan() {

		String man = "Usage:\tjava filterTrioVariantsAnnovar <in.annovar> <option>\n\n";

		man = man
				+ "Options:\n\t-n\tReturn heterozygous variants presented in proband's sample (_1) and not present in parents'samples (_2 and _3)\n\t-i\tReturn heterozygous variants presented in proband's sample (_1) and present in at least one parent's sample (_2 o/and _3)\n\t-s\tEnter samples' columns comma separeted (proband,mother,father). If not informed, sample names must end as follow: (_1 to proband, _2 to mother and _3 to father)\n\n\n";

		return man;
	}
}
