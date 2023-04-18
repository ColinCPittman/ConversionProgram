public class CurrencyConversion {
    public double getEXCHANGE_RATE_EUR2USD() {
        return EXCHANGE_RATE_EUR2USD;
    }
    public double getEXCHANGE_RATE_USD2EUR() {
        return EXCHANGE_RATE_USD2EUR;
    }

    private final double EXCHANGE_RATE_EUR2USD = 1.0978, EXCHANGE_RATE_USD2EUR = 0.9100;
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
        if(choice == 1) { //chose to convert from EUR to USD
            result = money * getEXCHANGE_RATE_EUR2USD();
        }
        else { //USD to EUR
            result = money * getEXCHANGE_RATE_USD2EUR();
        }
        return result;
    }


}
