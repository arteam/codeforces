import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MostPresidentInYear {

    public List<Integer> run(String presidents) {
        String[] rows = presidents.split("\n");
        int currentYear = LocalDate.now().getYear();
        int[] yearAmountOfPresidents = new int[currentYear + 1];
        for (int i = 1; i < rows.length; i++) {
            String row = rows[i];
            String[] parts = row.split(",");
            String birthDate = parts[1].trim();
            String deathDate = parts[3].trim();
            int birthYear = Integer.parseInt(birthDate.split(" ")[2]);
            int deathYear = deathDate.equals("") ? currentYear : Integer.parseInt(deathDate.split(" ")[2]);
            for (int j = birthYear; j <= deathYear; j++) {
                yearAmountOfPresidents[j]++;
            }
        }
        List<Integer> mostFrequentYears = new ArrayList<>();
        int maxAmountOfPresident = 0;
        for (int i = 1732; i < yearAmountOfPresidents.length; i++) {
            if (yearAmountOfPresidents[i] > maxAmountOfPresident) {
                maxAmountOfPresident = yearAmountOfPresidents[i];
                mostFrequentYears = new ArrayList<>();
                mostFrequentYears.add(i);
            } else if (yearAmountOfPresidents[i] == maxAmountOfPresident) {
                mostFrequentYears.add(i);
            }
        }
        return mostFrequentYears ;
    }
}
