package src;

public enum MealType {
    
    HEALTHY("Healthy"),
    WARM("Warm"),
    NEW("New"),
    TREAT("Treat");
    
    private String type;
    
    MealType(String type) {
        this.type = type;
    }
    
    public String toString() {
        return this.type;
    }
    
    static MealType get(String type){
        for(MealType mealType : MealType.values()) {
            if(type.equalsIgnoreCase(mealType.toString())) {
                return mealType;
            }
        }
        
        return null;
    }
}