public class Song {
	private String artist; // the artist performing the song
	private String title; // the title of the song
	private int minutes; // number of min in length
	private int seconds; // number of seconds of length of the song (always less than 60)
	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title;
		this.minutes = 0;
		this.seconds = 0;
	}
	public Song(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		if (seconds > 59) {
			int add = seconds / 60;
			this.minutes += add;
			this.seconds = seconds % 60;
		}
		else {
			this.seconds = seconds;
		}
	}
	public Song(Song s) {
		this.title = s.title;
		this.artist = s.artist;
		this.minutes = s.minutes;
		this.seconds = s.seconds;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {		
		if (seconds > 59) {
			int add = seconds / 60;
			this.minutes += add;
			this.seconds = seconds % 60;
		}
	
		else {
			this.seconds = seconds;
		}
	}
	public boolean equals(Object o) {
		if (o instanceof Song) {
			Song b = ((Song) o);
			if (this.title.equals(b.title) && this.artist.equals(b.artist) && this.minutes == b.minutes && this.seconds == b.seconds) {
				return true;
			}
		}

		return false;
	}

	public String toString() { // Use this code for toString EXACTLY
		return "{Song: title=" + title + " artist=" + artist + "}";
	}
	public void play() { // Use this code for play EXACTLY
		System.out.printf("Playing Song: artist=%-20s title=%s\n", artist, title);
	}

	private static void main(String[] args) {

	}
}
