public class WeightConversion {
    public String getMenu(){
        return """
                
                [Weight conversion]
                
                [1]Convert from kilograms to pounds.
                [2]Convert from pounds to kilograms.
                [9]Exit.
                """;
    }
    public double convert(int choice, double weight) { //method to be call after input has been validated to only accept 1 or 2.
        double converted;
        if (choice == 1) { //kilograms to pounds
            converted = weight * 2.20462;
        } else { //pounds to kilograms
            converted = weight * 0.453592;
        }
        return converted;
    }
}
