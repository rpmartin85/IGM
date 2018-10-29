import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class filterRareVariantsAnnovar {

	private static BufferedReader bR;
	private static double frequency = 0.01;
	private static String geneList[];
	private static String ignoreSampleList[];
	private static String includeSampleList[];
	private static boolean print = false;

	private static boolean gene = false;
	private static boolean sampleIg = false;
	private static boolean sampleInc = false;

	private static boolean[] samplesInclude;
	private static int numOfSamples = 0;

	public static void main(String args[]) {

		if (args.length == 0) {

			System.out.println(getMan());

			System.exit(0);

		}

		try {

			FileReader fr = new FileReader(args[0]);
			bR = new BufferedReader(fr);

			if (args.length > 1) {

				for (int i = 0; i < args.length; i++) {

					if (args[i].equals("-f")) {

						frequency = Double.parseDouble(args[i + 1]);

					}

					if (args[i].equals("-g")) {

						gene = true;

						geneList = args[i + 1].split(",");

					}

					if (args[i].equals("-s")) {

						sampleIg = true;

						ignoreSampleList = args[i + 1].split(",");

					}
					
					if (args[i].equals("-S")) {

						sampleInc = true;

						includeSampleList = args[i + 1].split(",");

					}
					
					
					
					

				}

			}

			String header = bR.readLine();

			if (gene) {

				if (geneList.length == 1) {

					for (int i = 0; i < 7; i++) {

						String line = "";

						for (int j = 0; j < 95; j++) {

							line = line + "\t";

						}

						switch (i) {

						case 0:
							line = line + "\t\t\tSUM";
							break;

						case 1:
							line = line +"\t\t\t./.";
							break;

						case 2:
							line = line +"\t\t\t0/0";
							break;

						case 3:
							line = line +"\t\t\t0/1";
							break;

						case 4:
							line = line +"\tTOTAL\t0/1 | 1/1\t1/1";
							break;

						case 5:
							line = line + geneList[0] + "\t\t\t0/1 | 1/1";
							break;

						case 6:
							break;

						}

						System.out.println(line);

					}

				}

			}

			if (sampleIg) {

				String[] samples = new String[header.split("\t").length - 99];
				numOfSamples = samples.length;
				samplesInclude = new boolean[numOfSamples];
				String tmpHeader = "";

				for (int i = 0; i < 99; i++) {

					tmpHeader = tmpHeader + header.split("\t")[i] + "\t";

				}

				for (int i = 99; i < header.split("\t").length; i++) {

					samples[i - 99] = header.split("\t")[i];

					samplesInclude[i - 99] = true;

					for (int j = 0; j < ignoreSampleList.length; j++) {

						if (samples[i - 99].equals(ignoreSampleList[j])) {

							samplesInclude[i - 99] = false;

						}

					}

					if (samplesInclude[i - 99]) {

						tmpHeader = tmpHeader + samples[i - 99] + "\t";

					}

				}

				header = tmpHeader;

			}
			
			
			if (sampleInc) {

				String[] samples = new String[header.split("\t").length - 99];
				numOfSamples = samples.length;
				samplesInclude = new boolean[numOfSamples];
				String tmpHeader = "";

				for (int i = 0; i < 99; i++) {

					tmpHeader = tmpHeader + header.split("\t")[i] + "\t";

				}

				for (int i = 99; i < header.split("\t").length; i++) {

					samples[i - 99] = header.split("\t")[i];

					samplesInclude[i - 99] = false;

					for (int j = 0; j < includeSampleList.length; j++) {

						if (samples[i - 99].equals(includeSampleList[j])) {

							samplesInclude[i - 99] = true;

						}

					}

					if (samplesInclude[i - 99]) {

						tmpHeader = tmpHeader + samples[i - 99] + "\t";

					}

				}

				header = tmpHeader;

			}
			
			
			
			
			

			System.out.println(header);

			String annovarLine = bR.readLine();

			while (annovarLine != null) {

				boolean SNV = true;

				boolean rare = true;

				boolean refSeq = false;

				if (annovarLine.split("\t")[3].equals("-") || annovarLine.split("\t")[4].equals("-")) {

					SNV = false;

				}

				if (SNV) {

					String func_refGene = annovarLine.split("\t")[5];

					if (func_refGene.equals("exonic") || func_refGene.equals("splicing")
							|| func_refGene.equals("exonic;splicing")) {

						if (func_refGene.equals("exonic") && annovarLine.split("\t")[8].equals("synonymous SNV")) {

							refSeq = false;

						}

						else {

							if (gene) {

								for (int i = 0; i < geneList.length; i++) {

									if (annovarLine.split("\t")[6].contains(",")) {

										String[] genesTmp = annovarLine.split("\t")[6].split(",");

										for (int j = 0; j < genesTmp.length; j++) {

											if (genesTmp[j].equals(geneList[i])) {

												refSeq = true;

											}

										}

									}

									else if (annovarLine.split("\t")[6].equals(geneList[i])) {

										refSeq = true;

									}

								}

							}

							else {

								refSeq = true;

							}

						}

					}

					if (refSeq) {

						for (int i = 45; i < 77; i++) {

							String annovarField = annovarLine.split("\t")[i];

							if (annovarField.equals(".") || annovarField.equals("")) {

								annovarField = "0";

							}

							if (Double.parseDouble(annovarField) > frequency) {

								rare = false;

							}

						}

						if (rare) {

							String annovarLineNew = "";

							if (sampleIg || sampleInc) {

								for (int i = 0; i < 99; i++) {

									annovarLineNew = annovarLineNew + annovarLine.split("\t")[i] + "\t";

								}

								String[] data = new String[numOfSamples];

								for (int i = 99; i < annovarLine.split("\t").length; i++) {

									data[i - 99] = annovarLine.split("\t")[i];

								}

								for (int i = 0; i < data.length; i++) {

									if (samplesInclude[i]) {									

										annovarLineNew = annovarLineNew + data[i] + "\t";

									}

								}

							}

							else {

								annovarLineNew = annovarLine;

							}
							
							
							String [] data = annovarLineNew.split("\t");
							
							
							
							for (int i = 99; i < data.length; i++) {
								
								if (data[i].contains("1")) {
									
									System.out.println(annovarLineNew);
									
								
									
								}
	

							}
							
							
							
							
						//	if (print) {
								
							//	System.out.println(annovarLineNew);
								
					//		}
							
							

						}

					}

				}

				annovarLine = bR.readLine();

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(getMan());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(getMan());
		}

	}

	private static String getMan() {

		String man = "Usage:\tjava filterRareVariantsAnnovar <in.annovar> [options]\n\n";

		man = man + "Options:\n\t-f\tset frequency (0.01 standard)\n\t-g\tlist of target genes (comma separated / all genes standard)\n\t-S\tlist of samples to be included (comma separated / all samples standard)\n\t-s\tlist of samples to be excluded (comma separated / all samples standard)\n\n\n";

		return man;
	}

}
