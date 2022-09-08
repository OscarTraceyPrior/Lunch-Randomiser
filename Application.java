import java.io.File;
import java.util.List;

public class Application {
    
    public static void main(String[] args) throws Exception {
        
        if(args.length != 0) {
            LunchReader reader = new LunchReader(new File(args[0].toLowerCase() + "-lunches.txt"));
            
            LunchRandomiser randomiser = new LunchRandomiser();
            List<Lunch> lunches = reader.readLunchesFromFile();
            Lunch todaysLunch = randomiser.getRandomLunch(lunches);
        
            if(args.length == 0 || (args.length > 0 && !args[0].equalsIgnoreCase("test"))) {
                LunchRecorder recorder = new LunchRecorder(new File("lunch-diary.txt"));
                recorder.record(todaysLunch);
            }
        
            System.out.println("Today's lunch is... " + todaysLunch + "! Enjoy!");
            
        } else {
            System.out.println("ERROR: Please specify an environment from the following: home, office");
        }
        
        
    }
    
}