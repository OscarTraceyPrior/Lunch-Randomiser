import java.io.File;
import java.util.List;

public class Application {
    
    public static void main(String[] args) throws Exception {
        LunchReader reader = new LunchReader(new File("lunches.txt"));
        LunchRandomiser randomiser = new LunchRandomiser();
        List<Lunch> lunches = reader.readLunchesFromFile();
        
        System.out.println("Today's lunch is... " + randomiser.getRandomLunch(lunches) + "! Enjoy!");
    }
    
}