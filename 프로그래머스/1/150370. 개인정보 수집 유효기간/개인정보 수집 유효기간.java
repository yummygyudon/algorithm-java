import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.IntStream;

class Solution {
    static Map<String, Integer> TERMS;
    public int[] solution(String today, String[] terms, String[] privacies) {
        TERMS = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            TERMS.put(split[0], Integer.parseInt(split[1]));
        }

        IntStream.Builder intBuilder = IntStream.builder();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        
        LocalDate todayDate = LocalDate.parse(today, dateTimeFormatter);
        for (int i = 1; i <= privacies.length; i++) {
            String privacy = privacies[i - 1];
            String[] split = privacy.split(" ");
            
            int availableMonth = TERMS.get(split[1]);
            LocalDate activateDate = LocalDate.parse(split[0], dateTimeFormatter);
            LocalDate limitDate = activateDate.plusMonths(availableMonth);
            if (todayDate.isAfter(limitDate) || todayDate.isEqual(limitDate) ) {
                intBuilder.add(i);
            }
        }

        return intBuilder.build().toArray();
    }
}