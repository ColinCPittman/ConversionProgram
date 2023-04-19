
public class Test_Conversion_Program {
    public static void main(String[] args) {
        CurrencyConversion c = new CurrencyConversion();
        c.convert(1,25);
        System.out.println(c.getStartingCurrency() + c.getTargetCurrency() + " " +c.getConvertedAmount());
        WeightConversion w = new WeightConversion(1,45);
        System.out.println(w.getStartingScale() + " " + w.getTargetScale());
    }
}
