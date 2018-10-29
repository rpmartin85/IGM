package logical;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import logical.ExcelFileFilter;

/**
 * Sample Java program to read and write Excel file in Java using Apache POI
 *
 */
public class Highlight {

	private static CellStyle RED;
	private static CellStyle GREEN;

	private static int ExAC03_EAS;
	private static int ExAC03_FIN;
	private static int ExAC03_NFE;
	private static int ExAC03_OTH;
	private static int ExAC03_SAS;

	private static int ExAC03_Global;
	private static int ExAC03_AFR;
	private static int ExAC03_AMR;

	private static int WG_GWAVA_score;
	private static int WG_EIGEN_score;
	private static int revel_score;
	private static int Kaviar_AF;
	private static int fathmm_score;
	private static int gnomAD_exome_freq;
	private static int gnomAD_genome_freq;
	private static int VEST_Score;
	private static int ExAC_r03_pLI;
	private static int ExAC_r03_mis_z;
	private static int Gerp_gt2;
	private static int mirna;
	private static int segdup;
	private static int tfbsConsSites;
	private static int SiftScore;
	private static int Score_Ljb_lrt;
	private static int Score_Ljb_mt;
	private static int Score_Ljb_phylop;
	private static int Score_Ljb_pp2hdiv;
	private static int Score_Ljb_pp2hvar;
	private static int Score_Ljb_gerp;
	private static int CCDSIntolerancePercentile;
	private static int CADDScore;
	private static int TraP;

