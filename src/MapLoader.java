import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MapLoader {

	public MapLoader() {
		
	}
	
	public String listDirectories() {
		File file = new File("maps");
		String[] directories = file.list(new FilenameFilter() {
		  @Override
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		for(int i = 0; i < directories.length; i++) {
			System.out.println(i + 1 + " - " + directories[i]);
		}
		Scanner s = new Scanner(System.in);
		int map = s.nextInt();
		
		return "maps\\" + directories[map - 1];
	}
	
	public ArrayList<ArrayList<Character>> loadMap(String directory) throws IOException {
		
		ArrayList<ArrayList<Character>> map = new ArrayList<ArrayList<Character>>();
		File file = new File(directory);
		if(!file.exists()) {
			file.createNewFile();
		}
		Scanner in = new Scanner(file);
		String line;
		ArrayList<String> lines = new ArrayList<String>();
		do {
			line = in.nextLine();
			lines.add(line);
		} while(in.hasNextLine());
		in.close();
					
		for(int i = 0; i < lines.size(); i++) {
			
			ArrayList<Character> chars = new ArrayList<Character>();
			chars.clear();
			
			for(int j = 0; j < lines.get(i).length(); j++) {
				
				chars.add(lines.get(i).charAt(j));
				
			}
			
			map.add(chars);
			
		}
		
		return map;
		
	}

}
