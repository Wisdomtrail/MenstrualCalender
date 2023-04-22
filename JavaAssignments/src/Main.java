import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MenstrualCycle cycle = new MenstrualCycle();
        System.out.println("""
                Enter the date of the first day of your last menstrual flow:
                "day/month/year"\040""");
        String date = scanner.next();

        System.out.println("Enter the number of days you had the flow:");
        int flowDays = scanner.nextInt();
        System.out.println("Enter the number of days before the flow started:");
        int cycleLength = scanner.nextInt();
        try {
           String[] split = date.split("/");
            while (Integer.parseInt(split[0]) > 31 && flowDays > 7 && cycleLength > 30){
                System.out.println("""
                Enter the date of the first day of your last menstrual flow:
                "day/month/year"\040""");
                date = scanner.next();
                System.out.println("Enter the number of days you had the flow:");
                flowDays = scanner.nextInt();
                System.out.println("Enter the number of days before the flow started:");
                cycleLength = scanner.nextInt();
            }

            split = date.split("/");


            LocalDate localDate = LocalDate.of(Integer.parseInt(split[2]), Integer.parseInt(split[1]), Integer.parseInt(split[0]));
            cycle.nextMonthFlow(localDate);
            cycle.setDaysOfFlow(flowDays);
            cycle.setNumberOfDaysBeforeFlow(cycleLength);
            System.out.println(cycle);
        }
        catch (DateTimeException e){
            System.out.println("invalid date");
        }
    }
}