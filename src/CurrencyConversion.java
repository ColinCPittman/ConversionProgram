public class CurrencyConversion {
    private double convertedAmount;
    private String startingCurrency, targetCurrency;
    private int choice;
    private double startAmount;
    private static final double EXCHANGE_RATE_EUR2USD = 1.0978, EXCHANGE_RATE_USD2EUR = 0.9100;

    public String getStartingCurrency() {
        return startingCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public CurrencyConversion () {
        choice = 0;
        startAmount = 0.0;
        convertedAmount = 0.0;

    }
    public CurrencyConversion(int choice, double startAmount) {
        this.choice = choice;
        this.startAmount = startAmount;
        this.convertedAmount = convertStored();
    }
    public double getEXCHANGE_RATE_EUR2USD() {
        return EXCHANGE_RATE_EUR2USD;
    }
    public double getEXCHANGE_RATE_USD2EUR() {
        return EXCHANGE_RATE_USD2EUR;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
        switch(choice) {
            case 1:
                this.startingCurrency = "EUR";
                this.targetCurrency = "USD";
                break;
            case 2:
                this.startingCurrency = "USD";
                this.targetCurrency = "EUR";
                break;
        }
    }
    public void setStartingChoice(String choice) {
        switch(choice.toLowerCase()) {
            case "euro":
            case "euros":
            case "EUR":
                this.startingCurrency = "EUR";
                this.targetCurrency = "USD";
                this.choice = 1;
                break;
            case "dollar":
            case "dollars":
            case "usd":
                this.choice = 2;
                this.startingCurrency = "USD";
                this.targetCurrency = "EUR";
                break;
        }
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public String getMenu(){
        return """
                
                [Currency conversion]
                
                [1]Convert from EUR to USD.
                [2]Convert from USD to EUR.
                [9]Exit.
                """;
    }
    public double convert(int choice, double money) {//to be called with validated choice 1 or 2
        double result;
        setChoice(choice);
        if(choice == 1) { //chose to convert from EUR to USD
            result = money * getEXCHANGE_RATE_EUR2USD();
        }
        else { //USD to EUR
            result = money * getEXCHANGE_RATE_USD2EUR();
        }
        this.convertedAmount =result;
        return result;
    }
    public double convertStored() {
        double result;
        if(getChoice() == 1) { //chose to convert from EUR to USD
            result = getStartAmount() * getEXCHANGE_RATE_EUR2USD();
        }
        else { //USD to EUR
            result = getStartAmount() * getEXCHANGE_RATE_USD2EUR();
        }
        this.convertedAmount =result;
        return result;
    }


}
