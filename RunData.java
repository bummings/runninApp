import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class RunData {
    private List<RunEntry> entries;

    public RunData() {
        // list of entries, each entry as a list
        // with both date and time, separated.
        entries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("miles.txt"))) {
            String line;
            // ensure that lines exist in file
            while ((line = br.readLine()) != null) {
                // separate date from miles
                String[] parts = line.split(",");
                LocalDate date = LocalDate.parse(parts[0]);
                double miles = Double.parseDouble(parts[1]);
                entries.add(new RunEntry(date, miles));
            }
        } catch (IOException e) {
            System.out.println("There was an error reading miles.txt");
        }
    }

    public double getWeeklyAverage() {
        LocalDate today = LocalDate.now();
        LocalDate oneWeekAgo = today.minusWeeks(1);
        return getAverage(oneWeekAgo, today);
    }

    private static class RunEntry {
        LocalDate date;
        double miles;

        RunEntry(LocalDate date, double miles) {
            this.date = date;
            this.miles = miles;
        }
    }
}
