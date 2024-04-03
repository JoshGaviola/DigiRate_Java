import java.util.HashMap;
import java.util.Scanner;

public class main {

    private static final HashMap<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {
        // Populate exchange rates (optional)
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.90);
        exchangeRates.put("JPY", 114.00);

        Scanner scanner = new Scanner(System.in);
        double amount;
        String fromCurrency, toCurrency;

        do {
            System.out.print("Enter amount to convert: ");
            amount = scanner.nextDouble();

            System.out.print("Enter currency to convert from (e.g., USD, EUR): ");
            fromCurrency = scanner.next();

            System.out.print("Enter currency to convert to (e.g., USD, EUR): ");
            toCurrency = scanner.next();

            if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
                System.out.println("Invalid currency code. Please try again.");
            } else {
                double convertedAmount = amount * exchangeRates.get(fromCurrency);
                System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
            }

            System.out.print("Do another conversion? (y/n): ");
        } while (scanner.next().equalsIgnoreCase("y"));

        scanner.close();
    }
}
