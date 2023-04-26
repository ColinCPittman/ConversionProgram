public class DistanceConversion {

    private String startMeasurement, targetMeasurement;
    private double startDist, convertedDist;
    private int startMeasurementInt, targetMeasurementInt;
    public DistanceConversion() {
        convertedDist = 0.0;
        startDist = 0.0;
        startMeasurement = null;
        startMeasurementInt = 0;
        targetMeasurement = null;
        targetMeasurementInt = 0;
    }

    public DistanceConversion(int startMeasurementInt, int targetMeasurementInt, double startDist) {
        this.startDist = startDist;
        this.startMeasurementInt = startMeasurementInt;
        this.targetMeasurementInt = targetMeasurementInt;
        convertedDist = convertStored();
    }

    public void setStartMeasurementInt(int startMeasurementInt) {
        this.startMeasurementInt = startMeasurementInt;
        if(1 <= startMeasurementInt && startMeasurementInt <= 8) {
            switch (startMeasurementInt) {
                case 1 -> startMeasurement = "kilometers";
                case 2 -> startMeasurement = "meters";
                case 3 -> startMeasurement = "centimeters";
                case 4 -> startMeasurement = "millimeters";
                case 5 -> startMeasurement = "miles";
                case 6 -> startMeasurement = "yards";
                case 7 -> startMeasurement = "feet";
                case 8 -> startMeasurement = "inches";
            }
        }
    }
    private static String mainMenu = """
                
                [Distance conversion]
                
                [1]Kilometers
                [2]Meters
                [3]Centimeters
                [4]Millimeters
                [5]Miles
                [6]Yards
                [7]Feet
                [8]Inches
                [9]Exit
                """;
    public void setTargetMeasurementInt(int targetMeasurementInt) {
        this.targetMeasurementInt = targetMeasurementInt;
        if(1 <= targetMeasurementInt && targetMeasurementInt <= 8) {
            switch (targetMeasurementInt) {
                case 1 -> targetMeasurement = "kilometers";
                case 2 -> targetMeasurement = "meters";
                case 3 -> targetMeasurement = "centimeters";
                case 4 -> targetMeasurement = "millimeters";
                case 5 -> targetMeasurement = "miles";
                case 6 -> targetMeasurement = "yards";
                case 7 -> targetMeasurement = "feet";
                case 8 -> targetMeasurement = "inches";
            }
        }
    }

    public void setStartDist(double startDist) {
        this.startDist = startDist;
    }

    public int getStartMeasurementInt() {
        return startMeasurementInt;
    }

    public int getTargetMeasurementInt() {
        return targetMeasurementInt;
    }

    public String getStartMeasurement() {
        return startMeasurement;
    }

    public String getTargetMeasurement() {
        return targetMeasurement;
    }

    public double getStartDist() {
        return startDist;
    }

    public double getConvertedDist() {
        return convertedDist;
    }
    public String getMenu(){
        return mainMenu;
    }
    public String getMenuAfterChoice(int choice) {//must be called only after int choice is validated to include only a non-exit value to match a bracketed int menu option.
        String menu2 = mainMenu.replaceFirst("^.*\\n.*\\n", ""); //regex to start from the top and replace all characters with nothing (aka deleting) up until the new line sequence (end of the line) then repeat to remove the first two lines of the menu.
        return menu2.replaceAll("\\["+choice+"\\].*\\n", ""); //(regex to replace part of the string starting with the 'int choice' number between brackets up to and including the new line escape sequence).

    }

    public double convertStored() {
        double converted;
        double[][] conversionMatrix = { //rows are starting conversion values and the columns are the factor to multiply by to get the converted number choice, indexes correspond to the menu options
                {0, 0, 0, 0, 0, 0, 0, 0, 0}, //this index shouldn't be references as zero shouldn't be a menu option
                {0, 1, 1000, 100000, 0.000001, 0.6215, 1094, 3281,39370}, //kilometers
                {0, 0.001, 1, 100, 1000, 0.000621371, 1.09361, 3.28084,39.3701}, //meters
                {0, 0.00001, 0.01, 1, 10, 0.00000621371, 0.0109361, 0.0328084,0.393701}, //centimeters
                {0, 0.000001, 0.001, 0.01, 1, 0.000000621371, 0.00109361, 0.00328084,0.0393701}, //millimeters
                {0,1.60934, 1609.34, 160934, 0.000001609, 1, 1760, 5280, 63360}, //miles
                {0,0.0009144, 0.9144, 91.44, 914.4, 0.000568182, 1, 3, 36}, //yards
                {0,0.0003048, 0.3048, 30.48, 304.8, 0.000189394, 0.333333, 1, 12}, //feet
                {0,0.0000254, 0.0254, 2.54, 25.4, 0.000015783, 0.0277778, 0.0833333, 1} //inches
        };
        if (getStartMeasurementInt() < 1 || getStartMeasurementInt() > 8 || getTargetMeasurementInt() < 1 || getTargetMeasurementInt() > 8) {
            throw new IllegalArgumentException("Invalid starting and/or target choice int in method convertStored"); // these error catches can be made more to be more specific but for now it just catches invalid indices in both starting and target at once
        }
        converted = startDist * conversionMatrix[getStartMeasurementInt()][getTargetMeasurementInt()];
        this.convertedDist = converted;
        return converted;
    }
    public  double convert(int startingMeasurement, int targetMeasurement, double startDist) {
        double converted;
        double[][] conversionMatrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0}, //this index shouldn't be references as zero shouldn't be a menu option
                {0, 1, 1000, 100000, 0.000001, 0.6215, 1094, 3281,39370}, //kilometers
                {0, 0.001, 1, 100, 1000, 0.000621371, 1.09361, 3.28084,39.3701}, //meters
                {0, 0.00001, 0.01, 1, 10, 0.00000621371, 0.0109361, 0.0328084,0.393701}, //centimeters
                {0, 0.000001, 0.001, 0.01, 1, 0.000000621371, 0.00109361, 0.00328084,0.0393701}, //millimeters
                {0,1.60934, 1609.34, 160934, 0.000001609, 1, 1760, 5280, 63360}, //miles
                {0,0.0009144, 0.9144, 91.44, 914.4, 0.000568182, 1, 3, 36}, //yards
                {0,0.0003048, 0.3048, 30.48, 304.8, 0.000189394, 0.333333, 1, 12}, //feet
                {0,0.0000254, 0.0254, 2.54, 25.4, 0.000015783, 0.0277778, 0.0833333, 1} //inches
        };

        if (startingMeasurement < 1 || startingMeasurement > 8 || targetMeasurement < 1 || targetMeasurement > 8) {
            throw new IllegalArgumentException("Invalid starting and/or target choice int in method convert");
        }

        converted = startDist * conversionMatrix[getStartMeasurementInt()][getTargetMeasurementInt()];
        this.convertedDist = converted;
        return converted;

    }

}
