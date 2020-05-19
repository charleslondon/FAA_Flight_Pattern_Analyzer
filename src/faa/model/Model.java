package faa.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/*
 *	This class consists of all the items needed to run the model. 
 *	It pulls in the targetFile and two arraylists (universe and galaxy)
 *	@author Charles London
 *	@author Robert J. Seedorf
 *	@author Benson Xu 
 *	@author Debra Lufadeju
 *	@author	Daniel Boehmke
 *	@author Brian Grillo
 *	@version 1.0
 *	
 */
public class Model {
	/*
	 * Thses are the three global variables.
	 * TargetFile is the file that is brought in to be seperated.
	 * universe is an arraylist that holds the data taken from the file.
	 * galaxy is an arraylist that holds the data once it is filtered from the universe.
	 */
	private File targetFile;
	private final ArrayList<SingleFlightData> universe;
	private ArrayList<SingleFlightData> galaxy;

	/*
	 *  This is the constructor that is used to make the Model.
	 *  @param none.
	 *  @return none.
	 */
	public Model() {
		universe = new ArrayList<>();
		galaxy = new ArrayList<>();
	}

	/*
	 *  This is the method that returns the universe.
	 *  @param none.
	 *  @return Arraylist of the universe.
	 */
	public ArrayList<SingleFlightData> getUniverse() {
		return universe;
	}

	/*
	 *  This is the method that returns the galaxy.
	 *  @param none.
	 *  @return Arraylist of the galaxy.
	 */
	public ArrayList<SingleFlightData> getGalaxy() {
		return galaxy;
	}

