package faa.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;


/**
 * Driver class to construct csv files for
 * the data mining team
 * 
 * @Author Benson Xu
 *
 */
public class SQLDriver {

	/**
	 * This method requires an scenario string to be entered,
	 * connects to the database, and creates a csv file locally
	 * @param args
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void main(String[] args) throws SQLException, IOException
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a scenario: ");
		String scenario = sc.nextLine();

		File file = new File("/home/rowan_user/" + scenario + ".csv");

		if(file.createNewFile())
		{
			System.out.println("File Created");
		}

		FileWriter writer = new FileWriter(file);
		SQLCommands sqc = new SQLCommands();

		String url = "jdbc:oracle:thin:@//localhost:1521/cablocal";
		Connection conn = DriverManager.getConnection(url, "uret01", "rowan");

		sqc.setScenario(scenario);
		SQLCommands.setConnection(conn);
		SQLCommands.queryTable();

		writer.write(sqc.getReturnedString());
		writer.flush();
		writer.close();
	}

}
