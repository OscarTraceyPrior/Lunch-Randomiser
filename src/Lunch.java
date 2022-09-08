package src;

public class Lunch{

    private MealType type;
    private String name;
    
    public Lunch(String lunchString) {
        String[] components = lunchString.split(":");
        this.type = MealType.get(components[0].trim().toUpperCase());
        this.name = components[1].trim();
        
        if(this.name == null || this.type == null) {
            throw new IllegalArgumentException("Name and/or type are null");
        }
    }
    
    public String getType() {
        return this.type.toString();
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}