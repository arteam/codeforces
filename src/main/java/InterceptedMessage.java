import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InterceptedMessage {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numberOfBlocks = reader.readLine();
        String firstMessage = reader.readLine();
        String secondMessage = reader.readLine();
        System.out.println(new InterceptedMessage().run(firstMessage, secondMessage));
    }

    public String run(String firstMessageStr, String secondMessageStr) {
        String[] firstMessage = firstMessageStr.split(" ");
        String[] secondMessage = secondMessageStr.split(" ");

        int firstCounter = 0;
        int secondCounter = 0;
        int foundMessages = 0;
        int firstSum = Integer.parseInt(firstMessage[firstCounter++]);
        int secondSum = Integer.parseInt(secondMessage[secondCounter++]);
        while (true) {
            if (firstSum == secondSum) {
                foundMessages++;
                if (firstCounter == firstMessage.length || secondCounter == secondMessage.length) {
                    break;
                }
                firstSum = Integer.parseInt(firstMessage[firstCounter++]);
                secondSum = Integer.parseInt(secondMessage[secondCounter++]);
            } else if (firstSum < secondSum) {
                if (firstCounter == firstMessage.length) {
                    break;
                }
                firstSum += Integer.parseInt(firstMessage[firstCounter++]);
            } else {
                if (secondCounter == secondMessage.length) {
                    break;
                }
                secondSum += Integer.parseInt(secondMessage[secondCounter++]);
            }
        }
        return String.valueOf(String.valueOf(foundMessages));
    }
}
