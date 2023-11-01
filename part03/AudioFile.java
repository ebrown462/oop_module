package part03;

public class AudioFile implements iAudio{
	
	// Setting variables
	private int code;
	private static int nextCode =1;
	private String title;
	private int duration;
	private String dataSource;
	private int playCount;
	
	// Constructor
	public AudioFile(String title, int duration, String dataSource) {
		this.code = useNextCode();
		this.title = title;
		this.duration = duration;
		this.dataSource = dataSource;
	}
	
	// Getters
	public int getCode() {
		return this.code;
	}
	public String getTitle() {
		return this.title;
	}
	public int getDuration() {
		return this.duration;
	}
	public String getDataSource() {
		return this.dataSource;
	}
	public int getPlayCount() {
		return this.playCount;
	}
	
	// toString
	public String toString() {
		String result = ("Code: " + this.getCode() + "\nTitle: " + this.getTitle() + "\nDuration: " + this.getDuration() + "\nData Source: " + this.getDataSource() + "\nPlay Count: " + this.getPlayCount());
		return result;
	}
	
	// Register Play
	// Note: currently increments ALL play counts
	public void registerPlay() {
		this.playCount = playCount;
		this.playCount++;
	}
	
	// Increment nextCode
	private static int useNextCode() {
		int code = nextCode++;
		return code;
	}
}