	/*
	 *  This is the method sets the file that will be used 
	 *  in the rest of the model. 
	 *  @param a file newFile.
	 *  @return none.
	 */
	public void setFile(File newFile) {	
		targetFile = newFile;

		try {
			universe.clear();
			generateUniverse();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 *  This is the method that returns the file.
	 *  @param none.
	 *  @return targetFile.
	 */
	public File getFile() {
		return targetFile;
	}

	/*
	 *  This is the method that generates the galaxy.
	 *  @return string of the galaxy.
	 */
	public String generateGalaxyString() {
		StringBuilder sb = new StringBuilder();
		String display = "AC_NUM \t \t" + "ACID \t \t" + "TRACK_CNT \t" + "ST_TIME \t \t" 
				+ "END_TIME \t \t" + "ORIG_ST_TIME \t" + "ORIG_END_TIME \t" + "MAX_X \t \t" 
				+ "MIN_X \t \t" + "MAX_Y \t \t" + "MIN_Y \t \t" + "MAX_Z \t \t" + "MIN_Z \t \t" 
				+ "AC_EQUIP \t \t" + "AC_TYPE \t \t" + "DEST_FIX \t \t" + "FLIGHT_TYPE \t" 
				+ "ORIGIN_FIX \t" + "GAP_VALUE \t" + "MAX_X_SMO \t" + "MIN_X_SMO \t"
				+ "MAX_Y_SMO \t" + "MIN_Y_SMO \t" + "MAX_Z_SMO \t" + "MIN_Z_SMO \t" 
				+ "TOD_TIME \t \t" + "TOC_TIME \t \t" + "TOC_ALT \t \t" + "END_CENTER \t" 
				+ "START_CENTER \t" + "END_CENTER_TIME \t" + "START_CENTER_TIME \t"
				+ "LOW_Z \t \t" + "HIGH_Z \t \t" + "LOW_TIME \t \t \t" + "HIGH_TIME \t \t" 
				+ "BETWEEN_TIME \t \t" + "AVG_CLIMB \t" + "LOW_GROUND_SPEED_SMO \t";
		sb.append(display);

		for (SingleFlightData singleFlightData : galaxy) {
			sb.append("\n");
			sb.append(singleFlightData.getAC_NUM()).append("\t \t");
			sb.append(singleFlightData.getACID()).append("           \t");
			sb.append(singleFlightData.getTRACK_CNT()).append("\t \t");
			sb.append(singleFlightData.getST_TIME()).append("\t \t");
			sb.append(singleFlightData.getEND_TIME()).append("\t \t");
			sb.append(singleFlightData.getORIG_ST_TIME()).append("\t \t");
			sb.append(singleFlightData.getORIG_END_TIME()).append("\t \t");
			sb.append(singleFlightData.getMAX_X()).append("\t \t");
			sb.append(singleFlightData.getMIN_X()).append("\t \t");
			sb.append(singleFlightData.getMAX_Y()).append("\t \t");
			sb.append(singleFlightData.getMIN_Y()).append("\t \t");
			sb.append(singleFlightData.getMAX_Z()).append("\t \t");
			sb.append(singleFlightData.getMIN_Z()).append("\t \t");
			sb.append(singleFlightData.getAC_EQUIP()).append("\t \t");
			sb.append(singleFlightData.getAC_TYPE()).append("\t \t");
			sb.append(singleFlightData.getDEST_FIX()).append("\t \t");
			sb.append(singleFlightData.getFLIGHT_TYPE()).append("\t \t");
			sb.append(singleFlightData.getORIGIN_FIX()).append("\t \t");
			sb.append(singleFlightData.getGAP_VALUE()).append("\t \t");
			sb.append(singleFlightData.getMAX_X_SMO()).append("\t \t");
			sb.append(singleFlightData.getMIN_X_SMO()).append("\t \t");
			sb.append(singleFlightData.getMAX_Y_SMO()).append("\t \t");
			sb.append(singleFlightData.getMIN_Y_SMO()).append("\t \t");
			sb.append(singleFlightData.getMAX_Z_SMO()).append("\t \t");
			sb.append(singleFlightData.getMIN_Z_SMO()).append("\t \t");
			sb.append(singleFlightData.getTOD_TIME()).append("\t \t");
			sb.append(singleFlightData.getTOC_TIME()).append("\t \t");
			sb.append(singleFlightData.getTOC_ALT()).append("\t \t");
			sb.append(singleFlightData.getSTART_CENTER()).append("\t \t");
			sb.append(singleFlightData.getEND_CENTER_TIME()).append("\t \t");
			sb.append(singleFlightData.getSTART_CENTER_TIME()).append("\t \t");
			sb.append(singleFlightData.getLOW_Z()).append("\t \t");
			sb.append(singleFlightData.getHIGH_Z()).append("\t \t");
			sb.append(singleFlightData.getLOW_TIME()).append("\t \t");
			sb.append(singleFlightData.getHIGH_TIME()).append("\t \t \t");
			sb.append(singleFlightData.getBETWEEN_TIME()).append("                     \t");
			sb.append(singleFlightData.getAVG_CLIMB()).append("\t \t");
			sb.append(singleFlightData.getLOW_GROUND_SPEED_SMO()).append("\t \t");
			sb.append(singleFlightData.getHIGH_GROUND_SPEED_SMO()).append("\t \t");
		}

		return sb.toString();
	}


	/*
	 *  This is the method that filters the galaxy.
	 *  @param String ACID
	 *  @param String ST_TIME
	 *  @param String END_TIME
	 *  @param String AC_EQ
	 *  @param String AC_TYPE
	 *  @param String ORIGIN_FIX
	 *  @param String START_CENTER
	 *  @param String AVG_CLIMB
	 *  @return boolean.
	 */
	public boolean filterGalaxy(String ACID, String ST_TIME, String END_TIME, String AC_EQ,
			String AC_TYPE, String ORIGIN_FIX, String START_CENTER, String AVG_CLIMB) {
		boolean hasChanged = false;

		for(int i = galaxy.size() - 1; i >= 0; i--) {
			if(!galaxy.get(i).getACID().contains(ACID)) {
				galaxy.remove(galaxy.get(i));
				hasChanged = true;
			}

			else if(!galaxy.get(i).getST_TIMEString().contains(ST_TIME)) {
				galaxy.remove(galaxy.get(i));
				hasChanged = true;
			}

			else if(!galaxy.get(i).getEND_TIMEString().contains(END_TIME)) {
				galaxy.remove(galaxy.get(i));
				hasChanged = true;
			}

			else if(!galaxy.get(i).getAC_EQUIP().contains(AC_EQ)) {
				galaxy.remove(galaxy.get(i));
				hasChanged = true;
			}

			else if(!galaxy.get(i).getAC_TYPE().contains(AC_TYPE)) {
				galaxy.remove(galaxy.get(i));
				hasChanged = true;
			}

			else if(!galaxy.get(i).getSTART_CENTER().contains(START_CENTER)) {
				galaxy.remove(galaxy.get(i));
				hasChanged = true;
			}

			else if(!galaxy.get(i).getEND_TIMEString().contains(END_TIME)) {
				galaxy.remove(galaxy.get(i));
				hasChanged = true;
			}

			else if(!galaxy.get(i).getAVG_CLIMBString().contains(AVG_CLIMB)) {
				galaxy.remove(galaxy.get(i));
				hasChanged = true;
			}
		}

		return hasChanged;
	}

	/*
	 *  This is the method writes the data.
	 *  @param file of where the data should be written.
	 *  @return none.
	 */
	public void writeData(File selectedFile) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));

