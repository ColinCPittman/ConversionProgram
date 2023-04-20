public class WeightConversion {
    private int choice;
    private String startingScale, targetScale;
    private double startingWeight, convertedWeight;
    public WeightConversion() {
        choice = 0;
        startingWeight = 0.0;
        convertedWeight = 0.0;
        startingScale = null;
        targetScale = null;
    }
    public WeightConversion(int choice, double startingWeight) {
        this.choice = choice;
        this.startingWeight = startingWeight;
        this.convertedWeight = convertStored();
    }
    public String toString() {
        return "The starting scale int is " + choice + " which corresponds to " + startingScale + " and the target conversion scale is " + targetScale
                + ". The starting weight is set to " + startingWeight + " and the stored conversion is " + convertedWeight + ".";
    }
    public String getStartingScale() {
        return startingScale;
    }

    public String getTargetScale() {
        return targetScale;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
        switch(choice) {
            case 1:
                this.startingScale = "kilograms";
                this.targetScale = "pounds";
                break;
            case 2:
                this.startingScale = "pounds";
                this.targetScale = "kilograms";
                break;
        }
    }

    public double getStartingWeight() {
        return startingWeight;
    }

    public void setStartingWeight(double startingWeight) {
        this.startingWeight = startingWeight;
    }

    public double getConvertedWeight() {
        return convertedWeight;
    }

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
            this.startingScale = "kilograms";
            this.targetScale = "pounds";
        } else { //pounds to kilograms
            converted = weight * 0.453592;
            this.startingScale = "pounds";
            this.targetScale = "kilograms";
        }
        this.convertedWeight = converted;
        return converted;
    }

    public double convertStored() { //method to be call after input has been validated to only accept 1 or 2.
        double converted;
        if (getChoice() == 1) { //kilograms to pounds
            converted = getStartingWeight() * 2.20462;
            this.startingScale = "kilograms";
            this.targetScale = "pounds";
        } else { //pounds to kilograms
            converted = getStartingWeight() * 0.453592;
            this.startingScale = "pounds";
            this.targetScale = "kilograms";
        }
        this.convertedWeight = converted;
        return converted;
    }

}
