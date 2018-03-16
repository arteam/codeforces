import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class ChatRoom {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        Queue<Character> checkedSymbols = new ArrayDeque<>();
        checkedSymbols.add('h');
        checkedSymbols.add('e');
        checkedSymbols.add('l');
        checkedSymbols.add('l');
        checkedSymbols.add('o');
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == checkedSymbols.peek()) {
                checkedSymbols.remove();
                if (checkedSymbols.isEmpty()) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}
