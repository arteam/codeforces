package advent2018;

import java.io.BufferedReader;
import java.util.List;
import java.util.stream.Collectors;

public class Task2_2 {

    public String getCommonLetters(BufferedReader reader) {
        List<String> lines = reader.lines().collect(Collectors.toList());
        for (int i = 0; i < lines.size(); i++) {
            String firstLine = lines.get(i);
            for (int j = i + 1; j < lines.size(); j++) {
                String secondLine = lines.get(j);
                int distance = 0;
                StringBuilder commonLetters = new StringBuilder();
                for (int k = 0; k < firstLine.length(); k++) {
                    if (firstLine.charAt(k) != secondLine.charAt(k)) {
                        if (++distance > 1) {
                            break;
                        }
                    } else {
                        commonLetters.append(firstLine.charAt(k));
                    }
                }
                if (distance == 1) {
                    return commonLetters.toString();
                }
            }
        }
        return "";
    }
}
