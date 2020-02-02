//preprocessor directive
import java.io.*;
import java.util.*;

public class JoinAndSelect {
	/* My first Java Program */


	
	public static void main(String args[]) throws IOException {

		Dictionary<String,Vector<String> > locationMap = new Hashtable<String,Vector<String> >();
		Dictionary<String, String > salaryMap = new Hashtable<String, String>();
		//initialize map object for storage of data


		//declare IO objects
		try {
			File locationData = new File("personnel_addresses.txt");
			File salaryData = new File("personnel_salaries.txt");			
			Scanner locationReader = new Scanner(locationData);
			Scanner salaryReader = new Scanner(salaryData);

			String inputA;
			String inputB;

			//process files!!
			while (locationReader.hasNextLine())
			{
				inputA = locationReader.nextLine();
				String[] data = inputA.split("\\|");
				//locationMap.put(data[1],data[0]);

				//if locationMap does not yet have a keyvalue pair, instantiate a new vector and add the name to that vector.
				// else, take the existing vector from the Map, add the name to it, and then re insert the vector into the Map.

				if (locationMap.get(data[1]) == null)	//does not already contain key
				{
					Vector<String> names = new Vector<String>();
					names.add(data[0]);

					locationMap.put(data[1],names);
				}
				else //ALREADY contains key..
				{
					Vector<String> names = locationMap.get(data[1]);
					names.add(data[0]);
					locationMap.put(data[1],names);
				}
			}		
			while (salaryReader.hasNextLine())
			{
				inputB = salaryReader.nextLine();
				String[] data = inputB.split("\\|");
				//do stuff with the input...
				salaryMap.put(data[0],data[1]);
				//salaryMap.
			}
		salaryReader.close();
		locationReader.close();
		//close the scanners to prevent me

		}	// end TRY block
		
		catch (FileNotFoundException e)
		{
			System.out.println("An error Occurred.");
			e.printStackTrace();
		}

		//=================== begin main program loop=========
		
		boolean quit = false;
		Vector<String> keys = new Vector<String>();

		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Files Processed Successfully\n Enter a Search Query: ");

		String query = inputScanner.nextLine();

		int keycount = 0;
		// loop through the enumeration of all keys, checking for substring results.
		for (Enumeration<String> locations = locationMap.keys(); locations.hasMoreElements();)
		{
			String key = locations.nextElement();

			if (key.indexOf(query) != -1)	//if the query is a substring of the key...
			{	
				keycount = keycount + 1;
				keys.add(key);
			}
		}

		//System.out.println("LocationKeys: " + keys);	
		int numEntries = 0;	
		for (int i = 0; i < keycount; i++)
		{
			Vector<String> people = locationMap.get(keys.get(i));
			numEntries += people.size();
			for (int j = 0; j < people.size(); j++)
			{
				System.out.println(people.get(j) + ":" + salaryMap.get(people.get(j)));
			}
		}
			
		//System.out.println(" Number of entries:" + numEntries); 
	}//End main
}//End JoinAndSelect class
