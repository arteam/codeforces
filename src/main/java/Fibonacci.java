import java.io.*;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Fibonacci {

    private NavigableSet<Long> fibonacciNumbers = new TreeSet<Long>();

    public static void main(String[] args) {
        new Fibonacci().run();
    }

    private void run() {
        initFibonacciNumbers();
        String result = readDataFromConsole();
        writeDataToConsole(result);
    }

    private void initFibonacciNumbers() {
        Long firstNumber = 0L;
        Long secondNumber = 1L;
        while (true) {
            secondNumber += firstNumber;
            if (secondNumber < firstNumber) {
                break;
            }
            firstNumber = secondNumber - firstNumber;
            fibonacciNumbers.add(secondNumber);
        }
    }


    private int calculateAmountSplitting(Long number) {
        Long lowerFibonacciNumber = fibonacciNumbers.lower(number);
        if (lowerFibonacciNumber == null || lowerFibonacciNumber == 1L) {
            return 1;
        }
        long rest = number - lowerFibonacciNumber;
        int fibAmount = calculateFibonacciSplitting(lowerFibonacciNumber, rest);
        int restAmount = calculateAmountSplitting(rest);
        return fibAmount + restAmount;
    }

    private int calculateFibonacciSplitting(Long fibonacciNumber, Long flow) {
        Long prevFibNumber = fibonacciNumbers.lower(fibonacciNumber);
        if (prevFibNumber != null) {
            prevFibNumber = fibonacciNumbers.lower(prevFibNumber);
            if (prevFibNumber != null && prevFibNumber.compareTo(flow) == 1) {
                return calculateFibonacciSplitting(prevFibNumber, flow) + 1;
            }
        }
        return 1;
    }

    private String readDataFromConsole() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int amountNumbers = Integer.parseInt(in.readLine());
            StringBuilder amountSplitting = new StringBuilder();
            for (int i = 0; i < amountNumbers; i++) {
                Long number = Long.parseLong(in.readLine());
                int amount = calculateAmountSplitting(number);
                if (i != 0) {
                    amountSplitting.append("\n");
                }
                amountSplitting.append(String.valueOf(amount));
            }
            return amountSplitting.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeDataToConsole(String s) {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            out.write(s);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
