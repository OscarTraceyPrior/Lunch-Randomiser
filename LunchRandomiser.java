import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;

public class LunchRandomiser {

    private Random randomiser;
    
    public LunchRandomiser() {
        this.randomiser = new Random(); 
    }

    public Lunch getRandomLunch(List<Lunch> potentialLunches) throws Exception {
        MealType todaysMealType = getTodaysMealType();
        
        potentialLunches = getLunchesOfType(potentialLunches, todaysMealType);
        
	    return chooseRandomLunch(potentialLunches);  	 
    }
    
    
    
    private MealType getTodaysMealType() {
        int randomValue = randomiser.nextInt(100);
        
        if(randomValue < 10) {
            return MealType.TREAT;
        } else if (randomValue < 30) {
            return MealType.NEW;
        } else if (randomValue < 50) {
            return MealType.WARM;
        } else if (randomValue < 100) {
            return MealType.HEALTHY;
        } else {
            throw new IllegalStateException("Random Value Generated above 100");
        }
    }
    
    private List<Lunch> getLunchesOfType(List<Lunch> potentialLunches, MealType type) {
        return potentialLunches.stream().filter(lunch -> lunch.getType().equalsIgnoreCase(type.toString())).collect(Collectors.toList());
    }
    
    private Lunch chooseRandomLunch(List<Lunch> potentialLunches) {
        return potentialLunches.get(randomiser.nextInt(potentialLunches.size()));
    }
}
