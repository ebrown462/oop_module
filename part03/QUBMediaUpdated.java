package part03;

import audio.AudioPlayer;
import java.awt.Color; 
import java.awt.Font;

import javax.swing.ImageIcon;

import console.Console;

public class QUBMediaUpdated {
	
	static boolean running = true;
	
	// Making new AudioPlayer and AudioManager instances
	public static AudioPlayer ap = new AudioPlayer();
	public static AudioManager am = new AudioManager();
	
	// Defining the console
	static Console con = new Console(true);

	// Main loop
	public static void main(String[] args) {
		
		// Creating and customising console window
		con.setSize(1000, 600);
		con.setVisible(true);
		con.setBgColour(Color.BLACK);
		con.setFont(new Font("Courier", Font.BOLD, 20));
		con.setColour(Color.white);
		con.setTitle("QUB Media Updated version 1.0");
		con.println("Welcome to QUBMedia created by Ewan");
		con.println();	
		
		// Infinite loop
		do {
			con.print("--------------------------------\nPlease Select From The Following Options\n\nAUDIO FILES\n[1] Display all Audio\n[2] Load AudioFile\n[3] Delete Audio\n[4] Play Audio File via code\n[5] Play Audio File from dataSource\n[6] Display top played songs\n\nALBUMS\n[7] Load New Album\n[8] Add Album Track\n[9] List Albums\n[10] Display album details\n[11] Play an Album\n\nSYSTEM\n[12] QUIT\n--------------------------------\nOption: ");
			int intTemp;
			String value = con.readLn();
			value = value.trim();
			intTemp = Integer.parseInt(value);
			if (intTemp > 0) {
				printChoice(intTemp, con);
			}
			else {
				con.println("Please enter a valid option");
			}
		}
		while (running = true);
	}

	// Choices
	public static void printChoice(int choice, Console con) {
		switch (choice) {
		case 1:
			con.clear();
			getAllData1();
			break;
		case 2:
			am.loadAudio(loadAudioFile());
			con.println("loaded successfully");
			con.clear();
			break;
		case 3:
			con.clear();
			am.deleteAudio(setCode());
			break;
		case 4:
			con.clear();
			con.println("The following songs are stored");
			getAllData1();
			am.play(setCode());
			break;
		case 5:
			con.clear();
			am.play(setTDS());
			break;
		case 6:
			con.clear();
			am.topTen();
			break;
		case 7:
			con.clear();
			am.loadAlbum(setTitle(), setArtist(), setIcon());
			break;
		case 8:
			con.clear();
			am.loadAlbumTrack(setTitle(), setDuration(), setDataSource(), setRecord());
			break;
		case 9:
			con.clear();
			getAlbumData1();
			break;
		case 10:
			con.clear();
			am.albumTrackDetails(setCode());
			break;
		case 11:
			con.clear();
			am.playAlbum(setCode());
			break;
		case 12:
			System.exit(0);
			break;
		default:
			con.println("Option " + choice + " is invalid.");
		}
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
			con.println("Exception - loadAudioFile failed, please make sure the duration is an integer");
			return null;
		}
	}
	
	// setters for all the AudioFile values
	public static String setTitle() {
		String defaultTitle = "Default";
		String tempName = "";
		con.println("Enter a title: ");
		tempName = con.readLn(); 
		// checks to make sure the user has entered a value, if not a default title is assigned
		if (tempName == null) {
			con.println("Error cannot enter a blank title, a default title has been set");
			return defaultTitle;
		}
		else {
			return tempName;
		}
	}
	public static int setDuration() {
		int defaultDuration = 0;
		int tempDuration = 0;
		con.println("\nEnter a song duration: ");
		String temp = con.readLn();
		tempDuration = Integer.parseInt(temp);
		// checks to make sure the user hasn't entered a negative value, if they have a default value is assigned
		if (tempDuration < 0) {
			con.println("Error cannot enter a value lower than 0, a default value ahs been assigned");
			return defaultDuration;
		}
		else {
			return tempDuration;
		}
	}
	public static String setDataSource() {
		String tempDataSource = "";
		con.println("\nEnter a song data source: ");
		tempDataSource = con.readLn();
		return tempDataSource;
	}
	public static String setArtist() {
		String tempArtist = "";
		con.println("\nEnter an artist name: ");
		tempArtist = con.readLn();
		return tempArtist;
	}
	
	// Pulls all data using the getAllData function in AudioManager
	public static void getAllData1() {
		try {
			for (String data : am.getAllData()) {
				con.println();
				con.println(data);
			}
		}
		catch(Exception ex){
			con.println("Error displaying data");
		}
	}

	public static void getAlbumData1() {
		try {
			con.clear();
			//con.println(new ImageIcon("Images//download.png"));

			for (String data : am.getAlbumData()) {
				con.println();
				con.print(new ImageIcon("Images//download.png"));
				con.println();
				con.println(data);
			}
		}
		catch(Exception ex){
			con.println("Error displaying data");
		}
	}
	
	// Getting the audio code for delete user function
	public static int setCode() {
		String temp = "";
		int tempCode = 0;
		con.println("Please enter a song code");
		temp = con.readLn();
		tempCode = Integer.parseInt(temp);
		if (tempCode > 0) {
			con.clear();
			return tempCode;
		}
		else {
			con.println("\nPlease enter a valid Audio code");
			return -1;
		}
	}
	
	public static Album setRecord() {
		Album ab = null;
		String temp = "";
		con.println("Please enter an album name: ");
		temp = con.readLn();
        for (var index = 0; index < am.albumData.size() - 1; index++) {
            if (temp.equals(am.albumData.get(index).getTitle())) {
            	con.println("Album found, adding song to album");
                ab = am.albumData.get(index);
                return ab;
            }
            else {
            	return null;
            }
            
        }
		return ab;
	}
	
	public static String setIcon() {
		String temp = "";
		con.println("Please enter a dataSource for the image");
		temp = con.readLn();
		return temp;
	}
}