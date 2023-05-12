import java.time.LocalDate;

public class RunEntry {
    private LocalDate date;
    private double miles;

    public RunEntry(LocalDate date, double miles) {
        this.date = date;
        this.miles = miles;
    }

    // getters for miles and date on specific run
    public LocalDate getDate() {
        return date;
    }

    public double getMiles() {
        return miles;
    }
}