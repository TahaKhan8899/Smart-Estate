package smart_estate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StateGen {
	public static String states[] = new String[50];

	public static String[] readStates() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data/connectedStates.txt"));
			String line = reader.readLine();
			int i = 0;
			while (line != null) {
				String[] info = line.split(", ");
				String state = info[0];
				states[i] = state;
				i++;
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return states;
	}

	public static void main(String[] args) {
		String s[] = readStates();
		for (int i = 0; i < states.length; i++) {
			System.out.println(s[i]);
		}

	}

}
