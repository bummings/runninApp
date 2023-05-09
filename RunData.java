import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
// import java.time.temporal.ChronoUnit;
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
                LocalDate date = LocalDate.parse(parts[0], formatter);
                double miles = Double.parseDouble(parts[1]);
                entries.add(new RunEntry(date, miles));
            }
        } catch (IOException e) {
            System.out.println("There was an error reading miles.txt");
        }
    }

    // declaring pattern for date format for parsing purposes
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Utilizes the getAverage method to figure out weekly
    // average from the run entries.
    public double getWeeklyAverage() {
        LocalDate today = LocalDate.now();
        LocalDate oneWeekAgo = today.minusWeeks(1);
        return getAverage(oneWeekAgo, today);
    }

    // Utilizes the getAverage method to figure out weekly
    // average from the run entries.
    public double getMonthlyAverage() {
        LocalDate today = LocalDate.now();
        LocalDate oneMonthAgo = today.minusMonths(1);
        return getAverage(oneMonthAgo, today);
    }

    // getAverage method will run thru the entries list one
    // by one, adding them to totalMiles so long as they fit
    // in the box of the beginning and end of the week/month.
    private double getAverage(LocalDate start, LocalDate end) {
        double totalMiles = 0;
        int count = 0;

        for (RunEntry entry : entries) {
            if (!entry.date.isBefore(start) && !entry.date.isAfter(end)) {
                totalMiles += entry.miles;
                count++;
            }
        }

        return count > 0 ? totalMiles / count : 0;
    }

    // Class describing the shape of each run within the
    // entries list.
    private static class RunEntry {
        LocalDate date;
        double miles;

        RunEntry(LocalDate date, double miles) {
            this.date = date;
            this.miles = miles;
        }
    }
}
