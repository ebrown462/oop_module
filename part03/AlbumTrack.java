package part03;
import part03.AudioFile;

public class AlbumTrack extends AudioFile{
	
	private Album record;
	
	public AlbumTrack (String title, int duration, String dataSource, Album record){
		super(title,duration,dataSource);
		this.record = record;
	}
	
	//public String getAlbum() {
	//	return this.getAlbum();
	//}
	
	public String toString() {
		return ("Code: " + getCode() + "\nDuration: " + getDuration() + "\ndataSource: " + getDataSource() + "\nAlbum: ");
	}
}
