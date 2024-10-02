import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static List<Number> NUMBERS;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken()),
                SCORE = Integer.parseInt(tokenizer.nextToken()),
                P = Integer.parseInt(tokenizer.nextToken());
        Number taesooNumber = new Number(SCORE, 0);

        if (N == 0) {
            NUMBERS = new ArrayList<>();
        } else {
            NUMBERS = Arrays.stream(reader.readLine().split(" ")).map(x -> new Number(Integer.parseInt(x), 1)).collect(Collectors.toList());
        }
        NUMBERS.add(taesooNumber);

        NUMBERS.sort(new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                if (o1.value == o2.value) {
                    return -(o1.weight - o2.weight);
                }
                return -(o1.value - o2.value);
            }
        });
        int i = NUMBERS.indexOf(taesooNumber);
        long biggerCount = NUMBERS.stream().filter(n -> n.value > taesooNumber.value).count();
        if ((i+1) > P) {
            System.out.println(-1);
        } else {
            System.out.println(biggerCount + 1);
        }
    }
    static class Number {
        final int value;
        final int weight;

        public Number(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Number number = (Number) o;
            return value == number.value && weight == number.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, weight);
        }
    }

}