		for(SingleFlightData ifd: galaxy) {
			sb.append(ifd.toString()).append("\n");
		}

		writer.write(sb.toString());
		writer.close();
	}

	/*
	 *  This is the method that generates the galaxy.
	 *  @param none
	 *  @return none
	 */
	public void generateGalaxy() {
		galaxy = new ArrayList<>(universe);
	}

	/*
	 *  This is the method that generates the universe.
	 *  @param none
	 *  @return none
	 */
	public void generateUniverse() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(targetFile));
		String temp = reader.readLine();

		while((temp = reader.readLine()) != null) {	
			SingleFlightData newFlight = new SingleFlightData();
			String[] data = temp.split(",");
			newFlight.setAC_NUM(Integer.parseInt(data[0]));
			newFlight.setACID(data[1]);
			newFlight.setTRACK_CNT(Integer.parseInt(data[2]));
			newFlight.setST_TIME(Integer.parseInt(data[3]));
			newFlight.setEND_TIME(Integer.parseInt(data[4]));
			newFlight.setORIG_ST_TIME(Integer.parseInt(data[5]));
			newFlight.setORIG_END_TIME(Integer.parseInt(data[6]));
			newFlight.setMAX_X(Double.parseDouble(data[7]));
			newFlight.setMIN_X(Double.parseDouble(data[8]));
			newFlight.setMAX_Y(Double.parseDouble(data[9]));
			newFlight.setMIN_Y(Double.parseDouble(data[10]));
			newFlight.setMAX_Z(Integer.parseInt(data[11]));
			newFlight.setMIN_Z(Integer.parseInt(data[12]));
			newFlight.setAC_EQUIP(data[13]);
			newFlight.setAC_TYPE(data[14]);
			newFlight.setDEST_FIX(data[15]);
			newFlight.setFLIGHT_TYPE(data[16]);
			newFlight.setORIGIN_FIX(data[17]);
			newFlight.setGAP_VALUE(Integer.parseInt(data[18]));
			newFlight.setMAX_X_SMO(Double.parseDouble(data[19]));
			newFlight.setMIN_X_SMO(Double.parseDouble(data[20]));
			newFlight.setMAX_Y_SMO(Double.parseDouble(data[21]));
			newFlight.setMIN_Y_SMO(Double.parseDouble(data[22]));
			newFlight.setMAX_Z_SMO(Integer.parseInt(data[23]));
			newFlight.setMIN_Z_SMO(Integer.parseInt(data[24]));
			newFlight.setTOD_TIME(Integer.parseInt(data[25]));
			newFlight.setTOC_TIME(Integer.parseInt(data[26]));
			newFlight.setTOC_ALT(Integer.parseInt(data[27]));
			newFlight.setEND_CENTER(data[28]);
			newFlight.setSTART_CENTER(data[29]);
			newFlight.setEND_CENTER_TIME(Integer.parseInt(data[30]));
			newFlight.setSTART_CENTER_TIME(Integer.parseInt(data[31]));
			newFlight.setLOW_Z(Integer.parseInt(data[32]));
			newFlight.setHIGH_Z(Integer.parseInt(data[33]));
			newFlight.setLOW_TIME(Integer.parseInt(data[34]));
			newFlight.setHIGH_TIME(Integer.parseInt(data[35]));
			newFlight.setBETWEEN_TIME(Integer.parseInt(data[36]));
			newFlight.setAVG_CLIMB(Float.parseFloat(data[37]));
			newFlight.setLOW_GROUND_SPEED_SMO(Integer.parseInt(data[38]));
			newFlight.setHIGH_GROUND_SPEED_SMO(Integer.parseInt(data[39]));

			universe.add(newFlight);
		}

		reader.close();
		generateGalaxy();
		generateGalaxyString();
	}

	/*
	 *  This is the method that returns the universe.
	 *  @param none
	 *  @return ArrayList of the universe
	 */
	public ArrayList<SingleFlightData> getuniverse() {
		return universe;
	}

	/*
	 *  This is the method that generates a map based on the plane data.
	 *  @param none
	 *  @return Map<String, Integer> based on the types of planes.
	 */
	public Map<String, Integer> GetPlanes() {
		Map<String, Integer> planes = new HashMap<>();
		Map<String, Integer> sortedMap = new HashMap<>();
		String plane = "";
		int size = galaxy.size();

		for (SingleFlightData singleFlightData : galaxy) {
			plane = singleFlightData.getAC_TYPE();

			if (planes.containsKey(plane)) {
				planes.put(plane, planes.get(plane) + 1);
			} else {
				planes.put(plane, 1);
			}
		}

		sortedMap = sortHashMap(planes);
		return sortedMap;
	}

	/*
	 *  This is the method that generates a map based on the destinations data.
	 *  @param none
	 *  @return Map<String, Integer> based on the types of destinations.
	 */
	public Map<String, Integer> GetDestinations() {
		Map<String, Integer> destinations = new HashMap<>();
		Map<String, Integer> sortedMap = new HashMap<>();
		String plane = "";
		int size = galaxy.size();

		for (SingleFlightData singleFlightData : galaxy) {
			plane = singleFlightData.getDEST_FIX();

			if (destinations.containsKey(plane)) {
				destinations.put(plane, destinations.get(plane) + 1);
			} else {
				destinations.put(plane, 1);
			}
		}

		sortedMap = sortHashMap(destinations);
		return sortedMap;
	}

	/*
	 *  This is the method that generates a map based on the flight data.
	 *  @param none
	 *  @return Map<String, Integer> based on the types of flights.
	 */
	public Map<String, Integer> GetFlights() {
		Map<String, Integer> flightTypes = new HashMap<>();
		Map<String, Integer> sortedMap = new HashMap<>();
		String plane = "";
		int size = galaxy.size();

		for (SingleFlightData singleFlightData : galaxy) {
			plane = singleFlightData.getFLIGHT_TYPE();

			if (flightTypes.containsKey(plane)) {
				flightTypes.put(plane, flightTypes.get(plane) + 1);
			} else {
				flightTypes.put(plane, 1);
			}
		}
		sortedMap = sortHashMap(flightTypes);
		return sortedMap;
	}

	/*
	 *  This is the method that generates a map based on the origns data.
	 *  @param none
	 *  @return Map<String, Integer> based on the types of origns.
	 */
	public Map<String, Integer> GetOrigins() {
		Map<String, Integer> originFix = new HashMap<>();
		Map<String, Integer> sortedMap = new HashMap<>();
		String plane = "";
		int size = galaxy.size();

		for (SingleFlightData singleFlightData : galaxy) {
			plane = singleFlightData.getORIGIN_FIX();

			if (originFix.containsKey(plane)) {
				originFix.put(plane, originFix.get(plane) + 1);
			} else {
				originFix.put(plane, 1);
			}
		}

		sortedMap = sortHashMap(originFix);
		return sortedMap;
	}

	/*
	 *  This is the method that generates a map based on the flight starts data.
	 *  @param none
	 *  @return Map<String, Integer> based on the types of flight starts.
	 */
	public Map<String, Integer> GetStarts() {
		Map<String, Integer> startCenter = new HashMap<>();
		Map<String, Integer> sortedMap = new HashMap<>();
		String plane = "";
		int size = galaxy.size();

		for (SingleFlightData singleFlightData : galaxy) {
			plane = singleFlightData.getSTART_CENTER();

			if (startCenter.containsKey(plane)) {
				startCenter.put(plane, startCenter.get(plane) + 1);
			} else {
				startCenter.put(plane, 1);
			}
		}

		sortedMap = sortHashMap(startCenter);
		return sortedMap;
	}

	/*
	 *  This is the method that sorts the data in a map based on the values.
	 *  @param unsorted Map<String, Integer>
	 *  @return sorted Map<String, Integer> based on the values.
	 */
	private static Map<String, Integer> sortHashMap(Map<String, Integer> unsortMap) {
		List<Map.Entry<String, Integer>> list =
				new LinkedList<>(unsortMap.entrySet());

		list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

		Map<String, Integer> sortedMap = new LinkedHashMap<>();

		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

}
