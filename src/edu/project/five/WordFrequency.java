package edu.project.five;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordFrequency {

	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		wordMap = CreateMap(wordMap);
		displayMap(wordMap);
	}

	public static Map<String, Integer> CreateMap(Map<String, Integer> map) throws FileNotFoundException {
		File fileName = new File("test.txt");
		Scanner input = new Scanner(fileName);
		while (input.hasNextLine()) {
			String inputLine = input.nextLine();
			String[] tokens = inputLine.split(" ");

			// remove punctuation
			for (int i = 0; i < tokens.length; i++) {
				if (tokens[i].contains(".") || tokens[i].contains(",")) {
					tokens[i] = tokens[i].substring(0, tokens[i].length() - 1);
				}
			}

			for (String s : tokens) {
				if (map.containsKey(s)) {
					int value = map.get(s);
					value++;
					map.replace(s, value);
				} else {
					map.put(s, 1);
				}
			}
		}
		input.close();
		return map;
	}

	public static void displayMap(Map<String, Integer> map) {
		Set<String> s = map.keySet();
		Set<String> ts = new TreeSet<String>(s);
		int largest = 0;
		
		System.out.println("All words..");
		for (String e : ts) {
				System.out.println(e + "	" + map.get(e));
		}
		
		for (String e : ts) {
			if (map.get(e) > largest) {
				largest = map.get(e);
			}
		}

		// Printing most frequent
		System.out.println("\nMost frequently used words..");
		for (String e : ts) {
			if (map.get(e) == largest) {
				System.out.println(e + "	" + map.get(e));
			}
		}

	}

}