	public static void doIt(String dir) {
		try {

			FileFilter filter = new ExcelFileFilter();
			File directory = new File(dir);
			
			
			
			
			File[] files = directory.listFiles(filter);
			for (File file : files) {

				FileInputStream fis = new FileInputStream(file);
				XSSFWorkbook book = new XSSFWorkbook(fis);
				XSSFSheet sheet = book.getSheetAt(0);
				Iterator<Row> itr = sheet.iterator();

				RED = book.createCellStyle();
				RED.setFillForegroundColor(IndexedColors.ROSE.getIndex());
				RED.setFillPattern(FillPatternType.SOLID_FOREGROUND);

				GREEN = book.createCellStyle();
				GREEN.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
				GREEN.setFillPattern(FillPatternType.SOLID_FOREGROUND);

				// Iterating over Excel file in Java

				int rows = 1;

				int cols = 0;

				// initialize all variables

				ExAC03_EAS = 0;
				ExAC03_FIN = 0;
				ExAC03_NFE = 0;
				ExAC03_OTH = 0;
				ExAC03_SAS = 0;
				ExAC03_Global = 0;
				ExAC03_AFR = 0;
				ExAC03_AMR = 0;
				WG_GWAVA_score = 0;
				WG_EIGEN_score = 0;
				revel_score = 0;
				Kaviar_AF = 0;
				fathmm_score = 0;
				gnomAD_exome_freq = 0;
				gnomAD_genome_freq = 0;
				VEST_Score = 0;
				ExAC_r03_pLI = 0;
				ExAC_r03_mis_z = 0;
				Gerp_gt2 = 0;
				mirna = 0;
				segdup = 0;
				tfbsConsSites = 0;
				SiftScore = 0;
				Score_Ljb_lrt = 0;
				Score_Ljb_mt = 0;
				Score_Ljb_phylop = 0;
				Score_Ljb_pp2hdiv = 0;
				Score_Ljb_pp2hvar = 0;
				Score_Ljb_gerp = 0;
				CCDSIntolerancePercentile = 0;
				CADDScore = 0;
				TraP = 0;

				Cell cell;

				Row row = itr.next();
				// Iterating over each column of Excel file
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {

					cell = cellIterator.next();

					cols = cols + 1;
					
					System.out.println(cell.getRowIndex() + " " + cell.getColumnIndex() + " " + cell.getStringCellValue());

					if (cell.getCellType() != Cell.CELL_TYPE_NUMERIC) {

						switch (cell.getStringCellValue()) {

						case "ExAC02_Global":
							ExAC03_Global = cell.getColumnIndex();
							break;

						case "ExAC02_AFR":
							ExAC03_AFR = cell.getColumnIndex();
							break;

						case "ExAC02_AMR":
							ExAC03_AMR = cell.getColumnIndex();
							break;

						case "ExAC03_Global":
							ExAC03_Global = cell.getColumnIndex();
							break;

						case "ExAC03_AFR":
							ExAC03_AFR = cell.getColumnIndex();
							break;

						case "ExAC03_AMR":
							ExAC03_AMR = cell.getColumnIndex();
							break;

						case "ExAC02_EAS":
							ExAC03_EAS = cell.getColumnIndex();
							break;

						case "ExAC02_FIN":
							ExAC03_FIN = cell.getColumnIndex();
							break;

						case "ExAC02_NFE":
							ExAC03_NFE = cell.getColumnIndex();
							break;

						case "ExAC02_OTH":
							ExAC03_OTH = cell.getColumnIndex();
							break;

						case "ExAC02_SAS":
							ExAC03_SAS = cell.getColumnIndex();
							break;

						case "ExAC03_EAS":
							ExAC03_EAS = cell.getColumnIndex();
							break;

						case "ExAC03_FIN":
							ExAC03_FIN = cell.getColumnIndex();
							break;

						case "ExAC03_NFE":
							ExAC03_NFE = cell.getColumnIndex();
							break;
						case "ExAC03_OTH":
							ExAC03_OTH = cell.getColumnIndex();
							break;

						case "ExAC03_SAS":
							ExAC03_SAS = cell.getColumnIndex();
							break;

						case "WG_GWAVA_score":
							WG_GWAVA_score = cell.getColumnIndex();
							break;

						case "WG_EIGEN_score":
							WG_EIGEN_score = cell.getColumnIndex();
							break;

						case "revel_score":
							revel_score = cell.getColumnIndex();
							break;

						case "Kaviar_AF":
							Kaviar_AF = cell.getColumnIndex();
							break;
						case "fathmm_score":
							fathmm_score = cell.getColumnIndex();
							break;

						case "gnomAD_exome_freq":
							gnomAD_exome_freq = cell.getColumnIndex();
							break;

						case "gnomAD_genome_freq":
							gnomAD_genome_freq = cell.getColumnIndex();
							break;

						case "VEST_Score":
							VEST_Score = cell.getColumnIndex();
							break;

						case "ExAC_r03_pLI":
							ExAC_r03_pLI = cell.getColumnIndex();
							break;

						case "ExAC_r03_mis_z":
							ExAC_r03_mis_z = cell.getColumnIndex();
							break;

						case "Gerp++gt2":
							Gerp_gt2 = cell.getColumnIndex();
							break;

						case "mirna":
							mirna = cell.getColumnIndex();
							break;

						case "segdup":
							segdup = cell.getColumnIndex();
							break;

						case "tfbsConsSites":
							tfbsConsSites = cell.getColumnIndex();
							break;

						case "SiftScore":
							SiftScore = cell.getColumnIndex();
							break;

						case "Score_Ljb_lrt":
							Score_Ljb_lrt = cell.getColumnIndex();
							break;

						case "Score_Ljb_mt":
							Score_Ljb_mt = cell.getColumnIndex();
							break;

						case "Score_Ljb_phylop":
							Score_Ljb_phylop = cell.getColumnIndex();
							break;

						case "Score_Ljb_pp2hdiv":
							Score_Ljb_pp2hdiv = cell.getColumnIndex();
							break;

						case "Score_Ljb_pp2hvar":
							Score_Ljb_pp2hvar = cell.getColumnIndex();
							break;

						case "Score_Ljb_gerp++":
							Score_Ljb_gerp = cell.getColumnIndex();
							break;

						case "CCDS Intolerance Percentile":
							CCDSIntolerancePercentile = cell.getColumnIndex();
							break;

						case "CADD Score":
							CADDScore = cell.getColumnIndex();
							break;

						case "TraP":
							TraP = cell.getColumnIndex();
							break;

						default:

						}

					}

				}

				while (itr.hasNext()) {

					row = itr.next();

					rows = rows + 1;

					cols = 0;

					cellIterator = row.cellIterator();

					while (cellIterator.hasNext()) {

						cell = cellIterator.next();

						cols = cols + 1;

						System.out.println(cell.getRowIndex() + "_" + cell.getColumnIndex() + "_" + cell.getAddress());
						
						

						String tmp = "";

						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {

							tmp = cell.getStringCellValue();

						}

						/*
						 * 
						 * Determine the range of each score to be highlighted
						 * 
						 * 
						 */

						// range for Gerp_gtp score
						if (Gerp_gt2 > 0 && cell.getColumnIndex() == Gerp_gt2) {

							if (!tmp.equals("")) {

						//		System.out.println(rows + " " + cols);

								cell.setCellStyle(GREEN);

							}

						}

						// range for segdup score
						if (segdup > 0 && cell.getColumnIndex() == segdup) {

							if (!tmp.equals("")) {

								cell.setCellStyle(GREEN);

							}

						}

						if (tmp.equals("")) {

							tmp = tmp + 0;

						}

						if (tmp.equals(".")) {

							tmp = "" + 0;

						}

						if (tmp.length() > 10) {

							tmp = "" + 0;

						}

						// range for ExAC03_Global score
						if (ExAC03_Global > 0 && cell.getColumnIndex() == ExAC03_Global) {
							if (Double.parseDouble(tmp) > 0.01) {
								cell.setCellStyle(RED);
							}
						}

						// range for ExAC03_AMR score
						if (ExAC03_AMR > 0 && cell.getColumnIndex() == ExAC03_AMR) {
							if (Double.parseDouble(tmp) > 0.01) {
								cell.setCellStyle(RED);
							}
						}

						// range for ExAC03_AFR score
						if (ExAC03_AFR > 0 && cell.getColumnIndex() == ExAC03_AFR) {
							if (Double.parseDouble(tmp) > 0.01) {
								cell.setCellStyle(RED);
							}
						}

						// range for ExAC03_EAS score
						if (ExAC03_EAS > 0 && cell.getColumnIndex() == ExAC03_EAS) {

							// System.out.println(cell.getAddress());

							if (Double.parseDouble(tmp) > 0.01) {
								cell.setCellStyle(RED);
							}
						}

						// range for ExAC03_FIN score
						if (ExAC03_FIN > 0 && cell.getColumnIndex() == ExAC03_FIN) {
							if (Double.parseDouble(tmp) > 0.01) {
								cell.setCellStyle(RED);
							}
						}

						// range for ExAC03_NFE score
						if (ExAC03_NFE > 0 && cell.getColumnIndex() == ExAC03_NFE) {
							if (Double.parseDouble(tmp) > 0.01) {
								cell.setCellStyle(RED);
							}
						}

						// range for ExAC03_OTH score
						if (ExAC03_OTH > 0 && cell.getColumnIndex() == ExAC03_OTH) {
							if (Double.parseDouble(tmp) > 0.01) {
								cell.setCellStyle(RED);
							}
						}

						// range for ExAC03_SAS score
						if (ExAC03_SAS > 0 && cell.getColumnIndex() == ExAC03_SAS) {
							if (Double.parseDouble(tmp) > 0.01) {
								cell.setCellStyle(RED);
							}
						}

						// range for WG_GWAVA_score score
						if (WG_GWAVA_score > 0 && cell.getColumnIndex() == WG_GWAVA_score) {
							if (Double.parseDouble(tmp) > 0.5) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for WG_EIGEN_score score
						if (WG_EIGEN_score > 0 && cell.getColumnIndex() == WG_EIGEN_score) {
							if (Double.parseDouble(tmp) > 0.5) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for revel_score score
						if (revel_score > 0 && cell.getColumnIndex() == revel_score) {
							if (Double.parseDouble(tmp) > 0.5) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for Kaviar_AF score
						if (Kaviar_AF > 0 && cell.getColumnIndex() == Kaviar_AF) {
							if (Double.parseDouble(tmp) > 0.01) {
								cell.setCellStyle(RED);
							}
						}

						// range for fathmm_score score
						if (fathmm_score > 0 && cell.getColumnIndex() == fathmm_score) {
							if (Double.parseDouble(tmp) > 0.5) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for gnomAD_exome_freq score
						if (gnomAD_exome_freq > 0 && cell.getColumnIndex() == gnomAD_exome_freq) {
							if (Double.parseDouble(tmp) > 0.01) {
								cell.setCellStyle(RED);
							}
						}

						// range for gnomAD_genome_freq score
						if (gnomAD_genome_freq > 0 && cell.getColumnIndex() == gnomAD_genome_freq) {
							if (Double.parseDouble(tmp) > 0.01) {
								cell.setCellStyle(RED);
							}
						}

						// range for VEST_Score score
						if (VEST_Score > 0 && cell.getColumnIndex() == VEST_Score) {
							if (Double.parseDouble(tmp) > 0.5) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for ExAC_r03_pLI score
						if (ExAC_r03_pLI > 0 && cell.getColumnIndex() == ExAC_r03_pLI) {

							String tmp2 = cell.getStringCellValue();

							if (tmp2.equals("")) {

								tmp2 = "Name=" + 0;

							}

							int stop = tmp2.length();

							if (tmp2.contains(",")) {

								stop = tmp2.indexOf(",");

							}
							
							

							tmp = tmp2.substring(5, stop);

							if (Double.parseDouble(tmp) > 0.95) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for ExAC_r03_mis_z score
						if (ExAC_r03_mis_z > 0 && cell.getColumnIndex() == ExAC_r03_mis_z) {

							String tmp2 = cell.getStringCellValue();

							if (tmp2.equals("")) {

								tmp2 = "Name=" + 0;

							}

							int stop = tmp2.length();

							if (tmp2.contains(",")) {

								stop = tmp2.indexOf(",");

							}

							tmp = tmp2.substring(5, stop);

							if (Double.parseDouble(tmp) < -2) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for SiftScore score
						if (SiftScore > 0 && cell.getColumnIndex() == SiftScore) {
							if (Double.parseDouble(tmp) < 0.5) {
								if (!cell.getStringCellValue().equals(""))
									cell.setCellStyle(GREEN);
							}
						}

						// range for Score_Ljb_lrt score
						if (Score_Ljb_lrt > 0 && cell.getColumnIndex() == Score_Ljb_lrt) {
							if (Double.parseDouble(tmp) > 0.5) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for Score_Ljb_mt score
						if (Score_Ljb_mt > 0 && cell.getColumnIndex() == Score_Ljb_mt) {
							if (Double.parseDouble(tmp) > 0.8) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for Score_Ljb_phylop score
						if (Score_Ljb_phylop > 0 && cell.getColumnIndex() == Score_Ljb_phylop) {
							if (Double.parseDouble(tmp) > 0.5) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for Score_Ljb_pp2hdiv score
						if (Score_Ljb_pp2hdiv > 0 && cell.getColumnIndex() == Score_Ljb_pp2hdiv) {
							if (Double.parseDouble(tmp) > 0.85) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for Score_Ljb_pp2hvar score
						if (Score_Ljb_pp2hvar > 0 && cell.getColumnIndex() == Score_Ljb_pp2hvar) {
							if (Double.parseDouble(tmp) > 0.85) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for Score_Ljb_gerp score
						if (Score_Ljb_gerp > 0 && cell.getColumnIndex() == Score_Ljb_gerp) {
							if (Double.parseDouble(tmp) > 2) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for CADDScore score
						if (CADDScore > 0 && cell.getColumnIndex() == CADDScore) {

							if (tmp.contains(",")) {

								tmp = tmp.substring(0, tmp.indexOf(",") - 1);

							}

							if (Double.parseDouble(tmp) >= 20) {
								cell.setCellStyle(GREEN);
							}
						}

						// range for TraP score
						if (TraP > 0 && cell.getColumnIndex() == TraP) {

							if (tmp.length() > 5) {

								tmp = 0 + "";

							}

							if (Double.parseDouble(tmp) > 0.93) {
								cell.setCellStyle(GREEN);
							}
						}

						/*
						 * 
						 * End of the section to highlight each score
						 * 
						 * 
						 */

					}

				}
				
				/*

				System.out.println("Rows: " + rows + " Cols: " + cols);

				System.out.println(" ExAC03_EAS: " + ExAC03_EAS + " ExAC03_FIN: " + ExAC03_FIN + " ExAC03_NFE: "
						+ ExAC03_NFE + " ExAC03_OTH: " + ExAC03_OTH + " ExAC03_SAS: " + ExAC03_SAS + " WG_GWAVA_score: "
						+ WG_GWAVA_score + " WG_EIGEN_score: " + WG_EIGEN_score + " revel_score: " + revel_score
						+ " Kaviar_AF: " + Kaviar_AF + " fathmm_score: " + fathmm_score + " gnomAD_exome_freq: "
						+ gnomAD_exome_freq + " gnomAD_genome_freq: " + gnomAD_genome_freq + " VEST_Score: "
						+ VEST_Score + " ExAC_r03_pLI: " + ExAC_r03_pLI + " ExAC_r03_mis_z: " + ExAC_r03_mis_z
						+ " Gerp_gt2: " + Gerp_gt2 + " mirna: " + mirna + " segdup: " + segdup + " tfbsConsSites: "
						+ tfbsConsSites + " SiftScore: " + SiftScore + " Score_Ljb_lrt: " + Score_Ljb_lrt
						+ " Score_Ljb_mt: " + Score_Ljb_mt + " Score_Ljb_phylop: " + Score_Ljb_phylop
						+ " Score_Ljb_pp2hdiv: " + Score_Ljb_pp2hdiv + " Score_Ljb_pp2hvar: " + Score_Ljb_pp2hvar
						+ " Score_Ljb_gerp: " + Score_Ljb_gerp + " CCDSIntolerancePercentile: "
						+ CCDSIntolerancePercentile + " CADDScore: " + CADDScore + " TraP: " + TraP);

				/*
				 * 
				 * 
				 * 
				 * 
				 * System.out.println(rows);
				 * 
				 * 
				 * 
				 * Row row = itr.next(); // Iterating over each column of Excel file
				 * Iterator<Cell> cellIterator = row.cellIterator(); while
				 * (cellIterator.hasNext()) { Cell cell = cellIterator.next(); switch
				 * (cell.getCellType()) { case Cell.CELL_TYPE_STRING:
				 * System.out.print(cell.getStringCellValue() + "\t"); break; case
				 * Cell.CELL_TYPE_NUMERIC: System.out.print(cell.getNumericCellValue() + "\t");
				 * if (cell.getNumericCellValue() > 3) {
				 * 
				 * // cell.setAsActiveCell();
				 * 
				 * // cell.setCellValue(10.0);
				 * 
				 * 
				 * cell.setCellStyle(RED);
				 * 
				 * }
				 * 
				 * else {
				 * 
				 * cell.setCellStyle(GREEN);
				 * 
				 * 
				 * }
				 * 
				 * 
				 * break; case Cell.CELL_TYPE_BOOLEAN:
				 * System.out.print(cell.getBooleanCellValue() + "\t"); break; default: } }
				 * System.out.println(""); }
				 * 
				 */

				// open an OutputStream to save written data into Excel file
				FileOutputStream os = new FileOutputStream(file);
				book.write(os);
				System.out.println("Writing on Excel file Finished ...");
				// Close workbook, OutputStream and Excel file to prevent leak
				os.close();
				book.close();
				fis.close();
			}
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
	}
}