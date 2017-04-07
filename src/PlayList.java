import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
//Tiffany Vinci-Cannava tv2bq CS2110 Lab Section 3
//Collaborated with Taji tah7qd
public class PlayList {
	private String name;
	private ArrayList<Song> songList;

	public PlayList() {
		songList = new ArrayList<Song>();
		this.name = "Untitled";

	}
	public PlayList(String newname) {
		songList = new ArrayList<Song>();
		this.name = newname;
	}

	public static boolean loadSongs(String filename) {
		/**Loads songs in file with given name.*/
		String songs = null;
		String[] a = null;
		File f = new File(filename);
		Scanner read = null;
		try {
			read = new Scanner(f);
		} catch (Exception e) {
			return false;
		}
		String[] time = new String[2];
		while (read.hasNextLine()) {
			songs = read.nextLine();
			String songName = read.nextLine().trim();
			String songArtist = read.nextLine().trim();
			String songLength = read.nextLine().trim();
			time = songLength.split(":");
			int minutes = Integer.parseInt(time[0]);
			int seconds = Integer.parseInt(time[1]);
			String ignore = read.nextLine().trim();
			return true;
		}
		return songs.length() > 0;
	} 
	public boolean clear() {
		/**returns true if all songs removed, returns false otherwise. */
		if (songList.size() > 0) {
			songList.clear();
			return true;
		}
		else {
			return false;
		}

	}
	public boolean addSong(Song s) {
		/**returns true if song is initially not in arrayList, then added.*/
		if (!(songList.contains(s))) {
			songList.add(s); //add song to last position...
			return true;
		}
		else {
			return false;
		}
	}
	public Song removeSong(int index) {
		Song c = null;
		if (index <= songList.size() - 1 && index >= 0) {
			c = songList.get(index);
			songList.remove(c);
			return c;
		}
		//		else if(index==songList.size()){
		//		    c=songList.get(index-1);
		//		    songList.remove(c);
		//		    return c;
		//		}
		else {
			return null;
		}				
	}
	public Song removeSong(Song s) {
		for (int i = 0; i < songList.size(); i++) {
			if (songList.get(i).equals(s)) {
				songList.remove(s);
			}
		}
		return s;
	}
	public Song getSong(int index) {
		if (index >= 0 && index < songList.size()) {
			return songList.get(index);
		}
		else {
			return null;
		}
	}
	public void play() {
		for (int i = 0; i < songList.size(); i++) {
			songList.get(i).play();
		}
	}
	public int size() {
		return songList.size();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}

	public void setSongList(ArrayList<Song> songList) {
		this.songList = songList;
	}

	@Override
	public String toString() {
		return "PlayList [name=" + name + "]";
	}


	public static void main(String[] args) {
		String a = "songs.txt";
		File f = new File(a);
		System.out.println(loadSongs(a));
	}

}
