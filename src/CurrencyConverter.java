import java.util.Scanner;

public class CurrencyConverter {

    private final static double USD_TO_EUR = 0.85;
    private static final double USD_TO_GBP = 0.75;
    private static final double USD_TO_JPY = 110.0;
    private static final double USD_TO_BYN = 3.28;
    private static final double USD_TO_RUB = 97.25;
    private static final double USD_TO_USD = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите валюту (USD, EUR, GBP, RUB, BYN): ");
        String currency = scanner.nextLine();
        System.out.print("Введите сумму в "+ currency+": ");
        double amountInYourCurrency = scanner.nextDouble();
        Convert(currency, amountInYourCurrency);

        double amountInEUR = Convert(currency, amountInYourCurrency) * USD_TO_EUR;
        double amountInGBP = Convert(currency, amountInYourCurrency) * USD_TO_GBP;
        double amountInJPY = Convert(currency, amountInYourCurrency) * USD_TO_JPY;
        double amountInBYN = Convert(currency, amountInYourCurrency) * USD_TO_BYN;
        double amountInRUB = Convert(currency, amountInYourCurrency) * USD_TO_RUB;
        double amountInUSD = Convert(currency, amountInYourCurrency) * USD_TO_USD;

        System.out.printf("Сумма в EUR: %.2f\n", amountInEUR);
        System.out.printf("Сумма в GBP: %.2f\n", amountInGBP);
        System.out.printf("Сумма в JPY: %.2f\n", amountInJPY);
        System.out.printf("Сумма в BYN: %.2f\n", amountInBYN);
        System.out.printf("Сумма в RUB: %.2f\n", amountInRUB);
        System.out.printf("Сумма в USD: %.2f\n", amountInUSD);

        scanner.close();
    }

    private static double Convert(String currency, double amountInYourCurrency){
        double USD_TO_EUR = 0.85;
        double USD_TO_GBP = 0.75;
        double USD_TO_JPY = 110.0;
        double USD_TO_BYN = 3.28;
        double USD_TO_RUB = 97.25;
        double amountInUSD = 0;
        if (currency.equals("EUR")){
            amountInUSD=amountInYourCurrency*(1/USD_TO_EUR);
        } else if (currency.equals("GBP")) {
            amountInUSD=amountInYourCurrency*(1/USD_TO_GBP);
        }
        else if (currency.equals("JPY")) {
            amountInUSD=amountInYourCurrency*(1/USD_TO_JPY);
        }
        else if (currency.equals("BYN")) {
            amountInUSD=amountInYourCurrency*(1/USD_TO_BYN);
        }
        else if (currency.equals("RUB")) {
            amountInUSD=amountInYourCurrency*(1/USD_TO_RUB);
        }
        return amountInUSD;
    }
}