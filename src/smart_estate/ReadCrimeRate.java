package smart_estate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.*;

public class ReadCrimeRate {
	public static Pair[] CRList() {
		try {
			Scanner scan = new Scanner(new File("data\\CrimeStateByState.csv"));
			List<String> lines = new ArrayList<String>();
			while (scan.hasNextLine()) 
				lines.add(scan.nextLine());
			String[] array = lines.toArray(new String[0]);
			
			int n = array.length;

			double[] crimerates = new double[50];
			int count = 0;
			
			for (int i = 7; i < n; i += 63) {
				double CR = 0;
				double total = 0;
				String[] line = array[i].split(",");
				CR = (double) Integer.parseInt(line[2]) / Integer.parseInt(line[1]);
				total += CR;
				
				if (Integer.parseInt(line[0]) == 1960) {
					for (int l = i+1; l < i+55; l++) {
						line = array[l].split(",");
						CR = (double) Integer.parseInt(line[2]) / Integer.parseInt(line[1]);
						total += CR;
					}
					crimerates[count] = total / 55;
				}
				else if (Integer.parseInt(line[0]) == 1965) {
					for (int l = i+1; l < i+50; l++) {
						line = array[l].split(",");
						CR = (double) Integer.parseInt(line[2]) / Integer.parseInt(line[1]);
						total += CR;
					}
					crimerates[count] = total / 50;
				}
				count++;
			}
			
			Pair[] pairs = new Pair[50];
			String[] states = {"Alabama","Alaska","Arizona","Arkansas","Calidornia","Colorado","Connecticut","Delware","Florida","Gerogia","Hawii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisonsin","Wyoming"};
			
			for (int i = 0; i < 50; i++) {
				Pair pair = new Pair(states[i],(int) (crimerates[i] * 100000));
				pairs[i] = pair;
			}
			return pairs;
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found error!");
			Pair[] lst = new Pair[1];
			return lst;
		}
	}
	
	public static void main(String[] args) {
		Pair[] arr = CRList();
		for (int i = 0; i < 50; i++)
			System.out.println(arr[i]);
	}
}
