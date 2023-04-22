import java.time.LocalDate;

public class MenstrualCycle {

    @Override
    public String toString() {
        return String.format("""
                        Date: %s/%s/%s
                        DaysOfFlow: %d
                        DaysBeforeFlow: %d""",
                nextMonthFlow.getDayOfWeek(), nextMonthFlow.getMonth(), nextMonthFlow.getYear(),
                daysOfFlow, numberOfDaysBeforeFlow);
    }

    private int daysOfFlow;
    private int numberOfDaysBeforeFlow;
    private LocalDate nextMonthFlow;


    public void setNumberOfDaysBeforeFlow(int numberOfDaysBeforeFlow) {
        this.numberOfDaysBeforeFlow = numberOfDaysBeforeFlow;
    }


    public void setDaysOfFlow(int daysOfFlow) {
        this.daysOfFlow = daysOfFlow;
    }


    public void nextMonthFlow(LocalDate localDate) {
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        if (month == 12) {
            year++;
            month = 1;
        } else {
            month++;
        }
        nextMonthFlow = LocalDate.of(year, month, day);
    }

}