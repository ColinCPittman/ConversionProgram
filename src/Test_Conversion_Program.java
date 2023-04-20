
public class Test_Conversion_Program {
    public static void main(String[] args) {
        CurrencyConversion c = new CurrencyConversion();
        c.convert(1,25);
        System.out.println(c.getStartingCurrency() + c.getTargetCurrency() + " " +c.getConvertedAmount());
        WeightConversion w = new WeightConversion(1,45);
        System.out.println(w.getStartingScale() + " " + w.getTargetScale());
        System.out.println(w);
        TempConversion tc1 = new TempConversion();
        tc1.setInitialScale(1);
        System.out.println(tc1);
        TempConversion tc2 = new TempConversion();
        tc2.setInitialScale("FAHRENHEIT");
        System.out.println(tc2);
        tc2.setTargetScale("sour");
        System.out.println(tc2);
        tc2.setTargetScale("celsius");
        tc2.setInitialTemp(69.42);
        System.out.println(tc2);
        tc2.convertStored();
        System.out.println(tc2);

    }
}
