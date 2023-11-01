package part03;
import javax.swing.ImageIcon;

public class Album {
	private String title;
	private String artist;
	private ImageIcon cover;

	// Constructor
	public Album(String title, String artist, ImageIcon cover) {
		this.title = title;
		this.artist = artist;
		this.cover = cover;
	}

	// Getters
	public String getTitle() {
		return this.title;
	}
	public String getArtist() {
		return this.artist;
	}
	public ImageIcon getCover() {
		return this.cover;
	}

	// toString
	public String toString() {
		String result = "Title: " + getTitle() + "\nArtist: " + getArtist();
		return result;
	}
}
