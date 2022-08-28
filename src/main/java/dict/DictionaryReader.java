package dict;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DictionaryReader {
	static String path = "src\\main\\java\\dict\\dictionary.config";

	public static void main(String[] args) {

		printMeaning("Apple");
		printMeaning("Table");
		printMeaning("Orange");

	}

	public static void printMeaning(String word) {

		if (doesFileExists(path)) {
			Properties prop = new Properties();
			InputStream input;
			try {
				input = new FileInputStream(path);
				prop.load(input);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String value = prop.getProperty(word);
			String[] meanings = value.split(",");
			System.out.println(word);
			for (String i : meanings) {
				System.out.println(i);
			}
		}
		else
			System.out.println("Specified File Does not Exists!!");
	}

	public static boolean doesFileExists(String path) {

		File file = new File(path);
		if (file.exists())
			return true;
		else
			return false;
	}
}
