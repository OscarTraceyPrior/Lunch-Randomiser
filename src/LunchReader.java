package src;

import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;


public class LunchReader {
    
    private File lunchDictionary;
    
    public LunchReader(File lunchDictionary) {
        this.lunchDictionary = lunchDictionary;
    }
    
    public List<Lunch> readLunchesFromFile() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(lunchDictionary));
        List<Lunch> lunches = new ArrayList<>();
	   
        try {
	        for(String currentLine = reader.readLine(); currentLine != null; currentLine = reader.readLine()) {
                lunches.add(new Lunch(currentLine));
            }
        } finally {
            reader.close();
        }
        
        return lunches;
    }
}