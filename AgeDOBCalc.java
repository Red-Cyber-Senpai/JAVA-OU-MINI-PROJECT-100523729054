import java.util.Scanner;

public class AgeDOBCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 'DOB' if you have Date of Birth, or 'AGE' if you have Age: ");
        String option = scanner.nextLine().toUpperCase();

        String delimiter = "-";
        String dateInput;
        String refDate;
        
        if (option.equals("DOB")) {
            System.out.print("Enter your Date of Birth (e.g., 28-02-2001): ");
            dateInput = scanner.nextLine();
            System.out.print("Enter reference date (e.g., 27-02-2024) or type 'today' for today’s date: ");
            refDate = scanner.nextLine();

            calculateAgeFromDOB(dateInput, refDate, delimiter);

        } else if (option.equals("AGE")) {
            System.out.print("Enter your Age (e.g., 19-10-27 for 19 years, 10 months, 27 days): ");
            dateInput = scanner.nextLine();
            System.out.print("Enter reference date (e.g., 27-02-2024) or type 'today' for today’s date: ");
            refDate = scanner.nextLine();

            calculateDOBFromAge(dateInput, refDate, delimiter);

        } else {
            System.out.println("Invalid option. Please enter 'DOB' or 'AGE'.");
        }

        scanner.close();
    }

    private static void calculateAgeFromDOB(String dobStr, String refDateStr, String delimiter) {
        String[] dobParts = dobStr.split(delimiter);
        String[] refParts = refDateStr.equalsIgnoreCase("today") ? getTodayDate().split(delimiter) : refDateStr.split(delimiter);

        int dobDay = Integer.parseInt(dobParts[0]);
        int dobMonth = Integer.parseInt(dobParts[1]);
        int dobYear = Integer.parseInt(dobParts[2]);

        int refDay = Integer.parseInt(refParts[0]);
        int refMonth = Integer.parseInt(refParts[1]);
        int refYear = Integer.parseInt(refParts[2]);

        int years = refYear - dobYear;
        int months = refMonth - dobMonth;
        int days = refDay - dobDay;

        if (days < 0) {
            days += 30;
            months -= 1;
        }
        if (months < 0) {
            months += 12;
            years -= 1;
        }

        System.out.printf("Age: %d years, %d months, %d days%n", years, months, days);
    }

    private static void calculateDOBFromAge(String ageStr, String refDateStr, String delimiter) {
        String[] ageParts = ageStr.split(delimiter);
        String[] refParts = refDateStr.equalsIgnoreCase("today") ? getTodayDate().split(delimiter) : refDateStr.split(delimiter);

        int ageYears = Integer.parseInt(ageParts[0]);
        int ageMonths = Integer.parseInt(ageParts[1]);
        int ageDays = Integer.parseInt(ageParts[2]);

        int refDay = Integer.parseInt(refParts[0]);
        int refMonth = Integer.parseInt(refParts[1]);
        int refYear = Integer.parseInt(refParts[2]);

        int dobYear = refYear - ageYears;
        int dobMonth = refMonth - ageMonths;
        int dobDay = refDay - ageDays;

        if (dobDay <= 0) {
            dobDay += 30;
            dobMonth -= 1;
        }
        if (dobMonth <= 0) {
            dobMonth += 12;
            dobYear -= 1;
        }

        System.out.printf("Date of Birth: %02d%s%02d%s%04d%n", dobDay, delimiter, dobMonth, delimiter, dobYear);
    }

    private static String getTodayDate() {
        return "07-11-2024"; // Replace with actual current date if needed
    }
}
