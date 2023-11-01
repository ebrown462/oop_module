package part01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import audio.AudioPlayer;

public class AudioManager implements iManager {

	// Creating a new Arraylist called audioData
	private ArrayList<AudioFile> audioData = new ArrayList<AudioFile>();
	// Creating a new AudioPlayer called player
	public static AudioPlayer player = new AudioPlayer();

	public void loadAudio(AudioFile af) {
		// adds a new Audio file
		audioData.add(af);
		String[] result = new String[audioData.size()];
		int index = 0;
		for (int i = 0; i < audioData.size() - 1 && audioData.size() > 1; i++) {
			result[index] = audioData.get(i).getDataSource();
			if (result[index].equals(af.getDataSource())) {
				System.out.println("Error, an audioFile with the same dataSouce already exists");
				audioData.remove(i);
			}
		}
	}

	public void deleteAudio(int index) {
		// Array index starts at 0 and Audio code starts at 1, so making them both start at 0
		int temp = index - 1;
		// Checking that the Audio code exists
		try {
			audioData.remove(temp);
		} catch (Exception ex) {
			System.out.println("Error, the Audio code entered does not exist");
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
		System.out.print(player.playFile(af.getDataSource()));
		return temp;
	}

	public String play(int audioId) {
		try {
		// Index starts at 0, and audio code starts at 1, so making them both start at 0
		int index = audioId - 1;
		// Getting the audioData by the ID that the user inputed, and trimming it
		AudioFile finish = audioData.get(index);
		String temp = finish.getDataSource();
		System.out.println(player.playFile(temp.trim()));
		// Display info about what file is playing, and call the register play function
		System.out.println("Currently playing '" + finish.getTitle() + "'" + " at dataSource: " + finish.getDataSource());
		finish.registerPlay();
		return null;
		}catch(Exception ex) {
			System.out.println("Error, code doesn't exist");
			return null;
		}
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
		System.out.println("\nThe Top Songs Played are:\n");
		Collections.sort(l);

		// If less than 10 songs are added, it will display all available songs,
		if ((audioData.size() < 10) && (audioData.size() > 0)){
				for (int i = 0; i < audioData.size(); i++) {
					String print = l.get(i);
					System.out.println(print);
				}	
		}
		// If there are no songs added, it will let the user know
		else if (audioData.size() < 1) {
			System.out.println("There are no AudioFiles stored");
		}
		// If more than 10 songs are added, it will display the top 10 most played in order
		else {
			Collections.sort(l);
			for (int i = 0; i < 10; i++) {
				String print = l.get(i);
				System.out.println(print);
			}
		}
		return null;
	}

	// Setting the player to p
	public void setPlayer(AudioPlayer p) {
		this.player = p;
	}
}
