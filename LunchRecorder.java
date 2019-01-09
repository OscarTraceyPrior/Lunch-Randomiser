import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class LunchRecorder {
    
    private File lunchRecord;
    
    public LunchRecorder(File lunchRecord) {
        this.lunchRecord = lunchRecord;
    }
    
    public void record(Lunch lunch) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(lunchRecord, true));
        
        try{
            LocalDate today = LocalDate.now();
            DateTimeFormatter prettifier = DateTimeFormatter.ofPattern("EEEE d MMMM uuuu");
            String prettyToday = today.format(prettifier);
            writer.write(prettyToday + " : " + lunch.toString() + " - " + lunch.getType() + "\n");
            writer.flush();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            writer.close();
        }
        
    }
    
    
}