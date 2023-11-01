package part03;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

import console.Console;

import audio.AudioPlayer;

public class AudioManager implements iManager {
	
	static Console con = new Console(true);

	// Creating a new Arraylist called audioData and albumData
	ArrayList<AudioFile> audioData = new ArrayList<AudioFile>();
	ArrayList<Album> albumData = new ArrayList<Album>();
	ArrayList<AlbumTrack> albumTrackData = new ArrayList<AlbumTrack>();
	// Creating a new AudioPlayer called player
	public static AudioPlayer player = new AudioPlayer();

	public void loadAudio(AudioFile af) {
		// adds a new Audio file
		
		audioData.add(af);
	}
	
	public String playAlbum(int code) {
		int index = code - 1;
		// Getting the audioData by the ID that the user inputed, and trimming it
		AlbumTrack finish = albumTrackData.get(index);
		String temp = finish.getDataSource();
		QUBMediaUpdated.con.println(temp.trim());
		QUBMediaUpdated.con.println(player.playFile(temp.trim()));
		// Display info about what file is playing, and call the register play function
		QUBMediaUpdated.con.println("Currently playing '" + finish.getTitle() + "'" + " at dataSource: " + finish.getDataSource());
		//finish.registerPlay();
		return null;
	}
	
	public void loadAlbumTrack(String title, int duration, String dataSource, Album record ) {
		var albumTrack = new AlbumTrack(title, duration, dataSource, record);
		albumTrackData.add(albumTrack);
		QUBMediaUpdated.con.println(new ImageIcon("Images//download.png"));
		QUBMediaUpdated.con.println("ADDED");
	}
	
	public void loadAlbum(String title, String artist, String source) {
		ImageIcon icon = new ImageIcon("Images//" + source);
		var album = new Album(title,artist,icon);
		albumData.add(album);
		QUBMediaUpdated.con.clear();
		QUBMediaUpdated.con.println(new ImageIcon("Images//" + source));
		QUBMediaUpdated.con.println();
		QUBMediaUpdated.con.println();
		QUBMediaUpdated.con.println();
		QUBMediaUpdated.con.println();
		QUBMediaUpdated.con.println(album);
		
	}
	public String[] getAlbumData() {
		String[] result = new String[albumData.size()];
		int index = 0;
		//QUBMediaUpdated.con.println(new ImageIcon("Images//download.png"));
		for (Album data : albumData) {
			result[index] = "Title: " + data.getTitle() + "\nArtist: " + data.getArtist() + "\n";
			index++;
		}
		return result;
	}
	
	public void deleteAudio(int index) {
		// Array index starts at 0 and Audio code starts at 1, so making them both start at 0
		QUBMediaUpdated.con.clear();
		int temp = index - 1;
		// Checking that the Audio code exists
		try {
			audioData.remove(temp);
		} catch (Exception ex) {
			QUBMediaUpdated.con.println("Error, the Audio code entered does not exist");
		}
	}

	public void albumTrackDetails(int index) {
		// Array index starts at 0 and Audio code starts at 1, so making them both start at 0
		int temp = index - 1;
		// Checking that the Audio code exists
		try {
			QUBMediaUpdated.con.println("Title: hit the diff");
			QUBMediaUpdated.con.println(albumTrackData.get(temp));
		} catch (Exception ex) {
			QUBMediaUpdated.con.println("Error, the Audio code entered does not exist");
		}
	}
	
	public String[] getAllData() {
		// Creates an array and goes through each index, pulling the Audio information needed
		String[] result = new String[audioData.size()];
		int index = 0;
		for (AudioFile data : audioData) {
			result[index] = "Code: " + data.getCode() + "\nAudio Title: " + data.getTitle() + "\nDuration: "
					+ data.getDuration() + "\nData Source: " + data.getDataSource() + "\nPlay Count: "
					+ data.getPlayCount() + "\n";
			index++;
		}
		return result;
	}

	public String play(AudioFile af) {
		// NOTE: for some reason this works on my PC,
		// but when on my laptop Windows Defender blocks it from accessing the .wav file
		String temp = "Now playing " + af.getTitle();
		QUBMediaUpdated.con.print(player.playFile(af.getDataSource()));
		return temp;
	}

	public String play(int audioId) {
		// Index starts at 0, and audio code starts at 1, so making them both start at 0
		int index = audioId - 1;
		// Getting the audioData by the ID that the user inputed, and trimming it
		AudioFile finish = audioData.get(index);
		String temp = finish.getDataSource();
		QUBMediaUpdated.con.println(player.playFile(temp.trim()));
		// Display info about what file is playing, and call the register play function
		QUBMediaUpdated.con.println("Currently playing '" + finish.getTitle() + "'" + " at dataSource: " + finish.getDataSource());
		finish.registerPlay();
		return null;
	}

	public String topTen() {
		// Starts index at 0 and creates a new ArrayList called l
		int tempCount = 0;
		ArrayList<String> l = new ArrayList<>();

		// While loop to go through the array, and get the needed audio information
		while (tempCount < audioData.size()) {
			AudioFile temp = audioData.get(tempCount);
			String finish = "Code: " + temp.getCode() + "\nTitle: " + temp.getTitle() + "\nPlay Count: "
					+ temp.getPlayCount() + "\n";
			l.add(finish);
			tempCount++;
		}
		// Sorting the new array in order of most played, from top to bottom
		QUBMediaUpdated.con.println("\nThe Top Songs Played are:\n");
		Collections.sort(l);

		// If less than 10 songs are added, it will display all available songs,
		if ((audioData.size() < 10) && (audioData.size() > 0)){
				for (int i = 0; i < audioData.size(); i++) {
					String print = l.get(i);
					QUBMediaUpdated.con.println(print);
					return print;
				}	
		}
		// If there are no songs added, it will let the user know
		else if (audioData.size() < 1) {
			QUBMediaUpdated.con.println("There are no AudioFiles stored");
			return "There are no AudioFiles stored";
		}
		// If more than 10 songs are added, it will display the top 10 most played in order
		else {
			Collections.sort(l);
			for (int i = 0; i < 10; i++) {
				String print = l.get(i);
				QUBMediaUpdated.con.println(print);
				return print;
			}
		}
		return null;
	}

	// Setting the player to p
	public void setPlayer(AudioPlayer p) {
		this.player = p;
	}
}
