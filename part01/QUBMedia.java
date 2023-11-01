package part01;

import java.util.Scanner;
import audio.AudioPlayer;
import menu.Menu;

public class QUBMedia {
	
	// Making new AudioPlayer and AudioManager instances
	public static AudioPlayer ap = new AudioPlayer();
	public static AudioManager am = new AudioManager();

	// Main loop
	public static void main(String[] args) {
		int choice;
		do {
			choice = myMenu.getUserChoice();
			if (choice != QUIT) {
				processChoice(choice);
			}
		} while (choice != QUIT);
		System.out.println("\nGoodbye!");
		input.close();
	}

	// Making each menu choice
	private static void processChoice(int choice) {
		switch (choice) {
		case 1:
			getAllData1();
			break;
		case 2:
			am.loadAudio(loadAudioFile());
			break;
		case 3:
			getAllData1();
			am.deleteAudio(setCode());
			break;
		case 4:
			getAllData1();
			am.play(setCode());
			break;
		case 5:
			am.play(setTDS());
			break;
		case 6:
			am.topTen();
			break;
		case 7:
			System.out.println("Option " + choice + " not yet implemented.");
			break;

		default:
			System.out.println("Option " + choice + " is invalid.");
		}
		System.out.println();
	}

	
	public static AudioFile setTDS() {
		String title = setTitle();
		String dataSource = setDataSource();
		AudioFile temp = new AudioFile("", 0, dataSource);
		return temp;
	}
	
	// LoadAudioFile function, sets all new information needed by getting the user to input it
	public static AudioFile loadAudioFile() {
		// title and dataSource can be integers or strings, but duration can ONLY be an integer
		// the code below checks to see if an error has occurred, which means the user has entered an incorrect duration
		try {
			String title = setTitle();
			int duration = setDuration();
			String dataSource = setDataSource();
			AudioFile temp = new AudioFile(title, duration, dataSource);
			return temp;
		} catch (Exception ex) {
			System.out.println("Exception - loadAudioFile failed, please make sure the duration is an integer");
			return null;
		}
	}
	
	// setters for all the AudioFile values
	public static String setTitle() {
		String defaultTitle = "Default";
		String tempName = "";
		System.out.println("Enter Song Name: ");
		tempName = input.nextLine();
		// checks to make sure the user has entered a value, if not a default title is assigned
		if (tempName == null) {
			System.out.println("Error cannot enter a blank title, a default title has been set");
			return defaultTitle;
		}
		else {
			return tempName;
		}
	}
	public static int setDuration() {
		int defaultDuration = 0;
		int tempDuration = 0;
		System.out.println("\nEnter a song duration: ");
		tempDuration = input.nextInt();
		// checks to make sure the user hasn't entered a negative value, if they have a default value is assigned
		if (tempDuration < 0) {
			System.out.println("Error cannot enter a value lower than 0, a default value ahs been assigned");
			return defaultDuration;
		}
		else {
			return tempDuration;
		}
	}
	public static String setDataSource() {
		String tempDataSource = "";
		System.out.println("\nEnter a song data source: ");
		input.nextLine();
		tempDataSource = input.nextLine();
		return tempDataSource;
	}
	
	// Pulls all data using the getAllData function in AudioManager
	public static void getAllData1() {
		try {
			for (String data : am.getAllData()) {
				if (data != "") {
					System.out.println(data);
				}
				else {
					System.out.println("No audioFiles added");
				}
			}
		}
		catch(Exception ex){
			System.out.println("Error displaying data");
		}
	}
	
	// Getting the audio code for delete user function
	public static int setCode() {
		int temp = 0;
		System.out.println("Please enter a song code");
		temp = input.nextInt();
		if (temp > 0) {
			return temp;
		}
		else {
			System.out.println("\nPlease enter a valid Audio code");
			return -1;
		}
	}
	
	// String array of all menu options
	static final String options[] = { "Get all Data", "Load Audio", "Delete Audio",
			"Play Audio File via code", "Play Audio File from dataSource","Display top played songs", "Quit" };

	// Defining the constant QUIT
	static final int QUIT = options.length;

	// Menu title
	static String title = "QUB Media Manager";

	// Defining the menu using title & options
	static Menu myMenu = new Menu(title, options);

	// Defining the Scanner
	static Scanner input = new Scanner(System.in);
}