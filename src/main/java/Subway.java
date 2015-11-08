import java.io.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: artem
 * Date: 27.08.11
 * Time: 0:13
 * To change this template use File | Settings | File Templates.
 */
public class Subway {

    private List<Integer> passengerAmounts;

    public static void main(String[] args) {
        new Subway().run();
    }

    private void run() {
        readDataFromConsole();
        writeDataToConsole(checkNumberList().toString());
    }

    private Integer checkNumberList() {
        int maxAmount = 0;
        int amount = 0;
        for (Integer pass : passengerAmounts) {
            amount += pass;
            if (amount > maxAmount) {
                maxAmount = amount;
            }
        }
        return maxAmount;
    }


    private void readDataFromConsole() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int amountNumbers = Integer.parseInt(in.readLine());
            passengerAmounts = new LinkedList<Integer>();
            String pairs = null;
            for (int i = 0; i < amountNumbers; i++) {
                String[] passengers = in.readLine().split(" ");
                int outPass = Integer.parseInt(passengers[0]);
                int inPass = Integer.parseInt(passengers[1]);
                passengerAmounts.add(inPass - outPass);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
