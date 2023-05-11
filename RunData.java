import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class RunData {
    private List<RunEntry> entries;

    public RunData() {
        // a list of entries, each entry as it's own list with a date, time, and shoes,
        // all separated with a comma

        // for reference: entries is an ArrayList of said runs with the three elements
        // described abvove
        entries = new ArrayList<>();

        // using BufferedReader to read from miles.txt
        try (BufferedReader br = new BufferedReader(new FileReader("miles.txt"))) {

            String line;
            // ensure that lines exist in file
            while ((line = br.readLine()) != null) {
                // separate each distinct value within the entry
                String[] parts = line.split(",");
                if (parts.length > 2) {
                    LocalDate date = LocalDate.parse(parts[0], formatter);
                    double miles = Double.parseDouble(parts[1]);
                    String shoes = parts[2];
                    entries.add(new RunEntry(date, miles, shoes));
                    // important to note that there cannot be a comma in the shoe name or the date,
                    // as that is the seperator for our values.
                }
            }
        } catch (IOException e) {
            System.out.println("There was an error reading miles.txt");
        }
    }

    // defining pattern for date format for parsing
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Utilizes the getAverage method to figure out weekly average of current and
    // past run entries..
    public double getWeeklyAverage() {
        LocalDate today = LocalDate.now();
        LocalDate oneWeekAgo = today.minusWeeks(1);
        return getAverage(oneWeekAgo, today);
    }

    // Utilizes the getAverage method to figure out monthly average of current and
    // past run entries.
    public double getMonthlyAverage() {
        LocalDate today = LocalDate.now();
        LocalDate oneMonthAgo = today.minusMonths(1);
        return getAverage(oneMonthAgo, today);
    }

    private double getAverage(LocalDate start, LocalDate end) {
        double totalMiles = 0;
        int count = 0;

        // loop to determine if entries are within bounds for a weekly or monthly
        // average:
        for (RunEntry entry : entries) {
            if (!entry.date.isBefore(start) && !entry.date.isAfter(end)) {
                totalMiles += entry.miles;
                count++;
            }
        }

        return count > 0 ? totalMiles / count : 0;
    }

    // Class describing the shape of each run entry within the entries list.
    private static class RunEntry {
        LocalDate date;
        double miles;
        String shoes;

        RunEntry(LocalDate date, double miles, String shoes) {
            this.date = date;
            this.miles = miles;
            this.shoes = shoes;
        }
    }

    // This is a map over all the shoes in shoes.txt file- using the getOrDefault
    // method we can set a pair of shoes to 0.0 miles if it is not associated with
    // any runs
    public Map<String, Double> getMilesByShoes() {
        Map<String, Double> milesByShoes = new HashMap<>();
        for (RunEntry run : entries) {
            milesByShoes.put(run.shoes, milesByShoes.getOrDefault(run.shoes, 0.0) + run.miles);
        }
        return milesByShoes;
    }
}
