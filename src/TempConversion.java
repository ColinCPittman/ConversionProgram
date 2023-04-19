public class TempConversion {
    public TempConversion() {
        this.initialTemp = 0.0;
        this.targetScaleInt = 0;
        this.initialScaleInt = 0;
        this.targetScale = null;
        this.startingScale = null;
        this.convertedTemp = 0.0;
    }
    public TempConversion(int initialScaleInt, int targetScaleInt, double initialTemp) {
        setInitialScale(initialScaleInt);
        setTargetScale(targetScaleInt);
        this.initialTemp = initialTemp;
    }
    public String getStartingScale() {
        return startingScale;
    }

    public String getTargetScale() {
        return targetScale;
    }

    private String startingScale,targetScale;
    public int getInitialScaleInt() {
        return initialScaleInt;
    }

    public void setInitialScale(int initialScaleInt) {

        switch(initialScaleInt) {
            case 1:
                startingScale = "Celsius";
                this.initialScaleInt = initialScaleInt;
                break;
            case 2:
                startingScale = "Fahrenheit";
                this.initialScaleInt = initialScaleInt;
                break;
            default:
                startingScale = "Kelvin";
                this.initialScaleInt = initialScaleInt;
                break;
        }
    }

    public int getTargetScaleInt() {
        return targetScaleInt;
    }

    public void setTargetScale(int targetScaleInt) {

        switch(targetScaleInt) {
            case 1:
                targetScale = "Celsius";
                this.targetScaleInt = targetScaleInt;
                break;
            case 2:
                targetScale = "Fahrenheit";
                this.targetScaleInt = targetScaleInt;
                break;
            default:
                targetScale = "Kelvin";
                this.targetScaleInt = targetScaleInt;
                break;
        }
    }

    public double getInitialTemp() {
        return initialTemp;
    }

    public void setInitialTemp(double initialTemp) {
        this.initialTemp = initialTemp;
    }

    public double getConvertedTemp() {
        return convertedTemp;
    }

    public void setConvertedTemp(double convertedTemp) {
        this.convertedTemp = convertedTemp;
    }
    private String mainMenu = """
                
                [Temperature Conversion Program]
                           
                [1]Celsius
                [2]Fahrenheit
                [3]Kelvin
                [9]Exit
                """;
    private int initialScaleInt, targetScaleInt;
    private double initialTemp, convertedTemp;

    public String getMainMenu() {
        return mainMenu;
    }
    public String getMenuAfterChoice(int choice) {//must be called only after int choice is validated to include only a non-exit value to match a bracketed int menu option.
        String menu2 = mainMenu.replaceFirst("^.*\\n.*\\n", ""); //regex to start from the top and replace all characters with nothing (aka deleting) up until the new line sequence (end of the line) then repeat to remove the first two lines of the menu.
        return menu2.replaceAll("\\["+choice+"\\].*\\n", ""); //(regex to replace part of the string starting with the 'int choice' number between brackets up to and including the new line escape sequence).

    }

    public double convertTemperature(int startScale, int targetScale, double startTemperature) { //to be called with validated start and target values 1, 2, and 3.
        double convertedTemperature;
        if (startScale == 1) {//celsius starting temp
            if (targetScale == 2) {
                convertedTemperature = startTemperature * 9.0 / 5.0 + 32; //to fahrenheit
            } else {
                convertedTemperature = startTemperature + 273.15; //to kelvin
            }
        } else if (startScale == 2) { //fahrenheit starting temp
            if (targetScale == 1) {
                convertedTemperature = (startTemperature - 32) * (5 / 9.0); //to celsius
            } else {
                convertedTemperature = (startTemperature - 32) * (5 / 9.0) + 273.15; //to kelvin
            }
        } else {//kelvin starting temp
            if (targetScale == 1) {
                convertedTemperature = startTemperature - 273.15; //to celsius
            } else {
                convertedTemperature = (startTemperature - 273.15) / (5 / 9.0) + 32; //to fahrenheit
            }
        }
        this.convertedTemp = convertedTemperature;
        return convertedTemperature;
    }

}
