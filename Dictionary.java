import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	public static String[] readArrayFile(String fileName) {
		//Make sure that the file has been dragged into the PROJECT folder
		//(not the src folder) in Eclipse. You should be able to see the file
		//below the JRE System Library in the Package Explorer view.
		try {
			Scanner scanner = new Scanner(new File(fileName));
			ArrayList<String> line = new ArrayList<String>();
			while (scanner.hasNext()) {	
				String n = scanner.nextLine();
				line.add(n);
			}
			String[] stringArray = new String[line.size()];
			for (int i = 0; i < stringArray.length; i++) {
				stringArray[i] = line.get(i);
			}
			return stringArray;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
