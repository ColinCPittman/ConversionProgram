import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean stayInMenu = true;
        int menuChoice;
        do {
            System.out.println(getMainMenu());
            menuChoice = getMenuChoice(1, 3, 9, "Choose a conversion type [9 to exit]: ");
            switch (menuChoice) {
                case 1:
                    handleCaseTempConversion();
                    break;
                case 2:
                    handleCaseCurrConversion();
                    break;
                case 3:
                    handleCaseWeightConversion();
                    break;
                case 9:
                    stayInMenu = false;
                    break;
            }
        } while (stayInMenu);
        System.out.println("Shutting down...");
    }

    public static void handleCaseWeightConversion() {
        do{
            WeightConversion wc1 = new WeightConversion();
            System.out.println(wc1.getMenu());
            int choice = getMenuChoice(1,2,9, "Choose an option [9 to exit]: ");
            if (choice == 9) {break;}
            double initialValue = getDoubleAny("Please enter amount: ");
            if (choice == 1) {
                System.out.printf("%.2f kilograms is equal to %.2f pounds.",initialValue,wc1.convert(choice,initialValue));
            }
            else {
                System.out.printf("%.2f pounds is equal to %.2f kilograms.",initialValue,wc1.convert(choice,initialValue));
            }
        }while(userStays());
    }

    public static void handleCaseCurrConversion() {
        do {
            CurrencyConversion cc1 = new CurrencyConversion();
            System.out.println(cc1.getMenu());
            int choice = getMenuChoice(1,2,9, "Choose an option [9 to exit]: ");
            if (choice == 9) {break;}
            double initialValue = getDoubleAny("Please enter amount: ");
            if (choice == 1) {
                System.out.printf("%.4f EUR is equal to %.4f USD at the exchange rate of %.4f",initialValue,cc1.convert(choice,initialValue),cc1.getEXCHANGE_RATE_EUR2USD());
            }
            else {
                System.out.printf("%.4f USD is equal to %.4f EUR at the exchange rate of %.4f",initialValue,cc1.convert(choice,initialValue),cc1.getEXCHANGE_RATE_USD2EUR());
            }
        }while (userStays());
    }

    public static void handleCaseTempConversion() {
        do {
            TempConversion tc1 = new TempConversion();
            System.out.print(tc1.getMainMenu());
            tc1.setInitialScale(getMenuChoice(1, 3, 9, "Starting temperature scale [9 to exit]: "));
            if (tc1.getInitialScaleInt() == 9) {
                break;
            } else {
                System.out.print(tc1.getMenuAfterChoice(tc1.getInitialScaleInt()));
                tc1.setTargetScale(getMenuChoice(1, 3, 9, "Converting from " + tc1.getStartingScale() + " into: ", tc1.getInitialScaleInt()));
                if (tc1.getTargetScaleInt() == 9) {
                    break;
                }
                tc1.setInitialTemp(getDoubleAny("Enter starting temperature: "));
                System.out.printf("%.2f degrees " + tc1.getStartingScale() + " is equal to %.2f degrees " + tc1.getTargetScale() + ".", tc1.getInitialTemp(), tc1.convertTemperature(tc1.getInitialScaleInt(), tc1.getTargetScaleInt(), tc1.getInitialTemp()));
            }
        } while (userStays());
    }

    public static boolean userStays() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nWould you like to do another conversion? [Y/N]:");
        String choice = sc.nextLine().trim();
        if (choice.equalsIgnoreCase("y")) {
            return true;
        } else if (choice.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Invalid input, try again.");
            userStays();
            return false;
        }
    }

    public static String getMainMenu() {
        return """
                                
                [Conversion Program]
                                
                [1]Temperature Conversion
                [2]Currency Conversion
                [3]Weight Conversion
                [9]Exit
                """;
    }

    public static double getDoubleAny(String choicePrompt) {
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(choicePrompt);
            String input = scanner.nextLine();

            try {
                value = Double.parseDouble(input);
                break;
            } catch (Exception err) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return value;
    }

    public static double getNonNegativeDouble(String choicePrompt) {
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(choicePrompt);
            String input = scanner.nextLine();

            try {
                value = Double.parseDouble(input);
                if (value <= 0) {
                    System.out.println("Please enter a positive non-zero value.");
                    continue;
                }
                break;
            } catch (Exception err) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return value;
    }

    public static int getMenuChoice(int lowValue, int highValue, int exitValue, String choicePrompt) { //method getting an int between starting and ending value (both inclusive)
        Scanner sc = new Scanner(System.in);
        boolean gotError = false;
        int y = exitValue;
        do {
            System.out.print(choicePrompt);
            gotError = false;
            try {
                y = sc.nextInt();
                sc.nextLine();
                if (!(lowValue <= y && y <= highValue) && y != exitValue) {
                    gotError = true;
                }
            } catch (Exception err) {
                gotError = true;
                sc.nextLine();
            }
            if (gotError) {
                System.out.println("Invalid input, please enter choice [" + exitValue + " to exit].");
            }
        } while (gotError);
        return y;
    }

    public static int getMenuChoice(int lowValue, int highValue, int exitValue, String choicePrompt, int firstChoice) { //method getting an int between starting and ending value (both inclusive)
        Scanner sc = new Scanner(System.in);
        boolean gotError = false;
        int y = exitValue;
        do {
            System.out.print(choicePrompt);
            gotError = false;
            try {
                y = sc.nextInt();
                sc.nextLine();
                if ((!(lowValue <= y && y <= highValue) && y != exitValue) || y == firstChoice) {
                    gotError = true;
                }
            } catch (Exception err) {
                gotError = true;
                sc.nextLine();
            }
            if (gotError) {
                System.out.println("Invalid input, please enter choice [" + exitValue + " to exit].");
            }
        } while (gotError);
        return y;
    }
}